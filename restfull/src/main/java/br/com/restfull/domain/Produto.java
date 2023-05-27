package br.com.restfull.domain;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity(name = "produto")
@Table(name = "TB_PRODUTO")
@SequenceGenerator(name = "produto", sequenceName = "SQ_TB_PRODUTO", allocationSize = 1)
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto")	
	@Column(name = "CD_PRODUTO")
	private int codigo;
	
	@NotBlank(message = "Nome obrigatório!")
	@Size(max = 50)
	@Column(name = "NM_PRODUTO")
	private String nome;
	@Min(value = 0, message = "Preço não pode ser negativo")
	
	@Column(name = "VL_PRECO")
	private double preco;
	
	@Column(name = "DS_NOVO")
	private boolean novo;
	@Past
	@Column(name = "DT_FABRICACAO")
	private LocalDate dataFabricacao;

	@ManyToOne
	@JoinColumn(name = "TB_CATEGORIA_CD_CATEGORIA")
	private Categoria categoria;

	public Produto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Produto(int codigo, @NotBlank(message = "Nome obrigatório!") @Size(max = 50) String nome,
			@Min(value = 0, message = "Preço não pode ser negativo") double preco, boolean novo,
			@Past LocalDate dataFabricacao, Categoria categoria) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.preco = preco;
		this.novo = novo;
		this.dataFabricacao = dataFabricacao;
		this.categoria = categoria;
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

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public boolean isNovo() {
		return novo;
	}

	public void setNovo(boolean novo) {
		this.novo = novo;
	}

	public LocalDate getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(LocalDate dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	
}
