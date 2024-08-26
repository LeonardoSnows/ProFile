package br.com.profile.model;

import br.com.profile.dto.PerfilDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

@Data
@Document(collection = "perfil_entity")
@NoArgsConstructor
@AllArgsConstructor
public class Perfil {

    @Id
    private String id;

    private Usuario usuario;

    private List<ExperienciaProfissional> experiencias;
    private List<Habilidades> habilidades;
    private List<Educacao> educacao;
    private List<Referencia> referencias;

    public Perfil(PerfilDTO perfilDTO) {
        this.id = perfilDTO.id();
        this.usuario = perfilDTO.usuario();
        this.experiencias = perfilDTO.experienciaProfissional();
        this.habilidades = perfilDTO.habilidades();
        this.educacao = perfilDTO.educacao();
        this.referencias = perfilDTO.referencia();
    }
}
