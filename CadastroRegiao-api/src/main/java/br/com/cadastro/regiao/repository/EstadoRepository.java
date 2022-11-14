package br.com.cadastro.regiao.repository;

import java.util.Optional;

//import java.util.List;

//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import br.com.cadastro.regiao.modelo.Estado;
//import br.com.cadastro.regiao.modelo.Regiao;
import br.com.cadastro.regiao.modelo.Regiao;


@Repository
public interface EstadoRepository extends JpaRepository<Estado,Long>{
	
	Estado findByNome(String nome);
    Optional<Estado> findByRegiao(Regiao regiao);




	


}
