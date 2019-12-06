package com.manthan.hotelBillingApplication.javaProgram;

import java.util.Scanner;

import com.manthan.hotelBillingApplication.BillingImplementation.AddFoodImplementation;
import com.manthan.hotelBillingApplication.BillingImplementation.FoodBillImplementation;
import com.manthan.hotelBillingApplication.BillingImplementation.MenuImplementation;
import com.manthan.hotelBillingApplication.BillingImplementation.ModifyFoodImplementation;
import com.manthan.hotelBillingApplication.BillingImplementation.RemoveFoodImplementation;

public class HotelBill {

	static double total_bill=0;

	public static void main(String[] args) {
		FoodBillImplementation billing=new FoodBillImplementation();
		int choices;
		String sub_choice;
		String update_choice;
		boolean flag=true;
		int item_code;
		

		MenuImplementation menuImplementation=new MenuImplementation();
		Scanner sc=new Scanner(System.in);


		System.out.println("\t\t\t\t Welcome To Hotel ");
		do {

			System.out.println("\n\nPLEASE SELECT THE OPTIONS SHOWN BELOW");
			System.out.println("1. Show all Foods\n2. Take order from customer\n3. Operate on food\n4. total bill of the day\n5. To exit press 0");	
			choices=sc.nextInt();
			switch(choices) {

			case 1:
				menuImplementation.foodMenu();
				break;

			case 2:
				
				int [] item_codes=new int[10];
				int i=0;
				int no_item=1;
				System.out.println("Please enter the item code");
				do{

					no_item=sc.nextInt();
					item_codes[i]=no_item;
					i++;
				}while(no_item!=0);
				i--;
				total_bill=total_bill+billing.foodBill(item_codes);

				break;

			case 3:
				System.out.println("\n\nPLEASE SELECT THE OPTIONS SHOWN BELOW");
				System.out.println("A. Add food item \nB. Remove food Item\nC. Modify Food Item ");
				sub_choice=sc.next();
				switch(sub_choice) {

				case "A":
					AddFoodImplementation addFoodImplementation=new AddFoodImplementation();
					addFoodImplementation.addFood();
					break;

				case "B":
					RemoveFoodImplementation removeFoodImplementation=new RemoveFoodImplementation();
					removeFoodImplementation.removeFood();
					break;

				case "C":

					ModifyFoodImplementation modify=new ModifyFoodImplementation();
					System.out.println("Please enter the Item code you want to modify");
					item_code=sc.nextInt();
					sc.nextLine();
					System.out.println("`````````````````````````````````````````````````");
					System.out.println("What do you want to update (Food/Price), please enter...");
					update_choice=sc.nextLine();
					double price;
					String food;

					if(update_choice.equalsIgnoreCase("price")) 
					{
						System.out.println("Please enter the price");
						price=sc.nextDouble();
						modify.modifyPrice(price, item_code);

					}
					else if(update_choice.equalsIgnoreCase("food"))
					{

						System.out.println("Please enter the food name");
						food=sc.nextLine();
						modify.modifyFoodItem(food, item_code);

					}
					else
						System.out.println("invalid choice for update");
					break;

				default:
					System.out.println("----INVALID CHOICE---");
					break;

				}
				break;

			case 4:
				System.out.println("-----------------------------------------");
				System.out.println("total billing for the day is "+total_bill);
				break;

			case 0:
				System.out.println("\t\t\t ~ ~ ~ ~ ~ Thank you for using ~ ~ ~ ~ ~");
				flag=false;
				break;

			default:	
				System.out.println("----INVALID CHOICE---");
				break;
			}

		}while(flag);

	}//end of main function

}//end of class
