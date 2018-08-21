package br.gov.sp.fatec;

import java.util.ArrayList;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.gov.sp.fatec.model.Funcionario;
import br.gov.sp.fatec.model.Servico;
import br.gov.sp.fatec.repository.FuncionarioRepository;
import br.gov.sp.fatec.repository.ServicoRepository;
import br.gov.sp.fatec.service.FuncionarioService;

public class App 
{
 
	public static void main( String[] args )
    {
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext(	"applicationContext.xml");
 
		// Recupera os repositorios
		ServicoRepository servRepo = (ServicoRepository) context.getBean("servicoRepository");
		FuncionarioRepository funcRepo = (FuncionarioRepository) context.getBean("funcionarioRepository");
		
		
		// Cria funcionario usando servico (FORMA CORRETA DE FAZER!)
		FuncionarioService funcService = (FuncionarioService)context.getBean("funcionarioService");
		
		Funcionario func1 = new Funcionario();

		func1 = funcService.incluirFuncionario("William", 22222222, "Barbeiro", "Nicolas");
		
		System.out.println("Id: " + func1.getId());
		
		// Realiza varias consultas
		System.out.println("Resultado da busca 1: " + funcRepo.findByNome("William").getNome());
		
		System.out.println("Resultado da busca 2: " + funcRepo.findTop1ByNomeContains("am").getNome());

		for(Funcionario us: funcRepo.findByIdGreaterThan(0l)) {
			System.out.println("Funcionario encontrado: " + us.getNome());
		}
			
		for(Funcionario us: funcRepo.findByNomeContainsIgnoreCaseOrServicosNomeContainsIgnoreCase("n", "m")) {
			System.out.println("Funcionario encontrado 2 (or): " + us.getNome());
		}
		
		for(Funcionario us: funcRepo.findByServicosNomeContainsIgnoreCase("Usuario")) {
			System.out.println("Funcionario encontrado 3: " + us.getNome());
		}
		
		for(Funcionario us: funcRepo.buscaFuncionario("a")) {
			System.out.println("Funcionario encontrado 4: " + us.getNome());
		}	
		
		// Exclui funcionario
		funcRepo.delete(funcRepo.findByNome("William"));
		
		
		context.close();

    }
    
}
