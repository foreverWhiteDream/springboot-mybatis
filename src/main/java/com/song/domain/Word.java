package com.song.domain;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("word")
@Data
public class Word {



    @TableId(type = IdType.AUTO)
    private Integer indexId;
    private String word;
    private String translation;




    public Word() {
    }

    public Word(Integer indexId, String word, String translation) {
        this.indexId = indexId;
        this.word = word;
        this.translation = translation;
    }

    public Integer getIndexId() {
        return indexId;
    }

    public void setIndexId(Integer indexId) {
        this.indexId = indexId;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    @Override
    public String toString() {
        return "Word{" +
                "indexId=" + indexId +
                ", word='" + word + '\'' +
                ", translation='" + translation + '\'' +
                '}';
    }
}
