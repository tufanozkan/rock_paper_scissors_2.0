public class UstaMakas extends Makas {
    double hiz;

    public UstaMakas(double hiz)
    {
        this.hiz=hiz;
    }

    public UstaMakas()
    {
        this.hiz=2;
    }

    @Override
    public void etkiHesapla(double saldiri, Nesne n) {
        if(n instanceof Kagit){
            saldiri=saldiri/(super.sK*hiz);
            super.durumGuncelle(saldiri);
        }
        if(n instanceof Tas){
            saldiri=saldiri/(super.sT*hiz);
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
