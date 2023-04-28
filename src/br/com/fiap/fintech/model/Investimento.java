package br.com.fiap.fintech.model;

import java.time.LocalDate;

public class Investimento {
	private int codigoInvestimento;
	private String nomeInvestimento;
	private String descInvestimento;
	private double valorInvestimento;
	private LocalDate dataInvestimento;
	private double valorRendimento;

	public Investimento() {
		
	}
	
	
	public int getCodigoInvestimento() {
		return codigoInvestimento;
	}


	public void setCodigoInvestimento(int codigoInvestimento) {
		this.codigoInvestimento = codigoInvestimento;
	}


	public String getNomeInvestimento() {
		return nomeInvestimento;
	}


	public void setNomeInvestimento(String nomeInvestimento) {
		this.nomeInvestimento = nomeInvestimento;
	}


	public String getDescInvestimento() {
		return descInvestimento;
	}


	public void setDescInvestimento(String descInvestimento) {
		this.descInvestimento = descInvestimento;
	}


	public double getValorInvestimento() {
		return valorInvestimento;
	}


	public void setValorInvestimento(double valorInvestimento) {
		this.valorInvestimento = valorInvestimento;
	}


	public LocalDate getDataInvestimento() {
		return dataInvestimento;
	}


	public void setDataInvestimento(LocalDate dataInvestimento) {
		this.dataInvestimento = dataInvestimento;
	}


	public double getValorRendimento() {
		return valorRendimento;
	}


	public void setValorRendimento(double valorRendimento) {
		this.valorRendimento = valorRendimento;
	}

	@Override
    public String toString() {
        return "Investimento{" +
                "codigoInvestimento=" + codigoInvestimento +
                ", nomeInvestimento='" + nomeInvestimento + '\'' +
                ", descInvestimento='" + descInvestimento + '\'' +
                ", valorInvestimento=" + valorInvestimento +
                ", dataInvestimento=" + dataInvestimento +
                ", valorRendimento=" + valorRendimento +
                '}';
    }

}
