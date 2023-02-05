import java.util.*;

public abstract class Oyuncu {
    String oyuncuID;
    String oyuncuAdi;
    int skor;

    public ArrayList <Nesne> nesneListesi= new ArrayList<>();

    public Oyuncu(String oyuncuAdi, String oyuncuID, int skor)
    {
        this.oyuncuAdi=oyuncuAdi;
        this.oyuncuID=oyuncuID;
        this.skor=skor;
    }

    public Oyuncu()
    {
        this.oyuncuAdi=oyuncuAdi;
        this.oyuncuID=oyuncuID;
        this.skor=skor;
    }

    public abstract double SkorGoster(ArrayList<Nesne> pup);
    public abstract int Nesnesec();
    public ArrayList<Nesne> getNesneListesi() {
        return nesneListesi;
    }
    public void setNesneListesi(ArrayList<Nesne> nesneListesi) {
        this.nesneListesi = nesneListesi;
    }
}
