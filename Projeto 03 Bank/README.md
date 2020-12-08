# Estudos da semana
- Nessa semana, estudei sobre a composição e agregação de duas ou mais classes, com o exemplo do projeto cofre que o professor fez em aula, ajudou-me muito para entender e aplicar no meu projeto da semana.

- Estudei sobre como aplicar e utilizar os modificadores de acesso para que eu possa encapsular os atributos de uma classe.

- Entendi e também pratiquei sobre atributos e métodos estáticos, onde podemos usá-los sem a necessidade de um objeto, chamamos diretamente pela classe.

- Vi vídeos e fiz exercícios utilizando a classe ArrayList, percebi semelhanças com as listas que existem em python, javaScript, e outras linguagens que possuo conhecimento.

# Relatório - projeto 03

Projeto realizado na IDE eclipse.

1. O que fez?
    - Criei um projetinho de um banco, chamando "Banco riquinho", nele utilizei os mais variádos conceitos que vi em aula e também outros conceitos que aprendi durante a semana de estudos.

    - Dentro do projeto, o usuário pode brincar com todas as funcionalidades, toda a classe principal Bank.java é interativa, tornando uma experiência mais prazerosa a quem for testar o projeto.

    - O usuário pode criar quantas contas quiser, e fazer o login em qualquer conta que ele criou, sendo que o login é feito pelo número da conta.

    - Dentro da funcionalidade login, após feito, o usuário pode:
        - Depositar
        - Sacar
        - Transferir para outra conta existente
        - Verificar o saldo
        - Verificar os dados da conta
        - Verificar os dados do cliente
    
    - Fique a vontade para testar, implementar novas funcionalidades, ou me dar dicas de como posso melhorar o projeto!. 

2. Com quem fez?
    - Fiz sozinho, com ajuda de alguns fóruns na internet, vídeos e com o apoio da apostila Caelum

3. Como fez?

    - No projeto "Banco Riquinho" foi utilizado a composição e atribuição entre classes, dos quais as classes acabei dividindo em arquivos dentro de um mesmo pacote:

        - Client.java --> Nesse arquivo contém a classe Client onde encontra-se os seguintes atributos e métodos:
            - name: Nome do cliente
            - age: idade do cliente
            - RG: Registro Geral
            - CPF: Cadastro de Pessoas Físicas 

            - getters desses atributos.

            - toString() --> Retorna os dados do cliente em forma de uma string
            

        - AccountBank.java --> Nesse arquivo contém a classe AccountBank, e possui os seguintes atributos e métodos:
            
            - counter --> Atributo estático, a cada conta criada o contador é incrementado e assim por diante...

            - somebody --> Esse atributo é um objeto do tipo cliente

            - numberAccount --> Esse atributo é o número da conta, o número da conta é igual ao counter quando um objeto da classe AccountBank é instanciada

            - balance --> Se refere ao saldo da conta.

            - deposit() --> Método utilizado para que se possa adicionar dinheiro na conta.

            - withdraw() --> Método utilizado que se possa sacar o dinheiro da conta.

            - transferMoney() --> Método utilizado para transferir dinheiro para outra conta existente.

            - checkBalance() --> Método que retorna o saldo disponível em conta

            - getNumberAccount() -> Retorna o número (id) da conta

            - showDataClient() --> Dentro dessa função é chamada o método toString do cliente, mostrando os seus dados

            - toString() --> Retorna os dados da conta em forma de string
    
    - Dentro da classe principal (Bank), foi utilizado um menu interativo, onde o usuário pode usar e abusar de todas as funcionalidades do projeto.
        - Dentro dessa classe, foram criados os métodos estáticos createAccount(), onde é criado a conta, e a funcionalidade de login(), onde é feito as alterações da conta

        - O projeto possui dois menus interativos, onde, no primeiro existe as opções de criar conta e realizar o login, no seguindo existe as opções após o login do usuário, podendo ser feita diversas alterações, desde depósito, transferencia, até sobre pesquisar os dados do cliente.

        - Utilizei a classe ArrayList para que se possa salvar os dados em tempo de execução, com isso, podemos acessar as diversas contas criadas.


4. O que aprendeu?

    - Aprendi sobre: tanto o uso da composição e agregação de classes, quanto o uso de classes novas em que importamos como a ArrayList, e a implementação de encapsulamento.

    - Os estudos da semana, estão me ajudando a revisar os conceitos de POO e praticar a linguagem Java.

5. Quanto tempo levou?

    - Demorei cerca de 6 horas, pois em alguns momentos tive dificuldade na aplicação da ArrayList para receber os meus objetos em tempo de execução, mas consegui ultrapassar esse obstáculo!.

    - Utilizei o apoio da apostila Caelum para o uso e o aprendizado dos conteúdos.