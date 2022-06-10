package EmailApp;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;

// import javax.lang.model.element.Element;

public class email {
    public Scanner scanner = new Scanner(System.in);
    private String fname;
    private String lname;
    private String dept;
    private String email;
    private String password;

    private int mail_Capacity = 500;
    private String alter_email;

    public email(String fname, String lname)
    {
        this.fname = fname;
        this.lname = lname;
        System.out.println("New Employee: " + this.fname + " " + this.lname);

        // Calling methods
        this.dept = this.set_dept();
        this.password = this.generate_password(8);
        this.email = this.generate_email();
    }

    private String generate_email()
    {
        return this.fname.toLowerCase() + "." + this.lname.toLowerCase() + "@" + this.dept.toLowerCase();
    }

    // Asking for department
    private String set_dept()
    {
        System.out.println("Department code:\n1 for Sale \n2 for Development \n3 for Accounting \n0 for none");
        boolean flag = false;
        do
        {
            System.out.println("Enter Department Code: ");
            int choice = scanner.nextInt();
            switch(choice)
            {
                case 1:
                    return "Sales";
                case 2:
                    return "Development";
                case 3:
                    return "Accounting";
                case 0:
                    return "None";
                default:
                    System.out.println("Invalid choice please choose again. ");
            }
        } while (!flag);
        return null;
    }

    // Generate random password method
    private String generate_password(int length)
    {
        Random random = new Random();
        String capacity_character = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String small_character =    "abcdefghijklmnopqrstuvwxyz";
        String number = "0123456789";
        String symbols = "~!@#$%^&*"; 
        String values = capacity_character + small_character + number + symbols;
        String password = "";

        for (int i = 0; i < length; i++)
        {
            password += values.charAt(random.nextInt(values.length()));
        }
        return password;
    }

    //Change password method
    public void set_password()
    {
        boolean flag = false;
        do
        {
            System.out.println("Do you want to change the password ? (Y/N)");
            char choice = scanner.next().charAt(0);
            if (choice == 'Y' || choice == 'y')
            {
                flag = true;
                System.out.println("Enter current password: ");
                String tmp = scanner.next();
                if (tmp.equals(this.password))
                {
                    System.out.println("Enter new password: ");
                    this.password = scanner.next();
                    System.out.println("Password changed successfully");
                }
                else 
                {
                    System.out.println("Incorrect password");
                }
            }
            else if (choice == 'N' || choice == 'n')
            {
                flag = true;
                System.out.println("Password changed option cancelled !");
            }
            else
            {
                System.out.println("Enter Valid Choice");
            }
        }while(!flag);
    }

    // Set mailbox capacity method
    public void set_mailCap()
    {
        System.out.println("Current capacity = " + this.mail_Capacity + "MB");
        System.out.println("Enter new mailbox capacity: ");
        this.mail_Capacity = scanner.nextInt();
        System.out.println("Mailbox capacity is successfully changed !");
    }

    // Set alternative mail
    public void set_alter_mail()
    {
        System.out.println("Enter new alternate mail: ");
        this.alter_email = scanner.next();
        System.out.println("Alternate mail is set");
    }

    // Display user information method
    public void get_info()
    {
        System.out.println("New: "+this.fname + " " + this.lname);
        System.out.println("Department: " + this.dept);
        System.out.println("Email: " + this.email);
        System.out.println("Password: " + this.password);
        System.out.println("Mail Capacity: " + this.mail_Capacity + " MB");
        System.out.println("Alternate mail: " + this.alter_email);
    }

    // Store in file 
    public void store_file()
    {
        try {
            FileWriter in = new FileWriter("F:\\Study\\Java\\Email Project\\info_email.txt");
            in.write("First name: " + this.fname);
            in.append("\nLast name: " + this.lname);
            in.append("\nEmail: " + this.email);
            in.append("\nPassword: " + this.password);
            in.append("\nCapacity: " + this.mail_Capacity);
            in.append("\nAlternate mail: " + this.alter_email);
            in.close();
            System.out.println("Data Stored..");
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println(e);
        }
    }

    // Reading file method
    public void read_file()
    {
        try {
            FileReader fr1 = new FileReader("F:\\Study\\Java\\Email Project\\info_email.txt");
            int i;
            while((i = fr1.read()) != -1)
            {
                System.out.print((char) i);
            }
            fr1.close();
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println(e);
        }
    }
}