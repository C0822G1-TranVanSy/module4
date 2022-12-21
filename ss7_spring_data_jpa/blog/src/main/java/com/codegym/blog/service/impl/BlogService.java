package com.codegym.blog.service.impl;

import com.codegym.blog.model.Blog;
import com.codegym.blog.repository.IBlogRepository;
import com.codegym.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public void add(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void edit(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Optional<Blog> findById(int id) {
        return blogRepository.findById(id);
    }

    @Override
    public void delete(int id) {
        blogRepository.deleteById(id);
    }


}
