package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //create / read / update / delete + detail + exit
        //exit 외의 다른 명령어가 들어왔다면 "명령어를 다시 입력해주세요"출력
        //후 명령어를 입력해주세요:

        // trim = 명령어를 입력할때 띄어씌기도 출력할수있도록 해줌
        //반복문생성
        Scanner scanner = new Scanner(System.in);

        List<Post> postList = new ArrayList<>();


        boolean programStatus = true;
        int postCount = 0;
        while(programStatus){

            System.out.print("명령어를 입력해 주세요 : ");
            String command = scanner.nextLine().trim();

            switch (command){

                //리스트를 하기 위해서 for문을 사용해 준다.
                case "list" :
                   // siza(): 현재 들어있는 크기가 나옴
                    if(postList.size() == 0){
                        System.out.println("현재 게시물이 비어있습니다.");
                    } else {
                     System.out.println("현재까지 입력 된 게시글입니다.");
                     for(Post post : postList){
                         System.out.println(post.getId());
                         System.out.println(post.getTitle());
                         System.out.println(post.getBody());
                         System.out.println(post.getUpdateDate());
                     }
                     System.out.println("완료되었습니다.");
                 }
                 break;
                case "delete" :
                    System.out.println("게시글을 삭제합니다.");
                    System.out.println("삭제할 게시글의 번호를 입력해주세요:");
                    String deleteId = scanner.nextLine().trim();
                try{
                    int id = Integer.parseInt(deleteId);
                    //게시글 삭제
                    Post foundPost = postList.get(id-1); //(-> 객체)
                    //if의 조건은 id를 가지고 인덱스번 게시글을 찾아서 null이
                    //아닌 경우에만 삭제할 수 있도록 만들어 줘야 한다.
                    if (null != foundPost) {
                        postList.set(id - 1, null);
                    }
                }
                catch (NumberFormatException e){
                    System.out.println("게시글의 번호를 정수로 입력하세요.");
                }catch(IndexOutOfBoundsException e){
                    System.out.println("게시글의 번호를 다시 확인해주세요.");
                }catch (NullPointerException e){
                    System.out.println("이미 삭제된 게시글 입니다.");
                }
                break;

                case "update":

                    System.out.println("게시글을 수정합니다.");

                    System.out.println("수정할 게시글 번호를 입력해주세요.");
                    System.out.println("게시글 번호 : ");
                    String updatePostId = scanner.nextLine().trim();
                    // 예외 처리 , try catch
                    try {
                        int id = Integer.parseInt(updatePostId);
                        Post foundPost = postList.get(id - 1); // 배열, index 번호를 꺼내옴

                        System.out.println("제목 : " + foundPost.getTitle());
                        System.out.println("수정할 제목을 입력해 주세요 :");
                        String updateTitle = scanner.nextLine().trim();

                        System.out.println("내용 : " + foundPost.getBody());
                        System.out.println("수정할 내용을 입력해 주세요 :");
                        String updateBody = scanner.nextLine().trim();

                        foundPost.setTitle(updateTitle);
                        foundPost.setBody(updateBody);
                        foundPost.setUpdateDate(LocalDateTime.now());
                        //현재 시간 , 시점만 알려주는거라 update에서가 아닌 detail 에서 나옴

                        System.out.println("게시물 수정이 완료되었습니다.");

                    } catch (NumberFormatException e) {
                        System.out.println("게시글 번호를 정수로 입력해주세요.");
                    } catch (IndexOutOfBoundsException e){
                        System.out.println("게시글 번호를 다시 확인해주세요.");
                    }

                    break;

                case "detail":

                    System.out.print("게시글 번호를 입력해 주세요 : ");
                    String postId = scanner.nextLine().trim();

                    try{
                        int id = Integer.parseInt(postId);
                        Post foundPost = postList.get(id-1);

                        System.out.println("게시글 번호 : " + foundPost.getId());
                        System.out.println("게시글 제목 : " + foundPost.getTitle());
                        System.out.println("게시글 내용 : " + foundPost.getBody());
                        System.out.println("게시글 작성일 : " + foundPost.getRegDate());
                        System.out.println("게시글 수정일 : " + foundPost.getUpdateDate());

                    }catch (NumberFormatException e){
                        System.out.println("게시글 번호를 정수로 입력해 주세요.");
                    }catch (IndexOutOfBoundsException e){
                        System.out.println("게시글 번호를 다시 한번 확인해 주세요.");
                    }catch (NullPointerException e){
                        System.out.println("이미 삭제된 게시글 입니다.");
                    }
                    break;

                case  "write":
                    System.out.println("게시글을 작성합니다.");
                    System.out.print("제목 : " );
                    String title = scanner.nextLine().trim();
                    System.out.print("내용 : " );
                    String body = scanner.nextLine().trim();
                    postCount++;
                    Post newPost = new Post(postCount,title,body);
                    postList.add(newPost);

                    System.out.println(postCount + "번 게시글이 생성되었습니다.");
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
