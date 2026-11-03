import java.net.*;
import java.io.*;
import java.util.*;

public class StudentResult {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("1. Server  2. Client");
        int choice = sc.nextInt();

        if (choice == 1) {
            ServerSocket ss = new ServerSocket(5000);
            System.out.println("Server waiting...");

            Socket s = ss.accept();
            BufferedReader in = new BufferedReader(
                new InputStreamReader(s.getInputStream()));
            PrintWriter out = new PrintWriter(s.getOutputStream(), true);

            String reg = in.readLine();

            if (reg.equals("101")) out.println("A Grade");
            else if (reg.equals("102")) out.println("B Grade");
            else out.println("Result Not Found");

            s.close();
            ss.close();
        } else {
            Socket s = new Socket("localhost", 5000);

            BufferedReader in = new BufferedReader(
                new InputStreamReader(s.getInputStream()));
            PrintWriter out = new PrintWriter(s.getOutputStream(), true);

            System.out.print("Enter Register Number: ");
            String reg = sc.next();

            out.println(reg);
            System.out.println("Result: " + in.readLine());

            s.close();
        }
    }
}