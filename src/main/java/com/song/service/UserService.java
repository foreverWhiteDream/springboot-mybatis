package com.song.service;

import com.song.domain.User;

import java.util.List;


public interface UserService {

    /**
     * 添加数据
     * @param user
     * @return
     */
    public boolean save(User user);

    /**
     * 按id修改
     * @param user
     * @return
     */
    public boolean update(User user);

    /**
     * 按id删除
     * @param id
     * @return
     */
    public boolean delete(Integer id);

    /**
     * 按id查询
     * @param id
     * @return
     */
    public User getById(Integer id);


//    public List<User> getByUsername(String userName);


    /**
     * 查询全部数据
     * @return
     */
    public List<User> getAll();
}
