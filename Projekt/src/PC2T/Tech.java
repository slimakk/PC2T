package PC2T;
public class Tech extends Kombi{

    public Tech(String meno, String priezvisko, int ID, int den, int mesiac, int rok)
    {
        super(meno,priezvisko,ID,den,mesiac,rok);
    }

    public String getTypeOfStudium()
    {
        return "Tech";
    }

    @Override
    public void Abilita() {
        PrestupnyRok();
    }
}