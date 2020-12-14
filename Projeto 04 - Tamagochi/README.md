# Relatório - Tamagochi

1. O que fez?
    - Fiz o projeto Tamagochi, aplicando os conceitos vistos em aula.

2. Com quem fez?
    - Fiz sozinho, com ajuda do [capítulo 5 da apostila Caelum](https://www.caelum.com.br/apostila-java-orientacao-objetos/modificadores-de-acesso-e-atributos-de-classe) e algumas vídeo aulas do [Curso em vídeo](https://www.youtube.com/user/cursosemvideo)

3. Como fez?
    - Utilizei os conceitos de modificadores de acesso, encapsulamento e também utilizei os métodos getters e setters.
        - Utilizei os métodos getters em todos os atributos.
        - Os métodos setters criei apenas alguns, e de modo privado, assim apenas a própria classe pode aproveitar esses métodos, no caso:
            - setEnergy()
            - setSatiety()
            - setCleaning()
        
        - De resto, criei os métodos principais:
            - eat()
            - shower()
            - sleep()
            - play()
            - Todos esses métodos utilizam os getters e setters criados.

4. O que aprendeu?
    - Aprendi sobre como utilizar os modificadores de acesso corretamente, e quem nem em todos os casos devemos dar acesso a todo os atributos e métodos da classe, com o encapsulamento a classe passa a ter total responsabilidade e controle de seus elementos (atributos e métodos)

    - Em muitos projetos reais e complexos é necessário o uso do encapsulamento, de forma que as outras classes apenas utilizam alguns métodos de outra, mas não possuem o conhecimento dos seus outros elementos.

    - Também auxilia quando vai refatorar ou corrigir algum bug do código, assim basta ir corrigir o problema apenas na classe que está sendo utilizada, sem interferir no resto do projeto.

5. Quanto tempo levou?
    - Demorei uma hora, iniciei após a aula do professor, dei uma olhada na apostila Caelum, mas de resto não obtive problemas e dificuldades.