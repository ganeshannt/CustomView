package ganeshannt.customview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Dataitem> lstData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lstData = new ArrayList<>();

        lstData.add(new Dataitem(R.drawable.tamil, "Tamil Nadu"));
        lstData.add(new Dataitem(R.drawable.tamil, "India "));

        ListView listView= (ListView)findViewById(R.id.ListView);

        CustomAdapter adapter = new CustomAdapter(this,R.layout.itemrow,lstData);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                intent.putExtra("state",lstData.get(position).statename);
                intent.putExtra("Flag",lstData.get(position).residthum);

                intent.setClass(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });

    }

}
