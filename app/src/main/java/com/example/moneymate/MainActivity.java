package com.example.moneymate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private EditText editTitle, editCategory, editAmount;
    private Button btnAdd;
    private RecyclerView recyclerView;
    private TextView textSummary;

    private List<Expense> expenseList;
    private ExpenseAdapter expenseAdapter;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTitle = findViewById(R.id.editTitle);
        editCategory = findViewById(R.id.editCategory);
        editAmount = findViewById(R.id.editAmount);
        btnAdd = findViewById(R.id.btnAdd);
        recyclerView = findViewById(R.id.recyclerView);
        textSummary = findViewById(R.id.textSummary);

        databaseHelper = new DatabaseHelper(this);
        expenseList = databaseHelper.getAllExpenses();

        expenseAdapter = new ExpenseAdapter(expenseList, this::deleteExpense);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(expenseAdapter);

        btnAdd.setOnClickListener(v -> {
            String title = editTitle.getText().toString().trim();
            String category = editCategory.getText().toString().trim();
            String amountStr = editAmount.getText().toString().trim();

            if (title.isEmpty() || category.isEmpty() || amountStr.isEmpty()) {
                Toast.makeText(MainActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            double amount;
            try {
                amount = Double.parseDouble(amountStr);
            } catch (NumberFormatException e) {
                Toast.makeText(MainActivity.this, "Invalid amount", Toast.LENGTH_SHORT).show();
                return;
            }

            String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
            Expense newExpense = new Expense(title, category, amount, date);

            databaseHelper.insertExpense(newExpense);
            expenseList.clear();
            expenseList.addAll(databaseHelper.getAllExpenses());
            expenseAdapter.notifyDataSetChanged();

            editTitle.setText("");
            editCategory.setText("");
            editAmount.setText("");

            updateSummary();
        });

        updateSummary(); // Initial update on app load
    }

    private void deleteExpense(Expense expense) {
        databaseHelper.deleteExpense(expense.getTitle(), expense.getCategory(), expense.getAmount());
        expenseList.clear();
        expenseList.addAll(databaseHelper.getAllExpenses());
        expenseAdapter.notifyDataSetChanged();
        updateSummary();
    }

    private void updateSummary() {
        double weekTotal = databaseHelper.getWeeklyTotal();
        double monthTotal = databaseHelper.getMonthlyTotal();
        textSummary.setText("Weekly Total: ₹" + weekTotal + "\nMonthly Total: ₹" + monthTotal);
    }
}

