package br.com.cadastro.regiao.form;

import br.com.cadastro.regiao.modelo.Estado;
import br.com.cadastro.regiao.modelo.Regiao;
import br.com.cadastro.regiao.repository.EstadoRepository;

public class AtualizacaoEstadoform {
	
	private String nome;
	private String capital;
	private Regiao regiao;
	private int populacao;
	private int area;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public Regiao getRegiao() {
		return regiao;
	}

	public void setRegiao(Regiao regiao) {
		this.regiao = regiao;
	}

	public int getPopulacao() {
		return populacao;
	}

	public void setPopulacao(int populacao) {
		this.populacao = populacao;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public Estado atualizar(Long id, EstadoRepository estadoRepository) {
		Estado estado = estadoRepository.getOne(id);
		estado.setNome(this.nome);
		estado.setCapital(this.capital);
		estado.setRegiao(this.regiao);
		estado.setPopulacao(this.populacao);
		estado.setArea(this.area);
		
		return estado;
	}
	
	

}
