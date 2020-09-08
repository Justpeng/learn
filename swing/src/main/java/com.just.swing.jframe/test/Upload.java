package com.just.swing.jframe.test;

import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Description
 *
 * @author = peng.li
 * @since 12/25/2018-22:07
 */
@Slf4j
public class Upload {

    public void eventOnImport(JButton button)  {
        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setMultiSelectionEnabled(true);
            FileNameExtensionFilter filter = new FileNameExtensionFilter("cls",
                    "xml", "txt", "doc", "docx");
            fileChooser.setFileFilter(filter);

            int returnVal = fileChooser.showOpenDialog(button);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                FileInputStream inputStream ;
                FileOutputStream outputStream;
                //目标文件夹
                String path = "/Users/lipeng/Downloads/importdir";
                File dir = new File(path);
                if (!dir.exists()) {
                    dir.mkdir();
                }
                File[] arrFiles = fileChooser.getSelectedFiles();
                for (File file : arrFiles) {
                    inputStream = new FileInputStream(file);
                    byte[] buffer = new byte[1024];
                    File des = new File(path, file.getName());
                    outputStream = new FileOutputStream(des);
                    int len = 0;
                    while (-1 != (len = inputStream.read(buffer))) {
                        outputStream.write(buffer,0,len);
                    }
                    inputStream.close();
                    outputStream.close();
                }
                JOptionPane.showMessageDialog(null, "上传成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
            }else {
                JOptionPane.showMessageDialog(null, "上传失败！", "提示", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            log.error("出现异常",e);
        }



    }
}
