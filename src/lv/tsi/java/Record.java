package lv.tsi.java;

public abstract class Record {
    private static int count =0; // obscaja peremennaja na vseh
    private int id;

    public Record() {
        count++;
        id = count;
    }

    public abstract boolean hasSubstring(String str); // otnositsa i k person i k note

    public int getId() {
        return id;
    }
    //public void setId(int id) {
    //    this.id = id;    }

}
