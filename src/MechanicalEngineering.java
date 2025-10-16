import java.util.Set;

public class MechanicalEngineering extends Department{
    public MechanicalEngineering(Long id, String name, Faculty faculty) {
        super(id, name, faculty);
    }

    @Override
    public Set<Course> lessonToLearn() {
        return getCourses();
    }
}
