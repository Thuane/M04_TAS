package web2.ifpe.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class Eleicao {
  
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Integer id;
	
	@Size(min=6, max=15)
	@NotBlank(message = "Cargo deve ser preenchido")
	private String descricao;
	
	@Future
	@NotNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date dataVotacao;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	} 
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getDataVotacao() {
		return dataVotacao;
	}
	public void setDataVotacao(Date dataVotacao) {
		this.dataVotacao = dataVotacao;
	}	
	
}
