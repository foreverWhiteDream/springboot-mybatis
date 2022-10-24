package com.song.service;

import com.song.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



import java.util.List;

@SpringBootTest
public class UserServiceTest {
@Autowired
    private UserService userService;


    @Test
    public void testGetById(){
    User user = userService.getById(1);
    System.out.println(user);
    }


    @Test
    public void testGetAll(){
        List<User> all = userService.getAll();
        System.out.println(all);
    }
}
