package com.song.service.Impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.song.domain.Word;
import com.song.mapper.WordMapper;
import com.song.service.WordMapperService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class WordMapperServiceImpl implements WordMapperService {

    @Resource
    private WordMapper wordMapper;

    @Override
    public boolean save(Word word) {
        wordMapper.insert(word);
        return true;
    }

    @Override
    public boolean update(Word word) {
        wordMapper.updateById(word);
        return true;
    }

    @Override
    public boolean delete(Integer id) {
        wordMapper.deleteById(id);
        return true;
    }

    @Override
    public Word getById(Integer id) {
        Word word = wordMapper.selectById(id);
        return word;
    }

    @Override
    public List<Word> getAll() {
        List<Word> words = wordMapper.selectList(null);
        return words;
    }

    @Override
    public Page page(Integer pageNum, Integer pageSize, String search) {
        LambdaQueryWrapper<Word> wrapper = Wrappers.lambdaQuery();
    if (StrUtil.isNotBlank(search)){

//        判断是否为全英文
        if (search.matches("[a-zA-Z]+")){
            wrapper.like(Word::getWord, search);
        }
        else {//不是全英文则判断汉字
            wrapper.like(Word::getTranslation, search);
        }

        }
        Page selectPage = wordMapper.selectPage(new Page(pageNum, pageSize),wrapper);

        return  selectPage;
    }
}
