package com.example.khaerulumam.submissionexpert4.model;

import android.os.Parcel;
import android.os.Parcelable;

public class FilmEntity implements Parcelable {
    private int id;
    private String judul, deskripsi, tahunTayang,popularitas,cover, negaraProduksi,statusFilm;
    Double rating;
    String isTrue;



    public String isTrue() {
        return isTrue;
    }

    public void setTrue(String aTrue) {
        isTrue = aTrue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getTahunTayang() {
        return tahunTayang;
    }

    public void setTahunTayang(String tahunTayang) {
        this.tahunTayang = tahunTayang;
    }

    public String getPopularitas() {
        return popularitas;
    }

    public void setPopularitas(String popularitas) {
        this.popularitas = popularitas;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getNegaraProduksi() {
        return negaraProduksi;
    }

    public void setNegaraProduksi(String negaraProduksi) {
        this.negaraProduksi = negaraProduksi;
    }

    public String getStatusFilm() {
        return statusFilm;
    }

    public void setStatusFilm(String statusFilm) {
        this.statusFilm = statusFilm;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public FilmEntity() {
    }

    public FilmEntity(int id, String judul, String deskripsi, String tahunTayang, String popularitas, String cover, String negaraProduksi, String status, Double rating, String isTrue) {
        this.id = id;
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.tahunTayang = tahunTayang;
        this.popularitas = popularitas;
        this.cover = cover;
        this.negaraProduksi = negaraProduksi;
        this.statusFilm = status;
        this.rating = rating;
        this.isTrue = isTrue;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.judul);
        dest.writeString(this.deskripsi);
        dest.writeString(this.tahunTayang);
        dest.writeString(this.popularitas);
        dest.writeString(this.cover);
        dest.writeString(this.negaraProduksi);
        dest.writeString(this.statusFilm);
        dest.writeValue(this.rating);
        dest.writeString(this.isTrue);
    }

    protected FilmEntity(Parcel in) {
        this.id = in.readInt();
        this.judul = in.readString();
        this.deskripsi = in.readString();
        this.tahunTayang = in.readString();
        this.popularitas = in.readString();
        this.cover = in.readString();
        this.negaraProduksi = in.readString();
        this.statusFilm = in.readString();
        this.rating = (Double) in.readValue(Double.class.getClassLoader());
        this.isTrue = in.readString();
    }

    public static final Creator<FilmEntity> CREATOR = new Creator<FilmEntity>() {
        @Override
        public FilmEntity createFromParcel(Parcel source) {
            return new FilmEntity(source);
        }

        @Override
        public FilmEntity[] newArray(int size) {
            return new FilmEntity[size];
        }
    };
}
