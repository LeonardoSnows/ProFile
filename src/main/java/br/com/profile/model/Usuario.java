package br.com.profile.model;

import lombok.Data;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "usuario_entity")
public class Usuario {
    @Id
    private String id;
    private String email;
    private String senha;
    private String nome;
    private String sobrenome;
    private String telefone;
    private boolean ativo;
    private String perfil;

    public boolean getAtivo(){
        return ativo;
    }
}
