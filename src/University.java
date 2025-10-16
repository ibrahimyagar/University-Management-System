import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class University {

    // Fieldlarimizi private tanimliyoruz
    //private Long id;
    public static final String NAME = System.getenv("UNIVERSITY_NAME");//"Workintech University";
    private String address;
    private String email;
    // const arr = [];
    // arr.push("Enis");
    // arr.push("Gayretli");
    // arr = [1, 2, 3];
    private final List<Faculty> faculties = new ArrayList<>();
    // faculties = new ArrayList(); yapamazsiniz!

    private static final University instance = new University();

    /*
    public University(Long id, String name){
        this.id = id;
        this.name = name;
    }
     */
    private University(){
        //this.faculties = new ArrayList<>();
    }

    public static University getInstance(){
        return instance;
    }

    //University university = new University();
    // university.setName("");

    // getter ve setter yazacagiz
    /*public Long getId(){
        return this.id; // id;
    }

    public String getName(){
        return this.name;
    }
     */

    public String getAddress(){
        return address;
    }

    public String getEmail(){
        return this.email;
    }

    public List<Faculty> getFaculties(){
        //return new ArrayList<>(faculties); // Bizim fakultelerimizden bir kopya alinmasi ve farkli bir referansla disariya acilmasi demek
        return Collections.unmodifiableList(faculties); // Read-only list-> yani sadece okuyabilir ama add yapamaz, degisiklik yapamaz
    }

    public List<Faculty> getFacultiesSnapshot(){
        return List.copyOf(this.faculties);
    }

    public List<Faculty> getFacultiesSnapshotWithModifiableList(){
        return Collections.unmodifiableList(new ArrayList<>(this.faculties));
    }

    public List<Faculty> getFacultiesAsNewArrayList(){
        return new ArrayList<>(this.faculties);
    }
    /*
    public void setFaculties(List<Faculty> faculties){
        this.faculties.clear();
        this.faculties = new ArrayList<>(faculties); // defensive copy
    }
    */

    /*public void setId(Long id){
        this.id = id;
    }

    public void setName(String name){

        // TODO move this to utils
        if(name == null)
            throw new IllegalArgumentException("Name null olamaz"); // Bunu aklimizda tutalim

        this.name = name;
    }
    */
    public void setAddress(String address){
        this.address = address;
    }

    public void setEmail(String email){

        // Validasyonlar yapabiliriz

        this.email = email;
    }


    public void addFaculty(Faculty faculty){

        if(faculty == null)
            throw new IllegalArgumentException("Faculty cannot be null!");
        // Kontrolleri yaptiktan sonra ekliyoruz
        // Daha once eklendi mi kontrol et

        if(faculty.getUniversity().equals(this) && !faculties.contains(faculty))
            this.faculties.add(faculty);
    }

    public void removeFaculty(Faculty faculty){

        this.faculties.remove(faculty);
    }

    // Encapsulation

    // University university1 = new University();
    // University university2 = new University();
    // university1.equals(university2);
    /*@Override
    public boolean equals(Object obj){

        if(obj == this) // university1.equals(university1);
            return true;

        // university1.equals(null); -> false
        // university1.equals(elma1);
        if(obj == null || obj.getClass() != getClass())
            return false;

        University university = (University) obj;

        return university.getId().equals(this.id);
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.id);
    }*/

    @Override
    public String toString() {

        return "University Name: " + NAME;
    }
}
