package com.marvel.api.service;

import com.marvel.api.entity.Character;
import com.marvel.api.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterService {

    @Autowired
    CharacterRepository repository;

    public Character save(Character character) {
        return repository.save(character);
    }

    public List<Character> findAll() {
        return repository.findAll();
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public Optional<Character> findById(Integer id) {
        return repository.findById(id);
    }

    public Character put(Character character) {
        Character characterSave = null;
        if (repository.findById(character.getId()).isPresent()) {
            characterSave = repository.save(character);
        }
        return characterSave;

    }

    public boolean patch(Integer id) {

       Optional<Character> character = repository.findById(id);

       character.get().setActive(atualizaStatus(character.get()));
       repository.save(character.get());
       return repository.getOne(id).isActive();
    }
    private boolean atualizaStatus(Character character){
        if (character.isActive()) {
            return false;
        }
        return true;
    }
}
