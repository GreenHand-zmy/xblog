package utils;

/**
 * Created by zmy on 2018/5/21.
 */
public final class StringUtil {
    /**
     * 判断字符串是否为空
     *
     * @param str 目标字符串
     * @return
     */
    public static boolean isEmpty(String str) {
        return str == null || "".equals(str);
    }

    /**
     * 判断字符串是否不为空
     *
     * @param str 目标字符串
     * @return
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }
}
