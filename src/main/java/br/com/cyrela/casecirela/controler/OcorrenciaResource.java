package br.com.cyrela.casecirela.controler;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.cyrela.casecirela.entity.Ocorrencia;
import br.com.cyrela.casecirela.service.OcorrenciaService;

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
    	
//  @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
	public	ResponseEntity<Ocorrencia> cadastrar(@Valid @RequestBody Ocorrencia ocorrencia) {
		Ocorrencia obj = ocorrenciaService.insert(ocorrencia);
		java.net.URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getNumeroOcorrencia()).toUri();
		return	ResponseEntity.created(uri).build();
	}

     @PutMapping("{id}")
     public ResponseEntity<Ocorrencia> atualizar(@Valid @RequestBody Ocorrencia ocorrencia, @PathVariable Integer id) {
    	ocorrencia.setNumeroOcorrencia(id);
 		ocorrenciaService.update(ocorrencia);
 		return ResponseEntity.ok().body(ocorrencia);
 	}
     
    @DeleteMapping("{id}")
	public	ResponseEntity<Void> deleteById(@PathVariable Integer id) {
    	ocorrenciaService.delete(id);
		return ResponseEntity.noContent().build();
    }	
}