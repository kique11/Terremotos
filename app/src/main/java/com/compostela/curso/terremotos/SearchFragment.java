package com.compostela.curso.terremotos;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.Calendar;
import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the

 * create an instance of this fragment.
 */
public class SearchFragment extends Fragment {
    private Spinner lvIntensidad;
    private Button butSearch;
    private DatePicker dpFecha;

    public SearchFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        butSearch = (Button)getActivity().findViewById(R.id.btn_search);
        lvIntensidad = (Spinner)getActivity().findViewById(R.id.intensidadList);
        dpFecha = (DatePicker)getActivity().findViewById(R.id.dateText);
    }

    public void setOnClickListener(View.OnClickListener listener){
        butSearch.setOnClickListener(listener);
    }

    public Calendar getFecha() {
        Calendar date = Calendar.getInstance();
        date.set(dpFecha.getYear(), dpFecha.getMonth(), dpFecha.getDayOfMonth());

        return date;
    }

    public int getIntensidad() {
        return Integer.parseInt(lvIntensidad.getSelectedItem().toString());
    }
}
