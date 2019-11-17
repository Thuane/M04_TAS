package web2.ifpe.controller;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import web2.ifpe.model.Candidato;
import web2.ifpe.model.CandidatoDAO;
import web2.ifpe.model.EleicaoDAO;


@Controller
public class CandidatoController {


	@Autowired
	private CandidatoDAO candidatoDAO;
	@Autowired
	private EleicaoDAO eleicaoDAO;
	
	@GetMapping("/listarCandidatos")
	public String listarCandidato(Model model) {
		model.addAttribute("lista",candidatoDAO.findAll(Sort.by("nome")));
		return "candidato/candidato-list";
	}
	
	@GetMapping("/exibirFormCandidato")
	public String exibirForm(Candidato candidato, Model model) {
		model.addAttribute("listaEleicao", this.eleicaoDAO.findAll(Sort.by("descricao")));
		return "candidato/candidato-form";
	}
	
	@PostMapping("/salvarCandidato")
	public String salvarCandidato(@Valid Candidato candidato, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return exibirForm(candidato, model);
		}
		this.candidatoDAO.save(candidato);
		return "redirect:listarCandidatos";
	}
	
	@GetMapping("/editarCandidato")
	public String editarCandidato(Integer id, Model model) {
		 model.addAttribute("candidato", this.candidatoDAO.findById(id));
		 model.addAttribute("listaEleicao",this.eleicaoDAO.findAll(Sort.by("descricao")));
		 return "candidato/candidato-form";
		 
	}
	
	@GetMapping("/removerCandidato")
	public String removerCandidato(Integer id) {
		this.candidatoDAO.deleteById(id);
		return "redirect:/listarCandidatos";
	}
	
	
	//----------------------------------------------------- //
	
	
}
