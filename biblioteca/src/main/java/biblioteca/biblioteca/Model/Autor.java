package biblioteca.biblioteca.Model;

import java.util.List;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@Table(name = "tb_autor")
@AllArgsConstructor
@NoArgsConstructor
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;

    @Column(name = "ds_nomeAutor", nullable = false)
    @JsonProperty("nomeAutor")
    private String nomeAutor;

    @Column(name = "ds_nacionalidade", nullable = false)
    @JsonProperty("nacionalidade")
    private String nacionalidade;

    // Adicione a relação com Livro aqui
    @OneToMany(mappedBy="livro.autor")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Livro> livros;
}