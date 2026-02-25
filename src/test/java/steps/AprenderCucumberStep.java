package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Então;

import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

import org.junit.Assert;

public class AprenderCucumberStep {

    // -----------------------------------------
    // CENÁRIO 1 - Criar e executar arquivo
    // -----------------------------------------

    @Dado("que criei o arquivo corretamente")
    public void queCrieiOArquivoCorretamente() {
        System.out.println("Arquivo criado corretamente!");
    }

    @Quando("executa-lo")
    public void executaLo() {
        System.out.println("Executando o arquivo...");
    }

    @Então("a especificacao deve finalizar com sucesso")
    public void aEspecificacaoDeveFinalizarComSucesso() {
        System.out.println("Especificação finalizada com sucesso!");
    }


    // -----------------------------------------
    // CENÁRIO 2 - Contador
    // -----------------------------------------

    private int contador = 0;

    @Dado("que o valor do contador é {int}")
    public void queOValorDoContadorÉ(Integer arg1) {
        contador = arg1;
    }

    @Quando("eu incrementar em {int}")
    public void euIncrementarEm(Integer arg1) {
        contador = contador + arg1;
    }

    @Então("o valor do contador será {int}")
    public void oValorDoContadorSerá(Integer arg1) {
        System.out.println(arg1);
        System.out.println(contador);
        System.out.println(arg1 == contador); //verifica se os 2 valores são iguais

    }


    // -----------------------------------------
    // CENÁRIO 3 - Datas (Entrega)
    // -----------------------------------------

    private Date entrega = new Date();

    @Dado("que a entrega é dia {int}\\/{int}\\/{int}")
    public void queAEntregaÉDia(Integer dia, Integer mes, Integer ano) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, dia);
        cal.set(Calendar.MONTH, mes - 1);  // mês começa em 0
        cal.set(Calendar.YEAR, ano);
        entrega = cal.getTime();
    }

    @Quando("a entrega vai atrasar em {int} dias")
    public void aEntregaVaiAtrasarEmDias(Integer dias) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(entrega);
        cal.add(Calendar.DAY_OF_MONTH, dias);
        entrega = cal.getTime(); // <-- faltava atualizar o objeto entrega
    }

    @Então("a entrega sera efetuada em {int}\\/{int}\\/{int}")
    public void aEntregaSeraEfetuadaEm(Integer dia, Integer mes, Integer ano) {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = format.format(entrega);

        String dataEsperada = String.format("%02d/%02d/%04d", dia, mes, ano);

        Assert.assertEquals(dataEsperada, dataFormatada);
    }
}
