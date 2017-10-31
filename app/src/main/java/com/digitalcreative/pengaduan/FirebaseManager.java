package com.digitalcreative.pengaduan;


import com.digitalcreative.pengaduan.Model.ModelForm;
import com.digitalcreative.pengaduan.controller.SupportManager;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;

/**
 * Created by malianzikri on 9/19/17.
 */

public class FirebaseManager {
    private DatabaseReference mDatabase;

    public FirebaseManager(){
        mDatabase = FirebaseDatabase.getInstance().getReference();

    }

    public void insert_form(String penyulang,ModelForm modelForm){
       String uid= mDatabase.child("pengaduan").child(penyulang).push().getKey();
        mDatabase.child("pengaduan").child(penyulang).child(uid).setValue(modelForm);
        mDatabase.child("pengaduan").child(penyulang).child(uid).child("timestamp").setValue(ServerValue.TIMESTAMP);
    }



}
