package hospital_management_system;

public class Patient {
    private static int idCounter=1;
    private int id;
    private String name;
    private String gender;
    private int age;

    public Patient (String name,String gender, int age ){
        this.id = idCounter++;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    public int getId(){
        return id;
    }
    public String toString(){
        return "Patient Id: "+id+", Name: "+name+", Age: "+age+", Gender: "+gender;

    }

}
