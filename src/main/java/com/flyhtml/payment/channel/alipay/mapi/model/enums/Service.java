package com.flyhtml.payment.channel.alipay.mapi.model.enums;

/**
 * @author xiaowei
 * @time 17-4-12 下午3:37
 * @describe Service interface name
 */
public enum Service {

  /** WEB支付 */
  WEB_PAY("create_direct_pay_by_user"),

  /** WAP支付 */
  WAP_PAY("alipay.wap.create.direct.pay.by.user"),

  /** APP支付 */
  APP_PAY("mobile.securitypay.pay"),

  /** 无密退款 */
  REFUND_NO_PWD("refund_fastpay_by_platform_nopwd"),

  /** 支付宝通知校验 */
  NOTIFY_VERIFY("notify_verify"),

  /** 单笔交易查询 */
  TRADE_QUERY("single_trade_query");

  private String value;

  private Service(String value) {
    this.value = value;
  }

  public String value() {
    return value;
  }
}
