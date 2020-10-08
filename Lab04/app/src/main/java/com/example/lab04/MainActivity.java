package com.example.lab04;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.content.Intent;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OnOpenInGoogleMaps(View view) {
        EditText teamAddress = (EditText) findViewById(R.id.teamAddressField);

        Uri gmmIntentUri = Uri.parse("http://maps.google.co.in/maps?q=" + teamAddress.getText());

        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);

        mapIntent.setPackage("com.google.android.apps.maps");

        startActivity(mapIntent);
    }

    public void OnSetAvatarButton(View view) {
        //Application Context and Activity
        Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
        startActivityForResult(intent, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_CANCELED) return;
        //Getting the Avatar Image we show to our users
        ImageView avatarImage = (ImageView) findViewById(R.id.logoImage);
        //Figuring out the correct image
        String drawableName;
        switch (data.getIntExtra("imageID", R.id.logoImage)) {
            case R.id.logoImage01:
                drawableName = "ic_logo_01";
                break;
            case R.id.logoImage02:
                drawableName = "ic_logo_02";
                break;
            case R.id.logoImage03:
                drawableName = "ic_logo_03";
                break;
            case R.id.logoImage04:
                drawableName = "ic_logo_04";
                break;
            case R.id.logoImage05:
                drawableName = "ic_logo_05";
                break;
            default:
                drawableName = "ic_logo_00";
                break;
        }
        int resID = getResources().getIdentifier(drawableName, "drawable",
                getPackageName());
        avatarImage.setImageResource(resID);

    }
}