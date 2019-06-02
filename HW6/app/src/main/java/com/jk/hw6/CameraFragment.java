package com.jk.hw6;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class CameraFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        RecyclerView cameraRecycler = (RecyclerView)inflater.inflate(R.layout.fragment_camera, container, false);

        String[] cameraDescription = new String[Camera.cameras.length];
        for (int i=0; i < cameraDescription.length; i++){
            cameraDescription[i] = Camera.cameras[i].getDescription();
        }

        String[] cameraUrl = new String[Camera.cameras.length];
        for (int i=0; i<cameraDescription.length; i++){
            cameraUrl[i] = Camera.cameras[i].getCameraUrl();
        }

        int [] cameraId = new int[Camera.cameras.length];
        for (int i=0; i < cameraId.length; i++){
            cameraId[i] = Camera.cameras[i].getCameraId();
        }

        CameraAdapter adapter = new CameraAdapter(cameraDescription, cameraUrl, cameraId);
        cameraRecycler.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        cameraRecycler.setLayoutManager(layoutManager);

//        adapter.setListener(new CameraAdapter.Listener() {
//            public void onClick(int position) {
//                Intent intent = new Intent(getActivity(), CameraDetailActivity.class);
//                intent.putExtra(CameraDetailActivity.CAMERA_ID, position);
//                getActivity().startActivity(intent);
//            }
//        });

        return cameraRecycler;
    }

}
