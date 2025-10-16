import java.util.Comparator;

public class SortDepartmentsById implements Comparator<Department> {
    @Override
    public int compare(Department o1, Department o2) {
        return o1.getId().compareTo(o2.getId());
    } // 1 2 3 4
}
