package com.flyhtml.payment.common.exception;

/**
 * @author xiaowei
 * @time 17-4-10 下午1:16
 * @describe
 */
public class PayTypeException extends RuntimeException {

    public PayTypeException() {
        super("channel not found");
    }
}
