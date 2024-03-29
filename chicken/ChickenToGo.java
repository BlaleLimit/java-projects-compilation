package chicken;

public class ChickenToGo {
	private int number;
	private int size;
	private String variant;
	private int price;

	// get methods
	// <editor-fold>
	public int getNumber()
	{
		return number;
	}
	public int getSize()
	{
		return size;
	}
	public String getVariant()
	{
		return variant;
	}
	public int getPrice()
	{
		return price;
	}
	// </editor-fold>

	// set methods
	// <editor-fold>
	public void setItems(int number, int size, String variant) {
		this.number = number;
		this.size = size;
		this.variant = variant;

		switch (size) {
			case 6 -> this.price = 1;
			case 8 -> this.price = 2;
			case 10 -> this.price = 3;
			default -> System.out.println("Invalid input");
		}
	}
	// </editor-fold>
}