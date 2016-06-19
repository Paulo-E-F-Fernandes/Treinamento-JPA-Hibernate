package br.com.treinamento.jpa.hibernate.repository;

import javax.persistence.EntityManager;

import br.com.treinamento.jpa.hibernate.entitymanager.JPAUtil;
import br.com.treinamento.jpa.hibernate.model.Veiculo;

public class BuscadorVeiculo1 {

	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		
		Veiculo veiculo = manager.find(Veiculo.class, 1L);
		
		System.out.println("Veículo de código " + veiculo.getCodigo() + " é um " + veiculo.getModelo());
		
		manager.close();
		JPAUtil.close();
	}

}
