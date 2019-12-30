package com.bbx.jc.park.mapper;

import com.bbx.jc.park.entity.Park;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ParkMapper {


    @Select("select * from park")
    List<Park> findAllPark();

    @Select("select * from park where  status = #{status}")
    List<Park> findAllParkByKey(@Param("status") int status);

    @Select("select * from park where  name like #{key}")
    List<Park> findParkByKey(@Param("key") String key);

    @Select("select * from park where id=#{id}")
    Park findCarById(@Param("id") int id);

    //添加信息
    @Insert("insert into park(name,price,status) values(#{name},#{price},0)")
    void insertCar(Park car);

    //删除信息
    @Delete("delete from park where id=#{id}")
    void deleteCar(int id);

    @Update("update park set status=#{status} where id=#{id}")
    void updateCarStatus(Park car);

    //修改信息
    @Update("update park set name=#{name},price=#{price} where id=#{id}")
    void updateCar(Park car);
}
