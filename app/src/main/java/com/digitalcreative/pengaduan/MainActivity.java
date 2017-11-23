package com.digitalcreative.pengaduan;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.digitalcreative.pengaduan.Model.ModelForm;
import com.digitalcreative.pengaduan.controller.GPSTracker;
import com.digitalcreative.pengaduan.controller.SupportManager;



public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;

    String[] KontenSpinner = {
            "Intan", "Kristal", "Permata", "Berlian", "Sasando", "Ukulele", "Mandolin", "Ekspress 2"
    };
    String[] KabelJTR = {
            "Join Bimetal", "Tap JTR", "Paralel"
    };
    GPSTracker gpsTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         gpsTracker = new GPSTracker(getApplicationContext(), this);
        if (gpsTracker.canGetLocation()) {


            if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                checkLocationPermission();
            }
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

            //set up Toolbar
            toolbar = (Toolbar) findViewById(R.id.tool_bar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("Laporan Gardu Distribusi");
            toolbar.setTitleTextColor(Color.WHITE);

            datapengaduan1();
            datapengamantrafo();
            datakabel();
//        check_error();

            final Button btn_submit = (Button) findViewById(R.id.btn_submit);
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
//                                ModelForm modelform=model_form_manager();
//                                FirebaseManager firebaseManager=new FirebaseManager();
//                                firebaseManager.insert_form(modelform.getPenyulang(),modelform);
//                                Toast.makeText(MainActivity.this, "Berhasil di Submit", Toast.LENGTH_SHORT).show();
//                                Intent intent =  new Intent(getApplicationContext(),EndActivity.class);
//                                startActivity(intent);
                                    if (check_error() == false) {
                                        ModelForm modelform = model_form_manager();
                                        FirebaseManager firebaseManager = new FirebaseManager();
                                        firebaseManager.insert_form(modelform.getPenyulang(), modelform);
                                        Toast.makeText(MainActivity.this, "Berhasil di Submit", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(getApplicationContext(), EndActivity.class);
                                        startActivity(intent);
                                    } else {
                                        Toast.makeText(MainActivity.this, "Silahkan isi data selengkapnya", Toast.LENGTH_SHORT).show();
                                    }

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

        } else {
            // Can't get location.
            // GPS or network is not enabled.
            // Ask user to enable GPS/network in settings.
            gpsTracker.showSettingsAlert();
        }


    }

    public void datapengaduan1() {
        //Set Spinner Penyulang
        Spinner spinner = (Spinner) findViewById(R.id.spin_penyulang);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner, KontenSpinner);
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
        final Button button_3 = (Button) findViewById(R.id.Schoon_Trafo_1);
        final Button button_2 = (Button) findViewById(R.id.Schoon_Trafo_2);
        final Button button_1 = (Button) findViewById(R.id.Schoon_Trafo_3);
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

    }

    public void datapengamantrafo() {
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
        final Button button_jur_C = (Button) findViewById(R.id.fuse_jurusan_C);
        final Button button_jur_D = (Button) findViewById(R.id.fuse_jurusan_D);
        final LinearLayout Jur_A_fuse = (LinearLayout) findViewById(R.id.text_gone_fuse_jurusan_A);
        final LinearLayout Jur_B_fuse = (LinearLayout) findViewById(R.id.text_gone_fuse_jurusan_B);
        final LinearLayout Jur_C_fuse = (LinearLayout) findViewById(R.id.text_gone_fuse_jurusan_C);
        final LinearLayout Jur_D_fuse = (LinearLayout) findViewById(R.id.text_gone_fuse_jurusan_D);
        final EditText txt_R_fuse_Jur_A = (EditText) findViewById(R.id.f_fuse_R_Jur_A);
        final EditText txt_S_fuse_Jur_A = (EditText) findViewById(R.id.f_fuse_S_Jur_A);
        final EditText txt_T_fuse_Jur_A = (EditText) findViewById(R.id.f_fuse_T_Jur_A);
        final EditText txt_R_fuse_Jur_B = (EditText) findViewById(R.id.f_fuse_R_Jur_B);
        final EditText txt_T_fuse_Jur_B = (EditText) findViewById(R.id.f_fuse_T_Jur_B);
        final EditText txt_S_fuse_Jur_B = (EditText) findViewById(R.id.f_fuse_S_Jur_B);
        final EditText txt_S_fuse_Jur_C = (EditText) findViewById(R.id.f_fuse_S_Jur_C);
        final EditText txt_R_fuse_Jur_C = (EditText) findViewById(R.id.f_fuse_R_Jur_C);
        final EditText txt_T_fuse_Jur_C = (EditText) findViewById(R.id.f_fuse_T_Jur_C);
        final EditText txt_S_fuse_Jur_D = (EditText) findViewById(R.id.f_fuse_S_Jur_D);
        final EditText txt_R_fuse_Jur_D = (EditText) findViewById(R.id.f_fuse_R_Jur_D);
        final EditText txt_T_fuse_Jur_D = (EditText) findViewById(R.id.f_fuse_T_Jur_D);


        button_jur_A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Jur_A_fuse.setVisibility(View.VISIBLE);
                Jur_C_fuse.setVisibility(View.INVISIBLE);
                Jur_B_fuse.setVisibility(View.INVISIBLE);
                Jur_D_fuse.setVisibility(View.INVISIBLE);
                view.setSelected(true);
                button_jur_B.setSelected(false);
                button_jur_C.setSelected(false);
                button_jur_D.setSelected(false);
//                txt_R_fuse_Jur_B.setText("");
//                txt_S_fuse_Jur_B.setText("");
//                txt_T_fuse_Jur_B.setText("");
//                txt_R_fuse_Jur_C.setText("");
//                txt_S_fuse_Jur_C.setText("");
//                txt_T_fuse_Jur_C.setText("");


            }
        });
        button_jur_B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Jur_B_fuse.setVisibility(View.VISIBLE);
                Jur_A_fuse.setVisibility(View.INVISIBLE);
                Jur_C_fuse.setVisibility(View.INVISIBLE);
                Jur_D_fuse.setVisibility(View.INVISIBLE);
                view.setSelected(true);
                button_jur_A.setSelected(false);
                button_jur_C.setSelected(false);
                button_jur_D.setSelected(false);
//                txt_R_fuse_Jur_A.setText("");
//                txt_S_fuse_Jur_A.setText("");
//                txt_T_fuse_Jur_A.setText("");
//                txt_R_fuse_Jur_C.setText("");
//                txt_S_fuse_Jur_C.setText("");
//                txt_T_fuse_Jur_C.setText("");

            }
        });
        button_jur_C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Jur_C_fuse.setVisibility(View.VISIBLE);
                Jur_A_fuse.setVisibility(View.INVISIBLE);
                Jur_B_fuse.setVisibility(View.INVISIBLE);
                Jur_D_fuse.setVisibility(View.INVISIBLE);
                view.setSelected(true);
                button_jur_B.setSelected(false);
                button_jur_A.setSelected(false);
                button_jur_D.setSelected(false);
//                txt_R_fuse_Jur_A.setText("");
//                txt_S_fuse_Jur_A.setText("");
//                txt_T_fuse_Jur_A.setText("");
//                txt_R_fuse_Jur_C.setText("");
//                txt_S_fuse_Jur_C.setText("");
//                txt_T_fuse_Jur_C.setText("");
            }
        });
        button_jur_D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Jur_D_fuse.setVisibility(View.VISIBLE);
                Jur_A_fuse.setVisibility(View.INVISIBLE);
                Jur_B_fuse.setVisibility(View.INVISIBLE);
                Jur_C_fuse.setVisibility(View.INVISIBLE);
                view.setSelected(true);
                button_jur_B.setSelected(false);
                button_jur_A.setSelected(false);
                button_jur_C.setSelected(false);

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
//                txt_R_NH_Jur_B.setText("");
//                txt_S_NH_Jur_B.setText("");
//                txt_T_NH_Jur_B.setText("");
//                txt_R_NH_Jur_C.setText("");
//                txt_S_NH_Jur_C.setText("");
//                txt_T_NH_Jur_C.setText("");
//                txt_R_NH_Jur_D.setText("");
//                txt_S_NH_Jur_D.setText("");
//                txt_T_NH_Jur_D.setText("");

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
//                txt_R_NH_Jur_A.setText("");
//                txt_S_NH_Jur_A.setText("");
//                txt_T_NH_Jur_A.setText("");
//                txt_R_NH_Jur_C.setText("");
//                txt_S_NH_Jur_C.setText("");
//                txt_T_NH_Jur_C.setText("");
//                txt_R_NH_Jur_D.setText("");
//                txt_S_NH_Jur_D.setText("");
//                txt_T_NH_Jur_D.setText("");

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
//                txt_R_NH_Jur_B.setText("");
//                txt_S_NH_Jur_B.setText("");
//                txt_T_NH_Jur_B.setText("");
//                txt_R_NH_Jur_A.setText("");
//                txt_S_NH_Jur_A.setText("");
//                txt_T_NH_Jur_A.setText("");
//                txt_R_NH_Jur_D.setText("");
//                txt_S_NH_Jur_D.setText("");
//                txt_T_NH_Jur_D.setText("");
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
//                txt_R_NH_Jur_B.setText("");
//                txt_S_NH_Jur_B.setText("");
//                txt_T_NH_Jur_B.setText("");
//                txt_R_NH_Jur_C.setText("");
//                txt_S_NH_Jur_C.setText("");
//                txt_T_NH_Jur_C.setText("");
//                txt_R_NH_Jur_A.setText("");
//                txt_S_NH_Jur_A.setText("");
//                txt_T_NH_Jur_A.setText("");
            }
        });

    }

    public void datakabel() {
        //Jenis Kabel INLET
        final Button btn_inlet_NYY = (Button) findViewById(R.id.jenis_kabel_inlet_NYY);
        final Button btn_inlet_LUTC = (Button) findViewById(R.id.jenis_kabel_inlet_LUTC);
        final Button btn_inlet_NYFUBY = (Button) findViewById(R.id.jenis_kabel_inlet_NYFUBY);
        btn_inlet_NYY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                btn_inlet_LUTC.setSelected(false);
                btn_inlet_NYFUBY.setSelected(false);

            }
        });
        btn_inlet_LUTC.setOnClickListener(new View.OnClickListener() {
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
                btn_inlet_LUTC.setSelected(false);
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
                btn_penampang_95.setSelected(false);
                btn_penampang_150.setSelected(false);
                btn_penampang_240.setSelected(false);

            }
        });
        btn_penampang_95.setOnClickListener(new View.OnClickListener() {
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
                btn_penampang_95.setSelected(false);
                btn_penampang_70.setSelected(false);
                btn_penampang_240.setSelected(false);
            }
        });
        btn_penampang_240.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                btn_penampang_95.setSelected(false);
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
        kabel_jur_A.setSelected(false);
        kabel_jur_B.setSelected(false);
        kabel_jur_C.setSelected(false);
        kabel_jur_D.setSelected(false);

//        //Spinner Jur A
//        final Spinner spinner2 = (Spinner) findViewById(R.id.spin_sambungan_kabel_ke_jtr);
//        final ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, R.layout.spinner, KabelJTR);
//        spinner2.setAdapter(adapter2);

        //Spinner Jur B
//        final Spinner spinner3 = (Spinner) findViewById(R.id.jur_B_spin_sambungan_kabel_ke_jtr);
//        final ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, R.layout.spinner, KabelJTR);

        //Spinner Jur C
//        final Spinner spinner4 = (Spinner) findViewById(R.id.jur_C_spin_sambungan_kabel_ke_jtr);
//        final ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this, R.layout.spinner, KabelJTR);
//
//        //Spinner Jur D
//        final Spinner spinner5 = (Spinner) findViewById(R.id.jur_D_spin_sambungan_kabel_ke_jtr);
//        final ArrayAdapter<String> adapter5 = new ArrayAdapter<String>(this, R.layout.spinner, KabelJTR);

        final Button btn_join_bimetal_jtr_A = (Button) findViewById(R.id.join_bimetal_jurusan_A);
        final Button btn_join_bimetal_jtr_B = (Button) findViewById(R.id.join_bimetal_jurusan_B);
        final Button btn_join_bimetal_jtr_C = (Button) findViewById(R.id.join_bimetal_jurusan_C);
        final Button btn_join_bimetal_jtr_D = (Button) findViewById(R.id.join_bimetal_jurusan_D);

        final Button btn_tap_jtr_A = (Button) findViewById(R.id.tap_jtr_jurusan_A);
        final Button btn_tap_jtr_B = (Button) findViewById(R.id.tap_jtr_jurusan_B);
        final Button btn_tap_jtr_C = (Button) findViewById(R.id.tap_jtr_jurusan_C);
        final Button btn_tap_jtr_D = (Button) findViewById(R.id.tap_jtr_jurusan_D);

        final Button btn_paralel_jtr_A = (Button) findViewById(R.id.paralel_jurusan_A);
        final Button btn_paralel_jtr_B = (Button) findViewById(R.id.paralel_jurusan_B);
        final Button btn_paralel_jtr_C = (Button) findViewById(R.id.paralel_jurusan_C);
        final Button btn_paralel_jtr_D = (Button) findViewById(R.id.paralel_jurusan_D);


        kabel_jur_A.setOnClickListener(new View.OnClickListener() {
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
//                btn_jur_B_outlet_NYY.setSelected(false);
//                btn_jur_B_outlet_LUTC.setSelected(false);
//                btn_jur_B_outlet_NYFUBY.setSelected(false);
//                btn_jur_C_outlet_NYY.setSelected(false);
//                btn_jur_C_outlet_LUTC.setSelected(false);
//                btn_jur_C_outlet_NYFUBY.setSelected(false);
//                btn_jur_D_outlet_NYY.setSelected(false);
//                btn_jur_D_outlet_LUTC.setSelected(false);
//                btn_jur_D_outlet_NYFUBY.setSelected(false);
//                btn_jur_B_penampang_25.setSelected(false);
//                btn_jur_B_penampang_35.setSelected(false);
//                btn_jur_B_penampang_70_out.setSelected(false);
//                btn_jur_B_penampang_95_out.setSelected(false);
//                btn_jur_B_penampang_150_out.setSelected(false);
//                btn_jur_B_penampang_240_out.setSelected(false);
//                btn_jur_C_penampang_25i.setSelected(false);
//                btn_jur_C_penampang_35i.setSelected(false);
//                btn_jur_C_penampang_70i_out.setSelected(false);
//                btn_jur_C_penampang_95i_out.setSelected(false);
//                btn_jur_C_penampang_150i_out.setSelected(false);
//                btn_jur_C_penampang_240i_out.setSelected(false);
//                btn_jur_D_penampang_25.setSelected(false);
//                btn_jur_D_penampang_35.setSelected(false);
//                btn_jur_D_penampang_70_out.setSelected(false);
//                btn_jur_D_penampang_95_out.setSelected(false);
//                btn_jur_D_penampang_150_out.setSelected(false);
//                btn_jur_D_penampang_240_out.setSelected(false);
//                spinner2.setAdapter(adapter2);
//                spinner3.setSelection(0);
//                spinner4.setSelection(0);
//                spinner5.setSelection(0);

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
//                btn_outlet_NYY.setSelected(false);
//                btn_outlet_LUTC.setSelected(false);
//                btn_outlet_NYFUBY.setSelected(false);
//                btn_jur_C_outlet_NYY.setSelected(false);
//                btn_jur_C_outlet_LUTC.setSelected(false);
//                btn_jur_C_outlet_NYFUBY.setSelected(false);
//                btn_jur_D_outlet_NYY.setSelected(false);
//                btn_jur_D_outlet_LUTC.setSelected(false);
//                btn_jur_D_outlet_NYFUBY.setSelected(false);
//                btn_penampang_25.setSelected(false);
//                btn_penampang_35.setSelected(false);
//                btn_penampang_70_out.setSelected(false);
//                btn_penampang_95_out.setSelected(false);
//                btn_penampang_150_out.setSelected(false);
//                btn_penampang_240_out.setSelected(false);
//                btn_jur_C_penampang_25i.setSelected(false);
//                btn_jur_C_penampang_35i.setSelected(false);
//                btn_jur_C_penampang_70i_out.setSelected(false);
//                btn_jur_C_penampang_95i_out.setSelected(false);
//                btn_jur_C_penampang_150i_out.setSelected(false);
//                btn_jur_C_penampang_240i_out.setSelected(false);
//                btn_jur_D_penampang_25.setSelected(false);
//                btn_jur_D_penampang_35.setSelected(false);
//                btn_jur_D_penampang_70_out.setSelected(false);
//                btn_jur_D_penampang_95_out.setSelected(false);
//                btn_jur_D_penampang_150_out.setSelected(false);
//                btn_jur_D_penampang_240_out.setSelected(false);
//                spinner2.setSelection(0);
//                spinner3.setAdapter(adapter3);
//                spinner4.setSelection(0);
//                spinner5.setSelection(0);
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
//                btn_outlet_NYY.setSelected(false);
//                btn_outlet_LUTC.setSelected(false);
//                btn_outlet_NYFUBY.setSelected(false);
//                btn_jur_B_outlet_NYY.setSelected(false);
//                btn_jur_B_outlet_LUTC.setSelected(false);
//                btn_jur_B_outlet_NYFUBY.setSelected(false);
//                btn_jur_D_outlet_NYY.setSelected(false);
//                btn_jur_D_outlet_LUTC.setSelected(false);
//                btn_jur_D_outlet_NYFUBY.setSelected(false);
//                btn_penampang_25.setSelected(false);
//                btn_penampang_35.setSelected(false);
//                btn_penampang_70_out.setSelected(false);
//                btn_penampang_95_out.setSelected(false);
//                btn_penampang_150_out.setSelected(false);
//                btn_penampang_240_out.setSelected(false);
//                btn_jur_B_penampang_25.setSelected(false);
//                btn_jur_B_penampang_35.setSelected(false);
//                btn_jur_B_penampang_70_out.setSelected(false);
//                btn_jur_B_penampang_95_out.setSelected(false);
//                btn_jur_B_penampang_150_out.setSelected(false);
//                btn_jur_B_penampang_240_out.setSelected(false);
//                btn_jur_D_penampang_25.setSelected(false);
//                btn_jur_D_penampang_35.setSelected(false);
//                btn_jur_D_penampang_70_out.setSelected(false);
//                btn_jur_D_penampang_95_out.setSelected(false);
//                btn_jur_D_penampang_150_out.setSelected(false);
//                btn_jur_D_penampang_240_out.setSelected(false);
//                spinner2.setSelection(0);
//                spinner4.setAdapter(adapter4);
//                spinner3.setSelection(0);
//                spinner5.setSelection(0);
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
//                btn_outlet_NYY.setSelected(false);
//                btn_outlet_LUTC.setSelected(false);
//                btn_outlet_NYFUBY.setSelected(false);
//                btn_jur_B_outlet_NYY.setSelected(false);
//                btn_jur_B_outlet_LUTC.setSelected(false);
//                btn_jur_B_outlet_NYFUBY.setSelected(false);
//                btn_jur_C_outlet_NYY.setSelected(false);
//                btn_jur_C_outlet_LUTC.setSelected(false);
//                btn_jur_C_outlet_NYFUBY.setSelected(false);
//                btn_penampang_25.setSelected(false);
//                btn_penampang_35.setSelected(false);
//                btn_penampang_70_out.setSelected(false);
//                btn_penampang_95_out.setSelected(false);
//                btn_penampang_150_out.setSelected(false);
//                btn_penampang_240_out.setSelected(false);
//                btn_jur_B_penampang_25.setSelected(false);
//                btn_jur_B_penampang_35.setSelected(false);
//                btn_jur_B_penampang_70_out.setSelected(false);
//                btn_jur_B_penampang_95_out.setSelected(false);
//                btn_jur_B_penampang_150_out.setSelected(false);
//                btn_jur_B_penampang_240_out.setSelected(false);
//                btn_jur_C_penampang_25i.setSelected(false);
//                btn_jur_C_penampang_35i.setSelected(false);
//                btn_jur_C_penampang_70i_out.setSelected(false);
//                btn_jur_C_penampang_95i_out.setSelected(false);
//                btn_jur_C_penampang_150i_out.setSelected(false);
//                btn_jur_C_penampang_240i_out.setSelected(false);
//                spinner2.setSelection(0);
//                spinner5.setAdapter(adapter5);
//                spinner3.setSelection(0);
//                spinner4.setSelection(0);
            }
        });

        //Jenis Kabel
        //Jur A
        btn_outlet_NYY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                btn_outlet_LUTC.setSelected(false);
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
                btn_outlet_LUTC.setSelected(false);
                btn_outlet_NYY.setSelected(false);

            }
        });

        //Jur B
        btn_jur_B_outlet_NYY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                btn_jur_B_outlet_LUTC.setSelected(false);
                btn_jur_B_outlet_NYFUBY.setSelected(false);

            }
        });
        btn_jur_B_outlet_LUTC.setOnClickListener(new View.OnClickListener() {
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
                btn_jur_B_outlet_LUTC.setSelected(false);
                btn_jur_B_outlet_NYY.setSelected(false);
            }
        });


        //Jur C
        btn_jur_C_outlet_NYY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                btn_jur_C_outlet_LUTC.setSelected(false);
                btn_jur_C_outlet_NYFUBY.setSelected(false);

            }
        });
        btn_jur_C_outlet_LUTC.setOnClickListener(new View.OnClickListener() {
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
                btn_jur_C_outlet_LUTC.setSelected(false);
                btn_jur_C_outlet_NYY.setSelected(false);
            }
        });

        //Jur D
        btn_jur_D_outlet_NYY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                btn_jur_D_outlet_LUTC.setSelected(false);
                btn_jur_D_outlet_NYFUBY.setSelected(false);

            }
        });
        btn_jur_D_outlet_LUTC.setOnClickListener(new View.OnClickListener() {
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
                btn_jur_D_outlet_LUTC.setSelected(false);
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
        btn_penampang_35.setOnClickListener(new View.OnClickListener() {
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
                btn_penampang_35.setSelected(false);
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
                btn_penampang_35.setSelected(false);
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
                btn_penampang_35.setSelected(false);
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
                btn_penampang_35.setSelected(false);
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
                btn_jur_B_penampang_35.setSelected(false);
                btn_jur_B_penampang_70_out.setSelected(false);
                btn_jur_B_penampang_95_out.setSelected(false);
                btn_jur_B_penampang_150_out.setSelected(false);
                btn_jur_B_penampang_240_out.setSelected(false);

            }
        });
        btn_jur_B_penampang_35.setOnClickListener(new View.OnClickListener() {
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
                btn_jur_B_penampang_35.setSelected(false);
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
                btn_jur_B_penampang_35.setSelected(false);
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
                btn_jur_B_penampang_35.setSelected(false);
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
                btn_jur_B_penampang_35.setSelected(false);
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
                btn_jur_C_penampang_35i.setSelected(false);
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
                btn_jur_C_penampang_35i.setSelected(false);
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
                btn_jur_C_penampang_35i.setSelected(false);
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
                btn_jur_C_penampang_35i.setSelected(false);
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
                btn_jur_D_penampang_35.setSelected(false);
                btn_jur_D_penampang_70_out.setSelected(false);
                btn_jur_D_penampang_95_out.setSelected(false);
                btn_jur_D_penampang_150_out.setSelected(false);
                btn_jur_D_penampang_240_out.setSelected(false);

            }
        });
        btn_jur_D_penampang_35.setOnClickListener(new View.OnClickListener() {
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
                btn_jur_D_penampang_35.setSelected(false);
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
                btn_jur_D_penampang_35.setSelected(false);
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
                btn_jur_D_penampang_35.setSelected(false);
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
                btn_jur_D_penampang_35.setSelected(false);
                btn_jur_D_penampang_25.setSelected(false);
                btn_jur_D_penampang_70_out.setSelected(false);
                btn_jur_D_penampang_95_out.setSelected(false);
                btn_jur_D_penampang_150_out.setSelected(false);
            }
        });

        //jurusan_A
        btn_join_bimetal_jtr_A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                btn_tap_jtr_A.setSelected(false);
                btn_paralel_jtr_A.setSelected(false);
            }
        });


        btn_tap_jtr_A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                btn_join_bimetal_jtr_A.setSelected(false);
                btn_paralel_jtr_A.setSelected(false);
            }
        });

        btn_paralel_jtr_A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                btn_join_bimetal_jtr_A.setSelected(false);
                btn_tap_jtr_A.setSelected(false);
            }
        });

        //jurusan_B
        btn_join_bimetal_jtr_B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                btn_tap_jtr_B.setSelected(false);
                btn_paralel_jtr_B.setSelected(false);
            }
        });


        btn_tap_jtr_B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                btn_join_bimetal_jtr_B.setSelected(false);
                btn_paralel_jtr_B.setSelected(false);
            }
        });

        btn_paralel_jtr_B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                btn_join_bimetal_jtr_B.setSelected(false);
                btn_tap_jtr_B.setSelected(false);
            }
        });

        //jurusan_C
        btn_join_bimetal_jtr_C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                btn_tap_jtr_C.setSelected(false);
                btn_paralel_jtr_C.setSelected(false);
            }
        });


        btn_tap_jtr_C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                btn_join_bimetal_jtr_C.setSelected(false);
                btn_paralel_jtr_C.setSelected(false);
            }
        });

        btn_paralel_jtr_C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                btn_join_bimetal_jtr_C.setSelected(false);
                btn_tap_jtr_C.setSelected(false);
            }
        });

        //jurusan_D
        btn_join_bimetal_jtr_D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                btn_tap_jtr_D.setSelected(false);
                btn_paralel_jtr_D.setSelected(false);
            }
        });


        btn_tap_jtr_D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                btn_join_bimetal_jtr_D.setSelected(false);
                btn_paralel_jtr_D.setSelected(false);
            }
        });

        btn_paralel_jtr_D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setSelected(true);
                btn_join_bimetal_jtr_D.setSelected(false);
                btn_tap_jtr_D.setSelected(false);
            }
        });

    }

    private ModelForm model_form_manager() {
        ModelForm modelForm = new ModelForm();

        final EditText f_petugas = (EditText) findViewById(R.id.f_petugas);
        final EditText f_kapel = (EditText) findViewById(R.id.f_kapel);
        final EditText f_kode_gardu = (EditText) findViewById(R.id.f_kode_gardu);
        final Spinner spin_penyulang = (Spinner) findViewById(R.id.spin_penyulang);

        final EditText f_daya = (EditText) findViewById(R.id.f_daya);
        final EditText f_merk = (EditText) findViewById(R.id.f_merk);
        final EditText f_noserie = (EditText) findViewById(R.id.f_noserie);
        final EditText f_jlh_fasa = (EditText) findViewById(R.id.f_jlh_fasa);
        final EditText f_tap_operasi = (EditText) findViewById(R.id.f_tap_operasi);
        final EditText f_kons_trafo = (EditText) findViewById(R.id.f_kons_trafo);
        //Button Rekondisi
        final Button button_ya_rek = (Button) findViewById(R.id.rekondisi_ya);
        final Button button_tdk_rek = (Button) findViewById(R.id.rekondisi_tidak);

        final EditText f_tahun_pembuatan = (EditText) findViewById(R.id.f_tahun_pembuatan);
        //Button Kunci Gardu
        final Button button_ya = (Button) findViewById(R.id.kunci_gardu_ya);
        final Button button_tdk = (Button) findViewById(R.id.kunci_gardu_tidak);
        //Button Kokon
        final Button button_ya_kokon = (Button) findViewById(R.id.kokon_ya);
        final Button button_tdk_kokon = (Button) findViewById(R.id.kokon_tidak);
        //Schoon Trafo (DI TR)
        final Button button_3 = (Button) findViewById(R.id.Schoon_Trafo_1);
        final Button button_2 = (Button) findViewById(R.id.Schoon_Trafo_2);
        final Button button_1 = (Button) findViewById(R.id.Schoon_Trafo_3);
        final Button button_0 = (Button) findViewById(R.id.Schoon_Trafo_4);

        final EditText f_kebutuhan_schoon_PHB = (EditText) findViewById(R.id.f_kebutuhan_schoon_PHB);
        final EditText f_primer_phasa_r = (EditText) findViewById(R.id.f_primer_phasa_r);
        final EditText f_primer_phasa_s = (EditText) findViewById(R.id.f_primer_phasa_s);
        final EditText f_primer_phasa_t = (EditText) findViewById(R.id.f_primer_phasa_t);
        final EditText f_saklar_merk = (EditText) findViewById(R.id.f_saklar_merk);
        final EditText f_saklar_arus = (EditText) findViewById(R.id.f_saklar_arus);
        final Button button_ya_phb = (Button) findViewById(R.id.saklar_utama_phb_ya);
        final Button button_tidak_phb = (Button) findViewById(R.id.saklar_utama_phb_tidak);

        final Button fuse_jurusan_A = (Button) findViewById(R.id.fuse_jurusan_A);
        final EditText f_fuse_R_Jur_A = (EditText) findViewById(R.id.f_fuse_R_Jur_A);
        final EditText f_fuse_S_Jur_A = (EditText) findViewById(R.id.f_fuse_S_Jur_A);
        final EditText f_fuse_T_Jur_A = (EditText) findViewById(R.id.f_fuse_T_Jur_A);

        final Button fuse_jurusan_B = (Button) findViewById(R.id.fuse_jurusan_B);
        final EditText f_fuse_R_Jur_B = (EditText) findViewById(R.id.f_fuse_R_Jur_B);
        final EditText f_fuse_S_Jur_B = (EditText) findViewById(R.id.f_fuse_S_Jur_B);
        final EditText f_fuse_T_Jur_B = (EditText) findViewById(R.id.f_fuse_T_Jur_B);

        final Button fuse_jurusan_C = (Button) findViewById(R.id.fuse_jurusan_C);
        final EditText f_fuse_R_Jur_C = (EditText) findViewById(R.id.f_fuse_R_Jur_C);
        final EditText f_fuse_S_Jur_C = (EditText) findViewById(R.id.f_fuse_S_Jur_C);
        final EditText f_fuse_T_Jur_C = (EditText) findViewById(R.id.f_fuse_T_Jur_C);

        final Button NH_jurusan_A = (Button) findViewById(R.id.NH_jurusan_A);
        final EditText f_NH_R_Jur_A = (EditText) findViewById(R.id.f_NH_R_Jur_A);
        final EditText f_NH_S_Jur_A = (EditText) findViewById(R.id.f_NH_S_Jur_A);
        final EditText f_NH_T_Jur_A = (EditText) findViewById(R.id.f_NH_T_Jur_A);

        final Button NH_jurusan_B = (Button) findViewById(R.id.NH_jurusan_B);
        final EditText f_NH_R_Jur_B = (EditText) findViewById(R.id.f_NH_R_Jur_B);
        final EditText f_NH_S_Jur_B = (EditText) findViewById(R.id.f_NH_S_Jur_B);
        final EditText f_NH_T_Jur_B = (EditText) findViewById(R.id.f_NH_T_Jur_B);

        final Button NH_jurusan_C = (Button) findViewById(R.id.NH_jurusan_C);
        final EditText f_NH_R_Jur_C = (EditText) findViewById(R.id.f_NH_R_Jur_C);
        final EditText f_NH_S_Jur_C = (EditText) findViewById(R.id.f_NH_S_Jur_C);
        final EditText f_NH_T_Jur_C = (EditText) findViewById(R.id.f_NH_T_Jur_C);

        final Button NH_jurusan_D = (Button) findViewById(R.id.NH_jurusan_D);
        final EditText f_NH_R_Jur_D = (EditText) findViewById(R.id.f_NH_R_Jur_D);
        final EditText f_NH_S_Jur_D = (EditText) findViewById(R.id.f_NH_S_Jur_D);
        final EditText f_NH_T_Jur_D = (EditText) findViewById(R.id.f_NH_T_Jur_D);

        final EditText f_arrester = (EditText) findViewById(R.id.f_arrester);
        final EditText f_saklar_tahanan_arrester = (EditText) findViewById(R.id.f_saklar_tahanan_arrester);
        final EditText f_saklar_tahanan_netral = (EditText) findViewById(R.id.f_saklar_tahanan_netral);
        final EditText f_body_trafo = (EditText) findViewById(R.id.f_body_trafo);
        //Jenis Kabel INLET
        final Button btn_inlet_NYY = (Button) findViewById(R.id.jenis_kabel_inlet_NYY);
        final Button btn_inlet_LUTC = (Button) findViewById(R.id.jenis_kabel_inlet_LUTC);
        final Button btn_inlet_NYFUBY = (Button) findViewById(R.id.jenis_kabel_inlet_NYFUBY);
        //Penampang INLET
        final Button btn_penampang_70 = (Button) findViewById(R.id.penampang_inlet_70);
        final Button btn_penampang_95 = (Button) findViewById(R.id.penampang_inlet_95);
        final Button btn_penampang_150 = (Button) findViewById(R.id.penampang_inlet_150);
        final Button btn_penampang_240 = (Button) findViewById(R.id.penampang_inlet_240);
        //Jenis Kabel Outlet
        final Button data_kabel_jurusan_A = (Button) findViewById(R.id.data_kabel_jurusan_A);
        final Button data_kabel_jurusan_B = (Button) findViewById(R.id.data_kabel_jurusan_B);
        final Button data_kabel_jurusan_C = (Button) findViewById(R.id.data_kabel_jurusan_C);
        final Button data_kabel_jurusan_D = (Button) findViewById(R.id.data_kabel_jurusan_D);
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
        //Spinner Jur A
        final Spinner spinner2 = (Spinner) findViewById(R.id.spin_sambungan_kabel_ke_jtr);
        //Spinner Jur B
        final Spinner spinner3 = (Spinner) findViewById(R.id.jur_B_spin_sambungan_kabel_ke_jtr);
        //Spinner Jur C
        final Spinner spinner4 = (Spinner) findViewById(R.id.jur_C_spin_sambungan_kabel_ke_jtr);
        //Spinner Jur D
        final Spinner spinner5 = (Spinner) findViewById(R.id.jur_D_spin_sambungan_kabel_ke_jtr);

        final EditText editText_Lain = (EditText) findViewById(R.id.edit_text_keterangan);

        //first
        String petugas = f_petugas.getText().toString();
        String kapel = f_kapel.getText().toString();
        String kode_gardu = f_kode_gardu.getText().toString();
        //spinner
        String penyulang = spin_penyulang.getSelectedItem().toString();
        //=====
        String daya = f_daya.getText().toString();
        String merk = f_merk.getText().toString();
        String noserie = f_noserie.getText().toString();
        String jlh_fasa = f_jlh_fasa.getText().toString();
        String tap_operasi = f_tap_operasi.getText().toString();
        String kons_trafo = f_kons_trafo.getText().toString();

        //button ya tidak
        String rekondisi = "";
        if (button_ya_rek.isSelected()) {
            rekondisi = "ya";
        } else if (button_tdk_rek.isSelected()) {
            rekondisi = "tidak";
        }


        //=====

        String tahun_pembuatan = f_tahun_pembuatan.getText().toString();
        //button ya tidak
        String kunci_gardu = "";
        if (button_ya.isSelected()) {
            kunci_gardu = "ya";
        } else if (button_tdk.isSelected()) {
            kunci_gardu = "tidak";
        }

        //=====
        //button ya tidak
        String kokon = "";
        if (button_ya_kokon.isSelected()) {
            kokon = "ya";
        } else if (button_tdk_kokon.isSelected()) {
            kokon = "tidak";
        }

        //=====
        //button angka 3 2 1 0
        String schoon_trafo = "";
        if (button_3.isSelected()) {
            schoon_trafo = "3";
        } else if (button_2.isSelected()) {
            schoon_trafo = "2";
        } else if (button_1.isSelected()) {
            schoon_trafo = "1";
        } else if (button_0.isSelected()) {
            schoon_trafo = "0";
        }


        //=====
        String kebutuhan_schoon_PHB = f_kebutuhan_schoon_PHB.getText().toString();
        //Data Pengaman Trafo
        String primer_phasa_r = f_primer_phasa_r.getText().toString();
        String primer_phasa_s = f_primer_phasa_s.getText().toString();
        String primer_phasa_t = f_primer_phasa_t.getText().toString();
        String saklar_merk = f_saklar_merk.getText().toString();
        String saklar_arus = f_saklar_arus.getText().toString();
        String saklar_utama_phb="";
        if (button_ya_phb.isSelected()) {
            saklar_utama_phb="Ya";
        }else if (button_tidak_phb.isSelected()) {
            saklar_utama_phb="tidak";
        }
        String fuse_jurusan = "";
        if (fuse_jurusan_A.isSelected()) {
            fuse_jurusan = "jurusan A";
        } else if (fuse_jurusan_B.isSelected()) {
            fuse_jurusan = "jurusan B";
        } else if (fuse_jurusan_C.isSelected()) {
            fuse_jurusan = "jurusan C";
        }
        String fuse_R_Jur_A = f_fuse_R_Jur_A.getText().toString();
        String fuse_S_Jur_A = f_fuse_S_Jur_A.getText().toString();
        String fuse_T_Jur_A = f_fuse_T_Jur_A.getText().toString();
        String fuse_R_Jur_B = f_fuse_R_Jur_B.getText().toString();
        String fuse_S_Jur_B = f_fuse_S_Jur_B.getText().toString();
        String fuse_T_Jur_B = f_fuse_T_Jur_B.getText().toString();
        String fuse_R_Jur_C = f_fuse_R_Jur_C.getText().toString();
        String fuse_S_Jur_C = f_fuse_S_Jur_C.getText().toString();
        String fuse_T_Jur_C = f_fuse_T_Jur_C.getText().toString();
        String nh_jurusan = "";
        if (NH_jurusan_A.isSelected()) {
            nh_jurusan = "jurusan A";
        } else if (NH_jurusan_B.isSelected()) {
            nh_jurusan = "jurusan B";
        } else if (NH_jurusan_C.isSelected()) {
            nh_jurusan = "jurusan C";
        } else if (NH_jurusan_D.isSelected()) {
            nh_jurusan = "jurusan D";
        }
        String NH_R_Jur_A = f_NH_R_Jur_A.getText().toString();
        String NH_S_Jur_A = f_NH_S_Jur_A.getText().toString();
        String NH_T_Jur_A = f_NH_T_Jur_A.getText().toString();
        String NH_R_Jur_B = f_NH_R_Jur_B.getText().toString();
        String NH_S_Jur_B = f_NH_S_Jur_B.getText().toString();
        String NH_T_Jur_B = f_NH_T_Jur_B.getText().toString();
        String NH_R_Jur_C = f_NH_R_Jur_C.getText().toString();
        String NH_S_Jur_C = f_NH_S_Jur_C.getText().toString();
        String NH_T_Jur_C = f_NH_T_Jur_C.getText().toString();
        String NH_R_Jur_D = f_NH_R_Jur_D.getText().toString();
        String NH_S_Jur_D = f_NH_S_Jur_D.getText().toString();
        String NH_T_Jur_D = f_NH_T_Jur_D.getText().toString();
        String arrester = f_arrester.getText().toString();
        //===============
        //Data Pertahanan
        String saklar_tahanan_arrester = f_saklar_tahanan_arrester.getText().toString();
        String saklar_tahanan_netral = f_saklar_tahanan_netral.getText().toString();
        String body_trafo = f_body_trafo.getText().toString();
        //=============
        //Data Kabel

        //button nyy lvtc nyfgby
        String kabel_inlet = "";

        if (btn_inlet_NYY.isSelected()) {
            kabel_inlet = "NYY";
        } else if (btn_inlet_LUTC.isSelected()) {
            kabel_inlet = "LUTC";
        } else if (btn_inlet_NYFUBY.isSelected()) {
            kabel_inlet = "NYFUBY";
        }


        //=====
        //button 70 95 150 240
        String penampang_inlet = "";
        if (btn_penampang_70.isSelected()) {
            penampang_inlet = "70";
        } else if (btn_penampang_95.isSelected()) {
            penampang_inlet = "95";
        } else if (btn_penampang_150.isSelected()) {
            penampang_inlet = "150";
        } else if (btn_penampang_240.isSelected()) {
            penampang_inlet = "240";
        }


        //Jenis Kabel Outlet
        String data_kabel_jurusan = "";
        String jenis_kabel_jurusan_a = "";
        String penampang_jurusan_a = "";
        String sambung_kabel_jtr_jurusan_a="";
        String jenis_kabel_jurusan_b = "";
        String penampang_jurusan_b = "";
        String sambung_kabel_jtr_jurusan_b="";
        String jenis_kabel_jurusan_c = "";
        String penampang_jurusan_c = "";
        String sambung_kabel_jtr_jurusan_c="";
        String jenis_kabel_jurusan_d = "";
        String penampang_jurusan_d = "";
        String sambung_kabel_jtr_jurusan_d="";
        if (data_kabel_jurusan_A.isSelected()) {
            data_kabel_jurusan = "jurusan A";
            //button jnyy lvtc nyfgby

            if (btn_outlet_NYY.isSelected()) {
                jenis_kabel_jurusan_a = "NYY";
            } else if (btn_outlet_LUTC.isSelected()) {
                jenis_kabel_jurusan_a = "LVTC";
            } else if (btn_outlet_NYFUBY.isSelected()) {
                jenis_kabel_jurusan_a = "NYFGBY";
            }

            //=====
            //button 25 35 70 95 150

            if (btn_penampang_25.isSelected()) {
                penampang_jurusan_a = "25";
            } else if (btn_penampang_35.isSelected()) {
                penampang_jurusan_a = "35";
            } else if (btn_penampang_70_out.isSelected()) {
                penampang_jurusan_a = "70";
            } else if (btn_penampang_95_out.isSelected()) {
                penampang_jurusan_a = "95";
            } else if (btn_penampang_150_out.isSelected()) {
                penampang_jurusan_a = "150";
            } else if (btn_penampang_240_out.isSelected()) {
                penampang_jurusan_a = "240";
            }
            //=====
            //spinner
            sambung_kabel_jtr_jurusan_a = spinner2.getSelectedItem().toString();
            //=====
        } else if (data_kabel_jurusan_B.isSelected()) {
            data_kabel_jurusan = "jurusan B";

            //button jnyy lvtc nyfgby

            if (btn_jur_B_outlet_NYY.isSelected()) {
                jenis_kabel_jurusan_b = "NYY";
            } else if (btn_jur_B_outlet_LUTC.isSelected()) {
                jenis_kabel_jurusan_b = "LVTC";
            } else if (btn_jur_B_outlet_NYFUBY.isSelected()) {
                jenis_kabel_jurusan_b = "NYFGBY";
            }
            //=====
            //button 25 35 70 95 150

            if (btn_jur_B_penampang_25.isSelected()) {
                penampang_jurusan_b = "25";
            } else if (btn_jur_B_penampang_35.isSelected()) {
                penampang_jurusan_b = "35";
            } else if (btn_jur_B_penampang_70_out.isSelected()) {
                penampang_jurusan_b = "70";
            } else if (btn_jur_B_penampang_95_out.isSelected()) {
                penampang_jurusan_b = "95";
            } else if (btn_jur_B_penampang_150_out.isSelected()) {
                penampang_jurusan_b = "150";
            } else if (btn_jur_B_penampang_240_out.isSelected()) {
                penampang_jurusan_b = "240";
            }
            //=====
            //spinner
            sambung_kabel_jtr_jurusan_b = spinner3.getSelectedItem().toString();
            //=====
        } else if (data_kabel_jurusan_C.isSelected()) {
            data_kabel_jurusan = "jurusan C";

            //button jnyy lvtc nyfgby

            if (btn_jur_C_outlet_NYY.isSelected()) {
                jenis_kabel_jurusan_c = "NYY";
            } else if (btn_jur_C_outlet_LUTC.isSelected()) {
                jenis_kabel_jurusan_c = "LVTC";
            } else if (btn_jur_C_outlet_NYFUBY.isSelected()) {
                jenis_kabel_jurusan_c = "NYFGBY";
            }
            //=====
            //button 25 35 70 95 150

            if (btn_jur_C_penampang_25i.isSelected()) {
                penampang_jurusan_c = "25";
            } else if (btn_jur_C_penampang_35i.isSelected()) {
                penampang_jurusan_c = "35";
            } else if (btn_jur_C_penampang_70i_out.isSelected()) {
                penampang_jurusan_c = "70";
            } else if (btn_jur_C_penampang_95i_out.isSelected()) {
                penampang_jurusan_c = "95";
            } else if (btn_jur_C_penampang_150i_out.isSelected()) {
                penampang_jurusan_c = "150";
            } else if (btn_jur_C_penampang_240i_out.isSelected()) {
                penampang_jurusan_c = "240";
            }
            //=====
            //spinner
           sambung_kabel_jtr_jurusan_c = spinner4.getSelectedItem().toString();
            //=====
        } else if (data_kabel_jurusan_D.isSelected()) {
            data_kabel_jurusan = "jurusan D";

            //button jnyy lvtc nyfgby

            if (btn_jur_D_outlet_NYY.isSelected()) {
                jenis_kabel_jurusan_d = "NYY";
            } else if (btn_jur_D_outlet_LUTC.isSelected()) {
                jenis_kabel_jurusan_d = "LVTC";
            } else if (btn_jur_D_outlet_NYFUBY.isSelected()) {
                jenis_kabel_jurusan_d = "NYFGBY";
            }
            //=====
            //button 25 35 70 95 150

            if (btn_jur_D_penampang_25.isSelected()) {
                penampang_jurusan_d = "25";
            } else if (btn_jur_D_penampang_35.isSelected()) {
                penampang_jurusan_d = "35";
            } else if (btn_jur_D_penampang_70_out.isSelected()) {
                penampang_jurusan_d = "70";
            } else if (btn_jur_D_penampang_95_out.isSelected()) {
                penampang_jurusan_d = "95";
            } else if (btn_jur_D_penampang_150_out.isSelected()) {
                penampang_jurusan_d = "150";
            } else if (btn_jur_D_penampang_240_out.isSelected()) {
                penampang_jurusan_d = "240";
            }
            //=====
            //spinner
           sambung_kabel_jtr_jurusan_d = spinner5.getSelectedItem().toString();
            //=====
        }

        //=======================
        SupportManager supportManager = new SupportManager();
        String tanggal = supportManager.get_date_now();

        String alamat = supportManager.getCompleteAddressString(gpsTracker.getLatitude(), gpsTracker.getLongitude(), getApplicationContext());
        modelForm.setAlamat(alamat);
        modelForm.setTanggal(tanggal);
        modelForm.setPetugas(petugas);
        modelForm.setKapel(kapel);
        modelForm.setKode_gardu(kode_gardu);
        modelForm.setPenyulang(penyulang);
        modelForm.setDaya(daya);
        modelForm.setMerk(merk);
        modelForm.setNoserie(noserie);
        modelForm.setJlh_fasa(jlh_fasa);
        modelForm.setTap_operasi(tap_operasi);
        modelForm.setKons_trafo(kons_trafo);
        modelForm.setRekondisi(rekondisi);
        modelForm.setTahun_pembuatan(tahun_pembuatan);
        modelForm.setKunci_gardu(kunci_gardu);
        modelForm.setKokon(kokon);
        modelForm.setSchoon_trafo(schoon_trafo);
        modelForm.setKebutuhan_schoon_PHB(kebutuhan_schoon_PHB);
        modelForm.setPrimer_phasa_r(primer_phasa_r);
        modelForm.setPrimer_phasa_s(primer_phasa_s);
        modelForm.setPrimer_phasa_t(primer_phasa_t);
        modelForm.setSaklar_merk(saklar_merk);
        modelForm.setSaklar_arus(saklar_arus);
        modelForm.setSaklar_utama_phb(saklar_utama_phb);
        modelForm.setFuse_jurusan(fuse_jurusan);
        modelForm.setFuse_R_Jur_A(fuse_R_Jur_A);
        modelForm.setFuse_S_Jur_A(fuse_S_Jur_A);
        modelForm.setFuse_T_Jur_A(fuse_T_Jur_A);
        modelForm.setFuse_R_Jur_B(fuse_R_Jur_B);
        modelForm.setFuse_S_Jur_B(fuse_S_Jur_B);
        modelForm.setFuse_T_Jur_B(fuse_T_Jur_B);
        modelForm.setFuse_R_Jur_C(fuse_R_Jur_C);
        modelForm.setFuse_S_Jur_C(fuse_S_Jur_C);
        modelForm.setFuse_T_Jur_C(fuse_T_Jur_C);
        modelForm.setNh_jurusan(nh_jurusan);
        modelForm.setNH_R_Jur_A(NH_R_Jur_A);
        modelForm.setNH_S_Jur_A(NH_S_Jur_A);
        modelForm.setNH_T_Jur_A(NH_T_Jur_A);
        modelForm.setNH_R_Jur_B(NH_R_Jur_B);
        modelForm.setNH_S_Jur_B(NH_S_Jur_B);
        modelForm.setNH_T_Jur_B(NH_T_Jur_B);
        modelForm.setNH_R_Jur_C(NH_R_Jur_C);
        modelForm.setNH_S_Jur_C(NH_S_Jur_C);
        modelForm.setNH_T_Jur_C(NH_T_Jur_C);
        modelForm.setNH_R_Jur_D(NH_R_Jur_D);
        modelForm.setNH_S_Jur_D(NH_S_Jur_D);
        modelForm.setNH_T_Jur_D(NH_T_Jur_D);
        modelForm.setArrester(arrester);
        modelForm.setSaklar_tahanan_arrester(saklar_tahanan_arrester);
        modelForm.setSaklar_tahanan_netral(saklar_tahanan_netral);
        modelForm.setBody_trafo(body_trafo);
        modelForm.setKabel_inlet(kabel_inlet);
        modelForm.setPenampang_inlet(penampang_inlet);
        modelForm.setData_kabel_jurusan(data_kabel_jurusan);
        modelForm.setJenis_kabel_jurusan_a(jenis_kabel_jurusan_a);
        modelForm.setPenampang_jurusan_a(penampang_jurusan_a);
        modelForm.setSambung_kabel_jtr_jurusan_a(sambung_kabel_jtr_jurusan_a);
        modelForm.setJenis_kabel_jurusan_b( jenis_kabel_jurusan_b);
        modelForm.setPenampang_jurusan_b( penampang_jurusan_b);
        modelForm.setSambung_kabel_jtr_jurusan_b(sambung_kabel_jtr_jurusan_b);
        modelForm.setJenis_kabel_jurusan_c( jenis_kabel_jurusan_c);
        modelForm.setPenampang_jurusan_c( penampang_jurusan_c);
        modelForm.setSambung_kabel_jtr_jurusan_c( sambung_kabel_jtr_jurusan_c);
        modelForm.setJenis_kabel_jurusan_d( jenis_kabel_jurusan_d);
        modelForm.setPenampang_jurusan_d( penampang_jurusan_d);
        modelForm.setSambung_kabel_jtr_jurusan_d( sambung_kabel_jtr_jurusan_d);
        return modelForm;
    }

    private boolean check_error() {
        final boolean[] check = {false};
        final EditText f_petugas = (EditText) findViewById(R.id.f_petugas);
        final EditText f_kapel = (EditText) findViewById(R.id.f_kapel);
        final EditText f_kode_gardu = (EditText) findViewById(R.id.f_kode_gardu);
        final EditText f_daya = (EditText) findViewById(R.id.f_daya);
        final EditText f_merk = (EditText) findViewById(R.id.f_merk);
        final EditText f_noserie = (EditText) findViewById(R.id.f_noserie);
        final EditText f_jlh_fasa = (EditText) findViewById(R.id.f_jlh_fasa);
        final EditText f_tap_operasi = (EditText) findViewById(R.id.f_tap_operasi);
        final EditText f_kons_trafo = (EditText) findViewById(R.id.f_kons_trafo);
        final EditText f_tahun_pembuatan = (EditText) findViewById(R.id.f_tahun_pembuatan);
        final EditText f_kebutuhan_schoon_PHB = (EditText) findViewById(R.id.f_kebutuhan_schoon_PHB);
        final EditText f_primer_phasa_r = (EditText) findViewById(R.id.f_primer_phasa_r);
        final EditText f_primer_phasa_s = (EditText) findViewById(R.id.f_primer_phasa_s);
        final EditText f_primer_phasa_t = (EditText) findViewById(R.id.f_primer_phasa_t);
        final EditText f_saklar_merk = (EditText) findViewById(R.id.f_saklar_merk);
        final EditText f_saklar_arus = (EditText) findViewById(R.id.f_saklar_arus);
        final EditText f_fuse_R_Jur_A = (EditText) findViewById(R.id.f_fuse_R_Jur_A);
        final EditText f_fuse_S_Jur_A = (EditText) findViewById(R.id.f_fuse_S_Jur_A);
        final EditText f_fuse_T_Jur_A = (EditText) findViewById(R.id.f_fuse_T_Jur_A);
        final EditText f_fuse_R_Jur_B = (EditText) findViewById(R.id.f_fuse_R_Jur_B);
        final EditText f_fuse_S_Jur_B = (EditText) findViewById(R.id.f_fuse_S_Jur_B);
        final EditText f_fuse_T_Jur_B = (EditText) findViewById(R.id.f_fuse_T_Jur_B);
        final EditText f_fuse_R_Jur_C = (EditText) findViewById(R.id.f_fuse_R_Jur_C);
        final EditText f_fuse_S_Jur_C = (EditText) findViewById(R.id.f_fuse_S_Jur_C);
        final EditText f_fuse_T_Jur_C = (EditText) findViewById(R.id.f_fuse_T_Jur_C);
        final EditText f_NH_R_Jur_A = (EditText) findViewById(R.id.f_NH_R_Jur_A);
        final EditText f_NH_S_Jur_A = (EditText) findViewById(R.id.f_NH_S_Jur_A);
        final EditText f_NH_T_Jur_A = (EditText) findViewById(R.id.f_NH_T_Jur_A);
        final EditText f_NH_R_Jur_B = (EditText) findViewById(R.id.f_NH_R_Jur_B);
        final EditText f_NH_S_Jur_B = (EditText) findViewById(R.id.f_NH_S_Jur_B);
        final EditText f_NH_T_Jur_B = (EditText) findViewById(R.id.f_NH_T_Jur_B);
        final EditText f_NH_R_Jur_C = (EditText) findViewById(R.id.f_NH_R_Jur_C);
        final EditText f_NH_S_Jur_C = (EditText) findViewById(R.id.f_NH_S_Jur_C);
        final EditText f_NH_T_Jur_C = (EditText) findViewById(R.id.f_NH_T_Jur_C);
        final EditText f_NH_R_Jur_D = (EditText) findViewById(R.id.f_NH_R_Jur_D);
        final EditText f_NH_S_Jur_D = (EditText) findViewById(R.id.f_NH_S_Jur_D);
        final EditText f_NH_T_Jur_D = (EditText) findViewById(R.id.f_NH_T_Jur_D);
        final EditText f_arrester = (EditText) findViewById(R.id.f_arrester);
        final EditText f_saklar_tahanan_arrester = (EditText) findViewById(R.id.f_saklar_tahanan_arrester);
        final EditText f_saklar_tahanan_netral = (EditText) findViewById(R.id.f_saklar_tahanan_netral);
        final EditText f_body_trafo = (EditText) findViewById(R.id.f_body_trafo);


        if (TextUtils.isEmpty(f_petugas.getText())) {

            f_petugas.setError(getResources().getString(R.string.pesan_eror));
            check[0] = true;
        }

        if (TextUtils.isEmpty(f_kapel.getText())) {

            f_kapel.setError(getResources().getString(R.string.pesan_eror));
            check[0] = true;
        }

        if (TextUtils.isEmpty(f_kode_gardu.getText())) {

            f_kode_gardu.setError(getResources().getString(R.string.pesan_eror));
            check[0] = true;
        }

        if (TextUtils.isEmpty(f_daya.getText())) {

            f_daya.setError(getResources().getString(R.string.pesan_eror));
            check[0] = true;
        }

        if (TextUtils.isEmpty(f_merk.getText())) {

            f_merk.setError(getResources().getString(R.string.pesan_eror));
            check[0] = true;
        }

        if (TextUtils.isEmpty(f_noserie.getText())) {

            f_noserie.setError(getResources().getString(R.string.pesan_eror));
            check[0] = true;
        }

        if (TextUtils.isEmpty(f_jlh_fasa.getText())) {

            f_jlh_fasa.setError(getResources().getString(R.string.pesan_eror));
            check[0] = true;
        }

        if (TextUtils.isEmpty(f_tap_operasi.getText())) {

            f_tap_operasi.setError(getResources().getString(R.string.pesan_eror));
            check[0] = true;
        }

        if (TextUtils.isEmpty(f_kons_trafo.getText())) {

            f_kons_trafo.setError(getResources().getString(R.string.pesan_eror));
            check[0] = true;
        }

        if (TextUtils.isEmpty(f_tahun_pembuatan.getText())) {

            f_tahun_pembuatan.setError(getResources().getString(R.string.pesan_eror));
            check[0] = true;
        }

        if (TextUtils.isEmpty(f_kebutuhan_schoon_PHB.getText())) {

            f_kebutuhan_schoon_PHB.setError(getResources().getString(R.string.pesan_eror));
            check[0] = true;
        }

        if (TextUtils.isEmpty(f_primer_phasa_r.getText())) {

            f_primer_phasa_r.setError(getResources().getString(R.string.pesan_eror));
            check[0] = true;
        }

        if (TextUtils.isEmpty(f_primer_phasa_s.getText())) {

            f_primer_phasa_s.setError(getResources().getString(R.string.pesan_eror));
            check[0] = true;
        }

        if (TextUtils.isEmpty(f_primer_phasa_t.getText())) {

            f_primer_phasa_t.setError(getResources().getString(R.string.pesan_eror));
            check[0] = true;
        }

        final Button button_ya_phb = (Button) findViewById(R.id.saklar_utama_phb_ya);
        if (button_ya_phb.isSelected()) {
            if (TextUtils.isEmpty(f_saklar_merk.getText())) {

                f_saklar_merk.setError(getResources().getString(R.string.pesan_eror));
                check[0] = true;
            }

            if (TextUtils.isEmpty(f_saklar_arus.getText())) {

                f_saklar_arus.setError(getResources().getString(R.string.pesan_eror));
                check[0] = true;
            }
        }


        final Button button_jur_A = (Button) findViewById(R.id.fuse_jurusan_A);
        final Button button_jur_B = (Button) findViewById(R.id.fuse_jurusan_B);
        final Button button_jur_C = (Button) findViewById(R.id.fuse_jurusan_C);
        if (button_jur_A.isSelected()) {
            if (TextUtils.isEmpty(f_fuse_R_Jur_A.getText())) {

                f_fuse_R_Jur_A.setError(getResources().getString(R.string.pesan_eror));
                check[0] = true;
            }

            if (TextUtils.isEmpty(f_fuse_S_Jur_A.getText())) {

                f_fuse_S_Jur_A.setError(getResources().getString(R.string.pesan_eror));
                check[0] = true;
            }

            if (TextUtils.isEmpty(f_fuse_T_Jur_A.getText())) {

                f_fuse_T_Jur_A.setError(getResources().getString(R.string.pesan_eror));
                check[0] = true;
            }

        } else if (button_jur_B.isSelected()) {
            if (TextUtils.isEmpty(f_fuse_R_Jur_B.getText())) {

                f_fuse_R_Jur_B.setError(getResources().getString(R.string.pesan_eror));
                check[0] = true;
            }

            if (TextUtils.isEmpty(f_fuse_S_Jur_B.getText())) {

                f_fuse_S_Jur_B.setError(getResources().getString(R.string.pesan_eror));
                check[0] = true;
            }

            if (TextUtils.isEmpty(f_fuse_T_Jur_B.getText())) {

                f_fuse_T_Jur_B.setError(getResources().getString(R.string.pesan_eror));
                check[0] = true;
            }
        } else if (button_jur_C.isSelected()) {
            if (TextUtils.isEmpty(f_fuse_R_Jur_C.getText())) {

                f_fuse_R_Jur_C.setError(getResources().getString(R.string.pesan_eror));
                check[0] = true;
            }

            if (TextUtils.isEmpty(f_fuse_S_Jur_C.getText())) {

                f_fuse_S_Jur_C.setError(getResources().getString(R.string.pesan_eror));
                check[0] = true;
            }

            if (TextUtils.isEmpty(f_fuse_T_Jur_C.getText())) {

                f_fuse_T_Jur_C.setError(getResources().getString(R.string.pesan_eror));
                check[0] = true;
            }
        }


        //NH Jurusan
        final Button button_jur_NH_A = (Button) findViewById(R.id.NH_jurusan_A);
        final Button button_jur_NH_B = (Button) findViewById(R.id.NH_jurusan_B);
        final Button button_jur_NH_C = (Button) findViewById(R.id.NH_jurusan_C);
        final Button button_jur_NH_D = (Button) findViewById(R.id.NH_jurusan_D);
        if (button_jur_NH_A.isSelected()) {

            if (TextUtils.isEmpty(f_NH_R_Jur_A.getText())) {

                f_NH_R_Jur_A.setError(getResources().getString(R.string.pesan_eror));
                check[0] = true;
            }

            if (TextUtils.isEmpty(f_NH_S_Jur_A.getText())) {

                f_NH_S_Jur_A.setError(getResources().getString(R.string.pesan_eror));
                check[0] = true;
            }

            if (TextUtils.isEmpty(f_NH_T_Jur_A.getText())) {

                f_NH_T_Jur_A.setError(getResources().getString(R.string.pesan_eror));
                check[0] = true;
            }


        } else if (button_jur_NH_B.isSelected()) {

            if (TextUtils.isEmpty(f_NH_R_Jur_B.getText())) {

                f_NH_R_Jur_B.setError(getResources().getString(R.string.pesan_eror));
                check[0] = true;
            }

            if (TextUtils.isEmpty(f_NH_S_Jur_B.getText())) {

                f_NH_S_Jur_B.setError(getResources().getString(R.string.pesan_eror));
                check[0] = true;
            }

            if (TextUtils.isEmpty(f_NH_T_Jur_B.getText())) {

                f_NH_T_Jur_B.setError(getResources().getString(R.string.pesan_eror));
                check[0] = true;
            }


        } else if (button_jur_NH_C.isSelected()) {

            if (TextUtils.isEmpty(f_NH_R_Jur_C.getText())) {

                f_NH_R_Jur_C.setError(getResources().getString(R.string.pesan_eror));
                check[0] = true;
            }

            if (TextUtils.isEmpty(f_NH_S_Jur_C.getText())) {

                f_NH_S_Jur_C.setError(getResources().getString(R.string.pesan_eror));
                check[0] = true;
            }

            if (TextUtils.isEmpty(f_NH_T_Jur_C.getText())) {

                f_NH_T_Jur_C.setError(getResources().getString(R.string.pesan_eror));
                check[0] = true;
            }


        } else if (button_jur_NH_D.isSelected()) {
            if (TextUtils.isEmpty(f_NH_R_Jur_D.getText())) {

                f_NH_R_Jur_D.setError(getResources().getString(R.string.pesan_eror));
                check[0] = true;
            }

            if (TextUtils.isEmpty(f_NH_S_Jur_D.getText())) {

                f_NH_S_Jur_D.setError(getResources().getString(R.string.pesan_eror));
                check[0] = true;
            }

            if (TextUtils.isEmpty(f_NH_T_Jur_D.getText())) {

                f_NH_T_Jur_D.setError(getResources().getString(R.string.pesan_eror));
                check[0] = true;
            }
        }


        if (TextUtils.isEmpty(f_arrester.getText())) {

            f_arrester.setError(getResources().getString(R.string.pesan_eror));
            check[0] = true;
        }

        if (TextUtils.isEmpty(f_saklar_tahanan_arrester.getText())) {

            f_saklar_tahanan_arrester.setError(getResources().getString(R.string.pesan_eror));
            check[0] = true;
        }

        if (TextUtils.isEmpty(f_saklar_tahanan_netral.getText())) {

            f_saklar_tahanan_netral.setError(getResources().getString(R.string.pesan_eror));
            check[0] = true;
        }

        if (TextUtils.isEmpty(f_body_trafo.getText())) {

            f_body_trafo.setError(getResources().getString(R.string.pesan_eror));
            check[0] = true;
        }


        return check[0];
    }



    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;
    public boolean checkLocationPermission(){
        if (ContextCompat.checkSelfPermission(this,
                android.Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            // Asking user if explanation is needed
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    android.Manifest.permission.ACCESS_FINE_LOCATION)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

                //Prompt the user once explanation has been shown
                ActivityCompat.requestPermissions(this,
                        new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);


            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(this,
                        new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);
            }
            return false;
        } else {
            return true;
        }

    }

}