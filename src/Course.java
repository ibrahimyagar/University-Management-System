import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Course {
    private Long id;
    private String name;
    private Double gpa;
    private String code;
    private Department department;

    public Course(Long id, String name, Double gpa, String code, Department department){
        this.setId(id);
        this.setName(name);
        this.setCode(code);
        this.setGpa(gpa);
        this.setDepartment(department);
    }

    private Set<Instructor> instructors = new HashSet<>();

    public Set<Instructor> getInstructors(){
        return Collections.unmodifiableSet(instructors);
    }

    public void addInstructor(Instructor instructor){
        this.instructors.add(instructor);
    }

    public void removeInstructor(Instructor instructor){
        this.instructors.remove(instructor);
    }

    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public Double getGpa(){
        return gpa;
    }

    public String getCode(){
        return code;
    }

    public Department getDepartment(){
        return department;
    }

    public void setId(Long id){
        this.id = Objects.requireNonNull(id);
    }

    public void setName(String name){
        this.name = name;
    }

    public void setGpa(Double gpa ){
        this.gpa = gpa;
    }

    public void setCode(String code){
        this.code = code;
    }

    public void setDepartment(Department department){
        this.department = Objects.requireNonNull(department);
    }

    // Polymorphism
    @Override
    public boolean equals(Object obj){
        if(this == obj)
            return true;

        if(obj == null || obj.getClass() != getClass())
            return false;

        Course course = (Course) obj;

        return course.getId().equals(id);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }

    @Override
    public String toString(){
        return "Course Name : " + name;
    }
}
