package com.wangzhijun.account;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CostListAdapter extends BaseAdapter {

    private List<CostBean> costBeanList;
    private Context context;
    private LayoutInflater layoutInflater;

    public CostListAdapter(Context context, List<CostBean> list) {
        costBeanList = list;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return costBeanList.size();
    }

    @Override
    public Object getItem(int position) {
        return costBeanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.list_item, null);
            viewHolder.textViewTitle = convertView.findViewById(R.id.tv_title);
            viewHolder.textViewDate = convertView.findViewById(R.id.tv_date);
            viewHolder.textViewMoney = convertView.findViewById(R.id.tv_cost);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        CostBean costBean = costBeanList.get(position);
        viewHolder.textViewMoney.setText(costBean.costMoney);
        viewHolder.textViewDate.setText(costBean.costDate);
        viewHolder.textViewTitle.setText(costBean.costTitle);
        return convertView;
    }

    private static class ViewHolder {
        public TextView textViewTitle;
        public TextView textViewDate;
        public TextView textViewMoney;
    }
}
