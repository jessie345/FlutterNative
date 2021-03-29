package com.luojilab.dedao.flutternative;

import androidx.appcompat.app.AppCompatActivity;
import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterEngineCache;
import io.flutter.embedding.engine.dart.DartExecutor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FlutterEngine flutterEngine = new FlutterEngine(this);
        flutterEngine.getDartExecutor().executeDartEntrypoint(DartExecutor.DartEntrypoint.createDefault());

        FlutterEngineCache.getInstance().put("test_id", flutterEngine);

        findViewById(R.id.btnStart).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = FlutterActivity.withCachedEngine("test_id")
                        .build(MainActivity.this);

                startActivity(intent);
            }
        });
    }
}