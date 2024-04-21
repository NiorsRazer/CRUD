import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Date;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import con.Con;

public class Addjob extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recuperer les parametres du formulaire HTML
        String nom = request.getParameter("nom");

        // Verifier si les parametres sont presents et non vides
        if (nom != null && !nom.isEmpty()) {
            try {
                // Etablir la connexion a la base de donnees
                Con connection = new Con();

                // Preparer la requete SQL INSERT INTO
                String sql = "INSERT INTO type_job (nom) VALUES (?)";
                PreparedStatement statement = connection.getConnection().prepareStatement(sql);
                statement.setString(1, nom);

                // Executer la requete SQL
                int rowsInserted = statement.executeUpdate();

                // Fermer la connexion et le statement
                statement.close();
                connection.getConnection().close();

                // Verifier si l'insertion a reussi
                if (rowsInserted > 0) {
                    // L'utilisateur a ete insere avec succes, vous pouvez rediriger l'utilisateur vers une page de confirmation
                    response.sendRedirect("add_job.jsp");
                } else {
                    // L'insertion a echoue, renvoyer un message d'erreur
                    response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Impossible de creer un nouvel utilisateur.");
                }
            } 
            catch (Exception e) {
                // Gerer les exceptions SQLException
                e.printStackTrace(); // Affiche l'erreur dans la console du serveur
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
            }
        } else {
            // Les donnees de l'utilisateur sont invalides, renvoyer un message d'erreur
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Veuillez fournir tous les champs necessaires.");
        }
    }
}
