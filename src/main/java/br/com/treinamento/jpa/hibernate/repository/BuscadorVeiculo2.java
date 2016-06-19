package br.com.treinamento.jpa.hibernate.repository;

import javax.persistence.EntityManager;

import br.com.treinamento.jpa.hibernate.entitymanager.JPAUtil;
import br.com.treinamento.jpa.hibernate.model.Veiculo;

public class BuscadorVeiculo2 {

	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		
		/* Buscando um objeto pelo identificador usando o método getReference(Class<T>, Object).
		 * 
		 * O método getReference(Class<T>, Object) só executa o SQL quando o primeiro método getter 
		 *  for chamado, desde que não seja o getCodigo.
		 */
		Veiculo veiculo = manager.getReference(Veiculo.class, 1L);
		
		System.out.println("--- Buscou veículo. Será que já executou o SELECT? ---");
		System.out.println("O veículo de código " + veiculo.getCodigo() + " é um " + veiculo.getModelo());
		
		manager.close();
		JPAUtil.close();
	}

}