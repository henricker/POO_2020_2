## Projeto "Pula pula no parquinho"

1. O que fez?
    - Fiz o projeto do pula pula no parquinho, onde ele gere uma fila de espera de crianças e controla as crianças que estão dentro do pula pula.

2. Como fez?

    - Fiz utilizando os conceitos vistos em aula e também com o apoio da apostila Caelum.
    
    - O projeto utiliza a `composição de classes`, onde uma classe contém um objeto de outra classe, e também são utilizados os conceitos de Listas de objetos, no caso o `ArrayList` da fila de espera e da fila de crianças no pula pula. Para ser mais sincero, acharia mais fácil se utilizássemos outra estrutura de dados mais indicadas como as Filas.
    
    - O projeto possui duas classes, uma classe é responsável por guardar os dados da criança (nome e idade) e possui apenas os métodos getters (`getName()` e `getAge()`)
    
    - A outra classe já possui a funcionalidade de controlar em si as crianças no pula pula, ela possui como atributos duas Listas `ArrayList` onde uma é responsável por guardar os objetos em fila simulando a espera das crianças, enquanto a outra possui a função de colocar essas crianças no pula pula, (também dispondo os objetos em fila)
    
    - Para controlar o projeto, utilizo uma classe em um arquivo separado chamado App.java, nele são feitos todos os comandos de interação com o usuário, são aceitos os seguintes comandos:
    - `arrive "nomeCriança" "idade"`
        - Cria um ojeto do tipo Kid e adiciona a criança na fila de espera.
    - `in`
        - Adiciona a criança do começo da fila no pula pula.
    - `out`
        - Remove a criança do pula pula e adiciona-o novamente na ultima posição da fila de espera. 

    - `remove "nomeCriança"` - Remove a criança que está no pula pula ou na fila de espera. 


    - `show`
        - Mostra os dados do pula pula, nele mostram as crianças que estão em fila e as crianças que estão brincando.
    - `end`
        - Finaliza a execução do programa.

4. O que aprendeu?

    - Aprendi sobre outros métodos que existem na classe ArrayList, como o indexOf, get(index, element), dentre várias outras.
    - Aprofundou a lógica para a interação entre duas listas.

5. Quanto tempo demorou?

    - Demorei cerca de 45 minutos, achei o projeto bem divertido de se fazer e bem interessante trabalhar com listas com objetos.
