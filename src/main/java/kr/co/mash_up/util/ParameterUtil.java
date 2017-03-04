package kr.co.mash_up.util;


import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;

public class ParameterUtil {

    public static boolean isEmpty(Object... args) {
        if (args == null) {
            return true;
        }

        for (Object arg : args) {
            if (arg == null) {
                return true;
            } else if (arg instanceof String && StringUtils.isEmpty(arg)) {
                return true;
            } else if (arg instanceof Integer && (Integer) arg == 0) {
                return true;
            } else if (arg instanceof Long && (Long) arg == 0) {
                return true;
            } else if (arg instanceof MultipartFile && ((MultipartFile) arg).isEmpty()) {
                return true;
            } else if (arg instanceof Collection && CollectionUtils.isEmpty((Collection<?>) arg)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkParameterEmpty(Object... args) {
        if (isEmpty(args)) {
            return true;
        }
        return false;
    }
}
