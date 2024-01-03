import java.util.Scanner;

public class Oyun {
    Oyuncu oyuncu;
    Konum konum;
    Scanner input = new Scanner(System.in);
    public void giris(){
        Scanner input = new Scanner(System.in);
        System.out.println("Macera oyununa hoşgelldiniz!!!");
        System.out.println("Oyuna başlamadan önce adınızı giriniz: ");
        String oyuncuadi = input.nextLine();
        System.out.println("HOŞGELDİNİZ " + oyuncuadi);
        oyuncu = new Oyuncu(oyuncuadi);
        oyuncu.karakter();
        basla();
    }
    public void basla(){
        while (true) {
            System.out.println();
			System.out.println("=================================================");
			System.out.println();
			System.out.println("Eylem gerçekleştirmek için bir yer seçiniz : ");
			System.out.println("1. Güvenli Ev --> Size ait güvenli bir mekan, düşman yok !");
			System.out.println("2. Mağara --> Karşınıza belki Hayalet çıkabilir !");
			System.out.println("3. Orman --> Karşınıza belki Devayak çıkabilir !");
			System.out.println("4. Vadi --> Karşınıza belki Ejderha çıkabilir !");
			System.out.println("5. Market --> Silah veya Zırh alabilirsiniz!");
            System.out.println("0. ÇIKIŞ");
			System.out.print("Gitmek istediğiniz yer : ");
            int konumsecimi = input.nextInt();
            while (konumsecimi < 0 || konumsecimi > 5) {
                System.out.println("Lütfen geçerli bir yer seçiniz.");
                konumsecimi = input.nextInt();
            }
            if (konumsecimi == 0) {
                break;
            }
            switch (konumsecimi) {
                case 1:
                    konum = new GuvenliEv(oyuncu);
                    break;
                case 2:
                    konum = new Magara(oyuncu);
                    break;
                case 3:
                    konum = new Orman(oyuncu);
                    break;
                case 4:
                    konum = new Vadi(oyuncu);
                    break;
                case 5:
                    konum = new Market(oyuncu);
                    break;
            
                default:
                    konum = new GuvenliEv(oyuncu);
                    break;
            }
            if (konum.getClass().getName().equals("Güvenli Ev")) {
                if (oyuncu.getEnvanter().suVar() && oyuncu.getEnvanter().yemekVar() && oyuncu.getEnvanter().yakacakVar()) {
                    System.out.println("TEBRİKLER OYUNU KAZANDINIZ!!!!");
                    break;
                    
                }
            }
            if (!konum.getKonum()) {
                System.out.println("OYUN BİTTİ!!!");
                break;
            }
        }
    }
}
