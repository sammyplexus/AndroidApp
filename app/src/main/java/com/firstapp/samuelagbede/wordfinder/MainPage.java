package com.firstapp.samuelagbede.wordfinder;


import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;

/**
 * Created by SamuelAgbede on 8/12/2015.
 */

public class MainPage extends Fragment {
    Button button;
    ProgressDialog pDial;
    String name1;
public static TextView getShown;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        pDial = new ProgressDialog(getActivity());
        final View v = inflater.inflate(R.layout.mainpage, container, false);
        button = (Button)v.findViewById(R.id.buttonmain);
        getShown = (TextView)v.findViewById(R.id.wordsGetShown);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView name = (TextView) v.findViewById(R.id.word);
                name1 = name.getText().toString();
                name1 = name1.replace(' ', '+');
                Log.d("Name 1 holds", name1);


                pDial.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                pDial.setTitle("Fetching your words");
                pDial.setMessage("Almost there");

                if (name1.equals("")) {
                    Toast.makeText(getActivity(), "Please enter your String", Toast.LENGTH_LONG).show();
                } else {
                    pDial.show();

                    String url = "http://www.samuelagbede.com/wordfinder/words1.php?word=" + name1 + "&amt=5&submit=Submit";

                    MainPage.getShown.setText(" ");

                    JsonArrayRequest jare = new JsonArrayRequest(Request.Method.GET, url, new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {

                             pDial.hide();
                             Log.d("Response", response.toString());

                            for (int i = 0; i < response.length(); i++) {

                                try {
                                    Log.d("Values", response.getString(i));
                                    MainPage.getShown.append(response.getString(i) + ", ");
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            pDial.hide();
                            Log.d("Error", error.toString());
                            MainPage.getShown.setText("Something's Up. Please check your internet connection and try again! :)");
                        }
                    });
                    jare.setRetryPolicy(new DefaultRetryPolicy(
                            7000,
                            DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                            DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
                    ));
                    Singleton.getInstance(getActivity()).addToRequestQueue(jare);


                }
            }});
        return v;
    }


}
