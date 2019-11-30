package ass1;
/**
 * @author  Weikan Zhou
 * @version 3.7
 */
import java.util.Scanner;
import java.util.Random;
public class Product implements Products
{
	private String name;
	private String desc;
	private double price;
	private int qtyOnHand;
	private int minOrderQty;
	
	public Product()
	{
		this.name = "";
		this.desc = "";
		this.price = 0.0;
		qtyOnHand = 0;
		minOrderQty = 0;
	}
	
	public Product(String name, 
					String desc, 
					double price) 
	{
		Random random = new Random();
		this.name = name;
		this.desc = desc;
		this.price = price;
		qtyOnHand = random.nextInt(10);
		minOrderQty = 1 + random.nextInt(4);
	}

	public void addQtyOnHand(int qtyOnHand) 
	{
		if (qtyOnHand < 0)
		{
			System.out.println("Quantity on hand cannot less than 0, fail to add");
		}
		else
		{
			this.qtyOnHand += qtyOnHand;
		}
	}

	public void displayProduct()
	{
		System.out.println("\n" + "Product" + "\n" + " Name: " + getName() + "\n" + " Description: " + getDesc() + "\n" + " Price: " + getPrice() + "\n" + " Quantity on hand: " + getQtyOnHand() + "\n" + " Min Order Quantity: " + getMinOrderQty() + "\n");
	}
	
	public String getDesc() 
	{
		return desc;
	}

	public int getMinOrderQty() 
	{
		return minOrderQty;
	}

	public String getName() 
	{
		return name;
	}
	
	public double getPrice() 
	{
		return price;
	}
	
	public int getQtyOnHand() 
	{
		return qtyOnHand;
	}

	public void renewQtyOnHand(int qtyOnHand) 
	{
		if (qtyOnHand < 0)
		{
			System.out.println("Quantity on hand cannot less than 0, fail to add");
		}
		else
		{
			this.qtyOnHand -= qtyOnHand;
		}
	}

	public void setDesc(String desc) 
	{
		Scanner input = new Scanner(System.in);
		while (desc.length() < 1 || desc.length() > 50)
		{
			System.out.println("Your description must be between 1 and 50 characters long, please enter again:");
			desc = input.next();
		}
		this.desc = desc;
	}

	public void setMinOrderQty(int minOrderQty) 
	{
		if (minOrderQty < 1)
		{
			System.out.println("Minimum order quantity must above 0");
		}
		else
		{
			this.minOrderQty = minOrderQty;
		}
	}

	public void setName(String name) 
	{
		Scanner input = new Scanner(System.in);
		while (name.trim().length() < 3 || name.trim().length() >25)
		{
			System.out.println("Product name must be between 3 and 25 characters long" + "\n" + "Please enter again:");
			name = input.next();
		}
		this.name = name;
	}

	public void setPrice(double price) 
	{
		Scanner input = new Scanner(System.in);
		while (price <= 0)
		{
			System.out.println("Your price must above 0, please enter again:");
			price = input.nextDouble();
		}
		this.price = price;
	}

	public void setQtyOnHand(int qtyOnHand) 
	{
		if (qtyOnHand < 0)
		{
			System.out.println("Quantity on hand cannot less than 0, fail to add");
		}
		else
		{
			this.qtyOnHand = qtyOnHand;
		}
	}
}