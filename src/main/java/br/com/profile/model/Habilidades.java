package br.com.profile.model;

import lombok.Data;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document(collection = "habilidade_entity")
public class Habilidades {

    @Id
    private String id;
    private String perfil;
    private String nome;
    private String nivel;
}
