package com.qfedu.ljb.pay.db.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Feri
 * @since 2019-06-27
 */
@TableName("t_orderqrcode")
@Data
public class TOrderqrcode extends Model<TOrderqrcode> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Integer opid;
    private String payurl;
    /**
     * 二维码路径
     */
    private String qrcodeurl;
    private Integer flag;
    private Date ctime;


}
