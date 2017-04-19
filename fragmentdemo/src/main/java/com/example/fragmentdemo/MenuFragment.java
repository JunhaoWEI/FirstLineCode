package com.example.fragmentdemo;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MenuFragment extends Fragment implements AdapterView.OnItemClickListener{
    private ListView menuList;
    private ArrayAdapter<String> adapter;

    private String[] menuItems = {"sound", "Display"};

    private boolean isTowPane;


    public MenuFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        adapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, menuItems);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        menuList = (ListView) view.findViewById(R.id.menu_list);
        menuList.setAdapter(adapter);
        menuList.setOnClickListener((View.OnClickListener) MenuFragment.this);


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity().findViewById(R.id.details_layout) != null) {
            isTowPane = true;
        } else {
            isTowPane = false;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (isTowPane) {
            Fragment fragment = null;
            if (position == 0) {
                fragment = new SoundFragment();
            } else if (position == 1) {
                fragment = new MenuFragment();
            }
            getFragmentManager().beginTransaction().replace(R.id.details_layout, fragment).commit();
        } else {
            Intent intent = null;
            if (position == 0) {
                intent = new Intent(getActivity(), SoundActivity.class);
            } else if (position == 1) {
                intent = new Intent(getActivity(), DisplayActivity.class);
            }
            startActivity(intent);
        }
    }
}
