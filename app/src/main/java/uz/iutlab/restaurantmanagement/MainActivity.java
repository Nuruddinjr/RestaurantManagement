package uz.iutlab.restaurantmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TableTypesFragment table_types_fragment;
    DetailsFragment details_fragment;
    Button newOrder_Btn;
    Button changeInfo_Btn;
    Button reset_Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        table_types_fragment = (TableTypesFragment) getSupportFragmentManager().findFragmentById(R.id.topFragment);
        details_fragment = (DetailsFragment)getSupportFragmentManager().findFragmentById(R.id.bottomFragment);
        newOrder_Btn = (Button)findViewById(R.id.mainActivity_newOrderBtn);
        changeInfo_Btn = (Button)findViewById(R.id.mainActivity_changeInfoBtn);
        reset_Btn = (Button)findViewById(R.id.mainActivity_resetBtn);


        newOrder_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str =  details_fragment.getTableName();
                Toast.makeText(getApplicationContext(),str, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, NewOrderActivity.class);
                startActivity(intent);

            }
        });


    }
}
