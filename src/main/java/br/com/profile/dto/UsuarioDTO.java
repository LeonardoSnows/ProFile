package br.com.profile.dto;

public record UsuarioDTO(String id,
                         String email,
                         String nome,
                         boolean ativo,
                         String sobrenome,
                         String telefone) {
}