package projetoSoftware.com.mercado.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import projetoSoftware.com.mercado.repository.ReclamacaoRepository;

import javax.persistence.*;
import java.util.Date;
@Data
@Table(name = "reclamacao")
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Reclamacao {
    @Id
    @Column(name ="id")
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    Integer id;
    @Column(name="cliente_id")
    String cliente_id;
    @Column(name="reclamacao")
    String reclamacao;
    @Column(name="data")
    Date data;


    public Reclamacao (String cliente_id, String reclamacao){
        this.cliente_id = cliente_id;
        this.reclamacao = reclamacao;
        this.data = new Date();
    }

}
