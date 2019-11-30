package ass1;
/**
 * @author  Weikan Zhou
 * @version 3.7
 */
import java.util.Scanner;
public class Sale 
{
	private ProductList productList;
	private SaleTransaction transaction;

	public Sale()
	{
		this.productList = new ProductList();
		this.transaction = new SaleTransaction();
	}

	public Sale(ProductList productList, 
				SaleTransaction transaction) 
	{
		this.productList = productList;
		this.transaction = transaction;
	}

	public int findPosition(int number)
	{
		int position = 3;
		for (int index = 0; index < 3; index++)
		{
			if (transaction.getItems()[index] != null &&
					productList.getListOfProducts()[number].getName().equals(transaction.getItems()[index].getName()))
			{
				position = index;
				break;
			}
		}
		if (position == 3)
		{
			for (int index = 0; index < 3; index++)
			{
				if (transaction.getItems()[index] == null)
				{
					transaction.setItems(transaction.newItem(), index);
					transaction.getItems()[index].setName(productList.getListOfProducts()[number].getName());
					transaction.getItems()[index].setDesc(productList.getListOfProducts()[number].getDesc());
					transaction.getItems()[index].setPrice(productList.getListOfProducts()[number].getPrice());
					transaction.getItems()[index].setQtyOnHand(0);
					transaction.getItems()[index].setMinOrderQty(productList.getListOfProducts()[number].getMinOrderQty());
					position = index;
					break;
				}
			}
		}
		return position;
	}

	public ProductList getProductList() 
	{
		return productList;
	}

	public SaleTransaction getTransaction() 
	{
		return transaction;
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

	public double inputDouble()
	{
		Scanner sc = new Scanner(System.in);
		while (!(sc.hasNextDouble()))
		{
			System.out.println("Please enter a number:");
			sc = new Scanner(System.in);		
		}
		double input = sc.nextDouble();			
		return input;
	}
	
	public double inputDouble(String text)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(text);
		while (!(sc.hasNextDouble()))
		{
			System.out.println("Please enter a number:");
			sc = new Scanner(System.in);		
		}
		double input = sc.nextDouble();			
		return input;
	}
	
	public int inputInt()
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
	
	public int inputInt(String text)
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
	
	public void openMenu()
	{
		System.out.println('\u000C');
		welcome();
		optionList();
		int x = inputInt();
		while (x != 7)
		{
			switch (x)
			{
			case 1:
				option1(); break;
			case 2:
				option2(); break;
			case 3:
				option3(); break;
			case 4:
				option4(); break;
			case 5:
				option5(); break;
			case 6:
				option6(); break;
			default :
				option7(); break;
			}
			optionList();
			x = inputInt();
		}
		productList = new ProductList();
		transaction = new SaleTransaction();
		System.out.println("Thanks for your using, goodbye!");		
	}
	
	public void option1()
	{
		RandomNumberGenerator ran = new RandomNumberGenerator();
		if (productList.getListOfProducts()[4] != null)
		{
			System.out.println('\u000C');
			System.out.println("The system only allows a maximum of FIVE products which can be registered");
			System.out.println("Please choose other option");
		}
		for (int index = 0; index < 5; index++)
		{
			if (productList.getListOfProducts()[index] == null)
			{
				productList.getListOfProducts()[index] = productList.newProduct();
				productList.getListOfProducts()[index].setName(input("Please enter your product name:"));
				for (int position = 0; position < index; position++)
				{
					if (productList.getListOfProducts()[index].getName().equalsIgnoreCase(productList.getListOfProducts()[position].getName()))
					{
						productList.getListOfProducts()[index].setName(input("You can not use the same name, please enter a new name:"));
						position = -1;
					}
				}
				productList.getListOfProducts()[index].setDesc(input("Please enter your product description:"));
				productList.getListOfProducts()[index].setPrice(inputDouble("Please enter your product price:"));
				productList.getListOfProducts()[index].setQtyOnHand(ran.randomNum(0,10));
				productList.getListOfProducts()[index].setMinOrderQty(ran.randomNum(1,5));
				System.out.println('\u000C');
				productList.displayProductList();
				break;
			}
		}
	}
	
	public void option2()
	{
		if (productList.getListOfProducts()[0] == null)
		{
			System.out.println('\u000C');
			System.out.println("Please press 1 to register a product first");
		}
		else
		{
			System.out.println('\u000C');
			System.out.println("Please select from the following products which are avaiable:" + "\n");
			productList.displayProductList();
			System.out.println("Press 0 to exit purchase menu");
			System.out.println("Please enter selected product:");
			int buy = inputInt();
			while ( buy != 0 && 
					buy != 1 && 
					buy != 2 && 
					buy != 3 && 
					buy != 4 && 
					buy != 5 )
				buy = inputInt("Please press a correct number");
			int type = type();
			while (buy != 0)
			{
				int number = buy - 1;
				if (productList.getListOfProducts()[number] == null)
				{
					System.out.println('\u000C');
					System.out.println("Wrong product, please select again:");
				}
				else 
				{
					if (type == 3)
					{
						int position = 3;
						for (int index = 0; index < 3; index++)
						{
							if (transaction.getItems()[index] != null &&
								productList.getListOfProducts()[number].getName().equals(transaction.getItems()[index].getName()))
							{
								position = index;
								break;
							}
						}
						if (position ==3)
						{
							System.out.println('\u000C');
							System.out.println("You can purchase a maximum of THREE items only");
							type = type();
							break;
						}
					}
					if (productList.getListOfProducts()[number].getQtyOnHand() >= productList.getListOfProducts()[number].getMinOrderQty())
					{
						int position = findPosition(number);
						int quantity = inputInt("Please enter the number of quantity:");
						while (transaction.getItems()[position].getQtyOnHand() + quantity < productList.getListOfProducts()[number].getMinOrderQty() || 
							   transaction.getItems()[position].getQtyOnHand() + quantity > productList.getListOfProducts()[number].getQtyOnHand())
						{
							if (transaction.getItems()[position].getQtyOnHand() == 0)
								System.out.println("Please enter a number between " + transaction.getItems()[position].getMinOrderQty() + " and " + productList.getListOfProducts()[number].getQtyOnHand());
							else
							{
								if (transaction.getItems()[position].getQtyOnHand() == productList.getListOfProducts()[number].getQtyOnHand())
								{
									System.out.println('\u000C');
									System.out.println("Out of stock, please select other products:");
									quantity = 0;
									break;
								}
								else
									System.out.println("Please enter a number between 1 and " + (productList.getListOfProducts()[number].getQtyOnHand() - transaction.getItems()[position].getQtyOnHand()));
							}
							quantity = inputInt();
						}
						if (quantity > 0)
						{
							transaction.getItems()[position].addQtyOnHand(quantity);
							System.out.println('\u000C');
							System.out.println("\n" + "Added into cart" + "\n");
						}
					}
					else
					{
						System.out.println('\u000C');
						System.out.println("Out of stock, please select other products:");
					}
				}
				System.out.println("Please select from the following products to continue:" + "\n");
				productList.displayProductList();
				System.out.println("Press 0 to exit purchase menu");
				System.out.println("Please enter selected product:");
				type = type();
				buy = inputInt();
			}
			if (type < 3)
				System.out.println('\u000C');
		}
	}
	
	public void option3()
	{
		if (productList.getListOfProducts()[0] == null)
		{
			System.out.println('\u000C');
			System.out.println("Please press 1 to register a product first");
		}
		else
		{
			int type = type();
			if (type == 0)
			{
				System.out.println('\u000C');
				System.out.println("You didn't add anything to your chart");
			}
			else
			{
				System.out.println('\u000C');
				System.out.println("Please select from the following products which have been added to the cart:" + "\n");
				transaction.displayItems();
				System.out.println("Press 0 to exit the remove menu");
				System.out.println("Please enter Item No.:");
				int remove = inputInt();
				while (remove != 0)
				{
					int number = remove - 1;
					if (remove > type ||
						remove < 1)
					{
						System.out.println("Wrong number!" + "\n" + "Please enter again:");
						remove = inputInt();
					}
					else
					{
						transaction.getItems()[number] = null;
						type--;
						System.out.println('\u000C');
						System.out.println("Remove successfully");
					}
					System.out.println("Please select from the following products which have been added to the cart:" + "\n");
					transaction.displayItems();
					System.out.println("Press 0 to exit the remove menu");
					System.out.println("Please enter Item No.:");
					remove = inputInt();
				}
				System.out.println('\u000C');
			}
		}
	}
	
	public void option4()
	{
		if (productList.getListOfProducts()[0] == null)
		{
			System.out.println('\u000C');
			System.out.println("Please press 1 to register a product first");
		}
		else
		{
			System.out.println('\u000C');
			productList.displayProductList();
			System.out.println("Press 0 to exit view");
			while (inputInt() != 0)
				System.out.println("Press 0 to exit view");
			System.out.println('\u000C');
		}
	}
	
	public void option5()
	{
		if (productList.getListOfProducts()[0] == null)
		{
			System.out.println('\u000C');
			System.out.println("Please press 1 to register a product first");
		}
		else
		{
			int type = type();
			if (type == 0)
			{
				System.out.println('\u000C');
				System.out.println("Your cart is empty");
			}
			else
			{
				transaction.generateSaleCode();
				for (int index = 0; index < type; index++)
				{
					transaction.addTotalCost(transaction.getItems()[index].getQtyOnHand() * transaction.getItems()[index].getPrice());
					for (int position = 0; position < 5; position++)
					{
						if (productList.getListOfProducts()[position] != null &&
								productList.getListOfProducts()[position].getName().equalsIgnoreCase(transaction.getItems()[index].getName()))
							productList.getListOfProducts()[position].renewQtyOnHand(transaction.getItems()[index].getQtyOnHand());
					}
				}
				System.out.println('\u000C');
				System.out.println("==================================");
				System.out.println("Sale Code:           " + transaction.getSaleCode());
				System.out.println("==================================");
				transaction.displayItems();
				System.out.println("==================================");
				System.out.println("Total Sale:           " + transaction.getTotalCost());
				System.out.println("==================================");
				transaction = new SaleTransaction();
			}
		}
	}
	
	public void option6()
	{
		System.out.println('\u000C');
		System.out.println("Introduction of the system");
		System.out.println();
		System.out.println("Option 1:");
		System.out.println(" You can press 1 to register a product for sale at beginning ");
		System.out.println(" Your product name must between 3 and 25 characters long ");
		System.out.println(" Your product name cannot be repeated for two or more products (Case Insensitive) ");
		System.out.println(" Product description must be between 1 and 50 characters long ");
		System.out.println(" Product price must be a double value > 0");
		System.out.println(" Quantity on hand and Minimum order quantity are randomly generated, you cannot set them ");
		System.out.println(" You can at most register 5 products ");
		System.out.println();
		System.out.println("Option 2:");
		System.out.println(" You can choose available product and add into cart ");
		System.out.println(" The quantity you enter must be an integer and meet the requirement ");
		System.out.println(" You can purchase a maximum of 3 items only ");
		System.out.println();
		System.out.println("Option 3:");
		System.out.println(" You can remove the product in your cart ");
		System.out.println(" You will remove all the kind of products at one time ");
		System.out.println();
		System.out.println("Option 4:");
		System.out.println(" You can view all the currently registered products which are available to be purchased ");
		System.out.println();
		System.out.println("Option 5:");
		System.out.println(" You can finalize a sale and checkout from the system ");
		System.out.println(" Only products added to the cart can be finalized for the sale ");
		System.out.println();
		System.out.println("Option 6:");
		System.out.println(" You are in the option 6 now");
		System.out.println();
		System.out.println("Option 7:");
		System.out.println(" Exit");
		System.out.println();
		System.out.println("Press 0 to exit view");
		while (inputInt() != 0)
			System.out.println("Press 0 to exit view");
		System.out.println('\u000C');
	}
	
	public void option7()
	{
		System.out.println('\u000C');
		System.out.println("Error, please enter again:");
	}
	
	public void optionList()
	{
		System.out.println();
		System.out.println("Please Select from the following options:");
		System.out.println("Press 1 to Register a Product for Sale");
		System.out.println("Press 2 to Buy a Product to the Cart");
		System.out.println("Press 3 to Remove a Product from the Cart");
		System.out.println("Press 4 to View all Aviable Products");
		System.out.println("Press 5 to Check out");
		System.out.println("Press 6 to Get Help");
		System.out.println("press 7 to Exit");
		System.out.println("Please Enter your Choice:");
	}

	public void setProductList(ProductList productList)
	{
		this.productList = productList;
	}
	
	public void setTransaction(SaleTransaction transaction)
	{
		this.transaction = transaction;
	}

	public int type()
	{
		int type = 3;
		for (int index = 0; index < 3; index++)
		{
			if (transaction.getItems()[index] == null)
				type--;
		}
		return type;
	}

	public void welcome()
	{
		System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");
		System.out.println("Welcome to the Sample Inventory Management System");
		System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");
	}
}
