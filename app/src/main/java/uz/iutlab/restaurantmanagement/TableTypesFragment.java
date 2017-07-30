package uz.iutlab.restaurantmanagement;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class TableTypesFragment extends Fragment {
    Button appleTable;
    Button grapeTable;
    Button kiwiTable;
    Button grapeFruitTable;
    DetailsFragment bottomFragment;



    public TableTypesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_table_types, container, false);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        appleTable = (Button)getActivity().findViewById(R.id.tableTypes_appleTable);
        grapeTable = (Button)getActivity().findViewById(R.id.tableTypes_grapeTable);
        kiwiTable = (Button)getActivity().findViewById(R.id.tableTypes_kiwiTable);
        grapeFruitTable = (Button)getActivity().findViewById(R.id.tableTypes_grapeFruitTable);

        bottomFragment = (DetailsFragment) getFragmentManager().findFragmentById(R.id.bottomFragment);



        appleTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomFragment.setTableName("Apple Table");
            }
        });

        grapeTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomFragment.setTableName("Grape Table");
            }
        });

        kiwiTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomFragment.setTableName("Kiwi Table");
            }
        });

        grapeFruitTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomFragment.setTableName("Grapefruit Table");
            }
        });

    }


}
