package org.example.sys;

import java.util.Map;

public class Request {

    // http , https 가 뭔지
    // request-response (요청-응답) 가 뭔지

    //같은 메소드를 쓰려면 전역변수,지역변수 나누고 변수를 만들어줌
    //-> 매개변수를 다르게 쓰면 사용 가능 .. 스코프
    //= 오버로드

    //= 오버라이딩 (=상속관계에서 메소드를 재정의 하는거)
    //toString은 object(부모클래스)안에 있는 메서드 사용
    //메소드의 이름은 같지만 안의 내용이 다름
    // 하는 이유 = 헷갈리지 않고 틀린게 있는지 검사해줌

    private Uriparser uriparser;

    protected Map<String,Object> parameters;
    // object는 부모 클래스이기에 모든 클래스를 사용 할 수 있음 (간결하게 쓰기 가능)

    public Request(String url){
        this.uriparser = new Uriparser(url);
        this.parameters = this.uriparser.getParameters();
    }
    public boolean isValidUri (){
        return uriparser.isValidUri();
    }

    //object를 반환시켜주기
    // <T>T -> 상황에 따라 반환시켜 줌(=제네릭) , class
    public <T>T getValue(String key, Class<T> cls){

        Object o = this.parameters.get(key);  // 1,aaa

        if(cls == Integer.class){
            return cls.cast(Integer.parseInt(o.toString()));
        } else if(cls == Long.class){
            return cls.cast(Long.parseLong(o.toString()));
        } else if (cls == Boolean.class){
            return cls.cast(Boolean.parseBoolean(o.toString()));
        }
        return cls.cast(o);
    }


    // locscalhost : 내 컴퓨터를 나타냄
      //http://localhost:8080/members/join
    //  /members/update?id=3(?: 단일 파라미터)
    //  /members/update?id=3&param=1(? & ? )
    //
}
