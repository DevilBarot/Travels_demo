package com.dolphinwebsolution.travellcious.Activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.dolphinwebsolution.travellcious.Adapter.Vacation_adapter;
import com.dolphinwebsolution.travellcious.Adapter.ViewAll_destination_adapter;
import com.dolphinwebsolution.travellcious.Adapter.Viewall_vacation_adapter;
import com.dolphinwebsolution.travellcious.Model.Destionation_model;
import com.dolphinwebsolution.travellcious.Model.Vacation_model;
import com.dolphinwebsolution.travellcious.R;
import com.dolphinwebsolution.travellcious.utils.CheckNetwork;
import com.dolphinwebsolution.travellcious.utils.Main_Url;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Vacation_viewAll extends AppCompatActivity {
    RecyclerView recycle_destination;
    private String URL ;
    private List<Vacation_model> model = new ArrayList<Vacation_model>();
    Viewall_vacation_adapter adapter;
    ProgressBar pd;
    String category="vacation";
    TextView txt_msg_vac;
    CardView cardview_vall_vac;
    LinearLayout ll_sub_click;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.perticular_category_row);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ll_sub_click = (LinearLayout) findViewById(R.id.ll_sub_click);
        ll_sub_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ll_sub_click.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                Intent i = new Intent(Vacation_viewAll.this, Package_name.class);
             /*   i.putExtra("cat_id", cat_id2);
                i.putExtra("location_id", location_id2);
                i.putExtra("location_img", location_img2);
                Log.e("imagee_one_locaimgggg", "" + location_img2);
             */   startActivity(i);
                                overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
                            }
                        }, 50);

                    }
                });
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        else if(item.getItemId()== R.id.request_callback)
        {
            Intent i=new Intent(Vacation_viewAll.this,Request_callBack.class);
            startActivity(i);
            Toast.makeText(getApplicationContext(),"Request",Toast.LENGTH_LONG).show();
        }
        else if(item.getItemId() == R.id.send_qury)
        {
            Intent i=new Intent(Vacation_viewAll.this,Send_query.class);
            startActivity(i);

            Toast.makeText(getApplicationContext(),"sendquery",Toast.LENGTH_LONG).show();
        }
        else if(item.getItemId() == R.id.help)
        {
            Toast.makeText(getApplicationContext(),"Item 3 Selected",Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
    }

}
