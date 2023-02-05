import java.util.ArrayList;
import java.util.Random;

public class Bilgisayar extends Oyuncu{
    boolean case1=true,case2=true,case3=true,case4=true,case5=true;

    @Override
    public double SkorGoster(ArrayList<Nesne> pup) {
        double toplamSkor=0;
        for(int i = 0; i < pup.size(); i++) {
            toplamSkor+=pup.get(i).dayaniklilik;
        }
        return toplamSkor;
    }

    @Override
    public int Nesnesec() {
        System.out.println("pc"+getNesneListesi());
        Random r=new Random(); //random sınıfı
        while (true){
            int a=r.nextInt(nesneListesi.size());
            if(!case1 && !case2 && !case3 && !case4 && !case5)
            {
                return a;
            }
            else {
                if (a == 0) {
                    if (case1) {
                        case1 = false;
                        return a;
                    }
                }
                if (a == 1) {
                    if(case2) {
                        case2 = false;
                        return a;
                    }
                }
                if (a == 2) {
                    if(case3) {
                        case3 = false;
                        return a;
                    }
                }
                if (a == 3) {
                    if(case4) {
                        case4 = false;
                        return a;
                    }
                }
                if (a == 4) {
                    if(case5) {
                        case5 = false;
                        return a;
                    }
                }
            }
        }
    }
}
