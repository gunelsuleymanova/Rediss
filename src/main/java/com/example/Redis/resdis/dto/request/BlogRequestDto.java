package com.example.Redis.resdis.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BlogRequestDto {
    private String owner;
    private String title;
    private String description;
}
