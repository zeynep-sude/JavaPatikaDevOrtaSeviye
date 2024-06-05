package java102.maceraOyunu;

public class Inventory {
	private Weapons weapon;
	private Armors armor;
	private String prize="";
	private boolean water =false;
	private boolean food =false;
	private boolean firewood =false;
	
	public Inventory() {
		this.weapon = new Weapons("Yumruk",-1,0,0);
		//this.armor = new Armors("Paçavra",0,0,0);
		this.armor = new Armors("Paçavra",-1,0,0);;
	}

	public Weapons getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapons weapon) {
		this.weapon = weapon;
	}

	public Armors getArmor() {
		return armor;
	}

	public void setArmor(Armors armor) {
		this.armor = armor;
	}

	public String getPrize() {
		return prize;
	}

	public void setPrize(String prize) {
		this.prize = prize;
	}

	public boolean isWater() {
		if(this.prize.equals("Su")) {
			this.water =true;
		}
		return water;
	}

	public void setWater(boolean water) {
		this.water = water;
	}

	public boolean isFood() {
		if(this.prize.equals("Food")) {
			this.food = true;
		}
		return food;
	}

	public void setFood(boolean food) {
		
		this.food = food;
	}

	public boolean isFirewood() {
		if(this.prize.equals("Odun")) {
			this.firewood = true;
		}
		return firewood;
	}

	public void setFirewood(boolean firewood) {
		this.firewood = firewood;
	}

	
	

}
