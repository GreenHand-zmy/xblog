package utils;

import com.alibaba.fastjson.JSON;

/**
 * Json工具类
 * Created by zmy on 2018/5/25.
 */
public final class JsonUtil {
    /**
     * 将对象实例转换为json格式
     *
     * @param data 数据对象
     * @return
     */
    public static String objectToJson(Object data) {
        return JSON.toJSONString(data);
    }

    /**
     * 将json字符串转化为对象实例
     *
     * @param jsonData json数据
     * @param dataType 目标对象.class
     * @return
     */
    public static <T> T jsonToObject(String jsonData, Class<T> dataType) {
        return JSON.parseObject(jsonData, dataType);
    }
}
