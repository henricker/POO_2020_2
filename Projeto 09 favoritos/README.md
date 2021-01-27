# Projeto favoritos

## Relatório
1. O que fez?
    - Fiz o projeto [favoritos](https://github.com/qxcodepoo/arcade/blob/master/base/016/Readme.md).
2. Com quem fez?
    - Sozinho.
3. Como fez?
    - O projeto faz o uso de três classes e uma classe para fazer o "front-end" com o usuário.

    - Classes:
        - `Phone`
        - `Contact`
        - `Phonebook`
    - A classe `phonebook` é responsável por gerenciar todas as outras classes da nossa agenda telefônica. 

    - Na classe `phonebook` fiz o uso da estrutura de dados `TreeMap`, que foi vista em aula, facilitando o processo da criação do projeto, uma vez que objetos do tipo `TreeMap` já possuem métodos que são muito úteis e produtivos para o desenvolvimento.

    - Utilizei a lib `JOptionPane` como uma interface na classe App para que o usuário possa testar o projeto.

    - Busquei deixar cada classe e método para resolver e retornar apenas aquilo que deve, evitei muitas redundâncias no meu código.

    - Em alguns métodos retorno string, pois como estou utilizando a lib `JOptionPane`, e em conjunto com a lib `java.util.regex.*`apenas verifico se é uma mensagem de erro ou sucesso e a partir daí mostro ao usuário.

4. O que aprendeu?
    - Já conhecia essa estrutura de dados, presente muito em `javaScript` com os famosos `objetos` e os `dicionários` do `python`, mas aprendi a sintaxe dessa estrutura em java, que será muito útil para os futuros projetos de POO, com a explicação do professor entendi mais ou menos como é por "baixo dos panos" as diferenças ente `TreeMap` e `HashMap`.

5. Quanto tempo demorou?
    - Demorei cerca de `duas horas`, pois acabei refazendo todo o projeto, para que pudesse se portar bem com o `TreeMap`