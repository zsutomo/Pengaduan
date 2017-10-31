package com.digitalcreative.pengaduan.controller;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;

import com.digitalcreative.pengaduan.MainActivity;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/**
 * Created by malianzikri on 9/19/17.
 */

public class SupportManager {
    public String getCompleteAddressString(double LATITUDE, double LONGITUDE,Context context) {
        String address = "";
        Geocoder geocoder;
        List<Address> addresses = null;
        geocoder = new Geocoder(context, Locale.getDefault());

        try {
            addresses = geocoder.getFromLocation(LATITUDE,LONGITUDE, 1); // Here 1 represent max location result to returned, by documents it recommended 1 to 5
        } catch (IOException e) {
            e.printStackTrace();
        }

        address = addresses.get(0).getAddressLine(0);
        return address;
    }
    public String get_date_now(){
        Calendar c = Calendar.getInstance();


        SimpleDateFormat df = new SimpleDateFormat("dd MMM yyyy");
        return df.format(c.getTime());

    }
}
