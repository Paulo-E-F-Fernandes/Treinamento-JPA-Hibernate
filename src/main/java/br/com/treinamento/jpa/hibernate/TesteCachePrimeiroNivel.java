package br.com.treinamento.jpa.hibernate;

import javax.persistence.EntityManager;

import br.com.treinamento.jpa.hibernate.entitymanager.JPAUtil;
import br.com.treinamento.jpa.hibernate.model.Veiculo;

public class TesteCachePrimeiroNivel {

	/* Uma mesma entidade pode ser representada por diferentes objetos na memória,
	 * desde que seja em diferentes instâncias de EntityManagers. 
	 */
	public static void main(String[] args) {
		testarMesmoEntityManager();
		testarDiferenteEntityManager();
		JPAUtil.close();
	}

	/* 
	 * Em uma única instância de EntityManager, apenas um objeto que representa determinada
	 * entidade (com o mesmo identificador) pode ser gerenciada.
	 */
	private static void testarMesmoEntityManager() {
		EntityManager manager = JPAUtil.getEntityManager();
		
		System.out.println("***testarMesmoEntityManager***");
		Veiculo veiculo1 = manager.find(Veiculo.class, 2L);
		System.out.println("Buscou o veículo pela primeira vez...");
		
		Veiculo veiculo2 = manager.find(Veiculo.class, 2L);
		System.out.println("Buscou o veículo pela segunda vez...");
		
		System.out.println("Mesmo veículo? " + (veiculo1 == veiculo2));
		
		manager.close();
	}

	private static void testarDiferenteEntityManager() {
		EntityManager manager = JPAUtil.getEntityManager();
		
		System.out.println("\n***testarDiferenteEntityManager***");
		Veiculo veiculo1 = manager.find(Veiculo.class, 2L);
		System.out.println("Buscou o veículo pela primeira vez...");
		
		// O método contains de EntityManager verifica se o objeto está sendo gerenciado 
		//  pelo contexto de persistência do EntityManager.
		System.out.println("Gerenciado? " + manager.contains(veiculo1));
		
		// O método detach pára de gerenciar a entidade no contexto de persistência, 
		//  colocando-a no estado detached.
		manager.detach(veiculo1);
		
		System.out.println("Continua gerenciado? " + manager.contains(veiculo1));
		
		Veiculo veiculo2 = manager.find(Veiculo.class, 2L);
		System.out.println("Buscou o veículo pela segunda vez...");
		
		System.out.println("Mesmo veículo? " + (veiculo1 == veiculo2));
		
		manager.close();
	}
	
	
	
	
}
