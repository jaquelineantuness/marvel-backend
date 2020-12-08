package com.marvel.api.service;

import com.marvel.api.config.ApiErrorEnum;
import com.marvel.api.entity.Character;
import com.marvel.api.repository.CharacterRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class CharacterService {

    final CharacterRepository repository;

    public CharacterService(CharacterRepository repository) {
        this.repository = repository;
    }

    public Page<Character> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Optional<Character> findById(Integer id) {
        Optional<Character> character = repository.findById(id);
        if(!character.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ApiErrorEnum.RECORD_NOT_FOUND_MESSAGE.getDescricao());
        }
        return repository.findById(id);
    }

    public Character save(Character character) {
        for(Character characterfor : repository.findAll()){
            if(character.getName().equals(characterfor.getName())){
                throw new ResponseStatusException(HttpStatus.CONFLICT,ApiErrorEnum.RECORD_IS_EXIST.getDescricao());
            }
        }
        return repository.save(character);
    }

    public Character put(Character character) {
        if (!repository.findById(character.getId()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ApiErrorEnum.RECORD_NOT_FOUND_MESSAGE.getDescricao());
        }
        return repository.save(character);
    }

    public boolean patch(Integer id) {

       Optional<Character> character = repository.findById(id);
        if(!character.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ApiErrorEnum.RECORD_NOT_FOUND_MESSAGE.getDescricao());
        }
       character.get().setActive(atualizaStatus(character.get()));
       repository.save(character.get());
       return repository.getOne(id).isActive();
    }

    public void delete(Integer id) {
        Optional<Character> character = repository.findById(id);
        if(!character.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ApiErrorEnum.RECORD_NOT_FOUND_MESSAGE.getDescricao());
        }
        repository.deleteById(id);
    }

    private boolean atualizaStatus(Character character){
        if (character.isActive())
            return false;
        return true;
    }
}
