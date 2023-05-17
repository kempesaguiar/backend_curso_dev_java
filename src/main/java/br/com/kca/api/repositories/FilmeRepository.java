package br.com.kca.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.kca.api.models.Filme;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long> {

}
