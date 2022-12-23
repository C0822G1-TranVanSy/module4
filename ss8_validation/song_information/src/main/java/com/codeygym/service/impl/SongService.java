package com.codeygym.service.impl;

import com.codeygym.model.Song;
import com.codeygym.repository.ISongRepository;
import com.codeygym.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongService implements ISongService {
    @Autowired
    ISongRepository iSongRepository;


    @Override
    public List<Song> findAll() {
        return iSongRepository.findAll();
    }

    @Override
    public void add(Song song) {
        iSongRepository.save(song);
    }

    @Override
    public void update(Song song) {
        iSongRepository.save(song);
    }

    @Override
    public Optional<Song> findById(int id) {
        return iSongRepository.findById(id);
    }
}
