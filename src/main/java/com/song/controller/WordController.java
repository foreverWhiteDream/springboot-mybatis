package com.song.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.song.domain.Word;
import com.song.service.WordMapperService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@CrossOrigin
@RestController
@RequestMapping("/words")
public class WordController {

//    @Autowired
//    private WordService wordService;

    @Resource
    private WordMapperService wordMapperService;


//增
    @PostMapping
    public Result<?> save(@RequestBody Word word) {
        boolean flag = wordMapperService.save(word);
        return new Result<>(flag ? Code.SAVE_OK : Code.SAVE_ERR,"添加数据成功");
    }

//    删
    @DeleteMapping("/{indexId}")
    public Result<?> delete(@PathVariable Integer indexId) {
        boolean flag = wordMapperService.delete(indexId);
        return new Result<>(flag ? Code.DELETE_OK : Code.DELETE_ERR,"删除数据成功");
    }



//改
    @PutMapping
    public Result<?> update(@RequestBody Word word) {
        boolean flag = wordMapperService.update(word);
        return new Result<>(flag ? Code.UPDATE_OK: Code.UPDATE_ERR,"更新数据成功");
    }
//
//
//按id查
    @GetMapping("/{indexId}")
    public Result<Word> getById(@PathVariable Integer indexId) {
        Word word = wordMapperService.getById(indexId);
        Integer code = word != null?Code.GET_OK:Code.GET_ERR;
        String msg = word != null?"id查询成功":"数据请求失败";
        return new Result<Word>(code,word,msg);

    }


//    @GetMapping("/{username}")
//    public Result getByUsername(@PathVariable String username) {
//        List<User> user = userService.getByUsername(username);
//        Integer code = user != null?Code.GET_OK:Code.GET_ERR;
//        String msg = user != null?"id查询成功":"数据请求失败";
//        return new Result(code,user,msg);
//
//    }



//    @GetMapping
//    public Result<?> getAll() {
//        List<Word> all = wordMapperService.getAll();
//        Integer code = all != null?Code.GET_OK:Code.GET_ERR;
//        String msg = all != null?"查询全部成功":"数据请求失败";
//        return new Result(code,all,msg);
//    }


    @GetMapping
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer pageNum,//查询第几页
                              @RequestParam(defaultValue = "15") Integer pageSize,//一页多少个
                              @RequestParam(defaultValue = "")String search) {//搜索值

    Page<Word> page = wordMapperService.page(pageNum, pageSize, search);

    return new Result<>(Code.GET_OK, page, "请求成功");
}
//
//
//    LambdaQueryWrapper<Word> wrapper = Wrappers.lambdaQuery();
//    if (StrUtil.isNotBlank(search)){
//            wrapper.like(Word::getWord, search);
//        }
//
//    Page<Word> wordPage = wordMapper.selectPage(new Page<>(pageNum, pageSize), wrapper);
//
//
//
//        return Result.success(wordPage);
//    }

}
