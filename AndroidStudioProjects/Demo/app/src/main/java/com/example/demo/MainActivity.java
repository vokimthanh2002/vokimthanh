package com.example.demo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtuse,edtpassword;
    Button btndangki,btndangnhap,btnthoat;
    String ten,mk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        controlButton();
    }

    private void controlButton() {
        //kich vao mo ra 1 cai hop thooai
        btnthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder  builder = new AlertDialog.Builder(MainActivity.this, android.R.style.Theme_DeviceDefault_Dialog);
                    builder.setTitle("Ban co chac muon thoat khoi app");
                    builder.setMessage("hay lua chon ben duoi de xac nhan");
                    builder.setIcon(android.R.drawable.ic_dialog_alert);
                    builder.setPositiveButton("Co", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        onBackPressed();
                    }
                });
                    builder.setNegativeButton("Khong", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                builder.show();
            }
        });
        btndangki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog= new Dialog(MainActivity.this);
                dialog.setTitle("Hoi thoai xu ly");
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.customdialog);
                final EditText edttk= (EditText) dialog.findViewById(R.id.edttk);
                final EditText edtmk= (EditText) dialog.findViewById(R.id.edtmk);
                Button btnhuy =(Button) dialog.findViewById(R.id.btnhuy);
                Button btndongy =(Button) dialog.findViewById(R.id.btndy);
                btndongy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ten= edttk.getText().toString().trim();
                        mk= edtmk.getText().toString().trim();
                        edtuse.setText(ten);
                        edtpassword.setText(mk);
                        dialog.cancel();
                    }
                });
                btnhuy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.cancel();
                    }
                });
                dialog.show();
            }
        });
        btndangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtuse.getText().length()!=0 && edtpassword.getText().length() !=0){
                    if(edtuse.getText().toString().equals(ten) && edtpassword.getText().toString().equals(mk)){
                        Toast.makeText(MainActivity.this,"Ban da dang nhap thanh cong",Toast.LENGTH_SHORT).show();
                        Intent intent= new Intent(MainActivity.this,MainActivity2.class);
                        startActivity(intent);
                    }else if(edtuse.getText().toString().equals("vokimthanh") && edtpassword.getText().toString().equals("123")){
                        Toast.makeText(MainActivity.this,"Ban da dang nhap thanh cong",Toast.LENGTH_SHORT).show();
                        Intent intent= new Intent(MainActivity.this,MainActivity2.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(MainActivity.this,"Sai thong tin tai khoan hoac mat khau",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(MainActivity.this,"Moi ban nhap du thong tin",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void anhxa() {
        edtuse= (EditText) findViewById(R.id.edittextuser);
        edtpassword= (EditText) findViewById(R.id.edittextpassword);
        btndangnhap= (Button) findViewById(R.id.buttondangnhap);
        btndangki= (Button) findViewById(R.id.buttondangki);
        btnthoat= (Button) findViewById(R.id.buttonthoat);




    }
}