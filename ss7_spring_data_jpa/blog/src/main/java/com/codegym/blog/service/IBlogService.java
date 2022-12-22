package com.codegym.blog.service;

import com.codegym.blog.model.Blog;
import com.codegym.blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    List<Blog> findAll();

    boolean add(Blog blog);

    boolean edit(Blog blog);

    Optional<Blog> findById(int id);

    void delete(int id);

    Page<Blog> findBlogByTitleContaining(String title, Pageable pageable);

    Page<Blog> selectByCategory(int categoryId,Pageable pageable);

}
