package br.com.servicos.spring.springproject.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.servicos.spring.springproject.domain.model.PokemonEntity;

public interface PokemonRepository extends PagingAndSortingRepository<PokemonEntity, Long> {
    
}
