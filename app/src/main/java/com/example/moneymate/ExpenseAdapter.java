package com.example.moneymate;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ExpenseAdapter extends RecyclerView.Adapter<ExpenseAdapter.ExpenseViewHolder> {

    private List<Expense> expenseList;
    private OnDeleteClickListener deleteClickListener;

    public ExpenseAdapter(List<Expense> expenseList, OnDeleteClickListener deleteClickListener) {
        this.expenseList = expenseList;
        this.deleteClickListener = deleteClickListener;
    }

    @NonNull
    @Override
    public ExpenseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_expense, parent, false);
        return new ExpenseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExpenseViewHolder holder, int position) {
        Expense expense = expenseList.get(position);
        holder.textTitle.setText(expense.getTitle());
        holder.textCategory.setText(expense.getCategory());
        holder.textAmount.setText("₹" + String.format("%.2f", expense.getAmount()));
        holder.textDate.setText(expense.getDate());

        holder.btnDelete.setOnClickListener(v -> {
            if (deleteClickListener != null) {
                deleteClickListener.onDeleteClick(expense);
            }
        });
    }

    @Override
    public int getItemCount() {
        return expenseList.size();
    }

    public static class ExpenseViewHolder extends RecyclerView.ViewHolder {
        TextView textTitle, textCategory, textAmount, textDate;
        Button btnDelete;

        public ExpenseViewHolder(@NonNull View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.textTitle);
            textCategory = itemView.findViewById(R.id.textCategory);
            textAmount = itemView.findViewById(R.id.textAmount);
            textDate = itemView.findViewById(R.id.textDate);
            btnDelete = itemView.findViewById(R.id.btnDelete);
        }
    }

    // Interface to handle delete click
    public interface OnDeleteClickListener {
        void onDeleteClick(Expense expense);
    }
}
