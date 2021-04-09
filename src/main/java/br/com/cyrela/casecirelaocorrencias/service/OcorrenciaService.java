package br.com.cyrela.casecirelaocorrencias.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.cyrela.casecirelaocorrencias.entity.Ocorrencia;
import br.com.cyrela.casecirelaocorrencias.repositori.OcorrenciaRepository;
import br.com.cyrela.casecirelaocorrencias.service.exceptions.EntityNotFoundException;

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

	public Ocorrencia save(Ocorrencia ocorrencia) {
		return ocorrenciaRepository.save(ocorrencia);
	}

	public void deleteById(Integer id) {
        ocorrenciaRepository.deleteById(id); 
	}
}
