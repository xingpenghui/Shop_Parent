package com.qfedu.common.message.core.dao;

import com.qfedu.common.message.core.entity.Message;
import java.util.List;

public interface MessageMapper {

    int insert(Message record);

    List<Message> selectAll();
}