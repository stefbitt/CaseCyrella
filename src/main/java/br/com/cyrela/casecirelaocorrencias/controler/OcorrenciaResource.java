package br.com.cyrela.casecirelaocorrencias.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.cyrela.casecirelaocorrencias.entity.Ocorrencia;
import br.com.cyrela.casecirelaocorrencias.repositori.OcorrenciaRepository;

@RestController
@RequestMapping("ocorrencia")
public class OcorrenciaResource {
    @Autowired
    private OcorrenciaRepository ocorrenciaRepository;
    
    @GetMapping
    public List<Ocorrencia> listar() {
        return ocorrenciaRepository.findAll();
    }
    @GetMapping("{id}")
    public Ocorrencia  buscar(@PathVariable Integer id) {
		return ocorrenciaRepository.findById(id).get(); 
   	}
    	
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Ocorrencia cadastrar(@RequestBody Ocorrencia ocorrencia) {
        return ocorrenciaRepository.save(ocorrencia);
    }
    @PutMapping("{id}")
    public Ocorrencia atualizar(@RequestBody Ocorrencia ocorrencia, @PathVariable Integer id) {
        ocorrencia.setNumeroOcorrencia(id);
        return ocorrenciaRepository.save(ocorrencia);
    }
    @DeleteMapping("{id}")
    public void remover(@PathVariable Integer id) {
        ocorrenciaRepository.deleteById(id);
    }
}