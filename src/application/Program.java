package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args)  {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		List<Reservation> reservations = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.print("Room number: ");
			int room = sc.nextInt();
			System.out.print("Check-in (dd/mm/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Check-out (dd/mm/yyyy): ");
			Date checkOut = sdf.parse(sc.next());
			
			reservations.add(new Reservation(room, checkIn, checkOut));
			System.out.println("Reservation: " + reservations.get(0));
		
			System.out.println();
			System.out.println("Enter data to update reservation: ");
			System.out.print("Check-in (dd/mm/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out (dd/mm/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			reservations.get(0).updateDates(checkIn, checkOut);
			System.out.println("Reservation: " + reservations.get(0));
		}
		catch(InputMismatchException e) {
			System.out.println("Invalid format number!");
		}
		
		catch(ParseException e) {
			System.out.println("Invalid date format!");
		}
		catch(DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Unexpected error!");
		}
		
		sc.close();
		
	}

}
