package writeit.konversi;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Model> negara = new ArrayList<>();
    Adapterbaru adapter;
    Character op = 'q';
    public String str ="";
    float i,num,numtemp;

    TextView result;
    TextView hasilValue;
//  BTN OK ALL
    Button btn_ok;
    Button btn_ok_japan;
    Button btn_ok_uk;
    Button btn_ok_euro;
    Button btn_ok_india;
    Button btn_ok_china;
    Button btn_ok_thai;
    Button btn_ok_malay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = (TextView) findViewById(R.id.IndoValue);
        hasilValue = (TextView) findViewById(R.id.hasilValue);

        final LinearLayout content = (LinearLayout)findViewById(R.id.layoutContent);
        final LinearLayout pilihanKonven = (LinearLayout)findViewById(R.id.pilihanKonven);
        final LinearLayout layout_angka = (LinearLayout)findViewById(R.id.layout_angka);
        final TextView btn = (TextView)findViewById(R.id.btn_PilihKonven);
        final TextView NameNegara = (TextView)findViewById(R.id.negara);
        final ImageView Benderanegara = (ImageView)findViewById(R.id.mtnegara);
        ImageView back = (ImageView)findViewById(R.id.back);
//      BUTTON ANGKA
        final Button btn_0 = (Button)findViewById(R.id.btn_0);
        Button btn_1 = (Button)findViewById(R.id.btn_1);
        Button btn_2 = (Button)findViewById(R.id.btn_2);
        Button btn_3 = (Button)findViewById(R.id.btn_3);
        Button btn_4 = (Button)findViewById(R.id.btn_4);
        Button btn_5 = (Button)findViewById(R.id.btn_5);
        Button btn_6 = (Button)findViewById(R.id.btn_6);
        Button btn_7 = (Button)findViewById(R.id.btn_7);
        Button btn_8 = (Button)findViewById(R.id.btn_8);
        Button btn_9 = (Button)findViewById(R.id.btn_9);
        Button btn_titik = (Button)findViewById(R.id.btn_titik);
        Button btn_clear = (Button)findViewById(R.id.btn_clear);
        Button btn_delete = (Button)findViewById(R.id.btn_delete);
//      BTN ACT BAR
        ImageView menu = (ImageView)findViewById(R.id.menu);
        final ImageView graphic = (ImageView)findViewById(R.id.graphic);
        final ImageView programmer = (ImageView)findViewById(R.id.programmer);
//      BTN OK
        btn_ok = (Button)findViewById(R.id.btn_ok);
        btn_ok_japan = (Button)findViewById(R.id.btn_ok_japan);
        btn_ok_uk = (Button)findViewById(R.id.btn_ok_uk);
        btn_ok_euro = (Button)findViewById(R.id.btn_ok_euro);
        btn_ok_india = (Button)findViewById(R.id.btn_ok_india);
        btn_ok_china = (Button)findViewById(R.id.btn_ok_china);
        btn_ok_thai = (Button)findViewById(R.id.btn_ok_thai);
        btn_ok_malay = (Button)findViewById(R.id.btn_ok_malay);
//      LIST
        ListView ListKonven = (ListView)findViewById(R.id.ListKonven);
//      Animasi
        final Animation AnmUp = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animateup);
        final Animation AnmDown = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animatedown);

        final Animation AnmLeft = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slideleft);
        final Animation AnmRight = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slideright);
//      CUSTOM ACTION BAR ALA ALA
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int btn_vis1 = programmer.getVisibility();
                if(btn_vis1==View.VISIBLE){
                    graphic.setVisibility(View.GONE);
                    programmer.setVisibility(View.GONE);
                }
                else if(btn_vis1==View.GONE){
                    graphic.startAnimation(AnmLeft);
                    programmer.startAnimation(AnmLeft);
                    graphic.setVisibility(View.VISIBLE);
                    programmer.setVisibility(View.VISIBLE);
                }
            }
        });
        graphic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goGrafik = new Intent (MainActivity.this, Grafik.class);
                startActivity(goGrafik);
            }
        });
        programmer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goGrafik = new Intent (MainActivity.this, developer.class);
                startActivity(goGrafik);
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

        adapter = new Adapterbaru(this,R.layout.design_item_list,negara);
        ListKonven.setAdapter(adapter);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pilihanKonven.startAnimation(AnmUp);
                pilihanKonven.setVisibility(View.VISIBLE);
                content.setVisibility(View.GONE);
                layout_angka.setVisibility(View.GONE);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pilihanKonven.startAnimation(AnmDown);
                pilihanKonven.setVisibility(View.GONE);
                content.setVisibility(View.VISIBLE);
                layout_angka.setVisibility(View.VISIBLE);
            }
        });
//      LIST VIEW ITEM ON CLICK
        ListKonven.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int potition, long l) {
                if (potition==0){
                    btn.setText("USD ");
                    NameNegara.setText("United States");
                    Benderanegara.setImageResource(R.drawable.usa);

 //                 SET VISIBILITY TO ALL SHIT
                    btn_ok.setVisibility(View.VISIBLE);
                    btn_ok_japan.setVisibility(View.GONE);
                    btn_ok_uk.setVisibility(View.GONE);
                    btn_ok_euro.setVisibility(View.GONE);
                    btn_ok_india.setVisibility(View.GONE);
                    btn_ok_china.setVisibility(View.GONE);
                    btn_ok_thai.setVisibility(View.GONE);
                    btn_ok_malay.setVisibility(View.GONE);

                    pilihanKonven.startAnimation(AnmDown);
                    pilihanKonven.setVisibility(View.GONE);
                    content.setVisibility(View.VISIBLE);
                    layout_angka.setVisibility(View.VISIBLE);
                }
                if (potition==1){
                    btn.setText("¥ ");
                    NameNegara.setText("Jepang");
                    Benderanegara.setImageResource(R.drawable.japan);

//                  SET VISIBILITY TO ALL SHIT
                    btn_ok.setVisibility(View.GONE);
                    btn_ok_japan.setVisibility(View.VISIBLE);
                    btn_ok_uk.setVisibility(View.GONE);
                    btn_ok_euro.setVisibility(View.GONE);
                    btn_ok_india.setVisibility(View.GONE);
                    btn_ok_china.setVisibility(View.GONE);
                    btn_ok_thai.setVisibility(View.GONE);
                    btn_ok_malay.setVisibility(View.GONE);

                    pilihanKonven.startAnimation(AnmDown);
                    pilihanKonven.setVisibility(View.GONE);
                    content.setVisibility(View.VISIBLE);
                    layout_angka.setVisibility(View.VISIBLE);
                }
                if (potition==2){
                    btn.setText("GBP ");
                    NameNegara.setText("United Kingdom");
                    Benderanegara.setImageResource(R.drawable.uk);

//                  SET VISIBILITY TO ALL SHIT
                    btn_ok.setVisibility(View.GONE);
                    btn_ok_japan.setVisibility(View.GONE);
                    btn_ok_uk.setVisibility(View.VISIBLE);
                    btn_ok_euro.setVisibility(View.GONE);
                    btn_ok_india.setVisibility(View.GONE);
                    btn_ok_china.setVisibility(View.GONE);
                    btn_ok_thai.setVisibility(View.GONE);
                    btn_ok_malay.setVisibility(View.GONE);

                    pilihanKonven.startAnimation(AnmDown);
                    pilihanKonven.setVisibility(View.GONE);
                    content.setVisibility(View.VISIBLE);
                    layout_angka.setVisibility(View.VISIBLE);
                }
                if (potition==3){
                    btn.setText("EUR ");
                    NameNegara.setText("Euro");
                    Benderanegara.setImageResource(R.drawable.euro);

//                  SET VISIBILITY TO ALL SHIT
                    btn_ok.setVisibility(View.GONE);
                    btn_ok_japan.setVisibility(View.GONE);
                    btn_ok_uk.setVisibility(View.GONE);
                    btn_ok_euro.setVisibility(View.VISIBLE);
                    btn_ok_india.setVisibility(View.GONE);
                    btn_ok_china.setVisibility(View.GONE);
                    btn_ok_thai.setVisibility(View.GONE);
                    btn_ok_malay.setVisibility(View.GONE);

                    pilihanKonven.startAnimation(AnmDown);
                    pilihanKonven.setVisibility(View.GONE);
                    content.setVisibility(View.VISIBLE);
                    layout_angka.setVisibility(View.VISIBLE);
                }
                if (potition==4){
                    btn.setText("INR ");
                    NameNegara.setText("India");
                    Benderanegara.setImageResource(R.drawable.india);

//                  SET VISIBILITY TO ALL SHIT
                    btn_ok.setVisibility(View.GONE);
                    btn_ok_japan.setVisibility(View.GONE);
                    btn_ok_uk.setVisibility(View.GONE);
                    btn_ok_euro.setVisibility(View.GONE);
                    btn_ok_india.setVisibility(View.VISIBLE);
                    btn_ok_china.setVisibility(View.GONE);
                    btn_ok_thai.setVisibility(View.GONE);
                    btn_ok_malay.setVisibility(View.GONE);

                    pilihanKonven.startAnimation(AnmDown);
                    pilihanKonven.setVisibility(View.GONE);
                    content.setVisibility(View.VISIBLE);
                    layout_angka.setVisibility(View.VISIBLE);
                }
                if (potition==5){
                    btn.setText("CNY ");
                    NameNegara.setText("China");
                    Benderanegara.setImageResource(R.drawable.china);

//                  SET VISIBILITY TO ALL SHIT
                    btn_ok.setVisibility(View.GONE);
                    btn_ok_japan.setVisibility(View.GONE);
                    btn_ok_uk.setVisibility(View.GONE);
                    btn_ok_euro.setVisibility(View.GONE);
                    btn_ok_india.setVisibility(View.GONE);
                    btn_ok_china.setVisibility(View.VISIBLE);
                    btn_ok_thai.setVisibility(View.GONE);
                    btn_ok_malay.setVisibility(View.GONE);

                    pilihanKonven.startAnimation(AnmDown);
                    pilihanKonven.setVisibility(View.GONE);
                    content.setVisibility(View.VISIBLE);
                    layout_angka.setVisibility(View.VISIBLE);
                }
                if (potition==6){
                    btn.setText("TBH ");
                    NameNegara.setText("Thailand");
                    Benderanegara.setImageResource(R.drawable.thai);

//                  SET VISIBILITY TO ALL SHIT
                    btn_ok.setVisibility(View.GONE);
                    btn_ok_japan.setVisibility(View.GONE);
                    btn_ok_uk.setVisibility(View.GONE);
                    btn_ok_euro.setVisibility(View.GONE);
                    btn_ok_india.setVisibility(View.GONE);
                    btn_ok_china.setVisibility(View.GONE);
                    btn_ok_thai.setVisibility(View.VISIBLE);
                    btn_ok_malay.setVisibility(View.GONE);

                    pilihanKonven.startAnimation(AnmDown);
                    pilihanKonven.setVisibility(View.GONE);
                    content.setVisibility(View.VISIBLE);
                    layout_angka.setVisibility(View.VISIBLE);
                }
                if (potition==7){
                    btn.setText("MYR ");
                    NameNegara.setText("Malaysia");
                    Benderanegara.setImageResource(R.drawable.malaysia);

//                  SET VISIBILITY TO ALL SHIT
                    btn_ok.setVisibility(View.GONE);
                    btn_ok_japan.setVisibility(View.GONE);
                    btn_ok_uk.setVisibility(View.GONE);
                    btn_ok_euro.setVisibility(View.GONE);
                    btn_ok_india.setVisibility(View.GONE);
                    btn_ok_china.setVisibility(View.GONE);
                    btn_ok_thai.setVisibility(View.GONE);
                    btn_ok_malay.setVisibility(View.VISIBLE);

                    pilihanKonven.startAnimation(AnmDown);
                    pilihanKonven.setVisibility(View.GONE);
                    content.setVisibility(View.VISIBLE);
                    layout_angka.setVisibility(View.VISIBLE);
                }
            }
        });
//      COBA SET ANGKA
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (result.getText().toString().trim().equals("")){
                    hasilValue.setText("");
                }else if (result.getText().toString().trim().equals(".")){
                    hasilValue.setText("");
                }else{
                    double pertama = Float.valueOf(result.getText().toString());
                    double hasil = pertama/13501;
                    hasilValue.setText(new DecimalFormat("##.##").format(hasil));
                }
            }
        });
        btn_ok_japan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (result.getText().toString().trim().equals("")){
                    hasilValue.setText("");
                }else if (result.getText().toString().trim().equals(".")){
                    hasilValue.setText("");
                }else {
                    double pertama = Float.valueOf(result.getText().toString());
                    double hasil = pertama / 120.554;
                    hasilValue.setText(new DecimalFormat("##.##").format(hasil));
                }
            }
        });
        btn_ok_uk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (result.getText().toString().trim().equals("")){
                    hasilValue.setText("");
                }else if (result.getText().toString().trim().equals(".")){
                    hasilValue.setText("");
                }else {
                    double pertama = Float.valueOf(result.getText().toString());
                    double hasil = pertama / 17945.9459;
                    hasilValue.setText(new DecimalFormat("##.###").format(hasil));
                }
            }
        });
        btn_ok_euro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (result.getText().toString().trim().equals("")){
                    hasilValue.setText("");
                }else if (result.getText().toString().trim().equals(".")){
                    hasilValue.setText("");
                }else {
                    double pertama = Float.valueOf(result.getText().toString());
                    double hasil = pertama / 15995;
                    hasilValue.setText(new DecimalFormat("##.##").format(hasil));
                }
            }
        });
        btn_ok_india.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (result.getText().toString().trim().equals("")){
                    hasilValue.setText("");
                }else if (result.getText().toString().trim().equals(".")){
                    hasilValue.setText("");
                }else {
                    double pertama = Float.valueOf(result.getText().toString());
                    double hasil = pertama / 207.7027;
                    hasilValue.setText(new DecimalFormat("##.##").format(hasil));
                }
            }
        });
        btn_ok_china.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (result.getText().toString().trim().equals("")){
                    hasilValue.setText("");
                }else if (result.getText().toString().trim().equals(".")){
                    hasilValue.setText("");
                }else {
                    double pertama = Float.valueOf(result.getText().toString());
                    double hasil = pertama / 2050.65;
                    hasilValue.setText(new DecimalFormat("##.##").format(hasil));
                }
            }
        });
        btn_ok_thai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (result.getText().toString().trim().equals("")){
                    hasilValue.setText("");
                }else if (result.getText().toString().trim().equals(".")){
                    hasilValue.setText("");
                }else {
                    double pertama = Float.valueOf(result.getText().toString());
                    double hasil = pertama / 408.208;
                    hasilValue.setText(new DecimalFormat("##.##").format(hasil));
                }
            }
        });
        btn_ok_malay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (result.getText().toString().trim().equals("")){
                    hasilValue.setText("");
                }else if (result.getText().toString().trim().equals(".")){
                    hasilValue.setText("");
                }else {
                    double pertama = Float.valueOf(result.getText().toString());
                    double hasil = pertama / 3199.72;
                    hasilValue.setText(new DecimalFormat("##.##").format(hasil));
                }
            }
        });

//      BUTTON ANGKA ON CLICK
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(result.getText()+"1");
            }
        });
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(result.getText()+"2");
            }
        });
        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(result.getText()+"3");
            }
        });
        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(result.getText()+"4");
            }
        });
        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(result.getText()+"5");
            }
        });
        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(result.getText()+"6");
            }
        });
        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(result.getText()+"7");
            }
        });
        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(result.getText()+"8");
            }
        });
        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(result.getText()+"9");
            }
        });
        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(result.getText()+"0");
            }
        });
        btn_titik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(result.getText()+".");
            }
        });
        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset();
            }
        });
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!result.getText().toString().equals("")){
                    String del=result.getText().toString();
                    if (del.length() > 0 ) {
                        del = del.substring(0, del.length()-1);
                        result.setText(del);
                    }
                }
            }
        });
    }


//  FUNCTION
    private void reset() {
        // TODO Auto-generated method stub
        str ="";
        op ='q';
        num = 0;
        numtemp = 0;
        result.setText("");
        result.setHint("0");
        hasilValue.setText("");
        result.setHint("0");
    }

}
