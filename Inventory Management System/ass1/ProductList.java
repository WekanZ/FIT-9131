package ass1;
/**
 * @author  Weikan Zhou
 * @version 3.7
 */
public class ProductList 
{
	private Product[] listOfProducts;

	public ProductList()
	{
		this.listOfProducts = new Product[5];
	}
	
	public ProductList(Product[] listOfProducts) 
	{
		this.listOfProducts = listOfProducts;
	}

	public void displayProductList()
	{
		for (int index = 0; index < 5; index++)
		{
			if (listOfProducts[index] != null)
			{
				System.out.println();
				System.out.println("Product" + (index + 1));
				System.out.println(" Name: " + listOfProducts[index].getName());
				System.out.println(" Description: " + listOfProducts[index].getDesc());
				System.out.println(" Price: " + listOfProducts[index].getPrice());
				System.out.println(" Quantity on hand: " + listOfProducts[index].getQtyOnHand());
				System.out.println(" Min Order Quantity: " + listOfProducts[index].getMinOrderQty());
				System.out.println();
			}
		}
	}
	

	public void generateProductList() 
	{
		for (int index = 0; index < 5; index++)
		{
			listOfProducts[index] = new Product();
		}
	}
	
	public Product[] getListOfProducts() 
	{
		return listOfProducts;
	}

	public Product newProduct()
	{
		Product product = new Product();
		return product;
	}
	
	public void setListOfProducts(Product[] listOfProducts) 
	{
		this.listOfProducts = listOfProducts;
	}
}
