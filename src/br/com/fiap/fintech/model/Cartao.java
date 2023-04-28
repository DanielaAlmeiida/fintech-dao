package br.com.fiap.fintech.model;

import java.time.LocalDate;

public class Cartao {
	private int codigoCartao;
	private String nomeCartao;
    private String descCartao;
    private String numeroCartao;
    private LocalDate dataVencimento;
    private String numeroCVV;
    private Double valorLimite;
    
    public Cartao() {
    	
    }
    
    
    public int getCodigoCartao() {
		return codigoCartao;
	}
	public void setCodigoCartao(int codigoCartao) {
		this.codigoCartao = codigoCartao;
	}
	public String getNomeCartao() {
		return nomeCartao;
	}
	public void setNomeCartao(String nomeCartao) {
		this.nomeCartao = nomeCartao;
	}
	public String getDescCartao() {
		return descCartao;
	}
	public void setDescCartao(String descCartao) {
		this.descCartao = descCartao;
	}
	public String getNumeroCartao() {
		return numeroCartao;
	}
	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}
	public LocalDate getDataVencimento() {
		return dataVencimento;
	}
	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	public String getNumeroCVV() {
		return numeroCVV;
	}
	public void setNumeroCVV(String numeroCVV) {
		this.numeroCVV = numeroCVV;
	}
	public Double getValorLimite() {
		return valorLimite;
	}
	public void setValorLimite(Double valorLimite) {
		this.valorLimite = valorLimite;
	}
	
	@Override
    public String toString() {
        return "Cartao{" +
                "codigoCartao=" + codigoCartao +
                ", nomeCartao='" + nomeCartao + '\'' +
                ", descCartao='" + descCartao + '\'' +
                ", numCartao='" + numeroCartao + '\'' +
                ", dataVencimento=" + dataVencimento +
                ", numCvv='" + numeroCVV + '\'' +
                ", valorLimite=" + valorLimite +
                '}';
    }
	
}
