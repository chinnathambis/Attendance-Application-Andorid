package com.example.jam;

import java.util.ArrayList;

//import com.jam.attendance.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;

public class ListAdapter extends BaseAdapter {
	Context ctx;
	LayoutInflater lInflater;
	ArrayList<student> objects;

	ListAdapter(Context context, ArrayList<student> products) {
		ctx = context;
		objects = products;
		lInflater = (LayoutInflater) ctx
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {
		return objects.size();
	}

	@Override
	public Object getItem(int position) {
		return objects.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = convertView;
		if (view == null) {
			view = lInflater.inflate(R.layout.student, parent, false);
		}

		student p = getProduct(position);

		((TextView) view.findViewById(R.id.tvDescr)).setText(p.std_name);
		((TextView) view.findViewById(R.id.tvPrice)).setText(p.roll_no + "");
		((ImageView) view.findViewById(R.id.ivImage)).setImageResource(p.std_photo);

		CheckBox cbBuy = (CheckBox) view.findViewById(R.id.cbBox);
		cbBuy.setOnCheckedChangeListener(myCheckChangList);
		cbBuy.setTag(position);
		cbBuy.setChecked(p.box);
		return view;
	}

	student getProduct(int position) {
		return ((student) getItem(position));
	}

	ArrayList<student> getBox() {
		ArrayList<student> box = new ArrayList<student>();
		for (student p : objects) {
			if (p.box)
				box.add(p);
		}
 		return box;
	}

	OnCheckedChangeListener myCheckChangList = new OnCheckedChangeListener() {
		public void onCheckedChanged(CompoundButton buttonView,
				boolean isChecked) {
			getProduct((Integer) buttonView.getTag()).box = isChecked;
		}
	};
}