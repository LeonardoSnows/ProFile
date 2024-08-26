package br.com.profile.service.impl;

import br.com.profile.dto.PerfilDTO;
import br.com.profile.dto.update.OutPerfilUpdateDTO;
import br.com.profile.model.Perfil;
import br.com.profile.repository.PerfilRepository;
import br.com.profile.service.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PerfilServiceImpl implements PerfilService {

    @Autowired
    PerfilRepository perfilRepository;

    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public Perfil savePerfil(PerfilDTO perfilDTO) {
        Perfil newPerfil = new Perfil(perfilDTO);
        perfilRepository.save(newPerfil);
        return newPerfil;
    }

    @Override
    public Perfil updatePerfil(String id, OutPerfilUpdateDTO perfilAtualizado) {

        Query query = new Query(Criteria.where("_id").is(id));
        Update update = new Update();

        update.set("usuario", perfilAtualizado.usuario());
        update.set("referencia", perfilAtualizado.referencia());
        update.set("habilidades", perfilAtualizado.habilidade());
        update.set("experiencia", perfilAtualizado.experienciaProfissional());
        update.set("educacao", perfilAtualizado.educacao());

        return mongoTemplate.findAndModify(query, update, FindAndModifyOptions.options().returnNew(true), Perfil.class);
    }

    @Override
    public Perfil inactivePerfil(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        Update update = new Update();

        update.set("usuario.ativo", "false");
        return mongoTemplate.findAndModify(query, update, FindAndModifyOptions.options().returnNew(true), Perfil.class);
    }


    @Override
    public List<Perfil> getAllPerfis() {
        return perfilRepository.findAll();
    }

    @Override
    public Optional<Perfil> getPerfil(String id) {
        return perfilRepository.findById(id);
    }

}
