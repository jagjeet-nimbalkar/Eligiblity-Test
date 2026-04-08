package Java;

import java.util.Scanner;

public class text {
    public static class Student {
        int roll;
        String name;
        String email;
        String address;

        public Student(String name, String email) {
            this.name = name;
            this.email = email;
        }

        public Student(int roll, String name, String email) {
            this.roll = roll;
            this.name = name;
            this.email = email;
        }

        public Student(int roll, String name, String email, String address) {
            this.roll = roll;
            this.name = name;
            this.email = email;
            this.address = address;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Rollno");
        int roll = sc.nextInt();
        System.out.print("Name :");
        String name = sc.next();
        System.out.print("Email : ");
        String email = sc.next();
        System.out.print("Address: ");
        String address = sc.next();

        Student s = new Student(name, email);
        Student s1 = new Student(roll, name, email);
        Student s2 = new Student(roll, name, email, address);

        System.out.println("Students created successfully!");
    }
}
