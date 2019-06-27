package com.qfedu.ljb.pay.db.service;

import com.qfedu.ljb.pay.db.entity.TOrderqrcode;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Feri
 * @since 2019-06-27
 */
public interface TOrderqrcodeService extends IService<TOrderqrcode> {
    TOrderqrcode selectLast(int opid);
}
