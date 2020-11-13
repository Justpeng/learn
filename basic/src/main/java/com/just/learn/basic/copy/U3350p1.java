package com.just.learn.basic.copy;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class U3350p1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(scanner.next());
            break;
        }
    }

//    public static void main(String[] args) {
//        try (InputStream in =System.in; OutputStream out =System.out) {
//            byte[] buffer = new byte[1024];
//            while (in.read(buffer) != -1) {
//                out.write(buffer);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}