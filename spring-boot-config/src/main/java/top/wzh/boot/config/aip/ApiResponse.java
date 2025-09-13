package top.wzh.boot.config.aip;

import lombok.Getter;

/**
 * @Author: 王振辉
 * @Date: 2025/9/13
 */
@Getter
public class ApiResponse<T> {
    private final int code;
    private final String msg;
    private final T data;

    public ApiResponse(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    public static <T> ApiResponse<T> success(String msg, T data) {
        return new ApiResponse<>(200, msg, data);
    }

    public static <T> ApiResponse<T> error(String  msg) {
        return new ApiResponse<>(200, msg, null);
    }
}
