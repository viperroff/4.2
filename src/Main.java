import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) {

        //4.1.1

        Student student1 = new Student("Вася", 3, 4, 5);
        Student student2 = new Student("Максим");

        System.out.println(student1);
        System.out.println(student2);

        try {
            student1.addGrade(6);
        } catch (InvalidGradeException e) {
            System.out.println(e.getMessage());
        }


        //4.1.2

        try{
            NetworkConnection networkConnection1 = new NetworkConnection(false);
        }catch (NetworkStatusException e){
            System.out.println(e.getMessage());
        }

        try{
            NetworkConnection networkConnection2 = new NetworkConnection(true);
            networkConnection2.SetConnectionStatus(false);
        }catch (NetworkStatusException e){
            System.out.println(e.getMessage());
        }

        //4.1.3

        Student student3 = new Student("Вася", 3, 4, 5);
        Student student4 = new Student("Максим");
        Student student5 = new Student("Аня");

        List<Student> students = Arrays.asList(student1, student2, student3);

        String result = addRandomGrades(students);
        System.out.println(result);

        for (Student student : students) {
            System.out.println(student);
        }

        //4.1.4

        List<String> names = generateStudent(5);
        List<String> grades = generateRandomGrades(5);

        List<Student> newStudents = convert(names, grades);

        if (students != null) {
            for (Student student : newStudents) {
                System.out.println(student);
            }
        }



    }

    public static String addRandomGrades(List<Student> students) {
        Random random = new Random();
        boolean canAddGrade = true;

        for (Student student : students) {
            int grade = random.nextInt(10) + 1;
            if (!student.canAddGrade(grade)) {
                canAddGrade = false;
                break;
            }
        }

        if (!canAddGrade) {
            return "Не удалось добавить оценку ни одному студенту.";
        }

        for (Student student : students) {
            int grade = random.nextInt(10) + 1;
            student.addGrade(grade);
        }

        return "Оценки успешно добавлены.";
    }

    public static List<Student> convert(List<String> names, List<String> grades) {
        List<Student> students = new ArrayList<>();
        Random rand = new Random();

        for (String name : names) {
            try {
                List<Integer> integerGrades = new ArrayList<>();
                for (String gradeStr : grades) {
                    integerGrades.add(Integer.parseInt(gradeStr));
                }
                Student student = new Student(name, integerGrades.toArray(new Integer[0]));
                students.add(student);

            }catch (InvalidGradeException e) {
                System.out.println("Ошибка: " + e.getMessage());
                return convert(names, new ArrayList<>());
            } catch (NumberFormatException e) {
                System.out.println("Студента " + name + " создать невозможно.");
            } catch (Exception e) {
                System.out.println("Студента " + name + " создать невозможно.");
            }
        }

        return students;
    }

    private static List<String> generateStudent(int count) {
        List<String> names = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            names.add("Студент " + i);
        }
        return names;
    }

    private static List<String> generateRandomGrades(int count) {
        List<String> grades = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            grades.add(Integer.toString(random.nextInt(11)));
        }
        return grades;
    }
}