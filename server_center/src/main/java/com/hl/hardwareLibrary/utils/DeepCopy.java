package com.hl.hardwareLibrary.utils;

import java.io.*;
import java.util.List;

/**
 * @author Candy
 * @date 2021/1/28 17:08
 */
public class DeepCopy {
    /**
     * 深度复制list对象,先序列化对象，再反序列化对象
     *
     * @param src 需要复制的对象列表
     * @return 返回新的对象列表
     * @throws IOException 读取Object流信息失败
     * @throws ClassNotFoundException 泛型类不存在
     */
    public static <T> List<T> deepCopy(List<T> src)
            throws IOException, ClassNotFoundException
    {
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteOut);
        out.writeObject(src);
        ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
        ObjectInputStream in = new ObjectInputStream(byteIn);
        return (List<T>)in.readObject();
    }
}


