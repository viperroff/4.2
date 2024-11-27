import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Student {
    private String name;
    private List<Integer> grades;

    public Student(String name, Integer... grades) {
        this.name = name;
        this.grades = grades.length > 0 ? new ArrayList<>(Arrays.asList(grades)) : new ArrayList<>();
    }

    public boolean canAddGrade(int grade) {
        return grade >= 1 && grade <= 5;
    }

    public void addGrade(int grade) {
        if (!canAddGrade(grade)) {
            throw new InvalidGradeException("Неправильная оценка для студента " + name);
        }
        grades.add(grade);
    }

    @Override
    public String toString() {
        return name + ": " + grades;
    }
}
