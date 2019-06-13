package com.qfedu.common.message.core.dao;

import com.qfedu.common.message.core.entity.MsgReceive;
import java.util.List;

public interface MsgReceiveMapper {

    int insert(MsgReceive record);

    List<MsgReceive> selectAll();
}