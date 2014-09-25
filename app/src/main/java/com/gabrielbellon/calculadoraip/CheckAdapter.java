//package com.gabrielbellon.calculadoraip;
//
//import java.util.ArrayList;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.CheckBox;
//import android.widget.TextView;
//import android.widget.Toast;
//
//public class CheckAdapter extends ArrayAdapter<String> {
//	
//	private final ArrayList<String> selecionados = new ArrayList<String>();
//	private ArrayList<String> hosts;
//	private LayoutInflater inflater;
//	private ViewHolder viewHolder;
//	
//	static class ViewHolder{
//		private CheckBox check;
//	}
//
//	public CheckAdapter(Context context, int textViewResourceId, String[] objects) {
//		super(context, textViewResourceId, objects);
//		
//		this.hosts = new ArrayList<String>();
//		inflater = LayoutInflater.from(context);
//		
//		for(String item: objects){
//			hosts.add(item);
//		}
//	}
//
//	@Override
//	public int getCount() {
//		return hosts.size();
//	}
//
//	@Override
//	public String getItem(int position) {
//		return hosts.get(position);
//	}
//
//	@Override
//	public long getItemId(int position) {
//		return 0;
//	}
//
//	@Override
//	public int getItemViewType(int arg0) {
//		return 0;
//	}
//
//	@Override
//	public View getView(int position, View convertView, ViewGroup parent) {
//
//		if (convertView == null) {
//			convertView = inflater.inflate(R.layout.host_layout, null);
//			viewHolder = new ViewHolder();
// 
//			viewHolder.check = (CheckBox) convertView.findViewById(R.id.check);
// 
//			convertView.setTag(viewHolder);
// 
//		} else {
//			viewHolder = (ViewHolder) convertView.getTag();
//		}
// 
//		if(hosts.get(position) != null){
//			viewHolder.check.setText(hosts.get(position));
//			viewHolder.check.setOnClickListener(new View.OnClickListener() {
//	            @Override
//	            public void onClick(View v) {
//	            	CheckBox chk = (CheckBox) v;
//	            	
//	            	Toast.makeText(getContext(), v.getId()+"", Toast.LENGTH_SHORT).show();
//	            	if(chk.isChecked()) {
//	            		if(!selecionados.contains(v.getId()+""))
//	                        selecionados.add(v.getId()+"");
//	            	} else {
//	            		if(selecionados.contains(v.getId()+""))
//	                        selecionados.remove(v.getId()+"");
//	                }
//	            }
//	        });
//		} else {
//			viewHolder.check.setText("");
//		}
//		
//		return convertView;
//	}
//
//
//	@Override
//	public boolean isEmpty() {
//		if(hosts.isEmpty()) return true;
//		return false;
//	}
//}
