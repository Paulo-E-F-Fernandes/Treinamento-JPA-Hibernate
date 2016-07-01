package br.com.treinamento.jpa.hibernate.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable /* Esta classe foi anotada com @Embeddable, pois sempre será utilizada de forma "embutida" em outra classe. */
public class VeiculoDetranId implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String cidade;
	private String placa;
	
	public VeiculoDetranId() {
	}
	
	public VeiculoDetranId(String cidade, String placa) {
		super();
		this.cidade = cidade;
		this.placa = placa;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result + ((placa == null) ? 0 : placa.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VeiculoDetranId other = (VeiculoDetranId) obj;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		if (placa == null) {
			if (other.placa != null)
				return false;
		} else if (!placa.equals(other.placa))
			return false;
		return true;
	}
	
	
}
