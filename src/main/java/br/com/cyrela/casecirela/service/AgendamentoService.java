package br.com.cyrela.casecirela.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cyrela.casecirela.repository.AgendamentoRepository;

@Service
public class AgendamentoService {
	@Autowired
	private AgendamentoRepository agendamentoRepository;
	


}
