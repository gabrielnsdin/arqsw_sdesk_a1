package br.usjt.arqsw.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.usjt.arqsw.entity.Chamado;
import br.usjt.arqsw.entity.Fila;
import br.usjt.arqsw.service.ChamadoService;
import br.usjt.arqsw.service.FilaService;
/**
 * 
 * @author asbonato
 *
 */
@Controller
public class ManterChamadosController {
	private FilaService filaService;
	private ChamadoService chamadoService;

	public ManterChamadosController() {
		filaService = new FilaService();
		chamadoService = new ChamadoService();
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping("index")
	public String inicio() {
		return "index";
	}

	private List<Fila> listarFilas() throws IOException{
			return filaService.listarFilas();
	}
	
	/**
	 * 
	 * @param model Acesso a request http
	 * @return JSP de Listar Chamados
	 */
	@RequestMapping("/listar_filas_exibir")
	public String listarFilasExibir(Model model) {
		try {
			model.addAttribute("filas", listarFilas());
			return "ChamadoListar";
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}
	
	@RequestMapping("/listar_chamados_exibir")
	public String listarChamadosExibir(@Valid Fila fila, BindingResult result, Model model) {
		try {
			if (result.hasFieldErrors("id")) {
				model.addAttribute("filas", listarFilas());
				System.out.println("Deu erro " + result.toString());
				return "ChamadoListar";
				//return "redirect:listar_filas_exibir";
			}
			fila = filaService.carregar(fila.getId());
			model.addAttribute("fila", fila);

			ArrayList<Chamado> chamados = chamadoService.listarChamados(fila);
			model.addAttribute("chamados", chamados);
			
			return "ChamadoListarExibir";

		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}
	
	@RequestMapping("/criar_chamado_exibir")
	public String criarChamado(Model model) {
		try {
			model.addAttribute("filas", listarFilas());
			return "ChamadoCriarExibir";
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}	
	}
	
	@RequestMapping("/criar_chamado_inserir")
	public String criarChamado(@Valid Fila fila, BindingResult result, @RequestParam("descricao") String descricao, Model model) {
		try {
			if (result.hasFieldErrors("id")) {
				model.addAttribute("filas", listarFilas());
				System.out.println("Deu erro " + result.toString());
				return "ChamadoCriarExibir";
				//return "redirect:listar_filas_exibir";
			}
			fila = filaService.carregar(fila.getId());
			model.addAttribute("fila", fila);
			
			System.out.println(fila);
			
			Chamado chamado = new Chamado();
			chamado.setFila(fila);
			chamado.setDescricao(descricao);
			chamado.setStatus("Aberto");
			chamadoService.criarChamado(chamado);
			
			return "redirect:listar_chamados_exibir?id=" + fila.getId();
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}	
	}
	
	@RequestMapping("/fechar_chamado")
	public String atualizarChamado (@Valid Fila fila, BindingResult result, @RequestParam("id") int id, Model model) {
		try {
			if (result.hasFieldErrors("id")) {
				model.addAttribute("filas", listarFilas());
				System.out.println("Deu erro " + result.toString());
				return "ChamadoListar";
				//return "redirect:listar_filas_exibir";
			}
			fila = filaService.carregar(fila.getId());
			model.addAttribute("fila", fila);
			
			System.out.println(fila);
			chamadoService.fecharChamado(id);
			
			return "redirect:listar_filas_exibir";
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}	
	}

}
