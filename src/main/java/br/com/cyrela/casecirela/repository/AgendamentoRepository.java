package br.com.cyrela.casecirela.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.cyrela.casecirela.entity.*;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
	  List<Agendamento> findByEmpreendimentoContaining(String empreendimento);


}
