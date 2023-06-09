package com.hl.hardwareLibrary.configuration;//package com.wtkj.task.com.ahsh.home.configuration;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
//import org.springframework.context.com.ahsh.home.annotation.Configuration;
//import org.springframework.scheduling.com.ahsh.home.annotation.AsyncConfigurer;
//import org.springframework.scheduling.com.ahsh.home.annotation.EnableAsync;
//import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
//
//import java.lang.reflect.Method;
//import java.util.concurrent.Executor;
//
//
//@Slf4j
//@Configuration
//@EnableAsync
//public class TaskExecutorConfigurer implements AsyncConfigurer {
//
//
//    @Override
//    public Executor getAsyncExecutor() {
//        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
//        //如果池中的实际线程数小于corePoolSize,无论是否其中有空闲的线程，都会给新的任务产生新的线程
//        taskExecutor.setCorePoolSize(5);
//        //连接池中保留的最大连接数。Default: 15 maxPoolSize
//        taskExecutor.setMaxPoolSize(10);
//        //线程池所使用的缓冲队列
//        taskExecutor.setQueueCapacity(25);
//        //等待所有线程执行完
//        taskExecutor.setWaitForTasksToCompleteOnShutdown(true);
//        taskExecutor.initialize();
//        return taskExecutor;
//    }
//
//    @Override
//    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
//        return new WcpAsyncExceptionHandler();
//    }
//
//    /**
//     * 自定义异常处理类
//     *
//     */
//    class WcpAsyncExceptionHandler implements AsyncUncaughtExceptionHandler {
//        //手动处理捕获的异常
//        @Override
//        public void handleUncaughtException(Throwable throwable, Method method, Object... obj) {
//            log.error("-------------》》》捕获到线程异常信息");
//            log.info("Exception message - " + throwable.getMessage());
//            log.info("Method name - " + method.getName());
//            for (Object param : obj) {
//                log.info("Parameter value - " + param);
//            }
//        }
//    }
//
//}
