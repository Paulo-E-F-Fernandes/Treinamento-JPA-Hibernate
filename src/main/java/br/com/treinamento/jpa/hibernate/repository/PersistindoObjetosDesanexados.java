package br.com.treinamento.jpa.hibernate.repository;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.treinamento.jpa.hibernate.entitymanager.JPAUtil;
import br.com.treinamento.jpa.hibernate.model.Veiculo;

public class PersistindoObjetosDesanexados {

	/*
	 * Objetos desanexados (detached) estão em um estado que não são mais gerenciados pelo EntityManager,
	 *  mas ainda representa uma entidade no banco de dados.
	 * 
	 * As alterações em objetos desanexados não são sincronizadas com o banco de dados.
	 */
	public static void main(String[] args) {
		alterandoEntidadeDesanexada();
		alterandoEntidadeReanexada();
		JPAUtil.close();
	}

	private static void alterandoEntidadeDesanexada() {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		System.out.println("***Alterando Entidade Desanexada***");
		System.out.println("Buscando o veículo...");
		Veiculo veiculo = manager.find(Veiculo.class, 2L);
		System.out.println("Valor do veículo: R$ " + veiculo.getValor());
		
		tx.commit();
		manager.close();
		
		System.out.println("Alterando o valor do veículo...");
		// essa alteração não será sincronizada
		veiculo.setValor(veiculo.getValor().add(new BigDecimal(360)));
		System.out.println("Novo valor do veículo: R$ " + veiculo.getValor());
	}
	
	/*
	 * O conteúdo do objeto desanexado é copiado para um objeto gerenciado com a mesma identidade. 
	 * Se o EntityManager ainda não estiver gerenciando um objeto com a mesma identidade, será realizada 
	 *  uma consulta para encontrá-lo, ou ainda, será persistida uma nova entidade.
	 *  
	 * O retorno do método merge é uma instância de um objeto gerenciado.
	 */
	private static void alterandoEntidadeReanexada() {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		System.out.println("\n***Reanexando a entidade e sincronizando as alterações***");
		System.out.println("Buscando o veículo...");
		Veiculo veiculo = manager.find(Veiculo.class, 2L);
		System.out.println("Valor do veículo: R$ " + veiculo.getValor());
		
		tx.commit();
		manager.close();
		
		System.out.println("Alterando o valor do veículo...");
		// essa alteração não será sincronizada
		veiculo.setValor(veiculo.getValor().add(new BigDecimal(300)));
		System.out.println("Novo valor do veículo: R$ " + veiculo.getValor());
		
		manager = JPAUtil.getEntityManager();
		tx = manager.getTransaction();
		tx.begin();
		
		// reanexamos o objeto ao novo EntityManager
		// Para reanexar o objeto em qualquer EntityManager, usamos o método merge.
		veiculo = manager.merge(veiculo);
		
		tx.commit();
		manager.close();
	}

}
