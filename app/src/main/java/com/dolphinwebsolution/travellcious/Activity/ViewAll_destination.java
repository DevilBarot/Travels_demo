package com.dolphinwebsolution.travellcious.Activity;

import android.content.Intent;
import android.graphics.Bitmap;
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
import com.dolphinwebsolution.travellcious.Adapter.ViewAll_destination_adapter;
import com.dolphinwebsolution.travellcious.Model.Destionation_model;
import com.dolphinwebsolution.travellcious.R;
import com.dolphinwebsolution.travellcious.utils.CheckNetwork;
import com.dolphinwebsolution.travellcious.utils.ItemOffsetDecoration;
import com.dolphinwebsolution.travellcious.utils.Main_Url;
import com.koushikdutta.ion.Ion;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import static java.security.AccessController.getContext;

public class ViewAll_destination extends AppCompatActivity {
    RecyclerView recycle_destination;
    private String URLDESTINATION;
    private List<Destionation_model> models = new ArrayList<Destionation_model>();
    ViewAll_destination_adapter adapter;
    ProgressBar pd;
    String category = "suggestion";
    TextView txt_msg_desti;
    CardView cardview_vall_destination;
    LinearLayout ll_sub_click;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.perticular_category_row);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        URLDESTINATION = Main_Url.sortUrl + "get_package.php?category=" + category;
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

                                Intent i = new Intent(ViewAll_destination.this, Package_name.class);
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

        /* cardview_vall_destination = (CardView) findViewById(R.id.cardview_vall_destination);
        txt_msg_desti = (TextView) findViewById(R.id.txt_msg_desti);
        pd = (ProgressBar) findViewById(R.id.progressBar);
        recycle_destination = (RecyclerView) findViewById(R.id.recycle_destination);
        adapter = new ViewAll_destination_adapter(ViewAll_destination.this, models);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(ViewAll_destination.this, 1);
        recycle_destination.setLayoutManager(mLayoutManager);
        recycle_destination.setItemAnimator(new DefaultItemAnimator());
        recycle_destination.setAdapter(adapter);

       */ // ItemOffsetDecoration itemDecoration = new ItemOffsetDecoration(ViewAll_destination.this, R.dimen.item_offset);
        //recycle_destination.addItemDecoration(itemDecoration);
       /* if (CheckNetwork.isNetworkAvailable(ViewAll_destination.this)) {
            // productlist.clear();

            callgetPackages_destination();
        } else {
        }
*/

    }

/*
    private void callgetPackages_destination() {
        pd.setVisibility(View.VISIBLE);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URLDESTINATION, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("", "" + response);
                pd.setVisibility(View.GONE);
                try {
                    JSONArray Array_desti = new JSONArray(response);
                    Log.e("arr", "" + Array_desti);
                    models.clear();
                    if(Array_desti != null)
                    {
                        for (int i = 0; i < Array_desti.length(); i++) {
                        try {
                            JSONObject object = Array_desti.getJSONObject(i);
                            String status, msg = null;
                            status = object.getString("status");
                            Log.e("status", "" + status);
                            msg = object.getString("message");
                            Log.e("response_msggg_best", "" + msg);

                            Log.e("package_title", "" + object.getString("package_title"));
                            Log.e("budget", "" + object.getString("budget"));
                            if (status.equals("error") == true) {
                                Toast.makeText(ViewAll_destination.this, "message==" + msg, Toast.LENGTH_SHORT).show();
                                Log.e("response_msggg_toast", "" + msg);
                                txt_msg_desti.setText("Package not available");
                                cardview_vall_destination.setVisibility(View.VISIBLE);

                            } else if (status.equals("Success") == true) {

                                cardview_vall_destination.setVisibility(View.GONE);
                                JSONArray imgarr = object.getJSONArray("package_images");
                                String imag = null;
                                for (int j = 0; j < imgarr.length(); j++) {
                                    // String street = imgarr.getString(0);
                                    JSONObject obj = imgarr.getJSONObject(j);
                                    Log.e("imagee", "" + obj.getString("image"));
                                    imag = obj.getString("image");
                                }
                                Log.e("imagee_destination", "" + imag);
                                Destionation_model destionation_model = new Destionation_model(object.getString("id"),
                                        object.getString("category_id"), object.getString("location_id"),
                                        object.getString("package_title"), object.getString("description"),
                                        object.getString("budget"), object.getString("best_time_to_visit"),
                                        object.getString("features"), object.getString("isActive"),
                                        object.getString("Location_Name"), object.getString("UpdatedAt"), object.getString("Category_Name"),
                                        imag);
                                models.add(destionation_model);
                            }
                        } catch (Exception e) {
                            Log.e("Exception", "" + e);
                        } finally {
                            adapter.notifyItemChanged(i);
                        }
                    }

                }
                } catch (JSONException e) {
                    pd.setVisibility(View.GONE);
                    Log.e("exception", "" + e);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                pd.setVisibility(View.GONE);
                Log.e("Error", "" + error.getMessage());
            }
        }) {
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
        RequestQueue requestQueue = Volley.newRequestQueue(ViewAll_destination.this);
        requestQueue.add(stringRequest);
        requestQueue.add(stringRequest);


    }
*/

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
        } else if (item.getItemId() == R.id.request_callback) {
            Intent i = new Intent(ViewAll_destination.this, Request_callBack.class);
            startActivity(i);
            Toast.makeText(getApplicationContext(), "Request", Toast.LENGTH_LONG).show();
        } else if (item.getItemId() == R.id.send_qury) {
            Intent i = new Intent(ViewAll_destination.this, Send_query.class);
            startActivity(i);

            Toast.makeText(getApplicationContext(), "sendquery", Toast.LENGTH_LONG).show();
        } else if (item.getItemId() == R.id.help) {
            Toast.makeText(getApplicationContext(), "Item 3 Selected", Toast.LENGTH_LONG).show();
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
