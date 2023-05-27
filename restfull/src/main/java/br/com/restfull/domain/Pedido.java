package br.com.restfull.domain;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity(name = "pedido")
@Table(name = "TB_PEDIDO")
@SequenceGenerator(name = "pedido", sequenceName = "SQ_TB_PEDIDO", allocationSize = 1)
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pedido")	
	@Column(name = "CD_PEDIDO")
	private int codigo;
	
	@Column(name = "DT_PEDIDO")
	private LocalDate dataPedido;

	public Pedido() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pedido(int codigo, LocalDate dataPedido) {
		super();
		this.codigo = codigo;
		this.dataPedido = dataPedido;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public LocalDate getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}

}
