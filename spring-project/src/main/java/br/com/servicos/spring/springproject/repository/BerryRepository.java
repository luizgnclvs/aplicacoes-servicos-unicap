package br.com.servicos.spring.springproject.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.servicos.spring.springproject.domain.model.BerryEntity;

public interface BerryRepository extends PagingAndSortingRepository<BerryEntity, Long> {
    
}
