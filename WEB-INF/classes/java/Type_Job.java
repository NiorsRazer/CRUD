import java.io.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.*;
import javax.servlet.http.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import con.Con;
import util.Class_Job;

public class Type_Job extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            // Etablir la connexion a la base de donnees
            Con connection = new Con();

            // Preparer la requete SQL INSERT INTO
            String sql = "SELECT * FROM type_job";
            PreparedStatement statement = connection.getConnection().prepareStatement(sql);
            
            // Executer la requete SQL
            ResultSet result = statement.executeQuery();
            List<Class_Job> list = new ArrayList<Class_Job>();
            while (result.next()) {
                Class_Job job = new Class_Job(
                    result.getInt("id_type_job"),
                    result.getString("nom"));
                list.add(job);
            }
            req.setAttribute("list", list);

            if (result != null) {
                // L'utilisateur a ete insere avec succes, vous pouvez rediriger l'utilisateur vers une page de confirmation
                RequestDispatcher dispat = req.getRequestDispatcher("/remove_job.jsp");
                dispat.forward(req,res);
            } else {
                // L'insertion a echoue, renvoyer un message d'erreur
                res.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Impossible de creer un nouvel utilisateur.");
            }
            // Fermer la connexion et le statement
            statement.close();
            connection.getConnection().close();
        } 
        catch (Exception e) {
            // Gerer les exceptions SQLException
            e.printStackTrace(); // Affiche l'erreur dans la console du serveur
            res.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}