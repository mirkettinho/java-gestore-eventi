package org.lessons.java.eventi;



import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		boolean isValid = false;
		Evento event = null;
		String titleInput = null;
		LocalDate dateInput = null;
		int numSeatsInput = 0;
		int numBookedInput = 0;
		
		while(!isValid) {
			
            System.out.println("Do you want to create a new event?(yes/no)");
            String userChoice = sc.nextLine();

            if (userChoice.equalsIgnoreCase("yes")) {
            	
           
                System.out.println("---------");

                while (event == null) {
                	
                try {
                	///TITLE
                	System.out.print("Title: ");
                    titleInput = sc.nextLine();
                    ///DATE
                    System.out.print("Date: -> (yyyy-mm-dd) ");
                    dateInput = LocalDate.parse(sc.nextLine());
                    ///NUM SEATS
                    System.out.print("Num seats: ");
                    numSeatsInput = Integer.parseInt(sc.nextLine());
                    
                    event = new Evento(titleInput, dateInput, numSeatsInput);
                    System.out.println(event);
                    System.out.println("Num seats: "+event.getNumSeats());
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
		                        System.out.println("Add number of bookings: ");
		                        numBookedInput = Integer.parseInt(sc.nextLine());
		                        event.book(numBookedInput);
		                        System.out.println("Total number of bookings: "+event.getNumBooked());
		                        event.seatsAvailable();
		                        System.out.println("Remaining seats: "+event.getSeatsAvailable());
		                        
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
		                        event.cancel(numBookedInput);
		                        event.seatsAvailable();
		                        System.out.println("Remaining seats: "+event.getSeatsAvailable());
		                        
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

