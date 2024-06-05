package java102.maceraOyunu;

import java.util.Random;

public class BattleLoc extends Location {

	private Obstacle obstacle;
	private String award;
	private int maxObstacle;

	public BattleLoc(Player player, String name, Obstacle obstacle, String award, int maxObstacle) {
		super(player, name);
		this.obstacle = obstacle;
		this.award = award;
		this.maxObstacle = maxObstacle;

	}

	@Override
	public boolean onLocation() {
		int obstacleNum = this.randomObstacleNumber();

		System.out.println("Bulunduğunuz alan bir " + this.getName());

		System.out
				.println("Dikkatli ol burada " + obstacleNum + " tane " + this.getObstacle().getName() + " yaşıyor!!");

		System.out.print("<S>avaş ya da <K>aç : ");
		String selectCase = input.nextLine();
		selectCase = selectCase.toUpperCase();

		if (selectCase.equals("S")) {
			System.out.println("Savaş Başlasın");
			if (combat(obstacleNum)) {
				System.out.println(this.getName() + " Bulunan Tüm Düşmanları Yendiniz");
				this.getPlayer().getInventory().setPrize(this.getAward());
				System.out.println("Tebrikler Bölge ödülünü kazandınız !!!! " + this.getPlayer().getInventory().getPrize() );
				return true;
			}
		}

		if (this.getPlayer().getHealth() <= 0) {
			System.out.println("Öldünüz");
			return false;
		}

		return true;
	}
	
	

	public boolean combat(int obsNumber) {
		for (int i = 1; i <= obsNumber; i++) {
			this.getObstacle().setHealth(this.getObstacle().getOrjinalHealth());
			playerStats();
			obstacleStats(i);

			while (this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0) {

				System.out.print("<V>ur veya <K>aç : ");
				String selectCombat = input.nextLine();
				selectCombat = selectCombat.toUpperCase();

				Random r = new Random();
				int firstHit = r.nextInt(2) + 1;

				if (selectCombat.equals("V")) {
					if (firstHit == 1) {
						System.out.println("Siz Vurdunuz");
						this.getObstacle()
								.setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
						afterHit();
					} else {
						if (this.getObstacle().getHealth() > 0) {
							System.out.println("Canavar Size Vurdu");
							int obstacleDamage = this.getObstacle().getDamage()
									- this.getPlayer().getInventory().getArmor().getDamage();
							if (obstacleDamage < 0) {
								obstacleDamage = 0;
							}
							this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
							afterHit();
						}

					}
				}else {
					return false;
				}

			}

			if (this.getObstacle().getHealth() < this.getPlayer().getHealth()) {
				System.out.println(i + ". " + this.getObstacle().getName() + " Öldü");
				System.out.println(this.getObstacle().getAwardMoney() + " Altın Kazandınız");
				this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAwardMoney());
				System.out.println("Güncel Bakiyeniz : " + this.getPlayer().getMoney());
			} else {
				return false;
			}
		}

		return true;
	}

	public void afterHit() {
		System.out.println("Canınız : " + this.getPlayer().getHealth());
		System.out.println(this.getObstacle().getName() + " canı " + this.getObstacle().getHealth());
		System.out.println();
	}

	public void playerStats() {
		System.out.println("Oyuncu Değerleri");
		System.out.println("---------------------------------");
		System.out.println("Sağlık : " + this.getPlayer().getHealth());
		System.out.println("Silah : " + this.getPlayer().getInventory().getWeapon().getName());
		System.out.println("Hasar : " + this.getPlayer().getTotalDamage());
		System.out.println("Zırh : " + this.getPlayer().getInventory().getArmor().getName());
		System.out.println("Bloklama : " + this.getPlayer().getInventory().getArmor().getDamage());
		System.out.println("Para : " + this.getPlayer().getMoney());
	}

	public void obstacleStats(int i) {
		System.out.println(i + ". " + this.getObstacle().getName() + " Değerleri");
		System.out.println("--------------------------------");
		System.out.println("Sağlık : " + this.getObstacle().getHealth());
		System.out.println("Hasar : " + this.getObstacle().getDamage());
		System.out.println("Ödül : " + this.getObstacle().getAwardMoney());
	}

	public int randomObstacleNumber() {
		Random r = new Random();

		return r.nextInt(3) + 1;
	}

	public Obstacle getObstacle() {
		return obstacle;
	}

	public void setObstacle(Obstacle obstacle) {
		this.obstacle = obstacle;
	}

	public String getAward() {
		return award;
	}

	public void setAward(String award) {
		this.award = award;
	}

	public int getMaxObstacle() {
		return maxObstacle;
	}

	public void setMaxObstacle(int maxObstacle) {
		this.maxObstacle = maxObstacle;
	}

}
