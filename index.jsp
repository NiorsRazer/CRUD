<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Formulaire d'inscription</title>
</head>
<body>
    <h1>Formulaire d'inscription</h1>
    <form action="/Crud/createUser" method="post">
        <label for="nom">Nom :</label>
        <input type="text" id="nom" name="nom"><br><br>
        
        <label for="prenom">Prenom :</label>
        <input type="text" id="prenom" name="prenom"><br><br>
        
        <label for="sexe">Sexe :</label>
        <label for="sexe">M</label><input type="radio" id="sexe" name="sexe" value="0">
        <label for="sexe">F</label><input type="radio" id="sexe" name="sexe" value="1"><br><br>
        
        <input type="submit" value="Creer un utilisateur">
    </form>
    <button><a href="add_job.jsp">Add Job</a></button>
</body>
</html>
