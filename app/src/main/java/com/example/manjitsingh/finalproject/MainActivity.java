package com.example.manjitsingh.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void register(View v){
        Intent register =new Intent(this, RegisterUser.class);
        startActivity(register);
    }

//    public void recreate(View v){
//        database db=new database(this);
//        db.deletetable();
//        db.close();
//    }
    public void login(View v){
        // login login =helper.handlinglogin();
        EditText name1=(EditText)findViewById(R.id.userid);
        EditText pass1=(EditText)findViewById(R.id.password);
        String name = name1.getText().toString();
        String pass=pass1.getText().toString();
        database db=new database(this);

        String re=db.dbfind(name,pass);
        db.close();
        if(re.equals("yes")) {
         Intent first =new Intent(this, Firstpage.class);
            first.putExtra("value",name);
            startActivity(first);
        }
        else{
            Toast.makeText(this,"wrong Entry",Toast.LENGTH_SHORT).show();
            //finish();
        }
    }
}
