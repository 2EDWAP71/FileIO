package com.example.a2edwap71.fileio;

import android.os.Environment;
import android.support.v7.app.AlertDialog;
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
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String path_to_storage = Environment.getExternalStorageDirectory().getAbsolutePath();
        EditText noteEditText = (EditText) findViewById(R.id.noteEditText);

        if (item.getItemId() == R.id.save) {

            PrintWriter pw = null;

            try {

                pw = new PrintWriter(new FileWriter(path_to_storage + "/data.txt", false));
                pw.println(noteEditText.getText());
                pw.flush();

            } catch (IOException e) {
                System.out.println("I/O Error:" + e);

            } finally {
                if (pw != null) pw.close();
            }
        }

        else if(item.getItemId()== R.id.load ){

            BufferedReader br = null;
            try{

                br = new BufferedReader (new FileReader(path_to_storage + "/data.txt"));

                String line = "";
                while ((line = br.readLine()) != null){
                    noteEditText.setText(noteEditText.getText() + line);
                }
                br.close();
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }

        return false;
    }


}










