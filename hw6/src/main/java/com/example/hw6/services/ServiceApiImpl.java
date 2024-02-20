package com.example.hw6.services;

import com.example.hw6.domain.Result;
import com.example.hw6.domain.Characters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
public class ServiceApiImpl implements ServiceApi {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HttpHeaders httpHeaders;

    @Value("${character.api.url}")
    private String CHARACTER_API;

    @Override
    public List<Result> getAllCharacters() {
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
        ResponseEntity<Characters> response = restTemplate.exchange(CHARACTER_API, HttpMethod.GET, entity,
                Characters.class);
        return response.getBody().getResults();
    }


    @Override
    public List<Result> getRandomCharacters(int count) {
        List<Result> allCharacters = getAllCharacters();
        Collections.shuffle(allCharacters);
        return allCharacters.subList(0, count);
    }


    @Override
    public Result getCharacterById(Integer id) {
        String characterUrl = CHARACTER_API + "/" + id;
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
        ResponseEntity<Result> response = restTemplate.exchange(characterUrl, HttpMethod.GET, entity, Result.class);
        return response.getBody();
    }

    @Override
    public List<Result> getNextCharacters(int page) {
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
        ResponseEntity<Characters> response = restTemplate.exchange(CHARACTER_API + "/?page=" + page, HttpMethod.GET,
                entity,
                Characters.class);
        return response.getBody().getResults();
    }

    @Override
    public List<Result> getPreviousCharacters(int page) {
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
        ResponseEntity<Characters> response = restTemplate.exchange(CHARACTER_API + "/?page=" + page, HttpMethod.GET,
                entity,
                Characters.class);
        return response.getBody().getResults();
    }
}
