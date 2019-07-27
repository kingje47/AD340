package com.jk.hw7;

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
    private double[] cameraLat;
    private double[]cameraLong;
    private String[] cameraUrl;
    private int[] cameraId;
    private Listener listener;

    interface Listener {
         void onClick(int cameraId);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private CardView cardView;

        public ViewHolder(CardView v) {
            super(v);
            cardView = v;
        }
    }

    public CameraAdapter(String[] descriptions, double[] lats, double[] longs, String[] urls, int[]ids) {
        this.cameraDescription = descriptions;
        this.cameraLat = lats;
        this.cameraLong = longs;
        this.cameraUrl = urls;
        this.cameraId = ids;
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
        TextView textView = (TextView)cardView.findViewById(R.id.camera_text);
        textView.setText(cameraDescription[cameraId]);
        textView.append(System.getProperty ("line.separator") + "Latitude: " + cameraLat[cameraId]);
        textView.append(System.getProperty ("line.separator") + "Longitude: " +  cameraLong[cameraId]);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onClick(cameraId);
                }
            }
        });
        Picasso.get().load(cameraUrl[cameraId]).into(imageView);


    }

    @Override
    public int getItemCount() {
        return cameraId.length;
    }

    public void setListener(Listener listener){
        this.listener = listener;
    }
}



