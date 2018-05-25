package utils;

/**
 * 结果对象
 * Created by zmy on 2018/5/25.
 */
public class ResultBean<T> {
    private static final String SUCCESS_CODE = "0";
    private static final String FAIL_CODE = "1";
    private String code;
    private String message;
    private T data;

    public ResultBean success() {
        code = SUCCESS_CODE;
        message = "success";
        return this;
    }

    public ResultBean success(String message) {
        code = SUCCESS_CODE;
        this.message = message;
        return this;
    }

    public ResultBean success(T data) {
        code = SUCCESS_CODE;
        message = "success";
        this.data = data;
        return this;
    }

    public ResultBean fail(String message) {
        code = FAIL_CODE;
        this.message = message;
        return this;
    }

    public static String getSuccessCode() {
        return SUCCESS_CODE;
    }

    public static String getFailCode() {
        return FAIL_CODE;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
