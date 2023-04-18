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
        int postCount = 0;
        while(programStatus){
            System.out.print("명령어를 입력해 주세요 : ");
            String command = scanner.nextLine().trim();
            switch (command){
                case  "write":
                    System.out.println("게시글을 작성합니다.");
                    System.out.print("제목 : " );
                    String title = scanner.nextLine().trim();
                    System.out.print("내용 : " );
                    String body = scanner.nextLine().trim();
                    postCount++;
                    Post newPost = new Post(postCount,title,body);
                    System.out.println("작성된 게시글 : " + newPost);
                    break;
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

// git 에 올리는 순서
//    git status
//    git add .
//    git status
//    git commit -m"post 엔티티클래스 생성"
//    git push origin master
