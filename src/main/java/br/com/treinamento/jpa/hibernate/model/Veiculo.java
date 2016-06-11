package br.com.treinamento.jpa.hibernate.model;

import java.math.BigDecimal;

public class Veiculo {

	private Long codigo; // identificador único do veículo
	private String fabricante; // nome do fabricante do veículo
	private String modelo; // descrição do modelo do veículo
	private Integer anoFabricacao; // ano de fabricação do veículo
	private Integer anoModelo; // ano do modelo do veículo
	private BigDecimal valor; // valor que está sendo pedido para venda do veículo

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
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
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Veiculo other = (Veiculo) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
}
