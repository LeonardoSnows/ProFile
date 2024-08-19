package br.com.profile.repository;

import br.com.profile.dto.ExperienciaProfissionalDTO;
import br.com.profile.model.Educacao;
import br.com.profile.model.ExperienciaProfissional;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ExperienciaProfissionalRepository extends MongoRepository<ExperienciaProfissional, String> {
    List<ExperienciaProfissional> findByPerfil(String idPerfil);
}
