package com.example.handwritten2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.ml.vision.FirebaseVision;
import com.google.firebase.ml.vision.common.FirebaseVisionImage;
import com.google.firebase.ml.vision.text.FirebaseVisionText;
import com.google.firebase.ml.vision.text.FirebaseVisionTextRecognizer;

import java.io.IOException;

@SuppressWarnings("ALL")
public class MainActivity extends AppCompatActivity {

    ImageView headimage;
    TextView headtext,headtext2;

    CountDownTimer countDownTimer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        headtext = findViewById(R.id.headtext);
        headtext2 = findViewById(R.id.headtext2);
        headimage = findViewById(R.id.headimage);

        headimage.animate().translationY(0f).setDuration(2000);
        new Handler().postDelayed((Runnable) () -> {
            countDownTimer = new CountDownTimer(2000,2000) {
                @Override
                public void onTick(long l) {
                    headimage.animate().translationY(0f).setDuration(2000);
                }

                @Override
                public void onFinish() {
                    headtext.animate().alpha(1f).setDuration(1500);
                    headtext2.animate().alpha(1f).setDuration(1500);
                    new Handler().postDelayed((Runnable) () -> {
                        startActivity(new Intent(MainActivity.this, MainActivity2.class));
                        finish();
                    },3000);
                }
            }.start();
        },2000);

//        imageView =findViewById(R.id.imageView);
//        resultTv = findViewById(R.id.detectedText);
//
//        choose = findViewById(R.id.snapBtn);
//
//        choose.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent();
//                intent.setType("image/*");
//                intent.setAction(Intent.ACTION_GET_CONTENT);
//                startActivityForResult(Intent.createChooser(intent,"select image"),121);
//
//            }
//        });
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if(requestCode == 121){
//            imageView.setImageURI(data.getData());
//            FirebaseVisionImage image;
//            try {
//                image = FirebaseVisionImage.fromFilePath(getApplicationContext(), data.getData());
//                FirebaseVisionTextRecognizer textRecognizer = FirebaseVision.getInstance()
//                        .getOnDeviceTextRecognizer();
//
//
//                textRecognizer.processImage(image)
//                        .addOnSuccessListener(new OnSuccessListener<FirebaseVisionText>() {
//                            @Override
//                            public void onSuccess(FirebaseVisionText result) {
//                                // Task completed successfully
//                                // ...
//                                Toast.makeText(MainActivity.this, "detected text from image", Toast.LENGTH_SHORT).show();
//                                resultTv.setText(result.getText());
//                            }
//                        })
//                        .addOnFailureListener(
//                                new OnFailureListener() {
//                                    @Override
//                                    public void onFailure(@NonNull Exception e) {
//                                        // Task failed with an exception
//                                        // ...
//                                        Toast.makeText(MainActivity.this, "Failed to detect text from image"+e.getMessage(), Toast.LENGTH_SHORT).show();
//                                    }
//                                });
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
}