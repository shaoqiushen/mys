package com.shanyuan.domain;

import lombok.Data;

/**
 * author  shenshaoqiu
 * <p>
 * create 2019-05-28 15:41
 * <p>
 * desc
 **/
@Data
public class PayInfo {
    /**
     * 公众账号ID，微信支付分配的公众账号ID（企业号corpid即为此appId） --  String(32)
     */
    private String appid;
    /**
     * 商户号，微信支付分配的商户号  -- String(32)
     */
    private String mch_id;
    /**
     * 设备号，自定义参数，可以为终端设备号(门店号或收银设备ID)，PC网页或公众号内支付可以传"WEB"  --  String(32)
     */
    private String device_info;
    /**
     * 商品描述 ，商品简单描述，该字段请按照规范传递  --  String(128)
     *        		使用场景	         支付模式	       			商品字段规则	        	 		样例	                                                备注
     PC网站	         扫码支付	        浏览器打开的网站主页title名 -商品概述	        腾讯充值中心-QQ会员充值
     微信浏览器	公众号支付		商家名称-销售商品类目					    腾讯-游戏						线上电商，商家名称必须为实际销售商品的商家
     门店扫码	        公众号支付		店名-销售商品类目						小张南山店-超市					线下门店支付
     门店扫码	        扫码支付			店名-销售商品类目						小张南山店-超市					线下门店支付
     门店刷卡	        刷卡支付			店名-销售商品类目						小张南山店-超市					线下门店支付
     手机浏览器	H5支付		浏览器打开的移动网页的主页title名-商品概述	 腾讯充值中心-QQ会员充值
     第三方APP	APP支付		应用市场上的APP名字-商品概述	                          天天爱消除-游戏充值
     */
    private String body;
    /**
     * 商户订单号，商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|* 且在同一个商户号下唯一  --  String(32)
     */
    private String out_trade_no;
    /**
     * 标价金额，订单总金额，单位为分，参数值不能带小数
     */
    private String total_fee;
    /**
     * 终端IP，APP和网页支付提交用户端ip，Native支付填调用微信支付API的机器IP。  --  String(16)
     */
    private String spbill_create_ip;
    /**
     * 通知地址，异步接收微信支付结果通知的回调地址，通知url必须为外网可访问的url，不能携带参数。
     */
    private String notify_url;
    /**
     * 交易类型，JSAPI--公众号支付、NATIVE--原生扫码支付、APP--app支付，
     */
    private String trade_type;
    /**
     * 用户标识，trade_type=JSAPI时（即公众号支付），此参数必传，此参数为微信用户在商户对应appid下的唯一标识
     */
    private String openid;
    /**
     * 签名类型，传 MD5 即可
     */
    private	String sign_type;

    private String appsecret;

    private String key; //秘钥

    private String user_id;


    private String code; //使用卡券时

    private String card_id;//使用卡券时

    private Integer system_source;//系统来源，0微信，1小程序
}
