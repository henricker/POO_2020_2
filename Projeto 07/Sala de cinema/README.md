## Projeto 'sala de cinema'

1. O que fez?
    - Fiz o projeto sala de cinema.

2. Com quem fez?
    - Fiz sozinho, com a ajuda de da documentação da própria linguagem java e da apostila Caelum.

3. Como fez?
    
    - O projeto trata-se do uso de dois modelos (classes), no caso as classes Cine e Client.

    - A classe `Client` é responsável por guardar os dados do cliente, ou seja, seu nome e telefone.
        - Possui os seguintes atributos: 
            - `name`
            - `phone`
        - Possui os seguintes métodos:
            - `getName()` retorna o nome
            - `getPhone()` retorna o telefone
            - `toString()` retorna os atributos   
    
    - A classe `Cine` utiliza a classe `Client`.
        - Possui o seguinte atributos: 
            - `clients` - Um Arraylist contendo todos os clientes no cinema, onde cada índice é o número da cadeira.

        - Possui os seguintes métodos:
            - `toReserve(String name, String phone, int index)` - Recebe os atributos e reserva uma cadeira para o cliente, dentro desse método ocorre a criação de um objeto do tipo `Client`. Esse método também faz todas as validações necessárias para oi cadastro.

            - `cancel(String name)` - Recebe como atributo o nome do cliente, caso o cliente exista altera o valor no índice para `null` e retorna `true`. Caso contrário, retorna `false`

            - `toString()` - Retorna os dados do cinema, no seguinte formato [ - - - ], utilizo o '-' caso não exista um cliente nessa cadeira ou 'nome_cliente:fone_cliente' caso exista.

    - A classe app é o arquivo responsável para que o usuário possa controlar esse projeto, dizemos que esse app se trata de um `controller`. Nesse projeto, utilizei a lib JOptionPane para pegar os dados do usuário com janelas, utilizo ele como uma interface mais amigável do que utilizar um simples terminal.

4. O que aprendeu?

    - Reforçou meus conhecimentos com o ArrayList e como utilizar valores nulos com ele. 

    - Aprendi por fora como se utiliza o JOptionPane para melhorar a qualidade e conforto do usuário na entrada de dados.

5. Quanto tempo demorou?

    - Cerca de 40 min. Achei esse projeto bem divertido de fazer!.
