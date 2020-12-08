package com.marvel.api.controller.dto;

import com.marvel.api.entity.Character;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CharacterDto {
    private String name;
    private String description;
    private Integer id;


    public CharacterDto(Character character){
        this.id=character.getId();
        this.name=character.getName();
        this.description= character.getDescription();
    }
}
