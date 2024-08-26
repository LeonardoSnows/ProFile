package br.com.profile.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
public class ExperienciaProfissional {

    private String cargo;
    private String empresa;
    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataFim;
}
