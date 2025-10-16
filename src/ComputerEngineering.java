import java.util.List;
import java.util.Set;

public class ComputerEngineering extends Department{
    public ComputerEngineering(Long id, String name, Faculty faculty) {
        super(id, name, faculty);
    }


    @Override
    public Set<Course> lessonToLearn() {
        return getCourses();
        //return List.of("Introcution to C", "Microchip programming", "Hardware");
    }
}
