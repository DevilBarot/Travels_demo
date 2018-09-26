package com.dolphinwebsolution.travellcious.Activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.dolphinwebsolution.travellcious.Adapter.PackDetail_hotel_adapter;
import com.dolphinwebsolution.travellcious.Adapter.Vacation_adapter;
import com.dolphinwebsolution.travellcious.Model.Destionation_model;
import com.dolphinwebsolution.travellcious.Model.PackageDetail_model;
import com.dolphinwebsolution.travellcious.R;
import com.dolphinwebsolution.travellcious.utils.CheckNetwork;
import com.dolphinwebsolution.travellcious.utils.Main_Url;
import com.koushikdutta.ion.Ion;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Package_Alldetail extends AppCompatActivity {
    RecyclerView hotel_recycler;
    private List<PackageDetail_model> models = new ArrayList<PackageDetail_model>();
    PackDetail_hotel_adapter adapter;
    String URL,id;
    ImageView img_main,imgone,imgtwo,imgthree,imgfour;
    TextView txt_inclusion,txt_exclusion;
    Button lv_cusomize_packagedetail;
    Button lv_similar_package;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_alldetail);
       // getSupportActionBar().hide();
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //http://travel.demoproject.info/api/get_package.php?id=1
        id=getIntent().getStringExtra("id");
        Log.e("iddd",""+id);
        URL = Main_Url.sortUrl + "get_package.php?id="+id;
       // hotel_recycler = (RecyclerView) findViewById(R.id.hotel_recycler);
        imgone = (ImageView) findViewById(R.id.imgone);
        imgtwo = (ImageView) findViewById(R.id.imgtwo);
        img_main = (ImageView) findViewById(R.id.img_main);
        imgthree = (ImageView) findViewById(R.id.imgthree);
        imgfour = (ImageView) findViewById(R.id.imgfour);
        txt_inclusion = (TextView) findViewById(R.id.txt_inclusion);
        txt_exclusion = (TextView) findViewById(R.id.txt_exclusion);
        lv_cusomize_packagedetail = (Button) findViewById(R.id.lv_cusomize_packagedetail);
        lv_similar_package = (Button) findViewById(R.id.lv_similar_package);

        lv_cusomize_packagedetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        Intent i = new Intent(Package_Alldetail.this, Customize_package_activity.class);
                        startActivity(i);
                        overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
                    }
                }, 50);
            }
        });
        lv_similar_package.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        Intent i = new Intent(Package_Alldetail.this, ViewAll_destination.class);
                        startActivity(i);
                        overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
                    }
                }, 50);
            }
        });

      /*  adapter = new PackDetail_hotel_adapter(Package_Alldetail.this, models);

        LinearLayoutManager layoutManager1 = new LinearLayoutManager(Package_Alldetail.this, LinearLayoutManager.VERTICAL, true);
        layoutManager1.setReverseLayout(false);
        hotel_recycler.setLayoutManager(layoutManager1);
        hotel_recycler.setAdapter(adapter);
        if (CheckNetwork.isNetworkAvailable(Package_Alldetail.this) ){
           CallpackageDetailApi();
            //  CallHoney_DestinationAPI();
            // CallVacationApi();
        }
        else {

        }*/
        imgfour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Package_Alldetail.this,Package_slider.class);
                startActivity(i);
            }
        });

    }

/*
    private void CallpackageDetailApi() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("", "" + response);
                try {
                    JSONObject obj = new JSONObject(response);
                    Log.e("object...", "" + obj);


                    models.clear();
                    String Hotels=obj.getString("Hotels");
                    JSONArray array=new JSONArray(Hotels);
                    Log.e("array...", "" + array);
                    Log.e("object...", "" + obj.getString("Category_name"));
                    Log.e("Hotels...", "" + obj.getString("Hotels"));
                    for (int i = 0; i < array.length(); i++) {

                        try {
                            JSONObject hotel = array.getJSONObject(i);
                            Log.e("hotel..", "" + hotel);
                            Log.e("hotel_id", "" + hotel.getString("Hotel_id"));
                            Log.e("meals", "" + hotel.getString("Meals"));

                            JSONArray imgarr = hotel.getJSONArray("Hotel_images");
                            String images = null;
                            for (int z = 0; z < imgarr.length(); z++) {
                                // String street = imgarr.getString(0);
                                JSONObject arr = imgarr.getJSONObject(0);
                                Log.e("imagee_detatil", "" + arr.getString("images"));
                                images = arr.getString("images");
                            }
                            Log.e("imagee_destination", "" + images);
                            PackageDetail_model packmodel = new PackageDetail_model(obj.getString("PackageId"),
                                    obj.getString("Category_id"), obj.getString("Category_name"),
                                    obj.getString("Location_id"), obj.getString("package_title"),
                                    obj.getString("Package_Description"), obj.getString("budget"),
                                    obj.getString("best_time_to_visit"), obj.getString("features"),
                                    obj.getString("Package_isActive"), obj.getString("package_image"),
                                    hotel.getString("Hotel_id"), hotel.getString("Hotel_title"),
                                    hotel.getString("Hotel_description"),hotel.getString("Hotel_rooms_type"),
                                    hotel.getString("Meals"),hotel.getString("address"),
                                    obj.getString("Inclusions"),obj.getString("Exclusions"),
                                    images,  hotel.getString("CHECK IN")
                                    ,  hotel.getString("CHECK OUT"));

                            models.add(packmodel);
                        } catch (Exception e) {
                            Log.e("Exception", "" + e);
                        } finally {
                            adapter.notifyItemChanged(i);
                        }
                    }

                    String package_img=obj.getString("package_image");
                    JSONArray img=new JSONArray(package_img);
                    Log.e("imagararrr",""+img);

                    for (int j = 0; j < img.length(); j++) {

                        try {
                            JSONObject img_pack = img.getJSONObject(j);
                            Log.e("img..", "" + img);
                            Log.e("img", "" + img_pack.getString("image"));

                            Bitmap bmw= null,img_one=null,img_two=null,img_three=null,img_four = null;
                            try {

                                bmw = Ion.with(Package_Alldetail.this).load(img_pack.getString("image")).asBitmap().get();
                                img_one = Ion.with(Package_Alldetail.this).load(img_pack.getString("image")).asBitmap().get();
                                img_two = Ion.with(Package_Alldetail.this).load(img_pack.getString("image")).asBitmap().get();
                                img_three = Ion.with(Package_Alldetail.this).load(img_pack.getString("image")).asBitmap().get();
                                img_four = Ion.with(Package_Alldetail.this).load(img_pack.getString("image")).asBitmap().get();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            } catch (ExecutionException e) {
                                e.printStackTrace();
                            }
                            imgone.setImageBitmap(img_one);
                            imgtwo.setImageBitmap(img_two);
                            imgthree.setImageBitmap(img_three);
                            imgfour.setImageBitmap(img_four);
                            img_main.setImageBitmap(bmw);


                           // models.add(packmodel);
                        } catch (Exception e) {
                            Log.e("Exception", "" + e);
                        } finally {
                           // adapter.notifyItemChanged(i);
                        }
                    }

                    String Exclusions=obj.getString("Exclusions");
                    String Inclusions=obj.getString("Inclusions");
                    Log.e("Inclusions",""+Inclusions);
                    txt_inclusion.setText(Html.fromHtml(Inclusions));
                    txt_exclusion.setText(Html.fromHtml(Exclusions));

                } catch (JSONException e) {
                    Log.e("exception", "" + e);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
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
        RequestQueue requestQueue = Volley.newRequestQueue(Package_Alldetail.this);
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
            Intent i=new Intent(Package_Alldetail.this,Request_callBack.class);
            startActivity(i);
            Toast.makeText(getApplicationContext(),"Request",Toast.LENGTH_LONG).show();
        }
        else if(item.getItemId() == R.id.send_qury)
        {
            Intent i=new Intent(Package_Alldetail.this,Send_query.class);
            startActivity(i);

            Toast.makeText(getApplicationContext(),"sendquery",Toast.LENGTH_LONG).show();
        }
        else if(item.getItemId() == R.id.help)
        {
            Toast.makeText(getApplicationContext(),"Help",Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }


}
