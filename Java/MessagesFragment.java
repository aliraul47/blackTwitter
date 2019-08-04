package com.nkima.blacktwitter;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MessagesFragment extends Fragment {
    private FloatingActionButton newMessage;

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate( R.layout.fragment_messages, container, false );

        newMessage = rootView.findViewById( R.id.newMessage );
        newMessage.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent( getContext(), NewMessageActivity.class ) );
            }
        } );

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
