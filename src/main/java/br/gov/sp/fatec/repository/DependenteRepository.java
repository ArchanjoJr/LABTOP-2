package br.gov.sp.fatec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import br.gov.sp.fatec.model.Dependente;

public interface DependenteRepository extends CrudRepository<Dependente, Long>{

	public Dependente findByNome(String nome);
	
	@Query("select f from Dependente f join f.funcionario j where j.nome = ?1")
	public List<Dependente> BuscaDependentePorFuncionario(String nome);
	
	

}