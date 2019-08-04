package com.nkima.blacktwitter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class Search_ForYouFragment extends Fragment implements AdapterView.OnItemSelectedListener {
    private Spinner trendingSpinner;

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate( R.layout.fragment_search_for_you, container, false );

        trendingSpinner = rootView.findViewById( R.id.trend_Spinner );
        trendingSpinner.setOnItemSelectedListener( this );

        List <String> trends = new ArrayList <>();
        trends.add( "This trend is spam" );
        trends.add( "This trend is abusive or harmful" );
        trends.add( "This trend is a duplicate" );
        trends.add( "This trend is low quality" );

        //creating an adapter for the spinner
        ArrayAdapter<String> choicesAdapter = new ArrayAdapter <>( rootView.getContext(), android.R.layout.simple_spinner_item, trends );

        //dropdown list style
        choicesAdapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );

        //attach spinner to adapter
        trendingSpinner.setAdapter( choicesAdapter );

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onItemSelected(AdapterView <?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView <?> adapterView) {

    }
}
