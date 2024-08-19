package br.com.profile.repository;

import br.com.profile.model.Habilidades;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface HabilidadeRepository extends MongoRepository<Habilidades, String> {

    List<Habilidades> findByPerfil(String idPerfil);
}
