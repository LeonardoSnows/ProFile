package br.com.profile.repository;

import br.com.profile.model.Perfil;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilRepository extends MongoRepository<Perfil, String> {
}
