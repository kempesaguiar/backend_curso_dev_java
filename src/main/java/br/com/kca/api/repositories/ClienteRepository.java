package br.com.kca.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.kca.api.models.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	
	@Query("Select id from Cliente where email = :email and telefone = :senha")
	public Long findByLogin(@Param("email") String email, @Param("senha") String senha);
}
