package com.bbx.jc.park.mapper;

import com.bbx.jc.park.entity.Message;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MessageMapper {

    //添加信息
    @Insert("insert into message(content,createDate,user_id,user_name) values(#{content},SYSDATE(),#{user_id},#{user_name})")
    void insertMessage(Message message);

    //删除信息
    @Delete("delete from message where id=#{id}")
    void deleteMessage(int id);

    //查询信息
    @Select("select * from message where content like #{content}")
    List<Message> findByContent(@Param("content") String content);

    @Select("select * from message")
    List<Message> findAllMessage();

    @Select("select * from message where user_id=#{id}")
    List<Message> findMyMessage(@Param("id") int id);

    //修改信息
    @Update("update message set answer=#{answer},answerDate=SYSDATE(),admin_id=#{admin_id},admin_name=#{admin_name} where id=#{id}")
    void updateMessage(Message message);
}
