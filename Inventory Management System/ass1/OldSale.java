package ass1;
import java.util.Scanner;
public class OldSale 
{
	private ProductList productList;
	private SaleTransaction transaction;
	
	public void openMenu()
	{
		String welcome = "=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=" + "\n" + "Welcome to the Sample Inventory Management System" + "\n" + "=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=" + "\n"  ;
		String mmm = "\n" + "Please Select from the following options" + "\n" + "Press 1 to Register a Product for Sale" + "\n" + "Press 2 to Buy a Product to the Cart" + "\n" + "Press 3 to Remove a Product from the Cart" + "\n" + "Press 4 to View all Aviable Products" + "\n" + "Press 5 to Check out" + "\n" + "Press 6 to Get Help" + "\n" + "press 7 to Exit" + "\n" + "Please Enter your Choice:";
		System.out.println(welcome + mmm);		
		SaleTransaction sale = new SaleTransaction();
		sale.generateItems();
		int x = inputI();
		String[] name = new String[5];
		String[] desc = new String[5];
		double[] price = new double[5];
		int[] qty = new int[5];
		int[] min = new int[5];
		int[] cart = new int[5];
		int index = 0;
		int type = 0;
		while (x != 7)
		{
			switch (x)
			{
			case 1:
				ProductList list = new ProductList();
				list.generateProductList();
				RandomNumberGenerator ran = new RandomNumberGenerator();
				if (index == 5)
				{
					System.out.println("The system only allows a maximum of FIVE products which can be registered" + "\n" + "Please choose other option");
				}
				while (index < 5)
				{
					if (list.getListOfProducts()[index].getName().equals(""))
					{
						list.getListOfProducts()[index].setName(input("Please enter your product name:"));
						for (int k = 0; k < index; k++)
						{
							if (list.getListOfProducts()[index].getName().equalsIgnoreCase(name[k]))
							{
								list.getListOfProducts()[index].setName(input("You can not use the same name, please enter a new name:"));
								k = -1;
							}
						}
						list.getListOfProducts()[index].setDesc(input("Please enter your product description:"));
						list.getListOfProducts()[index].setPrice(inputD("Please enter your product price:"));
						list.getListOfProducts()[index].setQtyOnHand(ran.randomNum(0,10));
						list.getListOfProducts()[index].setMinOrderQty(ran.randomNum(1,5));
						name[index] = list.getListOfProducts()[index].getName();
						desc[index] = list.getListOfProducts()[index].getDesc();
						price[index] = list.getListOfProducts()[index].getPrice();
						qty[index] = list.getListOfProducts()[index].getQtyOnHand();
						min[index] = list.getListOfProducts()[index].getMinOrderQty();
						System.out.println("\n" + "Product" + (index + 1) + "\n" + " Name: " + name[index] + "\n" + " Description: " + desc[index] + "\n" + " Price: " + price[index] + "\n" + " Quantity on hand: " + qty[index] + "\n" + " Min Order Quantity: " + min[index] + "\n");
						index++;
						break;
					}
					else
					{
						index++;
					}
				}
				break;
			case 2:
				if (name[0] == null)
				{
					System.out.println("Please press 1 to register a product first");
				}
				else
				{
					System.out.println("Please select from the following products which are avaiable:" + "\n");
					for (int j = 0; j < 5; j++)
					{
						if (name[j] != null)
						{
							System.out.println("Select Product " + (j + 1) + ":" + "\n" + "Name: " + name[j] + "\n" + " Description: " + desc[j] + "\n" + " Price: " + price[j] + "\n" + " Quantity on hand: " + qty[j] + "\n" + " Product in the cart: " + cart[j] + "\n" + " Min Order Quantity: " + min[j] + "\n");
						}
					}
					System.out.println("Press 0 to exit purchase menu");
					System.out.println("Please enter selected product:");
					int buy = inputI();
					while (buy != 0 && buy !=1 && buy != 2 && buy != 3 && buy != 4 && buy != 5)
					{
						buy = inputI("Please press 0 to 5");
					}
					while (buy != 0)
					{
						int number = buy - 1;
						if (min[number] == 0)
						{
							System.out.println("Wrong product, please select again:");
						}
						else 
						{
							if (qty[number] >= min[number])
							{
								int q = inputI("Please enter the number of quantity:");
								while (cart[number] + q < min[number] || cart[number] + q > qty[number])
								{
									if (cart[number] == 0)
									{
										
										System.out.println("Please enter a number between " + min[number] + " and " + qty[number]);
									}
									else
									{
										System.out.println("Please enter a number between " + "0" + " and " + (qty[number] - cart[number]));
									}
									q = inputI();
								}
								cart[number] += q;	
								System.out.println("\n" + "Added into cart" + "\n");
							}
							else
							{
								System.out.println("Out of stock, please select other products:");
							}
						}
						type = 0;
						for (int k = 0; k < 5; k++)
						{
							if (cart[k] != 0)
							{
								type++;
							}
						}
						if (type < 3)
						{
							System.out.println("Please select from the following products to continue:" + "\n");
							for (int j = 0; j < 5; j++)
							{
								if (name[j] != null)
								{
									System.out.println("Select Product " + (j + 1) + ":" + "\n" + "Name: " + name[j] + "\n" + " Description: " + desc[j] + "\n" + " Price: " + price[j] + "\n" + " Quantity on hand: " + qty[j] + "\n" + " Product in the cart: " + cart[j] + "\n" + " Min Order Quantity: " + min[j] + "\n");
								}
							}
							System.out.println("Press 0 to exit purchase menu");
							System.out.println("Please enter selected product:");
							buy = inputI();
						}
						else
						{
							System.out.println("Your purchases reach the maximum" + "\n");
							break;
						}
					}
				}
				break;
			case 3:
				if (name[0] == null)
				{
					System.out.println("Please press 1 to register a product first");
				}
				else
				{
					if (type == 0)
					{
						System.out.println("You didn't add anything to your chart" + "\n" + mmm);
					}
					else
					{
						System.out.println("Please select from the following products which have been added to the cart:" + "\n");
						for (int j = 0; j < 5; j++)
						{
							if (cart[j] != 0)
							{
								System.out.println("Select Added Item " + (j + 1) + ":" + "\n" + "Name: " + name[j] + "\n" + " Description: " + desc[j] + "\n" + " Price: " + price[j] + "\n" + " Quantity on hand: " + qty[j] + "\n" + " Product in the cart: " + cart[j] + "\n" + " Min Order Quantity: " + min[j] + "\n");
							}
						}
						System.out.println("Press 0 to exit the remove menu");
						System.out.println("Please enter Item No.:");
						int remove = inputI();
						while (remove != 0)
						{
							int number = remove - 1;
							if (cart[number] == 0)
							{
								System.out.println("You didn't add this item to your chart" + "\n" + "Please enter again:");
								remove = inputI();
							}
							else
							{
								cart[number] = 0;
								type--;
							}
							System.out.println("Please select from the following products which have been added to the cart:" + "\n");
							for (int j = 0; j < 5; j++)
							{
								if (cart[j] != 0)
								{
									System.out.println("Select Added Item " + (j + 1) + ":" + "\n" + "Name: " + name[j] + "\n" + " Description: " + desc[j] + "\n" + " Price: " + price[j] + "\n" + " Quantity on hand: " + qty[j] + "\n" + " Product in the cart: " + cart[j] + "\n" + " Min Order Quantity: " + min[j] + "\n");
								}
							}
							System.out.println("Press 0 to exit the remove menu");
							System.out.println("Please enter Item No.:");
							remove = inputI();
						}
					}
				}
				break;
			case 4:
				if (name[0] == null)
				{
					System.out.println("Please press 1 to register a product first");
				}
				else
				{
					for (int j = 0; j < 5; j++)
					{
						if (name[j] != null && qty[j] >= min[j])
						{
							System.out.println("Available Item " + (j + 1) + ":" + "\n" + "Name: " + name[j] + "\n" + " Description: " + desc[j] + "\n" + " Price: " + price[j] + "\n" + " Quantity on hand: " + qty[j] + "\n" + " Product in the cart: " + cart[j] + "\n" + " Min Order Quantity: " + min[j] + "\n");
						}
					}
					System.out.println("Press 0 to exit view");
					while (inputI() != 0)
					{
						System.out.println("Press 0 to exit view");
					}
				}
				break;
			case 5:
				option5();
				if (name[0] == null)
				{
					System.out.println("Please press 1 to register a product first");
				}
				else
				{
					if (type == 0)
					{
						System.out.println("Your cart is empty");
					}
					else
					{
						sale.generateSaleCode();
						System.out.println("==================================");
						System.out.println("Sale Code:           " + sale.getSaleCode());
						System.out.println("==================================");
						for (int j = 0; j < 5; j++)
						{
							sale.addTotalCost(cart[j] * price[j]);
							System.out.println("Item " + (j + 1) + ":" + "\n" + "Name: " + name[j] + "\n" + " Description: " + desc[j] + "\n" + " Price: " + price[j] + "\n" + " Quantity: " + cart[j] + "\n");
						}
						System.out.println("==================================");
						System.out.println("Total Sale:           " + sale.getTotalCost());
						System.out.println("==================================");
					}
				}
				break;
			case 6:
				option6();
				break;
			default :
				option7();
			}
			System.out.println(mmm);
			x = inputI();
		}
		System.out.println("Thanks for your using, goodbye!");		
	}
	
	public void option1()
	{
		
		
	}
	
	public void option2()
	{
		
	}
	
	public void option3()
	{
		
	}
	
	public void option4()
	{
		
	}
	
	public void option5()
	{
		
	}
	
	public void option6()
	{
		System.out.println("Introduction of the system" + "\n" + "\n" + "Option 1:" + "\n" + " You can press 1 to register a product for sale at beginning " + "\n" + " Your product name must between 3 and 25 characters long " + "\n" + " Your product name cannot be repeated for two or more products (Case Insensitive) " + "\n" + " Product description must be between 1 and 50 characters long " + "\n" + " Product price must be a double value > 0" + "\n" + " Quantity on hand and Minimum order quantity are randomly generated, you cannot set them " + "\n" + " You can at most register 5 products " + "\n" + "\n" + "Option 2:" + "\n" + " You can choose available product and add into cart " + "\n" + " The quantity you enter must be an integer and meet the requirement " + "\n" + " You can purchase a maximum of 3 items only " + "\n" + "\n" + "Option 3:" + "\n" + " You can remove the product in your cart " + "\n" + " The quantity you enter must be an integer " + "\n" + " After removing, the rest must meet the minimum order quantity " + "\n" + "\n" + "Option 4:" + "\n" + " You can view all the currently registered products which are available to be purchased " + "\n" + "\n" + "Option 5:" + "\n" + " You can finalize a sale and checkout from the system " + "\n" + " Only products added to the cart can be finalized for the sale " + "\n");
		System.out.println("Press 0 to exit view");
		while (inputI() != 0)
		{
			System.out.println("Press 0 to exit view");
		}
	}
	
	public void option7()
	{
		System.out.println("Error, please enter again:");
	}
	
	public String input()
	{
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		return input;
	}
	
	public String input(String text)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(text);
		String input = sc.nextLine();
		return input;
	}
	
	public int inputI()
	{
		Scanner sc = new Scanner(System.in);
		while (!(sc.hasNextInt()))
		{
			System.out.println("Please enter an integer:");
			sc = new Scanner(System.in);		
		}
		int input = sc.nextInt();			
		return input;
	}
	
	public int inputI(String text)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(text);
		while (!(sc.hasNextInt()))
		{
			System.out.println("Please enter an integer:");
			sc = new Scanner(System.in);		
		}
		int input = sc.nextInt();			
		return input;
	}
	
	public double inputD()
	{
		Scanner sc = new Scanner(System.in);
		while (!(sc.hasNextDouble()))
		{
			System.out.println("Please enter a number:");
			sc = new Scanner(System.in);		
		}
		double input = sc.nextInt();			
		return input;
	}
	
	public double inputD(String text)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(text);
		while (!(sc.hasNextDouble()))
		{
			System.out.println("Please enter a number:");
			sc = new Scanner(System.in);		
		}
		double input = sc.nextInt();			
		return input;
	}
	
	public ProductList getProductList() 
	{
		return productList;
	}
	
	public void setProductList(ProductList productList)
	{
		this.productList = productList;
	}
	
	public SaleTransaction getTransaction() 
	{
		return transaction;
	}
	
	public void setTransaction(SaleTransaction transaction)
	{
		this.transaction = transaction;
	}

	public OldSale(ProductList productList, SaleTransaction transaction) {
		this.productList = productList;
		this.transaction = transaction;
	}
	
	public OldSale()
	{
		this.productList = new ProductList();
		this.transaction = new SaleTransaction();
	}
}
