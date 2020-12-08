package com.marvel.api.repository.data.sample;
import com.marvel.api.entity.Character;

import java.util.Arrays;
import java.util.List;


public class LoadSamples {

    public static List<Character> loadCharacter(){
        return Arrays.asList(
                Character.builder()
                        .name("Hulk")
                        .description("strong")
                        .build(),
                Character.builder()
                        .name("Spider-Man")
                        .description("fly")
                        .build()
        );
    }
}
