package java102.maceraOyunu;

public class ToolStore extends NormalLoc {

	public ToolStore(Player player) {
		super(player, "Mağaza");

	}

	@Override
	public boolean onLocation() {
		System.out.println("Mağazaya Hoşgeldiniz");
		boolean showMenu = true;
		while (showMenu) {
			System.out.println();
			System.out.println("=====Menü=====");
			System.out.println("1- Silah");
			System.out.println("2- Zırh");
			System.out.println("3- Çıkış Yap");
			System.out.println("Menüden Seçim Yapınız");
			int selectMenu = input.nextInt();
			while (selectMenu < 1 || selectMenu > 3) {
				System.out.println("Lütfen Menüde Var Olan Ürünlerden Seçim Yapınız");
				selectMenu = input.nextInt();

			}

			switch (selectMenu) {
			case 1 -> {
				printItems(new Weapons());
				buyItems(new Weapons());
			}

			case 2 -> {
				printItems(new Armors());
				buyItems(new Armors());
			}

			case 3 -> {
				System.out.println("Bir daha bekleriz");
				showMenu = false;
			}
			}
		}
		return true;
	}

	public void printItems(Items item) {
		System.out.println("=====Ürünler=====");
		for (Items i : item.item()) {
			System.out.println(i.getId() + "-" + i.getName() + "< Para : " + i.getPrice() + ", Engelleme : "
					+ i.getDamage() + " >");
		}
		System.out.println("0 - Çıkış Yap");
		System.out.println();

	}

	public void buyItems(Items item) {
		System.out.print("Satın Almak İstediğiniz Ürünü Seçiniz : ");
		int selectItem = input.nextInt();

		while (selectItem < 0 || selectItem > item.item().length) {
			System.out.print("Lütfen Var Olan Ürünlerden Seçim Yapınız !!");
			System.out.print("Satın Almak İstediğiniz Ürünü Seçiniz : ");
			selectItem = input.nextInt();
		}

		if (selectItem != 0) {
			Items selectedItem = item.getItemsById(selectItem);
			if (selectedItem != null) {
				if (selectedItem.getPrice() > this.getPlayer().getMoney()) {

					System.out.println("Bakiyniz yetersiz");
				} else {

					System.out.println("---" + selectedItem.getName() + " Satın Aldınız ---");
					int balance = this.getPlayer().getMoney() - selectedItem.getPrice();
					this.getPlayer().setMoney(balance);
					System.out.println("Kalan Paranız : " + this.getPlayer().getMoney());
					if (selectedItem instanceof Armors) {

						System.out.println("Önceki Zırhınız : " + this.getPlayer().getInventory().getArmor().getName());
					} else if (selectedItem instanceof Weapons) {

						System.out
								.println("Önceki Silahınız : " + this.getPlayer().getInventory().getWeapon().getName());
					}
					
					Inventory inventory = this.getPlayer().getInventory();
					
					if (selectedItem instanceof Armors) {

						inventory.setArmor((Armors) selectedItem);
						System.out.println("Yeni Zırhınız: " + inventory.getArmor().getName());
					} else if (selectedItem instanceof Weapons) {

						inventory.setWeapon((Weapons) selectedItem);
						System.out.println("Yeni Silahınız: " + inventory.getWeapon().getName());
					} else {

						System.out.println("Yeni Ürününüz: " + selectedItem.getName());
					}

				}
			}
		}

	}
	/*
	 * public void printWeapon() { System.out.println("=====Silahlar====="); for
	 * (Weapons w : Weapons.weapons()) { System.out.println( w.getId() + "-" +
	 * w.getName() + "<Para : " + w.getPrice() + ", Hasar : " + w.getDamage() +
	 * ">"); }
	 * 
	 * }
	 * 
	 * public void buyWeapon() { System.out.print("Bir Silah Seçiniz : "); int
	 * selectWeapon = input.nextInt(); while(selectWeapon<1 ||
	 * selectWeapon>Weapons.weapons().length) {
	 * System.out.print("Lütfen Menüde Var Olan Ürünlerden Seçim Yapınız : ");
	 * selectWeapon = input.nextInt();
	 * 
	 * } Weapons selectedWeapons = Weapons.getWeaponById(selectWeapon);
	 * if(selectedWeapons != null) { if(selectedWeapons.getPrice() >
	 * this.getPlayer().getMoney()) { System.out.println("Bakiyniz yetersiz"); }else
	 * { System.out.println("---" +selectedWeapons.getName() + " Satın Aldınız"+
	 * "---"); int balance = this.getPlayer().getMoney() -
	 * selectedWeapons.getPrice(); this.getPlayer().setMoney(balance);
	 * System.out.println("Kalan Paranız : " + this.getPlayer().getMoney());
	 * System.out.println("Önceki Silahınız : " +
	 * this.getPlayer().getInventory().getWeapon().getName());
	 * this.getPlayer().getInventory().setWeapon(selectedWeapons);
	 * System.out.println("Yeni Silahınız : " +
	 * this.getPlayer().getInventory().getWeapon().getName()); } } }
	 */

}
