package org.example;

import java.time.LocalDateTime;

public class Post {

    //코딩을 은닉하기 위해 프라이베잍 사용
    private int id; //id : 번호
    private String title;
    private String body;
    private LocalDateTime regDate;
    private LocalDateTime updateDate;

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", regDate=" + regDate +
                ", updateDate=" + updateDate +
                '}';
    }

    public Post (int id, String title, String body){
        this. id = id;
        this. title = title;
        this. body = body;
        this.regDate = LocalDateTime.now(); // 값이 변경될 수 있도록 해줌
        this.updateDate = LocalDateTime.now();

    }
    public int getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public String getBody() {
        return body;
    }
    public LocalDateTime getRegDate(){
        return regDate;
    }
    public LocalDateTime getUpdateDate(){
        return updateDate;
    }
}
