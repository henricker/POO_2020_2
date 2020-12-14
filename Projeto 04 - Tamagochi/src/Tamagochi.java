import java.util.Scanner;

public class Tamagochi {
	
	//Max quantity elements --> Constants
	private final int ENERGY_MAX;
	private final int SATIETY_MAX;
	private final int CLEANING_MAX;
	
	//Atributes 
	private int diamonds;
	private int age;
	private int energy;
	private int satiety;
	private int cleaning;
	private boolean alive;
	
	
	//Constructor
	public Tamagochi(int energyMax, int satietyMax, int cleaningMax) {
		this.ENERGY_MAX = energyMax;
		this.SATIETY_MAX = satietyMax;
		this.CLEANING_MAX = cleaningMax;
		
		this.diamonds = 0;
		this.age = 0;
		this.energy = energyMax;
		this.satiety = satietyMax;
		this.cleaning = cleaningMax;
		this.alive = true;
	}
	
	//all gets methods
	public int getDiamonds() { return this.diamonds;}
	public int getAge() { return this.age;}
	public int getEnergy() { return this.energy;}
	public int getSatiety() { return this.satiety;}
	public int getCleaning() {return this.cleaning;}
	public boolean getAlive() { return this.alive;}
	public int getEnergyMax() {return this.ENERGY_MAX;}
	public int getSatietyMax() {return this.SATIETY_MAX;}
	public int getCleaningMax() { return this.CLEANING_MAX;}
	
	//Set methods
	//all set methods receive values < 0 or values > 0
	private void setEnergy(int value) {
		this.energy += value;
		
		if(this.getEnergy() > this.getEnergyMax())
			this.energy = this.getEnergyMax();
		
		if(this.energy <= 0) {
			this.energy = 0;
			this.alive = false;
			System.out.println("fail: O pet morreu sem energia");
		}
	}
	
	private void setSatiety(int value) {
		this.satiety += value;
		
		if(this.getSatiety() > this.getSatietyMax()) 
			this.satiety = this.getSatietyMax();
		
		if(this.satiety <= 0) {
			this.satiety = 0;
			this.alive = false;
			System.out.println("fail: O pet morreu de fraqueza");
		}
	}
	
	private void setCleaning(int value) {
		this.cleaning += value;
		
		if(this.getCleaning() > this.getCleaningMax())
			this.cleaning = this.getCleaningMax();
		
		if(this.cleaning <= 0) {
			this.cleaning = 0;
			this.alive = false;
			System.out.println("fail: O pet morreu de sujeira");
		}
	}
		
	//O comando "play" altera em -2 energia, -1 saciedade, -3 limpeza, +1 diamante, +1 idade.
	public void play() {
		if(!this.alive) {
			System.out.println("fail: O pet esta morto");
			return;
		}
		this.setEnergy(-2);
		this.setCleaning(-3);
		this.setSatiety(-1);
		
		this.diamonds++;
		this.age++;
	}
	
	// O Comando "eat" altera em -1 a energia, +4 a saciedade, -2 a limpeza, +0 diamantes,  +1 a idade
	public void eat() {
		if(!this.alive) {
			System.out.println("fail: O pet esta morto");
			return;
		}
		this.setEnergy(-1);
		this.setSatiety(4);
		this.setCleaning(-2);
		
		this.age++;
	}
	
	//# O Comando "sleep" aumenta energia até o máximo e idade aumenta do número de turnos que o pet dormiu.
	//# Os outros atributos permanecem inalterados.
	public void sleep() {
		if(!this.alive) {
			System.out.println("fail: O pet esta morto");
			return;
		}
		
		if(this.getEnergyMax() - this.getEnergy() < 5) {
			System.out.println("fail: nao esta com sono");
			return;
		}
		this.age += this.getEnergyMax() - this.getEnergy();
		setEnergy(this.getEnergyMax());
	}
	
	//# O comando "$clean" alteram em -3 energia, -1 na saciedade, MAX na limpeza, +0 diamantes, +2 na idade.
	public void shower() {
		if(!this.alive) {
			System.out.println("fail: O pet esta morto");
			return;
		}
		this.setEnergy(-3);
		this.setSatiety(-1);
		this.setCleaning(this.getCleaningMax());
		
	}
	
	public String toString() {
		return "E: " + this.getEnergy() + " | " + this.getEnergyMax() + "\n" +
			   "S: " + this.getSatiety() + " | " + this.getSatietyMax() + "\n" +
			   "L: " + this.getCleaning() + " | " + this.getCleaningMax() + "\n" +
			   "D: " + this.getDiamonds() + "\n" +
			   "I: " + this.getAge() + "\n";
		
	}
	
	//Main method
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Tamagochi tama = null;
		
		while(true) {
			String[] line = input.nextLine().split(" ");
			
			if(line[0].equals("init"))
				tama = new Tamagochi(Integer.parseInt(line[1]), Integer.parseInt(line[2]), Integer.parseInt(line[3]));
			else if(line[0].equals("show"))
				System.out.println(tama);
			else if(line[0].equals("play"))
				tama.play();
			else if(line[0].equals("eat"))
				tama.eat();
			else if(line[0].equals("clean"))
				tama.shower();
			else if(line[0].equals("sleep"))
				tama.sleep();
			else if(line[0].equals("end"))
				break;
			else
				System.out.println("Comando inválido!");
		}
	}

}
