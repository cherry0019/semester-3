import java.util.*; 
Build a JavaFX/Swing interface for better user experience. 
Implement seat selection feature (e.g., seat numbers). 
// Base Class: Movie 
abstract class Movie { 
protected String title; 
protected String genre; 
protected int duration; 
protected double basePrice; 
public Movie(String title, String genre, int duration, double basePrice) { 
        this.title = title; 
        this.genre = genre; 
        this.duration = duration; 
        this.basePrice = basePrice; 
    } 
     
    public abstract double calculateTicketPrice(); 
     
    public String getTitle() { 
        return title; 
    } 
} 
 
// Subclasses for Different Movie Genres 
class ActionMovie extends Movie { 
    public ActionMovie(String title, int duration, double basePrice) { 
        super(title, "Action", duration, basePrice); 
    } 
     
    @Override 
    public double calculateTicketPrice() { 
        return basePrice * 1.2; 
    } 
} 
 
class ComedyMovie extends Movie { 
    public ComedyMovie(String title, int duration, double basePrice) { 
        super(title, "Comedy", duration, basePrice); 
    } 
     
    @Override 
    public double calculateTicketPrice() { 
        return basePrice * 1.1; 
    } 
} 
 
// Interface: Bookable 
interface Bookable { 
    void bookTicket(int seats) throws Exception; 
    void cancelTicket(int seats) throws Exception; 
} 
 
// Booking System 
class BookingSystem implements Bookable { 
    private int availableSeats; 
     
    public BookingSystem(int seats) { 
        this.availableSeats = seats; 
    } 
     
    @Override 
    public void bookTicket(int seats) throws Exception { 
        if (seats > availableSeats) { 
            throw new Exception("Insufficient seats available."); 
        } 
        availableSeats -= seats; 
        System.out.println(seats + " ticket(s) booked successfully."); 
    } 
     
    @Override 
    public void cancelTicket(int seats) throws Exception { 
        availableSeats += seats; 
        System.out.println(seats + " ticket(s) canceled successfully."); 
    } 
     
    public int getAvailableSeats() { 
        return availableSeats; 
    } 
} 
 
// Loyalty Program 
class LoyaltyProgram { 
    private int points = 0; 
     
    public void addPoints(int tickets) { 
        points += tickets * 10; 
    } 
     
    public int getPoints() { 
        return points; 
    } 
} 
 
// Payment Gateway 
class PaymentGateway { 
    public void processPayment(double amount) { 
        System.out.println("Payment of $" + amount + " processed successfully."); 
    } 
} 
 
// Main Class 
public class MovieTicketBookingSystem { 
    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in); 
         
        List<Movie> movieList = Arrays.asList( 
            new ActionMovie("Fast & Furious", 120, 10.0), 
            new ComedyMovie("The Hangover", 110, 8.0) 
        ); 
         
        BookingSystem bookingSystem = new BookingSystem(50); 
        LoyaltyProgram loyaltyProgram = new LoyaltyProgram(); 
        PaymentGateway paymentGateway = new PaymentGateway(); 
         
        System.out.println("Available Movies:"); 
        for (int i = 0; i < movieList.size(); i++) { 
            System.out.println((i + 1) + ". " + movieList.get(i).getTitle()); 
        } 
         
        System.out.print("Select a movie (enter number): "); 
        int movieChoice = scanner.nextInt(); 
         
        if (movieChoice < 1 || movieChoice > movieList.size()) { 
            System.out.println("Invalid selection!"); 
            return; 
        } 
         
        Movie selectedMovie = movieList.get(movieChoice - 1); 
         
        System.out.print("Enter number of tickets to book: "); 
        int ticketsToBook = scanner.nextInt(); 
         
        try { 
            bookingSystem.bookTicket(ticketsToBook); 
            loyaltyProgram.addPoints(ticketsToBook); 
            paymentGateway.processPayment(ticketsToBook * selectedMovie.calculateTicketPrice()); 
             
            System.out.println("Loyalty Points Earned: " + loyaltyProgram.getPoints()); 
            System.out.print("Do you want to cancel any tickets? (yes/no): "); 
            scanner.nextLine();  
            String cancelResponse = scanner.nextLine(); 
             
            if (cancelResponse.equalsIgnoreCase("yes")) { 
                System.out.print("Enter number of tickets to cancel: "); 
                int ticketsToCancel = scanner.nextInt(); 
                bookingSystem.cancelTicket(ticketsToCancel); 
            } 
             
            System.out.println("Remaining Seats: " + bookingSystem.getAvailableSeats()); 
        } catch (Exception e) { 
            System.out.println("Error: " + e.getMessage()); 
        } finally { 
            scanner.close(); 
        } 
    } 
}
