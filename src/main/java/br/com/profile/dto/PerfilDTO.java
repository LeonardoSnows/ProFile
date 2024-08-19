package br.com.profile.dto;

import br.com.profile.model.*;
import org.springframework.data.relational.core.mapping.Embedded;

import java.util.List;

public record PerfilDTO(String id,
                        Usuario usuario,
                        List<ExperienciaProfissional> experienciaProfissional,
                        List<Habilidades> habilidades,
                        List<Educacao> educacao,
                        List<Referencia> referencia) {

}
