package com.just.swing.jframe.test;

import com.just.swing.jframe.start.StartService;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Description
 *
 * @author = peng.li
 * @since 12/25/2018-21:48
 */
@Slf4j
public class Demo {
    public static void main(String[] args) {

        StartService startService = new StartService();
        if (startService.isAuthor()) {
            log.info("授权成功");
        }else {
            log.info("授权失败");
        }


        JFrame frame = new JFrame("DEMO窗口");

        BorderLayout borderLayout = new BorderLayout();
        //流
        frame.setLayout(borderLayout);

        frame.setSize(1200,600);
        frame.setLocation(2000,600);




        //菜单拦
        JMenuBar mb = new JMenuBar();
        JMenu file = new JMenu("文件");

        mb.add(file);
        frame.setJMenuBar(mb);


        //底部
        JPanel bottom = new JPanel();


        ////创建一个从上到下显示的Box
        Box topLeft = Box.createVerticalBox();
        JTextArea ta = new JTextArea(8, 20);

        JScrollPane taJsp = new JScrollPane(ta);
        topLeft.add(taJsp);

        //创建一个水平排列组件的Box,盛装topLeft、colorList
        Box top = Box.createHorizontalBox();
        top.add(topLeft);

        frame.add(top);

        JButton upload = new JButton("上传");
        bottom.add(upload);
        upload.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new Upload().eventOnImport(upload);

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        JButton export = new JButton("导出");
        bottom.add(export);
        frame.add(bottom, BorderLayout.SOUTH);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
