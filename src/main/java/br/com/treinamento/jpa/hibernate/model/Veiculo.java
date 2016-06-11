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

}
