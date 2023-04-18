package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //create / read / update / delete + detail + exit
        //exit 외의 다른 명령어가 들어왔다면 "명령어를 다시 입력해주세요"출력
        //후 명령어를 입력해주세요:

        // trim = 명령어를 입력할때 띄어씌기도 출력할수있도록 해줌
        //반복문생성
        Scanner scanner = new Scanner(System.in);
        boolean programStatus = true;
        while(programStatus){
            System.out.print("명령어를 입력해 주세요 : ");
            String command = scanner.nextLine().trim();
            switch (command){
                case "exit":
                    System.out.println("프로그램을 종료합니다.");
                    programStatus = false;
                    break;
                default:
                    System.out.println("명령어를 다시 입력해주세요.");
            }
        }
    }



}
// if(command.equals(("exit"))){
//         System.out.println("프로그램을 종료합니다.");
//         programStatus = false;
//         } else {
//         System.out.println("명령 다시");
//         }