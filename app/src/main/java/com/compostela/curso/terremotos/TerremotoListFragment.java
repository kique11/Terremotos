package com.compostela.curso.terremotos;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.compostela.curso.terremotos.model.Terremoto;

import java.util.Arrays;
import java.util.List;


/**
 * Created by mañá on 04/02/2015.
 */
public class TerremotoListFragment extends Fragment {

    private List<Terremoto> terremotoList;
    private ListView list;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        terremotoList = Arrays.asList(
                new Terremoto("1", "titulo1", "http://", null),
                new Terremoto("1", "titulo1", "http://", null),
                new Terremoto("1", "titulo1", "http://", null),
                new Terremoto("1", "titulo1", "http://", null)
                );

        list = (ListView)getActivity().findViewById(R.id.lvTerremotos);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_terremoto_list, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayAdapter<Terremoto> arrayAdapter = new ArrayAdapter<Terremoto>(getActivity(), android.R.layout.simple_list_item_1, terremotoList);

        list.setAdapter(arrayAdapter);
    }
}
