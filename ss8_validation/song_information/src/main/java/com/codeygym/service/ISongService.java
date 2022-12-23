package com.codeygym.service;

import com.codeygym.model.Song;

import java.util.List;
import java.util.Optional;

public interface ISongService {
    List<Song> findAll();

    void add(Song song);

    void update(Song song);

    Optional<Song> findById(int id);
}
