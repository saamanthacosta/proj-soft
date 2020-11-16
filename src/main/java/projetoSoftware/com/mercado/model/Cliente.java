package projetoSoftware.com.mercado.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import projetoSoftware.com.mercado.repository.ReclamacaoRepository;

import javax.annotation.sql.DataSourceDefinition;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.concurrent.RecursiveAction;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @Column(name ="cpf")
    private String cpf;
    @Column(name = "identidade")
    private String identidade;
    @Column(name = "email")
    private String email;
    //    @OneToOne
//    private Endereco endereco;
    @Column(name ="prefencial")
    private boolean prefencial;
    @Column(name="pontosAcumulados")
    private int pontosAcumulados;
    @Column(name="dataCadastro")
    private Date dataCadastro;


    public Cliente(String cpf, String identidade, String email, boolean prefencial, int pontosAcumlados){
        this.cpf = cpf;
        this.identidade = identidade;
        this.email = email;
        this.prefencial = prefencial;
        this.pontosAcumulados = pontosAcumlados;
        this.dataCadastro = new Date();
    }
    public void setDataCadastro(Date data){
        this.dataCadastro = data;
    }
    public boolean adicionarPontos(int pontos){
        if(this.getPontosAcumulados()>=pontos){
            int total = this.getPontosAcumulados()+pontos;
            return true;
        }else{
            return false;
        }
    }
}