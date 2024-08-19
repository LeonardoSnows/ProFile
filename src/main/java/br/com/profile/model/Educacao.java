package br.com.profile.model;

import lombok.Data;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document(collection = "educacao_entity")
public class Educacao {
    @Id
    private String id;
    private String perfil;
    private String instituicao;
    private String curso;
    private String grau;
    private LocalDate dataInicio;
    private LocalDate dataFim;
}
