package lv.tsi.java;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
     public final static String DATE_FORMAT ="dd.MM.yyyy"; //constanta
     public final static DateTimeFormatter DATE_FORMATTER
             = DateTimeFormatter.ofPattern(DATE_FORMAT);
     public final static String TIME_FORMAT= "HH:mm";
     public final static DateTimeFormatter TIME_FORMATTER
             = DateTimeFormatter.ofPattern(TIME_FORMAT);
     private static Scanner scan = new Scanner(System.in);

     private static Map<Integer, Record> recordList = new LinkedHashMap<>();

     //static List<Person> people = new ArrayList<>();
      //static List<Record> recordList = new ArrayList<>(); // mozno budet hranitj vsje, v tom cisle i personi

   public static void main(String[] args) {
         // write your code here
         while (true) {
             System.out.println(" Enter command ");
             System.out.println(" createperson(cp), createnote(cn), creminder(cr), cralarm(ca), show, expired, del, list, find, exit :");
             String cmd = scan.next();
             switch (cmd) {
                 case "createperson":
                 case "cp":
                     createperson();
                     break;
                 case "creminder":
                 case "cr":
                     createreminder();
                     break;
                 case "cralarm":
                 case "ca":
                     createalarm();
                     break;
                 case "list":
                     showlist();
                     break;
                 case "del":
                     removeById();//delete();
                     break;
                 case "show":
                     showid();
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
                 case "expired" :
                      expired();     break;
                 case "exit":
                     return;
                 default:
                     System.out.println("It isn't a command");
             }
         }
      }
      private static void expired() {
          for (Record r : recordList.values()) {
              if (r instanceof Expirable) { // uznatj kakoj eto klass
                  Expirable e = (Expirable) r; // prividenie tipa
                  if (e.isExpired()) {
                      System.out.println(r);
                  }
              }
          }
      }
      private static void createperson() {
         Person p = new Person();
         addRecord(p);
         //System.out.printf("Person %s %s, phone %s\n", myname, suname,phon);
      } // create end
      private static void createalarm() {
        var alarm = new Alarm();
        addRecord(alarm);
      }
      private static void cnote() {
         Note p = new Note();
          addRecord(p);
      }
      //
      private static void createreminder() {
         var reminder = new Reminder();
          addRecord(reminder);
      }
      private static void addRecord(Record p) {
        p.askQuestions();
        //p.setName(name); p.setSurname(suname); p.setPhone(phone); p.setemail(mail);
        // recordList.add(p);
        recordList.put(p.getId(),p);
        System.out.println(p);
      }
      // polimorfizm
      private static void find() {
         System.out.println(" Find what :" );
         String mytxt = askstr();
          for (Record r : recordList.values()) {
            // if (r instanceof Person) // uznatj kakoj eto klass
             if (r.hasSubstring(mytxt)) {
                 System.out.println(r);
             }
         }
      }
      private static void showid() {
          System.out.println("Show Id :");
          int id = askInt();
          Record record = recordList.get(id);
          //System.out.println(recordList.get(id));
          System.out.println(record);
      }
      //
      private static void shownote () {
          for (Record p : recordList.values())
          //for  (int i = 0; i < cnt; i++)
          {
              //p = people.get(i);
              System.out.println(p);
          }
      }
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
      //private static String askname() {
      //   String alln="", fname, ffname;
      //   do {
      //           fname = scan.next();
      //           String fn = fname.substring(0, 1);
                 //System.out.println("fname=" + fname);
      //           if (fname.startsWith("\"") ||  fname.endsWith("\"")) {
       //              alln= String.join(" ",alln,fname);
      //               if (fname.endsWith("\"")) {
      //                   return alln;
      //               }
      //           } else {return fname;
      //           }
      //   }
      //   while (true) ;  // beskonecnij ciks
     //}
      private static void removeById() {
          System.out.println("Enter ID to remove:");
          int id = askInt();
          recordList.remove(id);
      }
    private static int askInt() {
        while (true) {
            try {
                return scan.nextInt();
            } catch (InputMismatchException e) {
                scan.next(); // skip wrong input
                System.out.println("It isn't a number");
            }
        }
    }
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
         //System.out.println(" Count of persons = "+cnt );
         for (Record p : recordList.values())
         {
             System.out.println(p);
         }
     }
     public static String askString() {
         var result = new ArrayList<String>();
         var word = scan.next();
         if (word.startsWith("\"")) {
             do {
                 result.add(word);
                 if (word.endsWith("\"")) {
                     String str = String.join(" ", result);
                     return str.substring(1, str.length() - 1);
                 }
                 word = scan.next();
             } while (true);

         } else {
             return word;
         }
     }
     //  Simple phone validation
     private static String askPhone_SIMPLE() {
         while (true) {
             String phone = askString();
             if (phone.length() >= 5) {
                 return phone; // valid
             } else {
                 System.out.println("Phone number is too short (min 5 digits)");
             }
         }
     }
     // More advanced phone validation Ļ(but still should be treated as an example)
     public static String askPhone() {
         while (true) {
             String phone = askString();
             // checking if there any characters expect digits, spaces, pluses and dashes
             if (phone.chars().anyMatch(c -> !Character.isDigit(c) && c != ' ' && c != '+' && c != '-')) {
                 System.out.println("Only digits, spaces, plus and dash are allowed!");
                 continue;
             }
             // checking how many digits in the entered number (excluding spaces and other non-digits)
             if (phone.chars().filter(Character::isDigit).count() < 5) {
                 System.out.println("At least 5 digits in phone number");
                 continue;
             }
             // validation passed
             return phone;
         }
     }
     //
     public static LocalDate askDate() {
         String d = askString();
         LocalDate date = LocalDate.parse(d, DATE_FORMATTER);
         return date;
     }
     public static LocalTime askTime() {
         String d = askString();
         LocalTime time = LocalTime.parse(d, TIME_FORMATTER );
         return time;
     }
     //
     private static void helpinfo() {
         System.out.println(" You cam insert info about person : " );
         System.out.println(" Name Surname Phone (min. length 5 number) email " );
         System.out.println(" Allowed command : create, delete, list, help " );
     }
 }


