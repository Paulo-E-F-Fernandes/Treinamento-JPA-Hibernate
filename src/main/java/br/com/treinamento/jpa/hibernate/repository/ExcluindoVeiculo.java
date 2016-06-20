package br.com.treinamento.jpa.hibernate.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.treinamento.jpa.hibernate.entitymanager.JPAUtil;
import br.com.treinamento.jpa.hibernate.model.Veiculo;

public class ExcluindoVeiculo {

	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		Veiculo veiculo = manager.find(Veiculo.class, 1L);
		// A exclusão de objetos é feita chamando o método remove(Object) da classe EntityManager,
		//  passando o objeto como parâmetro do método.
		manager.remove(veiculo);
		
		tx.commit();
		manager.close();
		JPAUtil.close();
	}
	
}
