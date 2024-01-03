import java.util.Random;
public class Dusman {
    private String isim;
    private int hasar, odul, saglik, maxSayi;
    public Dusman(String isim, int hasar, int saglik, int odul, int maxSayi){
        this.isim = isim;
        this.hasar = hasar;
        this.saglik = saglik;
        this.odul = odul;
        this.maxSayi = maxSayi;
    }
    public int sayac(){
        Random r = new Random();
        return r.nextInt(this.maxSayi) + 1;
    }
    public String getIsim(){
        return isim;
    }
    public void setIsim(String isim){
        this.isim = isim;
    }
    public int getHasar(){
        return hasar;
    }
    public void setHasar(int hasar){
        this.hasar = hasar;
    }
    public int getOdul(){
        return odul;
    }
    public void setOdul(int odul){
        this.odul = odul;
    }
    public int getSaglik(){
        return saglik;
    }
    public void setSaglik(int saglik){
        this.saglik = saglik;
    }
    public int getMaxsayi(){
        return maxSayi;
    }
    public void setMaxsayi(int maxSayi){
        this.maxSayi = maxSayi;
    }
}
