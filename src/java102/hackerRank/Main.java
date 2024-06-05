package java102.hackerRank;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(win());
		
	}
	static String win() {
		Random random = new Random();
        int chance = random.nextInt(100); // 0-99 arası rastgele bir sayı
        
        if (chance < 15) {
            return "Silah";
        } else if (chance < 35) {
            return "Tüfek";
        } else if (chance < 65) {
            return "Kılıç";
        } else if (chance < 115) { // Toplamda %50, önceki %20 ile 30 arasında
            return "Tabanca";
        } else if (chance < 130) {
            return "Zırh";
        } else if (chance < 150) {
            return "Ağır Zırh";
        } else if (chance < 180) {
            return "Orta Zırh";
        } else if (chance < 230) { // Toplamda %50, önceki %30 ile 50 arasında
            return "Hafif Zırh";
        } else if (chance < 255) {
            return "Para";
        } else if (chance < 275) {
            return "10 Para";
        } else if (chance < 305) {
            return "5 Para";
        } else if (chance < 355) {
            return "1 Para";
        } else {
            return "Hiçbir şey";
        }
	     

	}

}
