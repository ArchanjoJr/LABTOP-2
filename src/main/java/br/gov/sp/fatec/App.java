package br.gov.sp.fatec;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.gov.sp.fatec.model.Dependente;
import br.gov.sp.fatec.model.Funcionario;
import br.gov.sp.fatec.repository.DependenteRepository;
import br.gov.sp.fatec.repository.FuncionarioRepository;
import br.gov.sp.fatec.repository.ServicoRepository;
import br.gov.sp.fatec.service.FuncionarioService;

public class App {
	
	
	
	public static void main( String[] args ){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		FuncionarioService funcServ = (FuncionarioService)context.getBean("funcionarioService");
		FuncionarioService depenServ = (FuncionarioService) context.getBean("funcionarioService");
		FuncionarioService servicoServ = (FuncionarioService) context.getBean("funcionarioService");
	    servicoServ.incluirServico("PROFESSOR");
	    funcServ.incluirFuncionario("mineda", 112358133, "PROFESSOR");
	    depenServ.incluirDependente("SALA01", "mineda");
	    
	    servicoServ.incluirServico("DIRETOR");
	    funcServ.incluirFuncionario("ARAKAKI", 112358134, "DIRETOR");
	    depenServ.incluirDependente("FATEC", "ARAKAKI");
	    //consultas no banco
		DependenteRepository depenRepo = (DependenteRepository) context.getBean("dependenteRepository");
		ServicoRepository servRepo = (ServicoRepository) context.getBean("servicoRepository");
		FuncionarioRepository funcRepo = (FuncionarioRepository) context.getBean("funcionarioRepository");
	    
	    List<Funcionario> listaFunc = funcRepo.BuscaFuncionarioPorDependente("SALA01");
	    System.out.println("MOSTRANDO FUNCIONARIOS E SUAS DEPENDENCIAS ");
		for (Funcionario f:listaFunc) {
			System.out.println("nome:"+ f.getNome());
			
			for (Dependente d:f.getDependentes()) {
				System.out.println("dependente:"+d.getNome());
			}
		}
		
		List<Dependente> listaDepen = depenRepo.BuscaDependentePorFuncionario("mineda");
		for (Dependente f:listaDepen) {
			System.out.println("funcionario:"+f.getFuncionario().getNome()+"dependente:"+ f.getNome());
		}
		System.out.println("Resultado da busca de findByNome: " + funcRepo.findByNome("mineda").getNome());
		
    }
	
}