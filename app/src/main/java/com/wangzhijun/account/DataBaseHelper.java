package com.wangzhijun.account;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String COST_TITLE = "cost_title";
    public static final String COST_DATE = "cost_date";
    public static final String COST_MONEY = "cost_money";
    public static final String T_COST = "t_cost";

    public DataBaseHelper(Context context) {
        super(context, "account", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists t_cost(id interger primary key, cost_title varchar, cost_date varchar, cost_money varchar)");
    }

    public void insertCost(CostBean costBean) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COST_TITLE, costBean.costTitle);
        contentValues.put(COST_DATE, costBean.costDate);
        contentValues.put(COST_MONEY, costBean.costMoney);
        db.insert(T_COST, null, contentValues);
    }

    public Cursor getAllCostData() {
        SQLiteDatabase database = getWritableDatabase();
        return database.query(T_COST, null, null, null, null, null, "cost_date asc");
    }

    public void deleteAllData() {
        SQLiteDatabase database = getWritableDatabase();
        database.delete(T_COST, null, null);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
