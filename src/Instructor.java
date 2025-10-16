import java.util.*;

public abstract class Instructor {
   // Instructor sınıfında(id, firstName, lastName, salary, hasMsc, hasPhd)
    private Long id;
    private String firstName;
    private String lastName;
    private Double salary;
    private Boolean hasMsc;
    private Boolean hasPhd;

    private Map<Long, Course> courseMap = new HashMap<>();


    public void addCourse(Course course){
        this.courseMap.put(course.getId(), course);
    }

    public void removeCourse(Course course){
        this.courseMap.remove(course.getId());
    }

    public Map<Long, Course> getCourseMap(){
        return Collections.unmodifiableMap(courseMap);
    }

    public Collection<Course> getCourseList(){
        return Collections.unmodifiableCollection(courseMap.values());
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Boolean getHasMsc() {
        return hasMsc;
    }

    public Boolean getHasPhd() {
        return hasPhd;
    }

    public Double getSalary() {
        return salary;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setHasMsc(Boolean hasMsc) {
        this.hasMsc = hasMsc;
    }

    public void setHasPhd(Boolean hasPhd) {
        this.hasPhd = hasPhd;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this)
            return true;

        if(obj == null || obj.getClass() != getClass())
            return false;

        Instructor instructor = (Instructor) obj;

        return instructor.getId().equals(id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Instructor Name : " + firstName + " " + lastName;
    }
    // 'presentLesson', 'takeExam', 'makeALab', 'teachToWriteAcademicPaper', 'teachAcademicResearch', 'introduceStudentToAcademicStaff'

    /*



    */
    // SOLID principles
    // Single Responsibility
    // Open for extension closed for Modification
    // Liskov's subtition
    // Interface Segragation
    // Depenceny Inversion

}
