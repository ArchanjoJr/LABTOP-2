package br.gov.sp.fatec.repository;

import org.springframework.data.repository.CrudRepository;

import br.gov.sp.fatec.model.Servico;

public interface ServicoRepository extends CrudRepository<Servico, Long>{
	
	public Servico findByNome(String nomeServico);
	
}
