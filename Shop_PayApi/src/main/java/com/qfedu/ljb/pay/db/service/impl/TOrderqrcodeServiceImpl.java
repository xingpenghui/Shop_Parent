package com.qfedu.ljb.pay.db.service.impl;

import com.qfedu.ljb.pay.db.entity.TOrderqrcode;
import com.qfedu.ljb.pay.db.dao.TOrderqrcodeMapper;
import com.qfedu.ljb.pay.db.service.TOrderqrcodeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Feri
 * @since 2019-06-27
 */
@Service
public class TOrderqrcodeServiceImpl extends ServiceImpl<TOrderqrcodeMapper, TOrderqrcode> implements TOrderqrcodeService {

    @Override
    public TOrderqrcode selectLast(int opid) {
        return getBaseMapper().selectLast(opid);
    }
}
