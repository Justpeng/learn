package com.just.learn.basic.callback;

/**
 * @description:
 * @author: Peng.Li
 * @create: 2018-06-11 16:58
 **/
public class Teacher implements CallBack {

    private Student student;

    public Teacher(Student student) {
        this.student = student;
    }

    public void askQuestion() {
        student.resolveQuestion(this);
    }

    @Override
    public void tellAnswer(int answer) {
        System.out.println("学生的答案是：" + answer);
    }
}
