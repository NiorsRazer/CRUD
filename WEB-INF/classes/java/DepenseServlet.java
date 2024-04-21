import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Date;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepenseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérer les paramètres du formulaire HTML
        String montant = request.getParameter("montant");
        String date = request.getParameter("date");

        // Vérifier si les paramètres sont présents et non vides
        if (montant != null && !montant.isEmpty() && date != null && !date.isEmpty()) {
            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/crud_example", "root", "");

                // Préparer la requête SQL INSERT INTO
                String sqlInsert = "INSERT INTO depenses (montant, date) VALUES (?, ?)";
                PreparedStatement statementInsert = connection.prepareStatement(sqlInsert);
                statementInsert.setString(1, montant);
                statementInsert.setString(2, date);

                // Exécuter la requête SQL INSERT INTO
                int rowsInserted = statementInsert.executeUpdate();
                statementInsert.close();

                // Vérifier si l'insertion a réussi
                if (rowsInserted > 0) {
                    // Préparer la requête SQL SELECT
                    String sqlSelect = "SELECT * FROM depenses";
                    PreparedStatement statementSelect = connection.prepareStatement(sqlSelect);

                    // Exécuter la requête SQL SELECT
                    ResultSet resultSet = statementSelect.executeQuery();

                    // Stocker les dépenses dans une liste de listes
                    List<List<String>> depenses = new ArrayList<>();
                    while (resultSet.next()) {
                        List<String> depense = new ArrayList<>();
                        depense.add(resultSet.getString("montant"));
                        depense.add(resultSet.getString("date"));
                        depenses.add(depense);
                    }
                    resultSet.close();
                    statementSelect.close();
                    connection.close();

                    // Transmettre la liste des dépenses à la page JSP
                    request.setAttribute("depenses", depenses);
                    request.getRequestDispatcher("depenseAjoutee.jsp").forward(request, response);
                } else {
                    // L'insertion a échoué, renvoyer un message d'erreur
                    response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Impossible d'ajouter la dépense.");
                }
            } catch (SQLException e) {
                // Gérer les exceptions SQLException
                e.printStackTrace(); // Affiche l'erreur dans la console du serveur
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erreur lors de la connexion à la base de données.");
            }
        } else {
            // Les données de la dépense sont invalides, renvoyer un message d'erreur
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Veuillez fournir tous les champs nécessaires.");
        }
    }
}
