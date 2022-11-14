package br.com.cadastro.regiao.Dto;

import org.springframework.data.domain.Page;

import br.com.cadastro.regiao.modelo.Estado;
import br.com.cadastro.regiao.modelo.Regiao;

public class EstadoDto {
	
	private Long id;
	private String nome;
	private String capital;
	private Regiao regiao;
	private int populacao;
	private int area;

	public EstadoDto(Estado estado) {
		this.id = estado.getId();
		this.nome = estado.getNome();
		this.capital = estado.getCapital();
		this.regiao = estado.getRegiao();
		this.populacao = estado.getPopulacao();
		this.area = estado.getArea();
	
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCapital() {
		return capital;
	}

	public Regiao getRegiao() {
		return regiao;
	}

	public int getPopulacao() {
		return populacao;
	}

	public int getArea() {
		return area;
	}
	
    public static Page<EstadoDto> converter(Page<Estado> estados) {
		
		return estados.map(EstadoDto::new);
	}

}
