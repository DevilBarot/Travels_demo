package com.dolphinwebsolution.travellcious.Activity;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import com.dolphinwebsolution.travellcious.Adapter.Bestselling_adapter;
import com.dolphinwebsolution.travellcious.Adapter.Review_adapter;
import com.dolphinwebsolution.travellcious.Adapter.Tranding_adapter;
import com.dolphinwebsolution.travellcious.Model.Bestselling_Package_model;
import com.dolphinwebsolution.travellcious.Model.Review_model;
import com.dolphinwebsolution.travellcious.Model.Tranding_model;
import com.dolphinwebsolution.travellcious.R;
import com.dolphinwebsolution.travellcious.utils.CheckNetwork;
import com.dolphinwebsolution.travellcious.utils.Main_Url;
import com.koushikdutta.ion.Ion;
import com.rbrooks.indefinitepagerindicator.IndefinitePagerIndicator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutionException;


public class Package_name extends AppCompatActivity {

    CardView cardview_trading, cardview_bestsell, cardview_review;
    TextView tv_review, tv_reviewmore, tv_more, txt_msg, txt_msg_best, txt_msg_review, tv_tranding, tv_bestsell, tv_overview, tv_review_text;
    LinearLayout ll_packge_click;
    Button btn_bestsell_viewall, btn_trading_vall, btn_customize_package;
    RecyclerView recycler_bestselling, recycler_trading, recycler_review;
    String cat_id, location_id, URLBESTSELLING, URLREVIEW, location_img, URLTRANDING, Location_URL, ovreview;
    private List<Bestselling_Package_model> model = new ArrayList<Bestselling_Package_model>();
    private List<Tranding_model> trading_model = new ArrayList<Tranding_model>();
    private Bestselling_adapter adapter;
    Tranding_adapter trade_adapter;
    ImageView img_location;
    private List<Review_model> rmodel = new ArrayList<Review_model>();
    private Review_adapter review_adapter;
    IndefinitePagerIndicator indicates, indicates1;

    LinearLayout lv_package1,lv_package;
    Button lv_cusomize_package;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Allocatememory();

        cat_id = getIntent().getStringExtra("cat_id");
        location_id = getIntent().getStringExtra("location_id");
        location_img = getIntent().getStringExtra("location_img");
        Log.e("catid", "" + cat_id);
        Log.e("location", "" + location_id);
        Log.e("location_img", "" + location_img);

        tv_review.setVisibility(View.VISIBLE);
        lv_package1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        Intent i = new Intent(Package_name.this, Package_Alldetail.class);
               startActivity(i);
                        overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
                    }
                }, 50);
            }
        });
        lv_package.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        Intent i = new Intent(Package_name.this, Package_Alldetail.class);
                        startActivity(i);
                        overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
                    }
                }, 50);
            }
        });

        lv_cusomize_package.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        Intent i = new Intent(Package_name.this, Customize_package_activity.class);
                        startActivity(i);
                        overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
                    }
                }, 50);
            }
        });

       /* URLBESTSELLING = Main_Url.sortUrl + "get_package.php?best_selling=" + cat_id + "&location_id=" + location_id;
        URLTRANDING = Main_Url.sortUrl + "get_package.php?trending_package=" + cat_id + "&location_id=" + location_id;
        URLREVIEW = Main_Url.sortUrl + "get_reviews.php?location_id=" + location_id;
        Log.e("URLURLTRANDING", "" + URLTRANDING);
        Location_URL = Main_Url.sortUrl + "get_location.php?id=" + location_id;
        Log.e("URLLLLLL", "" + URLBESTSELLING);
*/
        //AttachAll_Recyclerview();
        Btn_all_clicklistener();
        Set_all_fontstyle();
/*

        Bitmap bmw = null;
        try {
            bmw = Ion.with(Package_name.this).load(location_img).asBitmap().get();
            Log.e("imageebmwtwo", "" + bmw);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        img_location.setImageBitmap(bmw);

*/

       /* if (CheckNetwork.isNetworkAvailable(Package_name.this)) {
         //   CallBestSelling_API();
            CallReviewAPI();
            CallTrandingApi();
            getlocation();
        } else {
        }
*/

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
    }

    private void Set_all_fontstyle() {
        AssetManager am = getApplicationContext().getAssets();
        Typeface typeface = Typeface.createFromAsset(am,
                String.format(Locale.getDefault(), "Lato-Bold.ttf"));
        Typeface tf = Typeface.createFromAsset(am,
                String.format(Locale.getDefault(), "Lato-Medium.ttf"));
        btn_bestsell_viewall.setTypeface(typeface);
        btn_trading_vall.setTypeface(typeface);
        tv_tranding.setTypeface(typeface);
        tv_bestsell.setTypeface(typeface);
        tv_overview.setTypeface(typeface);
        tv_review_text.setTypeface(typeface);
//        btn_customize_package.setTypeface(typeface);

    }

/*
    private void AttachAll_Recyclerview() {
        recycler_bestselling = (RecyclerView) findViewById(R.id.recycler_bestselling);
        recycler_review = (RecyclerView) findViewById(R.id.recycler_review);
        recycler_trading = (RecyclerView) findViewById(R.id.recycler_trading);

        review_adapter = new Review_adapter(Package_name.this, rmodel);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(Package_name.this, LinearLayoutManager.HORIZONTAL, true);
        layoutManager2.setReverseLayout(false);
        recycler_review.setLayoutManager(layoutManager2);
        recycler_review.setAdapter(review_adapter);
        indicates1.attachToRecyclerView(recycler_review);

        adapter = new Bestselling_adapter(Package_name.this, model);
        LinearLayoutManager layoutManager = new LinearLayoutManager(Package_name.this, LinearLayoutManager.HORIZONTAL, true);
        layoutManager.setReverseLayout(false);
        recycler_bestselling.setLayoutManager(layoutManager);
        recycler_bestselling.setAdapter(adapter);
        indicates.attachToRecyclerView(recycler_bestselling);


        trade_adapter = new Tranding_adapter(Package_name.this, trading_model);
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(Package_name.this, LinearLayoutManager.HORIZONTAL, true);
        layoutManager.setReverseLayout(false);
        recycler_trading.setLayoutManager(layoutManager1);
        recycler_trading.setAdapter(trade_adapter);

    }
*/

    private void Allocatememory() {
       /* indicates = findViewById(R.id.recyclerview_pager_indicator);
        indicates1 = findViewById(R.id.recyclerview_pager_indicator1);

        cardview_review = (CardView) findViewById(R.id.cardview_review);
        cardview_bestsell = (CardView) findViewById(R.id.cardview_bestsell);
        cardview_trading = (CardView) findViewById(R.id.cardview_trading);
       */ img_location = (ImageView) findViewById(R.id.img_location);
        ll_packge_click = (LinearLayout) findViewById(R.id.ll_packge_click);
        btn_bestsell_viewall = (Button) findViewById(R.id.btn_bestsell_viewall);
        btn_trading_vall = (Button) findViewById(R.id.btn_trading_vall);
        //btn_customize_package = (Button) findViewById(R.id.btn_customize_package);
        tv_review = (TextView) findViewById(R.id.tv_review);
        tv_reviewmore = (TextView) findViewById(R.id.tv_reviewmore);
        tv_more = (TextView) findViewById(R.id.tv_more);

        /*txt_msg = (TextView) findViewById(R.id.txt_msg);
        txt_msg_best = (TextView) findViewById(R.id.txt_msg_best);
        txt_msg_review = (TextView) findViewById(R.id.txt_msg_review);
        */tv_review_text = (TextView) findViewById(R.id.tv_review_text);
        tv_overview = (TextView) findViewById(R.id.tv_overview);
        tv_bestsell = (TextView) findViewById(R.id.tv_bestsell);
        tv_tranding = (TextView) findViewById(R.id.tv_tranding);

        lv_package = (LinearLayout) findViewById(R.id.lv_package);
        lv_package1 = (LinearLayout) findViewById(R.id.lv_package1);
        lv_cusomize_package = (Button) findViewById(R.id.lv_cusomize_package);


    }

    private void Btn_all_clicklistener() {


        btn_bestsell_viewall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {


                        Log.e("viewalllllllllll", "");

                Intent i = new Intent(Package_name.this, BestSelling_viewAll.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
                    }
                }, 50);

            }
        });
        tv_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tv_reviewmore.getVisibility() == View.GONE) {


                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            tv_reviewmore.setVisibility(View.VISIBLE);
                            tv_review.setVisibility(View.GONE);
                            tv_more.setText("READ LESS");

                        }
                    }, 50);
                     } else {

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            tv_reviewmore.setVisibility(View.GONE);
                            tv_review.setVisibility(View.VISIBLE);
                            tv_more.setText("READ MORE");

                        }
                    }, 50);

                     }
                // tv_reviewmore.setVisibility(View.VISIBLE);
                //tv_review.setVisibility(View.GONE);
            }
        });

        btn_trading_vall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Package_name.this, BestSelling_viewAll.class);
                startActivity(i);

            }
        });
    }

  /*  private void getlocation() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, Location_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("Response", "" + response);
                try {
                    JSONObject obj = new JSONObject(response);
                    ovreview = obj.getString("Overview");
                    AssetManager am = getApplicationContext().getAssets();
                    Typeface typeface = Typeface.createFromAsset(am,
                            String.format(Locale.getDefault(), "Lato-Bold.ttf"));
                    Typeface tf = Typeface.createFromAsset(am,
                            String.format(Locale.getDefault(), "Lato-Medium.ttf"));

                    Log.e("ovvovovovovovovo", "" + ovreview);
                    tv_review.setTypeface(tf);
                    tv_reviewmore.setTypeface(tf);
                    tv_more.setTypeface(typeface);

                    tv_review.setText(ovreview);
                    tv_reviewmore.setText(ovreview);
                    Log.e("ovreview", "" + ovreview);
                } catch (Exception e) {
                    Log.e("exception", "" + e);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("ErrorResponse", "" + error.getMessage());
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(Package_name.this);
        requestQueue.add(stringRequest);
        requestQueue.add(stringRequest);
    }

    private void CallTrandingApi() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URLTRANDING,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Log.e("responsepakeg", "" + response);
                        model.clear();
                        //   pd.setVisibility(View.GONE);
                        JSONArray arr = null;
                        try {
                            arr = new JSONArray(response);
                            if (arr != null) {
                                String msg = null;
                                Log.e("arr_trading", "" + arr);
                                for (int i = 0; i < arr.length(); i++) {
                                    try {
                                        JSONObject object = arr.getJSONObject(i);
                                        Log.e("object", "" + object);
                                        String status = object.getString("status");
                                        Log.e("status_trad", "" + status);

                                        msg = object.getString("message");
                                        Log.e("response_msggg", "" + msg);

                                        if (status.equals("error") == true) {
                                            Toast.makeText(Package_name.this, "message==" + msg, Toast.LENGTH_SHORT).show();
                                            Log.e("response_msggg_toast", "" + msg);
                                            txt_msg.setText("Package not Available");
                                            cardview_trading.setVisibility(View.VISIBLE);

                                        } else {

                                            Log.e("object_packagetitle", "" + object.getString("package_title"));
                                            cardview_trading.setVisibility(View.GONE);

                                            String days = null, night = null;
                                            String duration = object.getString("Duration");
                                            JSONArray day = new JSONArray(duration);
                                            Log.e("day", "" + day);


                                            for (int j = 0; j < day.length(); j++) {
                                                JSONObject obj = day.getJSONObject(j);
                                                days = obj.getString("Days");
                                                Log.e("dayss", "" + days);
                                                night = obj.getString("Nights");

                                                // loop and add it to array or arraylist
                                            }
                                            String pack_img = object.getString("package_images");
                                            String image = null;
                                            JSONArray imgarr = new JSONArray(pack_img);
                                            for (int k = 0; k < imgarr.length(); k++) {
                                                JSONObject jsonObject = imgarr.getJSONObject(k);
                                                image = jsonObject.getString("image");
                                            }
                                            Tranding_model model = new Tranding_model(
                                                    object.getString("package_title"),
                                                    object.getString("description"), days,
                                                    object.getString("budget"),
                                                    object.getString("best_time_to_visit"), night,
                                                    object.getString("category_id"),
                                                    object.getString("location_id"),
                                                    object.getString("features"),
                                                    object.getString("Category_Name"),
                                                    object.getString("Location_Name"),
                                                    image, object.getString("id"));

                                            trading_model.add(model);

                                        }
                                    } catch (Exception e) {
                                        Log.e("Exception", "" + e);
                                    } finally {
                                        trade_adapter.notifyItemChanged(i);

                                    }
                                }


                            }else {
                                Toast.makeText(Package_name.this, "array null", Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //  Toast.makeText(getActivity(), "not get Response" + error, Toast.LENGTH_SHORT).show();
                    }
                }) *//*{
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> KeyValuePair = new HashMap<String, String>();
                Log.e("idddddddddd", "" + id);
                KeyValuePair.put("id", id);
                return KeyValuePair;
            }
        }*//*;

        RequestQueue requestQueue = Volley.newRequestQueue(Package_name.this);
        requestQueue.add(stringRequest);
        requestQueue.add(stringRequest);

    }

    private void CallReviewAPI() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URLREVIEW,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Log.e("response_review", "" + response);
                        Log.e("reviewUrl", "" + URLREVIEW);
                        //   pd.setVisibility(View.GONE);

                        JSONArray arr = null;
                        try {
                            arr = new JSONArray(response);

                            if (arr != null) {

                                Log.e("arr_review", "" + arr);
                                rmodel.clear();
                                Log.e("arr_review", "" + arr);
                                String msg = null, status;

                                for (int i = 0; i < arr.length(); i++) {
                                    try {
                                        JSONObject object = arr.getJSONObject(i);
                                        Log.e("object", "" + object);
                                        Log.e("Review", "" + object.getString("Review"));
                                        status = object.getString("status");
                                        Log.e("status", "" + status);
                                        msg = object.getString("message");
                                        Log.e("response_msggg_best", "" + msg);

                                        if (status.equals("error") == true) {
                                            Toast.makeText(Package_name.this, "message==" + msg, Toast.LENGTH_SHORT).show();
                                            Log.e("response_msggg_toast", "" + msg);
                                            txt_msg_review.setText(msg);
                                            cardview_review.setVisibility(View.VISIBLE);

                                        } else {

                                            cardview_review.setVisibility(View.GONE);
                                            Review_model review_model = new Review_model(object.getString("Start"),
                                                    object.getString("Review"), object.getString("User_Id"),
                                                    object.getString("Package_id"), object.getString("User_image"));

                                            rmodel.add(review_model);
                                        }
                                    } catch (Exception e) {
                                        Log.e("Exception", "" + e);
                                    } finally {
                                        review_adapter.notifyItemChanged(i);

                                    }
                                }
                            } else {
                                Toast.makeText(Package_name.this, "arr is null" + arr, Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //  Toast.makeText(getActivity(), "not get Response" + error, Toast.LENGTH_SHORT).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(Package_name.this);
        requestQueue.add(stringRequest);
        requestQueue.add(stringRequest);


    }

    private void CallBestSelling_API() {
        final StringRequest stringRequest = new StringRequest(Request.Method.GET, URLBESTSELLING,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Log.e("response_bestselling", "" + response);
                        model.clear();
                        //   pd.setVisibility(View.GONE);
                        JSONArray arr = null;

                        try {
                            arr = new JSONArray(response);
                            String msg = null;
                            Log.e("arr_length", "" + arr.length());

                            Log.e("arr_bestsell", "" + arr);
                            for (int i = 0; i < arr.length(); i++) {
                                Log.e("arr_bestsell_lenght", "" + arr.length());
                                try {
                                    String status;
                                    JSONObject object = arr.getJSONObject(i);
                                    Log.e("object", "" + object);

                                    status = object.getString("status");
                                    Log.e("status", "" + status);
                                    msg = object.getString("message");
                                    Log.e("response_msggg_best", "" + msg);


                                    if (status.equals("error") == true) {
                                        Toast.makeText(Package_name.this, "message==" + msg, Toast.LENGTH_SHORT).show();
                                        Log.e("response_msggg_toast", "" + msg);
                                        txt_msg_best.setText("Package not available");
                                        cardview_bestsell.setVisibility(View.VISIBLE);

                                    } else if (status.equals("Success") == true) {
                                        Log.e("object_package_best", "" + object.getString("package_title"));
                                        cardview_bestsell.setVisibility(View.GONE);

                                        String days = null, night = null;
                                        String duration = object.getString("Duration");
                                        JSONArray day = new JSONArray(duration);
                                        Log.e("day", "" + day);

                                        for (int j = 0; j < day.length(); j++) {
                                            JSONObject obj = day.getJSONObject(j);
                                            days = obj.getString("Days");
                                            Log.e("dayss", "" + days);
                                            Log.e("Best_sell_pack_id", "" + object.getString("id"));
                                            night = obj.getString("Nights");

                                            // loop and add it to array or arraylist
                                        }
                                        String pack_img = object.getString("package_images");
                                        String image = null;
                                        JSONArray imgarr = new JSONArray(pack_img);
                                        for (int k = 0; k < imgarr.length(); k++) {
                                            JSONObject jsonObject = imgarr.getJSONObject(k);
                                            image = jsonObject.getString("image");
                                        }
                                        Bestselling_Package_model best_model = new Bestselling_Package_model(
                                                object.getString("package_title"),
                                                object.getString("description"), days,
                                                object.getString("budget"),
                                                object.getString("best_time_to_visit"), night,
                                                object.getString("category_id"),
                                                object.getString("location_id"),
                                                object.getString("features"),
                                                object.getString("Category_Name"),
                                                object.getString("Location_Name"),
                                                image, object.getString("id"));

                                        model.add(best_model);

                                    }
                                } catch (Exception e) {
                                    Log.e("Exception", "" + e);
                                } finally {
                                    adapter.notifyItemChanged(i);

                                }
                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //  Toast.makeText(getActivity(), "not get Response" + error, Toast.LENGTH_SHORT).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(Package_name.this);
        requestQueue.add(stringRequest);
        requestQueue.add(stringRequest);


    }

*/
/*
    private void CallBestSellingAPI() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Log.e("best_sellresponse", "" + response);
                        model.clear();
                        //   pd.setVisibility(View.GONE);

                        JSONArray arr = null;
                        try {
                            arr = new JSONArray(response);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        Log.e("bestarr", "" + arr);
                        for (int i = 0; i < arr.length(); i++) {
                            try {
                                JSONObject object = arr.getJSONObject(i);
                                Log.e("object", "" + object);
                                Log.e("object_packagetitle", "" + object.getString("package_title"));
                                String days = null, night = null;
                                String duration = object.getString("Duration");
                                JSONArray day = new JSONArray(duration);
                                Log.e("day", "" + day);

                                for (int j = 0; j < day.length(); j++) {
                                    JSONObject obj = day.getJSONObject(j);
                                    days = obj.getString("Days");
                                    Log.e("dayss", "" + days);

                                    night = obj.getString("Nights");

                                    // loop and add it to array or arraylist
                                }
                                String pack_img = object.getString("package_images");
                                String image = null;
                                JSONArray imgarr = new JSONArray(pack_img);
                                for (int k = 0; k < imgarr.length(); k++) {
                                    JSONObject jsonObject = imgarr.getJSONObject(k);
                                    image = jsonObject.getString("image");
                                }
                                Bestselling_Package_model best_model = new Bestselling_Package_model(
                                        object.getString("package_title"),
                                        object.getString("description"), days,
                                        object.getString("budget"),
                                        object.getString("best_time_to_visit"), night,
                                        object.getString("category_id"),
                                        object.getString("location_id"),
                                        object.getString("features"),
                                        object.getString("Category_Name"),
                                        object.getString("Location_Name"),
                                        image, object.getString("id"));

                                model.add(best_model);

                            } catch (Exception e) {
                                Log.e("Exception", "" + e);
                            } finally {
                                adapter.notifyItemChanged(i);

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

        RequestQueue requestQueue = Volley.newRequestQueue(Package_name.this);
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
            Intent i = new Intent(Package_name.this, Request_callBack.class);
            startActivity(i);
            Toast.makeText(getApplicationContext(), "Request", Toast.LENGTH_LONG).show();
        } else if (item.getItemId() == R.id.send_qury) {
            Intent i = new Intent(Package_name.this, Send_query.class);
            startActivity(i);

            Toast.makeText(getApplicationContext(), "sendquery", Toast.LENGTH_LONG).show();
        } else if (item.getItemId() == R.id.help) {
            Toast.makeText(getApplicationContext(), "Help", Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }


}
