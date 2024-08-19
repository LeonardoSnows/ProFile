package br.com.profile.repository;

import br.com.profile.dto.ReferenciaDTO;
import br.com.profile.model.Referencia;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ReferenciaRepository extends MongoRepository<Referencia, String> {
    List<Referencia> findByPerfil(String idPerfil);
}
