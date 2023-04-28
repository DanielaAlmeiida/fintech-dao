package br.com.fiap.fintech.model;

import java.time.LocalDate;

public class Meta {
	private int codigoMeta;
	private String nomeMeta;
    private String descMeta;
    private double valorMeta;
    private LocalDate dataInicioMeta;
    private LocalDate dataTerminoMeta;
    
	public Meta() {
		
	}
	
	public Meta(int codigoMeta, String nomeMeta, String descMeta, double valorMeta, LocalDate dataInicioMeta, LocalDate dataTerminoMeta) {
		this.codigoMeta = codigoMeta;
		this.nomeMeta = nomeMeta;
		this.descMeta = descMeta;
		this.valorMeta = valorMeta;
		this.dataInicioMeta = dataInicioMeta;
		this.dataTerminoMeta = dataTerminoMeta;

	}
	
	public int getCodigoMeta() {
		return codigoMeta;
	}

	public void setCodigoMeta(int codigoMeta) {
		this.codigoMeta = codigoMeta;
	}

	public String getNomeMeta() {
		return nomeMeta;
	}

	public void setNomeMeta(String nomeMeta) {
		this.nomeMeta = nomeMeta;
	}

	public String getDescMeta() {
		return descMeta;
	}

	public void setDescMeta(String descMeta) {
		this.descMeta = descMeta;
	}

	public double getValorMeta() {
		return valorMeta;
	}

	public void setValorMeta(double valorMeta) {
		this.valorMeta = valorMeta;
	}

	public LocalDate getDataInicioMeta() {
		return dataInicioMeta;
	}

	public void setDataInicioMeta(LocalDate dataInicioMeta) {
		this.dataInicioMeta = dataInicioMeta;
	}

	public LocalDate getDataTerminoMeta() {
		return dataTerminoMeta;
	}

	public void setDataTerminoMeta(LocalDate dataTerminoMeta) {
		this.dataTerminoMeta = dataTerminoMeta;
	}

 
	@Override
    public String toString() {
        return "Meta{" +
            "codigoMeta=" + codigoMeta +
            ", nomeMeta='" + nomeMeta + '\'' +
            ", descMeta='" + descMeta + '\'' +
            ", valorMeta=" + valorMeta +
            ", dataInicio=" + dataInicioMeta +
            ", dataTermino=" + dataTerminoMeta +
            '}';
    }
   
}