## Carro esportivo - Projeto 02 POO

- [x] Classe carro criada

    ## Atributos
    - `pass`: Passageiros;
    - `passMax`: Numero maximo de passageiros que podem entrar (2 pessoas);
    - `gas`: Quantidade abastecida no carro;
    - `gasMax`: Quantidade maxima que pode ser abastecido (100 litros)
    - `km`: Distancia em kilometros percorrida pelo carro

    ## Metodos
    - `embarcar()`: Adiciona um passageiro no carro, caso o carro ja esteja lotado
    terá o seguinte aviso: "Carro esta lotado...";
    - `desembarcar()`: Semelhante ao embarcar, mas sua função é remover uma pessoa no carro, caso ja esteja vazio terá o seguinte aviso: "O carro ja esta vazio...";
    - `abastecer()`: Coloca o combustivel no carro, recebendo como parametro a quantidade a ser abastecida.
    - `dirigir()`: 
        - Requisitos para dirigir: `pass > 0 && gas > 0`,
        - Recebe como parametro a distancia a ser percorrida,
        - Para cada um kilometro percorrigo, sao gastos um litro de combustivel
        - Se o total de gasolina atual for menor que a distancia a ser percorrida,
          entao o carro dirigi ate o seu limite e emite um aviso: "Acabou o combustivel em n
          kilometros percorridos".
    
    ## Para o controle desses metodos e atributos fiz uma main interativa
        Assim o usuario pode usar e abusar das metodos e atributos criados.

    [](controller.png)