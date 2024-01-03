public class Market extends NormalKonum {
    Market(Oyuncu oyuncu){
        super(oyuncu, "Mağaza");
    }
    public boolean getKonum(){
        System.out.println("Para: " + oyuncu.getPara());
        System.out.println("1 - SİLAHLAR");
        System.out.println("2 - ZIRHLAR");
        System.out.println("3 - ÇIKIŞ");
        System.out.println("Seçiminiz: ");
        int esyakarari = input.nextInt();
        int esyakararid;
        switch (esyakarari) {
            case 1:
                esyakararid = silahmenusu();
                silahsatinal(esyakararid);
                break;
            case 2:
                esyakararid = zirhmenusu();
                zirhsatinal(esyakararid);
                break;
        
            default:
                break;
        }
        return true;
    }
    public int zirhmenusu(){
        System.out.println("1 - Düşük \t <Para: 15 - Hasar: 1>");
        System.out.println("2 - Orta \t <Para: 25 - Hasar: 3>");
        System.out.println("3 - Yüksek \t <Para: 40 - Hasar: 5>");
        System.out.println("4 - Çıkış");
        System.out.println("Zırh seçiniz: ");
        int zirhkararid = input.nextInt();
        return zirhkararid;
    }
    public void zirhsatinal(int esyaid){
        int onlenen = 0, fiyat = 0;
        String aIsim = null;
        switch (esyaid) {
            case 1:
                onlenen = 1;
                aIsim = "Düşük zırh";
                fiyat = 15;
                break;
            case 2:
                onlenen = 3;
                aIsim = "Orta zırh";
                fiyat = 15;
                break;
            case 3:
                onlenen = 5;
                aIsim = "Yüksek zırh";
                fiyat = 40;
                break;
            case 4:
                System.out.println("Çıkış yapılıyor...");
        
            default:
            System.out.println("Geçersiz işlem!");
                break;
        }
        if (fiyat > 0) {
            if (oyuncu.getPara() >= fiyat) {
                oyuncu.getEnvanter().setZirh(onlenen);
                oyuncu.getEnvanter().setaIsim(aIsim);
                oyuncu.setPara(oyuncu.getPara() - fiyat);
                System.out.println(aIsim + "satın aldınız, Engellenen hasar: " + oyuncu.getEnvanter().getZirh());
                System.out.println("Kalan para: " + oyuncu.getPara());
            }else{
                System.out.println("Para yetersiz!");
            }
        }
    }
    public int silahmenusu(){
        System.out.println("1 - Bıçak\t <Para: 25 - Hasar: 2>");
        System.out.println("2 - Silah\t <Para: 35 - Hasar: 3>");
        System.out.println("3 - Tüfek\t <Para: 45 - Hasar: 7>");
        System.out.println("4 - Çıkış");
        int silahkararid = input.nextInt();
        return silahkararid;
    }
    public void silahsatinal(int esyaid){
        int hasar = 0, fiyat = 0;
        String wIsim = null;
        switch (esyaid) {
            case 1:
                hasar =  2;
                wIsim = "Bıçak";
                fiyat =  25;
                break;
            case 2:
                hasar = 3;
                wIsim = "Silah";
                fiyat =  35;
                break;
            case 3:
                hasar = 7;
                wIsim = "Tüfek";
                fiyat =  45;
                break;
            case 4:
                System.out.println("Çıkış yapılıyor...");
                break;
        
            default:
            System.out.println("Geçersiz işlem!");
                break;
        }
        if (fiyat > 0) {
            if (oyuncu.getPara() > fiyat) {
                oyuncu.getEnvanter().setHasar(hasar);
                oyuncu.getEnvanter().setwIsim(wIsim);
                oyuncu.setPara(oyuncu.getPara() - fiyat);
                System.out.println(wIsim + "satın aldınız, önceki hasar: " + oyuncu.getHasar() + " , yeni hasar: " + oyuncu.getToplamhasar());
                System.out.println("Kalan para: " + oyuncu.getPara());
            }else{
                System.out.println("Para yetesiz!");
            }
        }
    }
}
