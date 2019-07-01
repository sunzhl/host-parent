package cn.com.hosp.www.sys.vo;

import java.util.Collection;

/**
 * @ClassName ResponseData
 * @Description TODO
 * @Author tome
 * @Date 19-6-28 下午5:45
 * @Version 1.0
 */

public class ResponseData<V> {

    private ReturnCode returnCode;

    private V data;

    private int size;

    public ReturnCode getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(ReturnCode returnCode) {
        this.returnCode = returnCode;
    }

    public V getData() {
        return data;
    }

    public void setData(V data) {
        this.data = data;
        if (data instanceof Collection){
            size = ((Collection) data).size();
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setError(String message){
        returnCode = new ReturnCode();
        returnCode.setMessage(message);
        returnCode.setType(ReturnCode.Type.E.getValue());
    }

    public void setSuccess(String message){
        returnCode = new ReturnCode();
        returnCode.setMessage(message);
        returnCode.setType(ReturnCode.Type.S.getValue());
    }

}
