package com.bbx.jc.park.mapper;

import com.bbx.jc.park.entity.Admin;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AdminMapper {

    //添加信息
    @Insert("insert into admin(name,password,createDate) values(#{name},#{password},SYSDATE())")
    void insert(Admin admin);

    //删除信息
    @Delete("delete from admin where id=#{id}")
    void delete(int id);

    //修改
    @Update("update admin set name=#{name},password=#{password} where id=#{id}")
    void update(Admin admin);

    //查询信息
    @Select("select * from admin where name like #{name}")
    List<Admin> findByName(@Param("name") String name);

    //查询信息
    @Select("select * from admin where id=#{id}")
    Admin findById(@Param("id") int id);

    @Select("select * from admin")
    List<Admin> findAll();

    //登陆
    @Select("select * from admin where name=#{name} and password = #{password}")
    List<Admin> login(Admin admin);
}
