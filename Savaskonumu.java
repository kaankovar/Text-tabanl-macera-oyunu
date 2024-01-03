public abstract class Savaskonumu extends Konum {
    private Dusman dusman;
    private String odul;
    Savaskonumu(Oyuncu oyuncu, String isim, Dusman dusman, String odul){
        super(oyuncu);
        this.dusman = dusman;
        this.odul = odul;
        this.isim = isim;
    }
    public boolean getKonum(){
            int dusmansayisi = dusman.sayac();
            System.out.println("Şuan bulunduğunuz yer: " + this.getIsim());
            System.out.println("Dikkatli ol burda " + dusmansayisi + " kadar " + dusman.getIsim() + " yaşıyor! ");
            System.out.println("<S>avaş ya da <K>aç :");
            String karar = input.nextLine();
            karar = karar.toUpperCase();
            if (karar.equals("S")) {
                if (savas(dusmansayisi)) {
                    System.out.println("Tebrikler! " + this.getIsim() + " bölgesindeki tüm düşmanları temizlendiniz.");
                    if (this.odul.equals("Su") && oyuncu.getEnvanter().suVar() == false) {
                        System.out.println(this.odul + " kazandınız!");
                        oyuncu.getEnvanter().setSu(true);
                    }else if (this.odul.equals("Yemek") && oyuncu.getEnvanter().yemekVar() == false) {
                        System.out.println(this.odul + " kazandınız!");
                        oyuncu.getEnvanter().setYemek(true);
                    }else if (this.odul.equals("Yakacak") && oyuncu.getEnvanter().yakacakVar() == false) {
                        System.out.println(this.odul + " kazandınız!");
                        oyuncu.getEnvanter().setYakacak(true);
                    }
                return true;
            }
            if (oyuncu.getSaglik() <= 0) {
                System.out.println("Öldünüz!");
                return false;
            }
        }
        return true;
    }
    public boolean savas(int dusmansayisi){
        for (int i = 0; i < dusmansayisi; i++) {
            int dusmansagligi = dusman.getSaglik();
            oyuncudurumu();
            dusmanDurumu();
            while (oyuncu.getSaglik() > 0 && dusman.getSaglik() > 0) {
                System.out.println("<V>ur veya <K>aç");
                String karar = input.nextLine();
                karar = karar.toUpperCase();
                if (karar.equals("V")) {
                    System.out.println("Siz vurdunuz");
                    dusman.setSaglik(dusman.getSaglik() - oyuncu.getToplamhasar());
                    vurusSonrasi();
                    if (dusman.getSaglik() > 0) {
                        System.out.println();
                        System.out.println(dusman.getIsim() + " size vurdu!");
                        oyuncu.setSaglik(oyuncu.getSaglik() - (dusman.getHasar() - oyuncu.getEnvanter().getZirh()));
                        vurusSonrasi();
                    }
                }else{
                    return false;
                }
            }
            if (dusman.getSaglik() < oyuncu.getSaglik()) {
                System.out.println("Düşmanı yendiniz!");
                oyuncu.setPara(oyuncu.getPara() + dusman.getOdul());
                System.out.println("Güncel paranız: " + oyuncu.getPara());
                dusman.setSaglik(dusmansagligi);
            }else{
                return false;
            }
            System.out.println("---------------------");
        }
        return true;
    }
    public void oyuncudurumu(){
        System.out.println("Oyuncu Değerleri\n -------------------");
        System.out.println("Can: " + oyuncu.getSaglik());
        System.out.println("Hasar: " + oyuncu.getHasar());
        System.out.println("Para: " + oyuncu.getPara());
        if (oyuncu.getEnvanter().getHasar() > 0) {
            System.out.println("Silah: " + oyuncu.getEnvanter().getwIsim());
        }
        if (oyuncu.getEnvanter().getZirh() > 0) {
            System.out.println("Zırh: " + oyuncu.getEnvanter().getaIsim());
        }
    }
    public void dusmanDurumu(){
        System.out.println("\n" + dusman.getIsim() + "Değerleri\n--------------------");
        System.out.println("Can: " + dusman.getSaglik());
        System.out.println("Hasar: " + dusman.getHasar());
        System.out.println("Ödül: " + dusman.getOdul());
    }
    public void vurusSonrasi(){
        System.out.println("Oyuncu Canı: " + oyuncu.getSaglik());
        System.out.println(dusman.getIsim() + " Canı: " + dusman.getSaglik());
        System.out.println();
    }
}
