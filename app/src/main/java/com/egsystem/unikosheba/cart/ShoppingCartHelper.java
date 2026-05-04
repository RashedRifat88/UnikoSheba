package com.egsystem.unikosheba.cart;

import android.content.res.Resources;
import android.util.Log;

import com.egsystem.unikosheba.R;



import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ShoppingCartHelper {

    public static final String PRODUCT_INDEX = "PRODUCT_INDEX";

    private static List<Service> catalog;
    private static List<Service> cart;

    public static List<Service> getCatalog(Resources res) {
//        if (catalog == null) {
//            catalog = new Vector<Service>();
//            catalog.add(new Service("Transformer New Installation", res.getDrawable(R.drawable.freeze1),
//                    "Transformer New Installation...Transformer New Installation...Transformer New Installation...Transformer New Installation...", 29.99));
//
//            catalog.add(new Service("Transformer New Installation", res.getDrawable(R.drawable.freeze1),
//                    "Transformer New Installation...Transformer New Installation...Transformer New Installation...Transformer New Installation...", 29.99));
//
////            catalog.add(new Service("Transformer Re-installation", res.getDrawable(R.drawable.freeze1),
////                    "Transformer Re-installation...Transformer Re-installation...Transformer Re-installation...Transformer Re-installation...", 24.99));
////
////            catalog.add(new Service("Transformer Oil Level Check", res.getDrawable(R.drawable.freeze1),
////                    "Transformer Oil Level Check.....Transformer Oil Level Check.....Transformer Oil Level Check.....Transformer Oil Level Check.....", 14.99));
////
////             catalog.add(new Service("Transformer Oil Fill Up", res.getDrawable(R.drawable.freeze1),
////                    "Transformer Oil Fill Up.....Transformer Oil Fill Up.....Transformer Oil Fill Up.....Transformer Oil Fill Up.....", 14.99));
////
////             catalog.add(new Service("Transformer Continuity Check Up", res.getDrawable(R.drawable.freeze1),
////                    "Transformer Continuity Check Up....Transformer Continuity Check Up....Transformer Continuity Check Up....Transformer Continuity Check Up.....", 14.99));
////
////             catalog.add(new Service("Transformer Insulation Check Up", res.getDrawable(R.drawable.freeze1),
////                    "Transformer Insulation Check Up....Transformer Insulation Check Up....Transformer Insulation Check Up....Transformer Insulation Check Up.....", 14.99));
////
////             catalog.add(new Service("Transformer Oil Leakage Check Up", res.getDrawable(R.drawable.freeze1),
////                    "Transformer Oil Leakage Check Up....Transformer Oil Leakage Check Up....Transformer Oil Leakage Check Up....Transformer Oil Leakage Check Up.....", 14.99));
////            catalog.add(new Service("Transformer Continuity Check Up", res.getDrawable(R.drawable.freeze1),
////                    "Transformer Continuity Check Up....Transformer Continuity Check Up....Transformer Continuity Check Up....Transformer Continuity Check Up.....", 14.99));
//
//        }

        Log.d("catalog", "catalog: "+catalog);

        return catalog;
    }


    public static void setCatalog(Resources res, int length, String title, String imgLink, String description){
        if (catalog == null) {
//            catalog = new Vector<Service>();
            catalog = new ArrayList<>();

            for ( int i = 0; i<length; i++){
                catalog.add(new Service(title, res.getDrawable(R.drawable.ic_cart2), description, 29.00));
                Log.d("catalog", "catalog 0: "+catalog);
            }

//            catalog.add(new Service(title, res.getDrawable(R.drawable.freeze1), description, 29.00));
//            Log.d("catalog", "catalog 0: "+catalog);

        }

    }



    public static List<Service> getCart() {
        if (cart == null) {
            cart = new Vector<Service>();
        }

        return cart;
    }

}