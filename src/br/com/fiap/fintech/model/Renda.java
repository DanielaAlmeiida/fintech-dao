package br.com.fiap.fintech.model;

import java.time.LocalDate;

public class Renda {
	private int codigoRenda;
	private String nomeRenda;
    private String descRenda;
	private double valorRenda;
    private LocalDate dataRenda;

	public Renda() {
		
	}
	
	public int getCodigoRenda() {
		return codigoRenda;
	}

	public void setCodigoRenda(int codigoRenda) {
		this.codigoRenda = codigoRenda;
	}

	public String getNomeRenda() {
		return nomeRenda;
	}

	public void setNomeRenda(String nomeRenda) {
		this.nomeRenda = nomeRenda;
	}

	public String getDescRenda() {
		return descRenda;
	}

	public void setDescRenda(String descRenda) {
		this.descRenda = descRenda;
	}

	public double getValorRenda() {
		return valorRenda;
	}

	public void setValorRenda(double valorRenda) {
		this.valorRenda = valorRenda;
	}

	public LocalDate getDataRenda() {
		return dataRenda;
	}

	public void setDataRenda(LocalDate dataRenda) {
		this.dataRenda = dataRenda;
	}

	@Override
    public String toString() {
        return "Renda{" +
                "codigoRenda=" + codigoRenda +
                ", nomeRenda='" + nomeRenda + '\'' +
                ", descRenda='" + descRenda + '\'' +
                ", valorRenda=" + valorRenda +
                ", dataRenda=" + dataRenda +
                '}';
    }
	
	
	
}
