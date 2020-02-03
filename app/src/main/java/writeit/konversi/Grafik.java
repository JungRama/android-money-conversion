package writeit.konversi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Grafik extends AppCompatActivity {
    ArrayList<Model> negara = new ArrayList<>();
    Adapterbaru adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafik);
        ListView ListGrafik = (ListView)findViewById(R.id.ListGrafik);
        //BTN ACT BAR
        ImageView menu = (ImageView)findViewById(R.id.menu);
        final ImageView konverter = (ImageView)findViewById(R.id.konverter);
        final ImageView programmer = (ImageView)findViewById(R.id.programmer);
        //ANIMATION
        final Animation AnmLeft = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slideleft);
        final Animation AnmRight = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slideright);

        //      CUSTOM ACTION BAR ALA ALA
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int btn_vis1 = programmer.getVisibility();
                if(btn_vis1==View.VISIBLE){
                    konverter.setVisibility(View.GONE);
                    programmer.setVisibility(View.GONE);
                }
                else if(btn_vis1==View.GONE){
                    konverter.startAnimation(AnmLeft);
                    programmer.startAnimation(AnmLeft);
                    konverter.setVisibility(View.VISIBLE);
                    programmer.setVisibility(View.VISIBLE);
                }
            }
        });
        konverter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gokonven = new Intent (Grafik.this, MainActivity.class);
                startActivity(gokonven);
            }
        });
        programmer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent godevelop = new Intent (Grafik.this, developer.class);
                startActivity(godevelop);
            }
        });

        //      CUSTOM LIST VIEW
        negara.add(new Model(
                R.drawable.usa,
                "United States","(USD)")
        );
        negara.add(new Model(
                R.drawable.japan,
                "Japan","(¥)")
        );
        negara.add(new Model(
                R.drawable.uk,
                "United Kingdom","(GBP)")
        );
        negara.add(new Model(
                R.drawable.euro,
                "Europian Union","(EUR)")
        );
        negara.add(new Model(
                R.drawable.india,
                "Indian","(INR)")
        );
        negara.add(new Model(
                R.drawable.china,
                "China","(CNY)")
        );
        negara.add(new Model(
                R.drawable.thai,
                "Thailand","(TBH)")
        );
        negara.add(new Model(
                R.drawable.malaysia,
                "Malaysia","(MYR)")
        );

        adapter = new Adapterbaru(this,R.layout.design_item_list_grafik,negara);
        ListGrafik.setAdapter(adapter);

        ListGrafik.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int potition, long l) {
                Model model = negara.get(potition);
                String namaNegara = model.namaNegara;
                Intent goDetail = new Intent(Grafik.this, Detail_Graphic.class);
                goDetail.putExtra("nama",namaNegara);
                startActivity(goDetail);
            }
        });

    }

}