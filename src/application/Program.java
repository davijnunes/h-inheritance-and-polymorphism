package application;

import java.util.Scanner;
import java.util.Locale;
import java.util.List;
import java.util.ArrayList;
import entities.Company;
import entities.Individual;
import entities.TaxPayer;


public class Program {
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<TaxPayer> listOfTaxPayers = new ArrayList<TaxPayer>();
		
		
		System.out.print("Enter the number of tax payers: ");
		int TaxPayers = sc.nextInt();
		
		
		System.out.println();
		
		
		// #1: Creating tax payers during your classification
		
		for(int i = 0; i < TaxPayers; i++) {
			
			System.out.println("Tax payer #" + (i+1) +  " data:");
			
			System.out.print("Individual or company (i/c): ");
			char typePayer = sc.next().charAt(0);
			
			
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			
			System.out.print("Anual Income: " );
			Double anualIncome = sc.nextDouble();
			
			// Person individual
			if(typePayer == 'i') {
				
				System.out.print("Health expenditures: ");
				Double heathExpenditures = sc.nextDouble();
				
				
				listOfTaxPayers.add(new Individual(name,anualIncome, heathExpenditures));
			}
			// legal person
			else {
				System.out.print("Numbers of employee: ");
				Integer numbersOfEmployee = sc.nextInt();
				
				listOfTaxPayers.add(new Company(name,anualIncome,numbersOfEmployee));
			}
			
			System.out.println();
			
		}
		
		System.out.println("TAXES PAID:");
		
		// 2#: Showing taxes payable
		for(TaxPayer taxP: listOfTaxPayers) {
			System.out.println(taxP.getName() + ": $ " + String.format("%.2f", taxP.tax()));
		}
		
		System.out.println();
		
		// 3#: Show total of taxes
		System.out.printf("TOTAL TAXES: $ %.2f\n", totalTaxesPaid(listOfTaxPayers));
		
		
		
		sc.close();
	}
	
	// Calculation of total of taxes
	public static double totalTaxesPaid(List<TaxPayer> list) {
		
		double sumTaxesPaid = 0.0;
		
		for(TaxPayer taxP: list) {
			sumTaxesPaid += taxP.tax();
		}
		
		return sumTaxesPaid;
	}

}
