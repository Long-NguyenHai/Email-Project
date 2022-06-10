package EmailApp;

import java.util.Scanner;

public class email_App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        // User info
        System.out.println("Enter first name: ");
        String f_name = scanner.next();
        System.out.println("Enter last name: ");
        String l_name = scanner.next();

        // Create object for email class
        email email1 = new email(f_name, l_name);
        int choice = -1;

        do
        {
            System.out.println("\n********\nEnter your choice\n1. Show info\n2. Change password\n3. Change mailbox capacity\n4. Set alternate email\n5. Store data in file\n6. Display data from file\n7. Exit");            
            choice = scanner.nextInt();
            switch(choice)
            {
                case 1:
                    email1.get_info();
                    break;
                case 2:
                    email1.set_password();
                    break;
                case 3:
                    email1.set_mailCap();
                    break;
                case 4:
                    email1.set_alter_mail();
                    break;
                case 5:
                    email1.store_file();
                    break;
                case 6:
                    email1.read_file();
                    break;
                case 7:
                    System.out.println("Thank you for using this application!");
                    break;
                default:
                    System.out.println("Enter invalid choice!! Enter proper choice again.");
            }
        }while(choice != 7);
        scanner.close();
    }
}
