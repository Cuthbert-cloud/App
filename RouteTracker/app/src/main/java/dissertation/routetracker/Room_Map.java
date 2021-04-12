package dissertation.routetracker;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class Room_Map extends AppCompatActivity {

    Node test = new Node("A",70,45); // test location
    Node a = new Node("A",70,45); Node b = new Node("B",245,45); Node c = new Node("C",520,45); Node d = new Node("D",795,45); Node e = new Node("E",1070,45); Node f = new Node("F",1345,45); Node g = new Node("G",1620,45); Node h = new Node("H",1895,45); Node i = new Node("I",2170,45);
    Node j = new Node("J",70,245); Node k = new Node("K",520,245); Node l = new Node("L",1070,245); Node m = new Node("M",1620,245);
    Node n = new Node("N",70,445); Node o = new Node("O",245,445); Node p = new Node("P",520,445); Node q = new Node("Q",795,445); Node r = new Node("R",1070,445); Node s = new Node("S",1345,445); Node t = new Node("T",1620,445); Node u = new Node("U",1895,445); Node vv = new Node("V",2170,445);
    Node w = new Node("W",70,645); Node x = new Node("X",520,645); Node y = new Node("Y",1070,645); Node z = new Node("Z",1620,645);
    Node a1 = new Node("A1",70,845); Node b1 = new Node("B1",245,845); Node c1 = new Node("C1",520,845); Node d1 = new Node("D1",795,845); Node e1 = new Node("E1",1070,845); Node f1 = new Node("F1",1345,845); Node g1 = new Node("G1",1620,845); Node h1 = new Node("H1",1895,845); Node i1 = new Node("I1",2170,845);
    Node j1 = new Node("J1",70,1045); Node k1 = new Node("K1",520,1045); Node l1 = new Node("L1",1070,1045); Node m1 = new Node("M1",1620,1045);
    Node n1 = new Node("N1",70,1245); Node o1 = new Node("O1",245,1245); Node p1 = new Node("P1",520,1245); Node q1 = new Node("Q1",795,1245); Node r1 = new Node("R1",1070,1245); Node s1 = new Node("S1",1345,1245); Node t1 = new Node("T1",1620,1245); Node u1 = new Node("U1",1895,1245); Node v1 = new Node("V1",2170,1245);
    Node w1 = new Node("W1",70,1445); Node x1 = new Node("X1",520,1445); Node y1 = new Node("Y1",1070,1445); Node z1 = new Node("Z1",1620,1445);
    Node a2 = new Node("A2",70,1645); Node b2 = new Node("B2",245,1645); Node c2 = new Node("C2",520,1645); Node d2 = new Node("D2",795,1645); Node e2 = new Node("E2",1070,1645); Node f2 = new Node("F2",1345,1645); Node g2 = new Node("G2",1620,1645); Node h2 = new Node("H2",1895,1645); Node i2 = new Node("I2",2170,1645);
    Node j2 = new Node("J2",70,1845); Node k2 = new Node("K2",520,1845); Node l2 = new Node("L2",1070,1845); Node m2 = new Node("M2",1620,1845);
    Node n2 = new Node("N2",70,2045); Node o2 = new Node("O2",245,2045); Node p2 = new Node("P2",520,2045); Node q2 = new Node("Q2",795,2045); Node r2 = new Node("R2",1070,2045); Node s2 = new Node("S2",1345,2045); Node t2 = new Node("T2",1620,2045); Node u2 = new Node("U2",1895,2045); Node v2 = new Node("V2",2170,2045);

    Node office = new Node("I",2170,45); Node staff = new Node("V",2170,445); Node break_room = new Node("Z",1620,650);
    Node female_toilet  = new Node("I1",2170,845); Node disability_toilet = new Node("M1",1620,1045); Node male_toilet = new Node("V1",2170,1245);
    Node bar_section_1 = new Node("M2",1620,1845); Node bar_section_2 = new Node("U2",1895,2045);

    Node table_1 = new Node("1",250,265); Node table_2 = new Node("2",800,265); Node table_3 = new Node("3",1350,265); Node table_4 = new Node("4",1900,265);
    Node table_5 = new Node("5",250,665); Node table_6 = new Node("6",800,665); Node table_7 = new Node("7",1350,665); Node table_8 = new Node("8",1900,665);
    Node table_9 = new Node("9",250,1065); Node table_10 = new Node("10",800,665); Node table_11 = new Node("11",1350,1065); Node table_12 = new Node("12",1900,1065);
    Node table_13 = new Node("13",250,1465); Node table_14 = new Node("14",800,1465); Node table_15 = new Node("15",1350,1465); Node table_16 = new Node("16",1900,1465);
    Node table_17 = new Node("17",250,1865); Node table_18 = new Node("18",800,1865); Node table_19 = new Node("19",1350,1865); Node table_20 = new Node("20",1900,1865);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map);
        Actions();
    }
    private void Actions() {
        Button table1 = findViewById(R.id.table1);
        table1.setOnClickListener(v -> {
            send_to_server(test,a);
            startActivity(new Intent(this, Route.class));
        });
        Button table2 = findViewById(R.id.table2);
        table2.setOnClickListener(v -> {
            send_to_server(test,b);
            startActivity(new Intent(this, Route.class));
        });
        Button table3 = findViewById(R.id.table3);
        table3.setOnClickListener(v -> {
            send_to_server(test,c);
            startActivity(new Intent(this, Route.class));
        });
        Button table4 = findViewById(R.id.table4);
        table4.setOnClickListener(v -> {
            send_to_server(test,d);
            startActivity(new Intent(this, Route.class));
        });
        Button table5 = findViewById(R.id.table5);
        table5.setOnClickListener(v -> {
            send_to_server(test,e);
            startActivity(new Intent(this, Route.class));
        });
        Button table6 = findViewById(R.id.table6);
        table6.setOnClickListener(v -> {
            send_to_server(test,f);
            startActivity(new Intent(this, Route.class));
        });
        Button table7 = findViewById(R.id.table7);
        table7.setOnClickListener(v -> {
            send_to_server(test,g);
            startActivity(new Intent(this, Route.class));
        });
        Button table8 = findViewById(R.id.table8);
        table8.setOnClickListener(v -> {
            send_to_server(test,h);
            startActivity(new Intent(this, Route.class));
        });
        Button table9 = findViewById(R.id.table9);
        table9.setOnClickListener(v -> {
            send_to_server(test,i);
            startActivity(new Intent(this, Route.class));
        });
        Button table10 = findViewById(R.id.table10);
        table10.setOnClickListener(v -> {
            send_to_server(test,j);
            startActivity(new Intent(this, Route.class));
        });
        Button table11 = findViewById(R.id.table11);
        table11.setOnClickListener(v -> {
            send_to_server(test,k);
            startActivity(new Intent(this, Route.class));
        });
        Button table12 = findViewById(R.id.table12);
        table12.setOnClickListener(v -> {
            send_to_server(test,l);
            startActivity(new Intent(this, Route.class));
        });
        Button table13 = findViewById(R.id.table13);
        table13.setOnClickListener(v -> {
            send_to_server(test,m);
            startActivity(new Intent(this, Route.class));
        });
        Button table14 = findViewById(R.id.table14);
        table14.setOnClickListener(v -> {
            send_to_server(test,n);
            startActivity(new Intent(this, Route.class));
        });
        Button table15 = findViewById(R.id.table15);
        table15.setOnClickListener(v -> {
            send_to_server(test,o);
            startActivity(new Intent(this, Route.class));
        });
        Button table16 = findViewById(R.id.table16);
        table16.setOnClickListener(v -> {
            send_to_server(test,p);
            startActivity(new Intent(this, Route.class));
        });
        Button table17 = findViewById(R.id.table17);
        table17.setOnClickListener(v -> {
            send_to_server(test,q);
            startActivity(new Intent(this, Route.class));
        });
        Button table18 = findViewById(R.id.table18);
        table18.setOnClickListener(v -> {
            send_to_server(test,r);
            startActivity(new Intent(this, Route.class));
        });
        Button table19 = findViewById(R.id.table19);
        table19.setOnClickListener(v -> {
            send_to_server(test,s);
            startActivity(new Intent(this, Route.class));
        });
        Button table20 = findViewById(R.id.table20);
        table20.setOnClickListener(v -> {
            send_to_server(test,t);
            startActivity(new Intent(this, Route.class));
        });
        Button bar = findViewById(R.id.bar);
        bar.setOnClickListener(v -> {
            send_to_server(test, vv);
            startActivity(new Intent(this, Route.class));
        });
        Button bar2 = findViewById(R.id.bar2);
        bar2.setOnClickListener(v -> {
            send_to_server(test, y);
            startActivity(new Intent(this, Route.class));
        });
        Button office = findViewById(R.id.office);
        office.setOnClickListener(v -> {
            send_to_server(test, this.office);
            startActivity(new Intent(this, Route.class));
        });
        Button staff_room = findViewById(R.id.staffroom);
        staff_room.setOnClickListener(v -> {
            send_to_server(test, this.staff);
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

        }, error -> {
        });
        queue.add(post_request);
    }
}