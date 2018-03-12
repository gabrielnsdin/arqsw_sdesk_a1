package br.usjt.arqsw.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.usjt.arqsw.entity.Chamado;
import br.usjt.arqsw.entity.Fila;

/**
 * 
 * @author Gabriel do Nascimento RA 816113722
 *
 */
public class ChamadoDAO {
	
	public int criarChamado(Chamado chamado) throws IOException {
		String query = "insert into chamado values (null, ?, ?, CURRENT_TIMESTAMP(), null, ?)";
		int id;
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement pst = conn.prepareStatement(query);) {

			pst.setString(1, chamado.getDescricao());
			pst.setString(2, chamado.getStatus());
			pst.setInt(3, chamado.getFila().getId());
			id = pst.executeUpdate();

		} catch (SQLException e) {
			throw new IOException(e);
		}
		return id;
	}
	
	public ArrayList<Chamado> listarChamados(Fila fila) throws IOException {
		String query = "select id_chamado, descricao, status, dt_abertura, dt_fechamento, id_fila from chamado "
					 + "where id_fila=?";
		ArrayList<Chamado> chamados = new ArrayList<>();
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement pst = conn.prepareStatement(query);) {

			pst.setInt(1, fila.getId());
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Chamado chamado = new Chamado();
				chamado.setId(rs.getInt("id_chamado"));
				chamado.setDescricao(rs.getString("descricao"));
				chamado.setStatus(rs.getString("status"));
				chamado.setDtAbertura(rs.getDate("dt_abertura"));
				chamado.setDtFechamento(rs.getDate("dt_fechamento"));
				chamado.setFila(new Fila());
				chamado.getFila().setId(rs.getInt("id_fila"));
				chamados.add(chamado);
			}

		} catch (SQLException e) {
			throw new IOException(e);
		}
		return chamados;
	}
	
	public void fecharChamado(int id) throws IOException {
		String query = "update chamado set status='Fechado', dt_fechamento=CURRENT_TIMESTAMP()"
					 + "where chamado.id_chamado=?";
		
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement pst = conn.prepareStatement(query);) {
			
			pst.setInt(1, id);
			pst.executeUpdate();

		} catch (SQLException e) {
			throw new IOException(e);
		}
	}
	
	public Chamado carregarChamado(int id) throws IOException {
		String query = "select id_chamado, descricao, status, dt_abertura, dt_fechamento, id_fila from chamado "
					 + "where id_chamado=?";
		Chamado chamado = new Chamado();
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement pst = conn.prepareStatement(query);) {

			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				chamado.setId(rs.getInt("id_chamado"));
				chamado.setDescricao(rs.getString("descricao"));
				chamado.setStatus(rs.getString("status"));
				chamado.setDtAbertura(rs.getDate("dt_abertura"));
				chamado.setDtFechamento(rs.getDate("dt_fechamento"));
				chamado.setFila(new Fila());
				chamado.getFila().setId(rs.getInt("id_fila"));
			}

		} catch (SQLException e) {
			throw new IOException(e);
		}
		return chamado;
	}

}
