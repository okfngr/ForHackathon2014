package gr.kccode.hachathon.forhackathon2014;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements LocationListener {

    ArrayList<BasicData> data;
    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    private int id_option = 0;
    private int colour;
    private LocationManager lm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_maps);
        overridePendingTransition(R.anim.zoom_enter, R.anim.zoom_exit);

        Intent intent = getIntent();
        id_option = intent.getIntExtra("id_option", 0);


        if (id_option == 0) {
            data = DbAdapter.getInstance().gethotspots();
        } else if (id_option == 1) {
            data = DbAdapter.getInstance().getParking_Datas();
        } else {
            data = DbAdapter.getInstance().getGashotspots();
        }

        setUpMapIfNeeded();
        if (mMap != null) {
            mMap.setMyLocationEnabled(true);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(40.633257, 22.944343), 10));
        }

        lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 180000, 3, this);


        PlaceMarkers();

    }

    private void PlaceMarkers() {
        if (this.mMap == null) return;
        this.setColour(id_option);
        for (int i = 0; i < data.size(); i++) {


            mMap.addMarker(new MarkerOptions()
                    .position(data.get(i).getPoint())
                    .title(data.get(i).getLabel())
                    .icon(BitmapDescriptorFactory.defaultMarker((float) 16.5)));
        }

        if (id_option == 0) {
            Toast.makeText(getApplicationContext(), getResources().getString(R.string.closer_wifi), Toast.LENGTH_LONG).show();
        } else if (id_option == 1) {
            Toast.makeText(getApplicationContext(), getResources().getString(R.string.closer_parking), Toast.LENGTH_LONG).show();
        } else if (id_option == 2) {
            Toast.makeText(getApplicationContext(), getResources().getString(R.string.closer_gas_station), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p/>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p/>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p/>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */
    private void setUpMap() {
        mMap.clear();
    }

    public void setColour(int id_option) {
        if (id_option == 0) colour = this.getResources().getColor(R.color.wifi);
        else if (id_option == 1) colour = this.getResources().getColor(R.color.parking);
        else if (id_option == 2) colour = this.getResources().getColor(R.color.gas);
    }

    @Override
    public void onLocationChanged(Location location) {


    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
