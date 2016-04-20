package controllers;

import model.Announcement;
import model.Checklist;
import model.User;
import com.google.gson.*;
import spark.Request;
import spark.Response;

import java.sql.Timestamp;

/**
 * Created by Santiago Martí Olbrich (samarti@uc.cl) on 4/18/16.
 * Resit SpA.
 * All rights reserved
 */
public class ApiController {

    public static Response getAnnouncements(Request request, Response response){
        Timestamp aux = new Timestamp(System.currentTimeMillis());
        Announcement announcement1 = new Announcement(1, 23, 3, new int[] { 56, 34, 89}, aux,
                "Asado Incuba", false, false);
        Announcement announcement2 = new Announcement(2, 12, 2, new int[] { 45, 3, 8}, aux,
                "No se olviden de justificar remesas", true, false);
        JsonArray ret = new JsonArray();
        JsonParser parser = new JsonParser();
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        String str1 = gson.toJson(announcement1, Announcement.class);
        String str2 = gson.toJson(announcement2, Announcement.class);
        ret.add(parser.parse(str1));
        ret.add(parser.parse(str2));
        response.body(ret.toString());
        return response;
    }

    public static Response getChecklist(Request request, Response response){
        Timestamp aux = new Timestamp(System.currentTimeMillis());
        Checklist checklist = new Checklist(1, 2, 3, 4, "somePrivacy", aux);
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        String str1 = gson.toJson(checklist, Checklist.class);
        response.body(str1);
        return response;
    }

    public static Response login(Request request, Response response){
        User user = new Gson().fromJson(request.body(), User.class);
        JsonObject ret = new JsonObject();
        try {
            if(user == null){
                ret.addProperty("Succes", false);
                ret.addProperty("Error", "Missing fields");
                throw new Exception();
            }
            User userAux = new User(1, "1234");
            if(user.getId() != userAux.getId()){
                ret.addProperty("Error", "User not found");
                throw new Exception();
            }
            if(user.getPassword().equals(userAux.getPassword())){
                ret.addProperty("Success", true);
                ret.addProperty("token", "D!I·DA)?SJDAS?D");
            } else {
                ret.addProperty("Error", "Wrong password");
                throw new Exception();
            }
            response.body(ret.toString());
        } catch(Exception e){
            ret.addProperty("Success", false);
        } finally {
            response.body(ret.toString());
            return response;
        }
    }

    public static Response getTasks(Request request, Response response) {
        Timestamp aux = new Timestamp(System.currentTimeMillis());
        Announcement announcement1 = new Announcement(1, 23, 3, new int[] { 56, 34, 89}, aux,
                "Asado Incuba", false, false);
        Announcement announcement2 = new Announcement(2, 12, 2, new int[] { 45, 3, 8}, aux,
                "No se olviden de justificar remesas", true, false);
        JsonArray ret = new JsonArray();
        JsonParser parser = new JsonParser();
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        String str1 = gson.toJson(announcement1, Announcement.class);
        String str2 = gson.toJson(announcement2, Announcement.class);
        ret.add(parser.parse(str1));
        ret.add(parser.parse(str2));
        response.body(ret.toString());
        return response;
    }
}
