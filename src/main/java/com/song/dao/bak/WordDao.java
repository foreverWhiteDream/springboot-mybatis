package com.song.dao.bak;



import com.song.domain.Word;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface WordDao {

    @ResultMap("wordMap")
    @Insert("insert into word value(null,#{word.word},#{user.translation})")
    //    增
    public void save(@Param("word") Word word);



    @ResultMap("wordMap")
    @Delete("delete from word where id=#{id}")
    //      删
    public void delete(Integer id);



    @ResultMap("wordMap")
    @Update("update word set word=#{word}, translation=#{translation} where indexId=#{index_ID}")
    //    改
    public void update(Word word);



    @Results(id = "wordMap",value = {
            @Result(column = "index_ID",property = "indexId",id = true)
    })
    @Select("select * from word where index_ID=#{indexId}")
//    按id查询用户
    public Word getById(Integer id);


//    查询用户名是否已经被使用
//    @Select("select * from user where user_name = #{userName}")
//    public List<User> getByUsername(String userName);

    //    查询全部用户
    @ResultMap("wordMap")
    @Select("select * from word")
    public List<Word> getAll();



}
