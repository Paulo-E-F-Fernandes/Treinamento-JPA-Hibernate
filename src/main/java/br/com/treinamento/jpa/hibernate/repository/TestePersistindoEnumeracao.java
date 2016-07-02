package br.com.treinamento.jpa.hibernate.repository;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.treinamento.jpa.hibernate.entitymanager.JPAUtil;
import br.com.treinamento.jpa.hibernate.enuns.TipoCombustivel;
import br.com.treinamento.jpa.hibernate.model.Veiculo;

public class TestePersistindoEnumeracao {

	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		Veiculo veiculo = new Veiculo();
		veiculo.setFabricante("Chevrolet");
		veiculo.setModelo("Corsa");
		veiculo.setAnoFabricacao(2006);
		veiculo.setAnoModelo(2007);
		veiculo.setValor(new BigDecimal(12670));
		veiculo.setTipoCombustivel(TipoCombustivel.GASOLINA);
		
		manager.persist(veiculo);
		
		tx.commit();
		manager.close();
		JPAUtil.close();
	}

}
