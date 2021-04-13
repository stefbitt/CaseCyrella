package br.com.cyrela.casecirela.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "T_PJO_OCORRENCIA")
@SequenceGenerator(name="ocorrencia",sequenceName="sq_t_ocorrencia",allocationSize=1)

public class Ocorrencia implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ocorrencia")
	@Column(name = "nr_ocorrencia")
	private Integer numeroOcorrencia;

	@NotNull 
	@Min(value = 1, message = "Cliente deve ter um Identificador")
	@Column(name = "id_cliente_unidade")
	private Integer clienteDaUnidade;
	
	@NotNull 
	@Min(value = 1, message = "Empreendimentp deve ter um Identificador")
	@Column(name = "id_empreendimento")
	private Integer empreendimentoId;

	@NotNull 
	@Size(max = 20)
	@Column(name = "nr_bloco")
	private String bloco;

	@NotNull 
	@Size(max = 20)
	@Column(name = "nr_unidade")
	private String unidade;

	@NotNull 
	@Size(max = 20)
	@Column(name = "nm_unidade")
	private String bandeira;

	@NotNull 
	@Size(max = 100)
	@Column(name = "ds_ocorrencia")
	private String descricao;

	
	
	public Ocorrencia() {
		super();
	}

	public Ocorrencia(Integer numeroOcorrencia,
			@NotNull @Min(value = 1, message = "Cliente deve ter um Identificador") Integer clienteDaUnidade,
			@NotNull @Min(value = 1, message = "Empreendimentp deve ter um Identificador") Integer empreendimentoId,
			@NotNull @Size(max = 20) String bloco, @NotNull @Size(max = 20) String unidade,
			@NotNull @Size(max = 20) String bandeira, @NotNull @Size(max = 100) String descricao) {
		super();
		this.numeroOcorrencia = numeroOcorrencia;
		this.clienteDaUnidade = clienteDaUnidade;
		this.empreendimentoId = empreendimentoId;
		this.bloco = bloco;
		this.unidade = unidade;
		this.bandeira = bandeira;
		this.descricao = descricao;
	}

	public Integer getNumeroOcorrencia() {
		return numeroOcorrencia;
	}

	public void setNumeroOcorrencia(Integer numeroOcorrencia) {
		this.numeroOcorrencia = numeroOcorrencia;
	}

	public Integer getClienteDaUnidade() {
		return clienteDaUnidade;
	}

	public void setClienteDaUnidade(Integer clienteDaUnidade) {
		this.clienteDaUnidade = clienteDaUnidade;
	}

	public Integer getEmpreendimentoId() {
		return empreendimentoId;
	}

	public void setEmpreendimentoId(Integer empreendimentoId) {
		this.empreendimentoId = empreendimentoId;
	}

	public String getBloco() {
		return bloco;
	}

	public void setBloco(String bloco) {
		this.bloco = bloco;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public String getBandeira() {
		return bandeira;
	}

	public void setBandeira(String bandeira) {
		this.bandeira = bandeira;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
