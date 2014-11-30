package gr.kccode.hachathon.forhackathon2014;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class MainMenu extends Activity {

    private GridView gridView;
    static final String[] menuOptions = new String[] {"Wifi", "Parking","Gas Station", "Events", "Culture", "About" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main_menu);

        DbAdapter.getInstance().setDB(new DbHelper(this));

        gridView = (GridView) findViewById(R.id.gridView);

        gridView.setAdapter(new GridAdapter(this, menuOptions));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                if (position == 0){
                    Intent intent = new Intent(MainMenu.this, MapsActivity.class);
                    intent.putExtra("id_option",position);
                    MainMenu.this.startActivity(intent);
                }
                else if (position == 1){
                    Intent intent = new Intent(MainMenu.this, MapsActivity.class);
                    intent.putExtra("id_option",position);
                    MainMenu.this.startActivity(intent);
                }
                else if (position == 2){
                    Intent intent = new Intent(MainMenu.this, MapsActivity.class);
                    intent.putExtra("id_option",position);
                    MainMenu.this.startActivity(intent);
                }
                else if (position == 3){
                    Intent intent = new Intent(MainMenu.this, Calendar.class);
                    MainMenu.this.startActivity(intent);
                }
                else if (position == 4){
                    Intent intent = new Intent(MainMenu.this, Culture.class);
                    MainMenu.this.startActivity(intent);
                }
                else if (position == 5){
                    Intent intent = new Intent(MainMenu.this, About.class);
                    MainMenu.this.startActivity(intent);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
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
