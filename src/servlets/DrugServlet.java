package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.google.gson.*;
import entities.DrugsEntity;
import services.DrugService;

/**
 * Created by Andrew on 28.03.2017.
 */

public class DrugServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        Gson gson = new Gson();

        switch (request.getParameter("action")){
            case "getAll":
                List<DrugsEntity> de = new DrugService().getAll();
                String result = null;
                for(int i = 0; i < de.size();i++)
                    result += gson.toJson(de.get(i));
                response.getWriter().write(result);
                break;

        }
    }
}
