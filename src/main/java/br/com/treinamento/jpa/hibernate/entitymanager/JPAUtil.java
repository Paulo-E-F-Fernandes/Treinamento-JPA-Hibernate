package br.com.treinamento.jpa.hibernate.entitymanager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/*
 * Como os sistemas que usam JPA precisam de apenas uma instância do EntityManagerFactory, esta pode
 *  ser criada durante a inicialização da aplicação e depois qualquer parte do sistema que precisar 
 *  de um EntityManager pode solicitar a está instância.
 * 
 * Podemos criar um bloco estático para inicializar o EntityManagerFactory e como isso ocorrerá 
 *  apenas no carregamento da classe, sempre teremos uma instância da Factory, agora quando 
 *  precisarmos de uma EntityManager, usamos o seguinte código:
 * 
 * EntityManager manager = JpaUtil.getEntityManager();
 */
public class JPAUtil {
	
	private static EntityManagerFactory factory;
	
	static {
		factory = Persistence.createEntityManagerFactory("TreinamentoJPAHibernatePU");
	}
	
	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
	
	public static void close() {
		factory.close();
	}

}
