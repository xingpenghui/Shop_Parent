package com.qfedu.ljb.pay.core.wxchat;

import com.qfedu.common.util.EncryptionUtil;
import com.qfedu.ljb.pay.core.util.HttpUtil;
import com.qfedu.ljb.pay.core.util.MD5Util;

import java.net.Inet4Address;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *@Author feri
 *@Date Created in 2018/8/9 23:12
 */
public class PayCommonUtil {
    /**
     *
     * @return boolean
     */
    public static boolean isTenpaySign(String characterEncoding, SortedMap<Object,
                Object> packageParams, String API_KEY) {
        StringBuffer sb=new StringBuffer();
        Set es= packageParams.entrySet();
        Iterator it = es.iterator();
        while(it.hasNext()) {
            Map.Entry entry = (Map.Entry)it.next();
            String k = (String)entry.getKey();
            String v = (String)entry.getValue();
            if(!"sign".equals(k) && null != v && !"".equals(v)) {
                sb.append(k + "=" + v + "&");
            }
        }
        sb.append("key=" + API_KEY);
        String mysign =MD5Util.MD5Encode(sb.toString(),characterEncoding).toLowerCase();
        String tenpaySign = ((String)packageParams.get("sign")).toLowerCase();
        return tenpaySign.equals(mysign);
    }
    /**
     * @author
     * @Description sign 创建签名
     * @param characterEncoding
     * @return
     */
    public static String createSign(String characterEncoding, SortedMap<Object,
            Object> packageParams, String API_KEY) {
        StringBuffer sb = new StringBuffer();
        Set es = packageParams.entrySet();
        Iterator it = es.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String k = (String) entry.getKey();
            String v = (String) entry.getValue();
            if (null != v && !"".equals(v) && !"sign".equals(k) &&
                    !"key".equals(k)) {
                sb.append(k + "=" + v + "&");
            }
        }
        sb.append("key=" + API_KEY);
        String sign =MD5Util.MD5Encode(sb.toString(),characterEncoding).toUpperCase();
        return sign;
    }
    /**
     * @Description 封装请求参数为xml格式的字符串
     * @return
     */
    public static String getRequestXml(SortedMap<Object, Object> parameters) {
        StringBuffer sb = new StringBuffer();
        sb.append("<xml>");
        Set es = parameters.entrySet();
        Iterator it = es.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String k = (String) entry.getKey();
            String v = (String) entry.getValue();
                if ("attach".equalsIgnoreCase(k) || "body".equalsIgnoreCase(k)
                   ) {
                sb.append("<" + k + ">" + "<![CDATA[" + v + "]]></" + k + ">");
            } else {
                sb.append("<" + k + ">" + v + "</" + k + ">");
            } }
        sb.append("</xml>");
        return sb.toString();
    }
    /*获取指定大小的正整数*/
    public static int buildRandom(int length) {
        int num = 1;
        double random = Math.random();
        if (random < 0.1) {
            random = random + 0.1;
        }
        for (int i = 0; i < length; i++) {
            num = num * 10;
        }
        return (int) ((random * num));
    }

    public static String getCurrTime() {
        Date now = new Date();
        SimpleDateFormat outFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String s = outFormat.format(now);
        return s;
    }
    //调用预支付接口 获取支付链接
    /**
     * @param order_price 价格 单位 分
     * @param  body 商品描述
     * @param  out_trade_no 商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|* 且在同一个商户号下唯一*/
    public static String weixin_pay( String order_price,String body,String
            out_trade_no) throws Exception {
        String ip=Inet4Address.getLocalHost().getHostAddress();
        String appid = PayConfig.APP_ID; // appid
        String key = PayConfig.API_KEY; // key
        String currTime = PayCommonUtil.getCurrTime();
        String strTime = currTime.substring(8, currTime.length());
        String strRandom = PayCommonUtil.buildRandom(4) + "";
        String nonce_str = strTime + strRandom;
        String trade_type = "NATIVE";//JSAPI--公众号支付、NATIVE--原生扫码支付、APP--app支付，统一下单接口trade_type的传参可参考这里
        //MICROPAY--刷卡支付，刷卡支付有单独的支付接口，不调用统一下单接口
        SortedMap<Object, Object> packageParams = new TreeMap<Object, Object>();
        packageParams.put("appid", appid);
        packageParams.put("mch_id", PayConfig.MCH_ID);
        packageParams.put("nonce_str", nonce_str);
        packageParams.put("body", body);
        packageParams.put("out_trade_no", out_trade_no);
       // packageParams.put("total_fee", order_price);
        packageParams.put("total_fee", "1");
        packageParams.put("spbill_create_ip", ip);
        packageParams.put("notify_url", "http://"+ip+":8080/paycallback");
        packageParams.put("trade_type", trade_type);
        String sign = PayCommonUtil.createSign("UTF-8", packageParams, key);
        packageParams.put("sign", sign);
        String requestXML = PayCommonUtil.getRequestXml(packageParams);
        System.out.println("请求----->"+requestXML);
        String resXml = HttpUtil.postData(PayConfig.UFDOOER_URL, requestXML);
        System.out.println("结果----->"+resXml);
        Map map = XmlUtil.doXMLParse(resXml);
        String urlCode = (String) map.get("code_url");
        return urlCode;
    }

    //生成查询x支付结果
    public static String weixin_query(String orderno){
        String currTime = getCurrTime();
        String strTime = currTime.substring(8, currTime.length());
        String strRandom = PayCommonUtil.buildRandom(4) + "";
        String nonce_str = strTime + strRandom;
        SortedMap<Object, Object> packageParams = new TreeMap<Object, Object>();
        packageParams.put("appid", PayConfig.APP_ID);
        packageParams.put("mch_id", PayConfig.MCH_ID);
        packageParams.put("out_trade_no", orderno);
        packageParams.put("nonce_str", nonce_str);
        String sign = PayCommonUtil.createSign("UTF-8", packageParams, PayConfig.API_KEY);
        packageParams.put("sign", sign);
        String requestXML = PayCommonUtil.getRequestXml(packageParams);
        System.out.println("查询请求----->"+requestXML);
        String resXml = HttpUtil.postData(PayConfig.QUERY_URL, requestXML);
        System.out.println("查询结果----->"+resXml);
        return resXml;
    }
    //取消订单  没有支付的订单
    public static String closeOrder(String orderNo){
        String currTime = getCurrTime();
        String strTime = currTime.substring(8, currTime.length());
        String strRandom = PayCommonUtil.buildRandom(4) + "";
        String nonce_str = strTime + strRandom;
        SortedMap<Object, Object> packageParams = new TreeMap<Object, Object>();
        packageParams.put("appid", PayConfig.APP_ID);
        packageParams.put("mch_id", PayConfig.MCH_ID);
        packageParams.put("out_trade_no", orderNo);
        packageParams.put("nonce_str", nonce_str);
        String sign = PayCommonUtil.createSign("UTF-8", packageParams, PayConfig.API_KEY);
        packageParams.put("sign", sign);
        String requestXML = PayCommonUtil.getRequestXml(packageParams);
        System.out.println("查询请求----->"+requestXML);
        String resXml = HttpUtil.postData(PayConfig.CLOSE_URL, requestXML);
        System.out.println("查询结果----->"+resXml);
        return resXml;
    }

    //查询退款订单的状态
    public static String queryRefundOrder(String orderNo){
        String currTime = getCurrTime();
        String strTime = currTime.substring(8, currTime.length());
        String strRandom = PayCommonUtil.buildRandom(4) + "";
        String nonce_str = strTime + strRandom;
        SortedMap<Object, Object> packageParams = new TreeMap<Object, Object>();
        packageParams.put("appid", PayConfig.APP_ID);
        packageParams.put("mch_id", PayConfig.MCH_ID);
        packageParams.put("out_trade_no", orderNo);
        packageParams.put("nonce_str", nonce_str);
        String sign = PayCommonUtil.createSign("UTF-8", packageParams, PayConfig.API_KEY);
        packageParams.put("sign", sign);
        String requestXML = PayCommonUtil.getRequestXml(packageParams);
        System.out.println("查询请求----->"+requestXML);
        String resXml = HttpUtil.postData(PayConfig.REFUND_URL, requestXML);
        System.out.println("查询结果----->"+resXml);
        return resXml;
    }
}
