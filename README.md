# 💸 MoneyMate – Student Life Expense Tracker

MoneyMate is a simple and intuitive Android application designed for students to track their daily expenses easily. With a minimal and clean interface, users can quickly add, view, and delete their expenses on the go.

---

## 📱 Features

- 🚀 Add Expenses: Input title, category, and amount in seconds.
- 🗑️ Delete Entries: Instantly remove any expense from the list.
- 📋 Expense List: All added entries are shown in a neat scrollable list.
- 💾 Planned Feature: SQLite storage integration for persistent data (currently in progress).
- 📊 Upcoming Updates:
  - Monthly & weekly spending summaries
  - Category-based filtering
  - User login & cloud backup

---

## ⚙️ Tech Stack

- 🧠 Language: Java  
- 📱 Platform: Android (no login required initially)  
- 🗃️ Database: In-memory (SQLite planned)  
- 🧰 UI Components: RecyclerView, EditText, Buttons  
- 🎨 Architecture: MVVM-ready  

---

## 📂 Folder Structure

MoneyMate/
├── app/
│   ├── java/com/example/moneymate/
│   │   ├── MainActivity.java  
│   │   ├── Expense.java  
│   │   ├── ExpenseAdapter.java  
│   │   └── DatabaseHelper.java (coming soon)  
│   ├── res/
│   │   ├── layout/activity_main.xml  
│   │   ├── layout/item_expense.xml  
│   │   └── values/
│   │       ├── strings.xml  
│   │       ├── themes.xml  
│   │       └── colors.xml  
└── AndroidManifest.xml

---

## 🚀 How to Run the App

1. Clone the repository:
https://github.com/MayielRaja/MoneyMate.git
2. Open it in Android Studio  
3. Connect your device or start an emulator  
4. Press the **Run** button or hit `Shift + F10`

---

## 🛠️ What's Next?

- [ ] Add SQLite storage via DatabaseHelper  
- [ ] Display total expenses for current week/month  
- [ ] Export data to CSV or PDF  
- [ ] Add authentication (Google/Firebase login)  
- [ ] Sync to cloud (MySQL backend or Firebase)  

---

## 🙌 Credits

Developed by **Mayiel Raja Sundar**  
Engineering Graduate | 📱 Android Enthusiast | 🧠 Java Developer

---

## 📃 License

MIT License — feel free to fork, modify, and improve!
