package br.com.fiap.fintech.model;

import java.time.LocalDate;

public class Usuario {
    private int codigoUsuario;
    private String nomeUsuario;
    private LocalDate dataNascimento;
    private String genero;
    private String email;
    private String senha;
	
    public Usuario() {
    	
    }
    
	public Usuario(int codigoUsuario, String nomeUsuario, LocalDate dataNascimento, String genero, String email, String senha) {
		this.codigoUsuario = codigoUsuario;
		this.nomeUsuario = nomeUsuario;
		this.dataNascimento = dataNascimento;
		this.genero = genero;
		this.email = email;
		this.senha = senha;

	}


    public int getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(int codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public Usuario setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
        return this;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    
	
	public boolean realizarLogin(String email, String senha) {
		if (this.senha == senha) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
    public String toString() {
        return "Usuario[" +
                "codigoUsuario: " + codigoUsuario +
                ", nomeUsuario: '" + nomeUsuario + '\'' +
                ", dataNascimento: " + dataNascimento +
                ", genero: '" + genero + '\'' +
                ", email: '" + email + '\'' +
                ", senha: '" + senha + '\'' +
                ']';
	}
	
}




