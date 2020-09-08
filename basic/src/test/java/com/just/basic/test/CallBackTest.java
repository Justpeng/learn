package com.just.basic.test;

import com.just.learn.basic.callback.Student;
import com.just.learn.basic.callback.StudentRicky;
import com.just.learn.basic.callback.Teacher;
import org.junit.Test;

/**
 * @description:
 * @author: Peng.Li
 * @create: 2018-06-11 17:04
 **/
public class CallBackTest {

    @Test
    public void test() {
        Student student = new StudentRicky();
        Teacher teacher = new Teacher(student);
        teacher.askQuestion();
    }
}
