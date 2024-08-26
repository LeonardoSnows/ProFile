package br.com.profile.dto.update;

import java.time.LocalDate;

public record EducacaoUpdateDTO(

        String id,
        String instituicao,
        String curso,
        String grau,
        LocalDate dataInicio,
        LocalDate dataFim) {
}
