package com.wangzhijun.account;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.view.LineChartView;

public class ChartsActvity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chart_view);
        LineChartView chart = findViewById(R.id.chart);

        List<CostBean> beanList = (List<CostBean>) getIntent().getSerializableExtra("cost_list");
        Map<String, Integer> map = new TreeMap<>();
        String key;
        int value;
        for (CostBean costBean : beanList) {
            key = costBean.costDate;
            value = Integer.parseInt(costBean.costMoney);
            if (map.containsKey(key)) {
                value = value + map.get(key);
            }
            map.put(key, value);
        }

        List<PointValue> values = new ArrayList<>();
        int x = 0;
        for (Integer money : map.values()) {
            values.add(new PointValue(x, money));
            x++;
        }

        Line line = new Line(values).setColor(Color.BLUE).setCubic(true);
        List<Line> lines = new ArrayList<>();
        lines.add(line);

        LineChartData data = new LineChartData();
        data.setLines(lines);

        chart.setLineChartData(data);
    }


}
