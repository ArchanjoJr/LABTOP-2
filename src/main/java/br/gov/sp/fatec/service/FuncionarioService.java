package br.gov.sp.fatec.service;

import br.gov.sp.fatec.model.Dependente;
import br.gov.sp.fatec.model.Funcionario;
import br.gov.sp.fatec.model.Servico;

public interface FuncionarioService {

	public Funcionario incluirFuncionario(String nome, int Cpf, String servico);

	public Dependente incluirDependente(String nome, String nomeFunc);
	
	public Servico incluirServico(String nome);
}