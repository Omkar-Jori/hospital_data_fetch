package com.example.atlanticare;

import android.os.Bundle;
import android.text.InputType;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    private InputStream InputStream;
    String[] data;
    ListView listView;
    ArrayList<HospitalData> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        listView = (ListView) findViewById(R.id.lv1);

        InputStream = getResources().openRawResource(R.raw.hospital1);
        BufferedReader reader = new BufferedReader(new InputStreamReader(InputStream));

        list = new ArrayList<>();
        try{

            String csvLine;

            while ((csvLine = reader.readLine()) != null)
            {
                data=csvLine.split(",");
                try {
                        HospitalData hospitalData = new HospitalData(data[0],data[1]);
                        list.add(hospitalData);
                }
                catch (Exception e) {
                    Toast.makeText(getApplicationContext(),"Problem :"+e.toString(),Toast.LENGTH_SHORT).show();
                }
            }

        }
        catch (IOException e) {
            Toast.makeText(getApplicationContext(), "Problem :" + e.toString(), Toast.LENGTH_SHORT).show();
        }

        final HospitalAdapter hospitalAdapter = new HospitalAdapter(this,R.layout.adapter_view_layout,list);
        listView.setAdapter(hospitalAdapter);

    }
}
