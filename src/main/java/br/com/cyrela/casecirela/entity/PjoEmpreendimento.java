package br.com.cyrela.casecirela.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "T_PJO_EMPREENDIMENTO")
@SequenceGenerator(name="empreedimento",sequenceName="sq_t_empreendimento",allocationSize=1)
public class PjoEmpreendimento  implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "empreendimento")
	@Column(name = "nr_empreendimento")
	private Integer numeroEmpreendimento;
	
	@NotNull 
	@NotBlank
	@Size(max = 30)
	@Column(name = "pjo_empreendimento")
	private String empreendimento;
	
	
	@NotNull 
	@NotBlank
	@Size(max = 10)
	@Column(name = "pjo_bloco")
	private String bloco;
	
	@NotNull 
	@NotBlank
	@Column(name = "pjo_unidade")
	private Integer unidade;

	public PjoEmpreendimento(Integer numeroEmpreendimento,
			@NotNull @Size(max = 30) String empreendimento,
			@NotNull @Size(max = 30) String bloco,
			@NotNull Integer unidade){
		super();
		this.numeroEmpreendimento = numeroEmpreendimento;
		this.empreendimento = empreendimento;
		this.bloco = bloco;
		this.unidade = unidade;
	}
	
	
	

	public String getEmpreendimento() {
		return empreendimento;
	}




	public void setEmpreendimento(String empreendimento) {
		this.empreendimento = empreendimento;
	}




	public Integer getNumeroEmpreendimento() {
		return numeroEmpreendimento;
	}

	public void setNumeroEmpreendimento(Integer numeroEmpreendimento) {
		this.numeroEmpreendimento = numeroEmpreendimento;
	}

	public String getBloco() {
		return bloco;
	}

	public void setBloco(String bloco) {
		this.bloco = bloco;
	}

	public Integer getUnidade() {
		return unidade;
	}

	public void setUnidade(Integer unidade) {
		this.unidade = unidade;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
