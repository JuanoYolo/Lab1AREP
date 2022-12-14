package co.edu.escuelaing.stockwebapp;

import static spark.Spark.*;

public class StockWebApp {
    public static void main(String[] args) {
        port(getPort());
        staticFiles.location("/public");
        get("/hello", (req, res) -> "Hello heroku" + req.queryParams("name"));

        get("/stock", (req, res) -> {
            res.type("application/json");
            return HttpConnectionExample.getStock(req.queryParams("name"));
        });


    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set(i.e. on localhost)

    }
}