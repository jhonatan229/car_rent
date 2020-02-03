package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.CarRental;
import model.entities.Vehicle;
import model.service.BrazilTaxService;
import model.service.RentalService;


public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		System.out.print("Enter rental data \nCar model: ");
		String model = sc.nextLine();
		System.out.print("Pickup (dd/mm/yyyy hh:ss) ");
		Date start = sdf.parse(sc.nextLine());
		System.out.print("Return (dd/mm/yyyy hh:ss) ");
		Date finish = sdf.parse(sc.nextLine());
		CarRental rental = new CarRental(start, finish, new Vehicle(model));
		
		System.out.print("Enter price per hour: ");
		double priceHour = sc.nextDouble();
		System.out.print("Enter price per day: ");
		double priceDay = sc.nextDouble();
		
		RentalService service = new RentalService(priceHour, priceDay, new BrazilTaxService());
		service.processInvoice(rental);
		
		System.out.printf("INVOICE: \nBasic Payment: %.2f \nTax: %.2f \nTotal Payment: %.2f",
				rental.getInvoice().getBasicPyment(), rental.getInvoice().getTax(), rental.getInvoice().totalPayment());
		
		sc.close();
	}

}
