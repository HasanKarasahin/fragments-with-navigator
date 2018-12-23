package base;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.hasan.fragments_with_navigator.R;

import Fragments.ChangeFragment;
import Fragments.Abstract.AFrondFrag;
import Fragments.Abstract.ABackInnerFrag;
import Fragments.Abstract.ABackFrag;
import Fragments.Fragments;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ChangeFragment changeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        changeFragment = new ChangeFragment(MainActivity.this);

        Toast.makeText(this, "Create Calisti", Toast.LENGTH_SHORT).show();
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if (fragment == null) {
            changeFragment.replace_fragment(Fragments.Frond_Splash);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        Toast.makeText(this, "Resume Calisti", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
            return;
        }
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if (fragment != null) {
            if (fragment instanceof AFrondFrag) {
                Toast.makeText(this, "Ön Taraftasın- Uygulamadan Çık", Toast.LENGTH_SHORT).show();
            } else if (fragment instanceof ABackInnerFrag) {
                if (getSupportFragmentManager().getBackStackEntryCount() > 0)
                    super.onBackPressed();
                else
                    Toast.makeText(this, "YOKK", Toast.LENGTH_SHORT).show();
            } else if (fragment instanceof ABackFrag) {
                Toast.makeText(this, "ABack", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        Fragments fragments;
        switch (item.getItemId()) {
            case R.id.nav_home:
                fragments = Fragments.Back_Home;
                break;
            case R.id.nav_import:
                fragments = Fragments.Back_Import;
                break;
            case R.id.nav_gallery:
                fragments = Fragments.Back_Gallery;
                break;
            case R.id.nav_slideshow:
                fragments = Fragments.Back_Slideshow;
                break;
            case R.id.nav_tools:
                fragments = Fragments.Back_Tools;
                break;
            default:
                fragments = Fragments.Back_Home;
                break;
        }
        changeFragment.replace_fragment(fragments, MainActivity.this);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
