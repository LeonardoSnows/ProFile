package br.com.profile.service;

import br.com.profile.dto.OutPerfilDTO;
import br.com.profile.dto.PerfilDTO;
import br.com.profile.dto.update.OutPerfilUpdateDTO;
import br.com.profile.model.Perfil;
import br.com.profile.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PerfilService {

    public Perfil savePerfil(PerfilDTO perfilDTO);

    public Perfil updatePerfil(String id, OutPerfilUpdateDTO perfilAtualizado);

    public Perfil inactivePerfil(String id);

    public List<Perfil>  getAllPerfis();

    public Optional<Perfil> getPerfil(String id);
}
