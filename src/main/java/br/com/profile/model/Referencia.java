package br.com.profile.model;

import lombok.Data;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document(collection = "referencia_entity")
public class Referencia {

    @Id
    private String id;
    private String perfil;
    private String nome;
    private String contato;
    private String descricaoReferencia;
}
