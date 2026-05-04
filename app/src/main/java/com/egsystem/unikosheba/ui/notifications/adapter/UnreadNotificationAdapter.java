package com.egsystem.unikosheba.ui.notifications.adapter;


import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.egsystem.unikosheba.R;
import com.egsystem.unikosheba.data.SharedData;
import com.egsystem.unikosheba.model.AllNotificationModel;
import com.egsystem.unikosheba.model.NotificationMarkAsReadModel;
import com.egsystem.unikosheba.retrofit.RetrofitApiClient;

import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class UnreadNotificationAdapter extends RecyclerView.Adapter<UnreadNotificationAdapter.AppointmentHistoryViewHolder> {

    private List<String> dataSet = new ArrayList<>();
    private List<AllNotificationModel.Notification> appointmentList = new ArrayList<>();
    private List<String> popularTopicTitleList = new ArrayList<>();
    private List<String> popularTopicPriceList = new ArrayList<>();
    private boolean allItemStatus = false;
    Context context;
    String from_where = "";

    Cursor dataCursor;

//    private List<String> favTopicList = new ArrayList<>();


    String categoryName = "";

    String title;
    String category_id;
    private List<String> memberListFiltered = new ArrayList<>();


    private AdapterCallback adapterCallback;

    public UnreadNotificationAdapter(Context context) {
        this.context = context;

        try {
            adapterCallback = ((AdapterCallback) context);
        } catch (ClassCastException e) {
//            throw new ClassCastException("Activity must implement AdapterCallback.", e);
        }

    }


    public UnreadNotificationAdapter(Context context, Cursor cursor) {
        dataCursor = cursor;
        this.context = context;
        Log.d("tag1wwwww", " adapter: ");
    }


    public void setData(List<AllNotificationModel.Notification> appointmentList, String from_where) {
        this.appointmentList = appointmentList;
        this.from_where = from_where;
        Log.d("tagResponse", " appointmentList: " + appointmentList);
    }


    @Override
    public int getItemCount() {
        return appointmentList.size();
    }


    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public AppointmentHistoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_item_unread_notification_list, parent, false);
        AppointmentHistoryViewHolder myViewHolder = new AppointmentHistoryViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                listener.onItemClick(v, myViewHolder.getPosition());
            }
        });
        return myViewHolder;
    }


    @Override
    public void onBindViewHolder(final AppointmentHistoryViewHolder holder, int position) {
        TextView txtSlNo = holder.txtSlNo;
        TextView tv1 = holder.tv1;
        TextView tv2 = holder.tv2;
        TextView tv3 = holder.tv3;
        TextView tv4 = holder.tv4;
        TextView tv_details = holder.tv_details;
        TextView tv_price = holder.tv_price;
        TextView tv_remove_item = holder.tv_remove_item;
        LinearLayout linear1 = holder.linear1;
        RelativeLayout relative1 = holder.relative1;
        ImageView imageView = holder.imageView;
        ImageView imageViewTick = holder.imageViewTick;
        CardView card1 = holder.card1;


//        imageView.setAnimation(AnimationUtils.loadAnimation(context, R.anim.fade_transition_animation));
//        cardview.setAnimation(AnimationUtils.loadAnimation(context, R.anim.fall_down_animation));


        AllNotificationModel.Notification appointment = appointmentList.get(position);


        int notifiId = appointment.getId();
        String date1 = appointment.getCreatedAt();
        String message_json = appointment.getData();
//        String aStatus = appointment.getStatus();


        String string = "2016-12-02T00:00:00.000Z";
        String defaultTimezone = TimeZone.getDefault().getID();
        Date date = null;
        try {
            date = (new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")).parse(string.replaceAll("Z$", "+0000"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

//        Log.i("string: " + string);
//        Log.i("defaultTimezone: " + defaultTimezone);
        String final_date = (new SimpleDateFormat("HH:mm a   dd,MMM yyyy")).format(date);


        Log.d("tag12345", "message_json: " + message_json);

//        String pathStr = "C:\\tempFolder\\temp.txt";
//        pathStr = pathStr.replaceAll("\\\\","");

        String actualMessage = "";


        try {

            JSONObject obj = new JSONObject(message_json);
            actualMessage = obj.getString("message");


        } catch (Throwable tx) {
            Log.e("My App", "Could not parse malformed JSON: \"" + message_json + "\"");
        }


        tv1.setText(actualMessage);
        tv2.setText(final_date);
//        tv3.setText("Status: " + aStatus);
//        tv4.setText(date);


//        if (from_where.equalsIgnoreCase("explore_fragment")){
//            if (position > 3) {
//                card1.setVisibility(View.GONE);
//                holder.itemView.setLayoutParams(new RecyclerView.LayoutParams(0, 0));
//            }
//        }


//        Glide.with(context).load(imageLink).into(imageView);

        String finalActualMessage = actualMessage;
        tv_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Intent intent = new Intent(context, PopularProgrammsDetailsActivity.class);
//                context.startActivity(intent);

                notification_mark_as_read(notifiId);


                boolean wrapInScrollView = true;
                MaterialDialog dialog = new MaterialDialog.Builder(context)
                        .customView(R.layout.material_dialog_notification_view, wrapInScrollView)
                        .build();

                TextView tv1 = dialog.getCustomView().findViewById(R.id.tv1);
                TextView tv2 = dialog.getCustomView().findViewById(R.id.tv2);
                LinearLayout linear_yes = dialog.getCustomView().findViewById(R.id.linear_yes);


                tv1.setText(finalActualMessage);
                tv2.setText(final_date);

                linear_yes.setOnClickListener(view1 -> {
                    dialog.dismiss();
                });


                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                WindowManager.LayoutParams wmlp = dialog.getWindow()
                        .getAttributes();
                wmlp.width = WindowManager.LayoutParams.MATCH_PARENT;
                wmlp.height = WindowManager.LayoutParams.WRAP_CONTENT;
                dialog.show();

                dialog.setCancelable(true);
                dialog.setCanceledOnTouchOutside(true);



            }
        });


    }


    @SuppressLint("CheckResult")
    private void notification_mark_as_read(int notifiId) {

        String token = SharedData.getTOKEN(context);
        Log.d("tag11111", " token: " + token);
        String authorization = "Bearer" + " " + token;
        String accept = "application/json";

        Log.d("tag3344", "notifiId : " + notifiId);

        RetrofitApiClient.getApiInterface().notification_mark_as_read(authorization, accept, notifiId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {

                            Log.d("tag3344", response.toString());
                            Log.d("tag3344", response.message().toString());
                            Log.d("tag3344", String.valueOf(response.code()));
                            Log.d("tag3344", "response.body(): " + response.body().toString());

                            if (response.isSuccessful()) {

                                NotificationMarkAsReadModel model = response.body();
                                String message = model.getMessage();

                                Log.d("tag3344", "message: " + message);

                                boolean success = model.getSuccess();
                                String responseString = response.message();
                                Log.d("tag3344", "Response String:" + responseString);


                            } else {
                                Log.d("tag20", "response.isSuccessful(): not successful");
                            }
                        },
                        error -> {
                            Log.d("tag20", error.getMessage().toString());

                        },
                        () -> {
                            Log.d("tag3344", "onComplete");
                        }
                );


    }


    class AppointmentHistoryViewHolder extends RecyclerView.ViewHolder {

        TextView txtSlNo;
        TextView tv1;
        TextView tv2;
        TextView tv3;
        TextView tv4;
        TextView tv_details;

        TextView tv_price;
        TextView tv_remove_item;
        LinearLayout linear1;
        RelativeLayout relative1;

        ImageView imageView;
        ImageView imageViewTick;
        CardView card1;

        public AppointmentHistoryViewHolder(View itemView) {
            super(itemView);
            tv1 = itemView.findViewById(R.id.tv1);
            tv2 = itemView.findViewById(R.id.tv2);
            tv3 = itemView.findViewById(R.id.tv3);
            tv4 = itemView.findViewById(R.id.tv4);
            tv_details = itemView.findViewById(R.id.tv_details);
//            imageView = itemView.findViewById(R.id.imageView);
            relative1 = itemView.findViewById(R.id.relative1);
//            linear1 = itemView.findViewById(R.id.linear1);
            card1 = itemView.findViewById(R.id.card1);

        }
    }


//    @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
//    public void filter(CharSequence charText) {
//
//        List<String> filteredList = new ArrayList<>();
//        String charString = charText.toString();
//
//        if (charString.length() == 0) {
//////         memberListFiltered = dataSet;
////         filteredList.addAll(dataSet);
//            Log.i("tag", String.valueOf("1:  "+charString.length())+dataSet);
//
//
//        }
//
//        if (charString.isEmpty() || charString.equalsIgnoreCase("")) {
//            memberListFiltered = titleList;
//        } else {
////         List<MemberInfoModel.Result> filteredList = new ArrayList<>();
//            for (String row : titleList) {
//                if (
//                        row.toLowerCase().contains(charString.toLowerCase())
////                                ||
////                                row.getMobile().toLowerCase().contains(charString.toLowerCase())
////                                ||
////                                row.getYear().toLowerCase().contains(charString.toLowerCase())
////                                ||
////                                row.getMember_id_String().toLowerCase().contains(charString.toLowerCase())
////                             ||
////                             row.getTakaAmount().toLowerCase().contains(charString.toLowerCase()) ||
////                             row.getPaymentStatus().toLowerCase().contains(charString.toLowerCase())
//                ) {
//                    filteredList.add(row);
//                }
//            }
//
//            Log.i("tag", "2:  "+String.valueOf(charString.length())+filteredList);
//
//            memberListFiltered = filteredList;
//        }
//
////     Filter.FilterResults filterResults = new Filter.FilterResults();
////     filterResults.values = memberListFiltered;
//        this.setData(memberListFiltered, memberListFiltered, memberListFiltered);
//        this.notifyDataSetChanged();
//    }


    public interface AdapterCallback {
        void onMethodCallback(List<String> favTopicList);

        void onMethodCallback();
    }


}

