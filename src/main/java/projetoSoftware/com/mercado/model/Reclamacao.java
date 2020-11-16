package projetoSoftware.com.mercado.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import projetoSoftware.com.mercado.repository.ReclamacaoRepository;

import javax.persistence.*;
import java.util.Date;
@Data
public class Reclamacao {
    @Id
    @Column(name ="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;
    @Column(name="cliente_id")
    String cliente_id;
    @Column(name="reclamacao")
    String reclamacao;
    @Column(name="data")
    Date data;

    @Autowired
    ReclamacaoRepository reclamacaoRepository;

    public Reclamacao (String cliente_id, String reclamacao){
        this.cliente_id = cliente_id;
        this.reclamacao = reclamacao;
        this.data = new Date();
    }
    public Reclamacao save(){
        try{
            Reclamacao reclamacao = reclamacaoRepository.save(this);
            System.out.println("Reclamacao :: save :: reclamação salva");
            return reclamacao;
        }catch(Exception err){
            System.out.println("Reclamacao :: save :: Erro ao salvar reclamação :" + err.toString());
            return null;
        }
    }
}
