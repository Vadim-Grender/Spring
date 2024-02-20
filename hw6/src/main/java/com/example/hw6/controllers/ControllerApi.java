package com.example.hw6.controllers;

import com.example.hw6.domain.Result;
import com.example.hw6.services.ServiceApi;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/")
public class ControllerApi {

    private final ServiceApi apiService;


    @GetMapping("/start")
    public String showCharacters(Model model) {
        List<Result> characters = apiService.getAllCharacters();
        model.addAttribute("characters", characters);
        return "characters";
    }


    @GetMapping("/")
    public String showRandomCharacters(Model model) {
        List<Result> characters = apiService.getRandomCharacters(10);
        model.addAttribute("characters", characters);
        return "characters";
    }

    @GetMapping("/next")
    public String showNextCharacters(Model model, HttpSession session) {
        Integer nextPage = (Integer) session.getAttribute("nextPage");
        if (nextPage == null) {
            nextPage = 1;
        }
        List<Result> characters = apiService.getNextCharacters(nextPage);
        model.addAttribute("characters", characters);
        session.setAttribute("nextPage", nextPage + 1);
        return "characters";
    }

    @GetMapping("/prev")
    public String showPreviousCharacters(Model model, HttpSession session) {
        Integer prevPage = (Integer) session.getAttribute("prevPage");
        if (prevPage == null) {
            prevPage = 1;
        }
        List<Result> characters = apiService.getPreviousCharacters(prevPage);
        model.addAttribute("characters", characters);
        session.setAttribute("prevPage", prevPage - 1);
        return "characters";
    }



    @GetMapping("/{id}")
    public String showCharacterDetails(@PathVariable("id") Integer id, Model model) {
        Result character = apiService.getCharacterById(id);
        model.addAttribute("character", character);
        return "character";
    }
}