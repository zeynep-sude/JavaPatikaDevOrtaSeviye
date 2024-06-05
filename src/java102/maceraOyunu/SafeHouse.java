package java102.maceraOyunu;

public class SafeHouse extends NormalLoc {

	public SafeHouse(Player player) {
		super(player, "Güvenli Ev");
	}

	@Override
	public boolean onLocation() {
		System.out.println("Güvenli Eve Hoşgeldiniz!!");
		System.out.println("Canınını Yenileniyor");
		this.getPlayer().setHealth(this.getPlayer().getOrjinalHealth());
		return true;
	}

	
	
	

}
