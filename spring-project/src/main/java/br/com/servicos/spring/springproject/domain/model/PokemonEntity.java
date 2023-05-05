package br.com.servicos.spring.springproject.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PokemonEntity {
    private long id;
    private String name;
    private Type[] types;
    private Ability[] abilities;
    private String[] spriteUrls;
    private int height;
    private int weight;
    private int baseExperience;
}
