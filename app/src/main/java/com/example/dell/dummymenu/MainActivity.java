package com.example.dell.dummymenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import java.security.PrivilegedAction;

public class MainActivity extends AppCompatActivity implements ActionMode.Callback,View.OnLongClickListener {
    private static final String TAG = MainActivity.class.getSimpleName();
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView mImageViewIcon=(ImageView)findViewById(R.id.image_view_icon_main_activity);
       // mImageViewIcon.setOnClickListener(R);
        registerForContextMenu(mImageViewIcon);
        ImageView mImagebotmViewIcon=(ImageView)findViewById(R.id.image_view_icon_botm_main_activity);
            mImagebotmViewIcon.setOnLongClickListener(this);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       switch(item.getItemId())
        {
            case R.id.add_item:
                Log.v(MainActivity.TAG,"add_item");
            break;
            case R.id.item_like:
                Log.v(MainActivity.TAG,"item_like");
            break;
            case R.id.dis_like_item:
                Log.v(MainActivity.TAG,"dis_like_item");
            break;
            default:  Log.v(MainActivity.TAG,"Error");

        }
            return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
        ////onCreateOptionsMenu(menu) return true but you could replace to  return true
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_main,menu);
        //menu_context_floting
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch(item.getItemId())
        {
            case R.id.add_item:
                Log.e(MainActivity.TAG,"add_item");
                break;
            case R.id.item_like:
                Log.e(MainActivity.TAG,"item_like");
                break;
            case R.id.dis_like_item:
                Log.e(MainActivity.TAG,"dis_like_item");
                break;
            default:  Log.e(MainActivity.TAG,"Error");

        }
        return super.onContextItemSelected(item);

    }

    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        return false;
    }

    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {

return false;
    }

    @Override
    public void onDestroyActionMode(ActionMode mode) {

    }

    @Override
    public boolean onLongClick(View v) {

        if (v.getId()==R.id.image_view_icon_botm_main_activity)
       startSupportActionMode(this);
        return false;
    }
}
