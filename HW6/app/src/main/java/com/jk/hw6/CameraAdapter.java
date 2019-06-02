package com.jk.hw6;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;



/* Class designed from Head First Android Development Ch. 13 */


class CameraAdapter extends RecyclerView.Adapter<CameraAdapter.ViewHolder> {

    private String[] cameraDescription;
    private String[] cameraUrl;
    private int[] cameraId;
    private Listener listener;

    interface Listener {
        void onClick(int position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private CardView cardView;

        public ViewHolder(CardView v) {
            super(v);
            cardView = v;
        }
    }

    public CameraAdapter(String[] cameraDescription, String[] cameraUrl, int[] cameraId) {
        this.cameraDescription = cameraDescription;
        this.cameraUrl = cameraUrl;
        this.cameraId = cameraId;
    }

    @Override
    public CameraAdapter.ViewHolder onCreateViewHolder(
            ViewGroup parent, int viewType){
        CardView cv = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_camera, parent, false);
        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int cameraId){
        CardView cardView = holder.cardView;
        ImageView imageView = (ImageView)cardView.findViewById(R.id.camera_image);
//        Drawable drawable = ContextCompat.getDrawable(cardView.getContext(), cameraId[position]);
///       imageView.setImageDrawable(drawable);

//        imageView.setContentDescription(cameraName[position]);
//        TextView textView = (TextView)cardView.findViewById(R.id.camera_text);
//        textView.setText(cameraName[position]);
//        cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (listener != null) {
//                    listener.onClick(position);
//                }
//            }
//        });
        Picasso.get().load(cameraUrl[cameraId]).into(imageView);


    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public void setListener(Listener listener){
        this.listener = listener;
    }
}



