package com.example.kaylee.luc;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;
    ImageView draftImageView;
    Button addFilterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addFilterButton.setVisibility(View.GONE);

        Button takePicButton = (Button) findViewById(R.id.takePicButton);
        draftImageView = (ImageView) findViewById(R.id.draftImageView);

        // disable taking pic button if no camera on this device
        if ( !hasCamera() ) takePicButton.setEnabled(false);

    }

    // to check if a camera is on this device
    private boolean hasCamera() {
        return getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY);
    }

    // to launch the camera
    public void lauchCam(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        // to take a pic and pass the result to onActivityResult
        startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
    }

    // to return the taken pic
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK ) {
//            // to get the pic
//            Bundle extras = data.getExtras();
//            Bitmap pic = (Bitmap) extras.get("data");
//            draftImageView.setImageBitmap(pic);
//        }

        super.onActivityResult(requestCode, resultCode, data);
        Bitmap pic = (Bitmap) data.getExtras().get("data");
        draftImageView.setImageBitmap(pic);

        addFilterButton.setVisibility(View.VISIBLE);
    }

    // to add different filters
    public void addFilter(View view) {
        
    }





}
