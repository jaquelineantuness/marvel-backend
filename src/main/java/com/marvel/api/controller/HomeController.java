package com.marvel.api.controller;

import com.marvel.api.entity.Character;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {
    @GetMapping
    public Character home(){
        Character character = new Character();

        character.setName("Hulk2");
//       character.setName("Iron Man");
//        character.setDescription("aceedfew");
        return character;
    }
}
