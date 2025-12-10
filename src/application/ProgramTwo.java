package application;

import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ProgramTwo {

    public static void main (String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room number: ");
        int number = sc.nextInt();
        System.out.print("Check-in date (dd/MM/yyyy): ");
        Date checkin = sdf.parse(sc.next());
        System.out.print("Check-out date (dd/MM/yyyy): ");
        Date checkinOut = sdf.parse(sc.next());

        if (!checkinOut.after(checkin)) {
            System.out.println("Erro in reservation: Check-out date must be after check-in date");
        } else {
            Reservation reservation = new Reservation(number, checkin, checkinOut);
            System.out.println("Reservatio: " + reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation: ");

            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkin = sdf.parse(sc.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkinOut = sdf.parse(sc.next());

            Date now = new Date();

            if(checkin.before(now) || checkinOut.before(now)){
                System.out.println("Error in reservarion: Reservation dates for update must be future");
            } else if (!checkinOut.after(checkin)) {
                System.out.println("Erro in reservation: Check-out date must be after check-in date");
            } else {
                reservation.updateDates(checkin, checkinOut);
                System.out.println("Reservatio: " + reservation);
            }

        }

        sc.close();

    }
}
