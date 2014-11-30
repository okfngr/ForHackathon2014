package gr.kccode.hachathon.forhackathon2014;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.MarkerOptions;

public class CultureItem extends FragmentActivity {

    private GoogleMap mMap;
    private int id_culture;
    private Culture_Data cd;
    private ImageButton culturePhoto;
    private TextView cultureTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_culture_item);

        id_culture=getIntent().getIntExtra("id_culture",0);

        cd=DbAdapter.getInstance().getCulturebyId(id_culture);

        culturePhoto = (ImageButton)findViewById(R.id.culturePhoto);
        culturePhoto.setBackgroundResource(R.drawable.wifi);

        cultureTitle = (TextView)findViewById(R.id.cultureName);
        cultureTitle.setText("kapoio culture");

        setUpMap();

    }

    private void setUpMap() {
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) this.getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null&& cd!=null) {
               // mMap.clear();
                mMap.addMarker(new MarkerOptions()
                        .position(cd.getPoint())
                        .title(cd.getLabel())
                        .icon(BitmapDescriptorFactory.defaultMarker((float) 10.0)));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(cd.getPoint(), 12));

            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.culture_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
