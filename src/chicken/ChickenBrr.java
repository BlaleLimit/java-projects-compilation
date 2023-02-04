package chicken;

import java.util.Scanner;

public class ChickenBrr {
	static int number, number2, size, size2;
	static String variant, variant2, flavor;
	static boolean b;

	static final ChickenToGo chick = new ChickenToGo();
	static final ChickFlavor chick2 = new ChickFlavor();

	public static void printResult() {
		chick.setItems(number, size, variant);
		System.out.println("\nFirst Chicken:\nOrder Number is " + chick.getNumber() + ".");
		System.out.println("Size pcs are " + chick.getSize() + ".");
		System.out.println("Variant is " + chick.getVariant() + ".");
		System.out.println("Price " + chick.getPrice() + ".");

		chick2.setItems(number, size, variant);
		chick2.setFlavor(flavor);
		System.out.println("\nSecond Chicken:\nOrder Number is " + chick2.getNumber() + ".");
		System.out.println("Size pcs are " + chick2.getSize() + ".");
		System.out.println("Variant is " + chick2.getVariant() + ".");
		System.out.println("Price " + chick2.getPrice() + ".");
		System.out.println("Flavor is " + chick2.getFlavor() + ".");
	}
	public static void process() {
		b = true;
		while (b) {
			try {
				Scanner s = new Scanner(System.in);
				System.out.print("First Chicken:\nOrder Number (number only)? ");
				number = Integer.parseInt(s.nextLine());
				System.out.print("Size (6, 8, and 10 only)? ");
				size = Integer.parseInt(s.nextLine());
				System.out.print("Variant? ");
				variant = s.nextLine();

				System.out.print("\nSecond Chicken:\nOrder Number (number only)? ");
				number2 = Integer.parseInt(s.nextLine());
				System.out.print("Size (6, 8, or 10 only)? ");
				size2 = Integer.parseInt(s.nextLine());
				System.out.print("Variant? ");
				variant2 = s.nextLine();
				System.out.print("Flavor? ");
				flavor = s.nextLine();

				b = false;
			} catch(Exception ex) {
				System.out.print("========================================\n");
				System.out.println("Invalid Input");
				System.out.print("========================================\n");
				main(null);
			}
		}
	}

	public static void main(String[] args) {
		process();
		printResult();
	}
}