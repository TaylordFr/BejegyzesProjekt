import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
import static java.lang.Integer.parseInt;

public class Lista {
    private ArrayList<Bejegyzes> bejegyzeslista;


    public Lista(){
        this.bejegyzeslista = new ArrayList<Bejegyzes>();
    }

    public ArrayList<Bejegyzes> getBejegyzeslista() {
        return bejegyzeslista;
    }

    public void setBejegyzeslista(ArrayList<Bejegyzes> bejegyzeslista) {
        this.bejegyzeslista = bejegyzeslista;
    }

    public void beolvas(){
        try(BufferedReader br = new BufferedReader(new FileReader("bejegyzesek.csv"))){
            String line;
            while((line = br.readLine()) != null){
                String[] parts = line.split(";");
                bejegyzeslista.add(new Bejegyzes(parts[0], parts[1]));
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public void randomLikes(){
        int timestw = this.bejegyzeslista.size() * 20;

        for (int i = 0; i < timestw; i++) {
            int random = (int)(Math.random()*this.bejegyzeslista.size());
            this.bejegyzeslista.get(random).like();
        }
    }

    public void modosultSzoveg(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Adjon meg egy szöveget: ");
        String szoveg = scanner.nextLine();
        this.bejegyzeslista.get(1).setTartalom(szoveg);
        System.out.println("A szöveg módosult: " + this.bejegyzeslista.get(1).getTartalom());
    }


    public void custom_add(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Adjon meg egy darabszámot: ");
        String darab = scanner.nextLine();
        if(parseInt(darab) < 0){
            throw new IllegalArgumentException("Nem természetes számot adott meg!");
        } else {
            if(parseInt(darab) == 0){
                return;
            } else {
                for (int i = 0; i < parseInt(darab); i++){
                    System.out.println("A bejegyzés szerzője: ");
                    String szerzo = scanner.nextLine();
                    System.out.println("A bejegyzés tartalma: ");
                    String tartalom = scanner.nextLine();
                    bejegyzeslista.add(new Bejegyzes(szerzo, tartalom));
                }
            }
        }
    }

    public Bejegyzes legnepszerubb(){
        Bejegyzes leg = bejegyzeslista.get(0);
        int alap = bejegyzeslista.get(0).getLikeok();
        for(Bejegyzes element: bejegyzeslista){
            if(element.getLikeok() > alap){
                leg = element;
            }
        }

        return leg;
    }

    public boolean vane(){
        boolean harmincot;

        for(Bejegyzes element: bejegyzeslista){
            if(element.getLikeok() > 35){
                harmincot = true;
                break;
            }
        }
        harmincot = false;

        return harmincot;
    }

    public int hanydb(){
        int db = 0;

        for (Bejegyzes element: bejegyzeslista){
            if(element.getLikeok() < 15){
                db++;
            }
        }
        return db;
    }

    public void newFile(){
        FileWriter new_file;
        try{
            new_file = new FileWriter("newlist.txt");
            BufferedWriter new_writer = new BufferedWriter(new_file);
            for(Bejegyzes element: bejegyzeslista){
                new_writer.write(element.getSzerzo() + ";" + element.getTartalom() + ";" + element.getLikeok() + ";" + element.getLetrejott() + ";" + element.getSzerkesztve());
            }

            new_writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
