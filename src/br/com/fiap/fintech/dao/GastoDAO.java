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
import br.com.fiap.fintech.model.Gasto;
import br.com.fiap.fintech.model.Usuario;

public class GastoDAO {
	
	private Connection conexao;

	public GastoDAO() throws ClassNotFoundException {
		this.conexao = new ConnectionFactory().conectar();
	}

	public void insert(Usuario usuario, Gasto gasto) throws SQLException {
		try {
			String sql = "insert into t_gasto" 
						+ "(cd_usuario, cd_gasto, nm_gasto, ds_gasto, vl_gasto, dt_gasto) " 
						+ "values" + "(?, " + "?, " + "?, " + "?, " + "?, " + "?" + ")";
	
			PreparedStatement stmt = conexao.prepareStatement(sql);

			stmt.setInt(1, usuario.getCodigoUsuario());
			stmt.setInt(2, gasto.getCodigoGasto());
			stmt.setString(3, gasto.getNomeGasto());
			stmt.setString(4, gasto.getDescGasto());
			stmt.setDouble(5, gasto.getValorGasto());
			stmt.setDate(6, Date.valueOf(gasto.getDataGasto()));

			stmt.execute();
			stmt.close();

		} catch (SQLSyntaxErrorException t) {
			System.out.println("Tabela Gasto não existe.");
			throw new RuntimeException(t);
		}
	}

	public List<Gasto> select() throws SQLException {
		try {
			List<Gasto> gastos = new ArrayList<>();
			String sql = "select * from t_gasto order by cd_gasto";
			PreparedStatement stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Gasto gasto = new Gasto();
				gasto.setCodigoGasto(rs.getInt("cd_gasto"));
				gasto.setNomeGasto(rs.getString("nm_gasto"));
				gasto.setDescGasto(rs.getString("ds_gasto"));
				gasto.setValorGasto(rs.getDouble("vl_gasto"));
				gasto.setDataGasto(rs.getDate("dt_gasto").toLocalDate());

				gastos.add(gasto);
			}

			stmt.close();
			rs.close();

			return gastos;
		} catch (SQLSyntaxErrorException t) {
			System.out.println("Tabela Gasto não existe.");
			throw new RuntimeException(t);
		}

	}

	public Gasto selectByCd(int codigoGasto) throws SQLException {
		try {
			Gasto gasto = null;
			String sql = "select * from t_gasto where cd_gasto = ?";
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, codigoGasto);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				gasto = new Gasto();
				gasto.setCodigoGasto(rs.getInt("cd_gasto"));
				gasto.setNomeGasto(rs.getString("nm_gasto"));
				gasto.setDescGasto(rs.getString("ds_gasto"));
				gasto.setValorGasto(rs.getDouble("vl_gasto"));
				gasto.setDataGasto(rs.getDate("dt_gasto").toLocalDate());
			}

			stmt.close();
			rs.close();

			return gasto;
		} catch (SQLSyntaxErrorException t) {
			System.out.println("Tabela Gasto não existe.");
			throw new RuntimeException(t);
		}

	}

	public void delete(int codigoGasto) throws SQLException {
		try {
			String sql = "delete from t_gasto where cd_gasto = ?";
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(2, codigoGasto);
			stmt.execute();
			stmt.close();
		} catch (SQLSyntaxErrorException t) {
			System.out.println("Tabela Gasto não existe.");
			throw new RuntimeException(t);
		}

	}
	
	public void update(Gasto gasto) throws SQLException {
    	
		try {
			String sql = "update t_gasto "
	        		+ "set nm_gasto = ?, ds_gasto = ?, vl_gasto = ?, dt_gasto = ? where cd_gasto = ?";
	        PreparedStatement stmt = conexao.prepareStatement(sql);
	
	        stmt.setString(1, gasto.getNomeGasto());
	        stmt.setString(2, gasto.getDescGasto());
	        stmt.setDouble(3, gasto.getValorGasto());
	        stmt.setDate(4, Date.valueOf(gasto.getDataGasto()));
	        stmt.setInt(5, gasto.getCodigoGasto());
	
	        stmt.execute();
	        stmt.close();
	        
		} catch (SQLSyntaxErrorException t) {
	        System.out.println("Tabela Gasto não existe. Erro ao tentar atualizar gasto.");
	        throw new RuntimeException(t);
	    }
    
	}

	
	

}
