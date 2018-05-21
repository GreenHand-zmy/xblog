package utils;

/**
 * Created by zmy on 2018/5/21.
 */
public final class CheckUtil {
    /**
     * 字段校验
     *
     * @param condition 校验条件
     * @param message   校验失败,报错信息
     */
    public static void check(boolean condition, String message) {
        if (!condition) {
            fail(message);
        }
    }

    private static void fail(String message) {
        throw new RuntimeException(message);
    }
}
