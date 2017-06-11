package ganeshannt.customview;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Ganeshan NT on 4/28/2017.
 */

public class CustomAdapter extends ArrayAdapter<Dataitem>{

    Context context;
    int layoutresourceid;
    List<Dataitem> data = null;

    public CustomAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Dataitem> objects) {
        super(context, resource, objects);

        this.layoutresourceid = resource;
        this.context = context;
        this.data=objects;


    }
    static class  DataHolder
    {
        ImageView ivFlag;
        TextView tvstatename;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        DataHolder holder=null;
        if (convertView==null)
        {
            LayoutInflater inflater =((Activity)context).getLayoutInflater();
            convertView = inflater.inflate(layoutresourceid,parent);
            holder = new DataHolder();
            holder.ivFlag = (ImageView)convertView.findViewById(R.id.ivstate);
            holder.tvstatename = (TextView)convertView.findViewById(R.id.tvstate);
            convertView.setTag(holder);
        }
        else
        {
            holder = (DataHolder)convertView.getTag();
        }
            Dataitem dataitem = data.get(position);
        holder.tvstatename.setText(dataitem.statename);
        holder.ivFlag.setImageResource(dataitem.residthum);
       return  convertView;
    }
}
