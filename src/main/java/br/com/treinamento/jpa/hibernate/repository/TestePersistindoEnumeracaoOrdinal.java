package br.com.treinamento.jpa.hibernate.repository;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.treinamento.jpa.hibernate.entitymanager.JPAUtil;
import br.com.treinamento.jpa.hibernate.enuns.TipoCombustivel;
import br.com.treinamento.jpa.hibernate.model.Veiculo;

public class TestePersistindoEnumeracaoOrdinal {

	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		Veiculo veiculo = new Veiculo();
		veiculo.setFabricante("Fiat");
		veiculo.setModelo("Bravo");
		veiculo.setAnoFabricacao(2010);
		veiculo.setAnoModelo(2010);
		veiculo.setValor(new BigDecimal(23500));
		veiculo.setTipoCombustivel(TipoCombustivel.GASOLINA);
		
		manager.persist(veiculo);
		
		tx.commit();
		manager.close();
		JPAUtil.close();
	}

}
