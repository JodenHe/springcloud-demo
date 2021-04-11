/**
 * Copyright Hand China Co.,Ltd.
 */
package top.joden123.authuserservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * Created by xiaofeng.he on 2021/04/11
 *
 * @author xiaofeng.he
 */
@ResponseBody
@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(UserLoginException.class)
    public ResponseEntity<String> handleException(Exception e) {
        return new ResponseEntity(e.getMessage(), HttpStatus.OK);
    }

}
