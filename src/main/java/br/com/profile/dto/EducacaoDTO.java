package br.com.profile.dto;

import org.springframework.cglib.core.Local;

import java.time.LocalDate;

public record EducacaoDTO(
        String instituicao,
        String curso,
        String grau,
        LocalDate dataInicio,
        LocalDate dataFim) {
}
