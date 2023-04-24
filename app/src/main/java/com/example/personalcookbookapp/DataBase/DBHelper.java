package com.example.personalcookbookapp.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "CookbookApp.db";

    public DBHelper(Context context) {
        super(context, DBNAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDataBase) {
        MyDataBase.execSQL("create Table users(username TEXT primary key, password TEXT)");
        MyDataBase.execSQL("create Table main_recipes_list(title TEXT primary key not null, " +
                "short_description TEXT not null, difficulty TEXT not null)");
        MyDataBase.execSQL("CREATE TABLE saved_recipes(username TEXT NOT NULL, title TEXT NOT NULL, PRIMARY KEY (username, title), FOREIGN KEY (username) REFERENCES users(username), FOREIGN KEY (title) REFERENCES main_recipes_list(title))");
    }

    public void addRecipes() {

        SQLiteDatabase MyDataBase = this.getWritableDatabase();

        Cursor cursor = MyDataBase.rawQuery("select * from main_recipes_list where title = ?", new String[] {"Cheesecake"});
        if (cursor.getCount() == 0) {
            ContentValues values1 = new ContentValues();
            values1.put("title", "Cheesecake");
            values1.put("short_description", "Indulge in creamy decadence with our irresistible cheesecake recipe. Each luscious bite is a heavenly blend of tangy sweetness and silky smoothness, making it the ultimate dessert for any occasion.");
            values1.put("difficulty", "easy");
            MyDataBase.insert("main_recipes_list", null, values1);
        }
        cursor.close();

        cursor = MyDataBase.rawQuery("select * from main_recipes_list where title = ?", new String[] {"Pasta Carbonara"});
        if (cursor.getCount() == 0) {
            ContentValues values2 = new ContentValues();
            values2.put("title", "Pasta Carbonara");
            values2.put("short_description", "Get ready to twirl your fork and savor every bite of our classic carbonara pasta. Our dish is a perfect balance of al dente noodles, creamy egg yolk, salty pancetta, and freshly grated parmesan cheese, making it a mouthwatering meal that's simply irresistible.");
            values2.put("difficulty", "medium");
            MyDataBase.insert("main_recipes_list", null, values2);
        }
        cursor.close();

        cursor = MyDataBase.rawQuery("select * from main_recipes_list where title = ?", new String[] {"Grilled Octopus"});
        if (cursor.getCount() == 0) {
            ContentValues values3 = new ContentValues();
            values3.put("title", "Grilled Octopus");
            values3.put("short_description", "Discover a taste of the sea with our succulent grilled octopus. Charred to perfection, our dish is a tantalizing blend of tender meat, smoky flavors, and zesty citrus, making it a show-stopping appetizer that will leave your taste buds craving for more.");
            values3.put("difficulty", "hard");
            MyDataBase.insert("main_recipes_list", null, values3);
        }
        cursor.close();

        cursor = MyDataBase.rawQuery("select * from main_recipes_list where title = ?", new String[] {"Polenta"});
        if (cursor.getCount() == 0) {
            ContentValues values4 = new ContentValues();
            values4.put("title", "Polenta");
            values4.put("short_description", "Take a trip to Italy with our creamy and comforting polenta. Our recipe is a mouthwatering blend of buttery cornmeal, rich parmesan cheese, and aromatic herbs, making it the perfect side dish for any hearty meal or a satisfying main dish on its own.");
            values4.put("difficulty", "easy");
            MyDataBase.insert("main_recipes_list", null, values4);
        }
        cursor.close();

        cursor = MyDataBase.rawQuery("select * from main_recipes_list where title = ?", new String[] {"Blueberry Scones"});
        if (cursor.getCount() == 0) {
            ContentValues values5 = new ContentValues();
            values5.put("title", "Blueberry Scones");
            values5.put("short_description", "Start your day with a burst of juicy sweetness with our heavenly blueberry scones. Crumbly and tender, each bite is a delightful blend of tangy berries, buttery goodness, and a hint of vanilla, making it the ultimate breakfast treat or afternoon snack.");
            values5.put("difficulty", "medium");
            MyDataBase.insert("main_recipes_list", null, values5);
        }
        cursor.close();

        cursor = MyDataBase.rawQuery("select * from main_recipes_list where title = ?", new String[] {"Habanero Skewers"});
        if (cursor.getCount() == 0) {
            ContentValues values6 = new ContentValues();
            values6.put("title", "Habanero Skewers");
            values6.put("short_description", "Spice up your summer with our mouthwatering mango habanero chicken skewers. Each tender bite is a tantalizing blend of sweet and spicy flavors, making it the perfect dish for any backyard barbecue.");
            values6.put("difficulty", "medium");
            MyDataBase.insert("main_recipes_list", null, values6);
        }
        cursor.close();

        cursor = MyDataBase.rawQuery("select * from main_recipes_list where title = ?", new String[] {"Balsamic Caprese"});
        if (cursor.getCount() == 0) {
            ContentValues values7 = new ContentValues();
            values7.put("title", "Balsamic Caprese");
            values7.put("short_description", "Fresh and flavorful, our caprese salad with balsamic glaze is a vibrant celebration of juicy tomatoes, creamy mozzarella, and aromatic basil. It's a refreshing side dish or a light meal on its own.");
            values7.put("difficulty", "easy");
            MyDataBase.insert("main_recipes_list", null, values7);
        }
        cursor.close();

        cursor = MyDataBase.rawQuery("select * from main_recipes_list where title = ?", new String[] {"Beef Broccoli"});
        if (cursor.getCount() == 0) {
            ContentValues values8 = new ContentValues();
            values8.put("title", "Beef Broccoli");
            values8.put("short_description", "Satisfy your cravings with our savory beef and broccoli stir-fry. Tender strips of beef, crisp broccoli florets, and a savory sauce come together in a deliciously quick and easy meal.");
            values8.put("difficulty", "easy");
            MyDataBase.insert("main_recipes_list", null, values8);
        }
        cursor.close();

        cursor = MyDataBase.rawQuery("select * from main_recipes_list where title = ?", new String[] {"Chocolate Smoothie"});
        if (cursor.getCount() == 0) {
            ContentValues values9 = new ContentValues();
            values9.put("title", "Chocolate Smoothie");
            values9.put("short_description", "Indulge your sweet tooth with our decadent chocolate peanut butter banana smoothie. It's a rich and creamy blend of cocoa, peanut butter, banana, and almond milk that's sure to satisfy your cravings.");
            values9.put("difficulty", "easy");
            MyDataBase.insert("main_recipes_list", null, values9);
        }
        cursor.close();

        cursor = MyDataBase.rawQuery("select * from main_recipes_list where title = ?", new String[] {"Lemon Shrimp"});
        if (cursor.getCount() == 0) {
            ContentValues values10 = new ContentValues();
            values10.put("title", "Lemon Shrimp");
            values10.put("short_description", "Our lemon garlic shrimp scampi is a burst of flavor in every bite. Juicy shrimp, al dente pasta, and a zesty garlic sauce create a dish that's light, refreshing, and deliciously satisfying.");
            values10.put("difficulty", "medium");
            MyDataBase.insert("main_recipes_list", null, values10);
        }
        cursor.close();

        cursor = MyDataBase.rawQuery("select * from main_recipes_list where title = ?", new String[] {"Spinach Chicken"});
        if (cursor.getCount() == 0) {
            ContentValues values11 = new ContentValues();
            values11.put("title", "Spinach Chicken");
            values11.put("short_description", "Elevate your dinner game with our spinach and feta stuffed chicken breast. Tender and juicy chicken, stuffed with creamy spinach and tangy feta, is a flavor explosion that's sure to impress.");
            values11.put("difficulty", "medium");
            MyDataBase.insert("main_recipes_list", null, values11);
        }
        cursor.close();

        cursor = MyDataBase.rawQuery("select * from main_recipes_list where title = ?", new String[] {"Quinoa Chili"});
        if (cursor.getCount() == 0) {
            ContentValues values12 = new ContentValues();
            values12.put("title", "Quinoa Chili");
            values12.put("short_description", "Our vegetarian quinoa chili is a hearty and nutritious meal that's bursting with flavor. It's a delicious blend of quinoa, beans, vegetables, and warming spices that's perfect for a chilly evening.");
            values12.put("difficulty", "easy");
            MyDataBase.insert("main_recipes_list", null, values12);
        }
        cursor.close();

        cursor = MyDataBase.rawQuery("select * from main_recipes_list where title = ?", new String[] {"Raspberry Cheesecake Bars"});
        if (cursor.getCount() == 0) {
            ContentValues values13 = new ContentValues();
            values13.put("title", "Raspberry Cheesecake Bars");
            values13.put("short_description", "Treat yourself to our indulgent raspberry white chocolate cheesecake bars. Each bite is a luscious blend of creamy cheesecake, tangy raspberries, and sweet white chocolate, making it a dessert that's sure to impress.");
            values13.put("difficulty", "hard");
            MyDataBase.insert("main_recipes_list", null, values13);
        }
        cursor.close();

        cursor = MyDataBase.rawQuery("select * from main_recipes_list where title = ?", new String[] {"Mushroom Pizza"});
        if (cursor.getCount() == 0) {
            ContentValues values14 = new ContentValues();
            values14.put("title", "Mushroom Pizza");
            values14.put("short_description", "Our caramelized onion and mushroom pizza is a vegetarian delight. Topped with sautéed mushrooms, sweet caramelized onions, and gooey mozzarella cheese, it's a pizza that's full of flavor and texture.");
            values14.put("difficulty", "medium");
            MyDataBase.insert("main_recipes_list", null, values14);
        }
        cursor.close();

        cursor = MyDataBase.rawQuery("select * from main_recipes_list where title = ?", new String[] {"Peach & Burrata Salad"});
        if (cursor.getCount() == 0) {
            ContentValues values15 = new ContentValues();
            values15.put("title", "Peach & Burrata Salad");
            values15.put("short_description", "Celebrate summer with our grilled peach and burrata salad. The sweet, smoky flavors of grilled peaches pair perfectly with creamy burrata cheese, arugula, and a tangy balsamic dressing for a salad that's fresh and delicious.");
            values15.put("difficulty", "easy");
            MyDataBase.insert("main_recipes_list", null, values15);
        }
        cursor.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDataBase, int i, int i1) {
        MyDataBase.execSQL("drop Table if exists users");
        MyDataBase.execSQL("drop Table if exists main_recipes_list");
        MyDataBase.execSQL("drop Table if exists saved_recipes");
    }

    public Cursor getRecipesData() {
        SQLiteDatabase MyDataBase = this.getWritableDatabase();

        return MyDataBase.rawQuery("select * from main_recipes_list", null);
    }

    public boolean saveRecipe(String username, String title) {
        SQLiteDatabase MyDataBase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("username", username);
        contentValues.put("title", title);

        long result = MyDataBase.insert("saved_recipes", null, contentValues);

        return result != -1;
    }

    public boolean removeSavedRecipe(String username, String title) {
        SQLiteDatabase MyDataBase = this.getWritableDatabase();
        Cursor cursor = MyDataBase.rawQuery("select * from saved_recipes where username = ? and title = ?", new String[] {username, title});

        if (cursor.getCount() > 0) {
            MyDataBase.delete("saved_recipes", "username = ? and title = ?", new String[] {username, title});
            cursor.close();
            return true;
        } else {
            cursor.close();
            return false;
        }
    }

    public Cursor getSavedRecipes(String username) {
        SQLiteDatabase MyDataBase = this.getWritableDatabase();

        return MyDataBase.rawQuery("select * from saved_recipes where username = ?", new String[] {username});
    }

    public boolean insertData(String username, String password) {
        SQLiteDatabase MyDataBase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("username", username);
        contentValues.put("password", password);

        long result = MyDataBase.insert("users", null, contentValues);

        return result != -1;
    }

    public boolean checkUsername(String username) {
        SQLiteDatabase MyDataBase = this.getWritableDatabase();
        Cursor cursor = MyDataBase.rawQuery("select * from users where username = ?", new String[] {username});

        if (cursor.getCount() > 0) {
            return true;
        }

        cursor.close();

        return false;
    }

    public boolean checkUsernamePassword(String username, String password) {
        SQLiteDatabase MyDataBase = this.getWritableDatabase();
        Cursor cursor = MyDataBase.rawQuery("select * from users where username = ? and password = ?", new String[] {username, password});

        if (cursor.getCount() > 0) {
            return true;
        }

        cursor.close();

        return false;
    }

    public Cursor searchRecipes(String query) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] args = new String[]{"%" + query.toLowerCase() + "%"};
        return db.rawQuery("select * from main_recipes_list where lower(title) like ?", args);
    }
}
