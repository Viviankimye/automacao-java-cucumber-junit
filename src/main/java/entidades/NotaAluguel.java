/// informa em qual pacote esta
package entidades;
/// importa a classe para trabalhar com as datas

import java.util.Date;

/// Cria a classe NotaAluguel
public class NotaAluguel {
    /// dados da nota de aluguel
    private Integer preco;
    /// preço
    private Date dataEntrega; ///data de devolução
    private int pontuacao;

    /// apenas leitura e escrita dos valores
    public Integer getPreco() {

        return preco;
    }

    public void setPreco(Integer preco) {

        this.preco = preco;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }
}
