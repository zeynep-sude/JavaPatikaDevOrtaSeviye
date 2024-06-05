package java102.maceraOyunu;

public abstract class Items {
	private String name;
	private int id;
	private int damage;
	private int price;
	
	public Items(String name, int id, int damage, int price) {
		super();
		this.name = name;
		this.id = id;
		this.damage = damage;
		this.price = price;
	}
	public Items() {
		
	}
	public abstract Items[] item() ;
	
	public Items getItemsById(int id) {
		for(Items w:item()) {
			if(w.getId() == id) {
				return w;
			}
		}
		return null;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	

}
