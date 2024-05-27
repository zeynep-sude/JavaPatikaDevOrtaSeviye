package java102.hackerRank;
import java.util.Scanner;

public class staticBlok {
	public static boolean flag = true;
	public static int B;
	public static int H;
	static {
		Scanner input = new Scanner(System.in);
		System.out.println("Sayı giriniz");
		B = input.nextInt();
		H = input.nextInt();
		if (B >= -100 && B <= 100 || H >= -100 && H <= 100) {
			if (B <= 0 || H <= 0) {
				System.out.println("java.lang.Exception: Breadth and height must be positive");
				flag = false;
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		if (flag) {
			int area = B * H;
			System.out.print(area);
		}

	}

}
