package br.com.cyrela.casecirelaocorrencias.repositori;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cyrela.casecirelaocorrencias.entity.Ocorrencia;

@Repository
public interface OcorrenciaRepository extends JpaRepository<Ocorrencia, Integer> {
}