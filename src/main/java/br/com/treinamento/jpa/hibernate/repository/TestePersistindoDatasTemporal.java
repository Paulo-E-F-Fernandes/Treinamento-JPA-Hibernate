package br.com.treinamento.jpa.hibernate.repository;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.treinamento.jpa.hibernate.entitymanager.JPAUtil;
import br.com.treinamento.jpa.hibernate.enuns.TipoCombustivel;
import br.com.treinamento.jpa.hibernate.model.Veiculo;

public class TestePersistindoDatasTemporal {

	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		Veiculo veiculo = new Veiculo();
		veiculo.setFabricante("Fiat");
		veiculo.setModelo("Palio");
		veiculo.setAnoFabricacao(2009);
		veiculo.setAnoModelo(2009);
		veiculo.setValor(new BigDecimal(16900));
		veiculo.setTipoCombustivel(TipoCombustivel.FLEX);
		veiculo.setDataCadastro(new Date());
		
		manager.persist(veiculo);
		
		tx.commit();
		manager.close();
		JPAUtil.close();
	}

}
