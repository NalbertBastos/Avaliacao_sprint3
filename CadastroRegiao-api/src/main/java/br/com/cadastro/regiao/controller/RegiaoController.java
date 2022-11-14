package br.com.cadastro.regiao.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cadastro.regiao.Dto.DetalhesDoEstado;
import br.com.cadastro.regiao.modelo.Estado;
import br.com.cadastro.regiao.modelo.Regiao;
import br.com.cadastro.regiao.repository.EstadoRepository;

@RestController
@RequestMapping("/api/states/region")
public class RegiaoController {
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@GetMapping("/{regiao}")
	@Cacheable(value = "listaDeEstados")
	public ResponseEntity<Object> getEstado(@PathVariable Regiao regiao) {
		
		Optional<Estado> estados = estadoRepository.findByRegiao(regiao);
		
		if(estados.isPresent()) {
			return ResponseEntity.ok(new DetalhesDoEstado(estados.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping
	public List<Estado> mostrar(){
		Sort sort = Sort.by("populacao","area").ascending();
		
		return estadoRepository.findAll(sort);
		
	}

}
