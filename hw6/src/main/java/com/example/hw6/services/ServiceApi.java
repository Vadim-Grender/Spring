package com.example.hw6.services;

import com.example.hw6.domain.Result;

import java.util.List;

public interface ServiceApi {
    List<Result> getAllCharacters();
    List<Result> getRandomCharacters(int count);

    Result getCharacterById(Integer id);

    List<Result> getNextCharacters(int page);

    List<Result>  getPreviousCharacters(int page);
}
