package br.com.profile.dto.update;

public record UsuarioUpdateDTO(

        String id,
        String email,
        String nome,
        String sobrenome,
        String telefone) {
}
