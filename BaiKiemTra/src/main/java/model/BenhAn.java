package model;

public class BenhAn {
    private String maBenhAn;
    private  String tenBenhAn;

    public BenhAn(String maBenhAn, String tenBenhAn) {
        this.maBenhAn = maBenhAn;
        this.tenBenhAn = tenBenhAn;
    }

    public BenhAn() {
    }

    public String getMaBenhAn() {
        return maBenhAn;
    }

    public void setMaBenhAn(String maBenhAn) {
        this.maBenhAn = maBenhAn;
    }

    public String getTenBenhAn() {
        return tenBenhAn;
    }

    public void setTenBenhAn(String tenBenhAn) {
        this.tenBenhAn = tenBenhAn;
    }
}
