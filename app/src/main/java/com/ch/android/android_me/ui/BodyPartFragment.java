package com.ch.android.android_me.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ch.android.android_me.R;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;

public class BodyPartFragment extends Fragment {
    private static final String TAG = "BodyPartFragment";
    private static final String IMAGE_ID_LIST = "image_ids";
    private static final String LIST_INDEX = "list_index";

    private List<Integer> mImageIds;
    private int mListIndex;

    public BodyPartFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if (savedInstanceState != null) {
            mImageIds = savedInstanceState.getIntegerArrayList(IMAGE_ID_LIST);
            mListIndex = savedInstanceState.getInt(LIST_INDEX);
        }

        View rootView = inflater.inflate(R.layout.fragment_body_part, container, false);

        final ImageView imageView = rootView.findViewById(R.id.body_part_image_view);

        if(mImageIds != null) {
            imageView.setImageResource(mImageIds.get(mListIndex));

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mListIndex < mImageIds.size()-1) {
                        mListIndex++;
                    } else {
                        mListIndex = 0;
                    }
                    imageView.setImageResource(mImageIds.get(mListIndex));
                }
            });
        } else {
            Log.v(TAG, "This fragment has a null list of image id's");
        }

        return rootView;
    }

    public void setImageIds(List<Integer> imageIds) {
        mImageIds = imageIds;
    }

    public void setListIndex(int index){
        mListIndex = index;
    }

    @Override
    public void onSaveInstanceState(Bundle currentState){
        currentState.putIntegerArrayList(IMAGE_ID_LIST, (ArrayList<Integer>) mImageIds);
        currentState.putInt(LIST_INDEX, mListIndex);


    }
}
