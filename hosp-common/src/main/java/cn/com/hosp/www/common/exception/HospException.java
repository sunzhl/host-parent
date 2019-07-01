package cn.com.hosp.www.common.exception;

/**
 * @ClassName HospException
 * @Description TODO
 * @Author tome
 * @Date 19-6-27 下午6:27
 * @Version 1.0
 */

public class HospException extends RuntimeException{

    public HospException() {
    }
    public HospException(String message) {
        super(message);
    }

    public HospException(String message, Throwable cause) {
        super(message, cause);
    }

    public HospException(Throwable cause) {
        super(cause);
    }

    public HospException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
