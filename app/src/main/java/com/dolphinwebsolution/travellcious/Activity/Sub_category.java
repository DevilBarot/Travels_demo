package com.dolphinwebsolution.travellcious.Activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.dolphinwebsolution.travellcious.Adapter.Sub_cat_adapter;
import com.dolphinwebsolution.travellcious.Model.Sub_cat_model;
import com.dolphinwebsolution.travellcious.R;
import com.dolphinwebsolution.travellcious.utils.CheckNetwork;
import com.dolphinwebsolution.travellcious.utils.Main_Url;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Sub_category extends AppCompatActivity {
    TextView txtperson;
   public static String id,catname;
    private String URL;
    private List<Sub_cat_model> model = new ArrayList<Sub_cat_model>();
    private Sub_cat_adapter sub_cat_adapter;
    RecyclerView recycle_subcat;
    LinearLayout ll_sub_click;
    ProgressBar pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.perticular_category_row);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        ll_sub_click=(LinearLayout)findViewById(R.id.ll_sub_click);
        ll_sub_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        Intent i = new Intent(Sub_category.this, Package_name.class);
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

       // Bundle bundle =Sub_category.this.getArguments();

        /*Log.e("bundleeeeee", "" + bundle);
        if (bundle != null) {
            id = bundle.getString("id");
            Log.e("showscreen", "" + id);
        }
*/
      /*  id=getIntent().getStringExtra("id");

        catname=getIntent().getStringExtra("catname");
        Log.e("catnm",""+catname);
        Log.e("iddddddddddd",""+id);*/
//http://travel.demoproject.info/api/get_location_by_category.php?category=romantic
       /* URL = Main_Url.sortUrl + "get_location_by_category.php?category="+catname;

        pd = (ProgressBar) findViewById(R.id.pd);

        recycle_subcat = (RecyclerView) findViewById(R.id.recycle_subcat);
        sub_cat_adapter = new Sub_cat_adapter(Sub_category.this, model);
        LinearLayoutManager layoutManager = new LinearLayoutManager(Sub_category.this, LinearLayoutManager.VERTICAL, true);
        layoutManager.setReverseLayout(false);
        recycle_subcat.setLayoutManager(layoutManager);
        recycle_subcat.setAdapter(sub_cat_adapter);
*/

      /*  if (CheckNetwork.isNetworkAvailable(Sub_category.this)) {
            getSubCategory();
        } else {
        }
*/
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
/*
    private void getSubCategory() {
        pd.setVisibility(View.VISIBLE);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Log.e("response", "" + response);
                        model.clear();
                        pd.setVisibility(View.GONE);

                        JSONArray arr= null;
                        try {
                            arr = new JSONArray(response);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        Log.e("arr", "" + arr);
                        for (int i = 0; i < arr.length(); i++) {
                            try {
                                JSONObject object = arr.getJSONObject(i);
                                Log.e("object", "" + object);
                              //  Log.e("url", "" + object.getString("category_icon"));
                                 ///  String location_image=object.getString("location_image");
                               */
/* JSONArray imagarr=new JSONArray(location_image);
                                JSONArray obj;
                                for(int j=0;j<imagarr.length();j++)
                                {
                                    obj = imagarr.getJSONArray(j);
                                    Log.e("firstt",""+obj);
                                }*//*

                                String img = null;
                                JSONArray location_image = object.getJSONArray("location_image");
                                for(int j=0;j<location_image.length();j++)
                                {
                                    JSONObject obj=location_image.getJSONObject(0);
                                     img = obj.getString("image");
                                    Log.i("imggggggggg",""+img);
                                    // loop and add it to array or arraylist
                                }
                                Sub_cat_model submodel = new Sub_cat_model(object.getString("Category_Name"),
                                        object.getString("Location_id"), object.getString("Location_title"),
                                        object.getString("isActive"), object.getString("Starting_budget"),
                                        img);

                                model.add(submodel);

                            } catch (Exception e) {
                                Log.e("Exception", "" + e);
                            } finally {
                                sub_cat_adapter.notifyItemChanged(i);

                            }
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //  Toast.makeText(getActivity(), "not get Response" + error, Toast.LENGTH_SHORT).show();
                    }
                }) */
/*{
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> KeyValuePair = new HashMap<String, String>();
                Log.e("idddddddddd", "" + id);
                KeyValuePair.put("id", id);
                return KeyValuePair;
            }
        }*//*
;

        RequestQueue requestQueue = Volley.newRequestQueue(Sub_category.this);
        requestQueue.add(stringRequest);
        requestQueue.add(stringRequest);


    }
*/
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
    }
}
