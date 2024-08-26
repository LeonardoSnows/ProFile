package br.com.profile.model;

import lombok.Data;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
public class Referencia {

    private String nome;
    private String contato;
    private String descricaoReferencia;
}
