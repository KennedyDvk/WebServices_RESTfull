package br.com.restfull.domain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_CATEGORIA")
@SequenceGenerator(name = "categoria", sequenceName = "SQ_TB_CATEGORIA", allocationSize = 1)
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categoria")
	@Column(name = "CD_CATEGORIA")
	private int codigo;
	
	@Column(name = "NM_CATEGORIA")
	private String nome;
	
	
	@OneToMany(mappedBy = "categoria")
	private List<Produto> produto;


	public Categoria() {
		super();
		
	}


	public Categoria(int codigo, String nome, List<br.com.restfull.domain.Produto> produto) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.produto = produto;
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public List<Produto> getProduto() {
		return produto;
	}


	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}
	
	
}
