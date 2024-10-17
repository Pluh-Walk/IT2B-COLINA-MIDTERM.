package department;

import java.util.Scanner;

public class Departments {

    public Config config; 
    public Scanner sc; 

    public Departments() {
        config = new Config();
        sc = new Scanner(System.in);  
    }

    public void deptExec() {
        String response;

        do {
            System.out.println("1. ADD DEPARTMENT");
            System.out.println("2. VIEW DEPARTMENT");
            System.out.println("3. UPDATE DEPARTMENT");
            System.out.println("4. DELETE DEPARTMENT");
            System.out.println("5. EXIT");
            System.out.print("ENTER ACTION: ");
            
            int action = sc.nextInt();
            sc.nextLine(); 

            switch (action) {
                case 1:
                    addDepartment();
                    break;
                case 2:
                    viewDepartments();
                    break;
                case 3:
                    viewDepartments();
                    updateDepartment();
                    viewDepartments();
                    break;
                case 4:
                    viewDepartments();
                    deleteDepartment();  

                    break;
                
                case 5:
                    
                    break;
                    
                default:
                    System.out.println("Invalid action. Please try again.");
            }

            System.out.print("Do you want to continue? (Y/N): ");
            response = sc.nextLine();
        } while (response.equalsIgnoreCase("Y"));

        System.out.println("Goodbye!");
        sc.close();
    }

    public void addDepartment() {
        System.out.print("Department Name: ");
        String dname = sc.nextLine();
        System.out.print("Department Head: ");
        String dhead = sc.nextLine();
        System.out.print("Department Location: ");
        String dlocation = sc.nextLine();
        System.out.print("Department Phone Number: ");
        String phonen = sc.nextLine();
        System.out.print("Department Email: ");
        String demail = sc.nextLine();
        
        String sql = "INSERT INTO tbl_department (dept_name, dept_head, location, phone_n, d_email) VALUES (?, ?, ?, ?, ?)";
        config.addRecord(sql, dname, dhead, dlocation, phonen, demail); 
    }

    private void viewDepartments() {
        String deptQuery = "SELECT * FROM tbl_department";
        String[] deptHeaders = {"Dept ID", "Department Name", "Department Head", "Location", "Phone Number", "Email"};
        String[] deptColumns = {"d_id", "dept_name", "dept_head", "location", "phone_n", "d_email"};

        config.viewRecords(deptQuery, deptHeaders, deptColumns); 
    }

    private void updateDepartment() {
        System.out.print("Enter Department ID to edit: ");
        int departmentId = sc.nextInt();
        sc.nextLine();  

        System.out.print("Enter New Department Name: ");
        String newDeptname = sc.nextLine();

        System.out.print("Enter New Department Head: ");
        String newDepthead = sc.nextLine();

        System.out.print("Enter New Location: ");
        String newLocation = sc.nextLine();

        System.out.print("Enter New Phone Number: ");
        String newPhonen = sc.nextLine();
        
        System.out.print("Enter New Email: ");
        String newEmail = sc.nextLine();

        String sql = "UPDATE tbl_department SET dept_name = ?, dept_head = ?, location = ?, phone_n = ?, d_email = ? WHERE d_id = ?";
        config.updateRecord(sql, newDeptname, newDepthead, newLocation, newPhonen, newEmail, departmentId);        

        System.out.println("Department updated successfully.");
    }

    private void deleteDepartment() {
        System.out.print("Enter Department ID to delete: ");
        int departmentId = sc.nextInt();
        sc.nextLine();  

        System.out.print("Are you sure you want to delete Department ID " + departmentId + "? (Y/N): ");
        String confirmation = sc.nextLine();

        if (confirmation.equalsIgnoreCase("Y")) {
            String sql = "DELETE FROM tbl_department WHERE d_id = ?";
            config.deleteRecord(sql, departmentId); 
            System.out.println("Department deleted successfully.");
        } else {
            System.out.println("Delete action canceled.");
        }
    }
}