package br.com.profile.service;

import br.com.profile.dto.OutPerfilDTO;
import br.com.profile.dto.PerfilDTO;
import br.com.profile.model.Perfil;
import br.com.profile.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PerfilService {

    public Perfil savePerfil(PerfilDTO perfilDTO);

    public Perfil updatePerfil(String id);

    public Usuario inactivePerfil(String id);

    public List<OutPerfilDTO>  getAllPerfis();
}
