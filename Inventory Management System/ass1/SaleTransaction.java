package ass1;
/**
 * @author  Weikan Zhou
 * @version 3.7
 */
import java.util.Random;
public class SaleTransaction 
{
	private int saleCode;
	private Product[] items;
	private double totalCost;

	public SaleTransaction()
	{
		this.saleCode = 0;
		this.items = new Product[3];
		this.totalCost = 0.0;
	}
	
	public SaleTransaction(int saleCode, 
							Product[] items, 
							double totalCost) 
	{
		this.saleCode = saleCode;
		this.items = items;
		this.totalCost = totalCost;
	}

	public void addTotalCost(double amount) 
	{
		this.totalCost += amount;
	}

	public void displayItems()
	{
		for (int index = 0; index < 3; index++)
		{
			if (items[index] != null)
			{
				System.out.println();
				System.out.println("Select Added Item " + (index + 1));
				System.out.println(" Name: " + items[index].getName());
				System.out.println(" Description: " + items[index].getDesc());
				System.out.println(" Price: " + items[index].getPrice());
				System.out.println(" Product in the cart: " + items[index].getQtyOnHand());
				System.out.println(" Min Order Quantity: " + items[index].getMinOrderQty());
				System.out.println();
			}
		}
	}
	
	public void generateItems()
	{
		for (int index = 0; index < 3; index++)
		{
			items[index] = new Product();
		}
	}
	
	public void generateSaleCode()
	{
		Random ran = new Random();
		this.saleCode = ran.nextInt(999999);
	}
	
	public Product[] getItems() 
	{
		return items;
	}
	
	public int getSaleCode() 
	{
		return saleCode;
	}

	public double getTotalCost() 
	{
		return totalCost;
	}

	public Product newItem()
	{
		Product product = new Product();
		return product;
	}
	
	public void setItems(Product[] items) 
	{
		this.items = items;
	}

	public void setItems(Product product, 
							int index) 
	{
		this.items[index] = product;
	}

	public void setSaleCode(int saleCode) 
	{
		this.saleCode = saleCode;
	}
	
	public void setTotalCost(double totalCost) 
	{
		this.totalCost = totalCost;
	}
}
