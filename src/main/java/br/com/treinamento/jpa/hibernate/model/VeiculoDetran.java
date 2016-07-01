package br.com.treinamento.jpa.hibernate.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity /* Indica que a classe é uma entidade e representa uma tabela do banco de dados. */
@Table(name = "tab_veiculo_detran") /* O nome da tabela no banco de dados será "tab_veiculo_detran". */
public class VeiculoDetran {

	@EmbeddedId /* Como a chave da tabela é composta, a chave será "embutida" na clase. */
	private VeiculoDetranId id; // identificador único do veículo
	
	@Column(length = 60, nullable = false)
	private String fabricante; // nome do fabricante do veículo
	
	@Column(length = 60, nullable = false)
	private String modelo; // descrição do modelo do veículo
	
	@Column(name = "ano_fabricacao", nullable = false)
	private Integer anoFabricacao; // ano de fabricação do veículo
	
	@Column(name = "ano_modelo", nullable = false)
	private Integer anoModelo; // ano do modelo do veículo
	
	@Column(precision = 10, scale = 2, nullable = true) /* A precisão da coluna valor será 10, com 2 casas decimais */
	private BigDecimal valor; // valor que está sendo pedido para venda do veículo

	public VeiculoDetranId getId() {
		return id;
	}
	
	public void setId(VeiculoDetranId id) {
		this.id = id;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(Integer anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public Integer getAnoModelo() {
		return anoModelo;
	}

	public void setAnoModelo(Integer anoModelo) {
		this.anoModelo = anoModelo;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	/* 
	 * Os métodos hashCode() e equals() são necessários para que os objetos persistentes
	 *  sejam diferenciados um dos outros.
	 *  
	 * Com estes métodos, o Hibernate consegue comparar objetos para descobrir se são os
	 *  mesmos.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		VeiculoDetran other = (VeiculoDetran) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
