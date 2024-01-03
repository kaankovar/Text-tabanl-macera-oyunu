public class GuvenliEv extends NormalKonum {
    GuvenliEv(Oyuncu oyuncu){
        super(oyuncu, "Güvenli Ev");
    }
    public boolean getKonum(){
        oyuncu.setSaglik(oyuncu.getrSglik());
        System.out.println("İyileştiniz...");
        System.out.println("Şuan Güvenli Ev adlı yerdesiniz.");
        return true;
    }
}
