package br.com.kca.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.kca.api.models.Locacao;

@Repository
public interface LocacaoRepository extends JpaRepository<Locacao, Long> {

}
