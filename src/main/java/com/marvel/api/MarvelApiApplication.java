package com.marvel.api;

import com.marvel.api.entity.Character;
import com.marvel.api.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class MarvelApiApplication  extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(MarvelApiApplication.class, args);
	}
}
