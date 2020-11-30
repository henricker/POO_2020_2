## Calango - S02E01

Na aula vista, vimos como funciona os fundamentos de POO em java, o professor passou um exemplo, e, a partir desse exemplo farei as minhas alterações.

## Atributos do calango
- `life`: Vida do meu animal, por padrão quando instanciado vem "100%";
- `Stomach`: Se refere a quantidade de comida armazenada em sua barriga;
- `MaxStomachCapacity`: Refere-se a capacidade máxima de comida que pode ser armazenada no estômago do calango;
- `experience`: O nivel de habilidades de caça do animal, a medida que ele cresce, maior a probabilidade de encontrar mais insetos, o nivel MAXIMO de experiencia é 100;
- `walked`: A quantidade que o animal percorreu.

## Métodos da classe
- `Calango`: Método construtor, onde inicializa suas variaveis.
- `huntBug()`: Método onde o calango busca seu alimento, ele gasta um de energia contida em seu estômago e ganha de experiência o valor de insetos encontrados. Caso encontre insetos, ele pode se alimentar do máximo (que puder) de alimentos encontrados, esse metodo invoca outro metodo chamado `eating`, passando por parâmetro o numero de insetos cacados. 
- `eating()`: Método que faz com que o calango coma uma capacidade N de insetos passados por parâmetro
- `toWalk()`: Caso o animal esteja vivo, a funcao faz com que o calango se movimente atribuindo +1 ao atributo `walked` caso ele tenha comida armazenada no estômago, ele a utiliza como energia (perdendo -1 de energia contida), caso contrario ele gasta a propria vida para caminhar (perdendo -10 de vida para cada +1 no walked).
- `killCalanguim()`: Esse metodo mata o calango, alterando sua vida para zero.

