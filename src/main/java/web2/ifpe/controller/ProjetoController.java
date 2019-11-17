package web2.ifpe.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import web2.ifpe.model.CandidatoDAO;
import web2.ifpe.model.Projeto;
import web2.ifpe.model.ProjetoDAO;

@Controller
public class ProjetoController {

	@Autowired
	private ProjetoDAO projetoDAO;
	@Autowired
	private CandidatoDAO candidatoDAO;
	
	@GetMapping("/listarProjeto")
	public String exibirLista(Model model) {
		model.addAttribute("lista", this.projetoDAO.findAll(Sort.by("nomeDoProjeto")));
		return "projeto/projeto-list";
	}
	
	@GetMapping("/exibirFormProjeto")
	public String exibirForm(Projeto projeto, Model model) {
		model.addAttribute("listaCandidato", this.candidatoDAO.findAll((Sort.by("nome"))));
		return "projeto/projeto-form";
	}
	
	@PostMapping("/salvarProjeto")
	public String salvarProjeto(@Valid Projeto projeto, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return exibirForm(projeto, model);
		}
		this.projetoDAO.save(projeto);
		return "redirect:/listarProjeto";
	}
	
	@GetMapping("/editarProjeto")
	public String editarProjeto(Integer id, Model model) {
		model.addAttribute("projeto", this.projetoDAO.findById(id));
		model.addAttribute("listaCandidato",this.candidatoDAO.findAll(Sort.by("nome")));
		return "projeto/projeto-form";
	}
	
	@GetMapping("/removerProjeto")
	public String removerProjeto(Integer id) {
		this.projetoDAO.deleteById(id);
		return "redirect:/listarProjeto";
	}
}
