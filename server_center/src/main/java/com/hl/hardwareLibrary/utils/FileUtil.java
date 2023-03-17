package com.hl.hardwareLibrary.utils;

/**
 * @Classname FileUtil
 * @Description 文件操作工具类
 * @Author wanghd
 * @Date 2021/2/20
 */

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;


/**
 * 导出至csv文件
 * */
@Slf4j
public class FileUtil {

    private static ExecutorService service;

    private static BlockingQueue<Long> fileSizes = new ArrayBlockingQueue<>(
            500);

    private static AtomicLong pendingFileVisits = new AtomicLong();

    /**
     * 开启多线程计算指定文件或目录大小
     */
    public static void startExploreDir(File file) {
        pendingFileVisits.incrementAndGet();
        service.execute(() -> exploreDir(file));
    }

    /**
     * 递归计算指定文件或目录大小并存入阻塞队列中
     */
    public static void exploreDir(File file) {
        long fileSize = 0;
        if(file.isFile()){
            fileSize = file.length();
        }else {
            File[] children = file.listFiles();
            if(children != null && children.length != 0){
                for (File child : children) {
                    if(child.isFile()){
                        fileSize += child.length();
                    }else {
                        startExploreDir(child);
                    }
                }
            }

        }
        try {
            fileSizes.put(fileSize);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage(),"获取指定文件或文件夹大小出现异常!");
        }
        pendingFileVisits.decrementAndGet();
    }

    /**
     * 从阻塞队列中遍历相加所有文件大小
     */
    public static long getTotalSizeOfFile(String fileName) {
        service = Executors.newFixedThreadPool(100);
        long totalSize = 0;
        startExploreDir(new File(fileName));
        try {
            while (pendingFileVisits.get() > 0 || fileSizes.size() > 0) {
                final Long size;
                size = fileSizes.poll(10, TimeUnit.SECONDS);
                totalSize += size;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }finally {
            service.shutdown();
        }
        return totalSize;
    }

}
