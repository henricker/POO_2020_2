package Bank;

class Client {
	 private String name;
	    private int age;
	    private String CPF;
	    private String RG;

	    Client(String name, int age, String CPF, String RG) {
	        this.name = name;
	        this.age = age;
	        this.CPF = CPF;
	        this.RG = RG;
	    }
	    String getName() {
	        return this.name;
	    }

	    String getCPF() {
	        return this.CPF;
	    }

	    String getRG() {
	        return this.RG;
	    }

	    int getAge() {
	        return this.age;
	    }

	    public String toString() {
	        return "\n\n\n" +
	               "------------------------------\n" + 
	               "        Dados do cliente      \n" +
	               "------------------------------\n" +
	               "Nome: " + this.name + "\n" +
	               "Idade: " + this.age + "\n" +
	               "CPF: " + this.CPF + "\n" +
	               "RG: " + this.RG + "\n";
	    }

}
