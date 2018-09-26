package com.dolphinwebsolution.travellcious.Activity;

import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.dolphinwebsolution.travellcious.Model.sliderimage_model;
import com.dolphinwebsolution.travellcious.R;
import com.dolphinwebsolution.travellcious.utils.CheckNetwork;
import com.dolphinwebsolution.travellcious.utils.Main_Url;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class Package_slider extends AppCompatActivity implements ViewPager.OnPageChangeListener {
    int currentPage = 0;
    Timer timer;
    final long DELAY_MS = 500;//delay in milliseconds before task is to be executed
    final long PERIOD_MS = 3000; // time in milliseconds between successive task executions.
    private ViewPager mPager;
    String URL;
    private CircleIndicator indicator;
    private Sliding_Package_img_Adapter adapter;
    private List<sliderimage_model> sliderimage_models = new ArrayList<sliderimage_model>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_slider);
        URL = Main_Url.sortUrl + "get_package.php?id="+"1";
        getSupportActionBar().hide();
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mPager = (ViewPager) findViewById(R.id.pager_img);
        indicator = (CircleIndicator)findViewById(R.id.indicator_img);
        mPager.addOnPageChangeListener(this);
        startAutoScrollViewPager();
        if (CheckNetwork.isNetworkAvailable(Package_slider.this))
        {
            CallSliderApi();
        }else {

        }

    }
    private void startAutoScrollViewPager() {

        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            @Override
            public void run() {
                if (currentPage == sliderimage_models.size() - 1) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, DELAY_MS, PERIOD_MS);
    }
    private void CallSliderApi() {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Log.e("response_banner", "" + response);
                        try {
                            JSONObject obj=new JSONObject(response);
                            String package_image=obj.getString("package_image");

                            JSONArray arr = new JSONArray(package_image);
                            sliderimage_models.clear();
                            Log.e("arr", "" + arr);
                            for (int i = 0; i < arr.length(); i++) {
                                try {
                                    JSONObject object = arr.getJSONObject(i);
                                    Log.e("object", "" + object);
                                    Log.e("package_img", "" + object.getString("image"));
                                    sliderimage_model imageModel = new sliderimage_model(object.getString("image"), obj.getString("budget"));
                                    sliderimage_models.add(imageModel);
                                    Log.e("schedule", "" + sliderimage_models.size());

                                    mPager.setAdapter(new Sliding_Package_img_Adapter(Package_slider.this, sliderimage_models));
                                    indicator.setViewPager(mPager);

                                    //startAutoScrollViewPager();

                                } catch (Exception e) {
                                    Log.e("Exception", "" + e);
                                } finally {
                                    //  adapter.notifyDataSetChanged();
                                }
                            }

                        } catch (JSONException e) {

                        }
                    }


                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //   Toast.makeText(getActivity()), "not get Response", Toast.LENGTH_SHORT).show();
                    }
                });/* {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> KeyValuePair = new HashMap<String, String>();
                Log.e("lang", "" + type);
                KeyValuePair.put("type", type);
                return KeyValuePair;

            }
        };*/
        RequestQueue requestQueue = Volley.newRequestQueue(Package_slider.this);
        requestQueue.add(stringRequest);
        requestQueue.add(stringRequest);

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }


}

