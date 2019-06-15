package com.qfedu.ljb.api.resource.util;

import com.aliyun.oss.OSSClient;
import com.qfedu.common.config.ProjectConfig;
import com.qfedu.common.util.TimeUtil;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static com.qfedu.common.config.ProjectConfig.accessKeySecret;

/**
 *@Author feri
 *@Date Created in 2019/6/15 16:49
 */
public class OSSUtil {

    private OSSClient ossClient;
    public OSSUtil(){
        ossClient=new OSSClient(ProjectConfig.endpoint, ProjectConfig.accessKeyId, accessKeySecret);
    }
    //上传字符串
    public String uploadStr(String objectName,String value){
        // 上传字符串。
        ossClient.putObject(ProjectConfig.bucketName,objectName, new ByteArrayInputStream(value.getBytes()));
        return ossClient.generatePresignedUrl(ProjectConfig.bucketName,objectName,TimeUtil.getYear(3)).toString();
    }
    //上传文件流
    public String uploadFile(String fileName,InputStream is){
        ossClient.putObject(ProjectConfig.bucketName, fileName, is);
        return ossClient.generatePresignedUrl(ProjectConfig.bucketName,fileName,TimeUtil.getYear(3)).toString();

    }
    //上传数组
    public String uploadByte(String fileName,byte[] data){
        ossClient.putObject(ProjectConfig.bucketName, fileName,  new ByteArrayInputStream(data));
        return ossClient.generatePresignedUrl(ProjectConfig.bucketName,fileName,TimeUtil.getYear(3)).toString();
    }
    //验证某个文件是否存在
    public boolean checkFile(String fileName){
      return ossClient.doesObjectExist(ProjectConfig.bucketName, fileName);
    }
    //删除
    public void delete(String objName){
        ossClient.deleteObject(ProjectConfig.bucketName, objName);
    }



    public static void main(String[] args) {
        OSSUtil ossUtil=new OSSUtil();
        System.out.println(ossUtil.uploadStr("str1901","下课"));
    }
}
