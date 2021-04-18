package br.com.cyrela.casecirela.controler;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.cyrela.casecirela.repository.AgendamentoRepository;
import br.com.cyrela.casecirela.entity.*;

@RestController
@RequestMapping("/cirela/agendamento")
public class AgendamentoResource {
	@Autowired
	private AgendamentoRepository agendamentoRepository;

	@GetMapping
	ResponseEntity<List<Agendamento>> getAllAgendamentos(@RequestParam(required = false) String empreendimento) {
		try {
			List<Agendamento> agendamento = new ArrayList<Agendamento>();

			if (empreendimento == null)
				agendamentoRepository.findAll().forEach(agendamento::add);
			else
				agendamentoRepository.findByEmpreendimentoNomeContainingIgnoreCase(empreendimento).forEach(agendamento::add);

			if (agendamento.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(agendamento, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{numeroAgendamento}")
	public ResponseEntity<Agendamento> getTutorialById(@PathVariable("numeroAgendamento") long numeroAgendamento) {
		Optional<Agendamento> agendamento = agendamentoRepository.findById(numeroAgendamento);

		if (agendamento.isPresent()) {
			return new ResponseEntity<>(agendamento.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<Agendamento> createAgendamento(@RequestBody Agendamento agendamentoRequest) {
		try {
			Agendamento agendamento = agendamentoRepository.save(agendamentoRequest);
			return new ResponseEntity<>(agendamento, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{numeroAgendamento}")
	public ResponseEntity<Agendamento> updateTutorial(@PathVariable("numeroAgendamento") long numeroAgendamento,
			@RequestBody Agendamento agendamentoRequest) {
		Optional<Agendamento> agendamento1 = agendamentoRepository.findById(numeroAgendamento);

		if (agendamento1.isPresent()) {
			Agendamento _agendamento = agendamento1.get();

			_agendamento.setActualEnd(agendamentoRequest.getActualEnd());
			_agendamento.setActualStart(agendamentoRequest.getActualStart());
			_agendamento.setPjoTipoAtividade(agendamentoRequest.getPjoTipoAtividade());
			_agendamento.setSubject(agendamentoRequest.getSubject());
			return new ResponseEntity<>(agendamentoRepository.save(_agendamento), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	 @DeleteMapping("/{numeroAgendamento}")
	  public ResponseEntity<HttpStatus> deleteAgendamento(@PathVariable("numeroAgendamento") long numeroAgendamento) {
	    try {
	    	 
	     agendamentoRepository.deleteById(numeroAgendamento);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	  @DeleteMapping
	  public ResponseEntity<HttpStatus> deleteAllAgedamentos() {
	    try {
	    agendamentoRepository.deleteAll();
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }

	  }
	
	

}
