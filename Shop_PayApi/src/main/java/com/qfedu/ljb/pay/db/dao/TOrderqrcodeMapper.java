package com.qfedu.ljb.pay.db.dao;

import com.qfedu.ljb.pay.db.entity.TOrderqrcode;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Feri
 * @since 2019-06-27
 */
public interface TOrderqrcodeMapper extends BaseMapper<TOrderqrcode> {


    TOrderqrcode selectLast(int opid);
}
