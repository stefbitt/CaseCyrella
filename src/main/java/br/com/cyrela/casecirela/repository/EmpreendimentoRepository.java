package br.com.cyrela.casecirela.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cyrela.casecirela.entity.PjoEmpreendimento;

public interface EmpreendimentoRepository extends JpaRepository<PjoEmpreendimento, Long>{

}
