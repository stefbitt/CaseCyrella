package br.com.cyrela.casecirela.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "T_PJO_AGENDAMENTO")
//@SequenceGenerator(name="agendamento",sequenceName="sq_t_agendamento",allocationSize=1)
public class Agendamento implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "nr_agendamento")
	private Long numeroAgendamento;
	
	@NotNull
	@Future
	@Column(name = "actual_start")
	private LocalDate actualStart;
	
	@Column(name = "actual_end")
	private LocalDate actualEnd;
	
	@NotNull 
	@NotBlank
	@Size(max = 30)
	@Column(name = "pjo_tp_atividade")
	private String pjoTipoAtividade;
	
	@NotNull 
	@NotBlank
	@Size(max = 120)
	@Column(name = "subject")
	private String subject;
	
	@OneToOne
	private PjoEmpreendimento empreendimento;
	
	public Agendamento() {
		super();
	}

	public Agendamento(Long numeroAgendamento,
			@NotNull LocalDate actualStart,
			LocalDate actualEnd,
			@NotNull @Size(max = 30) String pjoTipoAtividade,
			@NotNull @Size(max = 120) String subject,
			@NotNull PjoEmpreendimento empreendimento) {
		super();
		this.numeroAgendamento = numeroAgendamento;
		this.actualStart = actualStart;
		this.actualEnd = actualEnd;
		this.pjoTipoAtividade = pjoTipoAtividade;
		this.subject = subject;
		this.empreendimento = empreendimento;
	}

	public Long getNumeroAgendamento() {
		return numeroAgendamento;
	}

	public void setNumeroAgendamento(Long numeroAgendamento) {
		this.numeroAgendamento = numeroAgendamento;
	}

	public LocalDate getActualStart() {
		return actualStart;
	}

	public void setActualStart(LocalDate actualStart) {
		this.actualStart = actualStart;
	}

	public LocalDate getActualEnd() {
		return actualEnd;
	}

	public void setActualEnd(LocalDate actualEnd) {
		this.actualEnd = actualEnd;
	}

	public String getPjoTipoAtividade() {
		return pjoTipoAtividade;
	}

	public void setPjoTipoAtividade(String pjoTipoAtividade) {
		this.pjoTipoAtividade = pjoTipoAtividade;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public PjoEmpreendimento getEmpreendimento() {
		return empreendimento;
	}

	public void setEmpreendimento(PjoEmpreendimento empreendimento) {
		this.empreendimento = empreendimento;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	
}
