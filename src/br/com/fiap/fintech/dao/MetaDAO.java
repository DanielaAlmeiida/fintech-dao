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
import br.com.fiap.fintech.model.Meta;
import br.com.fiap.fintech.model.Usuario;

public class MetaDAO {
	
	private Connection conexao;
	
	public MetaDAO() throws ClassNotFoundException {
		this.conexao = new ConnectionFactory().conectar();
	}
	
	public void insert(Usuario usuario, Meta meta) throws SQLException {
		try {
			String sql = "insert into t_meta"
					+ "(cd_usuario, cd_meta, nm_meta, ds_meta, vl_meta, dt_inicio, dt_termino)"
					+ "values(?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setInt(1, usuario.getCodigoUsuario());
		    stmt.setInt(2, meta.getCodigoMeta());
		    stmt.setString(3, meta.getNomeMeta());
		    stmt.setString(4, meta.getDescMeta());
		    stmt.setDouble(5, meta.getValorMeta());
		    stmt.setDate(6, Date.valueOf(meta.getDataInicioMeta()));
		    stmt.setDate(7, Date.valueOf(meta.getDataTerminoMeta()));
		
		    stmt.execute();
		    stmt.close();
		} catch (SQLSyntaxErrorException t) {
			System.out.println("Tabela Meta não existe.");
			throw new RuntimeException(t);
		}
		
	}
	
	public List<Meta> select() throws SQLException {
		
		try {
			List<Meta> metas = new ArrayList<>();
			String sql = "select * from t_meta order by cd_meta";
			PreparedStatement stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Meta meta = new Meta();
				meta.setCodigoMeta(rs.getInt("cd_meta"));
				meta.setNomeMeta(rs.getString("nm_meta"));
				meta.setDescMeta(rs.getString("ds_meta"));
				meta.setValorMeta(rs.getInt("vl_meta"));
				meta.setDataInicioMeta(rs.getDate("dt_inicio").toLocalDate());
				meta.setDataTerminoMeta(rs.getDate("dt_termino").toLocalDate());
				
				metas.add(meta);
			}
			
			stmt.close();
			rs.close();
			
			return metas;	
		} catch (SQLSyntaxErrorException t) {
			System.out.println("Tabela Meta não existe.");
			throw new RuntimeException(t);
		}
		
	}
	
	public Meta selectByCd(int codigoMeta) throws SQLException {
		try {
			Meta meta = null;
			String sql = "select * from t_meta where cd_meta = ?";
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, codigoMeta);
	        ResultSet rs = stmt.executeQuery();

	        while (rs.next()) {
	        	meta = new Meta();
				meta.setCodigoMeta(rs.getInt("cd_meta"));
				meta.setNomeMeta(rs.getString("nm_meta"));
				meta.setDescMeta(rs.getString("ds_meta"));
				meta.setValorMeta(rs.getInt("vl_meta"));
				meta.setDataInicioMeta(rs.getDate("dt_inicio").toLocalDate());
				meta.setDataTerminoMeta(rs.getDate("dt_termino").toLocalDate());
	        }

	        stmt.close();
	        rs.close();

	        return meta;
		} catch (SQLSyntaxErrorException t) {
			System.out.println("Tabela Meta não existe.");
			throw new RuntimeException(t);
		}
		
    }

    public void delete(int codigoMeta) throws SQLException {
    	try {
    		String sql = "delete from t_meta where cd_meta = ?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(2, codigoMeta);
            stmt.execute();
            stmt.close();
    	} catch (SQLSyntaxErrorException t) {
			System.out.println("Tabela Meta não existe.");
			throw new RuntimeException(t);
		}
    }
    
    public void update(Meta meta) throws SQLException {
    	
		try {
			String sql = "update t_meta "
	        		+ "set nm_meta = ?, ds_meta = ?, vl_meta = ?, dt_inicio = ?, dt_termino = ? where cd_meta = ?";
	        PreparedStatement stmt = conexao.prepareStatement(sql);
	
	        stmt.setString(1, meta.getNomeMeta());
	        stmt.setString(2, meta.getDescMeta());
	        stmt.setDouble(3, meta.getValorMeta());
	        stmt.setDate(4, Date.valueOf(meta.getDataInicioMeta()));
	        stmt.setDate(5, Date.valueOf(meta.getDataTerminoMeta()));
	        stmt.setInt(6, meta.getCodigoMeta());
	
	        stmt.execute();
	        stmt.close();
	        
		} catch (SQLSyntaxErrorException t) {
	        System.out.println("Tabela Meta não existe. Erro ao tentar atualizar meta.");
	        throw new RuntimeException(t);
	    }
    
	}

	
	
}

