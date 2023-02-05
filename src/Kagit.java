public class Kagit extends Nesne{
    double nufuz;
    double sM;
    double sT;


    public Kagit(double nufuz,double a)
    {
        this.nufuz=nufuz;
        this.sM=a*nufuz;
        this.sT=(1-a)*nufuz;
    }

    public Kagit()
    {
        double a=0.2;
        this.nufuz=2;
        this.sM=a*nufuz;
        this.sT=(1-a)*nufuz;
    }

    @Override
    public void nesnePuaniGoster() {
        System.out.print(getClass().getName()+" Dayanıklılık:"+super.dayaniklilik);
        System.out.println(" Seviye puanı:"+super.seviyePuani);
    }

    @Override
    public void etkiHesapla(double saldiri, Nesne n) {
        if(n instanceof  OzelKagit) {
            saldiri=2;
            durumGuncelle(saldiri);
        }
        if(n instanceof Tas) {
            if(n instanceof AgirTas){
                saldiri=saldiri*((AgirTas) n).sicaklik/sT;
                durumGuncelle(saldiri);
            }
            else {
                saldiri = saldiri / sT;
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
