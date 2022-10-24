package com.song.dao;

import com.song.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface UserDao {



    @ResultMap("userMap")
    @Insert("insert into user value(null,#{user.userName},#{user.password})")
    //    增
    public void save(@Param("user") User user);



    @ResultMap("userMap")
    @Delete("delete from user where id=#{id}")
    //      删
    public void delete(Integer id);



    @ResultMap("userMap")
    @Update("update user set user_name=#{userName}, password=#{password} where id=#{id}")
    //    改
    public void update(User user);



    @Results(id = "userMap",value = {
            @Result(column = "user_name",property = "userName",id = true)
    })
    @Select("select * from user where id=#{id}")
//    按id查询用户
    public User getById(Integer id);


//    查询用户名是否已经被使用
//    @Select("select * from user where user_name = #{userName}")
//    public List<User> getByUsername(String userName);

//    查询全部用户
    @ResultMap("userMap")
    @Select("select * from user")
    public List<User> getAll();



}
