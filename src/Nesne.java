public abstract class Nesne {
   double dayaniklilik;
   double seviyePuani;

   public Nesne(double dayaniklilik,double seviyePuani)
   {
       this.dayaniklilik=dayaniklilik;
       this.seviyePuani=seviyePuani;
   }

   public Nesne()
   {
        this.dayaniklilik=20;
        this.seviyePuani=0;
   }

    public abstract void nesnePuaniGoster(); // Nesnelerin dayanıklılık ve seviye puanı ozelliklerini oyunda gostermek icin
    public abstract void etkiHesapla(double saldiri,Nesne n); // Nesnelerin rakip nesneye karsı atak etkisini hesaplamak için
    public abstract void durumGuncelle(double rakipSaldiri);// Nesnelerin karsılıklı atakları sonucunda dayanıklılık degerlerinin azaltılması ve seviye puanı guncellemeleri icin
}
