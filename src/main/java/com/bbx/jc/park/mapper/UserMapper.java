package com.bbx.jc.park.mapper;

import com.bbx.jc.park.entity.Users;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    //添加信息
    @Insert("insert into user(name,phone,plate_num,password,createDate,stauts) values(#{name},#{phone},#{plate_num},#{password},SYSDATE(),0)")
    void insertUsers(Users users);

    //删除信息
    @Delete("delete from user where id=#{id}")
    void deleteUserById(int id);

    //修改信息
    @Update("update user set stauts=#{stauts} where id=#{id}")
    void updateUserStauts(@Param("id") int id, @Param("stauts") int stauts);

    @Update("update user set point=#{point} where id=#{id}")
    void updateUserPoint(Users user);

    @Update("update user set phone=#{phone},plate_num=#{plate_num} where id=#{id}")
    void updateUser(Users user);

    @Update("update user set password=#{password} where id=#{id}")
    void updateUserPwd(Users user);

    //查询信息
    @Select("select * from user where name like #{name}")
    List<Users> findByName(@Param("name") String name);

    @Select("select * from user")
    List<Users> findAllUser();

    @Select("select * from user where id=#{id}")
    Users findUserById(@Param("id") int id);

    @Select("select * from user order by point desc")
    List<Users> findAllPoint();

    @Select("select * from user where name like #{name} order by point desc")
    List<Users> findPointByName(@Param("name") String name);

    //登陆使用
    @Select("select * from user where name=#{name} and password = #{password}")
    List<Users> findUserByNameAndPwd(@Param("name") String adminName, @Param("password") String password);
}
