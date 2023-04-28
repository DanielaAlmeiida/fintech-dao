package br.com.fiap.fintech.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.fintech.factory.ConnectionFactory;
import br.com.fiap.fintech.model.Cartao;
import br.com.fiap.fintech.model.Usuario;

public class CartaoDAO {
private Connection conexao;
	
	public CartaoDAO() throws ClassNotFoundException {
		this.conexao = new ConnectionFactory().conectar();
	}
	
	public void insert(Usuario usuario, Cartao cartao) throws SQLException {
		try {
			String sql = "insert into t_cartao"
					+ "(cd_usuario, cd_cartao, nm_cartao, ds_cartao, nr_cartao, dt_vencimento, "
					+ "nr_cvv, vl_limite)"
					+ "values(?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setInt(1, usuario.getCodigoUsuario());
		    stmt.setInt(2, cartao.getCodigoCartao());
		    stmt.setString(3, cartao.getNomeCartao());
		    stmt.setString(4, cartao.getDescCartao());
		    stmt.setString(5, cartao.getNumeroCartao());
		    stmt.setDate(6, Date.valueOf(cartao.getDataVencimento()));
		    stmt.setString(7, cartao.getNumeroCVV());
		    stmt.setDouble(8, cartao.getValorLimite());
		
		    stmt.execute();
		    stmt.close();
		    
		} catch (SQLSyntaxErrorException t) {
			System.out.println("Tabela Cartão não existe.");
			throw new RuntimeException(t);
		}
		
	}
	
	public List<Cartao> select() throws SQLException {
		
		try {
			List<Cartao> cartaos = new ArrayList<>();
			String sql = "select * from t_cartao order by cd_cartao";
			PreparedStatement stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Cartao cartao = new Cartao();
				cartao.setCodigoCartao(rs.getInt("cd_cartao"));
				cartao.setNomeCartao(rs.getString("nm_cartao"));
				cartao.setDescCartao(rs.getString("ds_cartao"));
				cartao.setNumeroCartao(rs.getString("nr_cartao"));
				cartao.setDataVencimento(rs.getDate("dt_vencimento").toLocalDate());
				cartao.setNumeroCVV(rs.getString("nr_cvv"));
				cartao.setValorLimite(rs.getDouble("vl_limite"));
				
				cartaos.add(cartao);
			}
			
			stmt.close();
			rs.close();
			
			return cartaos;	
		} catch (SQLSyntaxErrorException t) {
			System.out.println("Tabela Cartão não existe.");
			throw new RuntimeException(t);
		}
		
	}
	
	public Cartao selectByCd(int codigoCartao) throws SQLException {
		
		try {
			Cartao cartao = null;
			String sql = "select * from t_cartao where cd_cartao = ?";
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, codigoCartao);
	        ResultSet rs = stmt.executeQuery();

	        while (rs.next()) {
	        	cartao = new Cartao();
				cartao.setCodigoCartao(rs.getInt("cd_cartao"));
				cartao.setNomeCartao(rs.getString("nm_cartao"));
				cartao.setDescCartao(rs.getString("ds_cartao"));
				cartao.setNumeroCartao(rs.getString("nr_cartao"));
				cartao.setDataVencimento(rs.getDate("dt_vencimento").toLocalDate());
				cartao.setNumeroCVV(rs.getString("nr_cvv"));
				cartao.setValorLimite(rs.getDouble("vl_limite"));
	        }

	        stmt.close();
	        rs.close();

	        return cartao;
	        
		} catch (SQLSyntaxErrorException t) {
			System.out.println("Tabela Cartão não existe.");
			throw new RuntimeException(t);
		}
		
    }

    public void delete(int codigoCartao) throws SQLException {
    	
    	try {
    		String sql = "delete from t_cartao where cd_cartao = ?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(2, codigoCartao);
            stmt.execute();
            stmt.close();
            
    	} catch (SQLSyntaxErrorException t) {
			System.out.println("Tabela Cartão não existe.");
			throw new RuntimeException(t);
		}
    }
    
	public void update(Cartao cartao) throws SQLException {
	    	
		try {
			String sql = "update t_cartao "
	        		+ "set nm_cartao = ?, ds_cartao = ?, nr_cartao = ?, "
	        		+ "dt_vencimento = ?, nr_cvv = ?, vl_limite = ? where cd_cartao = ?";
	        PreparedStatement stmt = conexao.prepareStatement(sql);
	
	        stmt.setString(1, cartao.getNomeCartao());
	        stmt.setString(2, cartao.getDescCartao());
	        stmt.setString(3, cartao.getNumeroCartao());
	        stmt.setDate(4, Date.valueOf(cartao.getDataVencimento()));
	        stmt.setString(5, cartao.getNumeroCVV());
	        stmt.setDouble(6, cartao.getValorLimite());
	        stmt.setInt(7, cartao.getCodigoCartao());
	
	        stmt.execute();
	        stmt.close();
	        
		} catch (SQLSyntaxErrorException t) {
	        System.out.println("Tabela Cartão não existe. Erro ao tentar atualizar cartão.");
	        throw new RuntimeException(t);
	    }
    
	}

        
    
        

    
}
