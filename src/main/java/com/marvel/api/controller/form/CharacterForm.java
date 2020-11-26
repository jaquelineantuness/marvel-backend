package com.marvel.api.controller.form;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CharacterForm {
    @NotNull(message = "{field.name.required}")
    @NotBlank(message = "{field.name.not.be.empty}")
    private String name;
    private String description;
}
