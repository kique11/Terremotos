package com.compostela.curso.terremotos;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.compostela.curso.terremotos.model.Terremoto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;


/**
 * Created by mañá on 04/02/2015.
 */
public class TerremotoListFragment extends Fragment {

    private List<Terremoto> terremotoList = new ArrayList<Terremoto>();
    private ListView list;
    private ArrayAdapter<Terremoto> arrayAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_terremoto_list, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        list = (ListView)getActivity().findViewById(R.id.lvTerremotos);
        arrayAdapter = new ArrayAdapter<Terremoto>(getActivity(), android.R.layout.simple_list_item_1, terremotoList);
        list.setAdapter(arrayAdapter);

        registerForContextMenu(list);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        final int position = ((AdapterView.AdapterContextMenuInfo) menuInfo).position;
        final Terremoto item = arrayAdapter.getItem(position);
        menu.setHeaderTitle(item.getTitle());
        getActivity().getMenuInflater().inflate(R.menu.menu_result_context, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        final int position = ((AdapterView.AdapterContextMenuInfo) item.getMenuInfo()).position;
        final Terremoto terremoto = arrayAdapter.getItem(position);

        Intent intent = new Intent(getActivity(), DetailActivity.class);
        intent.putExtra("terremoto", terremoto);
        startActivity(intent);

        return super.onContextItemSelected(item);

    }

    public void search(int intensidad, Calendar fecha) {
        terremotoList = Arrays.asList(
                new Terremoto("1", "titulo1", "http://", null),
                new Terremoto("1", "titulo1", "http://", null),
                new Terremoto("1", "titulo1", "http://", null),
                new Terremoto("1", "titulo1", "http://", null)
        );
        arrayAdapter.addAll(terremotoList);
    }
}
