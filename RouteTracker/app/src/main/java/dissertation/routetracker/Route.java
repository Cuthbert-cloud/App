package dissertation.routetracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class Route extends AppCompatActivity {

    Node a = new Node("1",70,45);     Node b = new Node("12",245,45);     Node c = new Node("18",520,45);    Node d = new Node("29",795,45);    Node e = new Node("35",1070,45);    Node f = new Node("46",1345,45);    Node g = new Node("52",1620,45);     Node h = new Node("63",1895,45);     Node i = new Node("69",2170,45);
    Node j = new Node("2",70,245);    Node o = new Node("13",245,445);    Node k = new Node("19",520,245);   Node q = new Node("30",795,445);   Node l = new Node("36",1070,245);   Node s = new Node("47",1345,445);   Node m = new Node("53",1620,245);    Node u = new Node("64",1895,445);    Node x2 = new Node("70",2170,245);
    Node n = new Node("3",70,445);    Node b1 = new Node("14",245,845);   Node p = new Node("20",520,445);   Node d1 = new Node("31",795,845);  Node r = new Node("37",1070,445);   Node f1 = new Node("48",1345,845);  Node t = new Node("54",1620,445);    Node h1 = new Node("65",1895,845);   Node vv = new Node("71",2170,445);
    Node w = new Node("4",70,645);    Node o1 = new Node("15",245,1245);  Node x = new Node("21",520,645);   Node q1 = new Node("32",795,1245); Node y = new Node("38",1070,645);   Node s1 = new Node("49",1345,1245); Node z = new Node("55",1620,645);    Node u1 = new Node("66",1895,1245);  Node y2 = new Node("72",2170,645);
    Node a1 = new Node("5",70,845);   Node b2 = new Node("16",245,1645);  Node c1 = new Node("22",520,845);  Node d2 = new Node("33",795,1645); Node e1 = new Node("39",1070,845);  Node f2 = new Node("50",1345,1645); Node g1 = new Node("56",1620,845);   Node h2 = new Node("67",1895,1645);  Node i1 = new Node("73",2170,845);
    Node j1 = new Node("6",70,1045);  Node o2 = new Node("17",245,2045);  Node k1 = new Node("23",520,1045); Node q2 = new Node("34",795,2045); Node l1 = new Node("40",1070,1045); Node s2 = new Node("51",1345,2045); Node m1 = new Node("57",1620,1045);  Node u2 = new Node("68",1895,2045);  Node z2 = new Node("74",2170,1045);
    Node n1 = new Node("7",70,1245);                                                Node p1 = new Node("24",520,1245);                                              Node r1 = new Node("41",1070,1245);                                               Node t1 = new Node("58",1620,1245);                                                 Node v1 = new Node("75",2170,1245);
    Node w1 = new Node("8",70,1445);                                                Node x1 = new Node("25",520,1445);                                              Node y1 = new Node("42",1070,1445);                                               Node z1 = new Node("59",1620,1445);                                                 Node A3 = new Node("76",2170,1445);
    Node a2 = new Node("9",70,1645);                                                Node c2 = new Node("26",520,1645);                                              Node e2 = new Node("43",1070,1645);                                               Node g2 = new Node("60",1620,1645);                                                 Node i2 = new Node("77",2170,1645);
    Node j2 = new Node("10",70,1845);                                               Node k2 = new Node("27",520,1845);                                              Node l2 = new Node("44",1070,1845);                                               Node m2 = new Node("61",1620,1845);                                                 Node B3 = new Node("78",2170,1845);
    Node n2 = new Node("11",70,2045);                                               Node p2 = new Node("28",520,2045);                                              Node r2 = new Node("45",1070,2045);                                               Node t2 = new Node("62",1620,2045);                                                 Node v2 = new Node("79",2170,2045);

    Node table_1 = new Node("A",250,265); Node table_2 = new Node("B",800,265); Node table_3 = new Node("C",1350,265); Node table_4 = new Node("D",1900,265);
    Node table_5 = new Node("E",250,665); Node table_6 = new Node("F",800,665); Node table_7 = new Node("G",1350,665); Node table_8 = new Node("H",1900,665);
    Node table_9 = new Node("I",250,1065); Node table_10 = new Node("J",800,665); Node table_11 = new Node("K",1350,1065); Node table_12 = new Node("L",1900,1065);
    Node table_13 = new Node("M",250,1465); Node table_14 = new Node("N",800,1465); Node table_15 = new Node("O",1350,1465); Node table_16 = new Node("P",1900,1465);
    Node table_17 = new Node("Q",250,1865); Node table_18 = new Node("R",800,1865); Node table_19 = new Node("S",1350,1865); Node table_20 = new Node("T",1900,1865);

    ArrayList<Node> nav_graph;
    ArrayList<String> list_of_nodes, draft;
    Button reset, done;
    ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);mImageView = (ImageView) findViewById(R.id.iv);
        setContentView(R.layout.map_route);
        Navigation_Graph();
        get_from_server();
        design_room();
        draft = new ArrayList<>();
        list_of_nodes = new ArrayList<>();
        reset = findViewById(R.id.back);
        reset.setOnClickListener(v -> reset());
    }
    private void Navigation_Graph() {
        nav_graph = new ArrayList<>();
        nav_graph.add(a); nav_graph.add(b); nav_graph.add(c); nav_graph.add(d); nav_graph.add(e); nav_graph.add(f); nav_graph.add(g); nav_graph.add(h);
        nav_graph.add(i); nav_graph.add(j); nav_graph.add(k); nav_graph.add(l); nav_graph.add(m); nav_graph.add(n); nav_graph.add(o); nav_graph.add(p); nav_graph.add(q); nav_graph.add(r);
        nav_graph.add(s); nav_graph.add(t); nav_graph.add(u); nav_graph.add(vv); nav_graph.add(w); nav_graph.add(x); nav_graph.add(y); nav_graph.add(z); nav_graph.add(a1); nav_graph.add(b1); nav_graph.add(c1); nav_graph.add(d1);
        nav_graph.add(e1); nav_graph.add(f1); nav_graph.add(g1); nav_graph.add(h1); nav_graph.add(i1); nav_graph.add(j1); nav_graph.add(k1); nav_graph.add(l1); nav_graph.add(m1);
        nav_graph.add(n1); nav_graph.add(o1); nav_graph.add(p1); nav_graph.add(q1); nav_graph.add(r1); nav_graph.add(s1); nav_graph.add(t1); nav_graph.add(u1); nav_graph.add(w1);
        nav_graph.add(x1); nav_graph.add(y1); nav_graph.add(z1); nav_graph.add(a2); nav_graph.add(b2); nav_graph.add(c2); nav_graph.add(d2); nav_graph.add(e2); nav_graph.add(f2);
        nav_graph.add(g2); nav_graph.add(h2); nav_graph.add(i2); nav_graph.add(j2); nav_graph.add(k2); nav_graph.add(l2); nav_graph.add(m2); nav_graph.add(n2); nav_graph.add(o2);
        nav_graph.add(p2); nav_graph.add(q2); nav_graph.add(r2); nav_graph.add(s2); nav_graph.add(t2); nav_graph.add(u2); nav_graph.add(v1); nav_graph.add(v2); nav_graph.add(x2); nav_graph.add(y2);nav_graph.add(z2);nav_graph.add(A3);nav_graph.add(B3);
        nav_graph.add(table_1); nav_graph.add(table_2); nav_graph.add(table_3); nav_graph.add(table_4); nav_graph.add(table_5); nav_graph.add(table_6); nav_graph.add(table_7);
        nav_graph.add(table_8); nav_graph.add(table_9); nav_graph.add(table_10); nav_graph.add(table_11); nav_graph.add(table_12); nav_graph.add(table_13); nav_graph.add(table_14);
        nav_graph.add(table_15); nav_graph.add(table_16); nav_graph.add(table_17); nav_graph.add(table_18); nav_graph.add(table_19); nav_graph.add(table_20);
    }

    private void design_room() {
        mImageView = (ImageView) findViewById(R.id.iv);
        Bitmap bitmap = Bitmap.createBitmap(2600,2270,Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(Color.RED);

        Paint yellow = new Paint();
        yellow.setColor(Color.YELLOW);
        yellow.setStyle(Paint.Style.FILL);
        yellow.setAntiAlias(true);

        Paint black = new Paint();
        black.setColor(Color.BLACK);
        black.setStyle(Paint.Style.FILL);
        black.setStrokeWidth(8);
        black.setAntiAlias(true);
        black.setTextSize(50);

        canvas.drawRect(150,200,400,300,yellow);
        canvas.drawText("1",250,265,black);
        canvas.drawRect(150,600,400,700,yellow);
        canvas.drawText("5",250,665,black);
        canvas.drawRect(150,1000,400,1100,yellow);
        canvas.drawText("9",250,1065,black);
        canvas.drawRect(150,1400,400,1500,yellow);
        canvas.drawText("13",250,1465,black);
        canvas.drawRect(150,1800,400,1900,yellow);
        canvas.drawText("17",250,1865,black);
        canvas.drawRect(700,200,950,300,yellow);

        canvas.drawText("2",800,265,black);
        canvas.drawRect(700,600,950,700,yellow);
        canvas.drawText("6",800,665,black);
        canvas.drawRect(700,1000,950,1100,yellow);
        canvas.drawText("10",800,1065,black);
        canvas.drawRect(700,1400,950,1500,yellow);
        canvas.drawText("14",800,1465,black);
        canvas.drawRect(700,1800,950,1900,yellow);
        canvas.drawText("18",800,1865,black);
        canvas.drawRect(1250,200,1500,300,yellow);

        canvas.drawText("3",1350,265,black);
        canvas.drawRect(1250,600,1500,700,yellow);
        canvas.drawText("7",1350,665,black);
        canvas.drawRect(1250,1000,1500,1100,yellow);
        canvas.drawText("11",1350,1065,black);
        canvas.drawRect(1250,1400,1500,1500,yellow);
        canvas.drawText("15",1350,1465,black);
        canvas.drawRect(1250,1800,1500,1900,yellow);
        canvas.drawText("19",1350,1865,black);
        canvas.drawRect(1800,200,2050,300,yellow);

        canvas.drawText("4",1900,265,black);
        canvas.drawRect(1800,600,2050,700,yellow);
        canvas.drawText("8",1900,665,black);
        canvas.drawRect(1800,1000,2050,1100,yellow);
        canvas.drawText("12",1900,1065,black);
        canvas.drawRect(1800,1400,2050,1500,yellow);
        canvas.drawText("16",1900,1465,black);
        canvas.drawRect(1800,1800,2050,1900,yellow);
        canvas.drawText("20",1900,1865,black);

        canvas.drawLine(2300,100,2300,250,black);
        canvas.drawRect(2300,5,2600,400,yellow);
        canvas.drawLine(2300,450,2300,550,black);
        canvas.drawRect(2300,401,2600,599,yellow);
        canvas.drawLine(2300,650,2300,750,black);
        canvas.drawRect(2300,600,2600,799,yellow);
        canvas.drawRect(2500,800,2600,999,yellow);
        canvas.drawLine(2500,850,2500,950,black);
        canvas.drawRect(2500,1000,2600, 1199,yellow);
        canvas.drawLine(2500,1050,2500,1150,black);
        canvas.drawRect(2500,1200,2600,1399,yellow);
        canvas.drawLine(2500,1250,2500,1350,black);
        canvas.drawRect(2300,1600,2600,2200,yellow);
        canvas.drawLine(2400,1600,2500,1600,black);
        canvas.drawRect(1800,2100,2600,2200,yellow);

        //column 1
        canvas.drawRect(20,20,70,70,yellow);                                 // A - 1
        canvas.drawRect(20,225,70,275,yellow);                               // J - 2
        canvas.drawRect(20,420,70,470,yellow);                               // O - 3
        canvas.drawRect(20,625,70,675,yellow);                               // X - 4
        canvas.drawRect(20,820,70,870,yellow);                               // C1 - 5
        canvas.drawRect(20,1025,70,1075,yellow);                             // L1 - 6
        canvas.drawRect(20,1220,70,1270,yellow);                             // Q1 - 7
        canvas.drawRect(20,1425,70,1475,yellow);                             // Z1 -8
        canvas.drawRect(20,1620,70,1670,yellow);                             // E2 -9
        canvas.drawRect(20,1825,70,1875,yellow);                             // N2-10
        canvas.drawRect(20,2020,70,2070,yellow);                             // S2-11

        //column 2
        canvas.drawRect(245,20,295,70,yellow);                               // B - 12
        canvas.drawRect(245,420,295,470,yellow);                             // P - 13
        canvas.drawRect(245,820,295,870,yellow);                             // D1 - 14
        canvas.drawRect(245,1220,295,1270,yellow);                           // R1 - 15
        canvas.drawRect(245,1620,295,1670,yellow);                           // F2 -16
        canvas.drawRect(245,2020,295,2070,yellow);                           // T2- 17

        //column 3
        canvas.drawRect(520,20,570,70,yellow);                               // C - 18
        canvas.drawRect(520,225,570,275,yellow);                             // K - 19
        canvas.drawRect(520,420,570,470,yellow);                             // Q - 20
        canvas.drawRect(520,625,570,675,yellow);                             // Y-21
        canvas.drawRect(520,820,570,870,yellow);                             // E1-22
        canvas.drawRect(520,1025,570,1075,yellow);                           // M1-23
        canvas.drawRect(520,1220,570,1270,yellow);                           // S1-24
        canvas.drawRect(520,1425,570,1475,yellow);                           // A2-25
        canvas.drawRect(520,1620,570,1670,yellow);                           // G2-26
        canvas.drawRect(520,1825,570,1875,yellow);                           // O2-27
        canvas.drawRect(520,2020,570,2070,yellow);                           // U2-28

        // column 4
        canvas.drawRect(795,20,845,70,yellow);                               // D-29
        canvas.drawRect(795,420,845,470,yellow);                             // R-30
        canvas.drawRect(795,820,845,870,yellow);                             // F1-31
        canvas.drawRect(795,1220,845,1270,yellow);                           // T1-32
        canvas.drawRect(795,1620,845,1670,yellow);                           // H2-33
        canvas.drawRect(795,2020,845,2070,yellow);                           // V2-34

        // column 5
        canvas.drawRect(1070,20,1120,70,yellow);                             // E-35
        canvas.drawRect(1070,225,1120,275,yellow);                           // L-36
        canvas.drawRect(1070,420,1120,470,yellow);                           // S-37
        canvas.drawRect(1070,625,1120,675,yellow);                           // Z-38
        canvas.drawRect(1070,820,1120,870,yellow);                           // G1-39
        canvas.drawRect(1070,1025,1120,1075,yellow);                         //40
        canvas.drawRect(1070,1220,1120,1270,yellow);                         // 41
        canvas.drawRect(1070,1425,1120,1475,yellow);                         // 42
        canvas.drawRect(1070,1620,1120,1670,yellow);                         //43
        canvas.drawRect(1070,1825,1120,1875,yellow);                         //44
        canvas.drawRect(1070,2020,1120,2070,yellow);                         //45

        //column 6
        canvas.drawRect(1345,20,1395,70,yellow);                             // F-46
        canvas.drawRect(1345,420,1395,470,yellow);                           // 47
        canvas.drawRect(1345,820,1395,870,yellow);                           // 48
        canvas.drawRect(1345,1220,1395,1270,yellow);                         // 49
        canvas.drawRect(1345,1620,1395,1670,yellow);                         //50
        canvas.drawRect(1345,2020,1395,2070,yellow);                         //51

        //column 7
        canvas.drawRect(1620,20,1670,70,yellow);                             // G-52
        canvas.drawRect(1620,225,1670,275,yellow);                           //53
        canvas.drawRect(1620,420,1670,470,yellow);                           //54
        canvas.drawRect(1620,625,1670,675,yellow);                           //55
        canvas.drawRect(1620,820,1670,870,yellow);                           //56
        canvas.drawRect(1620,1025,1670,1075,yellow);                         //57
        canvas.drawRect(1620,1220,1670,1270,yellow);                         //58
        canvas.drawRect(1620,1425,1670,1475,yellow);                         //59
        canvas.drawRect(1620,1620,1670,1670,yellow);                         //60
        canvas.drawRect(1620,1825,1670,1875,yellow);                         //61
        canvas.drawRect(1620,2020,1670,2070,yellow);                          //62

        //column 8
        canvas.drawRect(1895,20,1945,70,yellow);                             // H-63
        canvas.drawRect(1895,420,1945,470,yellow);                           //64
        canvas.drawRect(1895,820,1945,870,yellow);                           //65
        canvas.drawRect(1895,1220,1945,1270,yellow);                         //66
        canvas.drawRect(1895,1620,1945,1670,yellow);                         //67
        canvas.drawRect(1895,2020,1945,2070,yellow);                          //68

        //column 9
        canvas.drawRect(2170,20,2220,70,yellow);                             // I-69
        canvas.drawRect(2170,225,2220,275,yellow);                           //70   Node n = ("N",2170,225)
        canvas.drawRect(2170,420,2220,470,yellow);                           //71
        canvas.drawRect(2170,625,2220,675,yellow);                           //72
        canvas.drawRect(2170,820,2220,870,yellow);                           //73
        canvas.drawRect(2170,1025,2220,1075,yellow);                         //74
        canvas.drawRect(2170,1220,2220,1270,yellow);                         //75
        canvas.drawRect(2170,1425,2220,1475,yellow);                         //76
        canvas.drawRect(2170,1620,2220,1670,yellow);                         //77
        canvas.drawRect(2170,1825,2220,1875,yellow);                         //78
        canvas.drawRect(2170,2020,2220,2070,yellow);                         //79
        mImageView.setImageBitmap(bitmap);
    }

    private void get_from_server() {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://10.0.2.2:5000/route";
        JsonObjectRequest post_request = new JsonObjectRequest(Request.Method.GET, url, null, response -> {
            try {
                JSONArray route = response.getJSONArray("path");
                for (int i=0;i<route.length();i++) {
                    String index = (String) route.get(i);
                    draft.add(index);
                }
                list_of_nodes = removeDuplicates(draft);
                /*System.out.println(list_of_nodes);
                Bitmap bitmap = Bitmap.createBitmap(2600,1500,Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap);
                canvas.drawColor(Color.BLACK);
                Paint paint = new Paint();
                paint.setColor(Color.YELLOW);
                paint.setStyle(Paint.Style.FILL);
                paint.setAntiAlias(true);
                for (int i = 0; i < list_of_nodes.size()-1; i++) {
                    String co = list_of_nodes.get(i);
                    System.out.println(co);
                    for (int j = 0; j < navgraph.size()-1; j++) {
                        if (co.equals(navgraph.get(j).getID())) {
                            float startX = navgraph.get(j).getX();
                            float startY = navgraph.get(j).getY();
                            float stopX = navgraph.get(j+1).getX();
                            float stopY = navgraph.get(j+1).getY();
                            System.out.println("Coordinate: "+co +" at "+ j + " X = " + startX+startY);
                            System.out.println("Coordinate: "+co +" at "+ j+1 + " Y = " + stopX+stopY);
                            canvas.drawLine(startX,startY,stopX,stopY,paint);
                        }
                    }
                }*/

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }, error -> {
        });
        queue.add(post_request);
    }
    private static <T> ArrayList<T> removeDuplicates(ArrayList<T> list) {
        ArrayList<T> newList = new ArrayList<T>();
        for (T em : list) {
            if (!newList.contains(em)) {
                newList.add(em);
            }
        }
        return newList;
    }
    private void reset() {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://10.0.2.2:5000/reset";
        StringRequest update_request = new StringRequest(Request.Method.POST, url, response -> {
            Toast.makeText(this, "reset", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, Room_Map.class));
        }, error ->  {
            Toast.makeText(this, "path not resetted", Toast.LENGTH_SHORT).show();
        });
        queue.add(update_request);
    }
}