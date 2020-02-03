package writeit.konversi;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Detail_Graphic extends AppCompatActivity {

    String namaNegara;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail__graphic);

        ImageView bendera = (ImageView)findViewById(R.id.bendera);
        ImageView grafik = (ImageView)findViewById(R.id.grafik);
        TextView penjelasan = (TextView)findViewById(R.id.penjelasan);
        TextView nameNegara = (TextView)findViewById(R.id.namaNegara);
        TextView mataUang = (TextView)findViewById(R.id.mataUang);
        TextView back = (TextView)findViewById(R.id.back);
        String namaNegara = getIntent().getStringExtra("nama");

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(Detail_Graphic.this, Grafik.class);
                startActivity(back);
            }
        });

        if (namaNegara.equals("United States")){
            bendera.setImageResource(R.drawable.usa);
            nameNegara.setText("United States");
            mataUang.setText("USD");
            grafik.setImageResource(R.drawable.grafik_us);
            penjelasan.setText(R.string.us);
        }else if(namaNegara.equals("Japan")){
            bendera.setImageResource(R.drawable.japan);
            nameNegara.setText("Japan");
            mataUang.setText("Yen");
            grafik.setImageResource(R.drawable.grafik_japan);
            penjelasan.setText(R.string.japan);
        }else if(namaNegara.equals("United Kingdom")){
            bendera.setImageResource(R.drawable.uk);
            nameNegara.setText("United Kingdom");
            mataUang.setText("Pounds");
            grafik.setImageResource(R.drawable.grafik_uk);
            penjelasan.setText(R.string.uk);
        }else if(namaNegara.equals("Europian Union")){
            bendera.setImageResource(R.drawable.euro);
            nameNegara.setText("Europian Union");
            mataUang.setText("Euro");
            grafik.setImageResource(R.drawable.grafik_euro);
            penjelasan.setText(R.string.euro);
        }else if(namaNegara.equals("Indian")){
            bendera.setImageResource(R.drawable.india);
            nameNegara.setText("Indian");
            mataUang.setText("Rupee");
            grafik.setImageResource(R.drawable.grafik_india);
            penjelasan.setText(R.string.india);
        }else if(namaNegara.equals("China")){
            bendera.setImageResource(R.drawable.china);
            nameNegara.setText("China");
            mataUang.setText("Yuan");
            grafik.setImageResource(R.drawable.grafik_china);
            penjelasan.setText(R.string.china);
        }else if(namaNegara.equals("Thailand")){
            bendera.setImageResource(R.drawable.thai);
            nameNegara.setText("Thailand");
            mataUang.setText("Bath");
            grafik.setImageResource(R.drawable.grafik_thai);
            penjelasan.setText(R.string.thai);
        }else if(namaNegara.equals("Malaysia")){
            bendera.setImageResource(R.drawable.malaysia);
            nameNegara.setText("Malaysia");
            mataUang.setText("Ringit");
            grafik.setImageResource(R.drawable.grafik_malay);
            penjelasan.setText(R.string.malay);
        }
    }
}
