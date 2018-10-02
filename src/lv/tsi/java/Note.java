package lv.tsi.java;

public class Note extends Record{
    private String tekst;

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    @Override
    public boolean hasSubstring(String str) {
        return  tekst.contains(str);
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + getId() + '\'' +
                " ,tekst='" + tekst + '\'' +
                '}';
    }
}
