	Capitulo 3
	
	* Tipos de variaveis em java
		- A linguagem Java, por ter tipagem estatica, eh necessario que indique o tipo de variavel e o seu nome:
		exemplo: int idade = 15;
		
		- O escorpo das variaveis seguem o mesmo padrao da linguagem C, C++, Pascal.
		- Int ( inteiros ), Double( ponto flutuante ), char ( letra ), String (sequencia de letras)
	
	* Casting
		- Em muitas vezes, queremos que copiar o valor de determinada variavel mas convertendo o seu tipo primitivo
		exemplo:
			double pi = 3.1415
			int valor = pi 
			---- O codigo acima nao iria compilar ----
		- Para evitarmos erros, como no codigo acima, utilizamos o CASTING
		onde o casting eh nada mais nada menos que setar o tipo primitivo de um dado
		
		exemplo utilizando o casting:
			double pi = 3.1415
			int valor = (int) pi
			--- Esse (int) converter o pi em um valor inteiro e assim, a variavel valor pode receber um elemento
			de seu tipo, um inteiro :) ---
	
	* Fluxo de controle
		
		**Condicoes

		Nem sempre um codigo segue apenas em uma direcao possivel, mas e SE existir outro caminho alternativo?
		por exemplo, se tivermos um sistema de login, e queiramos que existam varios tipos de login, para funcionario,
		gerente e presidente da empresa, como podemos definir qual login eh pra quem?
		Simples!, utilizando condicoes! que no qual serao verificado se um dado pertence ao funcionario, retorne o login
		do funcionario, se for outro tipo de usuario, retorne o login desse tipo...

		Mas como funcionam essas estruturas de controle em Java?
		Simples, da mesma maneira que as outras linguagens, utilizamos as condicoes booleanas
		
		vamos com um exemplo:
		
		
		** prototipos das funcoes // pense que essas funcoes existem...
		public void loginFuncionario();
		public void loginGerente();
		public void loginPresidente();
		
		public static void main(String[] args) {
			
			//Vamos com esse exemplo
			String tipoUsuario = gerente
			
			//Vamos verificar se a condicao eh verdadeira ou falsa em todos os casos possiveis de login
			if(tipoUsuario == funcionario)
				loginFuncionario(); // caso seja um funcionario ative o login do funcionario
			else if(tipoUsuario == gerente)
				loginGerente();	//caso seja gerente ative o login do gerente
			else if(tipoUsuario == presidente)
				loginPresidente(); //caso seja o presidente ative o login do presidente
			else
				System.out.println("Opcao invalida!");
		}
		
		Switch
		O switch eh semelhante ao uso do if aninhado
		switch(tipoUsuario){
			case 'funcionario':
				loginFuncionario();
				break;
			case 'gerente'
				loginGerente();
				break;
			case 'presidente':
				loginPresidente();
				break;
		}
		
		**Loopings
		E quando queremos que o nosso trecho de codigo rode quantas vezes forem necessarias?
		
		Segue o mesmo padrao das outras linguagens, utilizamos as funcoes while, do while e for
		
			while:
			O while primeiro verifica se a condicao obedece, e entao inicia o looping
			enquando essa condicao eh verdadeira, o looping continua..
			
			exemplo:
			int valor = 1;
			
			//Note que nesse caso ingenuo estamos em looping infinito, mas a funcao eh executada
			todas as vezes que a condicao for verdadeira
			while(valor == 1){
				//Faca alguma coisa
			}
			
			do while:
			O do-while possui as mesmas caracteristicas que o while, porem existe uma pequena diferenca:
			Enquanto o while precisa verificar a condicao para entrar em looping, o while roda a funcao
			inicialmente ( sem verificar a condicao) e depois verifica e se a expressao ainda for verdadeira
			o looping continua
			
			exemplo:
			int valor = 0
			//note que nesse caso ainda entramos no looping, e com isso incrementamos o valor em + 1, e a partir
			dai serah checado a condicao se o valor for maior que 0, que sempre serah verdadeira, nesse caso en-
			traremos em looping infinito.

			do{
				valor = valor + 1;
			
			}while(valor > 0)

			for:
			O for tambem eh uma funcao de loopings, ela realiza loopings seguindo um numero maximo de loopings que
			deverao ser realizados e em cada caso, serah verificado a condicao
			
			Prototipo do for:
				for(inicio; condicao booleana; incremento ou decremento)
			
			exemplo: vamos contar de um ateh 10!;
			
			//inicializando nossa variavel com 1;
			int value = 1;
			
			for(value = 1; value <= 10; value++)
				System.out.println(i);
			
			Nesse caso, a variavel value em cada tempo, serah mostrada na tela, e depois incrementada
			ate com que a condicao booleana seja falsa
	
		**Controlando loopings
			Em loopings, podem existir condicoes em que queiramos parar o looping ou entao, simplesmente pular a etapa corrente
			Utilizamos os comandos break e continue, abaixo explicarei o que sao os dois e a implementacao dos mesmos em exemplos
			
			break:
			O break eh um comando utilizado para parar um looping, segue a sua implementacao
			
			while(true){
				Scanner input = Scanner(System.in);
				System.out.println("Digite um numero...");
				int valor = input.nextInt();
				
				if(valor == 0)
					break;
			}
			
			//O seguinte codigo eh um looping infinito em que se pede um numero, 
			//Porem existe uma verificacao, caso o valor seja igual a 0, o looping simplesmente para.
			
			
			continue:
			O comando continue serve para pular uma etapa e partir direto para a outra.
			
			//Nesse exemplo utilizaremos o continue para printar os numeros pares de um a 100
			
			for(int i = 1; i <= 100; i++){
				
				if(i%2 == 1)
					continue;
				System.out.println(i);
			}

			//Nesse caso, quando chegar um caso em que o numero eh impar, simplesmente damos continue
			(pulamos a etapa) e partimos para a proxima, quando o numero eh par a condicao nao eh satisfeita
			e entao sera printado o valor corrente.

		
		
		***Exercicios:

			--- A seguir segue a questao e o nome do arquivo da implementacao do exericio na pasta Exercicios ---
			Imprima todos os números de 150 a 300. --> printNumbers.java

			Imprima a soma de 1 até 1000. -->  sumTo100.java

			Imprima todos os múltiplos de 3, entre 1 e 100. --> multiple3.java

			Imprima os fatoriais de 1 a 10. --> factorial.java

			(opcional) Imprima os primeiros números da série de Fibonacci até passar de 100. A série de Fibonacci é a seguinte: 0, 1, 1, 2, 3, 5, 8				, 13, 21, etc... Para calculá-la, o primeiro elemento vale 0, o segundo vale 1, daí por diante, o n-ésimo elemento vale o (n-1)-ésimo 	 			 elemento somado ao (n-2)-ésimo elemento (ex: 8 = 5 + 3). ---> fibonacci.java


			(opcional) Escreva um programa que, dada uma variável x com algum valor inteiro, temos um novo x de acordo com a seguinte regra:

			se x é par, x = x / 2
			se x é impar, x = 3 * x + 1
			imprime x
			O programa deve parar quando x tiver o valor final de 1. Por exemplo, para x = 13, a saída será:
			40 -> 20 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1			
			--> stopOne.java

			(opcional) Faca uma questao que dado um numero n, imprima da seguinte maneira:
			1
			2 4
			3 6 9
			n n*2 n*3 ... n*n

