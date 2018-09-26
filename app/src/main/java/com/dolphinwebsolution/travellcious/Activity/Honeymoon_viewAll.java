package com.dolphinwebsolution.travellcious.Activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.dolphinwebsolution.travellcious.Adapter.ViewAll_honeymoon_adapter;
import com.dolphinwebsolution.travellcious.Adapter.Viewall_vacation_adapter;
import com.dolphinwebsolution.travellcious.Model.Honeymoon_model;
import com.dolphinwebsolution.travellcious.Model.Vacation_model;
import com.dolphinwebsolution.travellcious.R;
import com.dolphinwebsolution.travellcious.utils.CheckNetwork;
import com.dolphinwebsolution.travellcious.utils.Main_Url;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Honeymoon_viewAll extends AppCompatActivity {
    RecyclerView recycle_destination;
    private String URL ;
    private List<Honeymoon_model> model = new ArrayList<Honeymoon_model>();
    ViewAll_honeymoon_adapter adapter;
    ProgressBar pd;
    String category="Honeymoon";
    LinearLayout ll_sub_click;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.perticular_category_row);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ll_sub_click=(LinearLayout)findViewById(R.id.ll_sub_click);

        ll_sub_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ll_sub_click.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                Intent i = new Intent(Honeymoon_viewAll.this, Package_name.class);

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
         /*URL = Main_Url.sortUrl + "get_package.php?category=" + category;

        pd=(ProgressBar)findViewById(R.id.progressBar);
        recycle_destination=(RecyclerView)findViewById(R.id.recycle_honey_vall);
        adapter = new ViewAll_honeymoon_adapter(Honeymoon_viewAll.this, model);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(Honeymoon_viewAll.this, 1);
        recycle_destination.setLayoutManager(mLayoutManager);
        recycle_destination.setItemAnimator(new DefaultItemAnimator());
        recycle_destination.setAdapter(adapter);
*/
        // ItemOffsetDecoration itemDecoration = new ItemOffsetDecoration(ViewAll_destination.this, R.dimen.item_offset);
        //recycle_destination.addItemDecoration(itemDecoration);
       /* if (CheckNetwork.isNetworkAvailable(Honeymoon_viewAll.this)){
            // productlist.clear();

            callgetPackages_Honeymoon();
        }else{
        }
*/
    }

/*
    private void callgetPackages_Honeymoon() {
        pd.setVisibility(View.VISIBLE);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("",""+response);
                pd.setVisibility(View.GONE);
                try {
                    JSONArray Array = new JSONArray(response);
                    Log.e("arr", "" + Array);
                    model.clear();
                    for (int i = 0; i < Array.length(); i++) {
                        try {
                            JSONObject object = Array.getJSONObject(i);
                            Log.e("package_title", "" + object.getString("package_title"));
                            Log.e("budget", "" + object.getString("budget"));

                            JSONArray imgarr=object.getJSONArray("package_images");
                            String imag = null;
                            for (int j=0;j<imgarr.length();j++)
                            {
                                // String street = imgarr.getString(0);
                                JSONObject obj=imgarr.getJSONObject(j);
                                Log.e("imagee",""+obj.getString("image"));
                                imag=obj.getString("image");
                            }
                            Log.e("imagee_destination",""+imag);
                            Honeymoon_model hmodel = new Honeymoon_model(object.getString("id"),
                                    object.getString("category_id"), object.getString("location_id"),
                                    object.getString("package_title"), object.getString("description"),
                                    object.getString("budget"), object.getString("best_time_to_visit"),
                                    object.getString("features"), object.getString("Location_Name"),imag,
                                    object.getString("Category_Name"));
                            model.add(hmodel);
                        } catch (Exception e) {
                            Log.e("Exception", "" +e);
                        } finally {
                            adapter.notifyItemChanged(i);
                        }
                    }
                } catch (JSONException e) {
                    pd.setVisibility(View.GONE);
                    Log.e("exception",""+e);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                pd.setVisibility(View.GONE);
                Log.e("Error",""+error.getMessage());
            }
        })
        {
                */
/*@Override
                protected Map<String, String> getParams() {
                    Map<String, String> KeyValuePair = new HashMap<String, String>();
                    Log.e("langgggg", "" + Login_preference.getlang(getContext()));
                    Log.e("catiddd", "" + category_id);
                    KeyValuePair.put("lang", Login_preference.getlang(getContext()));
                    KeyValuePair.put("currency", "");
                    KeyValuePair.put("category_id", category_id);
                    KeyValuePair.put("page", "");
                    return KeyValuePair;
                }*//*

        };
        RequestQueue requestQueue = Volley.newRequestQueue(Honeymoon_viewAll.this);
        requestQueue.add(stringRequest);  requestQueue.add(stringRequest);


    }
*/
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
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
            Intent i=new Intent(Honeymoon_viewAll.this,Request_callBack.class);
            startActivity(i);
            Toast.makeText(getApplicationContext(),"Request",Toast.LENGTH_LONG).show();
        }
        else if(item.getItemId() == R.id.send_qury)
        {
            Intent i=new Intent(Honeymoon_viewAll.this,Send_query.class);
            startActivity(i);

            Toast.makeText(getApplicationContext(),"sendquery",Toast.LENGTH_LONG).show();
        }
        else if(item.getItemId() == R.id.help)
        {
            Toast.makeText(getApplicationContext(),"Item 3 Selected",Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }

}
