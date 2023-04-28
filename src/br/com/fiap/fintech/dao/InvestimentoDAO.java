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
import br.com.fiap.fintech.model.Investimento;
import br.com.fiap.fintech.model.Usuario;

public class InvestimentoDAO {
	
	private Connection conexao;
	
	public InvestimentoDAO() throws ClassNotFoundException {
		this.conexao = new ConnectionFactory().conectar();
	}
	
	public void insert(Usuario usuario, Investimento investimento) throws SQLException {
		
		try {
			String sql = "insert into t_investimento"
					+ "(cd_usuario, cd_investimento, nm_investimento, ds_investimento, vl_investimento, "
					+ "dt_investimento, vl_rendimento_investimento)"
					+ "values(?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setInt(1, usuario.getCodigoUsuario());
		    stmt.setInt(2, investimento.getCodigoInvestimento());
		    stmt.setString(3, investimento.getNomeInvestimento());
		    stmt.setString(4, investimento.getDescInvestimento());
		    stmt.setDouble(5, investimento.getValorInvestimento());
		    stmt.setDate(6, Date.valueOf(investimento.getDataInvestimento()));
		    stmt.setDouble(7, investimento.getValorRendimento());
		
		    stmt.execute();
		    stmt.close();
		} catch (SQLSyntaxErrorException t) {
			System.out.println("Tabela Investimento não existe.");
			throw new RuntimeException(t);
		}

	}
	
	public List<Investimento> select() throws SQLException {
		
		try {
			List<Investimento> investimentos = new ArrayList<>();
			String sql = "select * from t_investimento order by cd_investimento";
			PreparedStatement stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Investimento investimento = new Investimento();
				investimento.setCodigoInvestimento(rs.getInt("cd_investimento"));
				investimento.setNomeInvestimento(rs.getString("nm_investimento"));
				investimento.setDescInvestimento(rs.getString("ds_investimento"));
				investimento.setValorInvestimento(rs.getInt("vl_investimento"));
				investimento.setDataInvestimento(rs.getDate("dt_investimento").toLocalDate());
				investimento.setValorRendimento(rs.getDouble("vl_rendimento_investimento"));
				
				investimentos.add(investimento);
			}
			
			stmt.close();
			rs.close();
			
			return investimentos;
		} catch (SQLSyntaxErrorException t) {
			System.out.println("Tabela Investimento não existe.");
			throw new RuntimeException(t);
		}
	
	}
	
	public Investimento selectByCd(int codigoInvestimento) throws SQLException {
		
		try {
			Investimento investimento = null;
			String sql = "select * from t_investimento where cd_investimento = ?";
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, codigoInvestimento);
	        ResultSet rs = stmt.executeQuery();

	        while (rs.next()) {
	        	investimento = new Investimento();
				investimento.setCodigoInvestimento(rs.getInt("cd_investimento"));
				investimento.setNomeInvestimento(rs.getString("nm_investimento"));
				investimento.setDescInvestimento(rs.getString("ds_investimento"));
				investimento.setValorInvestimento(rs.getInt("vl_investimento"));
				investimento.setDataInvestimento(rs.getDate("dt_investimento").toLocalDate());
				investimento.setValorRendimento(rs.getDouble("vl_rendimento_investimento"));
	        }

	        stmt.close();
	        rs.close();

	        return investimento;
		} catch (SQLSyntaxErrorException t) {
			System.out.println("Tabela Investimento não existe.");
			throw new RuntimeException(t);
		}

    }

    public void delete(int codigoInvestimento) throws SQLException {
		
		try {
	        String sql = "delete from t_investimento where cd_investimento = ?";
	        PreparedStatement stmt = conexao.prepareStatement(sql);
	        stmt.setInt(1, codigoInvestimento);
	        stmt.execute();
	        stmt.close();
		} catch (SQLSyntaxErrorException t) {
			System.out.println("Tabela Investimento não existe.");
			throw new RuntimeException(t);
		}

    }
    
    public void update(Investimento investimento) throws SQLException {
    	
		try {
			String sql = "update t_investimento "
	        		+ "set nm_investimento = ?, ds_investimento = ?, vl_investimento = ?, "
	        		+ "dt_investimento = ?, vl_rendimento = ? where cd_investimento = ?";
	        PreparedStatement stmt = conexao.prepareStatement(sql);
	
	        stmt.setString(1, investimento.getNomeInvestimento());
	        stmt.setString(2, investimento.getDescInvestimento());
	        stmt.setDouble(3, investimento.getValorInvestimento());
	        stmt.setDate(4, Date.valueOf(investimento.getDataInvestimento()));
	        stmt.setDouble(5, investimento.getValorRendimento());
	        stmt.setInt(6, investimento.getCodigoInvestimento());
	
	        stmt.execute();
	        stmt.close();
	        
		} catch (SQLSyntaxErrorException t) {
	        System.out.println("Tabela Investimento não existe. Erro ao tentar atualizar investimento.");
	        throw new RuntimeException(t);
	    }
		
    }
    
}
