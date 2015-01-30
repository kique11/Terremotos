package com.compostela.curso.terremotos;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ExpandableListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button v = (Button)findViewById(R.id.btn_search);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TerremotoList.class);
                Spinner elv = (Spinner)findViewById(R.id.intensidadList);
                DatePicker dp = (DatePicker) findViewById(R.id.dateText);
                Calendar cal = Calendar.getInstance();
                cal.set(dp.getYear(), dp.getMonth(), dp.getDayOfMonth());
                intent.putExtra("intensidad", Integer.parseInt(elv.getSelectedItem().toString()));
                intent.putExtra("fecha", cal.getTimeInMillis());

                startActivity(intent);//Es un método de la clase externa. MainActivity.this.startActivity()
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        Intent intent = null;
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            intent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(intent);
            return true;
        }if(id == R.id.action_help){
            intent = new Intent(MainActivity.this, HelpActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
