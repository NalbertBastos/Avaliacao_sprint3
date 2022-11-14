package br.com.cadastro.regiao.controller;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Sort;

import br.com.cadastro.regiao.Dto.DetalhesDoEstado;
import br.com.cadastro.regiao.Dto.EstadoDto;
import br.com.cadastro.regiao.form.AtualizacaoEstadoform;
import br.com.cadastro.regiao.modelo.Estado;
import br.com.cadastro.regiao.modelo.Regiao;
import br.com.cadastro.regiao.repository.EstadoRepository;
//import net.bytebuddy.asm.Advice.OffsetMapping.Sort;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;



@RestController
@RequestMapping("/api/states")
public class EstadoController {
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	
	@GetMapping("/{id}")
	public ResponseEntity<DetalhesDoEstado> Listar(@PathVariable Long id) {
		Optional<Estado> estado = estadoRepository.findById(id);
		if(estado.isPresent()) {
			return ResponseEntity.ok(new DetalhesDoEstado(estado.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	
	

	@GetMapping
	public List<Estado> mostrar(){
		Sort sort = Sort.by("populacao","area").ascending();
		
		return estadoRepository.findAll(sort);
		
	}
	
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Estado adicionar(@RequestBody Estado estado) {
		return estadoRepository.save(estado);
	}
	
	@PutMapping("/{id}")
	@Transactional
	@CacheEvict(value = "listaDeEstados", allEntries = true)
	public ResponseEntity<EstadoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoEstadoform form ){
		Optional<Estado> optional = estadoRepository.findById(id);
		if(optional.isPresent()) {
			Estado estado = form.atualizar(id,estadoRepository);
			return ResponseEntity.ok(new EstadoDto(estado));
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	@CacheEvict(value = "listaDeEstados", allEntries = true)
	public ResponseEntity<?> remover(@PathVariable Long id){
		Optional<Estado> optional = estadoRepository.findById(id);
		if(optional.isPresent()) {
			estadoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
	
	

}
