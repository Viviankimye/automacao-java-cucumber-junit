package servicos;
/// esta importando as classes Filme, nota aluguel e Calendar
import entidades.Filme;
import entidades.NotaAluguel;

import entidades.TipoAluguel;
import utils.DateUtils;

import java.util.Calendar;

/// Cria a classe AluguelService e tem toda logica do sistema
public class AluguelService {
/// nesse metodo recebe um filme e retorna uma nota de aluguel
    public NotaAluguel alugar(Filme filme, TipoAluguel tipo) {
        if (filme.getEstoque() == 0)
            throw new RuntimeException("Filme sem estoque");
        /// cria uma nota de aluguel
        NotaAluguel nota = new NotaAluguel();
        switch (tipo) {
            case COMUM:
                nota.setPreco(filme.getAluguel());// copia o preço do filme para a nota
                nota.setDataEntrega(DateUtils.obterDataDiferencaDias(1));// define a data da devolução
                nota.setPontuacao(1);
                break;
            case EXTENDIDO:
                nota.setPreco(filme.getAluguel() * 2);
                nota.setDataEntrega(DateUtils.obterDataDiferencaDias(3));
                nota.setPontuacao(2);
                break;
            case SEMANAL:
                nota.setPreco(filme.getAluguel() * 3);
                nota.setDataEntrega(DateUtils.obterDataDiferencaDias(7));
                nota.setPontuacao(3);
                break;
        }
            // diminui 1 do estoque do filme alugado
            filme.setEstoque(filme.getEstoque() - 1);
            return nota;///retorna a nota

    }
}







//            nota.setPreco(filme.getAluguel());/// copia o preço do filme para a nota
//
//        ///Calendar cal = Calendar.getInstance();///pega a data atual
//        ///cal.add(Calendar.DAY_OF_MONTH, 1); ///soma + dia a data atual
//        nota.setDataEntrega(DateUtils.obterDataDiferencaDias(1));/// define a data da devolução
//        ///nota.setDataEntrega(cal.getTime()); /// define a data da devolução
//        nota.setPontuacao(1);
//        }

