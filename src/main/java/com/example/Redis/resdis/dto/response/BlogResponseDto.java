package com.example.Redis.resdis.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BlogResponseDto {
    private String title;
    private String description;
    private Boolean isDeleted;
    private LocalDate releaseDate;
}
