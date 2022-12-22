package com.codegym.blog.service;

import com.codegym.blog.model.Blog;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    List<Blog> findAll();

    boolean add(Blog blog);

    boolean edit(Blog blog);

    Optional<Blog> findById(int id);

    void delete(int id);
}
