import java.util.List;
import java.util.Set;

// Department department = new SoftwareEngineering();
public class SoftwareEngineering extends Department{ // Inheritance
    public SoftwareEngineering(Long id, String name, Faculty faculty) {
        super(id, name, faculty);
    }

    // Polymorphism
    @Override
    public Set<Course> lessonToLearn() { // Abstraction
        return getCourses();
        //return List.of("C++", "Introduction to Programming", "Intro to Java", "Data Structures");
    }

    /*@Override
    public boolean equals(Object obj) {

        if(!(obj instanceof SoftwareEngineering))
            return false;
        return super.equals(obj) && ((SoftwareEngineering)obj).getName().equals(getName());
    }*/
}
