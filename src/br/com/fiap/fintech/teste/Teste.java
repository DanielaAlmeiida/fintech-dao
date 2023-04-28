package br.com.fiap.fintech.teste;

import br.com.fiap.fintech.dao.*;
import br.com.fiap.fintech.model.*;
import br.com.fiap.fintech.model.Usuario;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class Teste {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
	
        UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario dani = new Usuario();
		
		dani.setCodigoUsuario(10);
		dani.setNomeUsuario("Dani");
		dani.setEmail("dani@gmail.com");
		dani.setSenha("dani#123");
		dani.setDataNascimento(LocalDate.of(2003, 4, 8));
		dani.setGenero("Feminino");

		usuarioDAO.insert(dani);


		RendaDAO rendaDAO = new RendaDAO();
		Renda trabalho = new Renda();
		
		trabalho.setCodigoRenda(2);
		trabalho.setDataRenda(LocalDate.of(2023, 04, 02));
		trabalho.setDescRenda("Emprego Principal");
		trabalho.setNomeRenda("Salário");
		trabalho.setValorRenda(6500);
		
		rendaDAO.insert(dani, trabalho);
		
		
		MetaDAO metaDAO = new MetaDAO();
		Meta maio = new Meta();
		
		maio.setCodigoMeta(2);
		maio.setNomeMeta("Viagem");
		maio.setDescMeta("Viagem de Natal");
		maio.setValorMeta(3000);
		maio.setDataInicioMeta(LocalDate.of(2025, 12, 25));
		maio.setDataTerminoMeta(LocalDate.of(2026, 12, 25));

		metaDAO.insert(dani, maio); 
		
		
		InvestimentoDAO investimentoDAO = new InvestimentoDAO();
		Investimento investimento = new Investimento();

		investimento.setCodigoInvestimento(2);
		investimento.setNomeInvestimento("Ações Petrobras");
		investimento.setDescInvestimento("Compra de ações da Petrobras");
		investimento.setValorInvestimento(5000);
		investimento.setDataInvestimento(LocalDate.of(2023, 4, 1));
		investimento.setValorRendimento(3);

		investimentoDAO.insert(dani, investimento);
		
		
		GastoDAO gastoDAO = new GastoDAO();
		Gasto mercado = new Gasto();
		
		mercado.setCodigoGasto(2);
		mercado.setDataGasto(LocalDate.of(2023, 04, 02));
		mercado.setDescGasto("Mercado descrição");
		mercado.setNomeGasto("Mercado Nome");
		mercado.setValorGasto(500);
		
		gastoDAO.insert(dani, mercado);

		
		CartaoDAO cartaoDAO = new CartaoDAO();
		Cartao meuCartao = new Cartao();

		meuCartao.setCodigoCartao(2);
		meuCartao.setNomeCartao("Meu cartão");
		meuCartao.setDescCartao("Descrição do meu cartão");
		meuCartao.setNumeroCartao("1234 5678 9012 3456");
		meuCartao.setDataVencimento(LocalDate.of(2023, 8, 8));
		meuCartao.setNumeroCVV("123");
		meuCartao.setValorLimite(2000.00);

		cartaoDAO.insert(dani, meuCartao);
			
		
		
		
		/**** CRUD no Usuario ****/
		
		// CRUD - CREATE/INSERT
		Usuario ana = new Usuario();
		ana.setCodigoUsuario(11);
		ana.setNomeUsuario("Ana");
		ana.setEmail("ana@gmail.com");
		ana.setSenha("ana#123");
		ana.setDataNascimento(LocalDate.of(2000, 3, 15));
		ana.setGenero("Feminino");
		usuarioDAO.insert(ana);
		

		// CRUD - READ/SELECT
		List<Usuario> usuarios = usuarioDAO.select();	

		for(Usuario usuario : usuarios) {
			System.out.println(usuario.toString());
		} 
		
		
		// CRUD - READ/SELECT
		System.out.println("Select where: " + usuarioDAO.selectByCd(11));
		
		
		// CRUD - UPDATE
		dani.setNomeUsuario("Dannyel");
		dani.setEmail("dannyel@gmail.com");
		dani.setGenero("Masculino");
		usuarioDAO.update(dani);
		
		
		// CRUD - DELETE
		usuarioDAO.delete(11);
		
		
		
//      System.out.println(usuarioDAO.select());
//      System.out.println(rendaDAO.select());
//      System.out.println(gastoDAO.select());
//      System.out.println(metaDAO.select());
//      System.out.println(cartaoDAO.select());
//      System.out.println(investimentoDAO.select());
	}

}
