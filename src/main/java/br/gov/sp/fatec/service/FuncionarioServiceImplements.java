package br.gov.sp.fatec.service;

import java.util.ArrayList;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.repository.ServicoRepository;
import br.gov.sp.fatec.model.Dependente;
import br.gov.sp.fatec.model.Funcionario;
import br.gov.sp.fatec.model.Servico;
import br.gov.sp.fatec.repository.DependenteRepository;
import br.gov.sp.fatec.repository.FuncionarioRepository;


@Service("funcionarioService")
public class FuncionarioServiceImplements implements FuncionarioService{

	
	@Autowired
	private FuncionarioRepository funcRepo;
	
	@Autowired
	private ServicoRepository servRepo;
	
	@Autowired
	private DependenteRepository depenRepo;

	
	public void setDependenteRepo(DependenteRepository depenRepo) {
		this.depenRepo = depenRepo;
	}
	
	
	public void setFuncionarioRepo(FuncionarioRepository funcRepo) {
		this.funcRepo = funcRepo;
	}
	
	public void setServicoRepo(ServicoRepository servRepo) {
		this.servRepo = servRepo;
	}

	
	@Override
	@Transactional
	public Funcionario incluirFuncionario(String nome, int cpf, String nomeServico, String nomeDependente) {
		Servico servico = servRepo.findByNome(nomeServico);
		
		if(servico == null) {
			servico = new Servico();
			servico.setNomeServico(nomeServico);
			servRepo.save(servico);
		}
		Funcionario func = new Funcionario();
		Dependente dep = new Dependente();
		func.setNome(nome);
		func.setCpf(cpf);
		func.setServico((Set<Servico>) new ArrayList<Servico>());
		func.getServico().add(servico);
		func.setDependente((Set<Dependente>)new ArrayList<Dependente>());
		func.getDependente().add(dep);
		funcRepo.save(func);
		return func;
		
	}

	

	
}
