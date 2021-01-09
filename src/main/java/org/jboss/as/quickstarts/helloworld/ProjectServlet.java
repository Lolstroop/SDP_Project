package org.jboss.as.quickstarts.helloworld;

import Armazem.Armazem;
import org.jboss.errai.codegen.builder.ClassStructureBuilder;
import org.jboss.errai.marshalling.rebind.api.ObjectMapper;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Provider;
import java.util.List;

import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.inject.Inject;


@WebServlet("/ServiceArmazem")
public class ProjectServlet extends HttpServlet {

    @Inject
    ServiceArmazem item;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        ObjectMapper mapper = new ObjectMapper() {
            @Override
            public ClassStructureBuilder<?> getMarshaller(String s) {
                return null;
            }
        };

        String itemid = req.getParameter("id");
        String jsonString = "";

        if(itemid != null) {
            Armazem item = Long.valueOf(ServiceArmazem.getProduto(Integer.parseInt(itemid)));
            jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(item);
        } else {
            List<Armazem> items = ServiceArmazem.getProdutos();
            jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(items);
        }
        out.print(jsonString);
        out.flush();


        /*
        //Tradução para JSON
        JsonObjectBuilder jsonBuilder = Json.createObjectBuilder();
        jsonBuilder.add("nome", item.getProduto(1));

        //Escrita da representação JSON na resposta
        JsonWriter jsonWriter = Json.createWriter(resp.getWriter());
        jsonWriter.writeObject(jsonBuilder.build());
        jsonWriter.close();
         */
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }



}
