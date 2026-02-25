/// informa em qual pacote esta
package entidades;

/// Cria a classe Filme
public class Filme {
/// Cria os atributos da classe
/// private é o encapsulamento, só a propria casse acessa os atributos
    private Integer estoque; ///informa a quantidade de filmes em estoque
    private Integer aluguel; ///preco do aluguel

///metodo para leitura do estoque
    public Integer getEstoque() {
        return estoque;
    }
/// Metodo para alterar o estoque.
    public void setEstoque(Integer estoque) {
        this.estoque = estoque;///this é o atributo da classe
    }
/// retorna o preço do aluguel
    public Integer getAluguel() {
        return aluguel;
    }
/// define o preço do aluguel
    public void setAluguel(Integer aluguel) {
        this.aluguel = aluguel;
    }
}
