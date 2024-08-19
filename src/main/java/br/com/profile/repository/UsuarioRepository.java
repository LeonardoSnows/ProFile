package br.com.profile.repository;

import br.com.profile.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepository extends MongoRepository<Usuario,String> {
    Usuario findByPerfil(String idPerfil);
}
