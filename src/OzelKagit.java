public class OzelKagit extends Kagit{
    double kalinlik;

    public OzelKagit(double kalinlik)
    {
        this.kalinlik=kalinlik;
    }

    public OzelKagit()
    {
        this.kalinlik=2;
    }

    @Override
    public void etkiHesapla(double saldiri,Nesne n) {
        if(n instanceof Tas){
            saldiri=saldiri/(super.sT*kalinlik);
            super.durumGuncelle(saldiri);
        }
        if(n instanceof Makas){
            saldiri=saldiri/(super.sM*kalinlik);
            super.durumGuncelle(saldiri);
        }
    }

    @Override
    public void durumGuncelle(double rakipSaldiri) {
        super.dayaniklilik=super.dayaniklilik-rakipSaldiri;
        System.out.println(getClass().getName()+" canı:"+super.dayaniklilik);
    }

    @Override
    public void nesnePuaniGoster() {
        System.out.print(getClass().getName()+" Dayanıklılık:"+super.dayaniklilik);
        System.out.println(" Seviye puanı:"+super.seviyePuani);
    }
}
