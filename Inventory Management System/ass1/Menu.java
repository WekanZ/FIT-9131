package ass1;

import java.util.Scanner;
import java.util.Random;
import java.lang.Object;
public class Menu 
{
	public static void main(String[] args) 
	{
		String welcome = "=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=" + "\n" + "Welcome to the Sample Inventory Management System" + "\n" + "=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=" + "\n"  ;
		String mmm = "\n" + "Please Select from the following options" + "\n" + "Press 1 to Register a Product for Sale" + "\n" + "Press 2 to Buy a Product to the Cart" + "\n" + "Press 3 to Remove a Product from the Cart" + "\n" + "Press 4 to View all Aviable Products" + "\n" + "Press 5 to Check out" + "\n" + "Press 6 to Get Help" + "\n" + "press 7 to Exit" + "\n" + "Please Enter your Choice:";
		System.out.println(welcome + mmm);
		Scanner input = new Scanner(System.in);
		int x = input.nextInt();
		Random ran = new Random();
		int index = 0;
		String[] name = new String[5];
		String[] description = new String[5];
		double[] price = new double[5];
		int[] cart = new int[5];
		int[] stock = new int[5];
		int[] min = new int[5];
		int[] quan = new int[5];
		int type = 0;
		while (x != 7)
		{
			switch (x)
			{
			case 1:
				if (index == 5)
				{
					System.out.println("The system only allows a maximum of FIVE products which can be registered" + "\n" + "Please choose other option");
				}
				while (index < 5)
				{
					if (name[index] == null)
					{
						System.out.println("Please enter your product name");
						name[index] = input.next();
						while (name[index].trim().length() < 3 || name[index].trim().length() > 25)
						{
							System.out.println("Product name must be between 3 and 25 characters long" + "\n" + "Please enter again:");
							name[index] = input.next();
						}
						for (int k = 0; k < index; k++)
						{
							if (name[index].equalsIgnoreCase(name[k]))
							{
								System.out.println("You can not use the same name, please enter a new name:");
								name[index] = input.next();
								k = -1;
							}
						}
						System.out.println("Please enter your product description:");
						description[index] = input.next();
						while (description[index].length() > 50)
						{
							System.out.println("Your description must be between 1 and 50 characters long, please enter again:");
							description[index] = input.next();
						}
						System.out.println("Please enter your product price:");
						price[index] = input.nextDouble();
						while (price[index] <= 0)
						{
							System.out.println("Your price must above 0, please enter again:");
							price[index] = input.nextDouble();
						}
						stock[index] = ran.nextInt(10);
						quan[index] = stock[index];
						min[index] = 1 + ran.nextInt(4);
						System.out.println("\n" + "Product" + (index + 1) + "\n" + " Name: " + name[index] + "\n" + " Description: " + description[index] + "\n" + " Price: " + price[index] + "\n" + " Quantity: " + quan[index] + "\n" + " Min Order Quantity: " + min[index] + "\n");
						System.out.println(mmm);
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
					if (type == 3)
					{
						System.out.println("You can purchase a maximum of THREE items only");
					}
					else
					{
						System.out.println("Please select from the following products which are avaiable:" + "\n");
						for (int j = 0; j < 5; j++)
						{
							if (name[j] != null)
							{
								System.out.println("Select Product " + (j + 1) + ":" + "\n" + "Name: " + name[j] + "\n" + " Description: " + description[j] + "\n" + " Quantity: " + quan[j] + "\n" + " Product in the cart: " + cart[j] + "\n" + " Price: " + price[j] + "\n" + " Min Order Quantity: " + min[j] + "\n");
							}
						}
						System.out.println("Press 0 to exit purchase menu");
						System.out.println("Please enter selected product:");
						int buy = input.nextInt();
						while (buy != 0)
						{
							switch (buy)
							{
							case 1:
								if (min[0] == 0)
								{
									System.out.println("Wrong product, please select again:");
								}
								else 
								{
									if (stock[0] + cart[0] >= min[0]) 
									{
										System.out.println("Please enter the number of quantity:");
										int q = input.nextInt();
										while (cart[0] + q < min[0] || q > stock[0])
										{
											if (cart[0] == 0)
											{
												
												System.out.println("Please enter a number between " + min[0] + " and " + (quan[0] - cart[0]));
											}
											else
											{
												System.out.println("Please enter a number between " + "0" + " and " + (quan[0] - cart[0]));
											}
											q = input.nextInt();
										}
										cart[0] += q;
										stock[0] -= q;	
										System.out.println("\n" + "Added into cart" + "\n");
									}
									else
									{
										System.out.println("Out of stock, please select other products:");
									}
								}
								break;
							case 2:
								if (min[1] == 0)
								{
									System.out.println("Wrong product, please select again:");
								}
								else
								{
									if (stock[1] + cart[1] >= min[1]) 
									{
										System.out.println("Please enter the number of quantity:");
										int q = input.nextInt();
										while (cart[1] + q < min[1] || q > stock[1])
										{
											if (cart[1] == 0)
											{
												
												System.out.println("Please enter a number between " + min[1] + " and " + (quan[1] - cart[1]));
											}
											else
											{
												System.out.println("Please enter a number between " + "0" + " and " + (quan[1] - cart[1]));
											}
											q = input.nextInt();
										}
										cart[1] += q;
										stock[1] -= q;
										System.out.println("\n" + "Added into cart" + "\n");
									}
									else
									{
										System.out.println("Out of stock, please select other products:");
									}
								}
								break;
							case 3:
								if (min[2] == 0)
								{
									System.out.println("Wrong product, please select again:");
								}
								else
								{
									if (stock[2] + cart[2] >= min[2]) 
									{
										System.out.println("Please enter the number of quantity:");
										int q = input.nextInt();
										while (cart[2] + q < min[2] || q > stock[2])
										{
											if (cart[2] == 0)
											{
												
												System.out.println("Please enter a number between " + min[2] + " and " + (quan[2] - cart[2]));
											}
											else
											{
												System.out.println("Please enter a number between " + "0" + " and " + (quan[2] - cart[2]));
											}
											q = input.nextInt();
										}
										cart[2] += q;
										stock[2] -= q;	
										System.out.println("\n" + "Added into cart" + "\n");
									}
									else
									{
										System.out.println("Out of stock, please select other products:");
									}
								}
								break;
							case 4:
								if (min[3] == 0)
								{
									System.out.println("Wrong product, please select again:");
								}
								else
								{								
									if (stock[3] + cart[3] >= min[3]) 
									{
										System.out.println("Please enter the number of quantity:");
										int q = input.nextInt();
										while (cart[3] + q < min[3] || q > stock[3])
										{
											if (cart[3] == 0)
											{
												
												System.out.println("Please enter a number between " + min[3] + " and " + (quan[3] - cart[3]));
											}
											else
											{
												System.out.println("Please enter a number between " + "0" + " and " + (quan[3] - cart[3]));
											}											
											q = input.nextInt();
										}
										cart[3] += q;
										stock[3] -= q;	
										System.out.println("\n" + "Added into cart" + "\n");
									}
									else
									{
										System.out.println("Out of stock, please select other products:");
									}
								}
								break;
							case 5:
								if (min[4] == 0)
								{
									System.out.println("Wrong product, please select again:");
								}
								else
								{								
									if (stock[4] + cart[4] >= min[4]) 
									{
										System.out.println("Please enter the number of quantity:");
										int q = input.nextInt();
										while (cart[4] + q < min[4] || q > stock[4])
										{
											if (cart[4] == 0)
											{
												
												System.out.println("Please enter a number between " + min[4] + " and " + (quan[4] - cart[4]));
											}
											else
											{
												System.out.println("Please enter a number between " + "0" + " and " + (quan[4] - cart[4]));
											}
											q = input.nextInt();
										}
										cart[4] += q;
										stock[4] -= q;	
										System.out.println("\n" + "Added into cart" + "\n");
									}
									else
									{
										System.out.println("Out of stock, please select other products:");
									}
								}
								break;
							default:
								System.out.println("Error, please enter again");
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
										System.out.println("Select Product " + (j + 1) + ":" + "\n" + "Name: " + name[j] + "\n" + " Description: " + description[j] + "\n" + " Quantity: " + quan[j] + "\n" + " Product in the cart: " + cart[j] + "\n" + " Price: " + price[j] + "\n" + " Min Order Quantity: " + min[j] + "\n");
									}
								}
								System.out.println("Press 0 to exit purchase menu");
								System.out.println("Please enter selected product:");
								buy = input.nextInt();
							}
							else
							{
								System.out.println("Your purchases reach the maximum" + "\n");
								break;
							}
						}
					}
					System.out.println(mmm);
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
								System.out.println("Select Added Item " + (j + 1) + ":" + "\n" + "Name: " + name[j] + "\n" + " Description: " + description[j] + "\n" + " Quantity: " + quan[j] + "\n" + " Product in the cart: " + cart[j] + "\n" + " Price: " + price[j] + "\n" + " Min Order Quantity: " + min[j] + "\n");
							}
						}
						System.out.println("Press 0 to exit the remove menu");
						System.out.println("Please enter Added Item:");
						int remove = input.nextInt();
						while (remove != 0)
						{
							switch (remove)
							{
							case 1:
								if (cart[0] == 0)
								{
									System.out.println("You didn't add this item to your chart" + "\n" + "Please enter again:");
									remove = input.nextInt();
								}
								else
								{
									System.out.println("Please enter the quantity you want to remove:");
									int q = input.nextInt();
									if (cart[0] - q >= min[0])
									{
										cart[0] -= q;
										stock[0] += q;
										System.out.println("Remove " + q + " from the cart");
									}
									else
									{
										if (cart[0] - q == 0)
										{
											cart[0] -= q;
											stock[0] += q;
											System.out.println("Remove " + q + " from the cart");
											type--;
										}
										else
										{
											if (cart[0] - q < 0)
											{
												System.out.println("You dont't have enough product 1 to remove" + "\n");
											}
											else
											{
												System.out.println("You have to meet the Minimum Order Quantity" + "\n");																							
											}										
										}
									}
								}
								break;
							case 2:
								if (cart[1] == 0)
								{
									System.out.println("You didn't add this item to your chart" + "\n" + "Please enter again:");
									remove = input.nextInt();
								}
								else
								{
									System.out.println("Please enter the quantity you want to remove:");
									int q = input.nextInt();
									if (cart[1] - q >= min[1])
									{
										cart[1] -= q;
										stock[1] += q;
										System.out.println("Remove " + q + " from the cart");
									}
									else
									{
										if (cart[1] - q == 0)
										{
											cart[1] -= q;
											stock[1] += q;
											System.out.println("Remove " + q + " from the cart");
											type--;
										}
										else
										{
											if (cart[1] - q < 0)
											{
												System.out.println("You dont't have enough product 2 to remove" + "\n");
											}
											else
											{
												System.out.println("You have to meet the Minimum Order Quantity" + "\n");																							
											}											
										}
									}
								}
								break;
							case 3:
								if (cart[2] == 0)
								{
									System.out.println("You didn't add this item to your chart" + "\n" + "Please enter again:");
									remove = input.nextInt();
								}
								else
								{
									System.out.println("Please enter the quantity you want to remove:");
									int q = input.nextInt();
									if (cart[2] - q >= min[2])
									{
										cart[2] -= q;
										stock[2] += q;
										System.out.println("Remove " + q + " from the cart");
									}
									else
									{
										if (cart[2] - q == 0)
										{
											cart[2] -= q;
											stock[2] += q;
											System.out.println("Remove " + q + " from the cart");
											type--;
										}
										else
										{
											if (cart[2] - q < 0)
											{
												System.out.println("You dont't have enough product 3 to remove" + "\n");
											}
											else
											{
												System.out.println("You have to meet the Minimum Order Quantity" + "\n");																							
											}											
										}
									}
								}
								break;
							case 4:
								if (cart[3] == 0)
								{
									System.out.println("You didn't add this item to your chart" + "\n" + "Please enter again:");
									remove = input.nextInt();
								}
								else
								{
									System.out.println("Please enter the quantity you want to remove:");
									int q = input.nextInt();
									if (cart[3] - q >= min[0])
									{
										cart[3] -= q;
										stock[3] += q;
										System.out.println("Remove " + q + " from the cart");
									}
									else
									{
										if (cart[3] - q == 0)
										{
											cart[3] -= q;
											stock[3] += q;
											System.out.println("Remove " + q + " from the cart");
											type--;
										}
										else
										{
											if (cart[3] - q < 0)
											{
												System.out.println("You dont't have enough product 4 to remove" + "\n");
											}
											else
											{
												System.out.println("You have to meet the Minimum Order Quantity" + "\n");																							
											}											
										}
									}
								}
								break;
							case 5:
								if (cart[4] == 0)
								{
									System.out.println("You didn't add this item to your chart" + "\n" + "Please enter again:");
									remove = input.nextInt();
								}
								else
								{
									System.out.println("Please enter the quantity you want to remove:");
									int q = input.nextInt();
									if (cart[4] - q >= min[4])
									{
										cart[4] -= q;
										stock[4] += q;
										System.out.println("Remove " + q + " from the cart");
									}
									else
									{
										if (cart[4] - q == 0)
										{
											cart[4] -= q;
											stock[4] += q;
											System.out.println("Remove " + q + " from the cart");
											type--;
										}
										else
										{
											if (cart[4] - q < 0)
											{
												System.out.println("You dont't have enough product 5 to remove" + "\n");
											}
											else
											{
												System.out.println("You have to meet the Minimum Order Quantity" + "\n");																							
											}
										}
									}
								}
								break;
							}
							System.out.println("Please select from the following products which have been added to the cart:" + "\n");
							for (int j = 0; j < 5; j++)
							{
								if (cart[j] != 0)
								{
									System.out.println("Select Added Item " + (j + 1) + ":" + "\n" + "Name: " + name[j] + "\n" + " Description: " + description[j] + "\n" + " Quantity: " + quan[j] + "\n" + " Product in the cart: " + cart[j] + "\n" + " Price: " + price[j] + "\n" + " Min Order Quantity: " + min[j] + "\n");
								}
							}
							System.out.println("Press 0 to exit the remove menu");
							System.out.println("Please enter Added Item:");
							remove = input.nextInt();
						}
						System.out.println(mmm);
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
						if (name[j] != null && quan[j] >= min[j])
						{
							System.out.println("Available Item " + (j + 1) + ":" + "\n" + "Name: " + name[j] + "\n" + " Description: " + description[j] + "\n" + " Quantity: " + quan[j] + "\n" + " Product in the cart: " + cart[j] + "\n" + " Min Order Quantity: " + min[j] + "\n" + " Price: " + price[j] + "\n");
						}
					}
					System.out.println("Press 0 to exit view");
					while (input.nextInt() != 0)
					{
						System.out.println("Press 0 to exit view");
					}
					System.out.println(mmm);
				}
				break;
			case 5:
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
						double total = 0.0;
						for (int j = 0; j < 5; j++)
						{
							total += cart[j] * price[j];
							cart[j] = 0;
							quan[j] = stock[j];
						}
						System.out.println("Total Sale: " + total);
					}
				}
				break;
			case 6:
				System.out.println("Introduction of the system" + "\n" + "\n" + "Option 1:" + "\n" + " You can press 1 to register a product for sale at beginning " + "\n" + " Your product name must between 3 and 25 characters long " + "\n" + " Your product name cannot be repeated for two or more products (Case Insensitive) " + "\n" + " Product description must be between 1 and 50 characters long " + "\n" + " Product price must be a double value > 0" + "\n" + " Quantity on hand and Minimum order quantity are randomly generated, you cannot set them " + "\n" + " You can at most register 5 products " + "\n" + "\n" + "Option 2:" + "\n" + " You can choose available product and add into cart " + "\n" + " The quantity you enter must be an integer and meet the requirement " + "\n" + " You can purchase a maximum of 3 items only " + "\n" + "\n" + "Option 3:" + "\n" + " You can remove the product in your cart " + "\n" + " The quantity you enter must be an integer " + "\n" + " After removing, the rest must meet the minimum order quantity " + "\n" + "\n" + "Option 4:" + "\n" + " You can view all the currently registered products which are available to be purchased " + "\n" + "\n" + "Option 5:" + "\n" + " You can finalize a sale and checkout from the system " + "\n" + " Only products added to the cart can be finalized for the sale " + "\n");
				System.out.println("Press 0 to exit view");
				while (input.nextInt() != 0)
				{
					System.out.println("Press 0 to exit view");
				}
				System.out.println(mmm);
				break;
			default:
				System.out.println("Error, please enter again:");
			}
			x = input.nextInt();
		}
		System.out.println("Thanks for your using, goodbye!");
	}
}