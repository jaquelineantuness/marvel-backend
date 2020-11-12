package com.marvel.api.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.marvel.api.entity.Character;
import com.marvel.api.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class CharacterController {

    @Autowired
    CharacterService service;

    @GetMapping
    public ResponseEntity<List<Character>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Character>> findById(@PathVariable Integer id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Character> save(@RequestBody Character character){
        return ResponseEntity.ok(service.save(character));
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
