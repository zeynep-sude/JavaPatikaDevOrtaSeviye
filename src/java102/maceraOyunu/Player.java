package java102.maceraOyunu;

import java.util.Scanner;

public class Player {
	private String charName;
	private String name;
	private int damage;
	private int health;
	private int money;
	public static Scanner input = new Scanner(System.in);
	private Inventory inventory;
	private int orjinalHealth;
	
	public Player(String name) {
		this.name = name;
		this.inventory = new Inventory();
	}
	
	public void selectChar() {
		  GameChar[] charList= {new Samurai(),new Archer(),new Knight()};
		  for(GameChar gameChar:charList) {
			  System.out.println("ID: " +gameChar.getId()+
					  "\tKarakter :" +gameChar.getName() +
					  "\tHasar : "+gameChar.getDamage()+
					  "\t Sağlık : "+gameChar.getHealth() +
					  "\t Para : " +gameChar.getMoney());
		  }
		  System.out.println("Lütfen Karakter Seçiniz");
		  int select = input.nextInt();
		  switch(select) {
		  case 1-> this.initPLayer(new Samurai());
		  case 2->this.initPLayer(new Archer());
		  case 3->this.initPLayer(new Knight());
		  }
		  
		 /* System.out.println("Karakter :" +this.getCharName()
		  +" Hasar : "+this.getDamage()
		  +" Sağlık : "+this.getHealth() 
		  +" Para : " +this.getMoney()); */
		  
		  System.out.println("-----------------------------");
	
	}
	
	public void printİnfo() {
		System.out.println("Silahınız :" +this.getInventory().getWeapon().getName()
		  +" Zırhınız : " + this.getInventory().getArmor().getName()
		  +" Hasarınız : "+this.getTotalDamage()
		  +" Sağlığınız : "+this.getHealth() 
		  +" Paranız : " +this.getMoney());
	}
	
	public void initPLayer(GameChar character) {
		this.charName = character.getName();
		this.damage = character.getDamage();
		this.health = character.getHealth();
		this.money = character.getMoney();
		this.orjinalHealth = character.getHealth();
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getCharName() {
		return charName;
	}

	public void setCharName(String charName) {
		this.charName = charName;
	}
public int getTotalDamage() {
	return damage + this.getInventory().getWeapon().getDamage();
}
	public int getDamage() {
		return damage ;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public int getOrjinalHealth() {
		return orjinalHealth;
	}

	public void setOrjinalHealth(int orjinalHealth) {
		this.orjinalHealth = orjinalHealth;
	}
	
	
	

	

}
