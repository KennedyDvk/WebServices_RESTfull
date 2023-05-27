package br.com.restfull.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity(name = "carrinho")
@Table(name = "TB_CARRINHO")
@SequenceGenerator(name = "carrinho", sequenceName = "SQ_TB_CARRINHO", allocationSize = 1)
public class Carrinho {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "carrinho")	
	@Column(name = "CD_CARRINHO")	
	private int codigo;
	
	@Column(name = "DS_ITEM_CARRINHO")
	private String descricao;

	public Carrinho() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Carrinho(int codigo, String descricao) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
}
