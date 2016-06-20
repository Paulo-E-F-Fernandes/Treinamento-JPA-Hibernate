package br.com.treinamento.jpa.hibernate.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.treinamento.jpa.hibernate.entitymanager.JPAUtil;
import br.com.treinamento.jpa.hibernate.model.Veiculo;

public class ListandoVeiculos {

	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		
		// Criamos uma query com a JPQL e armazenamos em na variável query.
		Query query = manager.createQuery("from Veiculo");
		// O método getResultList() retorna a lista de veículos do banco de dados.
		List<Veiculo> veiculos = query.getResultList();
		
		for (Veiculo veiculo : veiculos) {
			System.out.println(veiculo.getCodigo() + " - " 
					+ veiculo.getFabricante() + " " 
					+ veiculo.getModelo() + ", ano " 
					+ veiculo.getAnoFabricacao() + "/"
					+ veiculo.getAnoModelo() + " por R$ "
					+ veiculo.getValor());
		}
		
		manager.close();
		JPAUtil.close();
	}

}
