package br.com.nexusDev.demo.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
public class Cliente {
    @Id
    private Long id;
    @NotBlank(message = "CPF é obrigatório")
    private String cpf;

    @OneToOne(cascade = CascadeType.ALL)
    @MapsId //garante que vai ser o mesmo ID.
    @JoinColumn(name = "id")
    private Usuario usuario;

    public Cliente() {
    }

}
