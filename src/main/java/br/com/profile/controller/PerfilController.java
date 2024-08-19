package br.com.profile.controller;

import br.com.profile.dto.OutPerfilDTO;
import br.com.profile.dto.PerfilDTO;
import br.com.profile.model.Perfil;
import br.com.profile.service.impl.PerfilServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class PerfilController {

    @Autowired
    PerfilServiceImpl perfilServiceImpl;

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
    public ResponseEntity<List<OutPerfilDTO>> getAllPerfis() {
        return ResponseEntity.status(HttpStatus.OK).body(perfilServiceImpl.getAllPerfis());
    }

    @DeleteMapping("/inactive/user/{id}")
    public ResponseEntity<?> inactivePerfil(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(perfilServiceImpl.inactivePerfil(id));
    }
}
