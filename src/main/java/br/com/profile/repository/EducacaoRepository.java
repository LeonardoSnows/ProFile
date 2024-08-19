package br.com.profile.repository;

import br.com.profile.model.Educacao;
import br.com.profile.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EducacaoRepository extends MongoRepository<Educacao, String> {
    List<Educacao> findByPerfil(String idPerfil);
}
