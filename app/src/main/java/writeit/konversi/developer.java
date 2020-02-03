package writeit.konversi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class developer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer);

        //BTN ACT BAR
        ImageView menu = (ImageView)findViewById(R.id.menu);
        final ImageView graphic = (ImageView)findViewById(R.id.graphic);
        final ImageView konverter = (ImageView)findViewById(R.id.konverter);
        //ANIMATION
        final Animation AnmLeft = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slideleft);
        final Animation AnmRight = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slideright);

        //      CUSTOM ACTION BAR ALA ALA
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int btn_vis1 = graphic.getVisibility();
                if(btn_vis1==View.VISIBLE){
                    graphic.setVisibility(View.GONE);
                    konverter.setVisibility(View.GONE);
                }
                else if(btn_vis1==View.GONE){
                    graphic.startAnimation(AnmLeft);
                    konverter.startAnimation(AnmLeft);
                    graphic.setVisibility(View.VISIBLE);
                    konverter.setVisibility(View.VISIBLE);
                }
            }
        });

        konverter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gokonven = new Intent (developer.this, MainActivity.class);
                startActivity(gokonven);
            }
        });
        graphic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gographic = new Intent (developer.this, Grafik.class);
                startActivity(gographic);
            }
        });
    }
}
