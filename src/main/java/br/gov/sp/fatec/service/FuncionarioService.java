package br.gov.sp.fatec.service;

import br.gov.sp.fatec.model.Funcionario;

public interface FuncionarioService {

	public Funcionario incluirFuncionario(String nome, int cpf , String nomeServico, String nomeDependente);
	
}
