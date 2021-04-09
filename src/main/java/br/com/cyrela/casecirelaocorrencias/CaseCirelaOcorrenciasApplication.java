package br.com.cyrela.casecirelaocorrencias;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.cyrela.casecirelaocorrencias.entity.Ocorrencia;
import br.com.cyrela.casecirelaocorrencias.repositori.OcorrenciaRepository;

@SpringBootApplication
public class CaseCirelaOcorrenciasApplication implements CommandLineRunner{
	@Autowired
	private	OcorrenciaRepository ocorrenciaRepository;

	public static void main(String[] args) {
		SpringApplication.run(CaseCirelaOcorrenciasApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {

		Ocorrencia o1 = new Ocorrencia(1,100,1,"A","150","Vivaz","Trinca na janela");
		Ocorrencia o2 = new Ocorrencia(2,130,1,"B","350","Vivaz","Porta com defeito");
		Ocorrencia o3 = new Ocorrencia(3,150,1,"C","750","Vivaz","Piso quebrado");
		Ocorrencia o4 = new Ocorrencia(4,350,1,"C","850","Vivaz","Não sai agua na pia");
		Ocorrencia o5 = new Ocorrencia(5,650,1,"A","250","Vivaz","Gabinete da pia quebrado");
   
		ocorrenciaRepository.saveAll(Arrays.asList(o1,o2,o3,o4,o5));
	}

}
