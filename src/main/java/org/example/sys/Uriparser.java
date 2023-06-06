package org.example.sys;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Uriparser {
    //유효성을 검사하는 필드 , 요청을 응답
    // /members/join
    private String URI;
    private String controllerCode; // 요청을 쪼개서 저장 , career
    private String target; // job
    private  boolean isValidUri = true;
    private Map<String, Object> parameters = new HashMap<>();

    public Uriparser(String uri){
        this.URI = parse(uri);
    }
    protected String parse(String uri){
        if (! uri.startsWith("/")){
            this. isValidUri = false;
            return uri;
        }
        //split : 특정 값을 쪼개는 거 ,?물음표 기준으로 쪼갬
        String[] uriSplit = uri.split("\\?");
        if(uriSplit.length == 2){
            setParameters(uriSplit[1]);
        }
        String[] uriFront = uriSplit[0].split("/");
        if(uriFront.length != 3){
            this.isValidUri = false;
            return uri;
        }
        this.controllerCode = uriFront [1];
        this.target = uriFront[2];

        return uri;
    }
    protected void setParameters(String uriPart){

        try{
            if(uriPart.contains("&")) {
                String[] split = uriPart.split("&");
                for (String s : split) {
                    String[] parameterDate = s.split("=", 2);
                    //유효성 검사
                    if (parameterDate[1].equals("")) {
                        throw new IllegalArgumentException("유효하지 않은 파라미터입니다.");
                        //예외, throw = 던지다
                    }
                    parameters.put(parameterDate[0], parameterDate[1]); //key : value
                }
            }else{
               String[] split = uriPart.split("=",2);
               if(split[1].equals("")){
                   throw new IllegalArgumentException("유효하지 않은 파라미터 입니다.");
               }
               parameters.put(split[0],split[1]);
            }
        }catch (ArrayIndexOutOfBoundsException e){
            this.isValidUri = false;
        }catch (IllegalArgumentException e ){
            this.isValidUri = false;
        }
    }
    //getter

    protected String getURI() {
        return URI;
    }

    protected String getControllerCode() {
        return controllerCode;
    }

    protected String getTarget() {
        return target;
    }

    protected boolean isValidUri() {
        return isValidUri;
    }

    protected Map<String, Object> getParameters() {
        return parameters;
    }
    //mvc 패턴<?>
    // model : ex) 아이디,비밀번호가 일치한지 DB로 확인
    // view : ex) 로그인 누르기 전 화면
    // controller : ex)아이디,비밀번호 확인시켜주는 페이지로 이동,확인
}
