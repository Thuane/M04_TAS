package web2.ifpe.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import web2.ifpe.model.Eleicao;
import web2.ifpe.model.EleicaoDAO;

@Controller
public class EleicaoController {

	@Autowired
	private EleicaoDAO eleicaoDAO;
	
	@GetMapping("/listarEleicao")
	public String exibirLista(Model model) {
		model.addAttribute("lista", eleicaoDAO.findAll(Sort.by("descricao")));
		return "eleicao/eleicao-list";
	}
	
	@GetMapping("/exibirFormEleicao")
	public String exibirForm(Eleicao eleicao, Model model) {
		return "eleicao/eleicao-form";
	}
	
	@PostMapping("/salvarEleicao")
	public String salvarEleicao(@Valid Eleicao eleicao, BindingResult result ,Model model) {
		if(result.hasErrors()) {
			return exibirForm(eleicao, model);
		}
		this.eleicaoDAO.save(eleicao);		
		return "redirect:/listarEleicao";
	}
	
	@GetMapping("/editarEleicao")
	public String editarEleicao(Integer id, Model model) {
		model.addAttribute("eleicao", this.eleicaoDAO.findById(id));
		return "eleicao/eleicao-form";
	}
	
	@GetMapping("/removerEleicao")
	public String removerEleicao(Integer id) {
		this.eleicaoDAO.deleteById(id);
		return "redirect:/listarEleicao";
	}
}
