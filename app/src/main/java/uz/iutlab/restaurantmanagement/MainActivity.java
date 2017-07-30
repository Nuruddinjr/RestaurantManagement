package uz.iutlab.restaurantmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

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
                startActivityForResult(intent,7777);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 7777){
            if(resultCode == this.RESULT_OK){
                details_fragment.setEnterTime(data.getStringExtra("time"));
                details_fragment.setSpaghetti(data.getStringExtra("sp_count"));
                details_fragment.setPizza(data.getStringExtra("pz_count"));
                details_fragment.setMembership(data.getStringExtra("m_type"));
            Random rand = new Random(1000);
            int random_integer = rand.nextInt(1000-100) + 100;
            details_fragment.setPrice(String.valueOf(random_integer)+" $");
            }
        }
    }
}
