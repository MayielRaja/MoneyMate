package com.example.moneymate;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.*;

public class DatabaseHelper extends SQLiteOpenHelper{
    private static final String DATABASE_NAME="moneyMate.db";
    private static final int DATABASE_VERSION=1;
    private static final String TABLE_EXPENSE="expenses";
    private static final String COLUMN_ID="id";
    private static final String COLUMN_TITLE="title";
    private static final String COLUMN_CATEGORY="category";
    private static final String COLUMN_AMOUNT="amount";
    private static final String COLUMN_DATE="date";
    public DatabaseHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        String CREATE_EXPENSE_TABLE="CREATE TABLE"+TABLE_EXPENSE+"("+COLUMN_ID+"INTEFER PRIMARY KEY AUTOINCREMENT, "+COLUMN_TITLE+"TEXT, "+COLUMN_CATEGORY+"TEXT, "+COLUMN_AMOUNT+"REAL, "+COLUMN_DATE+"TEXT, "+")";
        db.execSQL(CREATE_EXPENSE_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,int newVersion){
        db.execSQL("DROP TABLE IF EXISTS"+TABLE_EXPENSE);
        onCreate(db);
    }
    public void insertExpense(Expense expense){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_TITLE,expense.getTitle());
        values.put(COLUMN_CATEGORY,expense.getCategory());
        values.put(COLUMN_AMOUNT,expense.getAmount());
        values.put(COLUMN_DATE,expense.getDate());
        db.insert(TABLE_EXPENSE,null,values);
        db.close();
    }
    public List<Expense> getAllExpenses(){
        List<Expense> expenseList=new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM"+TABLE_EXPENSE,null);
        if(cursor.moveToFirst()){
            do{
                String title= cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TITLE));
                String category= cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CATEGORY));
                double amount= cursor.getDouble(cursor.getColumnIndexOrThrow(COLUMN_AMOUNT));
                String date= cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_DATE));
                expenseList.add(new Expense(title,category,amount,date));
            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return expenseList;
    }
    public void deleteExpense(String title, String category,double amount){
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(TABLE_EXPENSE, COLUMN_TITLE + "=? AND " + COLUMN_CATEGORY + "=? AND " + COLUMN_AMOUNT + "=?",
                new String[]{title, category, String.valueOf(amount)});
        db.close();
    }
}
