package projetoSoftware.com.mercado.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "usuario")
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    @Column(name = "identificador")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "senha")
    private String senha;
    @Column(name = "cargo")
    private String cargo;



}
