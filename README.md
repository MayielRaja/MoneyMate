💸 MoneyMate
MoneyMate is a lightweight expense tracking Android application designed specifically for students to manage their daily spending efficiently — without the hassle of logging in.

📱 Features (v1.1)
✅ Add new expenses with title, category, amount, and date

✅ View a scrollable list of all expenses

✅ Delete expenses instantly from both UI and database

✅ Auto-save all data using SQLite (no internet required)

✅ Date tracking for each expense

✅ Ready for future upgrades like weekly/monthly summaries and user login

📌 Tech Stack
Android (Java)

SQLite for local data storage

XML for UI layout

No login required in v1.1 (coming in future updates)

🚀 Setup Instructions
Clone this repo

bash
Copy
Edit
git clone https://github.com/MayielRaja/MoneyMate.git
Open the project in Android Studio

Run the app on an emulator or physical device (API 21+ recommended)

📁 Project Structure
pgsql
Copy
Edit
📦 app/
 ┣ 📂 java/com/example/moneymate
 ┃ ┣ 📄 MainActivity.java
 ┃ ┣ 📄 Expense.java
 ┃ ┣ 📄 ExpenseAdapter.java
 ┃ ┗ 📄 DatabaseHelper.java
 ┣ 📂 res/layout
 ┃ ┣ 📄 activity_main.xml
 ┃ ┗ 📄 item_expense.xml
 ┗ 📂 res/values
   ┗ 📄 colors.xml, strings.xml, themes.xml
🏷️ Version
v1.1 - Initial Stable Release
Includes SQLite storage, delete functionality, expense date tracking, and structured UI layout.

✨ Upcoming Features (v1.2 Roadmap)
🔐 User login (email/password)

📊 Weekly and monthly spending summaries

📈 Expense category breakdown (pie chart)

☁️ Firebase backup support

📤 Export to CSV or PDF

🙌 Developed by
Mayiel Raja Sundar Balamurugan
GitHub: @MayielRaja
