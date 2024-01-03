import java.util.Scanner;
public class Oyuncu {
    private int hasar, saglik, para, rSaglik;
    private String isim, karakterIsmi;
    private Envanter envanter;
    Scanner input = new Scanner(System.in);
    public Oyuncu(String isim){
        this.isim = isim;
        this.envanter = new Envanter();
    }
    public int karakterMenusu(){
        System.out.println("Lütfen karakterinizi seçiniz: ");
        System.out.println("1 - Cellat \t Hasar: 5 \t Sağlık: 21 \t Para: 15");
        System.out.println("2 - Asker \t Hasar: 7 \t Sağlık: 18 \t Para: 20");
        System.out.println("3 - Nişancı \t Hasar: 8 \t Sağlık: 24 \t Para: 5");
        System.out.println("Karakter seçimin: ");
        int karaktersecimi = input.nextInt();
        while (karaktersecimi < 1 || karaktersecimi > 3) {
            System.out.println("Lütfen geçerli bir karakter seeçiniz: ");
            karaktersecimi = input.nextInt();
        }
        return karaktersecimi;
    }
    public void baslangicdegerleri(String karakterIsmi, int hasar, int saglik, int para){
        setKarakterismi(karakterIsmi);
        setHasar(hasar);
        setSaglik(saglik);
        setPara(para);
        setrSaglik(saglik);
    }
    public void karakter(){
        switch (karakterMenusu()) {
            case 1:
                baslangicdegerleri("Cellat", 5, 21, 15);
                break;
            case 2:
                baslangicdegerleri("Asker", 7, 18, 20);
                break;
            case 3:
                baslangicdegerleri("Nişancı", 8, 24, 5);
                break;
        
            default:
                break;
        }
        System.out.println("Karakter oluşturuldu! Adı = " + getKarakterismi() + "Hasarı = " + getHasar() + "Sağlığı = " + getSaglik() + "Parası = " + getPara());
    }
    public int getToplamhasar(){
        return this.getHasar() + this.getEnvanter().getHasar(); 
    }
    public int getHasar(){
        return hasar;
    }
    public void setHasar(int hasar){
        this.hasar = hasar;
    }
    public int getSaglik(){
        return saglik;
    }
    public void setSaglik(int saglik){
        this.saglik = saglik;
    }
    public int getPara(){
        return para;
    }
    public void setPara(int para){
        this.para = para;
    }
    public int getrSglik(){
        return rSaglik;
    }
    public void setrSaglik(int rSaglik){
        this.rSaglik = rSaglik;
    }
    public String getIsim(){
        return isim;
    }
    public void setIsim(String isim){
        this.isim = isim;
    }
    public String getKarakterismi(){
        return karakterIsmi;
    }
    public void setKarakterismi(String karakterIsmi){
        this.karakterIsmi = karakterIsmi;
    }
    public Envanter getEnvanter(){
        return envanter;
    }
    public void setEnvanter(Envanter envanter){
        this.envanter = envanter;
    }
}
