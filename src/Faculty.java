import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;


public class Faculty {

    // - Faculty sınıfı içerisinde(id, name, createdDate, address, dean, (fakülte altında bulunan departmanlar => bu ilişki nasıl kurulmalı)) bilgileri olmalıdır.
    private Long id;
    private String name;
    private LocalDateTime createdDate;
    private String address;
    private String email;
    private String phoneNumber;
    private String dean;

    private University university;

    private Set<Department> departments = new HashSet<>();

    public Faculty(Long id, String name, University university){
        this.setId(id);
        this.setName(name);
        this.university = university;
        //this.university.addFaculty(this);
        this.createdDate = LocalDateTime.now();
    }
    // getter
    public Long getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public LocalDateTime getCreatedDate(){
        return this.createdDate;
    }

    public String getDean(){
        return this.dean;
    }

    public String getAddress(){
        return this.address;
    }

    public String getEmail(){
        return this.email;
    }

    public String getPhoneNumber(){
        return this.phoneNumber;
    }

    public University getUniversity(){
        return this.university;
    }

    public Set<Department> getDepartments(){
        return Collections.unmodifiableSet(departments); //read-only
    }

    public SortedSet<Department> getSortedDepartments(){
        return Collections.unmodifiableSortedSet(new TreeSet<>(departments));
    }

    public SortedSet<Department> getSortedDepartmentsById(){
        SortedSet<Department> sortedSet = new TreeSet<>(new SortDepartmentsById());
        sortedSet.addAll(departments);
        return Collections.unmodifiableSortedSet(sortedSet);
    }

    public SortedSet<Department> getSortedDepartmentsByIdViaStream(){
        return this.departments.stream()
                .collect(Collectors.toCollection(()->
                  new TreeSet<>(Comparator.comparing(Department::getId))
                ));
                //.sorted(Comparator.comparing(Department::getId))
                //.collect(Collectors.toCollection(TreeSet::new));
                //.collect(Collectors.);
    }

    public List<Department> getSortedToList(){
        return this.departments.stream().sorted(Comparator.comparing(Department::getId)).toList();
    }

    public SortedSet<Department> getSortedDepartmentsByIdAndName(){
        return this.departments.stream().collect(Collectors.toCollection(()->
                    new TreeSet<>(Comparator.comparing(Department::getId).thenComparing(Department::getName))
                ));
                //.sorted(Comparator.comparing(Department::getId).thenComparing(Department::getName))
                //.collect(Collectors.toCollection(TreeSet::new));
    }

    /*public SortedSet<Department> getSortedDepartmentsByIdAndName2(){
        return this.departments.
    }*/


    // setter

    public void setId(Long id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }

    public void setEmail(String email){
        this.email = email;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public void setCreatedDate(LocalDateTime createdDate){
        this.createdDate = createdDate;
    }
    public void setDean(String dean){
        this.dean = dean;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    // addDepartment(new SoftwareEngineering());
    // Department department = new ComputerEngineering(); // upcast
    // ComputerEngineering ce = ((ComputerEngineering)department); downcast
    public void addDepartment(Department department){// Liskov substituon

        // Kontroller sonrasi ekle
        this.departments.add(department);
    }

    public void removeDepartment(Department department){
        this.departments.remove(department);
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj)
            return true;

        if(obj == null || obj.getClass() != getClass())
            return false;

        Faculty faculty = (Faculty) obj;

        return faculty.getId().equals(this.id);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }

    @Override
    public String toString(){
        return "Faculty Name : " + getName();
    }

}
