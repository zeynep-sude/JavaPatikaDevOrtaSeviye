package java102.maceraOyunu;

public class Obstacle {
	private String name;
	private int id;
	private int damage;
	private int health;
	private int awardMoney;
	private int orjinalHealth;
	
	public Obstacle(String name,int id,int damage,int health,int awardMoney) {
		this.name = name;
		this.id = id;
		this.damage = damage;
		this.health  =health;
		this.orjinalHealth = health;
		this.awardMoney = awardMoney;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		if(health<0) {
			health = 0;
		}
		this.health = health;
	}

	public int getAwardMoney() {
		return awardMoney;
	}

	public void setAwardMoney(int awardMoney) {
		this.awardMoney = awardMoney;
	}

	public int getOrjinalHealth() {
		return orjinalHealth;
	}

	public void setOrjinalHealth(int orjinalHealth) {
		this.orjinalHealth = orjinalHealth;
	}
	
	

}
