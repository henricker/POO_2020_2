## Projeto 'sala de cinema'
## Projeto TOPIC

1. O que fez?
    - Fiz o projeto Topic.

2. Com quem fez?
    - Fiz sozinho, com a ajuda de da documentação da própria linguagem java e da apostila Caelum.

3. Como fez?
    
    - O projeto trata-se do uso de dois modelos (classes), no caso as classes Cine e Client.

    - A classe `Passenger` é responsável por guardar os dados do cliente, ou seja, seu nome e telefone.
        - Possui os seguintes atributos: 
            - `name`
            - `age`
        - Possui os seguintes métodos:
            - `getName()` retorna o nome
            - `getAge()` retorna o telefone
            - `toString()` retorna os atributos   
    
    - A classe `Bus` utiliza a classe `Client`.
        - Possui o seguinte atributos: 
            - `normalChairs` - Um Arraylist contendo as cadeiras que serão ocupadas pelas pessoas mais novas no ônibus, onde cada índice é o número da cadeira.

            - `preferredChairs` - Um arraylist contendo as cadeiras de uso preferencial para idosos.

        - Possui os seguintes métodos:
            - `In(Passenger person)` - Recebe os atributos um objeto do tipo `Passenger`, O método verifica: e valida se ainda existem cadeiras vagas nos seguintes casos:
                - Caso o passageiro seja idoso e tenha vagas preferenciais, o idoso fica na primeira cadeira preferencial vaga, caso não tenha vaga nas preferenciais, mas existem vagas nas cadeiras normais, o idoso ficará nessa cadeira
                - Caso o passageiro seja uma pessoa não idosa e se tiver vagas para os assentos normais, ele se sentará na primeira cadeira vazia, caso não tenha vaga nas cadeiras normais e tenha vaga nas preferenciais o mais jovem pode ficar nessas cadeiras preferenciais. Esse método também faz todas as validações necessárias para oi cadastro.

            - `out(String name)` - Recebe como atributo o nome do Passageiro, caso exista altera o valor no índice para `null` e retorna `true`. Caso contrário, retorna `false`

            - `toString()` - Retorna os dados do cinema, no seguinte formato [ @ @ = ], utilizo o '@' caso não exista um pasageiro e seja uma cadeira preferencial e '=' caso não nessa cadeira não tenha passageiro e seja uma cadeira normal.
            Caso exista alguém, será desse formato '@[nome_preferencial:idade]', e '=[nome_pessoaJovem:idade]

    - A classe app é o arquivo responsável para que o usuário possa controlar esse projeto, dizemos que esse app se trata de um `controller`. Nesse projeto, utilizei a lib JOptionPane para pegar os dados do usuário com janelas, utilizo ele como uma interface mais amigável do que utilizar um simples terminal.

    - Além disso, para que a interação com o usuário se torne mais 'gostosa', utilizei blocos try-catch para que onde ocorressem exceções o usuário seria avisado, caso ele errasse algo e assim ele corrigiria e o programa continuaria a funcionar normalmente.

4. O que aprendeu?

    - Reforçou meus conhecimentos com o ArrayList e como utilizar valores nulos com ele. 

    - Aprendi por fora como se utiliza o JOptionPane para melhorar a qualidade e conforto do usuário na entrada de dados.

    - Também assim como em outras linguagens, aprendi a utilizar de forma melhor o Try-catch para validação de exceções.

5. Quanto tempo demorou?

    - Cerca de 50 min. Achei esse projeto bem divertido de fazer!.
