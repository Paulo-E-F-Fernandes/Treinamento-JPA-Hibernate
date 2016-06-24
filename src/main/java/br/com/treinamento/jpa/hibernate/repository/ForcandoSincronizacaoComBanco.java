package br.com.treinamento.jpa.hibernate.repository;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.treinamento.jpa.hibernate.entitymanager.JPAUtil;
import br.com.treinamento.jpa.hibernate.model.Veiculo;

public class ForcandoSincronizacaoComBanco {

	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		Veiculo veiculo = manager.find(Veiculo.class, 2L);
		System.out.println("Valor atual: " + veiculo.getValor());
		veiculo.setValor(veiculo.getValor().add(new BigDecimal(250)));
		
		// O método flush de EntityManager força a sincronização com o banco de dados antes mesmo do commit
		manager.flush();
		
		System.out.println("Novo valor: " + veiculo.getValor());
		
		tx.commit();
		manager.close();
		JPAUtil.close();
	}

}
