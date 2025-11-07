package br.com.condomcontrol.democondomcontrol.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Morador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
    private String nome;

    @NotBlank(message = "O número do apartamento é obrigatório")
    @Pattern(regexp = "^[0-9]{1,4}$", message = "Número do apartamento inválido")
    private String apartamento;

    @Size(max = 10, message = "O bloco deve ter no máximo 10 caracteres")
    private String bloco;

    @NotBlank(message = "O email é obrigatório")
    @Email(message = "Email inválido")
    private String email;

    @ManyToOne
    @JoinColumn(name = "condominio_id")
    @jakarta.validation.constraints.NotNull(message = "O condomínio é obrigatório")
    private Condominio condominio;
    
}
