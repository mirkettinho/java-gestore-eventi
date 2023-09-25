package org.lessons.java.eventi;



import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		boolean isValid = false;
		Concerto concert = null;
		String titleInput = null;
		LocalDate dateInput = null;
		LocalTime timeInput = null;
		BigDecimal priceInput = null;
		int numSeatsInput = 0;
		int numBookedInput = 0;
		
		while(!isValid) {
			
            System.out.println("Do you want to create a new event?(yes/no)");
            String userChoice = sc.nextLine();

            if (userChoice.equalsIgnoreCase("yes")) {
            	
           
                System.out.println("---------");

                while (concert == null) {
                	
                try {
                	///TITLE
                	System.out.print("Title: ");
                    titleInput = sc.nextLine();
                    ///DATE
                    System.out.print("Date: -> (yyyy-mm-dd) ");
                    dateInput = LocalDate.parse(sc.nextLine());
                    ///TIME
                    System.out.println("Time: => (hh:mm:ss)");
                    timeInput = LocalTime.parse(sc.nextLine());
                    ///NUM SEATS
                    System.out.print("Num seats: ");
                    numSeatsInput = Integer.parseInt(sc.nextLine());
                    ///PRICE
                    System.out.println("Price: ");
                    priceInput = new BigDecimal(sc.nextLine());
                    
                    concert = new Concerto(titleInput, dateInput, numSeatsInput, timeInput, priceInput);
                    System.out.println(concert);
                    System.out.println("Num seats: "+concert.getNumSeats());
                    System.out.println("---------");
                    
	                } catch (DateTimeParseException e) {
	                	
	                	System.out.println("Correct format is");
	                	
	                } catch (NumberFormatException e) {
	                	
	                	System.out.println("Number");
	                	
	                } catch (Exception e) {
	                	
	                	System.out.println(e.getMessage());
	                }
                
                }
                
                
                while(!isValid) {
                
                	System.out.println("What would you like to do? ");
                	
                    System.out.println("1.Book one or more seats.");
                    
                    System.out.println("2.Cancel one or more reservations.");
                    
                    System.out.println("3.Exit");
                    String menuChoice = sc.nextLine();
                    
                    switch(menuChoice) {
                    
	                    case "1":
	                        try {
		                        System.out.println("Enter the number of seats you want to book: ");
		                        numBookedInput = Integer.parseInt(sc.nextLine());
		                        concert.book(numBookedInput);
		                        System.out.println("Total number of bookings: "+concert.getNumBooked());
		                        concert.seatsAvailable();
		                        System.out.println("Remaining seats: "+concert.getSeatsAvailable());
		                        
	                        }catch (NumberFormatException e) {
	                        	
	                            System.out.println("Insert a number.");
	                            
	                        }catch (RuntimeException e) {
	                        	
	                            System.out.println(e.getMessage());
	                        }
	                        
	                        break;
	
	                    case "2":
	                        try {
		                        System.out.println("Add number of bookings you want to cancel: ");
		                        numBookedInput = Integer.parseInt(sc.nextLine());
		                        concert.cancel(numBookedInput);
		                        concert.seatsAvailable();
		                        System.out.println("Remaining seats: "+concert.getSeatsAvailable());
		                        
	                        }catch (NumberFormatException e) {
	                        	
	                           System.out.println("Insert a number.");
	                           
	                        }catch (RuntimeException e) {
	                        	
	                            System.out.println(e.getMessage());
	
	                        }
	
	                        break;
	
	                    case "3":
	                    	
	                        isValid = true;
	                        break;
	                    	default:
	                    		
	                        System.out.println("Invalid choice.");
	                        break;
	

                    }
                }

	         }else if(userChoice.equalsIgnoreCase("no")) {
	            	
	             isValid = true;
	                
	         }else {
	
	             System.out.println("Insert yes or no.");
	
	         }
                    	
         }
		
		  System.out.println("End");

	      sc.close();
	        
        }       
}

