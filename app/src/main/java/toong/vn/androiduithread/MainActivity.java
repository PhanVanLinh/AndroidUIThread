package toong.vn.androiduithread;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        runOnUiThread(new Runnable() {
            @Override
            public void run() {

            }
        });

        View view = null;
        view.post(new Runnable() {
            @Override
            public void run() {

            }
        });
    }
}
