package br.com.profile.dto.update;

import java.time.LocalDate;

public record ExperienciaProfissionalUpdateDTO(

        String id,
        String perfil,
        String cargo,
        String empresa,
        String descricao,
        LocalDate dataInicio,
        LocalDate dataFim
) {
}
