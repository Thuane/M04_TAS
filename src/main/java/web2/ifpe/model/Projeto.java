package web2.ifpe.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Projeto {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min=5, max=15)
	@NotBlank(message = "Nome do projeto deve ser preenchido")
	private String nomeDoProjeto;
	
	@Size(min=10, max=50)
	@NotBlank(message = "Breve descrição deve ser feita")
	private String descricao;
	
	@NotNull
	@ManyToOne
	private Candidato candidato;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNomeDoProjeto() {
		return nomeDoProjeto;
	}
	public void setNomeDoProjeto(String nomeDoProjeto) {
		this.nomeDoProjeto = nomeDoProjeto;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Candidato getCandidato() {
		return candidato;
	}
	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}
	
	
}
