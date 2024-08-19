package br.com.profile.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document(collection = "experienciaProficional_entity")
public class ExperienciaProfissional {
    @Id
    private String id;
    private String perfil;
    private String cargo;
    private String empresa;
    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataFim;
}
