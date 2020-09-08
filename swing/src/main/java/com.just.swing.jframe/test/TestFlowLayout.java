package com.just.swing.jframe.test;

import javax.swing.*;
import java.awt.*;

/**
 * Description
 *
 * @author = peng.li
 * @since 12/24/2018-23:19
 */
public class TestFlowLayout {
    public static void main(String[] args) {
        //窗口
        JFrame jFrame = new JFrame("流布局器");

        FlowLayout flowLayout = new FlowLayout();
        //流
        jFrame.setLayout(flowLayout);

        //按钮
        JButton jButton = new JButton("选择");

        jFrame.add(jButton);

        JButton jButton1 = new JButton("上传");
        jFrame.add(jButton1);

        JButton jButton2 = new JButton("导出");
        jFrame.add(jButton2);

        jFrame.setSize(600, 300);
        jFrame.setLocation(550,100);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }
}
