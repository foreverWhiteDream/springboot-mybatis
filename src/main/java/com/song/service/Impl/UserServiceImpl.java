package com.song.service.Impl;

import com.song.dao.UserDao;
import com.song.domain.User;
import com.song.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired//自动从spring容器中取得代理对象
    private UserDao userDao;

    public boolean save(User user) {
        userDao.save(user);
        return true;
    }

    public boolean update(User user) {
        userDao.update(user);
        return true;
    }

    public boolean delete(Integer id) {
        userDao.delete(id);
        return true;
    }

    public User getById(Integer id) {
        return userDao.getById(id);
    }


//    public List<User> getByUsername(String userName) {
//
//        return userDao.getByUsername(userName);
//    }

    public List<User> getAll() {
        return userDao.getAll();
    }

}
