package com.example.antrianmad;

public class Models {

    public String namaOrang, notelOrang, antrianOrang, kantinOrang,waktu;
    int idantri;

    //public Models(String namaOrang, String notelOrang, String antrianOrang, String kantinOrang){
        public Models(int idantri,String namaOrang, String notelOrang, String kantinOrang, String waktu){
        this.idantri = idantri;
        this.namaOrang = namaOrang;
        this.notelOrang = notelOrang;
        //this.antrianOrang = antrianOrang;
        this.kantinOrang = kantinOrang;
        this.waktu = waktu;

    }

    public int getIdAntri(){
            return idantri;
    }

    public void setIdAntri(int idantri){
            this.idantri = idantri;
    }

    public String getNamaOrang() {
        return namaOrang;
    }

    public void setNamaOrang(String namaOrang) {
        this.namaOrang = namaOrang;
    }

    public String getNotelOrang() {
        return notelOrang;
    }

    public void setNotelOrang(String notelOrang) {
        this.notelOrang = notelOrang;
    }

    //public String getAntrianOrang() { return antrianOrang; }

    //public void setAntrianOrang(String antrianOrang) { this.antrianOrang = antrianOrang; }

    public String getKantinOrang() {
        return kantinOrang;
    }

    public void setKantinOrang(String kantinOrang) {
        this.kantinOrang = kantinOrang;
    }

    public String getWaktu(){return waktu;}

    public void setWaktu(String waktu){
            this.waktu = waktu;
    }


}
