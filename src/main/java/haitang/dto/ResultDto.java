package haitang.dto;

import org.springframework.stereotype.Component;

@Component
public class ResultDto <T> {

    private Integer code;
    private String message;
    private T data;


    public static ResultDto success(){
        ResultDto resultDto=new ResultDto();
        resultDto.setCode(200);
        resultDto.setMessage("请求成功");
        return resultDto;
    }
    public static <T> ResultDto successWithData(T t){
        ResultDto resultDto=new ResultDto();
        resultDto.setCode(200);
        resultDto.setMessage("请求成功");
        resultDto.setData(t);
        return resultDto;
    }
    @Override
    public String toString() {
        return "ResultDto{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
