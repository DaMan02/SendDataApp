package com.example.dayal.senddataapp;

import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ShareActionProvider;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.util.JsonToken.NULL;

public class MainActivity extends AppCompatActivity {
    Button btn;
    EditText text;
    String msg;
    MenuItem menuItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        btn=(Button)findViewById(R.id.btn);
        text=(EditText)findViewById(R.id.edit_text);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(text.getText().toString()==null||text.getText().toString().trim().equals("")){
                    text.setHint("Type a message...");
                }
                else{
                    msg=text.getText().toString();
                    Intent intent=new Intent();
                    intent.setAction(Intent.ACTION_SEND);
                    intent.putExtra(Intent.EXTRA_TEXT,msg);
                    intent.setType("text/plain");
                    startActivity(Intent.createChooser(intent,"Send to"));
                }
            }
        });


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menuItem=(MenuItem)findViewById(R.id.my_menu_items);
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.my_menu,menu);   // ( ,Menu menu)
        //ShareActionProvider mShareActionProvider=(ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);
        return true;
    }
    protected void doShare(){
        Intent shareIntent=new Intent(Intent.ACTION_SEND);
        menuItem=(MenuItem)findViewById(R.id.my_menu_items);
        ShareActionProvider mShareActionProvider=(ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);
        mShareActionProvider.setShareIntent(shareIntent);

    }
    }
