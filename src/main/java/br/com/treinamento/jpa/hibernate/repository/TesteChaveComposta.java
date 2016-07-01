package br.com.treinamento.jpa.hibernate.repository;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.treinamento.jpa.hibernate.entitymanager.JPAUtil;
import br.com.treinamento.jpa.hibernate.model.VeiculoDetran;
import br.com.treinamento.jpa.hibernate.model.VeiculoDetranId;

public class TesteChaveComposta {

	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		/* 
		 * Salvar um veículo com chave composta no banco de dados.
		 * Precisamos criar a chave antes de salvar o veículo. 
		 */
		VeiculoDetran veiculoDetran = new VeiculoDetran();
		veiculoDetran.setId(new VeiculoDetranId("Pelotas", "IVB-0013"));
		veiculoDetran.setFabricante("Ford");
		veiculoDetran.setModelo("Fusion");
		veiculoDetran.setAnoFabricacao(2012);
		veiculoDetran.setAnoModelo(2012);
		veiculoDetran.setValor(new BigDecimal(82500));
		
		manager.persist(veiculoDetran);
		
		tx.commit();
		manager.close();
		
		/*
		 * Para buscar um veículo com chave composta do banco de dados precisamos instanciar o
		 *  VeiculoDetranId e passar como parâmetro para o find do EntityManager.
		 */
		manager = JPAUtil.getEntityManager();
		
		VeiculoDetranId id = new VeiculoDetranId("Pelotas", "IVB-0013");
		veiculoDetran = manager.find(VeiculoDetran.class, id);
		
		System.out.print("Placa: " + veiculoDetran.getId().getCidade());
		System.out.println(" " + veiculoDetran.getId().getPlaca());
		System.out.print("Veículo: " + veiculoDetran.getFabricante());
		System.out.print(" " + veiculoDetran.getModelo());
		System.out.print(" - Ano: " + veiculoDetran.getAnoFabricacao());
		System.out.println("/" + veiculoDetran.getAnoModelo());
		
		manager.close();
		JPAUtil.close();

	}

}
