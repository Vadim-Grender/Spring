package com.example.hw6.domain;

import lombok.Data;

import java.util.List;

@Data
public class Characters {
    private Info info;
    private List<Result> results;
}
