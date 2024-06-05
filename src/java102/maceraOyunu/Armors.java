package java102.maceraOyunu;

public class Armors extends Items {
	
	public Armors(String name, int id, int damage, int price) {
		super(name, id, damage, price);
	
	}
	public Armors() {
		
	}
	
	@Override
	public Items[] item() {
		Armors[] armorsList = {new Armors("Hafif Zırh",1,1,15),
				new Armors("Orta Zırh",2,3,25),
				new Armors("Ağır Zırh",3,5,40)};
		return armorsList;
		
	}
	
		

}
