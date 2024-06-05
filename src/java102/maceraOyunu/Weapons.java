package java102.maceraOyunu;

public class Weapons extends Items {
	
	public Weapons(String name,int id,int damage,int price) {
		super(name, id, damage, price);
	}
	public Weapons() {
		
	}
	@Override
	public  Items[] item() {
		Weapons[] weaponList  = {new Weapons("Tabanca" ,1,2,25),
				new Weapons("Kılıç",2,3,5),
				new Weapons("Tüfek",3,7,45)};
		return weaponList;
		
	}
	

}
