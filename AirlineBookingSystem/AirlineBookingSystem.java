
import java.util.*;

class AirlineBookingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String,Integer> flights = new LinkedHashMap<>();
        Map<String,String> bookings = new LinkedHashMap<>();
        flights.put("AI101",2);
        flights.put("AI202",2);
        flights.put("AI303",2);
        int pnr = 101, ch;

        do {
            System.out.println("\n===== AIRLINE BOOKING SYSTEM =====");
            System.out.println("1. Show Flights\n2. Book Flight\n3. Cancel Booking");
            System.out.println("4. Show Bookings\n5. Cheapest Route\n6. Exit");
            System.out.print("\nEnter Choice: ");
            ch = sc.nextInt();

            switch(ch) {
                case 1:
                    System.out.println("\nAvailable Flights:");
                    flights.forEach((f,s) -> System.out.println(f+" - Seats: "+s));
                    break;

                case 2:
                    System.out.print("Enter Flight ID: ");
                    String f = sc.next();
                    System.out.print("Enter Passenger Name: ");
                    String name = sc.next();
                    if(flights.containsKey(f) && flights.get(f)>0) {
                        String id = "PNR"+pnr++;
                        bookings.put(id,name+" - "+f);
                        flights.put(f,flights.get(f)-1);
                        System.out.println("\nBooking Confirmed!\nYour PNR: "+id);
                    } else System.out.println("Flight unavailable!");
                    break;

                case 3:
                    System.out.print("Enter PNR: ");
                    String id = sc.next();
                    if(bookings.containsKey(id)) {
                        String b = bookings.remove(id);
                        String flight = b.substring(b.lastIndexOf(" - ")+3);
                        flights.put(flight,flights.get(flight)+1);
                        System.out.println("Booking Cancelled!");
                    } else System.out.println("Invalid PNR!");
                    break;

                case 4:
                    System.out.println("\nConfirmed Bookings:");
                    bookings.forEach((p,b) -> System.out.println(p+" : "+b));
                    break;

                case 5:
                    System.out.println("\nCheapest Route:");
                    System.out.println("Patna -> Delhi -> Mumbai");
                    System.out.println("Total Fare: Rs 9000");
                    break;

                case 6:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }
        } while(ch != 6);

        sc.close();
    }
}
