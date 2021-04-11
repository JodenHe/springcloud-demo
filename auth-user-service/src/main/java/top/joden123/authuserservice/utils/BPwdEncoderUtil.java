/**
 * Copyright Hand China Co.,Ltd.
 */
package top.joden123.authuserservice.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * <p>
 * Created by xiaofeng.he on 2021/04/11
 *
 * @author xiaofeng.he
 */
public class BPwdEncoderUtil {

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    /**
     * 用BCryptPasswordEncoder
     * @param password
     * @return
     */
    public static String  BCryptPassword(String password){
        return encoder.encode(password);
    }

    /**
     *
     * @param rawPassword
     * @param encodedPassword
     * @return
     */
    public static boolean matches(CharSequence rawPassword, String encodedPassword){
        return encoder.matches(rawPassword,encodedPassword);
    }

}
