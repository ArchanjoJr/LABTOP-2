package br.gov.sp.fatec.service;

import java.util.ArrayList;

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
public class FuncionarioServiceImplements implements FuncionarioService {

	@Autowired
	private FuncionarioRepository funcRepo;
	
	@Autowired
	private DependenteRepository depenRepo;
	
	@Autowired
	private ServicoRepository servRepo;

	
	public ServicoRepository getServRepo() {
		return servRepo;
	}

	public void setServRepo(ServicoRepository servRepo) {
		this.servRepo = servRepo;
	}

	public FuncionarioRepository getFuncRepo() {
		return funcRepo;
	}

	public void setFuncRepo(FuncionarioRepository funcRepo) {
		this.funcRepo = funcRepo;
	}

	public DependenteRepository getDepenRepo() {
		return depenRepo;
	}

	public void setDepenRepo(DependenteRepository depenRepo) {
		this.depenRepo = depenRepo;
	}

	@Transactional
	public Funcionario incluirFuncionario(String nome, int Cpf, String nomeServico) {
		try {
			Servico serv = servRepo.findByNome(nomeServico);		
			Funcionario func = new Funcionario();
			func.setNome(nome);
			func.setCpf(Cpf);
			func.setDependentes(new ArrayList<Dependente>());
			func.setServico(serv);
			funcRepo.save(func);
			return func;
			
		} catch (Exception e) {
			System.out.println("chave unica duplicada");
			return null;
		}
		
	}
	
	
	@Transactional
	public Dependente incluirDependente(String nome, String nomeFunc) {
		Dependente dep = new Dependente();
		Funcionario func = new Funcionario();
		dep.setNome(nome);
		func = funcRepo.findByNome(nomeFunc);
		if (func == null) {
			return null;
		}
		dep.setFuncionario(func);
		depenRepo.save(dep);
		
		return dep;
	}
	
	@Transactional
	public Servico incluirServico(String nome) {
	
		Servico serv = new Servico();
		serv.setNome(nome);
		serv.setFuncionarios(new ArrayList<Funcionario>());
		servRepo.save(serv);
		return serv;
	}
	
}