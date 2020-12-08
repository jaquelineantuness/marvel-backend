package com.marvel.api.controller;

import com.marvel.api.adapter.CharacterAdapter;
import com.marvel.api.controller.dto.CharacterDto;
import com.marvel.api.controller.form.CharacterForm;
import com.marvel.api.entity.Character;
import com.marvel.api.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/character")
public class CharacterController {

    @Autowired
    CharacterService service;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @GetMapping
    public ResponseEntity<Page<CharacterDto>> findAll(
            @PageableDefault(sort = "name",direction = Sort.Direction.ASC,page=0, size = 1)Pageable pageable){
        Page<CharacterDto> characterDtos = CharacterAdapter.charactersPageToCharactersDtoPage(service.findAll(pageable));
        return ResponseEntity.ok(characterDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Character>> findById(@PathVariable Integer id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<CharacterDto> save(@Valid @RequestBody CharacterForm character){
        CharacterDto characterDto = CharacterAdapter.characterToCharacterDto(service.save(CharacterAdapter.characterFormToCharacter(character)));
        return ResponseEntity.status(HttpStatus.CREATED).body(characterDto);
        
    }
    @PutMapping("/{id}")
    public ResponseEntity<Character> put(@PathVariable Integer id, @RequestBody Character character){
        character.setId(id);
        return ResponseEntity.ok(service.put(character));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/status")
    public boolean patch(@PathVariable Integer id) {
        return service.patch(id);

    }
}
