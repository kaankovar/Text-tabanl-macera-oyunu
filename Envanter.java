public class Envanter {
    private boolean su, yemek, yakacak;
    private int hasar, zirh;
    private String wIsim, aIsim;
    Envanter(){
        this.su = false;
        this.yemek = false;
        this.yakacak = false;
        this.hasar = 0;
        this.zirh = 0;
        this.wIsim = null;
        this.aIsim = null;
    }
    public boolean suVar(){
        return su;
    }
    public boolean yemekVar(){
        return yemek;
    }
    public boolean yakacakVar(){
        return yakacak;
    }
    public int getHasar(){
        return hasar;
    }
    public int getZirh(){
        return zirh;
    }
    public String getwIsim(){
        return wIsim;
    }
    public String getaIsim(){
        return aIsim;
    }
    public void setYemek(boolean yemek){
        this.yemek = yemek;
    }
    public void setYakacak(boolean yakacak){
        this.yakacak = yakacak;
    }
    public void setHasar(int hasar){
        this.hasar = hasar;
    }
    public void setZirh(int zirh){
        this.zirh = zirh;
    }
    public void setwIsim(String wIsim){
        this.wIsim = wIsim;
    }
    public void setaIsim(String aIsim){
        this.aIsim = aIsim;
    }
    public void setSu(boolean su){
        this.su = su;
    }


}
