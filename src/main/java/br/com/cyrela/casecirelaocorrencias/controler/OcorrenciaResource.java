package br.com.cyrela.casecirelaocorrencias.controler;

import java.util.List;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.cyrela.casecirelaocorrencias.entity.Ocorrencia;
import br.com.cyrela.casecirelaocorrencias.service.OcorrenciaService;

@RestController
@RequestMapping("ocorrencia")
public class OcorrenciaResource {

    @Autowired
    private OcorrenciaService ocorrenciaService;
    
    @GetMapping
    public ResponseEntity<List<Ocorrencia>> listar() {
        List <Ocorrencia> list = ocorrenciaService.findAll(); 
        return ResponseEntity.ok().body(list);
    }
    @GetMapping("{id}")
    public ResponseEntity<Ocorrencia>  buscar(@PathVariable Integer id) {
		Ocorrencia obj = ocorrenciaService.findById(id);
		return ResponseEntity.ok().body(obj);
   	}
    	
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Ocorrencia cadastrar(@RequestBody Ocorrencia ocorrencia) {
        return ocorrenciaService.save(ocorrencia);
    }
    @PutMapping("{id}")
    public Ocorrencia atualizar(@RequestBody Ocorrencia ocorrencia, @PathVariable Integer id) {
        ocorrencia.setNumeroOcorrencia(id);
        return ocorrenciaService.save(ocorrencia);
    }
    @DeleteMapping("{id}")
    public void remover(@PathVariable Integer id) {
        ocorrenciaService.deleteById(id);
    }
}