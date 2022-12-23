package com.codeygym.controller;

import com.codeygym.dto.SongDto;
import com.codeygym.model.Song;
import com.codeygym.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/song")
public class SongController {
    @Autowired
    ISongService iSongService;

    @GetMapping("")
    public String showList(Model model){
        model.addAttribute("songList",iSongService.findAll());
        return "views/list";
    }

    @GetMapping("/add")
    public String showAdd(Model model){
        model.addAttribute("songDto", new SongDto());
        return "views/create";
    }

    @PostMapping("/add")
    public String add(@Validated SongDto songDto, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            return "views/create";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto,song);
        iSongService.add(song);
        redirectAttributes.addFlashAttribute("mess","Thêm mới thành công");
        return "redirect:/song";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable int id,Model model){
        Song song = iSongService.findById(id).orElseThrow(() -> new IllegalArgumentException("Not found"));
        SongDto songDto = new SongDto();
        BeanUtils.copyProperties(song,songDto);
        model.addAttribute("songDto", songDto);
        return "views/edit";
    }

    @PostMapping("/edit")
    public String edit(@Validated SongDto songDto, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            return "views/edit";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto,song);
        iSongService.update(song);
        redirectAttributes.addFlashAttribute("mess","Cập nhật thành công");
        return "redirect:/song";
    }
}
