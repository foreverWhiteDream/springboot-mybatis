package com.song.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.song.controller.Result;
import com.song.domain.Word;
import org.springframework.stereotype.Service;

import java.util.List;


public interface WordMapperService {

    /**
     * 添加数据
     * @param word
     * @return
     */
    public boolean save(Word word);

    /**
     * 按id修改
     * @param word
     * @return
     */
    public boolean update(Word word);

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
    public Word getById(Integer id);


//    public List<User> getByUsername(String userName);


    /**
     * 查询全部数据
     * @return
     */
    public List<Word> getAll();


    /**
     * 分页查询
     */
    public Page page(Integer pageNum, Integer pageSize, String search);

}
