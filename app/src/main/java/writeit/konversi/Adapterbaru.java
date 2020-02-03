package writeit.konversi;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Gung Rama on 10/11/2017.
 */

public class Adapterbaru extends ArrayAdapter<Model> {
    Context context;
    int layoutResourceId;
    ArrayList<Model> data;

    public Adapterbaru (Context context, int layoutResouceId, ArrayList<Model> data){
        super(context, layoutResouceId, data);
        this.context = context;
        this.layoutResourceId = layoutResouceId;
        this.data = data;
    }
    static class ViewHolder{
        ImageView bendera;
        TextView namaNegara;
        TextView mataUang;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        ViewHolder holder = null;

        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new ViewHolder();
            holder.bendera = (ImageView) row.findViewById(R.id.bendera);
            holder.namaNegara = (TextView) row.findViewById(R.id.namaNegara);
            holder.mataUang = (TextView) row.findViewById(R.id.mataUang);
            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();
        }
        Model model = data.get(position);
        holder.bendera.setImageResource(model.bendera);
        holder.namaNegara.setText(model.namaNegara);
        holder.mataUang.setText(model.mataUang);

        return row;
    }
}
