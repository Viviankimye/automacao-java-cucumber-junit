package steps;

import entidades.Filme;
import entidades.NotaAluguel;
import entidades.TipoAluguel;
import servicos.AluguelService;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Então;

import org.junit.Assert;

import utils.DateUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AlugarFilmeStep {

    // Objetos utilizados nos cenários
    private Filme filme;
    private AluguelService aluguel = new AluguelService();
    private NotaAluguel nota;
    private String erro;
    private TipoAluguel tipoAluguel;

    // =========================
    // DADOS INICIAIS
    // =========================

    @Dado("um filme com estoque de {int} unidades")
    public void umFilmeComEstoqueDeUnidades(Integer estoque) {
        filme = new Filme();
        filme.setEstoque(estoque);
    }

    @Dado("que o preço do aluguel seja R$ {int}")
    public void queOPrecoDoAluguelSeja(Integer preco) {
        filme.setAluguel(preco);
    }

    @Dado("que o tipo do aluguel seja {string}")
    public void queOTipoDoAluguelSeja(String tipo) {
        // Converte a String do cenário para Enum de forma segura
        tipoAluguel = TipoAluguel.valueOf(tipo.toUpperCase());
    }

    // =========================
    // AÇÃO
    // =========================

    @Quando("alugar")
    public void alugar() {
        try {

            // Caso o cenário não informe o tipo, assume COMUM
            if (tipoAluguel == null) {
                tipoAluguel = TipoAluguel.COMUM;
            }

            nota = aluguel.alugar(filme, tipoAluguel);

        } catch (RuntimeException e) {
            erro = e.getMessage();
        }
    }

    // =========================
    // VALIDAÇÕES
    // =========================

    @Então("o preço do aluguel sera R$ {int}")
    public void oPrecoDoAluguelSera(Integer precoEsperado) {
        Assert.assertNotNull("A nota não foi gerada!", nota);
        Assert.assertEquals(precoEsperado.intValue(), nota.getPreco().intValue());
    }

    @Então("a data de entrega será no dia seguinte")
    public void aDataDeEntregaSeraNoDiaSeguinte() {

        Assert.assertNotNull("A nota não foi gerada!", nota);

        Calendar hojeMais1 = Calendar.getInstance();
        hojeMais1.add(Calendar.DAY_OF_MONTH, 1);

        Calendar dataRetorno = Calendar.getInstance();
        dataRetorno.setTime(nota.getDataEntrega());

        Assert.assertEquals(hojeMais1.get(Calendar.DAY_OF_MONTH),
                dataRetorno.get(Calendar.DAY_OF_MONTH));

        Assert.assertEquals(hojeMais1.get(Calendar.MONTH),
                dataRetorno.get(Calendar.MONTH));

        Assert.assertEquals(hojeMais1.get(Calendar.YEAR),
                dataRetorno.get(Calendar.YEAR));
    }

    @Então("a data de entrega sera em {int} dias")
    public void aDataDeEntregaSeraEmDias(Integer dias) {

        Assert.assertNotNull("A nota não foi gerada!", nota);

        Date dataEsperada = DateUtils.obterDataDiferencaDias(dias);
        Date dataReal = nota.getDataEntrega();

        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        Assert.assertEquals(format.format(dataEsperada),
                format.format(dataReal));
    }

    @Então("o estoque do filme sera {int} unidade")
    public void oEstoqueDoFilmeSera(Integer estoqueEsperado) {
        Assert.assertEquals(estoqueEsperado.intValue(),
                filme.getEstoque().intValue());
    }

    @Então("a pontuacao recebida sera de {int} pontos")
    public void aPontuacaoRecebidaSeraDePontos(Integer pontos) {
        Assert.assertNotNull("A nota não foi gerada!", nota);
        Assert.assertEquals(pontos.intValue(), nota.getPontuacao());
    }

    @Então("não sera possivel por falta de estoque")
    public void naoSeraPossivelPorFaltaDeEstoque() {
        Assert.assertEquals("Filme sem estoque", erro);
    }
}