package web2.ifpe.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Candidato {

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Integer id;
	
	@Size(min=8, max=50)
	@NotBlank(message = "Nome deve ser preenchido")
	private String nome;
	
	@Size(min=2, max=15)
	@NotBlank(message = "Nome da chapa deve ser preenchido")
	private String chapa;
	
	@ManyToOne
	private Eleicao eleicao;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getChapa() {
		return chapa;
	}
	public void setChapa(String chapa) {
		this.chapa = chapa;
	}
	public Eleicao getEleicao() {
		return eleicao;
	}
	public void setEleicao(Eleicao eleicao) {
		this.eleicao = eleicao;
	}
	
}
	
	
	

