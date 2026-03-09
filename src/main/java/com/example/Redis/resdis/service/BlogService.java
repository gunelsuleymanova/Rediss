package com.example.Redis.resdis.service;

import com.example.Redis.resdis.dao.entity.BlogEntity;
import com.example.Redis.resdis.dao.repos.BlogRepository;
import com.example.Redis.resdis.dto.request.BlogRequestDto;
import com.example.Redis.resdis.dto.response.BlogResponseDto;
import com.example.Redis.resdis.exception.NotFoundBlogException;
import com.example.Redis.resdis.mapper.BlogMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {
    private final BlogMapper blogMapper;
    private final BlogRepository blogRepository;
    private final RedisService redisService;
    private static final String BLOG_KEY= "Blog";


    public BlogResponseDto getblog(Long id){
        BlogResponseDto d = (BlogResponseDto) redisService.get(BLOG_KEY + ":" + id);
        if(d!=null){
            return d;
        }
        BlogResponseDto b= blogMapper.entityToDto( blogRepository.findById(id).orElseThrow(()->new NotFoundBlogException("bu blog yoxdur")));
        redisService.set(BLOG_KEY + ":" + id, b);
        return b;

    }

public List<BlogResponseDto> getblogs(){
        List<BlogResponseDto> dd=(List<BlogResponseDto>) redisService.get(BLOG_KEY);
        if(dd!=null){
            return dd;
        }
        List<BlogResponseDto> ddd= blogMapper.entityToDtoList(blogRepository.findAll());
        redisService.set(BLOG_KEY,ddd);
        return  ddd;
}



//rediis olmadan

    public void saveBlog(BlogRequestDto d){
        blogRepository.save(blogMapper.dtoToEntity(d));
    }


    public BlogResponseDto getBlog(Long id){
        return blogMapper.entityToDto(blogRepository.findById(id).orElseThrow(()->new NotFoundBlogException("Bu id li blog tapilmadi ")));
    }

    public List<BlogResponseDto> getAllBlog(){
        return blogMapper.entityToDtoList(blogRepository.findAll());
    }

    public void deleteb(Long id){
        BlogEntity a= blogRepository.findById(id).orElseThrow(()->new NotFoundBlogException("bu blog yoxdurrrr"));
        a.setIsDeleted(true);
        blogRepository.save(a);
    }

    public void update(Long id,String data){
        redisService.delete(BLOG_KEY);
        BlogEntity c= blogRepository.findById(id).orElseThrow(()->new NotFoundBlogException("blpg yoxdukiii"));
        c.setDescription(data);
        blogRepository.save(c);
        redisService.set(BLOG_KEY+":"+id,c);

    }


}
