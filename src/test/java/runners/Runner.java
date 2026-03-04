package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
        //O Cucumber vai procurar dentro dessa pasta todos os cenários escritos em Gherkin.
        features = "src/test/resources/features/alugar_filme.feature",
        //Indica onde estão as classes Java que contêm os Steps.
        glue = "steps",
        //tags =
        //O plugin pretty deixa o output no console mais bonito e legível.
        plugin = {"pretty", "html:target/report-html"},
        //Remove caracteres especiais e cores do console.
        monochrome = true,
        //Indica qual estilo o Cucumber deve usar ao gerar métodos automaticamente.
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        publish = false,

        //Verifica steps (true) ou executa testes (false)
        dryRun = false
)
public class Runner {

}
