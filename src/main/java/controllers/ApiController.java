package controllers;

import model.Announcement;
import model.Checklist;
import model.Task;
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
                "Asado Incuba", false, true, false);
        Announcement announcement2 = new Announcement(2, 12, 2, new int[] { 45, 3, 8}, aux,
                "No se olviden de justificar remesas", false, false, false);
        Announcement announcement3 = new Announcement(3, 4, null, new int[] {}, aux,
                "Mensaje de emprendedor", true, false, true);
        JsonArray ret = new JsonArray();
        JsonParser parser = new JsonParser();
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        String str1 = gson.toJson(announcement1, Announcement.class);
        String str2 = gson.toJson(announcement2, Announcement.class);
        String str3 = gson.toJson(announcement3, Announcement.class);
        ret.add(parser.parse(str1));
        ret.add(parser.parse(str2));
        ret.add(parser.parse(str3));
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
            User userAux = new User("aneyem@uc.cl", "aneyem");
            if(!user.getUsername().equals(userAux.getUsername())){
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
        Task t1 = new Task(1, 2, aux, aux, aux, aux, "La remesa 3 tuvo algunos problemas de justificación, ruego ver los adjuntos!", 
            "Dominio 1", "Justificar Remesa #3", "some privacy", "some status", "Remesas");
        Task t2 = new Task(1, 2, aux, aux, aux, aux, "Será a las 8:30 en las oficinas de Incuba. Lleguen con tiempo para tener cuidado con el taco!",
            "Dominio 2", "No se olviden reunión martes 23/04!", "some privacy", "some status", "Reuniones");
        Task t3 = new Task(1, 2, aux, aux, aux, aux, "Los datos actuales no están al día. Debemos mostrar el crecimiento de los últimos meses", 
            "Dominio 3", "Subir últimos datos de ventas", "some privacy", "some status", "Dashboard");
        Task t4 = new Task(1, 2, aux, aux, aux, aux, "Falta subir las últimas boletas, no se olviden de sacarle foto y todo", 
            "Dominio 4", "Ver tema boletas diciembre", "some privacy", "some status", "Boletas");
        Task t5 = new Task(1, 2, aux, aux, aux, aux, "Tarea 5", "Está todo súper sucio, se huele hasta la calle", 
            "Lavar la ropa", "some privacy", "some status", "Random");

        JsonArray ret = new JsonArray();
        JsonParser parser = new JsonParser();
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        String str1 = gson.toJson(t1, Task.class);
        String str2 = gson.toJson(t2, Task.class);
        String str3 = gson.toJson(t3, Task.class);
        String str4 = gson.toJson(t4, Task.class);
        String str5 = gson.toJson(t5, Task.class);
        ret.add(parser.parse(str1));
        ret.add(parser.parse(str2));
        ret.add(parser.parse(str3));
        ret.add(parser.parse(str4));
        ret.add(parser.parse(str5));
        response.body(ret.toString());
        return response;
    }
}
