package br.com.profile.model;

import lombok.Data;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
public class Educacao {

    private String instituicao;
    private String curso;
    private String grau;
    private LocalDate dataInicio;
    private LocalDate dataFim;
}
