import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        Lista lista = new Lista();
        lista.getBejegyzeslista().add(new Bejegyzes("LL. Junior", "Raggamoffin"));
        lista.getBejegyzeslista().add(new Bejegyzes("Busa Pista", "Hello World!"));
        lista.beolvas();

        lista.custom_add();
        lista.randomLikes();
        lista.modosultSzoveg();

        for (int i = 0; i < lista.getBejegyzeslista().size() ; i++) {
            System.out.println(lista.getBejegyzeslista().get(i).getLikeok());
        }


        System.out.println("A legnépszerűbb bejegyzés: " + lista.legnepszerubb());
        System.out.println("Van-e 35-né több lájkot kapó bejegyzés? Válasz: " + lista.vane());
        System.out.println("15-nél kevesebb lájkot kapó bejegyzések száma: " + lista.hanydb());
        lista.newFile();
    }
}