package net.st4ndard.sampler.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.st4ndard.sampler.MainApplication;
import net.st4ndard.sampler.R;
import net.st4ndard.sampler.databinding.FragmentPadBinding;
import net.st4ndard.sampler.model.Pad;

public class PadFragment extends Fragment {
    FragmentPadBinding binding;
    private static final String colmun = "colmun";
    private static final String row = "row";

    private String mParam1;
    private String mParam2;

    // private OnFragmentInteractionListener mListener;

    public PadFragment() {
        // Required empty public constructor
    }
    public static PadFragment newInstance(int param1, int param2) {
        PadFragment fragment = new PadFragment();
        Bundle args = new Bundle();
        args.putInt(colmun, param1);
        args.putInt(row, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(colmun);
            mParam2 = getArguments().getString(row);
        }
        SharedPreferences data = MainApplication.getInstance().getApplicationContext().getSharedPreferences("DataSave", Context.MODE_PRIVATE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPadBinding.inflate(inflater, container, false);
        Pad pad = new Pad("pad","",Color.rgb(0, 0, 0));
        binding.setPad(pad);
        return binding.getRoot();
    }

    public void onButtonPressed(Uri uri) {
        //
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        /*
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
        */
    }

    @Override
    public void onDetach() {
        super.onDetach();
        //mListener = null;
    }

/*
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
*/
}
