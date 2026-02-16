🎬 Automação de Testes — Aluguel de Filmes

Projeto de automação de testes desenvolvido em Java, utilizando Cucumber + JUnit + BDD, simulando um sistema de locação de filmes com regras de negócio, validações e cenários automatizados.

🚀 Tecnologias utilizadas

Java
JUnit
Cucumber (BDD)
Gherkin
Maven / Gradle (dependendo do seu projeto)
IntelliJ IDEA

📌 Objetivo do Projeto

Validar as regras de negócio do sistema de aluguel de filmes através de testes automatizados em BDD, garantindo:
Aluguel com sucesso
Validação de estoque
Cálculo de preço
Data de devolução
Pontuação por tipo de aluguel
Regras especiais para aluguel estendido

🧪 Cenários Automatizados
✅ Deve alugar um filme com sucesso
❌ Não deve alugar filme sem estoque
⭐ Deve aplicar condições especiais para categoria estendida

📂 Estrutura do Projeto

src
 ├── main
 │   ├── java
 │   │   ├── entidades
 │   │   │   ├── Filme
 │   │   │   └── NotaAluguel
 │   │   ├── servicos
 │   │   │   └── AluguelService
 │   │   └── utils
 │   │       └── DateUtils
 │
 ├── test
 │   ├── java
 │   │   ├── runners
 │   │   │   └── Runner
 │   │   ├── steps
 │   │   │   └── AlugarFilmeStep
 │   │   └── converters
 │   │       └── DateConverter
 │   │
 │   └── resources
 │       └── features
 │           └── alugar_filme.feature



 ▶️ Como Executar os Testes
 
1. Clonar o repositório  - git clone https://github.com/Viviankimye/automacao--java-cucumber-junit.git
2. Abrir no IntelliJ -  File → Open → selecionar a pasta do projeto
3. Rodar os testes -  Runner.java

 🧠 Regras de Negócio Implementadas

| Regra             | Comportamento        |
| ----------------- | -------------------- |
| Sem estoque       | Lança exceção        |
| Aluguel comum     | Entrega em 1 dia     |
| Aluguel estendido | Entrega em 3 dias    |
| Aluguel estendido | Pontuação = 2        |
| Estoque           | Decrementa ao alugar |

📸 Exemplo de Feature (BDD)

Cenário: Deve alugar filme com sucesso
Dado que um filme com estoque
Quando alugar o filme
Então o aluguel será concluído
E a data de entrega será em 1 dia


