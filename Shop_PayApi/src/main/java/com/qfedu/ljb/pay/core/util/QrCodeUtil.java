package com.qfedu.ljb.pay.core.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.client.j2se.MatrixToImageConfig;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *@Author feri
 *@Date Created in 2019/6/27 09:56
 */
public class QrCodeUtil {
    //生成二维码  返回缓存图片
    public static BufferedImage createQrCode(String content, int width){
        //创建 属性
        Map<EncodeHintType,Object> map=new HashMap<>();
        map.put(EncodeHintType.ERROR_CORRECTION,ErrorCorrectionLevel.H);
        map.put(EncodeHintType.MARGIN,1);
        map.put(EncodeHintType.CHARACTER_SET,"UTF-8");

        try {
            //生成矩阵  参数说明：1、二维码的内容 2、类型 二维码 3、宽度 4、高度 5、属性设置
            BitMatrix bitMatrix=new MultiFormatWriter().encode(
                    content,BarcodeFormat.QR_CODE,width,width,map);
            //配色
            MatrixToImageConfig config=new MatrixToImageConfig(0xFF000000,0xFFFFFFFF);
            BufferedImage image=MatrixToImageWriter.toBufferedImage(bitMatrix,config);
            return image;
        } catch (WriterException e) {
            e.printStackTrace();
        }
        return null;
    }
    //生成二维码 存储到指定文件中
    public static String qrcodeFile(String content,int width,File file){
        BufferedImage image=createQrCode(content, width);
        if(image!=null){
            try {
                ImageIO.write(image,"png",file);
                return file.getAbsolutePath();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
      return null;
    }

}
