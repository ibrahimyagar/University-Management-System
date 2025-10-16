import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

// Exception handling
// Lambda functions -> Callback function, arrow function
// Stream API
// Search islemleri Stream api
// Generics, Generic Methods --> K, V
public class Main {


    /*public static void printArray(String [] isimler){
        for(String isim: isimler){
            System.out.println(isim);
        }
    }

    public static void printArray(Integer [] sayilar){
        for(Integer sayi: sayilar){
            System.out.println(sayi);
        }
    }

    public static void printArray(Double [] sayilar){
        for(Double sayi: sayilar){
            System.out.println(sayi);
        }
    }*/


    public static <T> void printArray(T[] array){
        for(T element: array){
            System.out.println(element);
        }
    }

    public static void checkAge(int age) throws FileNotFoundException {

        if(age < 18)
            throw new FileNotFoundException("Bu islemi yapmak icin 18 yasindan buyuk olmaniz gerekmektedir");
        else
            System.out.println("Yasiniz gecerli");
    }

    public static void main(String[] args) {
        Integer[] numbers = {1, 2, 3};
        int sayi1 = 10;
        int sayi2 = 0;

        String [] isimArr = {"Enis", "Ayse"};
        Double [] gpaS = {3.5, 2.9, 9.2};

        printArray(numbers);
        printArray(isimArr);
        printArray(gpaS);

        Pair<Integer, String> idNamePair = new Pair<>(1, "Enis");

        System.out.println(idNamePair.getKey());
        System.out.println(idNamePair.getValue());

        // (parametre) -> expression
        // (parametre1, parametre2) -> expression
        // ()-> {
        //    return
        // }
        /*Bsc bsc = new Bsc() {
            @Override
            public void presentLesson() {

            }

            @Override
            public void takeExam() {

            }
        };*/

        Greeting greeting = new Greeting() {
            @Override
            public void sayHello(String name) {
                System.out.println("Merhaba " + name);
            }
        };

        Greeting greeting1 = (name)-> System.out.println("Merhaba " + name);

        // const greeting = (name)-> console.log("Merhaba " +name);

        //greeting.sayHello("Enis");
        //greeting1.sayHello("Enis");

        MathOperation toplama = (a, b)-> a + b;
        MathOperation carpma = (a, b)-> a * b;

        //System.out.println("Toplama islemi :" + toplama.operate(10, 20));
        //System.out.println("Carpma islemi :" + carpma.operate(10, 20));
        EkranaYazdiran ekranaYazdiran = (name)-> System.out.println(name);

        Consumer<String> method = name -> System.out.println(name);
        // void yazdir(String name);
        //isimler.forEach(ekranaYazdiran);
        method.accept("Enis");

        Predicate<Integer> ciftMiDegilMi = (sayi)-> sayi % 2 == 0;

        ciftMiDegilMi.test(4);

        Function<String, Integer> stringBoyutu = (name)-> name.length();

        stringBoyutu.apply("Enis");

        Supplier<Integer> randomNumber = ()-> new Random().nextInt(100);

        randomNumber.get();

        List<String> isimler = Arrays.asList("Ahmet", "Ayse", "Aleyna", "Azra", "Asya", "Enis", "Deniz", "Leyla", "Suzan", "Zeynep", "Enis", "Ali", "Ahmet");

        List<String> names = new ArrayList<>();

        for(String name: isimler){
            if(name.startsWith("A"))
                names.add(name.toUpperCase());
            //System.out.println(name);
        }
        // Collection, Array, Map, Set , yardimci methodlari kullanarak degisitriiyoruz
        // Stream API methodlar sunuyor
        List<String> result = isimler
            .stream()
            .filter(name -> name.startsWith("A"))
            .map(String::toUpperCase) // name -> name.toUpperCase();
            .sorted()
            .distinct()
            .toList();

        //System.out.println(result);
        long count = isimler.stream()
                .filter(name -> name.startsWith("A"))
                .map(String::toUpperCase) // name -> name.toUpperCase();
                //.sorted()
                .distinct()
                .count();
                //.forEach(System.out::println);
        System.out.println(count);

        // array -> tek birsey geri donduruyordu
        long isimlerinUzunlukToplami = isimler
                .stream()
                .filter(name -> name.startsWith("A"))
                .distinct()
                .map(name-> name.length())
                .reduce(0, Integer::sum);

        System.out.println(isimlerinUzunlukToplami);

        String [] nameArr = {"Enis", "Zeynep", "Ali", "Ahmet"};
        List<String> nameList = Arrays.stream(nameArr)
                .collect(Collectors.toUnmodifiableList());

        try {
            //System.out.println(sayi1 / sayi2);
            checkAge(17);
            System.out.println(numbers[1]);
        }catch (ArithmeticException | ArrayIndexOutOfBoundsException ex){
            System.out.println(ex.getMessage());
        }/*catch(ArrayIndexOutOfBoundsException ex){
            System.out.println(ex.getMessage());
        }*/catch (FileNotFoundException ex){
            System.out.println(ex);
        }finally {
            System.out.println("Ne olursa olsun calisan blok");
        }

        System.out.println("University Name -----> " + University.NAME);

        University workintechUniversity = University.getInstance();
        //University workintechUniversity = new University(1L, "Workintech University");

        //University istanbulAydinUniversity = new University(2L, "Istanbul Aydin University");

        //University ozyeginUniversity = new University(3L, "Ozyegin Univeristy");

        Faculty engineering = new Faculty(1L, "Engineering", workintechUniversity);
        workintechUniversity.addFaculty(engineering);
        Faculty architecture = new Faculty(2L, "Architecture", workintechUniversity);
        workintechUniversity.addFaculty(architecture);

        Department softwareEngineering = new SoftwareEngineering(1L, "Software Engineering", engineering);
        Department computerEngineering = new ComputerEngineering(2L, "Computer Engineering", engineering);
        Department mechanicalEngineering = new MechanicalEngineering(3L, "Mechanical Engineering", engineering);

        engineering.addDepartment(softwareEngineering);
        engineering.addDepartment(computerEngineering);
        engineering.addDepartment(mechanicalEngineering);

        Course cPlusPlus = new Course(1L, "C++", 4.0, "CS101", softwareEngineering);
        Course introToJava = new Course(2L, "Intro to Java", 5.0, "CS302", softwareEngineering);

        softwareEngineering.addCourse(cPlusPlus);
        softwareEngineering.addCourse(introToJava);


        System.out.println("Universite : " + University.NAME);
        for(Faculty faculty: workintechUniversity.getFaculties()){
            System.out.println("      " + faculty);
            for(Department department : faculty.getSortedToList()){
                System.out.println("          " + department);
                for(Course course: department.getCourses()){
                    System.out.println("            " + course);
                }
            }
        }
        // Sikinti ne?
        //workintechUniversity.addFaculty(architecture);
        //workintechUniversity.addFaculty(engineering);

        /*
        List<Faculty> facultyList = workintechUniversity.getFaculties();
        List<Faculty> faculties = workintechUniversity.getFacultiesSnapshot();
        List<Faculty> faculties1 = workintechUniversity.getFacultiesSnapshotWithModifiableList();
        List<Faculty> fa = workintechUniversity.getFacultiesAsNewArrayList();

        System.out.println("Faculty List : " + facultyList);
        System.out.println("Faculties : "  + faculties);
        System.out.println("Faculties1 : "  + faculties1);
        System.out.println("Faculty as new ArrayList : "  + fa);

        workintechUniversity.addFaculty(architecture);
        System.out.println("Faculty List ++ : " + facultyList);
        System.out.println("Faculties ++ : "  + faculties);
        System.out.println("Faculties1 ++ : "  + faculties1);
        System.out.println("Faculty as new ArrayList ++ : "  + fa);
        */

        //System.out.println(university.getClass());
        //System.out.println(university.getClass().getSimpleName());

        //university.getFaculties().add(new Faculty());
        //university.getFaculties().add(new Faculty());
        //university.name = "";
        //System.out.println(university.getFaculties().size());

        //Department se = new SoftwareEngineering(1L, "Software Engineering", engineering);
        //Department se2 = new SoftwareEngineering(1L, "Software Engineering", engineering);

        //System.out.println(se instanceof SoftwareEngineering);
    }
}
/*
Universite Fakülte Sistemi

- Bir üniversite içerisinde birden fazla fakülte ve bu fakültelere bağlı birden fazla departman olabilir.
        - Faculty sınıfı içerisinde(id, name, createdDate, address, dean, (fakülte altında bulunan departmanlar => bu ilişki nasıl kurulmalı)) bilgileri olmalıdır.
        - Departmant sınıfı içerisinde(id, name, departmentHead, (bağlı bulunduğu fakülte => bu ilişki nasıl kurulmalı)
- Bazı departmanlarda departmanlara özel sınıf değişkenleri(instance variable) olabilir.
Örneğin: 'Computer Engineering' departmanı altında 'programmingLanguagesShouldBeTaught' bir liste olmalı ve içerisinde bölümde öğretilecek programlama dilleri yer almalı.
Bu ilişkiyi baz alarak Departmant ve Computer Engineering sınıfları arasındaki ilişkiyi tanımlayınız.
Kendinizde benzer şekillerde birkaç tane departman ekleyin ve o departmana özgü şeyler eklemeye çalışın.(Bu noktada öğrencilere sorulur)

        - Departmant sınıfı içerisinde bir adet 'lessonToLearn' adında metod tanımlanmalıdır. Bu metod içerisinde departmanda öğretilecek olan dersleri tutmaktadır.
Her departman bu metodu farklı şekillerde @Override etmelidir.

- Departmanların altında Dersler tanımlanmalıdır. Bir departmanda pek çok ders okutulabilir. Ancak her ders tek bir departmana ait olmalıdır.

        - Course isminde bir sınıf tanımlayın içerisinde(id, name, gpa) değerleri olmalıdır. Departman ile ilişkisini tanımlayın.

        - Bu ilişki tanımlandıktan sonra Departman sınıfı extends etmiş sınıflarda 'lessonToLearn' metodunu Course tipinde objeleri tutacak şekilde güncelleyiniz.

- Instructor ve Course ilişkisini tanımlamak için Instructor adında bir sınıf daha oluşturun ve ikisi arasındaki ilişkiyi tanımlayınız. Bir Instructor pek çok ders verebilir.
Bir ders pek çok hoca tarafından verilebilir.
        Instructor sınıfında(id, firstName, lastName, salary, hasMsc, hasPhd) değişkenleri tanımlı olmalıdır.

        - Instructor'lar farklı seviyedeki öğrenci gruplarına ders verebilirler. BsC, MsC ve Phd.
Bsc programda Instructor'ın 2 görevi vardır. 'presentLesson', 'takeExam'
Msc programda Instructor'ın 4 görevi bulunur. 'presentLesson', 'takeExam', 'makeALab', 'teachToWriteAcademicPaper'
Phd programda Instructor'ın 6 görevi bulunur. 'presentLesson', 'takeExam', 'makeALab', 'teachToWriteAcademicPaper', 'teachAcademicResearch', 'introduceStudentToAcademicStaff'

Bir Instructor Bsc, Msc, Phd bunların hepsine de ders verebilir, içlerinden sadece bir kısmına da ders verebilir. Bu programlar ile Instructor ilişkisi nasıl olmalı(Öğrencilere dizayn yaptırmaya çalışılmalı)
Minimum kod tekrarı yapmak için nasıl bir yol izlenebilir ?
        - Interfacelere ayırmak mantıklı olabilir.

 */