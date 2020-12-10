package com.marvel.api.controller;

import com.marvel.api.adapter.CharacterAdapter;
import com.marvel.api.controller.dto.CharacterDto;
import com.marvel.api.controller.form.CharacterForm;
import com.marvel.api.entity.Character;
import com.marvel.api.service.CharacterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/characters")
public class CharacterController {

    final CharacterService service;

    public CharacterController(CharacterService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Page<CharacterDto>> findAll(
            @PageableDefault(sort = "name",direction = Sort.Direction.ASC,page=0, size = 1)Pageable pageable){
        Page<CharacterDto> characterDtos = CharacterAdapter.charactersPageToCharactersDtoPage(service.findAll(pageable));
        return ResponseEntity.ok(characterDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Character>> findById(@Parameter(name = "Character id", example = "1", required = true)
                                                            @PathVariable Integer id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    @Operation(summary = "Create character", description = "This method creates a new character")
    public ResponseEntity<CharacterDto> save(@Valid @RequestBody CharacterForm character){
        CharacterDto characterDto = CharacterAdapter.characterToCharacterDto(service.save(CharacterAdapter.characterFormToCharacter(character)));
        return ResponseEntity.status(HttpStatus.CREATED).body(characterDto);
    }

    @PatchMapping("/{id}/status")
    public boolean patch(@PathVariable Integer id) {
        return service.patch(id);
    }

    // TODO Receber Form e Devolver DTO
    @PutMapping("/{id}")
    public ResponseEntity<CharacterDto> put(@Parameter(name = "Character id", example = "1", required = true)
                                             @PathVariable Integer id,@Valid @RequestBody CharacterForm characterForm){
        characterForm.setId(id);
        CharacterDto characterDto = CharacterAdapter.characterToCharacterDto(service.put(CharacterAdapter.characterFormToCharacter(characterForm)));
        return ResponseEntity.status(HttpStatus.OK).body(characterDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@Parameter(name = "Character id", example = "1", required = true)
                                           @PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
