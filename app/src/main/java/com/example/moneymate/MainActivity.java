package com.example.moneymate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private EditText editTitle, editCategory, editAmount;
    private Button btnAdd;
    private RecyclerView recyclerView;

    private List<Expense> expenseList;
    private ExpenseAdapter expenseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Link UI elements
        editTitle = findViewById(R.id.editTitle);
        editCategory = findViewById(R.id.editCategory);
        editAmount = findViewById(R.id.editAmount);
        btnAdd = findViewById(R.id.btnAdd);
        recyclerView = findViewById(R.id.recyclerView);

        // Initialize list and adapter
        expenseList = new ArrayList<>();
        expenseAdapter = new ExpenseAdapter(expenseList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(expenseAdapter);

        // Handle button click
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                expenseList.add(newExpense);
                expenseAdapter.notifyItemInserted(expenseList.size() - 1);

                // Clear fields
                editTitle.setText("");
                editCategory.setText("");
                editAmount.setText("");
            }
        });
    }
}

