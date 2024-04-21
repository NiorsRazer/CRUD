package util;

public class Class_Job {
    int id;
    String nom;

    public Class_Job(int id, String nom){
        this.setID(id);
        this.setNom(nom);
    }

    public void setID(int id){
        this.id = id;
    }
    public void setNom(String nom){
        this.nom = nom;
    }

    public int getID(){
        return this.id;
    }
    public String getNom(){
        return this.nom;
    }
}
