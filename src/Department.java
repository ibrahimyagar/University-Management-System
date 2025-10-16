import utils.Utils;

import java.util.*;
import java.util.stream.Collectors;

// Instance alamayiz! new Department() yapamayiz!
public abstract class Department implements Comparable<Department> {
     /* - Departmant sınıfı içerisinde(id, name, departmentHead, (bağlı bulunduğu fakülte => bu ilişki nasıl kurulmalı)
- Bazı departmanlarda departmanlara özel sınıf değişkenleri(instance variable) olabilir.
    Örneğin: 'Computer Engineering' departmanı altında 'programmingLanguagesShouldBeTaught' bir liste olmalı ve içerisinde bölümde öğretilecek programlama dilleri yer almalı.
    Bu ilişkiyi baz alarak Departmant ve Computer Engineering sınıfları arasındaki ilişkiyi tanımlayınız.
    Kendinizde benzer şekillerde birkaç tane departman ekleyin ve o departmana özgü şeyler eklemeye çalışın.(Bu noktada öğrencilere sorulur)

      */
    private Long id;
    private String name;
    private Faculty faculty; // Composition

    private Set<Course> courses = new HashSet<>();

    public Department(Long id, String name, Faculty faculty){
        this.setId(id);
        this.setName(name);
        this.setFaculty(faculty);
    }

    // Getter
    public Long getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public Faculty getFaculty(){
        return this.faculty;
    }

    public Set<Course> getCourses(){
        return Collections.unmodifiableSet(courses);
    }

    public Set<Course> getCoursesWithGpaMoreThan(Double gpa){
        return this.courses
            .stream()
            .filter(course -> course.getGpa() > gpa)
            .collect(Collectors.toUnmodifiableSet());
    }

    public Set<String> getCourseNamesWithGpaMoreThan(Double gpa){
        return this.courses
            .stream()
            .filter(course -> course.getGpa() > gpa)
            .map(Course::getName) // .map(course -> course.getName()); Function<T, R>
            .collect(Collectors.toUnmodifiableSet());
    }


    // Setter
    public void setId(Long id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    private void setFaculty(Faculty faculty){
        this.faculty = faculty;
    }

    public void addCourse(Course course){

//        if(Utils.isNull(course))
//            throw new IllegalArgumentException("Course null olamaz");

        Utils.validateAndThrow(course, "Course cannot be null!");

        this.courses.add(course);
    }

    public void removeCourse(Course course){
        this.courses.remove(course);
    }

    // Equals

    @Override
    public boolean equals(Object obj){

        if(obj == this)
            return true;

        if(obj == null || obj.getClass() != getClass())
            return false;

        Department department = (Department) obj;

        return department.getId().equals(this.id);
    }
    // Hashcode
    @Override
    public int hashCode(){
        return Objects.hash(this.id);
    }
    // ToString
    @Override
    public String toString(){
        return "Department Name : " + getName();
    }

    public abstract Set<Course> lessonToLearn();
    // Constructor

    @Override
    public int compareTo(Department o) {
        return this.name.compareTo(o.getName());
    }
}
