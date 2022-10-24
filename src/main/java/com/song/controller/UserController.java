package com.song.controller;


import com.song.domain.User;
import com.song.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;



    @PostMapping
    public Result save(@RequestBody User user) {
        boolean flag = userService.save(user);
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR,flag,"添加数据成功");
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        boolean flag = userService.delete(id);
        return new Result(flag ? Code.DELETE_OK : Code.DELETE_ERR,flag,"删除数据成功");
    }

    @PutMapping
    public Result update(@RequestBody User user) {
        boolean flag = userService.update(user);
        return new Result(flag ? Code.UPDATE_OK: Code.UPDATE_ERR,flag,"更新数据成功");
    }


    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        User user = userService.getById(id);
        Integer code = user != null?Code.GET_OK:Code.GET_ERR;
        String msg = user != null?"id查询成功":"数据请求失败";
        return new Result(code,user,msg);

    }


//    @GetMapping("/{username}")
//    public Result getByUsername(@PathVariable String username) {
//        List<User> user = userService.getByUsername(username);
//        Integer code = user != null?Code.GET_OK:Code.GET_ERR;
//        String msg = user != null?"id查询成功":"数据请求失败";
//        return new Result(code,user,msg);
//
//    }



    @GetMapping
    public Result getAll() {
        List<User> all = userService.getAll();
        Integer code = all != null?Code.GET_OK:Code.GET_ERR;
        String msg = all != null?"查询全部成功":"数据请求失败";
        return new Result(code,all,msg);
    }

}
