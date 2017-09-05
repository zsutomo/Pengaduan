package com.digitalcreative.pengaduan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;

import java.util.ArrayList;

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

        //set up Toolbar
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Pengaduan");

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
                editText_phb_ya.setVisibility(View.INVISIBLE);
                view.setSelected(true);
                button_ya_phb.setSelected(false);
            }
        });

        //Fuse Jurusan
        final Button button_jur_A = (Button) findViewById(R.id.fuse_jurusan_A);
        final Button button_jur_B = (Button) findViewById(R.id.fuse_jurusan_B);
        final Button button_jur_C= (Button) findViewById(R.id.fuse_jurusan_C);
        final LinearLayout Jur_A_fuse = (LinearLayout) findViewById(R.id.text_gone_fuse_jurusan_A);
        final LinearLayout Jur_B_fuse = (LinearLayout) findViewById(R.id.text_gone_fuse_jurusan_B);
        final LinearLayout Jur_C_fuse = (LinearLayout) findViewById(R.id.text_gone_fuse_jurusan_C);

        button_jur_A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Jur_A_fuse.setVisibility(View.VISIBLE);
                Jur_C_fuse.setVisibility(View.INVISIBLE);
                Jur_B_fuse.setVisibility(View.INVISIBLE);
                view.setSelected(true);
                button_jur_B.setSelected(false);
                button_jur_C.setSelected(false);

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
            }
        });
        kabel_jur_D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Jur_B_data_bael.setVisibility(View.INVISIBLE);
                Jur_A_data_bael.setVisibility(View.INVISIBLE);
                Jur_C_data_bael.setVisibility(View.VISIBLE);
                Jur_D_data_bael.setVisibility(View.INVISIBLE);
                view.setSelected(true);
                kabel_jur_B.setSelected(false);
                kabel_jur_A.setSelected(false);
                kabel_jur_C.setSelected(false);
            }
        });

        //Jenis Kabel Jur A
        //Jenis Kabel
        final Button btn_outlet_NYY = (Button) findViewById(R.id.jenis_kabel_outlet_NYY);
        final Button btn_outlet_LUTC = (Button) findViewById(R.id.jenis_kabel_outlet_LUTC);
        final Button btn_outlet_NYFUBY = (Button) findViewById(R.id.jenis_kabel_outlet_NYFUBY);
        btn_outlet_NYY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                btn_outlet_LUTC .setSelected(false);
                btn_outlet_NYFUBY.setSelected(false);

            }
        });
        btn_outlet_LUTC .setOnClickListener(new View.OnClickListener() {
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

        //Penampang OUTLET
        final Button btn_penampang_25 = (Button) findViewById(R.id.penampang_outlet_25);
        final Button btn_penampang_35 = (Button) findViewById(R.id.penampang_outlet_35);
        final Button btn_penampang_70_out = (Button) findViewById(R.id.penampang_outlet_70);
        final Button btn_penampang_95_out = (Button) findViewById(R.id.penampang_outlet_95);
        final Button btn_penampang_150_out = (Button) findViewById(R.id.penampang_outlet_150);
        final Button btn_penampang_240_out = (Button) findViewById(R.id.penampang_outlet_240);
        btn_penampang_25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                btn_penampang_35 .setSelected(false);
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


        //Jenis Kabel Jur B
        //Jenis Kabel
        final Button btn_jur_B_outlet_NYY = (Button) findViewById(R.id.jur_B_jenis_kabel_outlet_NYY);
        final Button btn_jur_B_outlet_LUTC = (Button) findViewById(R.id.jur_B_jenis_kabel_outlet_LUTC);
        final Button btn_jur_B_outlet_NYFUBY = (Button) findViewById(R.id.jur_B_jenis_kabel_outlet_NYFUBY);
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

        //Penampang OUTLET
        final Button btn_jur_B_penampang_25 = (Button) findViewById(R.id.jur_B_penampang_outlet_25);
        final Button btn_jur_B_penampang_35 = (Button) findViewById(R.id.jur_B_penampang_outlet_35);
        final Button btn_jur_B_penampang_70_out = (Button) findViewById(R.id.jur_B_penampang_outlet_70);
        final Button btn_jur_B_penampang_95_out = (Button) findViewById(R.id.jur_B_penampang_outlet_95);
        final Button btn_jur_B_penampang_150_out = (Button) findViewById(R.id.jur_B_penampang_outlet_150);
        final Button btn_jur_B_penampang_240_out = (Button) findViewById(R.id.jur_B_penampang_outlet_240);
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

        //Jenis Kabel Jur C
        //Jenis Kabel
        final Button btn_jur_C_outlet_NYY = (Button) findViewById(R.id.jur_C_jenis_kabel_outlet_NYY);
        final Button btn_jur_C_outlet_LUTC = (Button) findViewById(R.id.jur_C_jenis_kabel_outlet_LUTC);
        final Button btn_jur_C_outlet_NYFUBY = (Button) findViewById(R.id.jur_C_jenis_kabel_outlet_NYFUBY);
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

        //Penampang OUTLET
        final Button btn_jur_C_penampang_25 = (Button) findViewById(R.id.jur_C_penampang_outlet_25);
        final Button btn_jur_C_penampang_35 = (Button) findViewById(R.id.jur_C_penampang_outlet_35);
        final Button btn_jur_C_penampang_70_out = (Button) findViewById(R.id.jur_C_penampang_outlet_70);
        final Button btn_jur_C_penampang_95_out = (Button) findViewById(R.id.jur_C_penampang_outlet_95);
        final Button btn_jur_C_penampang_150_out = (Button) findViewById(R.id.jur_C_penampang_outlet_150);
        final Button btn_jur_C_penampang_240_out = (Button) findViewById(R.id.jur_C_penampang_outlet_240);

        btn_jur_C_penampang_25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                btn_jur_C_penampang_35 .setSelected(false);
                btn_jur_C_penampang_70_out.setSelected(false);
                btn_jur_C_penampang_95_out.setSelected(false);
                btn_jur_C_penampang_150_out.setSelected(false);
                btn_jur_C_penampang_240_out.setSelected(false);

            }
        });
        btn_jur_C_penampang_35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                btn_jur_C_penampang_25.setSelected(false);
                btn_jur_C_penampang_70_out.setSelected(false);
                btn_jur_C_penampang_95_out.setSelected(false);
                btn_jur_C_penampang_150_out.setSelected(false);
                btn_jur_C_penampang_240_out.setSelected(false);

            }
        });
        btn_jur_C_penampang_70_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                btn_jur_C_penampang_35 .setSelected(false);
                btn_jur_C_penampang_25.setSelected(false);
                btn_jur_C_penampang_95_out.setSelected(false);
                btn_jur_C_penampang_150_out.setSelected(false);
                btn_jur_C_penampang_240_out.setSelected(false);
            }
        });
        btn_jur_C_penampang_95_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                btn_jur_C_penampang_35 .setSelected(false);
                btn_jur_C_penampang_25.setSelected(false);
                btn_jur_C_penampang_70_out.setSelected(false);
                btn_jur_C_penampang_150_out.setSelected(false);
                btn_jur_C_penampang_240_out.setSelected(false);
            }
        });
        btn_jur_C_penampang_150_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                btn_jur_C_penampang_35 .setSelected(false);
                btn_jur_C_penampang_25.setSelected(false);
                btn_jur_C_penampang_70_out.setSelected(false);
                btn_jur_C_penampang_95_out.setSelected(false);
                btn_jur_C_penampang_240_out.setSelected(false);
            }
        });
        btn_jur_C_penampang_240_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                btn_jur_C_penampang_35 .setSelected(false);
                btn_jur_C_penampang_25.setSelected(false);
                btn_jur_C_penampang_70_out.setSelected(false);
                btn_jur_C_penampang_95_out.setSelected(false);
                btn_jur_C_penampang_150_out.setSelected(false);
            }
        });

        //Jenis Kabel Jur D
        //Jenis Kabel
        final Button btn_jur_D_outlet_NYY = (Button) findViewById(R.id.jur_D_jenis_kabel_outlet_NYY);
        final Button btn_jur_D_outlet_LUTC = (Button) findViewById(R.id.jur_D_jenis_kabel_outlet_LUTC);
        final Button btn_jur_D_outlet_NYFUBY = (Button) findViewById(R.id.jur_D_jenis_kabel_outlet_NYFUBY);
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

        //Penampang OUTLET
        final Button btn_jur_D_penampang_25 = (Button) findViewById(R.id.jur_D_penampang_outlet_25);
        final Button btn_jur_D_penampang_35 = (Button) findViewById(R.id.jur_D_penampang_outlet_35);
        final Button btn_jur_D_penampang_70_out = (Button) findViewById(R.id.jur_D_penampang_outlet_70);
        final Button btn_jur_D_penampang_95_out = (Button) findViewById(R.id.jur_D_penampang_outlet_95);
        final Button btn_jur_D_penampang_150_out = (Button) findViewById(R.id.jur_D_penampang_outlet_150);
        final Button btn_jur_D_penampang_240_out = (Button) findViewById(R.id.jur_D_penampang_outlet_240);
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


        //Spinner Jur A
        Spinner spinner2 = (Spinner) findViewById(R.id.spin_sambungan_kabel_ke_jtr);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, R.layout.spinner, KabelJTR);
        spinner2.setAdapter(adapter2);

        //Spinner Jur B
        Spinner spinner3 = (Spinner) findViewById(R.id.jur_B_spin_sambungan_kabel_ke_jtr);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, R.layout.spinner, KabelJTR);
        spinner3.setAdapter(adapter3);

        //Spinner Jur C
        Spinner spinner4 = (Spinner) findViewById(R.id.jur_C_spin_sambungan_kabel_ke_jtr);
        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this, R.layout.spinner, KabelJTR);
        spinner4.setAdapter(adapter4);


        //Spinner Jur D
        Spinner spinner5 = (Spinner) findViewById(R.id.jur_D_spin_sambungan_kabel_ke_jtr);
        ArrayAdapter<String> adapter5 = new ArrayAdapter<String>(this, R.layout.spinner, KabelJTR);
        spinner5.setAdapter(adapter5);

    }
}