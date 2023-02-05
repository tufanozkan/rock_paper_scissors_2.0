public class Makas extends Nesne{
    double keskinlik;
    double sT;
    double sK;

    public Makas(double keskinlik,double a)
    {
        this.keskinlik=keskinlik;
        this.sT=a*keskinlik;
        this.sK=(1-a)*keskinlik;
    }

    public Makas()
    {
        double a=0.2;
        this.keskinlik=2;
        this.sT=a*keskinlik;
        this.sK=(1-a)*keskinlik;
    }

    @Override
    public void nesnePuaniGoster() {
        System.out.print(getClass().getName()+" Dayanıklılık:"+super.dayaniklilik);
        System.out.println(" Seviye puanı:"+super.seviyePuani);
    }

    @Override
    public void etkiHesapla(double saldiri, Nesne n) {
        if(n instanceof  UstaMakas) {
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
        if (n instanceof Tas){
            if (n instanceof  AgirTas){
                saldiri=saldiri*((AgirTas) n).sicaklik/sT;
                durumGuncelle(saldiri);
            }
            else{
                saldiri = saldiri / sT;
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
