import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import con.Con;

public class UpdateJobServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        int id = Integer.parseInt(req.getParameter("id"));
        String nom = req.getParameter("nom");
        
        try {
            Con connection = new Con();
            String sql = "UPDATE type_job SET nom = ? WHERE id_type_job = ?";
            PreparedStatement statement = connection.getConnection().prepareStatement(sql);
            statement.setString(1, nom);
            statement.setInt(2, id);
            
            int rowsUpdated = statement.executeUpdate();
            
            statement.close();
            connection.getConnection().close();
            
            if (rowsUpdated > 0) {
                res.sendRedirect("/Crud/list_job");
            } else {
                res.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to update job.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            res.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        int id = Integer.parseInt(req.getParameter("id"));
        String nom = req.getParameter("nom");
        
        try {
            Con connection = new Con();
            String sql = "UPDATE type_job SET nom = ? WHERE id_type_job = ?";
            PreparedStatement statement = connection.getConnection().prepareStatement(sql);
            statement.setString(1, nom);
            statement.setInt(2, id);
            
            int rowsUpdated = statement.executeUpdate();
            
            statement.close();
            connection.getConnection().close();
            
            if (rowsUpdated > 0) {
                res.sendRedirect("/Crud/list_job");
            } else {
                res.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to update job.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            res.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}
