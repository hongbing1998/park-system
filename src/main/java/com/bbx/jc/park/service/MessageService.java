package com.bbx.jc.park.service;

import com.bbx.jc.park.entity.Message;
import com.bbx.jc.park.mapper.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageMapper messageMapper;

    //通过id修改状态
    public boolean updateMessage(Message message) {
        try {
            messageMapper.updateMessage(message);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //模糊查询
    public List<Message> getByContent(String tmpContent) {
        String content = "%" + tmpContent + "%";
        return messageMapper.findByContent(content);
    }

    //获取全部
    public List<Message> getAll() {
        return messageMapper.findAllMessage();
    }

    public List<Message> getMyMessage(int id) {
        return messageMapper.findMyMessage(id);
    }

    //删除
    public boolean delMessage(int id) {
        try {
            messageMapper.deleteMessage(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //添加
    public boolean addMessage(Message message) {
        try {
            messageMapper.insertMessage(message);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
