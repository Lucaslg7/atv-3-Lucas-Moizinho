package biblioteca.biblioteca.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import biblioteca.biblioteca.Model.Autor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LivroPostPutDto {

    @JsonProperty("ISBN")
    @NotBlank(message = "ISBN do livro não pode ser vazio")
    private String isbn;

    @JsonProperty("titulo")
    @NotBlank(message = "Título do livro não pode ser vazio")
    private String titulo;

    @JsonProperty("autor")
    @NotBlank(message = "Autor do livro não pode ser vazio")
    private Autor autor;

    @JsonProperty("ano")
    private int ano;

    @JsonProperty("edicao")
    @NotBlank(message = "Edição do livro não pode ser vazio")
    private String edicao;

}
