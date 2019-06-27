package com.qfedu.ljb.pay.core.test;

import com.qfedu.ljb.pay.core.util.QrCodeUtil;
import org.junit.Test;
import java.io.File;

/**
 *@Author feri
 *@Date Created in 2019/6/27 10:14
 */
public class Qrcode_Test {
    @Test
    public void test1(){
        File file=new File("hello.png");
        System.out.println(
                QrCodeUtil.qrcodeFile("Hello,Java,1901 欢迎你",400,file)
        );

    }
}
