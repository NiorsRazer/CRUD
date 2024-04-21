import java.io.*;
import java.sql.PreparedStatement;

import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Date;

import con.Con;
import util.Class_Job;

public class Delete_Job extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        int id = Integer.parseInt(req.getParameter("id"));
        try {
            // Etablir la connexion a la base de donnees
            Con connection = new Con();

            // Preparer la requete SQL INSERT INTO
            String sql = "DELETE FROM type_job where id_type_job ="+id;
            PreparedStatement statement = connection.getConnection().prepareStatement(sql);
            
            // Executer la requete SQL
            int rowsInserted = statement.executeUpdate();

            // Fermer la connexion et le statement
            statement.close();
            connection.getConnection().close();

            if (rowsInserted > 0) {
                // L'utilisateur a ete insere avec succes, vous pouvez rediriger l'utilisateur vers une page de confirmation
                res.sendRedirect("/Crud/list_job");
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
