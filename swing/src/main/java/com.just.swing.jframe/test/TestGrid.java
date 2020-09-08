package com.just.swing.jframe.test;

import javax.swing.*;
import java.awt.*;

/**
 * Description
 *
 * @author = peng.li
 * @since 12/25/2018-21:01
 */
public class TestGrid {
    public static void main(String[] args) {
        JFrame jf = new JFrame("网状布局DEMO");
        GridLayout gl = new GridLayout(5,4); //5行4列的表格
        jf.setLayout(gl); //修改布局为网状 5 行 4 列
        for(int i=0;i<20;i++){
            JButton jb = new JButton(i+""); //数字转String
            jf.add(jb);
        }
        //jf.setSize(600,300); //设置大小
        jf.pack(); //自动调整大小
        jf.setLocation(300,200); // 设置初始的位置
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭
        jf.setVisible(true); //解决了初始不可见的问题
    }
}
