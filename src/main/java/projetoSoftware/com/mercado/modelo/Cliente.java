package projetoSoftware.com.mercado.modelo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "cliente")
public class Cliente {
    @Id
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "nome")
    private String nome;
    @Column(name = "identidade")
    private String identidade;
    @Column(name = "email")
    private String email;
    @Column(name = "ehPreferencial")
    private boolean ehPreferencial;
    @Column(name = "pontosAcumulados")
    private int pontosAcumulados;
    @Column(name = "dataCadastro")
    private Date dataCadastro;

    public Cliente(String cpf, String nome, String identidade, String email, boolean ehPreferencial, int pontosAcumlados) {
        this.cpf = cpf;
        this.nome = nome;
        this.identidade = identidade;
        this.email = email;
        this.ehPreferencial = ehPreferencial;
        this.pontosAcumulados = pontosAcumlados;
        this.dataCadastro = new Date();
    }

    public void setDataCadastro(Date data) {
        this.dataCadastro = data;
    }

    public boolean adicionarPontos(int pontos) {
        if (this.getPontosAcumulados() >= pontos) {
            int total = this.getPontosAcumulados() + pontos;
            return true;
        } else {
            return false;
        }
    }
}