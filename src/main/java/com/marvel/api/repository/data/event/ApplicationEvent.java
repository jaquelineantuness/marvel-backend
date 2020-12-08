package com.marvel.api.repository.data.event;

import com.marvel.api.repository.CharacterRepository;
import com.marvel.api.repository.data.sample.LoadSamples;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class ApplicationEvent implements ApplicationListener<ContextRefreshedEvent> {

    private final CharacterRepository characterRepository;

    public ApplicationEvent(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        LoadSamples.loadCharacter()
                .stream()
                .forEach(c ->
                        characterRepository.save(c)
                );
    }
}

