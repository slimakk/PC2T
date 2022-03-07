package PC2T;

public class Student {
    private String menoStudenta;
    private double prumer = 0;
    public Student(String meno)
    {
        this.menoStudenta = meno;
    }

    public void setPrumer(double prumer) {
        this.prumer = prumer;
    }

    public double getPrumer() {
        return prumer;
    }
}
