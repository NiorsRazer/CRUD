<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles.css">
    <title>Ajouter une depense</title>
</head>
<body>
    <h1>Ajouter une depense</h1>
    <form action="/Crud/ajouterJob" method="post">
        <label for="nom">Nom du job :</label>
        <input type="text" id="nom" name="nom"><br><br>
        <input type="submit" value="Ajouter">
    </form>
    <button><a href="/Crud/list_job">List Job</a></button>
</body>
</html>
