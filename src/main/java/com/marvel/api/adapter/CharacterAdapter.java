package com.marvel.api.adapter;

import com.marvel.api.controller.dto.CharacterDto;
import com.marvel.api.controller.form.CharacterForm;
import com.marvel.api.entity.Character;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;


public class CharacterAdapter {

    public static Character characterFormToCharacter(CharacterForm characterForm){
        return Character.builder()
                .name(characterForm.getName())
                .description(characterForm.getDescription())
            .build();
    }

    public static CharacterDto characterToCharacterDto(Character character){
        return CharacterDto.builder()
                .name(character.getName())
                .description(character.getDescription())
            .build();
    }

    public static List<CharacterDto> charactersToCharactersDto(List<Character> characters) {

        return characters.stream().map(
                character -> CharacterDto.builder()
                .name(character.getName())
                .description((character.getDescription()))
            .build()
        ).collect(Collectors.toList());
    }

    public  static Page<CharacterDto> charactersPageToCharactersDtoPage (Page<Character> characters){
        return characters.map(CharacterDto::new);
    }
}
