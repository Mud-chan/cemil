package com.pramudya.cemil;

import java.util.ArrayList;

public class Datarproduk {
    private static final String[] urutanproduk = {
            "Makaroni Pedas",
            "Keripik Kaca",
            "Basreng",
            "Makaroni Muter",
            "Mie Lidi",
            "Keripik Singkong"
    };

    private static String detailproduk[] = {
            "Cemilan makaroni dengan citarasa pedas yang bikin nagih",
            "Keripik yang renyah dan pedas yang cocok untuk cemilan bersama teman",
            "Cemilan yang cukup populer di kalangan anak muda dengan rasa pedas dan gurih",
            "Sebuah varian dari makaroni pedas yang cocok untuk cemilan ringan",
            "Cemilan yang populer dari dulu sampai sekarang dengan cita rasa pedas khasnya",
            "Keripik singkong dengan bumbu balado renyah dan gurih cocok untuk dimakan bersama teman"
    };

    private static final int[] imageproduk = {
            R.drawable.makaroni,
            R.drawable.keripikkaca,
            R.drawable.basreng,
            R.drawable.makaronimuter,
            R.drawable.mielidi,
            R.drawable.singkong
    };
    public static ArrayList<Produk> getListData(){
        ArrayList<Produk> list = new ArrayList<>();
        for (int position=0; position<urutanproduk.length; position++){
            Produk produk = new Produk();
            produk.setNama(urutanproduk[position]);
            produk.setDetail(detailproduk[position]);
            produk.setPhoto(imageproduk[position]);
            list.add(produk);


        }
        return list;
    }
}
