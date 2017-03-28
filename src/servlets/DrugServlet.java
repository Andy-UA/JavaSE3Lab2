package servlets;

import com.google.gson.Gson;
import entities.DrugsEntity;
import services.DrugService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

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
            case "getAll": {
                List<DrugsEntity> de = new DrugService().getAll();
                String result = "[";
                for (int i = 0; i < de.size(); i++) {
                    if (i != 0) {
                        result += ",";
                    }
                    result += gson.toJson(de.get(i));
                }
                result += "]";
                response.getWriter().write(result);
                break;
            }
            case"find": {
                long id = Long.parseLong(request.getParameter("id"));
                DrugsEntity de = new DrugService().get(id);
                String result = gson.toJson(de);
                response.getWriter().write(result);
                break;
            }
        }
    }
}
