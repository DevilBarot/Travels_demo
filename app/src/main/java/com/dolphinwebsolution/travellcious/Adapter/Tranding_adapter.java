package com.dolphinwebsolution.travellcious.Adapter;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dolphinwebsolution.travellcious.Activity.Package_Alldetail;
import com.dolphinwebsolution.travellcious.Model.Bestselling_Package_model;
import com.dolphinwebsolution.travellcious.Model.Tranding_model;
import com.dolphinwebsolution.travellcious.R;

import java.util.List;
import java.util.Locale;


public class Tranding_adapter extends RecyclerView.Adapter<com.dolphinwebsolution.travellcious.Adapter.Tranding_adapter.MyViewHolder> {
    String id, cat_name;
    private List<Tranding_model> model;
    private Context context;
    LayoutInflater inflater;

    public Tranding_adapter(Context context, List<Tranding_model> model) {
        this.context = context;
        this.model = model;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public com.dolphinwebsolution.travellcious.Adapter.Tranding_adapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.bestselling_trading_row, parent, false);
        return new com.dolphinwebsolution.travellcious.Adapter.Tranding_adapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(com.dolphinwebsolution.travellcious.Adapter.Tranding_adapter.MyViewHolder holder, final int position) {

        final Tranding_model package_model = model.get(position);
        AssetManager am = context.getApplicationContext().getAssets();
        Typeface typeface = Typeface.createFromAsset(am,
                String.format(Locale.getDefault(), "Lato-Bold.ttf"));
        Typeface tf = Typeface.createFromAsset(am,
                String.format(Locale.getDefault(), "Lato-Black.ttf"));

        holder.txt_pack_title.setTypeface(typeface);
        holder.txt_duration.setTypeface(typeface);
        holder.txt_budget.setTypeface(tf);
        holder.txt_night.setTypeface(typeface);

        holder.txt_pack_title.setText(package_model.getPackage_title());
        holder.txt_duration.setText(package_model.getDuration() + " /");
        holder.txt_night.setText(package_model.getNight());
        holder.txt_budget.setText(Html.fromHtml((package_model.getBudget() + "<font color='Gray'><small>  per person on twin sharing</small></font>")));


        holder.lv_package.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                id = model.get(position).getId();
                Log.e("id", "" + id);
                Intent i = new Intent(context, Package_Alldetail.class);
                i.putExtra("id", id);
                activity.startActivity(i);
                activity.overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);

            }
        });
    }


    @Override
    public int getItemCount() {
        return model.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView txt_duration, txt_pack_title, txt_budget, txt_night;
        public ImageView img_cat;
        LinearLayout lv_package;

        public MyViewHolder(View itemView) {
            super(itemView);

            txt_duration = (TextView) itemView.findViewById(R.id.txt_duration);
            txt_night = (TextView) itemView.findViewById(R.id.txt_night);
            txt_pack_title = (TextView) itemView.findViewById(R.id.txt_pack_title);
            txt_budget = (TextView) itemView.findViewById(R.id.txt_budget);
            lv_package = (LinearLayout) itemView.findViewById(R.id.lv_package);
        }
    }
}




