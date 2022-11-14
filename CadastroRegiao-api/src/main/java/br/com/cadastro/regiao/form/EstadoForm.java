package br.com.cadastro.regiao.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.cadastro.regiao.modelo.Estado;
import br.com.cadastro.regiao.modelo.Regiao;
import br.com.cadastro.regiao.repository.EstadoRepository;

public class EstadoForm {
	
	
	@NotNull @NotEmpty @Length(min = 5)
	private String nome;
	@NotNull @NotEmpty @Length(min = 5)
	private String capital;
	@NotNull @NotEmpty
	private Regiao regiao;
	@NotNull @NotEmpty
	private int populacao;
	@NotNull @NotEmpty
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
	
	public Estado converter(EstadoRepository estadoRepository) {
		Estado estado = estadoRepository.findByNome(nome);
		
		return new Estado(nome,capital,regiao,populacao,area);
		
		
	}
	
	

}
