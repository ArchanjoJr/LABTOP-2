package br.gov.sp.fatec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.gov.sp.fatec.model.Funcionario;



public interface FuncionarioRepository extends CrudRepository<Funcionario, Long> {

	public Funcionario findByNome(String nome);
	
	public Funcionario findTop1ByNomeContains(String nome);
	
	public List<Funcionario> findByIdGreaterThan(Long id);
	
	public List<Funcionario> findByServicosNomeContainsIgnoreCase(String nome);
	
	public List<Funcionario> findByNomeContainsIgnoreCaseOrServicosNomeContainsIgnoreCase(String nome, String nomeServico);
	
	@Query("select u from funcionarios u where u.nome like %?1%")
	public List<Funcionario> buscaFuncionario(String nome);
}
