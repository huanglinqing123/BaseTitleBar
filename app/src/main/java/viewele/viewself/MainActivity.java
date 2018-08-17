package viewele.viewself;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import hlq.titlebarview.BaseTitleBar;

public class MainActivity extends AppCompatActivity {

    private BaseTitleBar baseTitleBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        baseTitleBar = findViewById(R.id.tilte);
        baseTitleBar.setOnLeftOnclickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"left Onclick",Toast.LENGTH_SHORT).show();
            }
        });
        baseTitleBar.setOnRightOnclickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"right Onclick",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
