package com.paltvlad.hibernate.h2;

public class MainApp {


    public static void main(String[] args) {

        SessionFactoryUtils sfu = new SessionFactoryUtils();
        sfu.init();

        try {
            ProductDao productDao = new ProductDaoImpl(sfu);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            sfu.shutdown();
        }
    }
}