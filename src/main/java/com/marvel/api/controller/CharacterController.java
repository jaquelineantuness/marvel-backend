package com.marvel.api.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.marvel.api.adapter.CharacterAdapter;
import com.marvel.api.controller.dto.CharacterDto;
import com.marvel.api.controller.form.CharacterForm;
import com.marvel.api.entity.Character;
import com.marvel.api.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class CharacterController {

    @Autowired
    CharacterService service;

    @GetMapping
    public ResponseEntity<Page<CharacterDto>> findAll(
            @PageableDefault(sort = "name",direction = Sort.Direction.ASC,page=0, size = 1)Pageable pageable){
        return ResponseEntity.ok(
                CharacterAdapter.charactersPageToCharactersDtoPage(service.findAll(pageable)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Character>> findById(@PathVariable Integer id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<CharacterDto> save(@Valid @RequestBody CharacterForm character){
        return ResponseEntity.ok(CharacterAdapter.characterToCharacterDto(service.save(CharacterAdapter.characterFormToCharacter(character))));
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
