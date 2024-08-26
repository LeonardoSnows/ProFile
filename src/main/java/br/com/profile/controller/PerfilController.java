package br.com.profile.controller;

import br.com.profile.dto.PerfilDTO;
import br.com.profile.dto.update.OutPerfilUpdateDTO;
import br.com.profile.model.Perfil;
import br.com.profile.service.impl.PerfilServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/v1")
public class PerfilController {

    @Autowired
    PerfilServiceImpl perfilServiceImpl;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/new/user")
    public ResponseEntity<?> setPerfil(@RequestBody PerfilDTO perfilDTO) {
        try {
            Perfil newPerfil = perfilServiceImpl.savePerfil(perfilDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(newPerfil);
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/get/all/perfis")
    public List<EntityModel<Perfil>> getAllPerfis() {
        List<Perfil> allPerfis = perfilServiceImpl.getAllPerfis();

        return allPerfis.stream().map(perfil -> {
            Link selfLink = WebMvcLinkBuilder.linkTo(methodOn(PerfilController.class).getPerfil(perfil.getId())).withSelfRel();
            return EntityModel.of(perfil, selfLink);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/inactive/user/{id}")
    public ResponseEntity<?> inactivePerfil(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(perfilServiceImpl.inactivePerfil(id));
    }

    @PutMapping("/update/perfil/{id}")
    ResponseEntity<?> updatePerfil(@PathVariable String id, @RequestBody OutPerfilUpdateDTO perfil) {
        perfilServiceImpl.updatePerfil(id, perfil);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/get/perfil/{id}")
    public EntityModel<Perfil> getPerfil(@PathVariable String id) {
        Optional<Perfil> perfilOptional = perfilServiceImpl.getPerfil(id);

        if (perfilOptional.isEmpty()) {
            throw new RuntimeException("Perfil não encontrado com o ID: " + id);
        }

        Perfil perfil = perfilOptional.get();

        Link selfLink = WebMvcLinkBuilder.linkTo(methodOn(PerfilController.class).getPerfil(id)).withSelfRel();
        Link allPerfisLink = WebMvcLinkBuilder.linkTo(methodOn(PerfilController.class).getAllPerfis()).withRel("all-perfis");

        return EntityModel.of(perfil, selfLink, allPerfisLink);
    }
}
