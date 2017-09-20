package com.digitalcreative.pengaduan.Model;

/**
 * Created by malianzikri on 9/19/17.
 */

public class ModelForm {
    private String tanggal;
    private String alamat;


   //first
    private String petugas ;
    private String kapel ;
    private String kode_gardu ;


    //spinner
   private String penyulang;
    //=====
    private String daya ;
    private String merk ;
    private String noserie ;
    private String jlh_fasa ;
    private String tap_operasi ;
    private String kons_trafo ;

    //button ya tidak
    private String rekondisi;
    //=====

    private String tahun_pembuatan ;
    //button ya tidak
    private String kunci_gardu;
    //=====
    //button ya tidak
    private String kokon;
    //=====
    //button angka 3 2 1 0
    private String schoon_trafo;
    //=====
    private String kebutuhan_schoon_PHB ;
    //Data Pengaman Trafo
    private String primer_phasa_r ;
    private String primer_phasa_s ;
    private String primer_phasa_t ;
    private String saklar_merk ;
    private String saklar_arus ;
    private String fuse_R_Jur_A ;
    private String fuse_S_Jur_A ;
    private String fuse_T_Jur_A ;
    private String fuse_R_Jur_B ;
    private String fuse_S_Jur_B ;
    private String fuse_T_Jur_B ;
    private String fuse_R_Jur_C ;
    private String fuse_S_Jur_C ;
    private String fuse_T_Jur_C ;
    private String NH_R_Jur_A ;
    private String NH_S_Jur_A ;
    private String NH_T_Jur_A ;
    private String NH_R_Jur_B ;
    private String NH_S_Jur_B ;
    private String NH_T_Jur_B ;
    private String NH_R_Jur_C ;
    private String NH_S_Jur_C ;
    private String NH_T_Jur_C ;
    private String NH_R_Jur_D ;
    private String NH_S_Jur_D ;
    private String NH_T_Jur_D ;
    private String arrester ;
    //===============
    //Data Pertahanan
    private String saklar_tahanan_arrester;
    private String saklar_tahanan_netral ;
    private String body_trafo ;
    //=============
    //Data Kabel

    //button nyy lvtc nyfgby
    private String kabel_inlet;
    //=====
    //button 70 95 150 240
    private String penampang_inlet;
    //=====




    //Jenis Kabel Outlet
    //button jnyy lvtc nyfgby
    private String jenis_kabel_jurusan_a;



    //=====
    //button 25 35 70 95 150
    private String penampang_jurusan_a;


    //=====
    //spinner
    private String sambung_kabel_jtr_jurusan_a;
    //=====
    //button jnyy lvtc nyfgby
    private String jenis_kabel_jurusan_b;
    //=====
    //button 25 35 70 95 150
    private String penampang_jurusan_b;
    //=====
    //spinner
    private String sambung_kabel_jtr_jurusan_b;
    //=====
    //button jnyy lvtc nyfgby
    private String jenis_kabel_jurusan_c;
    //=====
    //button 25 35 70 95 150
    private String penampang_jurusan_c;
    //=====
    //spinner
    private String sambung_kabel_jtr_jurusan_c;
    //=====

     //button jnyy lvtc nyfgby
    private String jenis_kabel_jurusan_d;
    //=====
    //button 25 35 70 95 150
    private String penampang_jurusan_d;
    //=====
    //spinner
    private String sambung_kabel_jtr_jurusan_d;
    //=====
    //=======================



    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    public void setPetugas(String petugas) {
        this.petugas = petugas;
    }

    public void setKapel(String kapel) {
        this.kapel = kapel;
    }

    public void setKode_gardu(String kode_gardu) {
        this.kode_gardu = kode_gardu;
    }

    public void setPenyulang(String penyulang) {
        this.penyulang = penyulang;
    }

    public void setDaya(String daya) {
        this.daya = daya;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public void setNoserie(String noserie) {
        this.noserie = noserie;
    }

    public void setJlh_fasa(String jlh_fasa) {
        this.jlh_fasa = jlh_fasa;
    }

    public void setTap_operasi(String tap_operasi) {
        this.tap_operasi = tap_operasi;
    }

    public void setKons_trafo(String kons_trafo) {
        this.kons_trafo = kons_trafo;
    }

    public void setRekondisi(String rekondisi) {
        this.rekondisi = rekondisi;
    }

    public void setTahun_pembuatan(String tahun_pembuatan) {
        this.tahun_pembuatan = tahun_pembuatan;
    }

    public void setKunci_gardu(String kunci_gardu) {
        this.kunci_gardu = kunci_gardu;
    }

    public void setKokon(String kokon) {
        this.kokon = kokon;
    }

    public void setSchoon_trafo(String schoon_trafo) {
        this.schoon_trafo = schoon_trafo;
    }

    public void setKebutuhan_schoon_PHB(String kebutuhan_schoon_PHB) {
        this.kebutuhan_schoon_PHB = kebutuhan_schoon_PHB;
    }

    public void setPrimer_phasa_r(String primer_phasa_r) {
        this.primer_phasa_r = primer_phasa_r;
    }

    public void setPrimer_phasa_s(String primer_phasa_s) {
        this.primer_phasa_s = primer_phasa_s;
    }

    public void setPrimer_phasa_t(String primer_phasa_t) {
        this.primer_phasa_t = primer_phasa_t;
    }

    public void setSaklar_merk(String saklar_merk) {
        this.saklar_merk = saklar_merk;
    }

    public void setSaklar_arus(String saklar_arus) {
        this.saklar_arus = saklar_arus;
    }

    public void setFuse_R_Jur_A(String fuse_R_Jur_A) {
        this.fuse_R_Jur_A = fuse_R_Jur_A;
    }

    public void setFuse_S_Jur_A(String fuse_S_Jur_A) {
        this.fuse_S_Jur_A = fuse_S_Jur_A;
    }

    public void setFuse_T_Jur_A(String fuse_T_Jur_A) {
        this.fuse_T_Jur_A = fuse_T_Jur_A;
    }

    public void setFuse_R_Jur_B(String fuse_R_Jur_B) {
        this.fuse_R_Jur_B = fuse_R_Jur_B;
    }

    public void setFuse_S_Jur_B(String fuse_S_Jur_B) {
        this.fuse_S_Jur_B = fuse_S_Jur_B;
    }

    public void setFuse_T_Jur_B(String fuse_T_Jur_B) {
        this.fuse_T_Jur_B = fuse_T_Jur_B;
    }

    public void setFuse_R_Jur_C(String fuse_R_Jur_C) {
        this.fuse_R_Jur_C = fuse_R_Jur_C;
    }

    public void setFuse_S_Jur_C(String fuse_S_Jur_C) {
        this.fuse_S_Jur_C = fuse_S_Jur_C;
    }

    public void setFuse_T_Jur_C(String fuse_T_Jur_C) {
        this.fuse_T_Jur_C = fuse_T_Jur_C;
    }

    public void setNH_R_Jur_A(String NH_R_Jur_A) {
        this.NH_R_Jur_A = NH_R_Jur_A;
    }

    public void setNH_S_Jur_A(String NH_S_Jur_A) {
        this.NH_S_Jur_A = NH_S_Jur_A;
    }

    public void setNH_T_Jur_A(String NH_T_Jur_A) {
        this.NH_T_Jur_A = NH_T_Jur_A;
    }

    public void setNH_R_Jur_B(String NH_R_Jur_B) {
        this.NH_R_Jur_B = NH_R_Jur_B;
    }

    public void setNH_S_Jur_B(String NH_S_Jur_B) {
        this.NH_S_Jur_B = NH_S_Jur_B;
    }

    public void setNH_T_Jur_B(String NH_T_Jur_B) {
        this.NH_T_Jur_B = NH_T_Jur_B;
    }

    public void setNH_R_Jur_C(String NH_R_Jur_C) {
        this.NH_R_Jur_C = NH_R_Jur_C;
    }

    public void setNH_S_Jur_C(String NH_S_Jur_C) {
        this.NH_S_Jur_C = NH_S_Jur_C;
    }

    public void setNH_T_Jur_C(String NH_T_Jur_C) {
        this.NH_T_Jur_C = NH_T_Jur_C;
    }

    public void setNH_R_Jur_D(String NH_R_Jur_D) {
        this.NH_R_Jur_D = NH_R_Jur_D;
    }

    public void setNH_S_Jur_D(String NH_S_Jur_D) {
        this.NH_S_Jur_D = NH_S_Jur_D;
    }

    public void setNH_T_Jur_D(String NH_T_Jur_D) {
        this.NH_T_Jur_D = NH_T_Jur_D;
    }

    public void setArrester(String arrester) {
        this.arrester = arrester;
    }

    public void setSaklar_tahanan_arrester(String saklar_tahanan_arrester) {
        this.saklar_tahanan_arrester = saklar_tahanan_arrester;
    }

    public void setSaklar_tahanan_netral(String saklar_tahanan_netral) {
        this.saklar_tahanan_netral = saklar_tahanan_netral;
    }

    public void setBody_trafo(String body_trafo) {
        this.body_trafo = body_trafo;
    }

    public void setKabel_inlet(String kabel_inlet) {
        this.kabel_inlet = kabel_inlet;
    }

    public void setPenampang_inlet(String penampang_inlet) {
        this.penampang_inlet = penampang_inlet;
    }

    public void setJenis_kabel_jurusan_a(String jenis_kabel_jurusan_a) {
        this.jenis_kabel_jurusan_a = jenis_kabel_jurusan_a;
    }

    public void setPenampang_jurusan_a(String penampang_jurusan_a) {
        this.penampang_jurusan_a = penampang_jurusan_a;
    }

    public void setSambung_kabel_jtr_jurusan_a(String sambung_kabel_jtr_jurusan_a) {
        this.sambung_kabel_jtr_jurusan_a = sambung_kabel_jtr_jurusan_a;
    }

    public void setJenis_kabel_jurusan_b(String jenis_kabel_jurusan_b) {
        this.jenis_kabel_jurusan_b = jenis_kabel_jurusan_b;
    }

    public void setPenampang_jurusan_b(String penampang_jurusan_b) {
        this.penampang_jurusan_b = penampang_jurusan_b;
    }

    public void setSambung_kabel_jtr_jurusan_b(String sambung_kabel_jtr_jurusan_b) {
        this.sambung_kabel_jtr_jurusan_b = sambung_kabel_jtr_jurusan_b;
    }

    public void setJenis_kabel_jurusan_c(String jenis_kabel_jurusan_c) {
        this.jenis_kabel_jurusan_c = jenis_kabel_jurusan_c;
    }

    public void setPenampang_jurusan_c(String penampang_jurusan_c) {
        this.penampang_jurusan_c = penampang_jurusan_c;
    }

    public void setSambung_kabel_jtr_jurusan_c(String sambung_kabel_jtr_jurusan_c) {
        this.sambung_kabel_jtr_jurusan_c = sambung_kabel_jtr_jurusan_c;
    }

    public void setJenis_kabel_jurusan_d(String jenis_kabel_jurusan_d) {
        this.jenis_kabel_jurusan_d = jenis_kabel_jurusan_d;
    }

    public void setPenampang_jurusan_d(String penampang_jurusan_d) {
        this.penampang_jurusan_d = penampang_jurusan_d;
    }

    public void setSambung_kabel_jtr_jurusan_d(String sambung_kabel_jtr_jurusan_d) {
        this.sambung_kabel_jtr_jurusan_d = sambung_kabel_jtr_jurusan_d;
    }



    public String getPenyulang() {
        return penyulang;
    }

    public String getTanggal() {
        return tanggal;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getPetugas() {
        return petugas;
    }

    public String getKapel() {
        return kapel;
    }

    public String getKode_gardu() {
        return kode_gardu;
    }

    public String getDaya() {
        return daya;
    }

    public String getMerk() {
        return merk;
    }

    public String getNoserie() {
        return noserie;
    }

    public String getJlh_fasa() {
        return jlh_fasa;
    }

    public String getTap_operasi() {
        return tap_operasi;
    }

    public String getKons_trafo() {
        return kons_trafo;
    }

    public String getRekondisi() {
        return rekondisi;
    }

    public String getTahun_pembuatan() {
        return tahun_pembuatan;
    }

    public String getKunci_gardu() {
        return kunci_gardu;
    }

    public String getKokon() {
        return kokon;
    }

    public String getSchoon_trafo() {
        return schoon_trafo;
    }

    public String getKebutuhan_schoon_PHB() {
        return kebutuhan_schoon_PHB;
    }

    public String getPrimer_phasa_r() {
        return primer_phasa_r;
    }

    public String getPrimer_phasa_s() {
        return primer_phasa_s;
    }

    public String getPrimer_phasa_t() {
        return primer_phasa_t;
    }

    public String getSaklar_merk() {
        return saklar_merk;
    }

    public String getSaklar_arus() {
        return saklar_arus;
    }

    public String getFuse_R_Jur_A() {
        return fuse_R_Jur_A;
    }

    public String getFuse_S_Jur_A() {
        return fuse_S_Jur_A;
    }

    public String getFuse_T_Jur_A() {
        return fuse_T_Jur_A;
    }

    public String getFuse_R_Jur_B() {
        return fuse_R_Jur_B;
    }

    public String getFuse_S_Jur_B() {
        return fuse_S_Jur_B;
    }

    public String getFuse_T_Jur_B() {
        return fuse_T_Jur_B;
    }

    public String getFuse_R_Jur_C() {
        return fuse_R_Jur_C;
    }

    public String getFuse_S_Jur_C() {
        return fuse_S_Jur_C;
    }

    public String getFuse_T_Jur_C() {
        return fuse_T_Jur_C;
    }

    public String getNH_R_Jur_A() {
        return NH_R_Jur_A;
    }

    public String getNH_S_Jur_A() {
        return NH_S_Jur_A;
    }

    public String getNH_T_Jur_A() {
        return NH_T_Jur_A;
    }

    public String getNH_R_Jur_B() {
        return NH_R_Jur_B;
    }

    public String getNH_S_Jur_B() {
        return NH_S_Jur_B;
    }

    public String getNH_T_Jur_B() {
        return NH_T_Jur_B;
    }

    public String getNH_R_Jur_C() {
        return NH_R_Jur_C;
    }

    public String getNH_S_Jur_C() {
        return NH_S_Jur_C;
    }

    public String getNH_T_Jur_C() {
        return NH_T_Jur_C;
    }

    public String getNH_R_Jur_D() {
        return NH_R_Jur_D;
    }

    public String getNH_S_Jur_D() {
        return NH_S_Jur_D;
    }

    public String getNH_T_Jur_D() {
        return NH_T_Jur_D;
    }

    public String getArrester() {
        return arrester;
    }

    public String getSaklar_tahanan_arrester() {
        return saklar_tahanan_arrester;
    }

    public String getSaklar_tahanan_netral() {
        return saklar_tahanan_netral;
    }

    public String getBody_trafo() {
        return body_trafo;
    }

    public String getKabel_inlet() {
        return kabel_inlet;
    }

    public String getPenampang_inlet() {
        return penampang_inlet;
    }

    public String getJenis_kabel_jurusan_a() {
        return jenis_kabel_jurusan_a;
    }

    public String getPenampang_jurusan_a() {
        return penampang_jurusan_a;
    }

    public String getSambung_kabel_jtr_jurusan_a() {
        return sambung_kabel_jtr_jurusan_a;
    }

    public  String getJenis_kabel_jurusan_b() {
        return jenis_kabel_jurusan_b;
    }public String getPenampang_jurusan_b() {
        return penampang_jurusan_b;
    }public String getSambung_kabel_jtr_jurusan_b() {
        return sambung_kabel_jtr_jurusan_b;
    }public String getJenis_kabel_jurusan_c() {
        return jenis_kabel_jurusan_c;
    }public String getPenampang_jurusan_c() {
        return penampang_jurusan_c;
    }public String getSambung_kabel_jtr_jurusan_c() {
        return sambung_kabel_jtr_jurusan_c;
    }public String getJenis_kabel_jurusan_d() {
        return jenis_kabel_jurusan_d;
    }public String getPenampang_jurusan_d() {
        return penampang_jurusan_d;
    }public String getSambung_kabel_jtr_jurusan_d() {
        return sambung_kabel_jtr_jurusan_d;
    }
}
