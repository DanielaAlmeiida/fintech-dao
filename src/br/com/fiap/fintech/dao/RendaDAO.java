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
import br.com.fiap.fintech.model.Renda;
import br.com.fiap.fintech.model.Usuario;

public class RendaDAO {

	private Connection conexao;

	public RendaDAO() throws ClassNotFoundException {
		this.conexao = new ConnectionFactory().conectar();
	}

	public void insert(Usuario usuario, Renda renda) throws SQLException {
		
		try {
			String sql = "insert into t_renda"
					+ "(cd_usuario, cd_renda, nm_renda, ds_renda, vl_renda, dt_renda) " 
					+ "values(?, ?, ?, ?, ?, ?)";

			PreparedStatement stmt = conexao.prepareStatement(sql);
	
			stmt.setInt(1, usuario.getCodigoUsuario());
			stmt.setInt(2, renda.getCodigoRenda());
			stmt.setString(3, renda.getNomeRenda());
			stmt.setString(4, renda.getDescRenda());
			stmt.setDouble(5, renda.getValorRenda());
			stmt.setDate(6, Date.valueOf(renda.getDataRenda()));
	
			stmt.execute();
			stmt.close();
			
		} catch (SQLSyntaxErrorException t) {
            System.out.println("Tabela Renda não existe. Erro ao tentar inserir uma nova renda.");
            throw new RuntimeException(t);
        }
		
	}

	public List<Renda> select() throws SQLException {
		
		try {
			List<Renda> rendas = new ArrayList<>();
			String sql = "select * from t_renda order by cd_renda";
			PreparedStatement stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Renda renda = new Renda();
				renda.setCodigoRenda(rs.getInt("cd_renda"));
				renda.setNomeRenda(rs.getString("nm_renda"));
				renda.setDescRenda(rs.getString("ds_renda"));
				renda.setValorRenda(rs.getDouble("vl_renda"));
				renda.setDataRenda(rs.getDate("dt_renda").toLocalDate());

				rendas.add(renda);
			}

			stmt.close();
			rs.close();

			return rendas;
			
		} catch (SQLSyntaxErrorException t) {
            System.out.println("Tabela Renda não existe.");
            throw new RuntimeException(t);
        }
		
	}

	public Renda selectByCd(int codigoRenda) throws SQLException {
		
		try {
			Renda renda = null;
			String sql = "select * from t_renda where cd_renda = ?";
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, codigoRenda);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				renda = new Renda();
				renda.setCodigoRenda(rs.getInt("cd_renda"));
				renda.setNomeRenda(rs.getString("nm_renda"));
				renda.setDescRenda(rs.getString("ds_renda"));
				renda.setValorRenda(rs.getDouble("vl_renda"));
				renda.setDataRenda(rs.getDate("dt_renda").toLocalDate());
			}

			stmt.close();
			rs.close();

			return renda;
			
		} catch (SQLSyntaxErrorException t) {
            System.out.println("Tabela Renda não existe.");
            throw new RuntimeException(t);
        }
		
	}

	public void delete(int codigoRenda) throws SQLException {
		
		try {
			String sql = "delete from t_renda where cd_renda = ?";
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(2, codigoRenda);
			stmt.execute();
			stmt.close();
			
		} catch (SQLSyntaxErrorException t) {
            System.out.println("Tabela Renda não existe.");
            throw new RuntimeException(t);
        }
		
	}
	
	public void update(Renda renda) throws SQLException {
    	
		try {
			String sql = "update t_renda "
	        		+ "set nm_renda = ?, ds_renda = ?, vl_renda = ?, dt_renda = ? where cd_renda = ?";
	        PreparedStatement stmt = conexao.prepareStatement(sql);
	
	        stmt.setString(1, renda.getNomeRenda());
	        stmt.setString(2, renda.getDescRenda());
	        stmt.setDouble(3, renda.getValorRenda());
	        stmt.setDate(4, Date.valueOf(renda.getDataRenda()));
	        stmt.setInt(5, renda.getCodigoRenda());
	
	        stmt.execute();
	        stmt.close();
	        
		} catch (SQLSyntaxErrorException t) {
	        System.out.println("Tabela Renda não existe. Erro ao tentar atualizar renda.");
	        throw new RuntimeException(t);
	    }
    
	}


}
