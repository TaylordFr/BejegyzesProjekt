import java.time.LocalDateTime;

public class Bejegyzes {


    private String szerzo;
    private String tartalom;
    private int likeok;
    private LocalDateTime letrejott;
    private LocalDateTime szerkesztve;

    public Bejegyzes(String szerzo, String tartalom){
        this.szerzo = szerzo;
        this.tartalom = tartalom;
        this.likeok = 0;
        this.szerkesztve = LocalDateTime.now();
        this.letrejott = LocalDateTime.now();
    }

    public String getSzerzo() {
        return szerzo;
    }

    public int getLikeok() {
        return likeok;
    }

    public String getTartalom() {
        return tartalom;
    }

    public void setTartalom(String tartalom) {
        this.tartalom = tartalom;
        if(!tartalom.equals("")){
            this.szerkesztve = LocalDateTime.now();
        }
    }

    public LocalDateTime getSzerkesztve() {
        return szerkesztve;
    }

    public LocalDateTime getLetrejott() {
        return letrejott;
    }

    public void like(){
        likeok++;
    }

    @Override
    public String toString() {
        if(this.letrejott != this.szerkesztve){
            return this.szerzo + " - " + this.likeok + " - " + this.letrejott + "\nSzerkesztve: " + this.szerkesztve + "\n" + this.tartalom;
        } else {
            return this.szerzo + " - " + this.likeok + " - " + this.letrejott + "\n" + this.tartalom;
        }
    }
}
