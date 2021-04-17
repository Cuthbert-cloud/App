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

    Node a = new Node("1",70,45); Node b = new Node("2",245,45); Node c = new Node("3",520,45); Node d = new Node("4",795,45); Node e = new Node("5",1070,45); Node f = new Node("6",1345,45); Node g = new Node("7",1620,45); Node h = new Node("8",1895,45); Node i = new Node("9",2170,45);
    Node j = new Node("10",70,245); Node k = new Node("11",520,245); Node l = new Node("12",1070,245); Node m = new Node("13",1620,245); Node n = new Node("14",2170,245);
    Node o = new Node("15",70,445); Node p = new Node("16",245,445); Node q = new Node("17",520,445); Node r = new Node("18",795,445); Node s = new Node("19",1070,445); Node t = new Node("20",1345,445); Node u = new Node("21",1620,445); Node V = new Node("22",1895,445); Node w = new Node("23",2170,445);
    Node x = new Node("24",70,645); Node y = new Node("25",520,645); Node z = new Node("26",1070,645);

    Node aa = new Node("27",1620,645); Node ba = new Node("28", 2170,645);
    Node ca = new Node("29",70,845); Node da = new Node("30",245,845); Node ea = new Node("31",520,845); Node fa = new Node("32",795,845); Node ga = new Node("33",1070,845); Node ha = new Node("34",1345,845); Node ia = new Node("35",1620,845); Node ja = new Node("36",1895,845); Node ka = new Node("37",2170,845);
    Node la = new Node("38",70,1045); Node ma = new Node("39",520,1045); Node na = new Node("40",1070,1045); Node oa = new Node("41",1620,1045);Node pa = new Node("42", 2170,1045);
    Node qa = new Node("43",70,1245); Node ra = new Node("44",245,1245); Node sa = new Node("45",520,1245); Node ta = new Node("46",795,1245); Node ua = new Node("47",1070,1245); Node va = new Node("48",1345,1245); Node wa = new Node("49",1620,1245); Node xa = new Node("50",1895,1245); Node ya = new Node("51",2170,1245);
    Node za = new Node("52",70,1445);

    Node ab = new Node("53",520,1445); Node bb = new Node("54",1070,1445); Node cb = new Node("55",1620,1445); Node db = new Node("56", 2170,1445);
    Node eb = new Node("57",70,1645); Node fb = new Node("58",245,1645); Node gb = new Node("59",520,1645); Node hb = new Node("60",795,1645); Node ib = new Node("61",1070,1645); Node jb = new Node("62",1345,1645); Node kb = new Node("63",1620,1645); Node lb = new Node("64",1895,1645); Node mb = new Node("65",2170,1645);
    Node nb = new Node("66",70,1845); Node ob = new Node("67",520,1845); Node pb = new Node("68",1070,1845); Node qb = new Node("69",1620,1845); Node rb = new Node("70", 2170,1845);
    Node sb = new Node("71",70,2045); Node tb = new Node("72",245,2045); Node ub = new Node("73",520,2045); Node vb = new Node("74",795,2045); Node wb = new Node("75",1070,2045); Node xb = new Node("76",1345,2045); Node yb = new Node("77",1620,2045); Node zb = new Node("78",1895,2045); Node ac = new Node("79",2170,2045);

    Node office = new Node("9",2170,45); Node staff = new Node("23",2170,445); Node break_room = new Node("28",1620,650);
    Node female_toilet  = new Node("37",2170,845); Node disability_toilet = new Node("42",1620,1045); Node male_toilet = new Node("51",2170,1245);
    Node bar_section_1 = new Node("70",1620,1845); Node bar_section_2 = new Node("78",1895,2045);

    Node table_1 = new Node("16",245,445); Node table_2 = new Node("18",795,445); Node table_3 = new Node("20",1345,445); Node table_4 = new Node("22",1895,445);
    Node table_5 = new Node("30",245,845); Node table_6 = new Node("32",795,845); Node table_7 = new Node("34",1345,845); Node table_8 = new Node("36",195,845);
    Node table_9 = new Node("44",245,1245); Node table_10 = new Node("46",795,1245); Node table_11 = new Node("48",1345,1245); Node table_12 = new Node("50",1895,1245);
    Node table_13 = new Node("58",250,1645); Node table_14 = new Node("60",795,1645); Node table_15 = new Node("62",1345,1645); Node table_16 = new Node("64",1895,1645);
    Node table_17 = new Node("72",250,2045); Node table_18 = new Node("74",795,2045); Node table_19 = new Node("76",1345,2045); Node table_20 = new Node("78",1895,2045);


    Nav_Graph nav_graph;
    ArrayList<String> list_of_nodes;
    Button done;
    ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);mImageView = (ImageView) findViewById(R.id.iv);
        setContentView(R.layout.map_route);
        list_of_nodes = new ArrayList<>();
        done = findViewById(R.id.done); done.setOnClickListener(v -> reset());
        get_from_server();
        nav_graph = new Nav_Graph();
        nav_graph.addNode(a);
        nav_graph.addNode(b);
        nav_graph.addNode(c);
        nav_graph.addNode(d);
        nav_graph.addNode(e);
        nav_graph.addNode(f);
        nav_graph.addNode(g);
        nav_graph.addNode(h);
        nav_graph.addNode(i);
        nav_graph.addNode(j);
        nav_graph.addNode(k);
        nav_graph.addNode(l);
        nav_graph.addNode(m);
        nav_graph.addNode(n);
        nav_graph.addNode(o);
        nav_graph.addNode(p);
        nav_graph.addNode(q);
        nav_graph.addNode(r);
        nav_graph.addNode(s);
        nav_graph.addNode(t);
        nav_graph.addNode(u);
        nav_graph.addNode(V);
        nav_graph.addNode(w);
        nav_graph.addNode(x);
        nav_graph.addNode(y);
        nav_graph.addNode(z);
        nav_graph.addNode(aa);
        nav_graph.addNode(ba);
        nav_graph.addNode(ca);
        nav_graph.addNode(da);
        nav_graph.addNode(ea);
        nav_graph.addNode(fa);
        nav_graph.addNode(ga);
        nav_graph.addNode(ha);
        nav_graph.addNode(ia);
        nav_graph.addNode(ja);
        nav_graph.addNode(ka);
        nav_graph.addNode(la);
        nav_graph.addNode(ma);
        nav_graph.addNode(na);
        nav_graph.addNode(oa);
        nav_graph.addNode(pa);
        nav_graph.addNode(qa);
        nav_graph.addNode(ra);
        nav_graph.addNode(sa);
        nav_graph.addNode(ta);
        nav_graph.addNode(ua);
        nav_graph.addNode(va);
        nav_graph.addNode(wa);
        nav_graph.addNode(xa);
        nav_graph.addNode(ya);
        nav_graph.addNode(za);
        nav_graph.addNode(ab);
        nav_graph.addNode(bb);
        nav_graph.addNode(cb);
        nav_graph.addNode(db);
        nav_graph.addNode(eb);
        nav_graph.addNode(fb);
        nav_graph.addNode(gb);
        nav_graph.addNode(hb);
        nav_graph.addNode(ib);
        nav_graph.addNode(jb);
        nav_graph.addNode(kb);
        nav_graph.addNode(lb);
        nav_graph.addNode(mb);
        nav_graph.addNode(nb);
        nav_graph.addNode(ob);
        nav_graph.addNode(pb);
        nav_graph.addNode(qb);
        nav_graph.addNode(rb);
        nav_graph.addNode(sb);
        nav_graph.addNode(tb);
        nav_graph.addNode(ub);
        nav_graph.addNode(vb);
        nav_graph.addNode(wb);
        nav_graph.addNode(xb);
        nav_graph.addNode(yb);
        nav_graph.addNode(zb);
        nav_graph.addNode(ca);
        nav_graph.addNode(office);
        nav_graph.addNode(staff);
        nav_graph.addNode(break_room);
        nav_graph.addNode(female_toilet);
        nav_graph.addNode(disability_toilet);
        nav_graph.addNode(bar_section_1);
        nav_graph.addNode(bar_section_2);
        nav_graph.addNode(table_1);
        nav_graph.addNode(table_2);
        nav_graph.addNode(table_3);
        nav_graph.addNode(table_4);
        nav_graph.addNode(table_5);
        nav_graph.addNode(table_6);
        nav_graph.addNode(table_7);
        nav_graph.addNode(table_8);
        nav_graph.addNode(table_9);
        nav_graph.addNode(table_10);
        nav_graph.addNode(table_11);
        nav_graph.addNode(table_12);
        nav_graph.addNode(table_13);
        nav_graph.addNode(table_14);
        nav_graph.addNode(table_15);
        nav_graph.addNode(table_16);
        nav_graph.addNode(table_17);
        nav_graph.addNode(table_18);
        nav_graph.addNode(table_19);
        nav_graph.addNode(table_20);
    }

    private void get_from_server() {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://10.0.2.2:5000/route";
        JsonObjectRequest post_request = new JsonObjectRequest(Request.Method.GET, url, null, response -> {
            try {
                Toast.makeText(this, "Response retrieved",Toast.LENGTH_LONG).show();
                JSONArray route = response.getJSONArray("path");
                for (int i=0;i<route.length();i++) {
                    list_of_nodes.add(String.valueOf(route.get(i)));
                }
                list_of_nodes = removeDuplicates(list_of_nodes);
                mImageView = findViewById(R.id.iv);
                Bitmap bitmap = Bitmap.createBitmap(2600,2270,Bitmap.Config.ARGB_8888); Canvas canvas = new Canvas(bitmap); canvas.drawColor(Color.RED);
                Paint yellow = new Paint(); yellow.setColor(Color.YELLOW); yellow.setStyle(Paint.Style.FILL); yellow.setAntiAlias(true);
                Paint black = new Paint(); black.setColor(Color.BLACK); black.setStyle(Paint.Style.FILL); black.setStrokeWidth(8); black.setAntiAlias(true); black.setTextSize(50);
                canvas.drawRect(150,200,400,300,yellow); canvas.drawText("1",250,265,black);
                canvas.drawRect(150,600,400,700,yellow); canvas.drawText("5",250,665,black);
                canvas.drawRect(150,1000,400,1100,yellow); canvas.drawText("9",250,1065,black);
                canvas.drawRect(150,1400,400,1500,yellow); canvas.drawText("13",250,1465,black);
                canvas.drawRect(150,1800,400,1900,yellow); canvas.drawText("17",250,1865,black);
                canvas.drawRect(700,200,950,300,yellow); canvas.drawText("2",800,265,black);
                canvas.drawRect(700,600,950,700,yellow); canvas.drawText("6",800,665,black);
                canvas.drawRect(700,1000,950,1100,yellow); canvas.drawText("10",800,1065,black);
                canvas.drawRect(700,1400,950,1500,yellow); canvas.drawText("14",800,1465,black);
                canvas.drawRect(700,1800,950,1900,yellow); canvas.drawText("18",800,1865,black);
                canvas.drawRect(1250,200,1500,300,yellow); canvas.drawText("3",1350,265,black);
                canvas.drawRect(1250,600,1500,700,yellow); canvas.drawText("7",1350,665,black);
                canvas.drawRect(1250,1000,1500,1100,yellow); canvas.drawText("11",1350,1065,black);
                canvas.drawRect(1250,1400,1500,1500,yellow); canvas.drawText("15",1350,1465,black);
                canvas.drawRect(1250,1800,1500,1900,yellow); canvas.drawText("19",1350,1865,black);
                canvas.drawRect(1800,200,2050,300,yellow); canvas.drawText("4",1900,265,black);
                canvas.drawRect(1800,600,2050,700,yellow); canvas.drawText("8",1900,665,black);
                canvas.drawRect(1800,1000,2050,1100,yellow); canvas.drawText("12",1900,1065,black);
                canvas.drawRect(1800,1400,2050,1500,yellow); canvas.drawText("16",1900,1465,black);
                canvas.drawRect(1800,1800,2050,1900,yellow); canvas.drawText("20",1900,1865,black);
                canvas.drawLine(2300,100,2300,250,black); canvas.drawRect(2300,5,2600,400,yellow);
                canvas.drawLine(2300,450,2300,550,black); canvas.drawRect(2300,401,2600,599,yellow);
                canvas.drawLine(2300,650,2300,750,black); canvas.drawRect(2300,600,2600,799,yellow);
                canvas.drawRect(2500,800,2600,999,yellow); canvas.drawLine(2500,850,2500,950,black);
                canvas.drawRect(2500,1000,2600, 1199,yellow); canvas.drawLine(2500,1050,2500,1150,black);
                canvas.drawRect(2500,1200,2600,1399,yellow); canvas.drawLine(2500,1250,2500,1350,black);
                canvas.drawRect(2300,1600,2600,2200,yellow); canvas.drawLine(2400,1600,2500,1600,black);
                canvas.drawRect(1800,2100,2600,2200,yellow); canvas.drawRect(20,20,70,70,yellow);
                canvas.drawRect(20,225,70,275,yellow); canvas.drawRect(20,420,70,470,yellow);
                canvas.drawRect(20,625,70,675,yellow); canvas.drawRect(20,820,70,870,yellow);
                canvas.drawRect(20,1025,70,1075,yellow); canvas.drawRect(20,1220,70,1270,yellow);
                canvas.drawRect(20,1425,70,1475,yellow); canvas.drawRect(20,1620,70,1670,yellow);
                canvas.drawRect(20,1825,70,1875,yellow); canvas.drawRect(20,2020,70,2070,yellow);
                canvas.drawRect(245,20,295,70,yellow); canvas.drawRect(245,420,295,470,yellow);
                canvas.drawRect(245,820,295,870,yellow); canvas.drawRect(245,1220,295,1270,yellow);
                canvas.drawRect(245,1620,295,1670,yellow); canvas.drawRect(245,2020,295,2070,yellow);
                canvas.drawRect(520,20,570,70,yellow); canvas.drawRect(520,225,570,275,yellow);
                canvas.drawRect(520,420,570,470,yellow); canvas.drawRect(520,625,570,675,yellow);
                canvas.drawRect(520,820,570,870,yellow); canvas.drawRect(520,1025,570,1075,yellow);
                canvas.drawRect(520,1220,570,1270,yellow); canvas.drawRect(520,1425,570,1475,yellow);
                canvas.drawRect(520,1620,570,1670,yellow); canvas.drawRect(520,1825,570,1875,yellow);
                canvas.drawRect(520,2020,570,2070,yellow); canvas.drawRect(795,20,845,70,yellow);
                canvas.drawRect(795,420,845,470,yellow); canvas.drawRect(795,820,845,870,yellow);
                canvas.drawRect(795,1220,845,1270,yellow); canvas.drawRect(795,1620,845,1670,yellow);
                canvas.drawRect(795,2020,845,2070,yellow); canvas.drawRect(1070,20,1120,70,yellow);
                canvas.drawRect(1070,225,1120,275,yellow); canvas.drawRect(1070,420,1120,470,yellow);
                canvas.drawRect(1070,625,1120,675,yellow); canvas.drawRect(1070,820,1120,870,yellow);
                canvas.drawRect(1070,1025,1120,1075,yellow); canvas.drawRect(1070,1220,1120,1270,yellow);
                canvas.drawRect(1070,1425,1120,1475,yellow); canvas.drawRect(1070,1620,1120,1670,yellow);
                canvas.drawRect(1070,1825,1120,1875,yellow); canvas.drawRect(1070,2020,1120,2070,yellow);
                canvas.drawRect(1345,20,1395,70,yellow); canvas.drawRect(1345,420,1395,470,yellow);
                canvas.drawRect(1345,820,1395,870,yellow); canvas.drawRect(1345,1220,1395,1270,yellow);
                canvas.drawRect(1345,1620,1395,1670,yellow); canvas.drawRect(1345,2020,1395,2070,yellow);
                canvas.drawRect(1620,20,1670,70,yellow); canvas.drawRect(1620,225,1670,275,yellow);
                canvas.drawRect(1620,420,1670,470,yellow); canvas.drawRect(1620,625,1670,675,yellow);
                canvas.drawRect(1620,820,1670,870,yellow); canvas.drawRect(1620,1025,1670,1075,yellow);
                canvas.drawRect(1620,1220,1670,1270,yellow); canvas.drawRect(1620,1425,1670,1475,yellow);
                canvas.drawRect(1620,1620,1670,1670,yellow); canvas.drawRect(1620,1825,1670,1875,yellow);
                canvas.drawRect(1620,2020,1670,2070,yellow); canvas.drawRect(1895,20,1945,70,yellow);
                canvas.drawRect(1895,420,1945,470,yellow); canvas.drawRect(1895,820,1945,870,yellow);
                canvas.drawRect(1895,1220,1945,1270,yellow); canvas.drawRect(1895,1620,1945,1670,yellow);
                canvas.drawRect(1895,2020,1945,2070,yellow); canvas.drawRect(2170,20,2220,70,yellow);
                canvas.drawRect(2170,225,2220,275,yellow); canvas.drawRect(2170,420,2220,470,yellow);
                canvas.drawRect(2170,625,2220,675,yellow); canvas.drawRect(2170,820,2220,870,yellow);
                canvas.drawRect(2170,1025,2220,1075,yellow); canvas.drawRect(2170,1220,2220,1270,yellow);
                canvas.drawRect(2170,1425,2220,1475,yellow); canvas.drawRect(2170,1620,2220,1670,yellow);
                canvas.drawRect(2170,1825,2220,1875,yellow); canvas.drawRect(2170,2020,2220,2070,yellow);
                mImageView.setImageBitmap(bitmap);
                Paint paint = new Paint(); paint.setColor(Color.YELLOW); paint.setStyle(Paint.Style.FILL); paint.setStrokeWidth(8); paint.setAntiAlias(true);
                for (int i = 0; i < list_of_nodes.size()-1; i++) {
                    if (nav_graph.hasNode(list_of_nodes.get(i)) && nav_graph.hasNode(list_of_nodes.get(i + 1))) {
                        Node start = nav_graph.getNode(list_of_nodes.get(i));
                        Node end = nav_graph.getNode(list_of_nodes.get(i + 1));
                        System.out.println(start.getID());
                        System.out.println(end.getID());
                        float startX = start.getX();
                        float startY = start.getY();
                        float stopX = end.getX();
                        float stopY = end.getY();
                        canvas.drawLine(startX,startY,stopX,stopY,paint);
                    }
                }
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