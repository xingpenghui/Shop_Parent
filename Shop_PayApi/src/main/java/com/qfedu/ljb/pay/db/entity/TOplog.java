package com.qfedu.ljb.pay.db.entity;


import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
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
@TableName("t_oplog")
@Data
public class TOplog extends Model<TOplog> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String orderno;
    private Integer type;
    private String content;
    private Date ctime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
