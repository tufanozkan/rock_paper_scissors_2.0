public class Tas extends Nesne {
    double katilik;
    double sK;
    double sM;

    public Tas(double katilik,double a)
    {
        this.katilik=katilik;
        this.sM=(1-a)*katilik;
        this.sK=a*katilik;
    }

    public Tas()
    {
        double a=0.2;
        this.katilik=2;
        this.sM=(1-a)*katilik;
        this.sK=a*katilik;
    }

    @Override
    public void nesnePuaniGoster() {
        System.out.print(getClass().getName()+" Dayanıklılık:"+super.dayaniklilik);
        System.out.println(" Seviye puanı:"+super.seviyePuani);
    }

    @Override
    public void etkiHesapla(double saldiri,Nesne n) {
        if(n instanceof  AgirTas) {
            saldiri=2;
            durumGuncelle(saldiri);
        }
        if(n instanceof Kagit) {
            if(n instanceof OzelKagit){
                saldiri=saldiri*((OzelKagit) n).kalinlik/sK;
                durumGuncelle(saldiri);
            }
            else {
                saldiri = saldiri / sK;
                durumGuncelle(saldiri);
            }
        }
        if (n instanceof Makas){
            if (n instanceof  UstaMakas){
                saldiri=saldiri*((UstaMakas) n).hiz/sM;
                durumGuncelle(saldiri);
            }
            else{
                saldiri = saldiri / sM;
                durumGuncelle(saldiri);
            }
        }
    }

    @Override
    public void durumGuncelle(double rakipSaldiri) {
        super.dayaniklilik=super.dayaniklilik-rakipSaldiri;
        System.out.println(getClass().getName()+" canı:"+super.dayaniklilik);
    }
}

