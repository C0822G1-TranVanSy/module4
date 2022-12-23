package com.codeygym.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SongDto {
    private int id;
    @NotBlank(message = "Không được để trống")
    @Size(max=800, message = "Không được vượt quá 800 ký tự")
    @Pattern(regexp = "[a-zA-Z ]+",message = "Không được ký tự đặc biệt & số")
    private String name;
    @NotBlank(message = "Không được để trống")
    @Size(max=300, message = "Không được vượt quá 300 ký tự")
    @Pattern(regexp = "[a-zA-Z ]+",message = "Không được ký tự đặc biệt & số")
    private String singer;
    @NotBlank(message = "Không được để trống")
    @Size(max=1000, message = "Không được vượt quá 100 ký tự")
    @Pattern(regexp = "[a-zA-Z ,]+",message = "Không được ký tự đặc biệt & số(ngoài dấu ,)")
    private String kindOfMusic;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getKindOfMusic() {
        return kindOfMusic;
    }

    public void setKindOfMusic(String kindOfMusic) {
        this.kindOfMusic = kindOfMusic;
    }
}
