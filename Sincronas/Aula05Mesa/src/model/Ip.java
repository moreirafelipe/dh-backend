package model;

public class Ip {

    private int octeto1;
    private int octeto2;
    private int octeto3;
    private int octeto4;

    public Ip(int octeto1, int octeto2, int octeto3, int octeto4) {
        this.octeto1 = octeto1;
        this.octeto2 = octeto2;
        this.octeto3 = octeto3;
        this.octeto4 = octeto4;
    }


    public int getOcteto1() {
        return octeto1;
    }
}
