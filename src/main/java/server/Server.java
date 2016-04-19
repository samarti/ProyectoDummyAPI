package server;

import controllers.ApiController;

import static spark.Spark.*;

/**
 * Created by Santiago Martí Olbrich (samarti@uc.cl) on 4/18/16.
 * Resit SpA.
 * All rights reserved
 */
public class Server {

    public static void main(String[] args) {

        get("/", (request, response) -> "IncubApi");

        get("/announcements", (request, response) -> ApiController.getAnnouncements(request, response).body());

        post("/login", (request, response) -> ApiController.getUser(request, response).body());

    }
}
