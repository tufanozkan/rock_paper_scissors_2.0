import java.util.*;

public class Kullanici extends Oyuncu{
    Scanner scan=new Scanner(System.in);
    boolean case1=true,case2=true,case3=true,case4=true,case5=true;

    @Override
    public double SkorGoster(ArrayList<Nesne> pup) {
        double toplamSkor=0;
        for (int i = 0; i < pup.size(); i++) {
            toplamSkor+=pup.get(i).dayaniklilik;
        }
        return toplamSkor;
    }

    @Override
    public int Nesnesec() {
        System.out.println("user:"+getNesneListesi());
       while (true){
            System.out.println("Secim yapin:");
            int a= scan.nextInt();
            if(!case1 && !case2 && !case3 && !case4 && !case5)
            {
                return a;
            }
            else {
                if (a == 0) {
                    if(case1) {
                        case1 = false;
                        return a;
                    }else {
                        System.out.println("Tekrar seçmek için tüm nesneleri en az bir kere oynamalısınız!!");
                    }
                }
                if (a == 1) {
                    if(case2) {
                        case2 = false;
                        return a;
                    }else {
                        System.out.println("Tekrar seçmek için tüm nesneleri en az bir kere oynamalısınız!!");
                    }
                }
                if (a == 2) {
                    if(case3) {
                        case3 = false;
                        return a;
                    }else {
                        System.out.println("Tekrar seçmek için tüm nesneleri en az bir kere oynamalısınız!!");
                    }
                }
                if (a == 3) {
                    if(case4) {
                        case4 = false;
                        return a;
                    }else {
                        System.out.println("Tekrar seçmek için tüm nesneleri en az bir kere oynamalısınız!!");
                    }
                }
                if (a == 4) {
                    if(case5) {
                        case5 = false;
                        return a;
                    }else {
                        System.out.println("Tekrar seçmek için tüm nesneleri en az bir kere oynamalısınız!!");
                    }
                }
            }
        }
    }
}
