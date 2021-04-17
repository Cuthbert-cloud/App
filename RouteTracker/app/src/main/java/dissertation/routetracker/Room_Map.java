package dissertation.routetracker;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class Room_Map extends AppCompatActivity {

    Node test = new Node("1",70,45); // test location

    Node office = new Node("9",2170,45); Node staff = new Node("23",2170,445); Node break_room = new Node("28",1620,650);
    Node female_toilet  = new Node("37",2170,845); Node disability_toilet = new Node("42",1620,1045); Node male_toilet = new Node("51",2170,1245);
    Node bar_section_1 = new Node("70",1620,1845); Node bar_section_2 = new Node("78",1895,2045);

    Node table_1 = new Node("16",245,445); Node table_2 = new Node("18",795,445); Node table_3 = new Node("20",1345,445); Node table_4 = new Node("22",1895,445);
    Node table_5 = new Node("30",245,845); Node table_6 = new Node("32",795,845); Node table_7 = new Node("34",1345,845); Node table_8 = new Node("36",195,845);
    Node table_9 = new Node("44",245,1245); Node table_10 = new Node("46",795,1245); Node table_11 = new Node("48",1345,1245); Node table_12 = new Node("50",1895,1245);
    Node table_13 = new Node("58",250,1645); Node table_14 = new Node("60",795,1645); Node table_15 = new Node("62",1345,1645); Node table_16 = new Node("64",1895,1645);
    Node table_17 = new Node("72",250,2045); Node table_18 = new Node("74",795,2045); Node table_19 = new Node("76",1345,2045); Node table_20 = new Node("78",1895,2045);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map);
        Actions();
    }
    private void Actions() {
        Button table1 = findViewById(R.id.table1);
        table1.setOnClickListener(v -> {
            send_to_server(test,table_1);
            startActivity(new Intent(this, Route.class));
        });
        Button table2 = findViewById(R.id.table2);
        table2.setOnClickListener(v -> {
            send_to_server(test,table_2);
            startActivity(new Intent(this, Route.class));
        });
        Button table3 = findViewById(R.id.table3);
        table3.setOnClickListener(v -> {
            send_to_server(test,table_3);
            startActivity(new Intent(this, Route.class));
        });
        Button table4 = findViewById(R.id.table4);
        table4.setOnClickListener(v -> {
            send_to_server(test,table_4);
            startActivity(new Intent(this, Route.class));
        });
        Button table5 = findViewById(R.id.table5);
        table5.setOnClickListener(v -> {
            send_to_server(test,table_5);
            startActivity(new Intent(this, Route.class));
        });
        Button table6 = findViewById(R.id.table6);
        table6.setOnClickListener(v -> {
            send_to_server(test,table_6);
            startActivity(new Intent(this, Route.class));
        });
        Button table7 = findViewById(R.id.table7);
        table7.setOnClickListener(v -> {
            send_to_server(test,table_7);
            startActivity(new Intent(this, Route.class));
        });
        Button table8 = findViewById(R.id.table8);
        table8.setOnClickListener(v -> {
            send_to_server(test,table_8);
            startActivity(new Intent(this, Route.class));
        });
        Button table9 = findViewById(R.id.table9);
        table9.setOnClickListener(v -> {
            send_to_server(test,table_9);
            startActivity(new Intent(this, Route.class));
        });
        Button table10 = findViewById(R.id.table10);
        table10.setOnClickListener(v -> {
            send_to_server(test,table_10);
            startActivity(new Intent(this, Route.class));
        });
        Button table11 = findViewById(R.id.table11);
        table11.setOnClickListener(v -> {
            send_to_server(test,table_11);
            startActivity(new Intent(this, Route.class));
        });
        Button table12 = findViewById(R.id.table12);
        table12.setOnClickListener(v -> {
            send_to_server(test,table_12);
            startActivity(new Intent(this, Route.class));
        });
        Button table13 = findViewById(R.id.table13);
        table13.setOnClickListener(v -> {
            send_to_server(test,table_13);
            startActivity(new Intent(this, Route.class));
        });
        Button table14 = findViewById(R.id.table14);
        table14.setOnClickListener(v -> {
            send_to_server(test,table_14);
            startActivity(new Intent(this, Route.class));
        });
        Button table15 = findViewById(R.id.table15);
        table15.setOnClickListener(v -> {
            send_to_server(test,table_15);
            startActivity(new Intent(this, Route.class));
        });
        Button table16 = findViewById(R.id.table16);
        table16.setOnClickListener(v -> {
            send_to_server(test,table_16);
            startActivity(new Intent(this, Route.class));
        });
        Button table17 = findViewById(R.id.table17);
        table17.setOnClickListener(v -> {
            send_to_server(test,table_17);
            startActivity(new Intent(this, Route.class));
        });
        Button table18 = findViewById(R.id.table18);
        table18.setOnClickListener(v -> {
            send_to_server(test,table_18);
            startActivity(new Intent(this, Route.class));
        });
        Button table19 = findViewById(R.id.table19);
        table19.setOnClickListener(v -> {
            send_to_server(test,table_19);
            startActivity(new Intent(this, Route.class));
        });
        Button table20 = findViewById(R.id.table20);
        table20.setOnClickListener(v -> {
            send_to_server(test,table_20);
            startActivity(new Intent(this, Route.class));
        });
        Button bar = findViewById(R.id.bar);
        bar.setOnClickListener(v -> {
            send_to_server(test, bar_section_1);
            startActivity(new Intent(this, Route.class));
        });
        Button bar2 = findViewById(R.id.bar2);
        bar2.setOnClickListener(v -> {
            send_to_server(test, bar_section_2);
            startActivity(new Intent(this, Route.class));
        });
        Button office = findViewById(R.id.office);
        office.setOnClickListener(v -> {
            send_to_server(test, this.office);
            startActivity(new Intent(this, Route.class));
        });
        Button staff_room = findViewById(R.id.staffroom);
        staff_room.setOnClickListener(v -> {
            send_to_server(test, staff);
            startActivity(new Intent(this, Route.class));
        });
        Button break_room = findViewById(R.id.breakroom);
        break_room.setOnClickListener(v -> {
            send_to_server(test, this.break_room);
            startActivity(new Intent(this, Route.class));
        });
        Button f_toilet = findViewById(R.id.female_toilet);
        f_toilet.setOnClickListener(v -> {
            send_to_server(test, disability_toilet);
            startActivity(new Intent(this, Route.class));
        });
        Button d_toilet = findViewById(R.id.disability_toilet);
        d_toilet.setOnClickListener(v -> {
            send_to_server(test, female_toilet);
            startActivity(new Intent(this, Route.class));
        });
        Button m_toilet = findViewById(R.id.male_toilet);
        m_toilet.setOnClickListener(v -> {
            send_to_server(test, male_toilet);
            startActivity(new Intent(this, Route.class));
        });
    }
    private void send_to_server(Node a, Node b) {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://10.0.2.2:5000/route/" + a.getID() + "/" + b.getID() ;
        StringRequest post_request = new StringRequest(Request.Method.POST, url, response -> {
            Toast.makeText(this,"response sent",Toast.LENGTH_LONG).show();
            System.out.println("Start Node: " + a.getID() + " | End Node: " + b.getID());
        }, error -> {
            Toast.makeText(this,"response not sent",Toast.LENGTH_LONG).show();
        });
        queue.add(post_request);
    }
}