package br.com.profile.dto.update;

import br.com.profile.dto.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

public record OutPerfilUpdateDTO(

        UsuarioUpdateDTO usuario,
        List<EducacaoUpdateDTO> educacao,
        List<HabilidadeUpdateDTO> habilidade,
        List<ExperienciaProfissionalUpdateDTO> experienciaProfissional,
        List<ReferenciaupdateDTO> referencia
) {
}
