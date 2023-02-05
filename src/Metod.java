import java.util.*;

public class Metod {

    ArrayList<Nesne> user=new ArrayList<Nesne>(5);
    ArrayList<Nesne> comp= new ArrayList<>(5);  // ai secim
    ArrayList<Nesne> comp2= new ArrayList<>(5);  // ai secim

    Bilgisayar bilgisayar=new Bilgisayar();
    Bilgisayar bilgisayar2=new Bilgisayar();
    Kullanici kullanici = new Kullanici();

    AgirTas agirtas=new AgirTas();
    OzelKagit ozelkagit=new OzelKagit();
    UstaMakas ustamakas=new UstaMakas();

    public  void SecKullanici()   //  Kullanıcı 3 nesneye ek 2 nesnesini secer
    {
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.println("0-Taş 1-Kağıt 2-Makas seçin:");
            int secim1=scan.nextInt();
            if(secim1==0) {
                user.add(new Tas());
            } else if (secim1==1) {
                user.add(new Kagit());
            } else if (secim1==2) {
                user.add(new Makas());
            }
        }
        System.out.println("USER: "+user);
    }

    public  void SecBilgisayar()  //  Bilgisayara 3 nesneye ek rastgele 2 nesne atanır
    {
        Random r=new Random(); //random sınıfı
        for (int i = 0; i < 5; i++) {
            int random = r.nextInt(3);
            if (random == 0) {
                comp.add(new Tas());
            }
            if (random == 1) {
                comp.add(new Kagit());
            }
            if (random == 2) {
                comp.add(new Makas());
            }
        }
        System.out.println("PC1: "+comp);
    }

    public  void SecBilgisayar2()  //  Bilgisayara 3 nesneye ek rastgele 2 nesne atanır
    {
        for (int i = 0; i < 5; i++) {
            Random r=new Random(); //random sınıfı
            int random=r.nextInt(3);
            if(random==0){
                comp2.add(new Tas());
            }
            if(random==1){
                comp2.add(new Kagit());
            }
            if(random==2){
                comp2.add(new Makas());
            }
        }
        System.out.println("PC2: "+comp2);
    }
    public void Savastir()
    {
        kullanici.setNesneListesi(user);
        bilgisayar.setNesneListesi(comp);
        int kulnes=kullanici.Nesnesec();
        int compnes=bilgisayar.Nesnesec();
        Nesne kul=kullanici.nesneListesi.get(kulnes);
        Nesne bil=bilgisayar.nesneListesi.get(compnes);

        if (kul instanceof AgirTas){
            if(bil instanceof Tas){
                kul.etkiHesapla(((Tas) bil).katilik,kul);
                bil.etkiHesapla(((AgirTas) kul).katilik,kul);
            }
        }
        if (kul instanceof OzelKagit){
            if(bil instanceof Kagit){
                kul.etkiHesapla(((Kagit) bil).nufuz,kul);
                bil.etkiHesapla(((OzelKagit) kul).nufuz,kul);
            }
        }
        if (kul instanceof UstaMakas){
            if(bil instanceof Makas){
                kul.etkiHesapla(((Makas) bil).keskinlik,kul);
                bil.etkiHesapla(((UstaMakas) kul).keskinlik,kul);
            }
        }
        if(kul instanceof Tas)
        {
            if(bil instanceof Tas){
                if(bil instanceof AgirTas){
                    System.out.println("Bilgisayar oynadı:"+bil.getClass().getName());
                    kul.etkiHesapla(((AgirTas) bil).katilik,kul);
                    bil.etkiHesapla(((Tas) kul).katilik,kul);
                }
                else{
                    System.out.println("Bilgisayar oynadı:"+bil.getClass().getName());
                    System.out.println("Berabere");
                }
            } else if (bil instanceof Kagit) {
                System.out.println("Bilgisayar oynadı:"+bil.getClass().getName());
                kul.etkiHesapla(((Kagit) bil).nufuz,bil);
                bil.etkiHesapla(((Tas) kul).katilik,kul);

                if(bilgisayar.nesneListesi.get(compnes).dayaniklilik<=0) {
                    bilgisayar.nesneListesi.remove(compnes);
                }
                bilgisayar.nesneListesi.get(compnes).seviyePuani+=20;
                if (bilgisayar.nesneListesi.get(compnes).seviyePuani>=30) {
                    bilgisayar.nesneListesi.set(compnes,ozelkagit);
                }
                if(kullanici.nesneListesi.get(kulnes).dayaniklilik<=0) {
                    kullanici.nesneListesi.remove(kulnes);
                }
            } else if (bil instanceof Makas) {
                System.out.println("Bilgisayar oynadı:"+bil.getClass().getName());
                kul.etkiHesapla(((Makas) bil).keskinlik,bil);
                bil.etkiHesapla(((Tas) kul).katilik,kul);

                kullanici.nesneListesi.get(kulnes).seviyePuani+=20;
                if(bilgisayar.nesneListesi.get(compnes).dayaniklilik<=0) {
                    bilgisayar.nesneListesi.remove(compnes);
                }
                if (kullanici.nesneListesi.get(kulnes).seviyePuani>=30) {
                    kullanici.nesneListesi.set(kulnes,agirtas);
                }
                if(kullanici.nesneListesi.get(kulnes).dayaniklilik<=0) {
                    kullanici.nesneListesi.remove(kulnes);
                }
            }
        }
        if(kul instanceof Kagit)
        {
            if(bil instanceof Kagit) {
                if(bil instanceof OzelKagit){
                    System.out.println("Bilgisayar oynadı:"+bil.getClass().getName());
                    kul.etkiHesapla(((OzelKagit) bil).kalinlik,kul);
                    bil.etkiHesapla(((Kagit) kul).nufuz,kul);
                }
                else {
                    System.out.println("Bilgisayar oynadı:"+bil.getClass().getName());
                    System.out.println("Berabere");
                }
            } else if (bil instanceof Tas) {
                System.out.println("Bilgisayar oynadı:"+bil.getClass().getName());
                kul.etkiHesapla(((Tas) bil).katilik,bil);
                bil.etkiHesapla(((Kagit) kul).nufuz,kul);

                if(bilgisayar.nesneListesi.get(compnes).dayaniklilik<=0) {
                    bilgisayar.nesneListesi.remove(compnes);
                }
                kullanici.nesneListesi.get(kulnes).seviyePuani+=20;
                if (kullanici.nesneListesi.get(kulnes).seviyePuani>=30) {
                    kullanici.nesneListesi.set(kulnes,ozelkagit);
                }
                if(kullanici.nesneListesi.get(kulnes).dayaniklilik<=0) {
                    kullanici.nesneListesi.remove(kulnes);
                }
            } else if (bil instanceof Makas) {
                System.out.println("Bilgisayar oynadı:"+bil.getClass().getName());
                kul.etkiHesapla(((Makas) bil).keskinlik,bil);
                bil.etkiHesapla(((Kagit) kul).nufuz,kul);

                if(bilgisayar.nesneListesi.get(compnes).dayaniklilik<=0) {
                    bilgisayar.nesneListesi.remove(compnes);
                }
                if(kullanici.nesneListesi.get(kulnes).dayaniklilik<=0) {
                    kullanici.nesneListesi.remove(kulnes);
                }
                bilgisayar.nesneListesi.get(compnes).seviyePuani+=20;
                if (bilgisayar.nesneListesi.get(compnes).seviyePuani>=30) {
                    bilgisayar.nesneListesi.set(compnes,ustamakas);
                }
            }
        }
        if(kul instanceof Makas)
        {
            if(bil instanceof Makas) {
                if(bil instanceof UstaMakas){
                    System.out.println("Bilgisayar oynadı:"+bil.getClass().getName());
                    kul.etkiHesapla(((UstaMakas) bil).hiz,kul);
                    bil.etkiHesapla(((Makas) kul).keskinlik,kul);
                }
                else {
                    System.out.println("Bilgisayar oynadı:"+bil.getClass().getName());
                    System.out.println("Berabere");
                }
            } else if (bil instanceof Tas) {
                System.out.println("Bilgisayar oynadı:"+bil.getClass().getName());
                kul.etkiHesapla(((Tas) bil).katilik,bil);
                bil.etkiHesapla(((Makas) kul).keskinlik,kul);

                if(bilgisayar.nesneListesi.get(compnes).dayaniklilik<=0) {
                    bilgisayar.nesneListesi.remove(compnes);
                }
                bilgisayar.nesneListesi.get(compnes).seviyePuani+=20;
                if (bilgisayar.nesneListesi.get(compnes).seviyePuani>=30) {
                    bilgisayar.nesneListesi.set(compnes,agirtas);
                }
                if(kullanici.nesneListesi.get(kulnes).dayaniklilik<=0) {
                    kullanici.nesneListesi.remove(kulnes);
                }
            } else if (bil instanceof Kagit) {
                System.out.println("Bilgisayar oynadı:"+bil.getClass().getName());
                kul.etkiHesapla(((Kagit) bil).nufuz,bil);
                bil.etkiHesapla(((Makas) kul).keskinlik,kul);

                if(bilgisayar.nesneListesi.get(compnes).dayaniklilik<=0) {
                    bilgisayar.nesneListesi.remove(compnes);
                }
                kullanici.nesneListesi.get(kulnes).seviyePuani+=20;
                if (kullanici.nesneListesi.get(kulnes).seviyePuani>=30) {
                    kullanici.nesneListesi.set(kulnes,ustamakas);
                }
                if(kullanici.nesneListesi.get(kulnes).dayaniklilik<=0)
                {
                    kullanici.nesneListesi.remove(kulnes);
                }
            }
        }
    }
    public void Savastir2()
    {
        bilgisayar.setNesneListesi(comp);
        bilgisayar2.setNesneListesi(comp2);
        int compnes1=bilgisayar.Nesnesec();
        int compnes2=bilgisayar2.Nesnesec();
        Nesne bil=bilgisayar.nesneListesi.get(compnes1);
        Nesne bil2=bilgisayar2.nesneListesi.get(compnes2);

        if (bil instanceof AgirTas){
            if(bil2 instanceof Tas){
                bil.etkiHesapla(((Tas) bil2).katilik,bil);
                bil2.etkiHesapla(((AgirTas) bil).katilik,bil);
            }
        }
        if (bil instanceof OzelKagit){
            if(bil2 instanceof Kagit){
                bil.etkiHesapla(((Kagit) bil2).nufuz,bil);
                bil2.etkiHesapla(((OzelKagit) bil).nufuz,bil);
            }
        }
        if (bil instanceof UstaMakas){
            if(bil2 instanceof Makas){
                bil.etkiHesapla(((Makas) bil2).keskinlik,bil);
                bil2.etkiHesapla(((UstaMakas) bil).keskinlik,bil);
            }
        }
        if(bil instanceof Tas)
        {
            if(bil2 instanceof Tas){
                if(bil2 instanceof AgirTas){
                    System.out.println("bilgisayar1 oynadı:"+bil.getClass().getName());
                    System.out.println("bilgisayar2 oynadı:"+bil2.getClass().getName());
                    bil.etkiHesapla(((AgirTas) bil2).katilik,bil);
                    bil2.etkiHesapla(((Tas) bil).katilik,bil);
                }
                else{
                    System.out.println("bilgisayar1 oynadı:"+bil.getClass().getName());
                    System.out.println("bilgisayar2 oynadı:"+bil2.getClass().getName());
                    System.out.println("Berabere");
                }
            } else if (bil2 instanceof Kagit) {
                System.out.println("bilgisayar1 oynadı:"+bil.getClass().getName());
                System.out.println("bilgisayar2 oynadı:"+bil2.getClass().getName());
                bil.etkiHesapla(((Kagit) bil2).nufuz,bil2);
                bil2.etkiHesapla(((Tas) bil).katilik,bil);

                if(bilgisayar2.nesneListesi.get(compnes2).dayaniklilik<=0) {
                    bilgisayar2.nesneListesi.remove(compnes2);
                }
                bilgisayar2.nesneListesi.get(compnes2).seviyePuani+=20;
                if (bilgisayar2.nesneListesi.get(compnes2).seviyePuani>=30) {
                    bilgisayar2.nesneListesi.set(compnes2,ozelkagit);
                }
                if(bilgisayar.nesneListesi.get(compnes1).dayaniklilik<=0) {
                    bilgisayar.nesneListesi.remove(compnes1);
                }
            } else if (bil2 instanceof Makas) {
                System.out.println("bilgisayar1 oynadı:"+bil.getClass().getName());
                System.out.println("bilgisayar2 oynadı:"+bil2.getClass().getName());
                bil.etkiHesapla(((Makas) bil2).keskinlik,bil2);
                bil2.etkiHesapla(((Tas) bil).katilik,bil);

                bilgisayar.nesneListesi.get(compnes1).seviyePuani+=20;
                if(bilgisayar2.nesneListesi.get(compnes2).dayaniklilik<=0) {
                    bilgisayar2.nesneListesi.remove(compnes2);
                }
                if (bilgisayar.nesneListesi.get(compnes1).seviyePuani>=30) {
                    bilgisayar.nesneListesi.set(compnes1,agirtas);
                }
                if(bilgisayar.nesneListesi.get(compnes1).dayaniklilik<=0) {
                    bilgisayar.nesneListesi.remove(compnes1);
                }
            }
        }
        else if(bil instanceof Kagit)
        {
            if(bil2 instanceof Kagit) {
                if(bil2 instanceof OzelKagit){
                    System.out.println("bilgisayar1 oynadı:"+bil.getClass().getName());
                    System.out.println("bilgisayar2 oynadı:"+bil2.getClass().getName());
                    bil.etkiHesapla(((OzelKagit) bil2).kalinlik,bil);
                    bil2.etkiHesapla(((Kagit) bil).nufuz,bil);
                }
                else {
                    System.out.println("bilgisayar1 oynadı:"+bil.getClass().getName());
                    System.out.println("bilgisayar2 oynadı:"+bil2.getClass().getName());
                    System.out.println("Berabere");
                }
            } else if (bil2 instanceof Tas) {
                System.out.println("bilgisayar1 oynadı:"+bil.getClass().getName());
                System.out.println("bilgisayar2 oynadı:"+bil2.getClass().getName());
                bil.etkiHesapla(((Tas) bil2).katilik,bil2);
                bil2.etkiHesapla(((Kagit) bil).nufuz,bil);

                if(bilgisayar2.nesneListesi.get(compnes2).dayaniklilik<=0) {
                    bilgisayar2.nesneListesi.remove(compnes2);
                }
                bilgisayar.nesneListesi.get(compnes1).seviyePuani+=20;
                if (bilgisayar.nesneListesi.get(compnes1).seviyePuani>=30) {
                    bilgisayar.nesneListesi.set(compnes1,ozelkagit);
                }
                if(bilgisayar.nesneListesi.get(compnes1).dayaniklilik<=0) {
                    bilgisayar.nesneListesi.remove(compnes1);
                }
            } else if (bil2 instanceof Makas) {
                System.out.println("bilgisayar1 oynadı:"+bil.getClass().getName());
                System.out.println("bilgisayar2 oynadı:"+bil2.getClass().getName());
                bil.etkiHesapla(((Makas) bil2).keskinlik,bil2);
                bil2.etkiHesapla(((Kagit) bil).nufuz,bil);

                if(bilgisayar2.nesneListesi.get(compnes2).dayaniklilik<=0) {
                    bilgisayar2.nesneListesi.remove(compnes2);
                }
                if(bilgisayar.nesneListesi.get(compnes1).dayaniklilik<=0) {
                    bilgisayar.nesneListesi.remove(compnes1);
                }
                bilgisayar2.nesneListesi.get(compnes2).seviyePuani+=20;
                if (bilgisayar2.nesneListesi.get(compnes2).seviyePuani>=30) {
                    bilgisayar2.nesneListesi.set(compnes2,ustamakas);
                }
            }
        }
        else if(bil instanceof Makas)
        {
            if(bil2 instanceof Makas) {
                if(bil2 instanceof UstaMakas){
                    System.out.println("bilgisayar1 oynadı:"+bil.getClass().getName());
                    System.out.println("bilgisayar2 oynadı:"+bil2.getClass().getName());
                    bil.etkiHesapla(((UstaMakas) bil2).hiz,bil);
                    bil2.etkiHesapla(((Makas) bil).keskinlik,bil);
                }
                else {
                    System.out.println("bilgisayar1 oynadı:"+bil.getClass().getName());
                    System.out.println("bilgisayar2 oynadı:"+bil2.getClass().getName());
                    System.out.println("Berabere");
                }
            } else if (bil2 instanceof Tas) {
                System.out.println("bilgisayar1 oynadı:"+bil.getClass().getName());
                System.out.println("bilgisayar2 oynadı:"+bil2.getClass().getName());
                bil.etkiHesapla(((Tas) bil2).katilik,bil2);
                bil2.etkiHesapla(((Makas) bil).keskinlik,bil);

                if(bilgisayar2.nesneListesi.get(compnes2).dayaniklilik<=0) {
                    bilgisayar2.nesneListesi.remove(compnes2);
                }
                bilgisayar2.nesneListesi.get(compnes2).seviyePuani+=20;
                if (bilgisayar2.nesneListesi.get(compnes2).seviyePuani>=30) {
                    bilgisayar2.nesneListesi.set(compnes2,agirtas);
                }
                if(bilgisayar.nesneListesi.get(compnes1).dayaniklilik<=0) {
                    bilgisayar.nesneListesi.remove(compnes1);
                }
            } else if (bil2 instanceof Kagit) {
                System.out.println("bilgisayar1 oynadı:"+bil.getClass().getName());
                System.out.println("bilgisayar2 oynadı:"+bil2.getClass().getName());
                bil.etkiHesapla(((Kagit) bil2).nufuz,bil2);
                bil2.etkiHesapla(((Makas) bil).keskinlik,bil);

                if(bilgisayar2.nesneListesi.get(compnes2).dayaniklilik<=0) {
                    bilgisayar2.nesneListesi.remove(compnes2);
                }
                bilgisayar.nesneListesi.get(compnes1).seviyePuani+=20;
                if (bilgisayar.nesneListesi.get(compnes1).seviyePuani>=30) {
                    bilgisayar.nesneListesi.set(compnes1,ustamakas);
                }
                if(bilgisayar.nesneListesi.get(compnes1).dayaniklilik<=0)
                {
                    bilgisayar.nesneListesi.remove(compnes1);
                }
            }
        }
    }

    public void NesneDurumu()
    {
        System.out.println("USER:");
        for (int i = 0; i < kullanici.nesneListesi.size(); i++) {
            kullanici.nesneListesi.get(i).nesnePuaniGoster();
        }
        System.out.println("PC:");
        for (int i = 0; i < bilgisayar.nesneListesi.size(); i++) {
            bilgisayar.nesneListesi.get(i).nesnePuaniGoster();
        }
    }
    public void NesneDurumuBilgisayar()
    {
        System.out.println("PC1:");
        for (int i = 0; i < bilgisayar.nesneListesi.size(); i++) {
            bilgisayar.nesneListesi.get(i).nesnePuaniGoster();
        }
        System.out.println("PC2:");
        for (int i = 0; i < bilgisayar2.nesneListesi.size(); i++) {
            bilgisayar2.nesneListesi.get(i).nesnePuaniGoster();
        }
    }

    double skorKullanici;
    double skorBilgisayar;
    double skorBilgisayar2;
    public void SkorDurumu(){
        skorKullanici=kullanici.SkorGoster(kullanici.nesneListesi);
        skorBilgisayar= bilgisayar.SkorGoster(bilgisayar.nesneListesi);
        System.out.println("Kullanıcının Skoru: "+skorKullanici);
        System.out.println("Bilgisayarın Skoru: "+skorBilgisayar);
    }
    public void SkorDurumu2(){
        skorBilgisayar=bilgisayar.SkorGoster(bilgisayar.nesneListesi);
        skorBilgisayar2=bilgisayar2.SkorGoster(bilgisayar2.nesneListesi);
        System.out.println("Bilgisayar1'in Skoru: "+skorBilgisayar);
        System.out.println("Bilgisayar2'nin Skoru: "+skorBilgisayar2);
    }

    public void Kazanan(){
        SkorDurumu();
        if(skorBilgisayar<skorKullanici) {
            System.out.println("Kullanıcı kazandı!");
        } else if (skorBilgisayar>skorKullanici) {
            System.out.println("Bilgisayar kazandı!");
        } else {
            System.out.println("Berabere!");
        }
    }
    public void Kazanan2(){
        SkorDurumu2();

        if(skorBilgisayar<skorBilgisayar2)
        {
            System.out.println("Bilgisayar2 kazandı!");
        } else if (skorBilgisayar>skorBilgisayar2) {
            System.out.println("Bilgisayar1 kazandı!");
        }
        else {
            System.out.println("Berabere!");
        }
    }
}
