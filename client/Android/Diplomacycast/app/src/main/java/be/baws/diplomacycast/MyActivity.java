package be.baws.diplomacycast;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import be.baws.diplomacycast.activity.CastHelperActivity;


public class MyActivity extends CastHelperActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
    }

    @Override
    protected int getMenuToInflate() {
       return R.menu.menu_myactivity;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in Andr oidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_hellochromecast) {
            startActivity(new Intent(this, SampleHelloWorld.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
