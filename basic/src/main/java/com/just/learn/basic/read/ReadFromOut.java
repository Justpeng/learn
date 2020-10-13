package com.just.learn.basic.read;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ReadFromOut {
    public static void main(String[] args) throws IOException {
//        Scanner scanner = new Scanner(System.in);
//        String s = scanner.nextLine();
//        System.out.println(s);

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String  s = input.readLine();
            switch (s) {
                case "1":
                    System.out.println("nnnn");
                case "2":
                    break;
            }
        }
    }
}
