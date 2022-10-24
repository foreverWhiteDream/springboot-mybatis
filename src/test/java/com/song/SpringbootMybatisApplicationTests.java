package com.song;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.song.dao.UserDao;
import com.song.domain.User;
import com.song.service.WordMapperService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
class SpringbootMybatisApplicationTests {


    @Autowired
    WordMapperService wordMapperService;

    @Test
    void getById() {
        wordMapperService.getById(1);

    }

    @Test
    void getAll(){
        wordMapperService.getAll();
    }


    @Test
    void page(){
        Page page = wordMapperService.page(1, 10, "");
        System.out.println(page.getRecords());
    }

}
