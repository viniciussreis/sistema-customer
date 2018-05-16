package br.com.customer.entity;

public class CustomerAccount {

	private Long id;
	private String cpfCnpj;
	private String nome;
	private boolean ativo;
	private Double valorTotal;
	
	public CustomerAccount() {}

	public CustomerAccount(String cpfCnpj, String nome, boolean ativo, Double valorTotal) {
		this.cpfCnpj = cpfCnpj;
		this.nome = nome;
		this.ativo = ativo;
		this.valorTotal = valorTotal;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

}
