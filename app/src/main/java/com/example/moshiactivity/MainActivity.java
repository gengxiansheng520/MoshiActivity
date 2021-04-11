package com.example.moshiactivity;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

//    ActivityResultLauncher<Intent> mStartForResult = registerForActivityResult(new StartActivityForResult(),
//            new ActivityResultCallback<ActivityResult>() {
//                @Override
//                public void onActivityResult(ActivityResult result) {
//                    if (result.getResultCode() == Activity.RESULT_OK) {
//                        Intent intent = result.getData();
//                    }
//                }
//            });

    ActivityResultLauncher<String> mGetContent = registerForActivityResult(new ActivityResultContracts.GetContent(),
            new ActivityResultCallback<Uri>() {
                @Override
                public void onActivityResult(Uri uri) {
                    // Handle the returned Uri
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //mStartForResult.launch(new Intent(this, ResultProducingActivity.class));
        Button button = findViewById(R.id.button);
        button.setOnClickListener(view -> {
            mGetContent.launch("image/*");
        });
    }
}





//    @Override
//    public void onCreate(@Nullable savedInstanceState: Bundle) {
//        // ...
//
//        Button startButton = findViewById(R.id.start_button);
//
//        startButton.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // The launcher with the Intent you want to start
//                mStartForResult.launch(new Intent(this, ResultProducingActivity.class));
//            }
//        });
//    }