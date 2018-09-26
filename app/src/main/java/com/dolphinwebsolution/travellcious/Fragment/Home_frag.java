package com.dolphinwebsolution.travellcious.Fragment;


import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
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
import com.dolphinwebsolution.travellcious.Activity.Honeymoon_viewAll;
import com.dolphinwebsolution.travellcious.Activity.MyAccount;
import com.dolphinwebsolution.travellcious.Activity.Package_name;
import com.dolphinwebsolution.travellcious.Activity.Sub_category;
import com.dolphinwebsolution.travellcious.Activity.Vacation_viewAll;
import com.dolphinwebsolution.travellcious.Activity.ViewAll_destination;
import com.dolphinwebsolution.travellcious.Adapter.Category_adapter;
import com.dolphinwebsolution.travellcious.Adapter.Honeymoon_adapter;
import com.dolphinwebsolution.travellcious.Adapter.Vacation_adapter;
import com.dolphinwebsolution.travellcious.Model.Category_model;
import com.dolphinwebsolution.travellcious.Model.Destionation_model;
import com.dolphinwebsolution.travellcious.Model.Honeymoon_model;
import com.dolphinwebsolution.travellcious.Model.Vacation_model;
import com.dolphinwebsolution.travellcious.Model.sliderimage_model;
import com.dolphinwebsolution.travellcious.R;
import com.dolphinwebsolution.travellcious.utils.CheckNetwork;
import com.dolphinwebsolution.travellcious.utils.Main_Url;
import com.koushikdutta.ion.Ion;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutionException;

import me.relex.circleindicator.CircleIndicator;


public class Home_frag extends Fragment implements View.OnClickListener {
   /* RecyclerView recycle_vac, honey_recycler;
    private List<Destionation_model> models = new ArrayList<Destionation_model>();
    private List<Vacation_model> vac_model = new ArrayList<Vacation_model>();
    private List<Honeymoon_model> honey_model = new ArrayList<Honeymoon_model>();
    Vacation_adapter vac_adapter;
    Honeymoon_adapter honey_adapter;
    CardView cardview_honeymoon,cardview_vaction;
    private static String type = "image_only", category = "suggestion";
    private SlidingImage_Adapter adapter;
    private List<sliderimage_model> sliderimage_models = new ArrayList<sliderimage_model>();
    private String URLBANNER, URLDESTINATION, URLHONEYMOON, URL, URLVACATION;
   */ View v;
    /*private List<Category_model> category_model = new ArrayList<Category_model>();
    private Category_adapter category_adapter;
    RecyclerView recycle_category;
    ProgressBar pd1, pd2;
*/
  /*  int currentPage = 0;
    Timer timer;
    final long DELAY_MS = 800;//delay in milliseconds before task is to be executed
    final long PERIOD_MS = 4000; // time in milliseconds between successive task executions.
    private ViewPager mPager;
    private CircleIndicator indicator;
*/
    Button btn_desti_viewall, btn_honey_viewAll, btn_vac_viewAll, btn_vmore, btn_vmoretwo;
    Button btn_vac_vmore,btn_vac_vmoretwo,btn_vmorehoney,btn_vmorehoneytwo;
    TextView txtbudget, txtdesc, txtpacknm, txtbudgettwo, txtdescritwo, txtpacktwo, txtdesti;
    TextView txt_vac_budget, txt_vac_title;
    TextView txthoney, txtvac, txttravel, txt_text, txt_detailtwo, txt_know, txt_veri_agent,
            txt_detail, txt_know_more, txt_msg_honey,txt_msg_vaction;
    ImageView imgdesti, imgdesitwo, img_vacation;

    String cat_id, Location_id, cat_id2, location_id2, location_img, location_img2;
    LinearLayout ll_cat_click1,ll_cat_click2,ll_cat_click3,ll_cat_click4,ll_cat_click5;
    public Home_frag() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_home_frag, container, false);
        Allocatememory(v);
       /* URL = Main_Url.sortUrl + "get_category.php";
        URLBANNER = Main_Url.sortUrl + "get_banner.php?type=" + type;
        //http://travel.demoproject.info/api/get_package.php?category=suggestion
        URLDESTINATION = Main_Url.sortUrl + "get_package.php?category=" + category;
        //http://travel.demoproject.info/api/get_location_by_category.php?category=honeymoon
        URLHONEYMOON = Main_Url.sortUrl + "get_package.php?category=" + "Honeymoon";
        URLVACATION = Main_Url.sortUrl + "get_package.php?category=" + "vacation";
*/
        set_All_FontStyle();
      //  Attach_RecyclerView();
        Btn_Click_listner();
        //  getMainBannerImages();
       // mPager.addOnPageChangeListener(this);
       // startAutoScrollViewPager();
        if (CheckNetwork.isNetworkAvailable(getActivity())) {
            //getCategory();
            //CallSliderApi();
           // callDestionationApi();
            //CallHoney_destinationApi();
           // CallVacationSliderApi();


            //  CallHoney_DestinationAPI();
            // CallVacationApi();
        } else {
        }


        return v;
    }

    private void Btn_Click_listner() {
        btn_desti_viewall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent i = new Intent(getActivity(), ViewAll_destination.class);
                        startActivity(i);
                        getActivity().overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);

                    }
                }, 50);

            }
        });
        btn_vac_viewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        Intent i = new Intent(getActivity(), Vacation_viewAll.class);
                startActivity(i);
                getActivity().overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
                    }
                }, 50);

            }
        });
        btn_honey_viewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        Intent i = new Intent(getActivity(), Honeymoon_viewAll.class);
                startActivity(i);
                getActivity().overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
                    }
                }, 50);


            }
        });
        btn_vmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {


                        Intent i = new Intent(getContext(), Package_name.class);
              /*  i.putExtra("cat_id", cat_id);
                i.putExtra("location_id", Location_id);
                i.putExtra("location_img", location_img);
                Log.e("imagee_one_location_img", "" + location_img);
              */  startActivity(i);
                getActivity().overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
                    }
                }, 50);

            }
        });
        btn_vmoretwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        Intent i = new Intent(getContext(), Package_name.class);
             /*   i.putExtra("cat_id", cat_id2);
                i.putExtra("location_id", location_id2);
                i.putExtra("location_img", location_img2);
                Log.e("imagee_one_locaimgggg", "" + location_img2);
             */   startActivity(i);
                getActivity().overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
                    }
                }, 50);

            }
        });

        ll_cat_click1.setOnClickListener(this);
        ll_cat_click2.setOnClickListener(this);
        ll_cat_click3.setOnClickListener(this);
        ll_cat_click4.setOnClickListener(this);
        ll_cat_click5.setOnClickListener(this);
        btn_vac_vmoretwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        Intent i = new Intent(getActivity(), Package_name.class);
                        startActivity(i);
                        getActivity().overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
                    }
                }, 50);

            }
        });
        btn_vac_vmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        Intent i = new Intent(getActivity(), Package_name.class);
                        startActivity(i);
                        getActivity().overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
                    }
                }, 50);
            }
        });
        btn_vmorehoneytwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        Intent i = new Intent(getActivity(), Package_name.class);
                        startActivity(i);
                        getActivity().overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
                    }
                }, 50);
            }
        });
        btn_vmorehoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        Intent i = new Intent(getActivity(), Package_name.class);
                        startActivity(i);
                        getActivity().overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
                    }
                }, 50);
            }
        });



    }

   /* private void Attach_RecyclerView() {
        recycle_vac = (RecyclerView) v.findViewById(R.id.vac_recycler);
        honey_recycler = (RecyclerView) v.findViewById(R.id.honey_recycler);

        vac_adapter = new Vacation_adapter(getContext(), vac_model);
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, true);
        layoutManager1.setReverseLayout(false);
        recycle_vac.setLayoutManager(layoutManager1);
        recycle_vac.setAdapter(vac_adapter);

        honey_adapter = new Honeymoon_adapter(getContext(), honey_model);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, true);
        layoutManager2.setReverseLayout(false);
        honey_recycler.setLayoutManager(layoutManager2);
        honey_recycler.setAdapter(honey_adapter);

    }
*/
    private void set_All_FontStyle() {
        AssetManager am = getActivity().getApplicationContext().getAssets();
        Typeface typeface = Typeface.createFromAsset(am,
                String.format(Locale.getDefault(), "Lato-Bold.ttf"));
        Typeface tf = Typeface.createFromAsset(am,
                String.format(Locale.getDefault(), "Lato-Medium.ttf"));
       /* txt_msg_honey.setTypeface(typeface);
        txt_msg_vaction.setTypeface(typeface);
       */ txtdesti.setTypeface(typeface);
        txthoney.setTypeface(typeface);
        txttravel.setTypeface(typeface);
        txtvac.setTypeface(typeface);
        btn_desti_viewall.setTypeface(typeface);
        btn_honey_viewAll.setTypeface(typeface);
        btn_vac_viewAll.setTypeface(typeface);
        btn_vmore.setTypeface(typeface);
        btn_vmoretwo.setTypeface(typeface);
        txt_text.setTypeface(typeface);
        txt_veri_agent.setTypeface(typeface);
        txt_know.setTypeface(tf);
        txt_detail.setTypeface(tf);
        txt_detailtwo.setTypeface(tf);
        txt_know_more.setTypeface(tf);

    }
    private void Allocatememory(View v) {


    //    cardview_honeymoon = (CardView) v.findViewById(R.id.cardview_honeymoon);
      //  cardview_vaction = (CardView) v.findViewById(R.id.cardview_vaction);
       /* txt_msg_honey = (TextView) v.findViewById(R.id.txt_msg_honey);
        txt_msg_vaction = (TextView) v.findViewById(R.id.txt_msg_vaction);
*/

        //recycle_category = (RecyclerView) v.findViewById(R.id.cat_recycler);
        //pd1 = (ProgressBar) v.findViewById(R.id.pd1);
        //pd2 = (ProgressBar) v.findViewById(R.id.pd2);

        btn_vmorehoney = (Button) v.findViewById(R.id.btn_vmorehoney);
        btn_vmorehoneytwo = (Button) v.findViewById(R.id.btn_vmorehoneytwo);
        btn_vac_vmore = (Button) v.findViewById(R.id.btn_vac_vmore);
        btn_vac_vmoretwo = (Button) v.findViewById(R.id.btn_vac_vmoretwo);
        btn_desti_viewall = (Button) v.findViewById(R.id.btn_desti_viewall);
        btn_desti_viewall = (Button) v.findViewById(R.id.btn_desti_viewall);

        btn_desti_viewall = (Button) v.findViewById(R.id.btn_desti_viewall);
        txtbudget = (TextView) v.findViewById(R.id.txtbudget);
        txtdesc = (TextView) v.findViewById(R.id.txtdesc);
        txtpacknm = (TextView) v.findViewById(R.id.txtpacknm);
        imgdesti = (ImageView) v.findViewById(R.id.imgdesti);
        imgdesitwo = (ImageView) v.findViewById(R.id.imgdesitwo);
        txtbudgettwo = (TextView) v.findViewById(R.id.txtbudgettwo);
        txtdescritwo = (TextView) v.findViewById(R.id.txtdescritwo);
        txtpacktwo = (TextView) v.findViewById(R.id.txtpacktwo);

        txthoney = (TextView) v.findViewById(R.id.txthoney);
        txtvac = (TextView) v.findViewById(R.id.txtvac);
        txttravel = (TextView) v.findViewById(R.id.txt_travel);
        txtdesti = (TextView) v.findViewById(R.id.txtdesti);
        btn_honey_viewAll = (Button) v.findViewById(R.id.btn_honey_viewAll);
        btn_vmore = (Button) v.findViewById(R.id.btn_vmore);
        btn_vmoretwo = (Button) v.findViewById(R.id.btn_vmoretwo);

        btn_vac_viewAll = (Button) v.findViewById(R.id.btn_vac_viewAll);
        img_vacation = (ImageView) v.findViewById(R.id.img_vacation);


        txt_vac_budget = (TextView) v.findViewById(R.id.txt_vac_budget);
        txt_vac_title = (TextView) v.findViewById(R.id.txt_vac_title);

        txt_text = (TextView) v.findViewById(R.id.txt_text);
        txt_detailtwo = (TextView) v.findViewById(R.id.txt_detailtwo);
        txt_know = (TextView) v.findViewById(R.id.txt_know);
        txt_veri_agent = (TextView) v.findViewById(R.id.txt_veri_agent);
        txt_detail = (TextView) v.findViewById(R.id.txt_detail);
        txt_know_more = (TextView) v.findViewById(R.id.txt_know_more);

        ll_cat_click5 = (LinearLayout) v.findViewById(R.id.ll_cat_click5);
        ll_cat_click4 = (LinearLayout) v.findViewById(R.id.ll_cat_click4);
        ll_cat_click3 = (LinearLayout) v.findViewById(R.id.ll_cat_click3);
        ll_cat_click2 = (LinearLayout) v.findViewById(R.id.ll_cat_click2);
        ll_cat_click1 = (LinearLayout) v.findViewById(R.id.ll_cat_click1);


      /*  category_adapter = new Category_adapter(getActivity(), category_model);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, true);
        layoutManager.setReverseLayout(false);
        recycle_category.setLayoutManager(layoutManager);
        recycle_category.setAdapter(category_adapter);

        mPager = (ViewPager) v.findViewById(R.id.pager);
        indicator = (CircleIndicator) v.findViewById(R.id.indicator);
*/
    }

    @Override
    public void onClick(View view) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent i = new Intent(getContext(), Sub_category.class);
                 startActivity(i);
                getActivity().overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
            }
        }, 50);

    }

/*

    private void CallHoney_destinationApi() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URLHONEYMOON, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("honey_response", "" + response);
                try {
                    JSONArray arr = new JSONArray(response);
                    if(arr != null ) {

                        Log.e("arr_honey", "" + arr);
                        honey_model.clear();
                        for (int i = 0; i < arr.length(); i++) {
                            try {

                                JSONObject object = arr.getJSONObject(i);
                                String msg = null,status;
                                status = object.getString("status");
                                Log.e("status", "" + status);
                                msg = object.getString("message");
                                Log.e("response_msggg_best", "" + msg);


                                if (status.equals("error") == true) {
                                    Toast.makeText(getActivity(), "message==" + msg, Toast.LENGTH_SHORT).show();
                                    Log.e("response_msggg_toast", "" + msg);
                                    txt_msg_honey.setText(msg);
                                    cardview_honeymoon.setVisibility(View.VISIBLE);

                                } else {

                                    cardview_honeymoon.setVisibility(View.GONE);

                                    Log.e("package_title", "" + object.getString("package_title"));
                                    Log.e("budget", "" + object.getString("budget"));

                                    String package_images = object.getString("package_images");
                                    JSONArray imgarr = new JSONArray(package_images);
                                    String imag = null;
                                    for (int j = 0; j < imgarr.length(); j++) {
                                        // String street = imgarr.getString(0);
                                        JSONObject obj = imgarr.getJSONObject(j);
                                        Log.e("imagee", "" + obj.getString("image"));
                                        imag = obj.getString("image");
                                    }
                                    Log.e("imagee_destination", "" + imag);
                                    Honeymoon_model h_model = new Honeymoon_model(object.getString("id"),
                                            object.getString("category_id"), object.getString("location_id"),
                                            object.getString("package_title"), object.getString("description"),
                                            object.getString("budget"), object.getString("best_time_to_visit"),
                                            object.getString("features"), object.getString("Location_Name"), imag,
                                            object.getString("Category_Name"));
                                    honey_model.add(h_model);
                                }
                            } catch (Exception e) {
                                Log.e("Exception", "" + e);
                            } finally {
                                honey_adapter.notifyItemChanged(i);
                            }
                        }
                    }
                    else {
                        Toast.makeText(getActivity(), "array is null"+arr, Toast.LENGTH_SHORT).show();
                    }
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
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(stringRequest);
        requestQueue.add(stringRequest);


    }

    private void CallVacationSliderApi() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URLVACATION, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("", "" + response);
                try {
                    JSONArray Array_vac = new JSONArray(response);
                    Log.e("arr_vacation", "" + Array_vac);
                    vac_model.clear();
                    for (int i = 0; i < Array_vac.length(); i++) {
                        try {
                            JSONObject object = Array_vac.getJSONObject(i);

                            String msg = null,status;
                            status = object.getString("status");
                            Log.e("status", "" + status);
                            msg = object.getString("message");
                            Log.e("response_msggg_best", "" + msg);


                            if (status.equals("error") == true) {
                                Toast.makeText(getActivity(), "message==" + msg, Toast.LENGTH_SHORT).show();
                                Log.e("response_msggg_toast", "" + msg);
                                txt_msg_vaction.setText(msg);
                                cardview_vaction.setVisibility(View.VISIBLE);

                            } else {
                                cardview_vaction.setVisibility(View.GONE);
                                Log.e("package_title", "" + object.getString("package_title"));
                                Log.e("budget", "" + object.getString("budget"));

                                JSONArray imgarr = object.getJSONArray("package_images");
                                String imag = null;
                                for (int j = 0; j < imgarr.length(); j++) {
                                    // String street = imgarr.getString(0);
                                    JSONObject obj = imgarr.getJSONObject(j);
                                    Log.e("imagee", "" + obj.getString("image"));
                                    imag = obj.getString("image");
                                }
                                Log.e("imagee_destination_vacation", "" + imag);

                                Vacation_model vmodel = new Vacation_model(object.getString("id"),
                                        object.getString("category_id"), object.getString("location_id"),
                                        object.getString("package_title"), object.getString("description"),
                                        object.getString("budget"), object.getString("best_time_to_visit"),
                                        object.getString("features"), object.getString("Location_Name"), imag,
                                        object.getString("Category_Name"));


                                vac_model.add(vmodel);
                            }
                        } catch (Exception e) {
                            Log.e("Exception", "" + e);
                        } finally {
                            vac_adapter.notifyItemChanged(i);
                        }
                    }
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
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(stringRequest);
        requestQueue.add(stringRequest);


    }
*/

  /*  private void callDestionationApi() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URLDESTINATION,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Log.e("response", "" + response);

                        JSONArray arr = null;
                        try {

                            arr = new JSONArray(response);

                            if(arr != null) {
                                Log.e("arr", "" + arr);
                                for (int i = 0; i < arr.length(); i++) {
                                    try {
                                        JSONObject object = arr.getJSONObject(0);
                                        Log.e("object", "" + object);
                                        Log.e("description", "" + object.getString("description"));
                                        Log.e("budget", "" + object.getString("budget"));
                                        cat_id = object.getString("category_id");
                                        Location_id = object.getString("location_id");
                                        AssetManager am = getActivity().getApplicationContext().getAssets();
                                        Typeface typeface = Typeface.createFromAsset(am,
                                                String.format(Locale.getDefault(), "Lato-Bold.ttf"));
                                        Typeface tf = Typeface.createFromAsset(am,
                                                String.format(Locale.getDefault(), "Lato-Black.ttf"));
                                        Typeface medium = Typeface.createFromAsset(am,
                                                String.format(Locale.getDefault(), "Lato-Medium.ttf"));


                                        txtbudget.setTypeface(tf);
                                        txtdesc.setTypeface(medium);
                                        txtpacknm.setTypeface(typeface);


                                        txtbudget.setText(object.getString("budget"));
                                        txtdesc.setText(object.getString("description"));
                                        txtpacknm.setText(object.getString("Location_Name"));
                                        // String package_images=object.getString("package_images");
                                        JSONArray imgarr = object.getJSONArray("package_images");
                                        for (int j = 0; j < imgarr.length(); j++) {
                                            // String street = imgarr.getString(0);
                                            JSONObject obj = imgarr.getJSONObject(j);

                                            Log.e("imagee", "" + obj.getString("image"));
                                            String img = obj.getString("image");
                                            location_img = obj.getString("image");
                                            Log.e("imagee_one_location_img", "" + location_img);

                                            Log.e("imagee_one", "" + img);
                                            // Glide.with(getActivity()).load(street).into(imgdesti);
                                            Bitmap bmw = null;
                                            try {
                                                bmw = Ion.with(getActivity()).load(img).asBitmap().get();
                                                Log.e("imageebmw", "" + bmw);

                                            } catch (InterruptedException e) {
                                                e.printStackTrace();
                                            } catch (ExecutionException e) {
                                                e.printStackTrace();
                                            }
                                            imgdesti.setImageBitmap(bmw);
                                        }


                                        JSONObject objtwo = arr.getJSONObject(1);
                                        Log.e("objecttwo", "" + objtwo);
                                        Log.e("package_titletwo", "" + objtwo.getString("package_title"));
                                        Log.e("descriptiontwo", "" + objtwo.getString("description"));
                                        Log.e("budgettwo", "" + objtwo.getString("budget"));
                                        Log.e("descriptiontwo", "" + objtwo.getString("description"));
                                        txtbudgettwo.setTypeface(tf);
                                        txtdescritwo.setTypeface(medium);
                                        txtpacktwo.setTypeface(typeface);
                                        cat_id2 = objtwo.getString("category_id");
                                        location_id2 = objtwo.getString("location_id");

                                        txtbudgettwo.setText(objtwo.getString("budget"));
                                        txtdescritwo.setText(objtwo.getString("description"));
                                        txtpacktwo.setText(objtwo.getString("Location_Name"));
                                        // String package_images=object.getString("package_images");
                                        JSONArray imgarrtwo = objtwo.getJSONArray("package_images");
                                        for (int k = 0; k < imgarrtwo.length(); k++) {
                                            // String street = imgarr.getString(0);
                                            JSONObject objt = imgarrtwo.getJSONObject(0);

                                            Log.e("imageetwo", "" + objt.getString("image"));
                                            // Glide.with(getActivity()).load(street).into(imgdesti);
                                            String img = objt.getString("image");
                                            Log.e("imageetwo", "" + img);
                                            location_img2 = objt.getString("image");
                                            Log.e("imagee_one_location_img", "" + location_img2);

                                            Bitmap bmw = null;
                                            try {
                                                bmw = Ion.with(getActivity()).load(img).asBitmap().get();
                                                Log.e("imageebmwtwo", "" + bmw);

                                            } catch (InterruptedException e) {
                                                e.printStackTrace();
                                            } catch (ExecutionException e) {
                                                e.printStackTrace();
                                            }
                                            imgdesitwo.setImageBitmap(bmw);
                                        }


                                        //Category_model model = new Category_model(object.getString("id"), object.getString("category_icon"), object.getString("category_name"));
                                        //category_model.add(model);

                                    } catch (Exception e) {
                                        Log.e("Exception", "" + e);
                                    } finally {
                                        //category_adapter.notifyItemChanged(i);

                                    }
                                }

                            }
                            else {
                                Toast.makeText(getActivity(), "array is null"+arr, Toast.LENGTH_SHORT).show();
                                Log.e("arrrrr",""+arr);
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

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(stringRequest);
        requestQueue.add(stringRequest);

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

    private void getCategory() {
        //  pd1.setVisibility(View.VISIBLE);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Log.e("response", "" + response);
                        category_model.clear();
                        // pd1.setVisibility(View.GONE);

                        JSONArray arr = null;
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
                                Log.e("id", "" + object.getString("id"));
                                Log.e("url", "" + object.getString("category_icon"));
                                Category_model model = new Category_model(object.getString("id"), object.getString("category_icon"), object.getString("category_name"));
                                category_model.add(model);

                            } catch (Exception e) {
                                Log.e("Exception", "" + e);
                            } finally {
                                category_adapter.notifyItemChanged(i);

                            }
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //  Toast.makeText(getActivity(), "not get Response" + error, Toast.LENGTH_SHORT).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(stringRequest);
        requestQueue.add(stringRequest);

    }

    private void CallSliderApi() {
        pd2.setVisibility(View.VISIBLE);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URLBANNER,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        sliderimage_models.clear();
                        Log.e("response_banner", "" + response);
                        try {
                            JSONArray arr = new JSONArray(response);
                            pd2.setVisibility(View.GONE);

                            sliderimage_models.clear();
                            Log.e("arr", "" + arr);
                            for (int i = 0; i < arr.length(); i++) {
                                try {
                                    JSONObject object = arr.getJSONObject(i);
                                    Log.e("object", "" + object);
                                    Log.e("package_id", "" + object.getString("package_id"));
                                    Log.e("package_images", "" + object.getString("package_images"));
                                    sliderimage_model imageModel = new sliderimage_model(object.getString("package_images"), object.getString("package_id"));
                                    sliderimage_models.add(imageModel);
                                    Log.e("schedule", "" + sliderimage_models.size());

                                    mPager.setAdapter(new SlidingImage_Adapter(getActivity(), sliderimage_models));
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
                });*//* {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> KeyValuePair = new HashMap<String, String>();
                Log.e("lang", "" + type);
                KeyValuePair.put("type", type);
                return KeyValuePair;

            }
        };*//*
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
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

*/
/*
    private void CallVacationApi() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URLDESTINATION,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Log.e("response", "" + response);

                        JSONArray arr = null;
                        try {

                            arr = new JSONArray(response);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        Log.e("arr", "" + arr);
                        for (int i = 0; i < arr.length(); i++) {
                            try {
                                JSONObject object = arr.getJSONObject(0);
                                Log.e("object", "" + object);
                                Log.e("package_title", "" + object.getString("package_title"));
                                Log.e("description", "" + object.getString("description"));
                                Log.e("budget", "" + object.getString("budget"));
                                Log.e("description", "" + object.getString("description"));
                                txt_vac_budget.setText(object.getString("budget"));
                                //txtdesc.setText(object.getString("description")+"...");
                                txt_vac_title.setText(object.getString("package_title")+"...");
                                // String package_images=object.getString("package_images");
                                JSONArray imgarr=object.getJSONArray("package_images");
                                for (int j=0;j<imgarr.length();j++)
                                {
                                    // String street = imgarr.getString(0);
                                    JSONObject obj=imgarr.getJSONObject(j);

                                    Log.e("imagee",""+obj.getString("image"));
                                    // Glide.with(getActivity()).load(street).into(imgdesti);
                                    Bitmap bmw= null;
                                    try {
                                        bmw = Ion.with(getActivity()).load(obj.getString("image")).asBitmap().get();
                                        Log.e("imageebmw",""+bmw);

                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    } catch (ExecutionException e) {
                                        e.printStackTrace();
                                    }
                                    img_vacation.setImageBitmap(bmw);
                                }
                                JSONObject objtwo = arr.getJSONObject(1);
                                Log.e("objecttwo", "" + objtwo);
                                Log.e("package_titletwo", "" + objtwo.getString("package_title"));
                                Log.e("descriptiontwo", "" + objtwo.getString("description"));
                                Log.e("budgettwo", "" + objtwo.getString("budget"));
                                Log.e("descriptiontwo", "" + objtwo.getString("description"));
                                txt_vac_budgettwo.setText(objtwo.getString("budget"));
                                // txtdescritwo.setText(objtwo.getString("description") + "...");
                                txt_vac_titletwo.setText(objtwo.getString("package_title") + "...");
                                // String package_images=object.getString("package_images");
                                JSONArray imgarrtwo=objtwo.getJSONArray("package_images");
                                for (int k=0;k<imgarrtwo.length();k++)
                                {
                                    JSONObject objt=imgarrtwo.getJSONObject(k);

                                    Log.e("imageetwo",""+objt.getString("image"));
                                    Bitmap bmw= null;
                                    try {
                                        bmw = Ion.with(getActivity()).load(objt.getString("image")).asBitmap().get();
                                        Log.e("imageebmwtwo",""+bmw);

                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    } catch (ExecutionException e) {
                                        e.printStackTrace();
                                    }
                                    img_vacationtwo.setImageBitmap(bmw);
                                }


                            } catch (Exception e) {
                                Log.e("Exception", "" + e);
                            } finally {
                                //category_adapter.notifyItemChanged(i);

                            }
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //  Toast.makeText(getActivity(), "not get Response" + error, Toast.LENGTH_SHORT).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(stringRequest);
        requestQueue.add(stringRequest);

    }
*/

    /* private void CallHoney_DestinationAPI() {
         StringRequest stringRequest = new StringRequest(Request.Method.GET, URLDESTINATION,
                 new Response.Listener<String>() {
                     @Override
                     public void onResponse(String response) {

                         Log.e("response", "" + response);

                         JSONArray arr = null;
                         try {

                             arr = new JSONArray(response);
                         } catch (JSONException e) {
                             e.printStackTrace();
                         }
                         Log.e("arr", "" + arr);
                         for (int i = 0; i < arr.length(); i++) {
                             try {
                                 JSONObject object = arr.getJSONObject(0);
                                 Log.e("object", "" + object);
                                 Log.e("package_title", "" + object.getString("package_title"));
                                 Log.e("description", "" + object.getString("description"));
                                 Log.e("budget", "" + object.getString("budget"));
                                 Log.e("description", "" + object.getString("description"));
                                 txtbudget_honey.setText(object.getString("budget"));
                                 //txtdesc.setText(object.getString("description")+"...");
                                 txt_honey_title.setText(object.getString("package_title") + "...");
                                 // String package_images=object.getString("package_images");
                                 JSONArray imgarr = object.getJSONArray("package_images");
                                 for (int j = 0; j < imgarr.length(); j++) {
                                     // String street = imgarr.getString(0);
                                     JSONObject obj = imgarr.getJSONObject(j);

                                     Log.e("imagee", "" + obj.getString("image"));
                                     // Glide.with(getActivity()).load(street).into(imgdesti);
                                     Bitmap bmw = null;
                                     try {
                                         bmw = Ion.with(getActivity()).load(obj.getString("image")).asBitmap().get();
                                         Log.e("imageebmw", "" + bmw);

                                     } catch (InterruptedException e) {
                                         e.printStackTrace();
                                     } catch (ExecutionException e) {
                                         e.printStackTrace();
                                     }
                                     img_honeydesti.setImageBitmap(bmw);
                                 }


                                 JSONObject objtwo = arr.getJSONObject(1);
                                 Log.e("objecttwo", "" + objtwo);
                                 Log.e("package_titletwo", "" + objtwo.getString("package_title"));
                                 Log.e("descriptiontwo", "" + objtwo.getString("description"));
                                 Log.e("budgettwo", "" + objtwo.getString("budget"));
                                 Log.e("descriptiontwo", "" + objtwo.getString("description"));
                                 txtbudget_honeytwo.setText(objtwo.getString("budget"));
                                 // txtdescritwo.setText(objtwo.getString("description") + "...");
                                 txt_honey_titletwo.setText(objtwo.getString("package_title") + "...");
                                 // String package_images=object.getString("package_images");
                                 JSONArray imgarrtwo = objtwo.getJSONArray("package_images");
                                 for (int k = 0; k < imgarrtwo.length(); k++) {
                                     JSONObject objt = imgarrtwo.getJSONObject(k);

                                     Log.e("imageetwo", "" + objt.getString("image"));
                                     Bitmap bmw = null;
                                     try {
                                         bmw = Ion.with(getActivity()).load(objt.getString("image")).asBitmap().get();
                                         Log.e("imageebmwtwo", "" + bmw);

                                     } catch (InterruptedException e) {
                                         e.printStackTrace();
                                     } catch (ExecutionException e) {
                                         e.printStackTrace();
                                     }
                                     img_honeydestitwo.setImageBitmap(bmw);
                                 }


                             } catch (Exception e) {
                                 Log.e("Exception", "" + e);
                             } finally {
                                 //category_adapter.notifyItemChanged(i);

                             }
                         }
                     }
                 },
                 new Response.ErrorListener() {
                     @Override
                     public void onErrorResponse(VolleyError error) {
                         //  Toast.makeText(getActivity(), "not get Response" + error, Toast.LENGTH_SHORT).show();
                     }
                 });

         RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
         requestQueue.add(stringRequest);
         requestQueue.add(stringRequest);

     }
 */

}



