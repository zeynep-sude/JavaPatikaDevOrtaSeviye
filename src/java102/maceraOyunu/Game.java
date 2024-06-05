package java102.maceraOyunu;

import java.util.Scanner;

public class Game {

	private Scanner input = new Scanner(System.in);

	public void start() {
		System.out.println("=====Macere Oyununa Hoşgeldiniz=====");
		System.out.print("Adınızı Giriniz : ");
		String name = input.nextLine();
		System.out.println("----------------------------------------");
		Player player = new Player(name);
		player.selectChar();

		while (true) {
			player.printİnfo();
			Location location = null;
			System.out.println();
			System.out.println("=====Bölgeler=====");
			System.out.println("1- Güvenli Ev -> Can Yenilemek için gidiniz");
			System.out.println("2- Eşya Dükkanı -> İhtiyacınız olan ürünler burada");
			System.out.println("3- Mağara -> Mağaraya git. Dikkat Zombi var");
			System.out.println("4- Orman -> Ormana git. Dikkat Vampir var");
			System.out.println("5- Nehir -> Nehire git. Dikkat Ayı var");
			System.out.println("0- oYUNU Sonlnadır");
			System.out.print("Lütfen Gitmek İstediğiniz Bölgeyi Seçiniz : ");
			System.out.println("-----------------------------------------------");
			int selected = input.nextInt();

			switch (selected) {
			case 0 -> location = null;

			case 1 -> location = new SafeHouse(player);

			case 2 -> location = new ToolStore(player);

			case 3 -> {
				if (!player.getInventory().isFood()) {
					location = new Cave(player);
				} else {
					System.out.println("Bölge Temiz");
					location = new WaitingArea(player);
				}
			}

			case 4 -> {
				if (!player.getInventory().isFirewood()) {
					location = new Forest(player);
				} else {
					System.out.println("Bölge Temiz");
					location = new WaitingArea(player);
				}
				;
			}

			case 5 -> {
				if (!player.getInventory().isWater()) {
					location = new River(player);
				} else {
					System.out.println("Bölge Temiz");
					location = new WaitingArea(player);
				}
			}

			default -> location = new SafeHouse(player);

			}
			if (location == null) {
				System.out.println("Oyun Bitti Yine Bekleriz");
				break;
			}
			if (!location.onLocation()) {
				System.out.println("=====Game Over!!======");
				break;
			}

			if (player.getInventory().isFood() && player.getInventory().isFirewood()
					&& player.getInventory().isWater()) {
				System.out.println();
				System.out.println("Tüm Bölgeleri Temizlediniz Tebrikler !!!");
				System.out.println();
				System.out.println("######  OYUNU KAZANDINIZ  ###### ");
				break;
			}

		}

	}

}
