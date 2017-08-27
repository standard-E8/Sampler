package net.st4ndard.sampler.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.st4ndard.sampler.MainApplication;
import net.st4ndard.sampler.RecyclerAdapter;
import net.st4ndard.sampler.databinding.FragmentPadBinding;
import net.st4ndard.sampler.model.Pad;

import java.util.ArrayList;
import java.util.List;

public class PadFragment extends Fragment {
    FragmentPadBinding binding;
    private static final String colmun = "colmun";
    private static final String row = "row";

    private String mParam1;
    private String mParam2;

    // private OnPadFragmentListener mListener;

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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Context context = MainApplication.getInstance().getApplicationContext();
        binding = FragmentPadBinding.inflate(inflater, container, false);
        Pad pad = new Pad("pad","",Color.rgb(0, 0, 0));
        binding.setPad(pad);
        /*
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("button", "clicked!");
            }});
        binding.button.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v){
                Log.v("button","Longclicked");
                return true;
            }
        });*/
        SharedPreferences data = context.getSharedPreferences("DataSave", Context.MODE_PRIVATE);
        List<Pad> pads = new ArrayList<>();
        pads.add(new Pad("pad1","",5));
        pads.add(new Pad("pad2","",5));

        RecyclerAdapter adapter = new RecyclerAdapter(pads);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(context));
        binding.recyclerView.setAdapter(adapter);
        return binding.getRoot();
    }

    public void onButtonPressed(Uri uri) {
        //
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        /*
        if (context instanceof OnPadFragmentListener) {
            mListener = (OnPadFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnPadFragmentListener");
        }*/
    }

    @Override
    public void onDetach() {
        super.onDetach();
        //mListener = null;
    }
    /*
    public interface OnPadFragmentListener {
        void onFragmentInteraction(Uri uri);
    }*/
}
