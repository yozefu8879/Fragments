package com.example.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentOne.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentOne#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentOne extends Fragment {

   private EditText textViewFragmentOne;
   private Button buttonFragmentOne;

    private ImageView indicator;
    private int colorId;

    private void changeColor(){
        indicator.setColorFilter(ContextCompat.getColor(getContext(), colorId));
        return;
    }

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public FragmentOne() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static FragmentOne newInstance() {
        FragmentOne fragment = new FragmentOne();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_fragment_one, container, false);

        textViewFragmentOne = rootView.findViewById(R.id.editText);
        buttonFragmentOne = rootView.findViewById(R.id.buttonFragmentOne);
        indicator = rootView.findViewById(R.id.indicator);
        buttonFragmentOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onButtonPressed(colorId);
            }
        });
        Button colorOne = rootView.findViewById(R.id.color1);
        Button colorTwo = rootView.findViewById(R.id.color2);
        Button colorThree = rootView.findViewById(R.id.color3);
        Button colorFour = rootView.findViewById(R.id.color4);
        colorOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                colorId = android.R.color.holo_blue_dark;
                changeColor();
            }
        });
        colorTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                colorId = android.R.color.holo_green_dark;
                changeColor();
            }
        });
        colorThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                colorId = android.R.color.holo_orange_dark;
                changeColor();
            }
        });
        colorFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                colorId = android.R.color.holo_red_dark;
                changeColor();
            }
        });
        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(int colorId) {
        if (mListener != null) {
            mListener.onFragmentInteraction(textViewFragmentOne.getText().toString(),colorId);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(String s, int colorId);
    }
}
