import mv.model.Student;
import mv.view.StudentView;

public class Main {

    public static void main(String[] args) {

        Student student = new Student(0, "Alfonso Pettiti", 1, 'A');

        StudentView studentView = new StudentView(student);

        student.setViewListener(studentView);



    }
}
