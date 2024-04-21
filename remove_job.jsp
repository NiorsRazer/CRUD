<%@page import="java.util.List"%>
<%@page import="util.Class_Job"%>
<%
    List<Class_Job> jobList = (List<Class_Job>) request.getAttribute("list");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles.css">
    <title>Ajouter une depense</title>
</head>
<body>
    <h1>List de Job</h1>
    <table border="2">
        <thead>
            <tr>
                <%-- <th>ID</th> --%>
                <th>Name</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <% for (Class_Job job : jobList) { %>
                <tr>
                    <%-- <td><%= job.getID() %></td> --%>
                    <td>
                    <form action="/Crud/update" method="get">
                        <input type="text" name="nom" value="<%= job.getNom() %>">
                        <input type="hidden" name="id" value="<%= job.getID() %>">
                        <input type="submit" value="Modify">
                    </from>
                    </td>
                    <td><button> <a href="/Crud/delete?id=<%= job.getID() %>">Supprimer</a></button></td>
                </tr>
            <% } %>
        </tbody>
    </table>
    <button><a href="add_job.jsp">Add Job</a></button>
</body>
</html>

