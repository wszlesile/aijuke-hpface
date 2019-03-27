package com.aijuke.hpface.common;

/**
 * 系统常量
 */
public class SysConstant {
    private SysConstant() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * 成功的Status Code.
     */
    private static final int RESCODE_OK = 200;

    /**
     * 失败的Status Code.
     */
    private static final int RESCODE_FAIL = 201;

    /**
     * 未授权
     */
    private static final int RESCODE_UNAUTHORIZED = 401;

    public static int getRescodeOk() {
        return RESCODE_OK;
    }

    public static int getRescodeFail() {
        return RESCODE_FAIL;
    }

    public static int getUnauthorized() {
        return RESCODE_UNAUTHORIZED;
    }
}
