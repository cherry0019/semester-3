# semester-4 java  overview
Overview of the System
The program simulates a movie ticket booking system. It consists of several components, each performing a specific role:

1. Movie Class
Purpose: This is the base class for all movies. It defines common properties for a movie, such as its title, genre, duration, and base price. It also has a method to calculate the ticket price, which is implemented differently in the subclasses.

Key Concepts:

Title: The name of the movie.

Genre: The type of the movie (e.g., action, comedy).

Duration: The length of the movie in minutes.

Base Price: The base ticket price of the movie.

2. Subclasses for Movie Genres
Purpose: These are the specific types of movies (e.g., Action, Comedy), each of which has its own way to calculate the ticket price.

Action Movies: The ticket price for action movies is higher (20% more) than the base price.

Comedy Movies: The ticket price for comedy movies is slightly higher (10% more) than the base price.

3. Booking System
Purpose: This handles the booking and cancellation of tickets.

Booking Tickets: When a user books tickets, the system checks if enough seats are available. If there are enough seats, the booking is confirmed and the number of available seats decreases.

Canceling Tickets: If the user wants to cancel tickets, the system restores the number of seats.

Seats Available: The system always keeps track of how many seats are available.

4. Loyalty Program
Purpose: This keeps track of points a user earns by booking tickets. For each ticket booked, the user earns a certain number of loyalty points (in this case, 10 points per ticket).

Add Points: When tickets are booked, the system adds loyalty points to the user's account.

Points Balance: The program lets the user know how many loyalty points they've accumulated.

5. Payment Gateway
Purpose: This handles the payment process. After booking tickets, the system calculates the total price for the tickets and processes the payment.

Payment: The system confirms the payment and displays a success message with the amount.

6. The Main Program Flow
The user interacts with the system through the following steps:

Select a Movie: The program first shows a list of available movies. The user selects the movie they want to watch.

Book Tickets: The user is asked how many tickets they want to book. If enough seats are available, the system proceeds with the booking.

Loyalty Points: For every ticket booked, the user earns loyalty points.

Cancel Tickets: The user is asked if they want to cancel any tickets. If so, the system restores the canceled tickets.

Remaining Seats: After booking or canceling tickets, the system displays how many seats remain available.

Payment: The program calculates the price based on the movie's ticket price and processes the payment.

Key Features
Movie Selection: The system allows the user to choose from different movie genres.

Booking: The system ensures that the correct number of tickets are available and updates the seat count when tickets are booked or canceled.

Loyalty Rewards: Users are rewarded with points for booking tickets.

Payment Processing: The program simulates payment by displaying a message when the payment is processed.
