package com.marvel.api.controller.form;

import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(example = "Super-man", required = true)
    private String name;

    @Schema(example = "The stronguest", required = true)
    private String description;
}
