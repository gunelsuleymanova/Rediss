package com.example.Redis.resdis.rest;

import com.example.Redis.resdis.dto.request.BlogRequestDto;
import com.example.Redis.resdis.dto.response.BlogResponseDto;
import com.example.Redis.resdis.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/blog")
public class BlogController {
    private final BlogService blogService;

    @GetMapping("/get/{id}")
    public BlogResponseDto getb(@PathVariable Long id){
        return blogService.getblog(id);
    }

    @GetMapping("/gets")
    public List<BlogResponseDto> getsb(){
        return blogService.getblogs();
    }
    @DeleteMapping("/del/{id}")
    public String deleteb(@PathVariable Long id){
        blogService.deleteb(id);
        return "silindi";
    }

    @PostMapping("add")
    public void save(@RequestBody BlogRequestDto h){
        blogService.saveBlog(h);
    }

    @PutMapping("/put/{id}/{data}")
    public String update(@PathVariable Long id,@PathVariable String data){
        blogService.update(id,data);
        return "deyisiklik icra olsundu";
    }



}
