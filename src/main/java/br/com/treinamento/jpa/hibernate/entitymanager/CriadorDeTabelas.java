package br.com.treinamento.jpa.hibernate.entitymanager;

import javax.persistence.Persistence;

public class CriadorDeTabelas {

	public static void main(String[] args) {
		/* O parâmetro do método "createEntityManagerFactory" é o "name" do "persistence-unit" do persistence.xml */
		Persistence.createEntityManagerFactory("TreinamentoJPAHibernatePU");
	}

}
