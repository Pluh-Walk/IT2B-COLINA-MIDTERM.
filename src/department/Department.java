package department;

import java.util.Scanner;

public class Department {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String response;

        do {
            System.out.println("1. DEPARTMENTS");
            System.out.println("2. EXIT");
            System.out.print("ENTER ACTION: ");
            
            int action = sc.nextInt();
            
            switch(action) {
                case 1:
                    Departments departments = new Departments();
                    departments.deptExec();                     
                    break;
                case 2:
                   
                    break;
                default:
                    
                    System.out.println("Invalid action. Please try again.");         
            }

            System.out.print("Do you want to continue? (Y/N): ");
            response = sc.next();
        } while(response.equalsIgnoreCase("Y"));

        System.out.println("Kaon Pakag Tae");
        sc.close();  
    }
}