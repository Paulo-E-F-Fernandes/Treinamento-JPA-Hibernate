package br.com.treinamento.jpa.hibernate.repository;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.treinamento.jpa.hibernate.entitymanager.JPAUtil;
import br.com.treinamento.jpa.hibernate.model.Veiculo;

public class AtualizandoVeiculo {

	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		// Iniciar uma nova transação, necessário para atualizar as informações do banco de dados
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		// Busca o veículo de código 1
		Veiculo veiculo = manager.find(Veiculo.class, 1L); 
		
		System.out.println("Valor atual: R$ " + veiculo.getValor());
		veiculo.setValor(veiculo.getValor().add(new BigDecimal(523))); // Atualiza o valor do veículo
		System.out.println("Novo valor: R$ " + veiculo.getValor());
		
		// Commita a transação no banco de dados
		tx.commit();
		manager.close();
		JPAUtil.close();
	}

}
