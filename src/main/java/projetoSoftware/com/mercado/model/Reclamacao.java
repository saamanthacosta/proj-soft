package projetoSoftware.com.mercado.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Data
public class Reclamacao {
    @Id
    @Column(name ="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id", referencedColumnName = "cpf")
    Cliente cliente;
    @Column(name="reclamacao")
    String reclamacao;
    @Column(name="data")
    Date data;
    public Reclamacao (Cliente cliente, String reclamacao){
        this.cliente = cliente;
        this.reclamacao = reclamacao;
        this.data = new Date();
    }

}
