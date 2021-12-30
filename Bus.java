import java.util.Scanner;
import java.util.Date;

public class Main {

	// Create an array of 12 seats, 6 window and 6 aisle.
	private static int[] seats = new int[12];
    static int se[]={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
	public static void main(String args[]) {
		System.out.println("Welcome to the KLU bus reservation system!");
		System.out.println();
		

		// Lets start by setting all seats equal to 0 (aka Empty)
		for (int i = 0; i < 12; i++) {
			seats[i] = 0;
		}

		// Setup our scanner and default the choice to window.
		Scanner s = new Scanner(System.in);
		int choice = 1;

		// Ask user for a window or an aisle seat and store their coice.
		System.out.print("Please enter 1 for window, 2 for aisle, or 0 to exit: ");
		choice = s.nextInt();


		// While their choice is not the one for exit, execute our booking.
		while (choice != 0) {
			int seatnumber = 0;


			// If they chose a window seat, attempt to book it.
			if (choice == 1) {
				seatnumber = bookWindow();


				// No window seats available, try booking an aisle seat for them instead.
				if (seatnumber == -1) {
					seatnumber = bookAisle();
				
					if (seatnumber != -1) {
						System.out.println("Sorry, we were not able to book a window seat. But do have an aisle seat.");
						printBoardingPass(seatnumber);
					}
				}
				else {
					// Booking a window seat was successful.
					System.out.println("You are in luck, we have a window seat available!");
					printBoardingPass(seatnumber);
				}
			}
			else if (choice == 2) {

				// If they chose booking an isle, check to see if it is available.
				seatnumber = bookAisle();
			
				// If not available, see if we have window seats available.
				if (seatnumber == -1) {
					seatnumber = bookWindow();

					if (seatnumber != -1) {
						System.out.println("Sorry, we were not able to book an aisle seat. But do have a window seat.");
						printBoardingPass(seatnumber);
					}
				}
				else {
					// Booking an aisle seat was successful.
					System.out.println("You are in luck, we have an aisle seat available!");
					printBoardingPass(seatnumber);
				}
			}
			else {
				// Print an error message if they did not choose 1, 2, or 0 for their choice.
				System.out.println("Invalid choice made. Please try again!");
				choice = 0;
			}


			// No window or aisle seats were available. 
			if (seatnumber == -1) {
				System.out.println("We are sorry, there are no window or aisle seats available.");
				System.out.println();
			}


			// Reprompt for a choice
			System.out.print("Please enter 1 for window, 2 for aisle, or 0 to exit: ");
			choice = s.nextInt();
		}

			
	}


	// This function checks for window seats and returns seat number or -1 if full.
	private static int bookWindow() {
		for (int i = 0; i < 6; i++) {
			if (seats[i] == 0) {
				seats[i] = 1;
				return i + 1;
			}
		}
		return -1;
	}


	// This function checks to see if aisle seats were available, -1 if full.
	private static int bookAisle() {
		for (int i = 6; i < 12; i++) {
			if (seats[i] == 0) {
				seats[i] = 1;
				return i + 1;
			}
		}
		return -1;

	}


	// This simply prints out a nice little boarding pass message with their seat number and date of issue.
	private static void printBoardingPass(int seatnumber) {
	    Scanner sc=new Scanner(System.in);
	    String s[]={"30/10/2021","04/11/2021","05/11/2021"};
	    System.out.println("enter your name:");
	    String name=sc.nextLine();
	    System.out.println("enter your mobile number:");
	    int phn=sc.nextInt();
	    System.out.println("enter your gender Male or Female or Other:");
	    String gender=sc.next();
	    System.out.println("enter your location:");
	    String loc=sc.next();
	    System.out.println("enter your destination:");
	    String des=sc.next();
	    System.out.println("Enter date: ");
	    String date=sc.next();
	    
	    //String gender=sc.nextLine();
	    System.out.println("Name:"+name);
	    System.out.println("Phone:"+phn);
	    System.out.println("Gender:"+gender);
	    System.out.print("your journey from "+loc);
	    System.out.println(" to "+des);
	    int f=1;
	    for(String k:s){
	        if(date.equals(k)){
	            System.out.println("Seats are available on "+date);
	            System.out.println("Available seats on "+date);
	            int c=0;
	            for(int i=0;i<5;i++){
        	        for(int j=0;j<4;j++){
        	            System.out.print(se[c]+"  ");
        	            c++;
        	        }
	                System.out.println();
	            }
	            f=0;
	            System.out.println("Enter seat number: ");
	            int see=sc.nextInt();
	            if(se[see-1]==-1){
	                System.out.println("Seat not available \ntry again");
	                f=1;
	            }else{
	                seatnumber=se[see-1];
	                se[see-1]=-1;
	            }
	            break;
	        }
	    }
	    if(f==1){
	        System.out.println("Not available on "+date+" try again");
	    }
	    else{
	    System.out.println("successfully registered");
	    
	    System.out.println();
		Date timenow = new Date();
		System.out.println();
		System.out.println("Date: " + timenow.toString());
		System.out.println("Boarding pass for seat number: " + seatnumber);
		System.out.println("Please be curteous, do not smoke. Enjoy your trip.");
		System.out.println();
	    }
	}
}
