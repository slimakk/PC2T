package Test;
public class test {

    public static void main(String[] args) {
        Databaze db = new Databaze(5);
        db.setMeno("Miro", 0);
        System.out.println(db.getMeno(0));
    }
}