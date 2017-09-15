package com.digitalcreative.pengaduan;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import static com.digitalcreative.pengaduan.R.color.background;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;

    String[] KontenSpinner = {
            "Intan", "Kristal", "Permata", "Berlian", "Sasando", "Ukulele", "Mandolin", "Ekspress 2"
    };
    String[] KabelJTR = {
            "Join Bimetal", "Tap JTR", "Paralel"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        //set up Toolbar
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Pengaduan");
        toolbar.setTitleTextColor(Color.WHITE);

        //Set Spinner Penyulang
        Spinner spinner = (Spinner) findViewById(R.id.spin_penyulang);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.spinner, KontenSpinner);
        spinner.setAdapter(adapter);

        //Button Rekondisi
        final Button button_ya_rek = (Button) findViewById(R.id.rekondisi_ya);
        final Button button_tdk_rek = (Button) findViewById(R.id.rekondisi_tidak);
        button_ya_rek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                button_tdk_rek.setSelected(false);
            }
        });
        button_tdk_rek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                button_ya_rek.setSelected(false);
            }
        });

        //Button Kunci Gardu
        final Button button_ya = (Button) findViewById(R.id.kunci_gardu_ya);
        final Button button_tdk = (Button) findViewById(R.id.kunci_gardu_tidak);
        button_ya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                button_tdk.setSelected(false);
            }
        });

        button_tdk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                button_ya.setSelected(false);
            }
        });

        //Button Kokon
        final Button button_ya_kokon = (Button) findViewById(R.id.kokon_ya);
        final Button button_tdk_kokon = (Button) findViewById(R.id.kokon_tidak);
        button_ya_kokon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                button_tdk_kokon.setSelected(false);
            }
        });

        button_tdk_kokon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                button_ya_kokon.setSelected(false);
            }
        });

        //Schoon Trafo (DI TR)
        final Button button_3= (Button) findViewById(R.id.Schoon_Trafo_1);
        final Button button_2 = (Button) findViewById(R.id.Schoon_Trafo_2);
        final Button button_1= (Button) findViewById(R.id.Schoon_Trafo_3);
        final Button button_0 = (Button) findViewById(R.id.Schoon_Trafo_4);
        button_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                button_2.setSelected(false);
                button_1.setSelected(false);
                button_0.setSelected(false);
            }
        });

        button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                button_3.setSelected(false);
                button_1.setSelected(false);
                button_0.setSelected(false);
            }
        });

        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                button_2.setSelected(false);
                button_3.setSelected(false);
                button_0.setSelected(false);
            }
        });

        button_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                button_2.setSelected(false);
                button_1.setSelected(false);
                button_3.setSelected(false);
            }
        });

        //Button Saklar Utama PHB
        final Button button_ya_phb = (Button) findViewById(R.id.saklar_utama_phb_ya);
        final Button button_tidak_phb = (Button) findViewById(R.id.saklar_utama_phb_tidak);
        final LinearLayout editText_phb_ya = (LinearLayout) findViewById(R.id.text_gone);
        final EditText txt1 = (EditText) findViewById(R.id.f_saklar_merk);
        final EditText txt2 = (EditText) findViewById(R.id.f_saklar_arus);
        button_ya_phb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText_phb_ya.setVisibility(View.VISIBLE);
                view.setSelected(true);
                button_tidak_phb.setSelected(false);
            }
        });
        button_tidak_phb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText_phb_ya.setVisibility(View.GONE);
                view.setSelected(true);
                button_ya_phb.setSelected(false);
                txt1.setText("");
                txt2.setText("");
            }
        });

        //Fuse Jurusan
        final Button button_jur_A = (Button) findViewById(R.id.fuse_jurusan_A);
        final Button button_jur_B = (Button) findViewById(R.id.fuse_jurusan_B);
        final Button button_jur_C= (Button) findViewById(R.id.fuse_jurusan_C);
        final LinearLayout Jur_A_fuse = (LinearLayout) findViewById(R.id.text_gone_fuse_jurusan_A);
        final LinearLayout Jur_B_fuse = (LinearLayout) findViewById(R.id.text_gone_fuse_jurusan_B);
        final LinearLayout Jur_C_fuse = (LinearLayout) findViewById(R.id.text_gone_fuse_jurusan_C);
        final EditText txt_R_fuse_Jur_A = (EditText) findViewById(R.id.f_fuse_R_Jur_A);
        final EditText txt_S_fuse_Jur_A = (EditText) findViewById(R.id.f_fuse_S_Jur_A);
        final EditText txt_T_fuse_Jur_A = (EditText) findViewById(R.id.f_fuse_T_Jur_A);
        final EditText txt_R_fuse_Jur_B = (EditText) findViewById(R.id.f_fuse_R_Jur_B);
        final EditText txt_T_fuse_Jur_B = (EditText) findViewById(R.id.f_fuse_T_Jur_B);
        final EditText txt_S_fuse_Jur_B = (EditText) findViewById(R.id.f_fuse_S_Jur_B);
        final EditText txt_S_fuse_Jur_C = (EditText) findViewById(R.id.f_fuse_S_Jur_C);
        final EditText txt_R_fuse_Jur_C = (EditText) findViewById(R.id.f_fuse_R_Jur_C);
        final EditText txt_T_fuse_Jur_C = (EditText) findViewById(R.id.f_fuse_T_Jur_C);



        button_jur_A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Jur_A_fuse.setVisibility(View.VISIBLE);
                Jur_C_fuse.setVisibility(View.INVISIBLE);
                Jur_B_fuse.setVisibility(View.INVISIBLE);
                view.setSelected(true);
                button_jur_B.setSelected(false);
                button_jur_C.setSelected(false);
                txt_R_fuse_Jur_B.setText("");
                txt_S_fuse_Jur_B.setText("");
                txt_T_fuse_Jur_B.setText("");
                txt_R_fuse_Jur_C.setText("");
                txt_S_fuse_Jur_C.setText("");
                txt_T_fuse_Jur_C.setText("");


            }
        });
        button_jur_B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Jur_B_fuse.setVisibility(View.VISIBLE);
                Jur_A_fuse.setVisibility(View.INVISIBLE);
                Jur_C_fuse.setVisibility(View.INVISIBLE);
                view.setSelected(true);
                button_jur_A.setSelected(false);
                button_jur_C.setSelected(false);
                txt_R_fuse_Jur_A.setText("");
                txt_S_fuse_Jur_A.setText("");
                txt_T_fuse_Jur_A.setText("");
                txt_R_fuse_Jur_C.setText("");
                txt_S_fuse_Jur_C.setText("");
                txt_T_fuse_Jur_C.setText("");

            }
        });
        button_jur_C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Jur_C_fuse.setVisibility(View.VISIBLE);
                Jur_A_fuse.setVisibility(View.INVISIBLE);
                Jur_B_fuse.setVisibility(View.INVISIBLE);
                view.setSelected(true);
                button_jur_B.setSelected(false);
                button_jur_A.setSelected(false);
                txt_R_fuse_Jur_A.setText("");
                txt_S_fuse_Jur_A.setText("");
                txt_T_fuse_Jur_A.setText("");
                txt_R_fuse_Jur_C.setText("");
                txt_S_fuse_Jur_C.setText("");
                txt_T_fuse_Jur_C.setText("");
            }
        });

        //NH Jurusan
        final Button button_jur_NH_A = (Button) findViewById(R.id.NH_jurusan_A);
        final Button button_jur_NH_B = (Button) findViewById(R.id.NH_jurusan_B);
        final Button button_jur_NH_C = (Button) findViewById(R.id.NH_jurusan_C);
        final Button button_jur_NH_D = (Button) findViewById(R.id.NH_jurusan_D);
        final LinearLayout Jur_NH_A = (LinearLayout) findViewById(R.id.text_gone_NH_jurusan_A);
        final LinearLayout Jur_NH_B = (LinearLayout) findViewById(R.id.text_gone_NH_jurusan_B);
        final LinearLayout Jur_NH_C = (LinearLayout) findViewById(R.id.text_gone_NH_jurusan_C);
        final LinearLayout Jur_NH_D = (LinearLayout) findViewById(R.id.text_gone_NH_jurusan_D);
        final EditText txt_R_NH_Jur_A = (EditText) findViewById(R.id.f_NH_R_Jur_A);
        final EditText txt_S_NH_Jur_A = (EditText) findViewById(R.id.f_NH_S_Jur_A);
        final EditText txt_T_NH_Jur_A = (EditText) findViewById(R.id.f_NH_T_Jur_A);
        final EditText txt_R_NH_Jur_B = (EditText) findViewById(R.id.f_NH_R_Jur_B);
        final EditText txt_T_NH_Jur_B = (EditText) findViewById(R.id.f_NH_T_Jur_B);
        final EditText txt_S_NH_Jur_B = (EditText) findViewById(R.id.f_NH_S_Jur_B);
        final EditText txt_S_NH_Jur_C = (EditText) findViewById(R.id.f_NH_S_Jur_C);
        final EditText txt_R_NH_Jur_C = (EditText) findViewById(R.id.f_NH_R_Jur_C);
        final EditText txt_T_NH_Jur_C = (EditText) findViewById(R.id.f_NH_T_Jur_C);
        final EditText txt_S_NH_Jur_D = (EditText) findViewById(R.id.f_NH_S_Jur_D);
        final EditText txt_R_NH_Jur_D = (EditText) findViewById(R.id.f_NH_R_Jur_D);
        final EditText txt_T_NH_Jur_D = (EditText) findViewById(R.id.f_NH_T_Jur_D);
        button_jur_NH_A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Jur_NH_A.setVisibility(View.VISIBLE);
                Jur_NH_B.setVisibility(View.INVISIBLE);
                Jur_NH_C.setVisibility(View.INVISIBLE);
                Jur_NH_D.setVisibility(View.INVISIBLE);
                view.setSelected(true);
                button_jur_NH_D.setSelected(false);
                button_jur_NH_B.setSelected(false);
                button_jur_NH_C.setSelected(false);
                txt_R_NH_Jur_B.setText("");
                txt_S_NH_Jur_B.setText("");
                txt_T_NH_Jur_B.setText("");
                txt_R_NH_Jur_C.setText("");
                txt_S_NH_Jur_C.setText("");
                txt_T_NH_Jur_C.setText("");
                txt_R_NH_Jur_D.setText("");
                txt_S_NH_Jur_D.setText("");
                txt_T_NH_Jur_D.setText("");

            }
        });
        button_jur_NH_B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Jur_NH_B.setVisibility(View.VISIBLE);
                Jur_NH_A.setVisibility(View.INVISIBLE);
                Jur_NH_C.setVisibility(View.INVISIBLE);
                Jur_NH_D.setVisibility(View.INVISIBLE);
                view.setSelected(true);
                button_jur_NH_D.setSelected(false);
                button_jur_NH_A.setSelected(false);
                button_jur_NH_C.setSelected(false);
                txt_R_NH_Jur_A.setText("");
                txt_S_NH_Jur_A.setText("");
                txt_T_NH_Jur_A.setText("");
                txt_R_NH_Jur_C.setText("");
                txt_S_NH_Jur_C.setText("");
                txt_T_NH_Jur_C.setText("");
                txt_R_NH_Jur_D.setText("");
                txt_S_NH_Jur_D.setText("");
                txt_T_NH_Jur_D.setText("");

            }
        });
        button_jur_NH_C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Jur_NH_C.setVisibility(View.VISIBLE);
                Jur_NH_B.setVisibility(View.INVISIBLE);
                Jur_NH_A.setVisibility(View.INVISIBLE);
                Jur_NH_D.setVisibility(View.INVISIBLE);
                view.setSelected(true);
                button_jur_NH_D.setSelected(false);
                button_jur_NH_B.setSelected(false);
                button_jur_NH_A.setSelected(false);
                txt_R_NH_Jur_B.setText("");
                txt_S_NH_Jur_B.setText("");
                txt_T_NH_Jur_B.setText("");
                txt_R_NH_Jur_A.setText("");
                txt_S_NH_Jur_A.setText("");
                txt_T_NH_Jur_A.setText("");
                txt_R_NH_Jur_D.setText("");
                txt_S_NH_Jur_D.setText("");
                txt_T_NH_Jur_D.setText("");
            }
        });

        button_jur_NH_D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Jur_NH_D.setVisibility(View.VISIBLE);
                Jur_NH_B.setVisibility(View.INVISIBLE);
                Jur_NH_C.setVisibility(View.INVISIBLE);
                Jur_NH_A.setVisibility(View.INVISIBLE);
                view.setSelected(true);
                button_jur_NH_C.setSelected(false);
                button_jur_NH_B.setSelected(false);
                button_jur_NH_A.setSelected(false);
                txt_R_NH_Jur_B.setText("");
                txt_S_NH_Jur_B.setText("");
                txt_T_NH_Jur_B.setText("");
                txt_R_NH_Jur_C.setText("");
                txt_S_NH_Jur_C.setText("");
                txt_T_NH_Jur_C.setText("");
                txt_R_NH_Jur_A.setText("");
                txt_S_NH_Jur_A.setText("");
                txt_T_NH_Jur_A.setText("");
            }
        });

        //Jenis Kabel INLET
        final Button btn_inlet_NYY = (Button) findViewById(R.id.jenis_kabel_inlet_NYY);
        final Button btn_inlet_LUTC = (Button) findViewById(R.id.jenis_kabel_inlet_LUTC);
        final Button btn_inlet_NYFUBY = (Button) findViewById(R.id.jenis_kabel_inlet_NYFUBY);
        btn_inlet_NYY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                btn_inlet_LUTC .setSelected(false);
                btn_inlet_NYFUBY.setSelected(false);

            }
        });
        btn_inlet_LUTC .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                btn_inlet_NYY.setSelected(false);
                btn_inlet_NYFUBY.setSelected(false);

            }
        });
        btn_inlet_NYFUBY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                btn_inlet_LUTC .setSelected(false);
                btn_inlet_NYY.setSelected(false);
            }
        });

        //Penampang INLET
        final Button btn_penampang_70 = (Button) findViewById(R.id.penampang_inlet_70);
        final Button btn_penampang_95 = (Button) findViewById(R.id.penampang_inlet_95);
        final Button btn_penampang_150 = (Button) findViewById(R.id.penampang_inlet_150);
        final Button btn_penampang_240 = (Button) findViewById(R.id.penampang_inlet_240);
        btn_penampang_70.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                btn_penampang_95 .setSelected(false);
                btn_penampang_150.setSelected(false);
                btn_penampang_240.setSelected(false);

            }
        });
        btn_penampang_95 .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                btn_penampang_70.setSelected(false);
                btn_penampang_150.setSelected(false);
                btn_penampang_240.setSelected(false);

            }
        });
        btn_penampang_150.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                btn_penampang_95 .setSelected(false);
                btn_penampang_70.setSelected(false);
                btn_penampang_240.setSelected(false);
            }
        });
        btn_penampang_240.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                btn_penampang_95 .setSelected(false);
                btn_penampang_70.setSelected(false);
                btn_penampang_150.setSelected(false);
            }
        });

        //Jenis Kabel
        //Jur A
        final Button btn_outlet_NYY = (Button) findViewById(R.id.jenis_kabel_outlet_NYY);
        final Button btn_outlet_LUTC = (Button) findViewById(R.id.jenis_kabel_outlet_LUTC);
        final Button btn_outlet_NYFUBY = (Button) findViewById(R.id.jenis_kabel_outlet_NYFUBY);
        //Jur B
        final Button btn_jur_B_outlet_NYY = (Button) findViewById(R.id.jur_B_jenis_kabel_outlet_NYY);
        final Button btn_jur_B_outlet_LUTC = (Button) findViewById(R.id.jur_B_jenis_kabel_outlet_LUTC);
        final Button btn_jur_B_outlet_NYFUBY = (Button) findViewById(R.id.jur_B_jenis_kabel_outlet_NYFUBY);
        //Jur C
        final Button btn_jur_C_outlet_NYY = (Button) findViewById(R.id.jur_C_jenis_kabel_outlet_NYY);
        final Button btn_jur_C_outlet_LUTC = (Button) findViewById(R.id.jur_C_jenis_kabel_outlet_LUTC);
        final Button btn_jur_C_outlet_NYFUBY = (Button) findViewById(R.id.jur_C_jenis_kabel_outlet_NYFUBY);
        //Jur D
        final Button btn_jur_D_outlet_NYY = (Button) findViewById(R.id.jur_D_jenis_kabel_outlet_NYY);
        final Button btn_jur_D_outlet_LUTC = (Button) findViewById(R.id.jur_D_jenis_kabel_outlet_LUTC);
        final Button btn_jur_D_outlet_NYFUBY = (Button) findViewById(R.id.jur_D_jenis_kabel_outlet_NYFUBY);

        //Penampang Outlet
        //Jur A
        final Button btn_penampang_25 = (Button) findViewById(R.id.penampang_outlet_25);
        final Button btn_penampang_35 = (Button) findViewById(R.id.penampang_outlet_35);
        final Button btn_penampang_70_out = (Button) findViewById(R.id.penampang_outlet_70);
        final Button btn_penampang_95_out = (Button) findViewById(R.id.penampang_outlet_95);
        final Button btn_penampang_150_out = (Button) findViewById(R.id.penampang_outlet_150);
        final Button btn_penampang_240_out = (Button) findViewById(R.id.penampang_outlet_240);
        //Jur B
        final Button btn_jur_B_penampang_25 = (Button) findViewById(R.id.jur_B_penampang_outlet_25);
        final Button btn_jur_B_penampang_35 = (Button) findViewById(R.id.jur_B_penampang_outlet_35);
        final Button btn_jur_B_penampang_70_out = (Button) findViewById(R.id.jur_B_penampang_outlet_70);
        final Button btn_jur_B_penampang_95_out = (Button) findViewById(R.id.jur_B_penampang_outlet_95);
        final Button btn_jur_B_penampang_150_out = (Button) findViewById(R.id.jur_B_penampang_outlet_150);
        final Button btn_jur_B_penampang_240_out = (Button) findViewById(R.id.jur_B_penampang_outlet_240);
        //Jur C
        final Button btn_jur_C_penampang_25i = (Button) findViewById(R.id.jur_c_penampang_outlet_25);
        final Button btn_jur_C_penampang_35i = (Button) findViewById(R.id.jur_c_penampang_outlet_35);
        final Button btn_jur_C_penampang_70i_out = (Button) findViewById(R.id.jur_c_penampang_outlet_70);
        final Button btn_jur_C_penampang_95i_out = (Button) findViewById(R.id.jur_c_penampang_outlet_95);
        final Button btn_jur_C_penampang_150i_out = (Button) findViewById(R.id.jur_c_penampang_outlet_150);
        final Button btn_jur_C_penampang_240i_out = (Button) findViewById(R.id.jur_c_penampang_outlet_240);
        //Jur D
        final Button btn_jur_D_penampang_25 = (Button) findViewById(R.id.jur_D_penampang_outlet_25);
        final Button btn_jur_D_penampang_35 = (Button) findViewById(R.id.jur_D_penampang_outlet_35);
        final Button btn_jur_D_penampang_70_out = (Button) findViewById(R.id.jur_D_penampang_outlet_70);
        final Button btn_jur_D_penampang_95_out = (Button) findViewById(R.id.jur_D_penampang_outlet_95);
        final Button btn_jur_D_penampang_150_out = (Button) findViewById(R.id.jur_D_penampang_outlet_150);
        final Button btn_jur_D_penampang_240_out = (Button) findViewById(R.id.jur_D_penampang_outlet_240);

        //Data Kabel Outlet
        final Button kabel_jur_A = (Button) findViewById(R.id.data_kabel_jurusan_A);
        final Button kabel_jur_B = (Button) findViewById(R.id.data_kabel_jurusan_B);
        final Button kabel_jur_C = (Button) findViewById(R.id.data_kabel_jurusan_C);
        final Button kabel_jur_D = (Button) findViewById(R.id.data_kabel_jurusan_D);
        final LinearLayout Jur_A_data_bael = (LinearLayout) findViewById(R.id.jur_A_data_kabel);
        final LinearLayout Jur_B_data_bael = (LinearLayout) findViewById(R.id.jur_B_data_kabel);
        final LinearLayout Jur_C_data_bael = (LinearLayout) findViewById(R.id.jur_C_data_kabel);
        final LinearLayout Jur_D_data_bael = (LinearLayout) findViewById(R.id.jur_D_data_kabel);
        kabel_jur_A.setSelected(true);
        kabel_jur_B.setSelected(false);
        kabel_jur_C.setSelected(false);


        //Spinner Jur A
        final Spinner spinner2 = (Spinner) findViewById(R.id.spin_sambungan_kabel_ke_jtr);
        final ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, R.layout.spinner, KabelJTR);
        spinner2.setAdapter(adapter2);

        //Spinner Jur B
        final Spinner spinner3 = (Spinner) findViewById(R.id.jur_B_spin_sambungan_kabel_ke_jtr);
        final ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, R.layout.spinner, KabelJTR);

        //Spinner Jur C
        final Spinner spinner4 = (Spinner) findViewById(R.id.jur_C_spin_sambungan_kabel_ke_jtr);
        final ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this, R.layout.spinner, KabelJTR);

        //Spinner Jur D
        final Spinner spinner5 = (Spinner) findViewById(R.id.jur_D_spin_sambungan_kabel_ke_jtr);
        final ArrayAdapter<String> adapter5 = new ArrayAdapter<String>(this, R.layout.spinner, KabelJTR);

        kabel_jur_A .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Jur_A_data_bael.setVisibility(View.VISIBLE);
                Jur_B_data_bael.setVisibility(View.INVISIBLE);
                Jur_C_data_bael.setVisibility(View.INVISIBLE);
                Jur_D_data_bael.setVisibility(View.INVISIBLE);
                view.setSelected(true);
                kabel_jur_B.setSelected(false);
                kabel_jur_C.setSelected(false);
                kabel_jur_D.setSelected(false);
                btn_outlet_LUTC .setSelected(false);
                btn_outlet_NYFUBY.setSelected(false);
                btn_jur_B_outlet_NYY .setSelected(false);
                btn_jur_B_outlet_LUTC .setSelected(false);
                btn_jur_B_outlet_NYFUBY.setSelected(false);
                btn_jur_C_outlet_NYY .setSelected(false);
                btn_jur_C_outlet_LUTC .setSelected(false);
                btn_jur_C_outlet_NYFUBY.setSelected(false);
                btn_jur_D_outlet_NYY .setSelected(false);
                btn_jur_D_outlet_LUTC .setSelected(false);
                btn_jur_D_outlet_NYFUBY.setSelected(false);
                btn_jur_B_penampang_25 .setSelected(false);
                btn_jur_B_penampang_35 .setSelected(false);
                btn_jur_B_penampang_70_out.setSelected(false);
                btn_jur_B_penampang_95_out.setSelected(false);
                btn_jur_B_penampang_150_out.setSelected(false);
                btn_jur_B_penampang_240_out.setSelected(false);
                btn_jur_C_penampang_25i .setSelected(false);
                btn_jur_C_penampang_35i .setSelected(false);
                btn_jur_C_penampang_70i_out.setSelected(false);
                btn_jur_C_penampang_95i_out.setSelected(false);
                btn_jur_C_penampang_150i_out.setSelected(false);
                btn_jur_C_penampang_240i_out.setSelected(false);
                btn_jur_D_penampang_25 .setSelected(false);
                btn_jur_D_penampang_35 .setSelected(false);
                btn_jur_D_penampang_70_out.setSelected(false);
                btn_jur_D_penampang_95_out.setSelected(false);
                btn_jur_D_penampang_150_out.setSelected(false);
                btn_jur_D_penampang_240_out.setSelected(false);
                spinner3.setSelection(0);
                spinner4.setSelection(0);
                spinner5.setSelection(0);

            }
        });
        kabel_jur_B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Jur_B_data_bael.setVisibility(View.VISIBLE);
                Jur_A_data_bael.setVisibility(View.INVISIBLE);
                Jur_C_data_bael.setVisibility(View.INVISIBLE);
                Jur_D_data_bael.setVisibility(View.INVISIBLE);
                view.setSelected(true);
                kabel_jur_A.setSelected(false);
                kabel_jur_C.setSelected(false);
                kabel_jur_D.setSelected(false);
                btn_outlet_NYY .setSelected(false);
                btn_outlet_LUTC .setSelected(false);
                btn_outlet_NYFUBY.setSelected(false);
                btn_jur_C_outlet_NYY .setSelected(false);
                btn_jur_C_outlet_LUTC .setSelected(false);
                btn_jur_C_outlet_NYFUBY.setSelected(false);
                btn_jur_D_outlet_NYY .setSelected(false);
                btn_jur_D_outlet_LUTC .setSelected(false);
                btn_jur_D_outlet_NYFUBY.setSelected(false);
                btn_penampang_25.setSelected(false);
                btn_penampang_35.setSelected(false);
                btn_penampang_70_out.setSelected(false);
                btn_penampang_95_out.setSelected(false);
                btn_penampang_150_out.setSelected(false);
                btn_penampang_240_out.setSelected(false);
                btn_jur_C_penampang_25i .setSelected(false);
                btn_jur_C_penampang_35i .setSelected(false);
                btn_jur_C_penampang_70i_out.setSelected(false);
                btn_jur_C_penampang_95i_out.setSelected(false);
                btn_jur_C_penampang_150i_out.setSelected(false);
                btn_jur_C_penampang_240i_out.setSelected(false);
                btn_jur_D_penampang_25 .setSelected(false);
                btn_jur_D_penampang_35 .setSelected(false);
                btn_jur_D_penampang_70_out.setSelected(false);
                btn_jur_D_penampang_95_out.setSelected(false);
                btn_jur_D_penampang_150_out.setSelected(false);
                btn_jur_D_penampang_240_out.setSelected(false);
                spinner2.setSelection(0);
                spinner3.setAdapter(adapter3);
                spinner4.setSelection(0);
                spinner5.setSelection(0);
            }
        });
        kabel_jur_C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Jur_B_data_bael.setVisibility(View.INVISIBLE);
                Jur_A_data_bael.setVisibility(View.INVISIBLE);
                Jur_C_data_bael.setVisibility(View.VISIBLE);
                Jur_D_data_bael.setVisibility(View.INVISIBLE);
                view.setSelected(true);
                kabel_jur_B.setSelected(false);
                kabel_jur_A.setSelected(false);
                kabel_jur_D.setSelected(false);
                btn_outlet_NYY .setSelected(false);
                btn_outlet_LUTC .setSelected(false);
                btn_outlet_NYFUBY.setSelected(false);
                btn_jur_B_outlet_NYY .setSelected(false);
                btn_jur_B_outlet_LUTC .setSelected(false);
                btn_jur_B_outlet_NYFUBY.setSelected(false);
                btn_jur_D_outlet_NYY .setSelected(false);
                btn_jur_D_outlet_LUTC .setSelected(false);
                btn_jur_D_outlet_NYFUBY.setSelected(false);
                btn_penampang_25.setSelected(false);
                btn_penampang_35.setSelected(false);
                btn_penampang_70_out.setSelected(false);
                btn_penampang_95_out.setSelected(false);
                btn_penampang_150_out.setSelected(false);
                btn_penampang_240_out.setSelected(false);
                btn_jur_B_penampang_25 .setSelected(false);
                btn_jur_B_penampang_35 .setSelected(false);
                btn_jur_B_penampang_70_out.setSelected(false);
                btn_jur_B_penampang_95_out.setSelected(false);
                btn_jur_B_penampang_150_out.setSelected(false);
                btn_jur_B_penampang_240_out.setSelected(false);
                btn_jur_D_penampang_25 .setSelected(false);
                btn_jur_D_penampang_35 .setSelected(false);
                btn_jur_D_penampang_70_out.setSelected(false);
                btn_jur_D_penampang_95_out.setSelected(false);
                btn_jur_D_penampang_150_out.setSelected(false);
                btn_jur_D_penampang_240_out.setSelected(false);
                spinner2.setSelection(0);
                spinner4.setAdapter(adapter4);
                spinner3.setSelection(0);
                spinner5.setSelection(0);
            }
        });
        kabel_jur_D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Jur_B_data_bael.setVisibility(View.INVISIBLE);
                Jur_A_data_bael.setVisibility(View.INVISIBLE);
                Jur_C_data_bael.setVisibility(View.INVISIBLE);
                Jur_D_data_bael.setVisibility(View.VISIBLE);
                view.setSelected(true);
                kabel_jur_B.setSelected(false);
                kabel_jur_A.setSelected(false);
                kabel_jur_C.setSelected(false);
                btn_outlet_NYY .setSelected(false);
                btn_outlet_LUTC .setSelected(false);
                btn_outlet_NYFUBY.setSelected(false);
                btn_jur_B_outlet_NYY .setSelected(false);
                btn_jur_B_outlet_LUTC .setSelected(false);
                btn_jur_B_outlet_NYFUBY.setSelected(false);
                btn_jur_C_outlet_NYY .setSelected(false);
                btn_jur_C_outlet_LUTC .setSelected(false);
                btn_jur_C_outlet_NYFUBY.setSelected(false);
                btn_penampang_25.setSelected(false);
                btn_penampang_35.setSelected(false);
                btn_penampang_70_out.setSelected(false);
                btn_penampang_95_out.setSelected(false);
                btn_penampang_150_out.setSelected(false);
                btn_penampang_240_out.setSelected(false);
                btn_jur_B_penampang_25 .setSelected(false);
                btn_jur_B_penampang_35 .setSelected(false);
                btn_jur_B_penampang_70_out.setSelected(false);
                btn_jur_B_penampang_95_out.setSelected(false);
                btn_jur_B_penampang_150_out.setSelected(false);
                btn_jur_B_penampang_240_out.setSelected(false);
                btn_jur_C_penampang_25i .setSelected(false);
                btn_jur_C_penampang_35i .setSelected(false);
                btn_jur_C_penampang_70i_out.setSelected(false);
                btn_jur_C_penampang_95i_out.setSelected(false);
                btn_jur_C_penampang_150i_out.setSelected(false);
                btn_jur_C_penampang_240i_out.setSelected(false);
                spinner2.setSelection(0);
                spinner5.setAdapter(adapter5);
                spinner3.setSelection(0);
                spinner4.setSelection(0);
            }
        });

        //Jenis Kabel
        //Jur A
        btn_outlet_NYY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                btn_outlet_LUTC .setSelected(false);
                btn_outlet_NYFUBY.setSelected(false);
            }
        });
        btn_outlet_LUTC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                btn_outlet_NYY.setSelected(false);
                btn_outlet_NYFUBY.setSelected(false);


            }
        });
        btn_outlet_NYFUBY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                btn_outlet_LUTC .setSelected(false);
                btn_outlet_NYY.setSelected(false);

            }
        });

        //Jur B
        btn_jur_B_outlet_NYY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                btn_jur_B_outlet_LUTC .setSelected(false);
                btn_jur_B_outlet_NYFUBY.setSelected(false);

            }
        });
        btn_jur_B_outlet_LUTC .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                btn_jur_B_outlet_NYY.setSelected(false);
                btn_jur_B_outlet_NYFUBY.setSelected(false);

            }
        });
        btn_jur_B_outlet_NYFUBY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                btn_jur_B_outlet_LUTC .setSelected(false);
                btn_jur_B_outlet_NYY.setSelected(false);
            }
        });


        //Jur C
        btn_jur_C_outlet_NYY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                btn_jur_C_outlet_LUTC .setSelected(false);
                btn_jur_C_outlet_NYFUBY.setSelected(false);

            }
        });
        btn_jur_C_outlet_LUTC .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                btn_jur_C_outlet_NYY.setSelected(false);
                btn_jur_C_outlet_NYFUBY.setSelected(false);

            }
        });
        btn_jur_C_outlet_NYFUBY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                btn_jur_C_outlet_LUTC .setSelected(false);
                btn_jur_C_outlet_NYY.setSelected(false);
            }
        });

        //Jur D
        btn_jur_D_outlet_NYY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                btn_jur_D_outlet_LUTC .setSelected(false);
                btn_jur_D_outlet_NYFUBY.setSelected(false);

            }
        });
        btn_jur_D_outlet_LUTC .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                btn_jur_D_outlet_NYY.setSelected(false);
                btn_jur_D_outlet_NYFUBY.setSelected(false);

            }
        });
        btn_jur_D_outlet_NYFUBY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                btn_jur_D_outlet_LUTC .setSelected(false);
                btn_jur_D_outlet_NYY.setSelected(false);
            }
        });

        //Penampang OUTLET Jur A
        btn_penampang_25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                btn_penampang_35.setSelected(false);
                btn_penampang_70_out.setSelected(false);
                btn_penampang_95_out.setSelected(false);
                btn_penampang_150_out.setSelected(false);
                btn_penampang_240_out.setSelected(false);

            }
        });
        btn_penampang_35 .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                btn_penampang_25.setSelected(false);
                btn_penampang_70_out.setSelected(false);
                btn_penampang_95_out.setSelected(false);
                btn_penampang_150_out.setSelected(false);
                btn_penampang_240_out.setSelected(false);

            }
        });
        btn_penampang_70_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                btn_penampang_35 .setSelected(false);
                btn_penampang_25.setSelected(false);
                btn_penampang_95_out.setSelected(false);
                btn_penampang_150_out.setSelected(false);
                btn_penampang_240_out.setSelected(false);
            }
        });
        btn_penampang_95_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                btn_penampang_35 .setSelected(false);
                btn_penampang_25.setSelected(false);
                btn_penampang_70_out.setSelected(false);
                btn_penampang_150_out.setSelected(false);
                btn_penampang_240_out.setSelected(false);
            }
        });
        btn_penampang_150_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                btn_penampang_35 .setSelected(false);
                btn_penampang_25.setSelected(false);
                btn_penampang_70_out.setSelected(false);
                btn_penampang_95_out.setSelected(false);
                btn_penampang_240_out.setSelected(false);
            }
        });
        btn_penampang_240_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                btn_penampang_35 .setSelected(false);
                btn_penampang_25.setSelected(false);
                btn_penampang_70_out.setSelected(false);
                btn_penampang_95_out.setSelected(false);
                btn_penampang_150_out.setSelected(false);
            }
        });


        //Penampang OUTLET Jur B
        btn_jur_B_penampang_25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                btn_jur_B_penampang_35 .setSelected(false);
                btn_jur_B_penampang_70_out.setSelected(false);
                btn_jur_B_penampang_95_out.setSelected(false);
                btn_jur_B_penampang_150_out.setSelected(false);
                btn_jur_B_penampang_240_out.setSelected(false);

            }
        });
        btn_jur_B_penampang_35 .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                btn_jur_B_penampang_25.setSelected(false);
                btn_jur_B_penampang_70_out.setSelected(false);
                btn_jur_B_penampang_95_out.setSelected(false);
                btn_jur_B_penampang_150_out.setSelected(false);
                btn_jur_B_penampang_240_out.setSelected(false);

            }
        });
        btn_jur_B_penampang_70_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                btn_jur_B_penampang_35 .setSelected(false);
                btn_jur_B_penampang_25.setSelected(false);
                btn_jur_B_penampang_95_out.setSelected(false);
                btn_jur_B_penampang_150_out.setSelected(false);
                btn_jur_B_penampang_240_out.setSelected(false);
            }
        });
        btn_jur_B_penampang_95_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                btn_jur_B_penampang_35 .setSelected(false);
                btn_jur_B_penampang_25.setSelected(false);
                btn_jur_B_penampang_70_out.setSelected(false);
                btn_jur_B_penampang_150_out.setSelected(false);
                btn_jur_B_penampang_240_out.setSelected(false);
            }
        });
        btn_jur_B_penampang_150_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                btn_jur_B_penampang_35 .setSelected(false);
                btn_jur_B_penampang_25.setSelected(false);
                btn_jur_B_penampang_70_out.setSelected(false);
                btn_jur_B_penampang_95_out.setSelected(false);
                btn_jur_B_penampang_240_out.setSelected(false);
            }
        });
        btn_jur_B_penampang_240_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                btn_jur_B_penampang_35 .setSelected(false);
                btn_jur_B_penampang_25.setSelected(false);
                btn_jur_B_penampang_70_out.setSelected(false);
                btn_jur_B_penampang_95_out.setSelected(false);
                btn_jur_B_penampang_150_out.setSelected(false);
            }
        });

        //Penampang OUTLET Jur C
        btn_jur_C_penampang_25i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                btn_jur_C_penampang_35i .setSelected(false);
                btn_jur_C_penampang_70i_out.setSelected(false);
                btn_jur_C_penampang_95i_out.setSelected(false);
                btn_jur_C_penampang_150i_out.setSelected(false);
                btn_jur_C_penampang_240i_out.setSelected(false);

            }
        });
        btn_jur_C_penampang_35i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                btn_jur_C_penampang_25i.setSelected(false);
                btn_jur_C_penampang_70i_out.setSelected(false);
                btn_jur_C_penampang_95i_out.setSelected(false);
                btn_jur_C_penampang_150i_out.setSelected(false);
                btn_jur_C_penampang_240i_out.setSelected(false);

            }
        });
        btn_jur_C_penampang_70i_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                btn_jur_C_penampang_35i.setSelected(false);
                btn_jur_C_penampang_25i.setSelected(false);
                btn_jur_C_penampang_95i_out.setSelected(false);
                btn_jur_C_penampang_150i_out.setSelected(false);
                btn_jur_C_penampang_240i_out.setSelected(false);
            }
        });
        btn_jur_C_penampang_95i_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                btn_jur_C_penampang_35i .setSelected(false);
                btn_jur_C_penampang_25i.setSelected(false);
                btn_jur_C_penampang_70i_out.setSelected(false);
                btn_jur_C_penampang_150i_out.setSelected(false);
                btn_jur_C_penampang_240i_out.setSelected(false);
            }
        });
        btn_jur_C_penampang_150i_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                btn_jur_C_penampang_35i .setSelected(false);
                btn_jur_C_penampang_25i.setSelected(false);
                btn_jur_C_penampang_70i_out.setSelected(false);
                btn_jur_C_penampang_95i_out.setSelected(false);
                btn_jur_C_penampang_240i_out.setSelected(false);
            }
        });
        btn_jur_C_penampang_240i_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                btn_jur_C_penampang_35i .setSelected(false);
                btn_jur_C_penampang_25i.setSelected(false);
                btn_jur_C_penampang_70i_out.setSelected(false);
                btn_jur_C_penampang_95i_out.setSelected(false);
                btn_jur_C_penampang_150i_out.setSelected(false);
            }
        });

        //Penampang OUTLET Jur D
        btn_jur_D_penampang_25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                btn_jur_D_penampang_35 .setSelected(false);
                btn_jur_D_penampang_70_out.setSelected(false);
                btn_jur_D_penampang_95_out.setSelected(false);
                btn_jur_D_penampang_150_out.setSelected(false);
                btn_jur_D_penampang_240_out.setSelected(false);

            }
        });
        btn_jur_D_penampang_35 .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                btn_jur_D_penampang_25.setSelected(false);
                btn_jur_D_penampang_70_out.setSelected(false);
                btn_jur_D_penampang_95_out.setSelected(false);
                btn_jur_D_penampang_150_out.setSelected(false);
                btn_jur_D_penampang_240_out.setSelected(false);

            }
        });
        btn_jur_D_penampang_70_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                btn_jur_D_penampang_35 .setSelected(false);
                btn_jur_D_penampang_25.setSelected(false);
                btn_jur_D_penampang_95_out.setSelected(false);
                btn_jur_D_penampang_150_out.setSelected(false);
                btn_jur_D_penampang_240_out.setSelected(false);
            }
        });
        btn_jur_D_penampang_95_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                btn_jur_D_penampang_35 .setSelected(false);
                btn_jur_D_penampang_25.setSelected(false);
                btn_jur_D_penampang_70_out.setSelected(false);
                btn_jur_D_penampang_150_out.setSelected(false);
                btn_jur_D_penampang_240_out.setSelected(false);
            }
        });
        btn_jur_D_penampang_150_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                btn_jur_D_penampang_35 .setSelected(false);
                btn_jur_D_penampang_25.setSelected(false);
                btn_jur_D_penampang_70_out.setSelected(false);
                btn_jur_D_penampang_95_out.setSelected(false);
                btn_jur_D_penampang_240_out.setSelected(false);
            }
        });
        btn_jur_D_penampang_240_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                btn_jur_D_penampang_35 .setSelected(false);
                btn_jur_D_penampang_25.setSelected(false);
                btn_jur_D_penampang_70_out.setSelected(false);
                btn_jur_D_penampang_95_out.setSelected(false);
                btn_jur_D_penampang_150_out.setSelected(false);
            }
        });

        Button btn_submit = (Button) findViewById(R.id.btn_submit);
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Apakah Anda Ingin Submit Form ini?");
                builder.setPositiveButton(
                        "Yes",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(MainActivity.this, "Berhasil di Submit", Toast.LENGTH_SHORT).show();
                                Intent intent =  new Intent(getApplicationContext(),EndActivity.class);
                                startActivity(intent);
                            }
                        });
                builder.setNegativeButton(
                        "No",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });


    }
}