package com.egsystem.unikosheba.data.database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.egsystem.unikosheba.cart.CartModel;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    // DB Info
    private static final int DATABASE_VERSION = 3; // version increased (important)
    private static final String DATABASE_NAME = "uniko_db1.db";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Create Table
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CartModel.CREATE_TABLE);
    }

    // Upgrade DB
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + CartModel.TABLE_NAME);
        onCreate(db);
    }

    // INSERT
    public long insertCartModel(String category_name,
                                String sub_category_name,
                                String service_id,
                                String service_name,
                                String price,
                                String discount,
                                String quantity,
                                String img_link) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(CartModel.CATEGORY_NAME, category_name);
        values.put(CartModel.SUB_CATEGORY_NAME, sub_category_name);
        values.put(CartModel.SERVICE_ID, service_id);
        values.put(CartModel.SERVICE_NAME, service_name);
        values.put(CartModel.PRICE, price);
        values.put(CartModel.DISCOUNT, discount);
        values.put(CartModel.QUANTITY, quantity);
        values.put(CartModel.IMG_LINK, img_link);

        long id = db.insert(CartModel.TABLE_NAME, null, values);

        db.close();
        return id;
    }

    // GET SINGLE ITEM
    public CartModel getCartModel(long id) {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(
                CartModel.TABLE_NAME,
                null,
                CartModel.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)},
                null, null, null
        );

        if (cursor != null && cursor.moveToFirst()) {

            CartModel cartModel = new CartModel(
                    cursor.getInt(cursor.getColumnIndexOrThrow(CartModel.COLUMN_ID)),
                    cursor.getString(cursor.getColumnIndexOrThrow(CartModel.CATEGORY_NAME)),
                    cursor.getString(cursor.getColumnIndexOrThrow(CartModel.SUB_CATEGORY_NAME)),
                    cursor.getString(cursor.getColumnIndexOrThrow(CartModel.SERVICE_ID)),
                    cursor.getString(cursor.getColumnIndexOrThrow(CartModel.SERVICE_NAME)),
                    cursor.getString(cursor.getColumnIndexOrThrow(CartModel.PRICE)),
                    cursor.getString(cursor.getColumnIndexOrThrow(CartModel.DISCOUNT)),
                    cursor.getString(cursor.getColumnIndexOrThrow(CartModel.QUANTITY)),
                    cursor.getString(cursor.getColumnIndexOrThrow(CartModel.IMG_LINK))
            );

            cursor.close();
            return cartModel;
        }

        return null;
    }

    // GET ALL
    public List<CartModel> getAllCartModels() {

        List<CartModel> cartModels = new ArrayList<>();

        String query = "SELECT * FROM " + CartModel.TABLE_NAME +
                " ORDER BY " + CartModel.COLUMN_ID + " DESC";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                CartModel cartModel = new CartModel();

                cartModel.setId(cursor.getInt(cursor.getColumnIndexOrThrow(CartModel.COLUMN_ID)));
                cartModel.setCategory_name(cursor.getString(cursor.getColumnIndexOrThrow(CartModel.CATEGORY_NAME)));
                cartModel.setSub_category_name(cursor.getString(cursor.getColumnIndexOrThrow(CartModel.SUB_CATEGORY_NAME)));
                cartModel.setService_id(cursor.getString(cursor.getColumnIndexOrThrow(CartModel.SERVICE_ID)));
                cartModel.setService_name(cursor.getString(cursor.getColumnIndexOrThrow(CartModel.SERVICE_NAME)));
                cartModel.setPrice(cursor.getString(cursor.getColumnIndexOrThrow(CartModel.PRICE)));
                cartModel.setDiscount(cursor.getString(cursor.getColumnIndexOrThrow(CartModel.DISCOUNT)));
                cartModel.setQuantity(cursor.getString(cursor.getColumnIndexOrThrow(CartModel.QUANTITY)));
                cartModel.setImg_link(cursor.getString(cursor.getColumnIndexOrThrow(CartModel.IMG_LINK)));

                cartModels.add(cartModel);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return cartModels;
    }

    // COUNT
    public int getCartModelsCount() {

        String countQuery = "SELECT COUNT(*) FROM " + CartModel.TABLE_NAME;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = 0;

        if (cursor.moveToFirst()) {
            count = cursor.getInt(0);
        }

        cursor.close();
        return count;
    }

    // UPDATE
    public int updateCartModel(CartModel cartModel) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(CartModel.CATEGORY_NAME, cartModel.getCategory_name());
        values.put(CartModel.SUB_CATEGORY_NAME, cartModel.getSub_category_name()); // FIXED
        values.put(CartModel.SERVICE_ID, cartModel.getService_id());
        values.put(CartModel.SERVICE_NAME, cartModel.getService_name());
        values.put(CartModel.PRICE, cartModel.getPrice());
        values.put(CartModel.DISCOUNT, cartModel.getDiscount());
        values.put(CartModel.QUANTITY, cartModel.getQuantity());
        values.put(CartModel.IMG_LINK, cartModel.getImg_link());

        int rows = db.update(
                CartModel.TABLE_NAME,
                values,
                CartModel.COLUMN_ID + "=?",
                new String[]{String.valueOf(cartModel.getId())}
        );

        db.close();
        return rows;
    }


    public void updateCartQuantity(int id, int quantity) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("quantity", quantity);

        db.update(CartModel.TABLE_NAME, values, "id=?", new String[]{String.valueOf(id)});
    }



    // DELETE BY ID (SAFE)
    public void deleteCartModel(CartModel cartModel) {

        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(
                CartModel.TABLE_NAME,
                CartModel.COLUMN_ID + "=?",
                new String[]{String.valueOf(cartModel.getId())}
        );

        db.close();
    }

    // OPTIONAL: DELETE ALL
    public void clearCart() {

//        SQLiteDatabase db = this.getWritableDatabase();
//        db.execSQL("DELETE FROM " + CartModel.TABLE_NAME);
//        db.close();


        SQLiteDatabase db = this.getWritableDatabase();

        // Check if table exists first
        Cursor cursorCheck = db.rawQuery(
                "SELECT name FROM sqlite_master WHERE type='table' AND name=?",
                new String[]{CartModel.TABLE_NAME}
        );
        boolean tableExists = cursorCheck.getCount() > 0;
        cursorCheck.close();

        if (tableExists) {
            db.execSQL("DELETE FROM " + CartModel.TABLE_NAME);
        }

        db.close();


    }




    public boolean isItemExists(String service_id) {
        SQLiteDatabase db = this.getReadableDatabase();

        // Check if the table exists first
        Cursor cursorCheck = db.rawQuery(
                "SELECT name FROM sqlite_master WHERE type='table' AND name=?",
                new String[]{CartModel.TABLE_NAME}
        );

        boolean tableExists = cursorCheck.getCount() > 0;
        cursorCheck.close();

        if (!tableExists) {
            return false; // table not created yet, so item definitely does not exist
        }

        // Table exists, now check if the item exists
        Cursor cursor = db.query(
                CartModel.TABLE_NAME,
                new String[]{CartModel.COLUMN_ID}, // only need ID, more efficient
                CartModel.SERVICE_ID + "=?",
                new String[]{service_id},
                null, null, null
        );

        boolean exists = cursor.moveToFirst(); // true if at least 1 row found
        cursor.close();

        return exists;
    }


    public boolean isCartTableEmpty() {

        SQLiteDatabase db = this.getReadableDatabase();

        // Step 1: Check if table exists
        Cursor cursorCheck = db.rawQuery(
                "SELECT name FROM sqlite_master WHERE type='table' AND name=?",
                new String[]{CartModel.TABLE_NAME}
        );
        boolean tableExists = cursorCheck.getCount() > 0;
        cursorCheck.close();

        if (!tableExists) {
            return true; // if table doesn't exist, consider it empty
        }

        // Step 2: Table exists, check row count
        Cursor cursor = db.rawQuery("SELECT COUNT(*) FROM " + CartModel.TABLE_NAME, null);
        boolean empty = true;
        if (cursor.moveToFirst()) {
            empty = cursor.getInt(0) == 0; // true if 0 rows
        }
        cursor.close();

        return empty;


    }



    public int getTotalPrice() {

        // If table doesn't exist → total = 0
        if (!isCartTableEmpty()) return 0;

        SQLiteDatabase db = this.getReadableDatabase();

        int total = 0;

        Cursor cursor = db.rawQuery(
                "SELECT " + CartModel.PRICE + " FROM " + CartModel.TABLE_NAME,
                null
        );

        if (cursor.moveToFirst()) {
            do {
                String priceStr = cursor.getString(0);

                if (priceStr != null && !priceStr.isEmpty()) {
                    try {
                        total += Integer.parseInt(priceStr);
                    } catch (Exception e) {
                        e.printStackTrace(); // skip invalid price
                    }
                }

            } while (cursor.moveToNext());
        }

        cursor.close();
        return total;
    }




}



//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//
//
//import com.egsystem.unikosheba.cart.CartModel;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class DatabaseHelper extends SQLiteOpenHelper {
//
//    // Database Version
//    private static final int DATABASE_VERSION = 1;
//    // Database Name
//    private static final String DATABASE_NAME = "uniko_db1.db";
//
//
//    public DatabaseHelper(Context context) {
//        super(context, DATABASE_NAME, null, DATABASE_VERSION);
//    }
//
//    // Creating Tables
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        // create cartModels table
//        db.execSQL(CartModel.CREATE_TABLE);
//    }
//
//    // Upgrading database
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        // Drop older table if existed
//        db.execSQL("DROP TABLE IF EXISTS " + CartModel.TABLE_NAME);
//        // Create tables again
//        onCreate(db);
//    }
//
//    public long insertCartModel(String category_name, String sub_category_name, String service_id, String img_link) {
//        // get writable database as we want to write data
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        // `id` will be inserted automatically, no need to add id
//        values.put(CartModel.CATEGORY_NAME, category_name);
//        values.put(CartModel.SUB_CATEGORY_NAME, sub_category_name);
//        values.put(CartModel.SERVICE_ID, service_id);
//        values.put(CartModel.IMG_LINK, img_link);
//        // insert row
//        long id = db.insert(CartModel.TABLE_NAME, null, values);
//        // close db connection
//        db.close();
//
//        // return newly inserted row id
//        return id;
//    }
//
//    public CartModel getCartModel(long id) {
//        // get readable database as we are not inserting anything
//        SQLiteDatabase db = this.getReadableDatabase();
//
//        Cursor cursor = db.query(CartModel.TABLE_NAME,
//                new String[]{CartModel.COLUMN_ID, CartModel.CATEGORY_NAME, CartModel.SUB_CATEGORY_NAME,
//                        CartModel.SERVICE_ID, CartModel.IMG_LINK},
//                CartModel.COLUMN_ID + "=?",
//                new String[]{String.valueOf(id)}, null, null, null, null);
//
//        if (cursor != null)
//            cursor.moveToFirst();
//
//        // prepare cartModel object
//        @SuppressLint("Range") CartModel cartModel = new CartModel(
//                cursor.getInt(cursor.getColumnIndex(CartModel.COLUMN_ID)),
//                cursor.getString(cursor.getColumnIndex(CartModel.CATEGORY_NAME)),
//                cursor.getString(cursor.getColumnIndex(CartModel.SUB_CATEGORY_NAME)),
//                cursor.getString(cursor.getColumnIndex(CartModel.SERVICE_ID)),
//                cursor.getString(cursor.getColumnIndex(CartModel.IMG_LINK)));
//
//        // close the db connection
//        cursor.close();
//
//        return cartModel;
//    }
//
//    @SuppressLint("Range")
//    public List<CartModel> getAllCartModels() {
//        List<CartModel> cartModels = new ArrayList<>();
//
//        // Select All Query
//        String selectQuery = "SELECT  * FROM " + CartModel.TABLE_NAME + " ORDER BY " +
//                CartModel.COLUMN_ID + " DESC";
//
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery(selectQuery, null);
//
//        // looping through all rows and adding to list
//        if (cursor.moveToFirst()) {
//            do {
//                CartModel cartModel = new CartModel();
//                cartModel.setId(cursor.getInt(cursor.getColumnIndex(CartModel.COLUMN_ID)));
//                cartModel.setCategory_name(cursor.getString(cursor.getColumnIndex(CartModel.CATEGORY_NAME)));
//                cartModel.setSub_category_name(cursor.getString(cursor.getColumnIndex(CartModel.SUB_CATEGORY_NAME)));
//                cartModel.setSub_category_id(cursor.getString(cursor.getColumnIndex(CartModel.SERVICE_ID)));
//                cartModel.setImg_link(cursor.getString(cursor.getColumnIndex(CartModel.IMG_LINK)));
//
//
//                cartModels.add(cartModel);
//            } while (cursor.moveToNext());
//        }
//
//        // close db connection
//        db.close();
//
//        // return cartModels list
//        return cartModels;
//    }
//
//    public int getCartModelsCount() {
//        String countQuery = "SELECT  * FROM " + CartModel.TABLE_NAME;
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery(countQuery, null);
//
//        int count = cursor.getCount();
//        cursor.close();
//
//
//        // return count
//        return count;
//    }
//
//    public int updateCartModel(CartModel cartModel) {
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//        values.put(CartModel.CATEGORY_NAME, cartModel.getCategory_name());
//        values.put(CartModel.SUB_CATEGORY_NAME, cartModel.getSub_category_id());
//        values.put(CartModel.SERVICE_ID, cartModel.getSub_category_id());
//        values.put(CartModel.IMG_LINK, cartModel.getImg_link());
//
//
//        // updating row
//        return db.update(CartModel.TABLE_NAME, values, CartModel.COLUMN_ID + " = ?",
//                new String[]{String.valueOf(cartModel.getId())});
//    }
//
////    public void deleteCartModel(CartModel cartModel) {
////        SQLiteDatabase db = this.getWritableDatabase();
////        db.delete(CartModel.TABLE_NAME, CartModel.COLUMN_ID + " = ?",
////                new String[]{String.valueOf(cartModel.getId())});
////        db.close();
////    }
//      public void deleteCartModel(CartModel cartModel) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        db.delete(CartModel.TABLE_NAME, CartModel.SERVICE_ID + " = ?",
//                new String[]{String.valueOf(cartModel.getSub_category_id())});
//        db.close();
//    }
//
//
//
//}