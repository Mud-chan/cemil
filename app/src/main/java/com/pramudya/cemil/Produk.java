package com.pramudya.cemil;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Produk implements Parcelable {
    private String nama, detail;
    private int photo;



    public Produk(){

    }
    public Produk(String nama, String detail, int photo) {
        this.nama = nama;
        this.detail = detail;
        this.photo = photo;
    }

    protected Produk(Parcel in) {
        nama = in.readString();
        detail = in.readString();
        photo = in.readInt();
    }

    public static final Creator<Produk> CREATOR = new Creator<Produk>() {
        @Override
        public Produk createFromParcel(Parcel in) {
            return new Produk(in);
        }

        @Override
        public Produk[] newArray(int size) {
            return new Produk[size];
        }
    };

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(nama);
        dest.writeString(detail);
        dest.writeInt(photo);
    }
}
