	Capitulo 2
	
	* Entendendo a linguagem Java e sua forma de compilar:

	Em aplicacoes utilizando linguagens como C e Pascal, podem acabar tendo execucoes de formas diferentes por conta dos diferentes tipos de 
	SO's que a aplicacao estah rodando. A linguagem Java, utiliza a sua propria maquina virtual para resolver esse problema, ela eh como se
	fosse um "minicomputador" que tambem possui controle de alocacao de memoria, threads, pilhas de execucao e etc. Essa maquina virtual in-
	terpreta o codigo, gera um bytecode e ela mesmo executa, sem precisar de apoio do sistema operacional. Assim, um codigo rodado em Java
	tera a mesma execucao em diferentes sistemas operacionais.
	
	No quesito velocidade no tempo de compilacao, a JVM utiliza dois elementos: O Hotpot, que detecta os pontos "quentes" do codigo a ser
	compilado, geralmente trechos de codigos que estao em 1 ou mais loopings. E o JIT (Just inTime Compiler), onde ele compila dinamicamente
	os trechos de codigo, assim o compilador pode ver se existe algum trecho que nao estah sendo executado de forma correta, e dai ele pode
	focar nesses elementos e no final, obter uma boa desenvoltura na compilacao.

	O uso da linguagem possui o foco, geralmente, em sistemas de medio e grande porte. Mesmo que a construcao de um sistema com java seja bem
	dificil e as vezes complicado, no final quando o projeto estah feito, torna-se facil na hora de refatorar ou fazer alteracoes no codigo 
	pois eh uma linguagem orientada a objetos e bem madura (seguindo, claro, os padroes de DESIGN do paradigma).
	
	* Criando o primeiro programa em Java
	Primeiro, eh interessante saber que o compilador soh pode compilar o codigo se o arquivo Java possuir o mesmo nome que a classe principal
	por exemplo: 
	
	Vamos criar um arquivo com o nome: HelloWorld.java
	no linux --> touch HelloWorld.java
	dentro dele vamos fazer a seguinte edicao: 
	
	public class HelloWorld {
	
		public static void main(String[] args) {
			System.out.println("Hello World!");
		}

	}
	
	Para compilar, abra o seu terminal na pasta onde estah inserido o arquivo:
		Digite:
		javac HelloWorld.java --> O javac compila e gera um bytecode ( codigo de maquina para o JVM executar)
		
		HelloWorld.class eh o codigo convertido em codigo de maquina para o JVM
		
		Em seguida digite:
		Java HelloWorld --> Agora o JVM vai executar esse codigo
		
		No final virah como output:
		Hello World!
	
	Pronto, voce executou seu primeiro programinha em java!

