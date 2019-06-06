package com.jk.hw7;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
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

        private LinearLayout linearLayout;

        public ViewHolder(LinearLayout v) {
            super(v);
            linearLayout = v;
        }
    }

    public CameraAdapter(String[] descriptions, String[] urls, int[]ids) {
        this.cameraDescription = descriptions;
        this.cameraUrl = urls;
        this.cameraId = ids;
    }

    @Override
    public CameraAdapter.ViewHolder onCreateViewHolder(
            ViewGroup parent, int viewType){
        LinearLayout cv = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_camera_detail, parent, false);
        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int cameraId){
        LinearLayout linearLayout = holder.linearLayout;
        ImageView imageView = (ImageView)linearLayout.findViewById(R.id.camera_image);
//        Drawable drawable = ContextCompat.getDrawable(cardView.getContext(), cameraId[position]);
///       imageView.setImageDrawable(drawable);
//        imageView.setContentDescription(cameraName[position]);
        TextView textView = (TextView)linearLayout.findViewById(R.id.camera_text);
        textView.setText(cameraDescription[cameraId]);
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
        return cameraId.length;
    }

//    public void setListener(Listener listener){
//        this.listener = listener;
//    }
}



