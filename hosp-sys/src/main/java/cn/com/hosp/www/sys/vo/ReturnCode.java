package cn.com.hosp.www.sys.vo;


/**
 * @ClassName ReturnCode
 * @Description TODO
 * @Author tome
 * @Date 19-6-27 下午5:57
 * @Version 1.0
 */

public class ReturnCode {

    private String type;
    private String code;
    private String message;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public  enum Type{
        E("E"), S("S");
        private String value;
         Type(String value){
            this.value = value;
        }
        public String getValue(){
             return this.value;
        }
    }

}
