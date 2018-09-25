package lv.tsi.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

 public class Main {

     static Scanner scan = new Scanner(System.in);
     static List<Person> people = new ArrayList<>();


     public static void main(String[] args) {
         // write your code here
         while (true) {
             System.out.println(" Enter command :");
             String cmd = scan.next();
             switch (cmd) {
                 case "create":
                     create();
                     break;
                 case "list":
                     showlist();
                     break;
                 case "delete":
                     delete();
                     break;
                 case "exit":
                     return;
                 default:
                     System.out.println("It isn't a command");
             }
         }
     }

     private static void create() {
         String myname; String suname; String phon;
         System.out.println(" Insert name surname phone :" );
         myname = scan.next();
         suname = scan.next();
         phon = scan.next();
         Person p = new Person();
         p.setName(myname);
         p.setSurname(suname);
         p.setPhone(phon);
         people.add(p);
         //System.out.println(p);
         //System.out.printf("Person %s %s, phone %s\n", myname, suname,phon);
     } // create end
     //
     private static void delete() {
        System.out.println(" Delete Id :" );
        int cnt = people.size();
        int idnum = scan.nextInt();
        for  (int i = 1; i < cnt+1; i++) {
            if (idnum == i) {
             people.remove(i);
            }
             //System.out.println(p);
             //System.out.printf("Person %s %s, phone %s\n", myname, suname,phon);
         }
     }

     private static void showlist () {
         //Person p = new Person();
         int cnt = people.size();
         System.out.println(" Count of persons = "+cnt );
         for (Person p : people)
         //for  (int i = 0; i < cnt; i++)
         {
             //p = people.get(i);
             System.out.println(p);
             //System.out.printf("Person %s %s, phone %s\n", myname, suname,phon);
         }

     }

 }


