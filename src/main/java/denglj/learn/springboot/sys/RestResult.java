package denglj.learn.springboot.sys;

public class RestResult {
    private String code;
    private String msg;

    public RestResult(){

    }

    public RestResult(String code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
