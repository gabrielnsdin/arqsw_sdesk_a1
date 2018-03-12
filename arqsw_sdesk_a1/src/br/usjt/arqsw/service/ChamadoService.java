package br.usjt.arqsw.service;

import java.io.IOException;
import java.util.ArrayList;

import br.usjt.arqsw.dao.ChamadoDAO;
import br.usjt.arqsw.entity.Chamado;
import br.usjt.arqsw.entity.Fila;

/**
 * 
 * @author Gabriel do Nascimento RA 816113722
 *
 */
public class ChamadoService {

	private ChamadoDAO dao;

	public ChamadoService() {
		dao = new ChamadoDAO();
	}

	public int criarChamado(Chamado chamado) throws IOException{
		 int id = dao.criarChamado(chamado);
		 return id;
	}
	
	public ArrayList<Chamado> listarChamados(Fila fila) throws IOException {
		ArrayList<Chamado> chamados = dao.listarChamados(fila);
		return chamados;
	}
	
	public void fecharChamado(int id) throws IOException {
		dao.fecharChamado(id);
	}
	
	public Chamado carregarChamado(int id) throws IOException {
		Chamado chamado = dao.carregarChamado(id);
		return chamado;
	}
}
