package lv.tsi.java;

public class Person {
    private static int count =0; // obscaja peremennaja na vseh
    private int id;
    private String name;
    private String surname;
    private String phone;
    private String email;

    public Person() {
        count++;
        id = count;
    }

    public int getId() {
        return id;
    }
    //public void setId(int id) {
    //    this.id = id;    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }
    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
