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
                 case "help":
                     helpinfo();
                     break;
                 case "exit":
                     return;
                 default:
                     System.out.println("It isn't a command");
             }
         }
     }

     private static void create() {
         String myname; String suname; String phon; String mail;
         System.out.println(" Insert name :" );
         myname = askname();//scan.next();
         System.out.println(" Insert surname :" );
         suname = scan.next();
         System.out.println(" Insert phone :" );
         do {
           phon = scan.next();
           if (phon.length()<5) {
               System.out.println("Phone length must be >=5");
           } else {
               break;
           }
         } while (true);  // beskonecnij ciks
         System.out.println(" Insert email:" );
         mail = scan.next();
         Person p = new Person();
         p.setName(myname);
         p.setSurname(suname);
         p.setPhone(phon);
         p.setemail(mail);
         people.add(p);
         //System.out.println(p);
         //System.out.printf("Person %s %s, phone %s\n", myname, suname,phon);
     } // create end
     //
     static String askname() {

         String alln, fname, ffname;
         do {
                 fname = scan.next();
                 String fn = fname.substring(0, 1);
                 System.out.println("fname=" + fname);
                 if (fname.startsWith("'") ||  fname.endsWith("'")) {
                     //System.out.println("fn=" + fn);
                     if (fname.startsWith("'")) {
                          ffname = fname;
                          alln= fname;
                     }
                     if (fname.endsWith("'")) {
                            //alln= alln+" "+fname;
                         alln= String.join(" ",fname);
                            return alln;
                     }
                 } else {
                     return fname;
                 }
         }
         while (true) ;  // beskonecnij ciks

     }
     //
     private static void delete() {
         System.out.println(" Delete Id :");
         int cnt = people.size();
         int idnum = scan.nextInt();
         if (idnum < 0 ) {
             System.out.println(" ID number must be >0");
         } else {
             for (Person p : people) {
                 if (p.getId() == idnum) {
                     System.out.println("Deleted "+p);
                     people.remove(p);
                     break;
                 }
             }
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
     private static void helpinfo() {
         System.out.println(" You cam insert info about person : " );
         System.out.println(" Name Surname Phone (min. length 5 number) email " );
         System.out.println(" Allowed command : create, delete, list, help " );
     }
 }


