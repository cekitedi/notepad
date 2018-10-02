package lv.tsi.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

 public class Main {

      static Scanner scan = new Scanner(System.in);
      //static List<Person> people = new ArrayList<>();
      static List<Record> recordList = new ArrayList<>(); // mozno budet hranitj vsje, v tom cisle i personi
      public static void main(String[] args) {
         // write your code here
         while (true) {
             System.out.println(" Enter command ");
             System.out.println(" createperson(cp), createnote(cn), del, list, find, exit :");
             String cmd = scan.next();
             switch (cmd) {
                 case "createperson":
                 case "cp":
                     createperson();
                     break;
                 case "list":
                     showlist();
                     break;
                 case "del":
                     delete();
                     break;
                 case "help":
                     helpinfo();
                     break;
                 case "createnote":
                 case "cn":
                     cnote();
                     break;
                 case "nlist":
                     shownote();
                     break;
                 case "find":
                     find();
                     break;
                 case "exit":
                     return;
                 default:
                     System.out.println("It isn't a command");
             }
         }
      }

     private static void find() {
         System.out.println(" Find what :" );
         String mytxt = askstr();
         for (Record r : recordList) {
            // if (r instanceof Person) uznatj kakoj eto klass
             if (r.hasSubstring(mytxt)) {
                 System.out.println(r);
             }
         }
     }

     private static void cnote() {
         String mytxt;
         System.out.println(" Insert note tekst :" );
         mytxt = askstr();
         Note p = new Note();
         p.setTekst(mytxt);
         recordList.add(p);
         //System.out.println(p);
         //System.out.printf("Person %s %s, phone %s\n", myname, suname,phon);
     } // create end

     private static void shownote () {
         for (Record p : recordList)
         //for  (int i = 0; i < cnt; i++)
         {
             //p = people.get(i);
             System.out.println(p);
             //System.out.printf("Person %s %s, phone %s\n", myname, suname,phon);
         }
     }
      private static void createperson() {
         String myname; String suname; String phon; String mail;
         System.out.println(" Insert name :" );
         myname = askstr();
         //myname =askname();//scan.next();
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
         recordList.add(p);
         //System.out.println(p);
         //System.out.printf("Person %s %s, phone %s\n", myname, suname,phon);
      } // create end
      //
      private static String askstr() {
         var result = new ArrayList<String>();
         var word = scan.next();
         if (word.startsWith("\"")) {
                 do {
                     //result.add(word.replace("\"","") );
                     result.add(word);
                     if (word.endsWith("\"")) {
                         String str = String.join(" ", result);
                         //return str;
                         return  str.substring(1,str.length()-1);
                     }
                     word = scan.next();
                 }  while (true) ;

         } else {
                 return word;
                }
      }
      //my variant, only for 2 word
      private static String askname() {
         String alln="", fname, ffname;
         do {
                 fname = scan.next();
                 String fn = fname.substring(0, 1);
                 //System.out.println("fname=" + fname);
                 if (fname.startsWith("\"") ||  fname.endsWith("\"")) {
                     alln= String.join(" ",alln,fname);
                     if (fname.endsWith("\"")) {
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
         //int cnt = people.size();
         Record p = new Person();
         int idnum = scan.nextInt();
         if (idnum < 0 ) {
             System.out.println(" ID number must be >0");
         } else {
          for (int i = 0; i <recordList.size(); i++) { // etot cikl lusce cem vtoroj
             //            for (Person p : people) {
              p = recordList.get(i);
              //System.out.println("p.getId() "+p.getId());
                 if (p.getId() == idnum) {
                     System.out.println("Deleted "+p);
                     recordList.remove(p);
                     break;
                 }
             }
         }
     }
     private static void showlist () {
         //Person p = new Person();
         int cnt = recordList.size();
         System.out.println(" Count of persons = "+cnt );
         for (Record p : recordList)
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


