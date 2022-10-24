package com.song.service.bak;

import com.song.domain.Word;
import com.song.mapper.WordMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class WordServiceImpl  {

//    @Autowired//自动从spring容器中取得代理对象
    @Resource
    private WordMapper wordMapper;

    public boolean save(Word word) {
        wordMapper.insert(word);
//        wordMapper.selectPage()
        return true;
    }
//
//    public boolean update(Word word) {
//        wordMapper.update();
//        return true;
//    }
//
//    public boolean delete(Integer id) {
//        wordMapper.delete(id);
//        return true;
//    }
//
//    public Word getById(Integer id) {
//        return wordMapper.getById(id);
//    }
//
//
////    public List<User> getByUsername(String userName) {
////
////        return userDao.getByUsername(userName);
////    }
//
//    public List<Word> getAll() {
//        return wordMapper.getAll();
//    }

}
