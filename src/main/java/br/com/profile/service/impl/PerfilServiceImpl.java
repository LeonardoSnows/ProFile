package br.com.profile.service.impl;

import br.com.profile.dto.*;
import br.com.profile.model.Perfil;
import br.com.profile.model.Usuario;
import br.com.profile.repository.*;
import br.com.profile.service.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PerfilServiceImpl implements PerfilService {

    @Autowired
    PerfilRepository perfilRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    EducacaoRepository educacaoRepository;

    @Autowired
    ReferenciaRepository referenciaRepository;

    @Autowired
    HabilidadeRepository habilidadeRepository;

    @Autowired
    ExperienciaProfissionalRepository experienciaProfissionalRepository;

    private void setPerfilId(Perfil newPerfil) {
        newPerfil.getUsuario().setPerfil(newPerfil.getId());
        newPerfil.getEducacao().forEach(educacao -> {
            educacao.setPerfil(newPerfil.getId());
        });
        newPerfil.getReferencias().forEach(referencia -> {
            referencia.setPerfil(newPerfil.getId());
        });
        newPerfil.getHabilidades().forEach(habilidades -> {
            habilidades.setPerfil(newPerfil.getId());
        });
        newPerfil.getExperiencias().forEach(experiencias -> {
            experiencias.setPerfil(newPerfil.getId());
        });
    }

    private void saveNewInfos(Perfil newPerfil) {
        usuarioRepository.save(newPerfil.getUsuario());
        educacaoRepository.saveAll(newPerfil.getEducacao());
        referenciaRepository.saveAll(newPerfil.getReferencias());
        habilidadeRepository.saveAll(newPerfil.getHabilidades());
        experienciaProfissionalRepository.saveAll(newPerfil.getExperiencias());
    }

    @Override
    public Perfil savePerfil(PerfilDTO perfilDTO) {
        Perfil newPerfil = new Perfil(perfilDTO);
        perfilRepository.save(newPerfil);
        setPerfilId(newPerfil);
        saveNewInfos(newPerfil);
        return newPerfil;
    }

    @Override
    public Perfil updatePerfil(String id) {
        return null;
    }

    @Override
    public Usuario inactivePerfil(String id) {
        Optional<Usuario> deletePerfil = Optional.ofNullable(
                usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado com o id:" + id)
                ));

        deletePerfil.ifPresent(usuario -> {
            usuario.setAtivo(false);
        });

        setUserInactiveForPefil(deletePerfil);
        usuarioRepository.save(deletePerfil.get());

        return deletePerfil.get();
    }

    private void setUserInactiveForPefil(Optional<Usuario> deletePerfil) {
        Optional<Perfil> perfil = perfilRepository.findById(deletePerfil.get().getPerfil());
        perfil.ifPresent(perfil1 -> {
            perfil1.getUsuario().setAtivo(false);
        });
        perfilRepository.save(perfil.get());
    }

    @Override
    public List<OutPerfilDTO> getAllPerfis() {
        return perfilRepository.findAll().stream()
                .map(perfil -> new OutPerfilDTO(
                        perfil.getId(),
                        getUsuarioDTO(perfil),
                        getEducacaoDTOS(perfil),
                        getHabilidadeDTOS(perfil, habilidadeRepository),
                        getExperienciaProfissionalDTOS(perfil),
                        getReferenciaDTOS(perfil)
                )).collect(Collectors.toList());
    }

    private List<ReferenciaDTO> getReferenciaDTOS(Perfil perfil) {
        List<ReferenciaDTO> referenciaDTO = referenciaRepository.findByPerfil(perfil.getId()).stream().map(
                referencia -> new ReferenciaDTO(
                        referencia.getId(),
                        referencia.getNome(),
                        referencia.getContato(),
                        referencia.getDescricaoReferencia()
                )).collect(Collectors.toList());
        return referenciaDTO;
    }

    private List<ExperienciaProfissionalDTO> getExperienciaProfissionalDTOS(Perfil perfil) {
        List<ExperienciaProfissionalDTO> experienciaProfissional = experienciaProfissionalRepository.findByPerfil(perfil.getId())
                .stream().map(
                        experienciaProfissional1 -> new ExperienciaProfissionalDTO(
                                experienciaProfissional1.getId(),
                                experienciaProfissional1.getPerfil(),
                                experienciaProfissional1.getCargo(),
                                experienciaProfissional1.getEmpresa(),
                                experienciaProfissional1.getDescricao(),
                                experienciaProfissional1.getDataInicio(),
                                experienciaProfissional1.getDataFim()
                        )).collect(Collectors.toList());
        return experienciaProfissional;
    }

    private static List<HabilidadeDTO> getHabilidadeDTOS(Perfil perfil, HabilidadeRepository habilidadeRepository) {
        List<HabilidadeDTO> habilidadeDTO = habilidadeRepository.findByPerfil(perfil.getId()).stream().map(
                habilidade -> new HabilidadeDTO(
                        habilidade.getId(),
                        habilidade.getNome(),
                        habilidade.getNivel()
                )).collect(Collectors.toList());
        return habilidadeDTO;
    }

    private List<EducacaoDTO> getEducacaoDTOS(Perfil perfil) {
        List<EducacaoDTO> educacaoDTO = educacaoRepository.findByPerfil(perfil.getId()).stream().map(
                educacao -> new EducacaoDTO(
                        educacao.getId(),
                        educacao.getInstituicao(),
                        educacao.getCurso(),
                        educacao.getGrau(),
                        educacao.getDataInicio(),
                        educacao.getDataFim()
                )).collect(Collectors.toList());
        return educacaoDTO;
    }

    private UsuarioDTO getUsuarioDTO(Perfil perfil) {
        UsuarioDTO usuarioDTO = new UsuarioDTO(
                usuarioRepository.findByPerfil(perfil.getId()).getId(),
                usuarioRepository.findByPerfil(perfil.getId()).getEmail(),
                usuarioRepository.findByPerfil(perfil.getId()).getNome(),
                usuarioRepository.findByPerfil(perfil.getId()).getAtivo(),
                usuarioRepository.findByPerfil(perfil.getId()).getSobrenome(),
                usuarioRepository.findByPerfil(perfil.getId()).getTelefone()
        );
        return usuarioDTO;
    }
}
