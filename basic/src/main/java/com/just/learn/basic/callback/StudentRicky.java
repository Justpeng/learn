package com.just.learn.basic.callback;

/**
 * @description:
 * @author: Peng.Li
 * @create: 2018-06-11 17:06
 **/
public class StudentRicky implements Student {
    @Override
    public void resolveQuestion(CallBack callBack) {
        callBack.tellAnswer(1);
    }
}
