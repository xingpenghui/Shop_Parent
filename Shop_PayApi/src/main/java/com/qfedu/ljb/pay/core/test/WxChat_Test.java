package com.qfedu.ljb.pay.core.test;

import com.qfedu.ljb.pay.core.wxchat.PayCommonUtil;
import org.junit.Test;

/**
 *@Author feri
 *@Date Created in 2019/6/27 11:21
 */
public class WxChat_Test {
    @Test
    public void test1() throws Exception {
//       String url=PayCommonUtil.weixin_pay("1","测试微信支付","201906270001");
//        System.out.println("支付链接："+url);
        System.out.println(PayCommonUtil.weixin_query("201906270021"));
    }
}
