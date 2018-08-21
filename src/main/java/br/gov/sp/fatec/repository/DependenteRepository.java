package br.gov.sp.fatec.repository;

import org.springframework.data.repository.CrudRepository;

import br.gov.sp.fatec.model.Dependente;
import br.gov.sp.fatec.model.Funcionario;

public interface DependenteRepository extends CrudRepository<Dependente, Long>{

	public Dependente findByNome(String nome);
	
	public Dependente findByCpf(int cpf);

	
}
