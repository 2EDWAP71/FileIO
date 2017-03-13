package com.example.a2edwap71.fileio;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import android.widget.TextView;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.savemenu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.save) {

            try {
                PrintWriter pw =
                        new PrintWriter(new FileWriter(Environment.getExternalStorageDirectory().getAbsolutePath() + "data.txt"));

                EditText et = (EditText) findViewById(R.id.editText);
                String outputText = et.getText().toString();
                pw.println(outputText);
                pw.close();
            } catch (IOException e) {
                System.out.println("I/O Error:" + e);

            }
        }

        return false;
    }


}










