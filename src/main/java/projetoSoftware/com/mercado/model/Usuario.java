package projetoSoftware.com.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuario")
public abstract class Usuario {

    @Id
    @Column(name = "identificador")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String identificador;
    @Column(name = "login")
    private String login;
    @Column(name = "senha")
    private String senha;
    @Column(name = "nome")
    private String nome;

}