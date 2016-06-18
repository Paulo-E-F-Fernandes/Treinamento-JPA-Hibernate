package br.com.treinamento.jpa.hibernate.repository;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.treinamento.jpa.hibernate.entitymanager.JPAUtil;
import br.com.treinamento.jpa.hibernate.model.Veiculo;

/*
 * Classe para exemplificar a persistência de dados. 
 */
public class PersistindoVeiculo {
	
	public static void main(String[] args) {
		// Obter uma instância de EntityManager a partir da factory (JPAUtil)
		EntityManager manager = JPAUtil.getEntityManager();
		
		// Iniciar uma nova transação
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		Veiculo veiculo = new Veiculo();
		veiculo.setFabricante("Honda");
		veiculo.setModelo("Civic");
		veiculo.setAnoFabricacao(2012);
		veiculo.setAnoModelo(2013);
		veiculo.setValor(new BigDecimal(74500));
		
		// Executar o método persist, passando como parâmetro o veículo.
		// O JPA deve insirir o objeto no banco de dados.
		manager.persist(veiculo);
		
		// Executar o commit da transação para efetivar a inserção do veículo no banco de dados.
		tx.commit();
		
		// Fechar o EntityManager.
		manager.close();
		
		// Fechar o EntityManagerFactory.
		JPAUtil.close();
	}

}