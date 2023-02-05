public class AgirTas extends Tas{
    double sicaklik;

    public AgirTas(double sicaklik)
    {
        this.sicaklik=sicaklik;
    }

    public AgirTas()
    {
        this.sicaklik=2;
    }
    @Override
    public void etkiHesapla(double saldiri,Nesne n) {

        if(n instanceof Kagit){
            saldiri=saldiri/(super.sK*sicaklik);
            super.durumGuncelle(saldiri);
        }
        if(n instanceof Makas){
            saldiri=saldiri/(super.sM*sicaklik);
            super.durumGuncelle(saldiri);
        }
    }

    @Override
    public void nesnePuaniGoster() {
        System.out.print(getClass().getName()+" Dayanıklılık:"+super.dayaniklilik);
        System.out.println(" Seviye puanı:"+super.seviyePuani);
    }

    @Override
    public void durumGuncelle(double rakipSaldiri) {
        super.dayaniklilik=super.dayaniklilik-rakipSaldiri;
        System.out.println(getClass().getName()+" canı:"+super.dayaniklilik);
    }
}
