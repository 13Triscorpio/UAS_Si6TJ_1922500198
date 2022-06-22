package com.example.uassi6tj1922500198.dosen;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DosenPost {

    @SerializedName("nidn")
    @Expose
    private String nidn;
    @SerializedName("nama_dosen")
    @Expose
    private String namaDosen;
    @SerializedName("jabatan")
    @Expose
    private String jabatan;
    @SerializedName("gol_pang")
    @Expose
    private String golPang;
    @SerializedName("keahlian")
    @Expose
    private String keahlian;
    @SerializedName("program_studi")
    @Expose
    private String programStudi;

    public String getNidn() {
        return nidn;
    }

    public void setNidn(String nidn) {
        this.nidn = nidn;
    }

    public String getNamaDosen() {
        return namaDosen;
    }

    public void setNamaDosen(String namaDosen) {
        this.namaDosen = namaDosen;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String getGolPang() {
        return golPang;
    }

    public void setGolPang(String golPang) {
        this.golPang = golPang;
    }

    public String getKeahlian() {
        return keahlian;
    }

    public void setKeahlian(String keahlian) {
        this.keahlian = keahlian;
    }

    public String getProgramStudi() {
        return programStudi;
    }

    public void setProgramStudi(String programStudi) {
        this.programStudi = programStudi;
    }

}