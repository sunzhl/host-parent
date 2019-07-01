package cn.com.hosp.www.sys.handler;

import cn.com.hosp.www.common.exception.HospException;
import cn.com.hosp.www.common.result.Result;
import cn.com.hosp.www.sys.vo.ReturnCode;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

/**
 * 全局Exception处理类
 * @DATE 2019/06/27
 * @author szl
 * @version 1.0
 */

@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public Object argumentNotValidException(HttpServletRequest request, MethodArgumentNotValidException ex){
        LOGGER.error("拦截到请求[{}]中参数验证不通过异常", request.getContextPath(), ex);
        List<ObjectError> allErrors = ex.getBindingResult().getAllErrors();
        ReturnCode returnCode = new ReturnCode();
        returnCode.setType(ReturnCode.Type.E.getValue());
        if(null != allErrors && allErrors.size() > 0){
            for (ObjectError error: allErrors) {
                returnCode.setCode(error.getCode());
                returnCode.setMessage(error.getDefaultMessage());
                break;
            }
        }else{
            returnCode.setMessage("参数校验未通过.");
        }
        return returnCode;
    }


    @ExceptionHandler(SQLException.class)
    public Object sqlException(SQLException ex){
        LOGGER.error("操作数据库出现异常", ex);
        ReturnCode returnCode = new ReturnCode();
        returnCode.setType(ReturnCode.Type.E.getValue());
        String message = "出现异常,请联系管理员!";
        if(ex instanceof MySQLIntegrityConstraintViolationException){
           message = "数据有重复!";
        }
        returnCode.setMessage(message);
        return returnCode;
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result exception(Exception ex){
        LOGGER.error("查询数据出现异常", ex);
        if (ex instanceof HospException){
            return Result.serverError(ex.getMessage());
        }
        if (ex instanceof HttpRequestMethodNotSupportedException) {
            return Result.serverError("url请求方法错误！");
        }
        return Result.serverError();
    }

}
