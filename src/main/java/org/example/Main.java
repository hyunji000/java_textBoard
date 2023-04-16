package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //스캐너 객체
        Scanner scanner = new Scanner(System.in);
        //사용자에게 입력받을수 있도록 출력
        System.out.print("명령어를 입력해 주세요 : ");
        //값 입력 받는거
        String command = scanner.nextLine();
        System.out.println("입력하신 명령어는 : " + command);
    }

}