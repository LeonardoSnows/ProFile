package br.com.profile.dto;

import java.time.LocalDate;

public record ExperienciaProfissionalDTO(

        String cargo,
        String empresa,
        String descricao,
        LocalDate dataInicio,
        LocalDate dataFim
) {
}
