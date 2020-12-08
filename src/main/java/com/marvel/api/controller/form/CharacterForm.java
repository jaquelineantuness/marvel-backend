package com.marvel.api.controller.form;

import io.swagger.annotations.ApiModelProperty;
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

    @ApiModelProperty(notes = "Name" , position = 2, name = "Name", dataType = "String", example = "Super-man", required = true)
    private String name;
    @ApiModelProperty(notes = "Name" , position = 2, name = "Name", dataType = "String", example = "Super-man", required = true)
    private String description;
}
