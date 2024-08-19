package br.com.profile.dto;

import br.com.profile.model.*;

import java.util.List;

public record OutPerfilDTO(
        String id,
        UsuarioDTO usuario,
        List<EducacaoDTO> educacao,
        List<HabilidadeDTO> habilidade,
        List<ExperienciaProfissionalDTO> experienciaProfissional,
        List<ReferenciaDTO> referencia
) {
}
