import java.util.*;

public class Main {
    public static void main(String[] args) {
        Metod metod =new Metod();
        Scanner scan = new Scanner(System.in);

        System.out.println("TAS KAGIT MAKAS OYUNUNA HOSGELDİNİZ");
        System.out.println("[1]-Kullanıcı-Bilgisayar");
        System.out.println("[2]-Bilgisayar-Bilgisayar");

        System.out.print("Lutfen secim yapiniz: ");
        int secim = scan.nextInt();
        int hamle=0;

        switch (secim) {
            case 1:
                metod.SecKullanici();
                metod.SecBilgisayar();
                while(hamle<10){
                    System.out.println("[1]-Savaştır");
                    System.out.println("[2]-Nesne puanı göster");
                    System.out.println("[3]-Skor durumunu göster");
                    System.out.print("Lutfen seciniz: ");
                    int a= scan.nextInt();
                    switch (a)
                    {
                        case 1:
                            metod.Savastir();
                            hamle++;
                            break;
                        case 2:
                            metod.NesneDurumu();
                            break;
                        case 3:
                            metod.SkorDurumu();
                    }
                }
                metod.Kazanan();
                break;
            case 2:
                metod.SecBilgisayar();
                metod.SecBilgisayar2();
                while (hamle<10) {
                    System.out.println("[1]-Savaştır");
                    System.out.println("[2]-Nesne puanı göster");
                    System.out.println("[3]-Skor durumunu göster");
                    System.out.println("Secin:");
                    int a= scan.nextInt();
                    switch (a)
                    {
                        case 1:
                            metod.Savastir2();
                            hamle++;
                            break;
                        case 2:
                            metod.NesneDurumuBilgisayar();
                            break;
                        case 3:
                            metod.SkorDurumu2();
                   }
                }
                metod.Kazanan2();
                break;
            default:
                System.out.println("HATALI SECIM!!");
        }
    }
}