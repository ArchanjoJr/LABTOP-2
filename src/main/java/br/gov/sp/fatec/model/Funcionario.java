package br.gov.sp.fatec.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "funcionarios")
public class Funcionario {
	
	@Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "func_id",unique=true, length = 11, nullable = false)
	private Long id;
	
    @Column(name = "func_nome", length = 50, nullable = false)
	private String nome;
	
    @Column(name = "func_cpf", unique=true, length = 11, nullable = false)
	private int cpf;
    
    @Column(name = "func_depen", length = 50, nullable = false)
    private Set<Dependente> dependente;
    
    @Column(name = "func_servico", length = 30, nullable = false)
    private Set<Servico> servico;
    

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public Set<Servico> getServico() {
		return servico;
	}

	public void setServico(Set<Servico> servico) {
		this.servico = servico;
	}
	
	public void setDependente(Set<Dependente> dependente) {
		this.dependente = dependente;
	}
	
	public Set<Dependente> getDependente() {
		return dependente;
	}
	
	
}
