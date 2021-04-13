package br.com.cyrela.casecirela.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cyrela.casecirela.entity.Ocorrencia;
import br.com.cyrela.casecirela.repository.OcorrenciaRepository;
import br.com.cyrela.casecirela.service.exceptions.EntityNotFoundException;

@Service
public class OcorrenciaService {
    @Autowired
    private OcorrenciaRepository ocorrenciaRepository;
    
	public Ocorrencia findById(Integer id) {
		return	ocorrenciaRepository.findById(id).orElseThrow(
				() -> new EntityNotFoundException("Id não encontrado " + id));
	}

	public List<Ocorrencia> findAll() {
		  return ocorrenciaRepository.findAll();
	}

	public Ocorrencia insert(Ocorrencia ocorrencia) {
		ocorrencia.setNumeroOcorrencia(null);
		return ocorrenciaRepository.save(ocorrencia);
	}
	public Ocorrencia update(Ocorrencia ocorrencia) {
		findById(ocorrencia.getNumeroOcorrencia());
		return ocorrenciaRepository.save(ocorrencia);
	}

	public void delete(Integer id) {
		findById(id);
		ocorrenciaRepository.deleteById(id);
	}	
}
