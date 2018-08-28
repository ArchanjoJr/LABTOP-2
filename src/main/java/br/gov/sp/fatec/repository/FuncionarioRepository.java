package br.gov.sp.fatec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.gov.sp.fatec.model.Funcionario;



public interface FuncionarioRepository extends CrudRepository <Funcionario, Long>{
	
	public Funcionario findByNome(String nome);
	
	@Query("select f from Funcionario f join f.dependentes j where j.nome = ?1")
	public List<Funcionario> BuscaFuncionarioPorDependente(String nome);
	

}