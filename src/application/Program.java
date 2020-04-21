package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		List<Reservation> reservations = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Room number: ");
		int room = sc.nextInt();
		System.out.print("Check-in (dd/mm/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-out (dd/mm/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		
		if (!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date.");
		}
		else {
			reservations.add(new Reservation(room, checkIn, checkOut));
			System.out.println("Reservation: " + reservations.get(0));
		}
		
		System.out.println();
		System.out.println("Enter data to update reservation: ");
		System.out.print("Check-in (dd/mm/yyyy): ");
		checkIn = sdf.parse(sc.next());
		System.out.print("Check-out (dd/mm/yyyy): ");
		checkOut = sdf.parse(sc.next());
		
		Date now = new Date();
		
		if (checkIn.before(now) || checkOut.before(now)) {
			System.out.println("Error in update reservation: Reservation dates must be future dates.");
		}
		
		else if (!checkOut.after(checkIn)) {
			System.out.println("Error in update reservation: Check-out date must be after check-in date.");
		}
		else {
			reservations.get(0).updateDates(checkIn, checkOut);
			System.out.println("Updated reservation: " + reservations.get(0));
		}
		
		
		
		
		
		sc.close();
		
		

	}

}
