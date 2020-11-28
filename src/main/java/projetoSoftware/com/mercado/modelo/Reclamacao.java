package projetoSoftware.com.mercado.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "reclamacao")
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Reclamacao {
    @Id
    @Column(name = "identificador")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer identificador;
    @Column(name = "cliente_id")
    String cliente;
    @Column(name = "descricao")
    String descricao;
    @Column(name = "assunto")
    Assunto assunto;
    @Column(name = "data")
    Date data;

    public Reclamacao(String cliente, String descricao, Assunto assunto) {
        this.cliente = cliente;
        this.descricao = descricao;
        this.assunto = assunto;
        this.data = new Date();
    }

}
