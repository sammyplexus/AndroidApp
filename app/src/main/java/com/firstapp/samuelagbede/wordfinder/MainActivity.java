package com.firstapp.samuelagbede.wordfinder;
import android.app.Activity;
import android.app.ProgressDialog;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import org.json.JSONArray;
import org.json.JSONException;

public class MainActivity extends ActionBarActivity {


       @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager vp = (ViewPager)findViewById(R.id.viewpager);
        vp.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
        vp.setCurrentItem(0);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId()){
            case R.id.Search : Toast.makeText(this, "You just clicked the search", Toast.LENGTH_LONG).show();
                break;
        }
        return true;
    }

}
