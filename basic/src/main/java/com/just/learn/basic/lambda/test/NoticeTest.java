package com.just.learn.basic.lambda.test;

import com.just.learn.basic.lambda.Param;
import com.just.learn.basic.lambda.ThreadPool;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @description:
 * @author: Peng.Li
 * @create: 2019-06-04 11:34
 **/
@Slf4j
public class NoticeTest {

    //执行初始化操作
    public void initLuggage(Param param) {
        try {
            //模拟执行，睡眠2s
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        log.info("异步初始化完成");
    }
    //通知方法1
    private boolean notice0(Param param) {
        log.info("收到调用方请求");
        initLuggage(param);
        log.info("通知成功，表示调用方已经收到反馈");
        return true;
    }


    //通知方法1
    private boolean notice(Param param) {
        log.info("收到调用方请求");
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                initLuggage(param);
            }
        };
        //异步
        ThreadPool.runTask(runnable);
        log.info("通知成功，表示调用方已经收到反馈");
        return true;
    }

    //通知方法2
    private boolean notice2(Param param) {
        log.info("收到调用方请求");
        Runnable runnable = () -> initLuggage(param);
        //异步
        ThreadPool.runTask(runnable);
        log.info("通知成功，表示调用方已经收到反馈");
        return true;
    }

    //通知方法3
    private boolean notice3(Param param) {
        log.info("收到调用方请求");
        ThreadPool.runTask(() -> initLuggage(param));
        log.info("通知成功，表示调用方已经收到反馈");
        return true;
    }

    @Test
    public void test() throws InterruptedException {
        Param param = new Param();
        notice0(param);
        //测试类防止线程init未执行而进程消失
        Thread.sleep(3000);
    }
}

