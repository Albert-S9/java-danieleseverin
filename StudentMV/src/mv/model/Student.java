package mv.model;

import mv.view.StudentView;

import java.util.ArrayList;

public class Student {

    private int code=0;
    private String fullname;

    private int year;
    private char letter;

    private StudentView studentView;

    private ArrayList<Integer> grades;
    private ArrayList<Student> students;

    public Student(int code, String fullname, int year, char letter) {
        this.code = code;
        this.fullname = fullname;
        this.year = year;
        this.letter = letter;

        grades = new ArrayList<>();
        students = new ArrayList<>();
    }

    public void setViewListener(StudentView listener) {
        this.studentView = listener;
    }

    public void onUpdateYear(int year) {
        this.year = year;

        if (studentView != null)
            studentView.onUpdateYear(this.year);
    }

    public void onUpdateLetter(char letter) {
        this.letter = letter;

        if (studentView != null)
            studentView.onUpdateLetter(this.letter);
    }

    public void onUpdateFullname(String fullname) {
        this.fullname = fullname;

        if (studentView != null)
            studentView.onUpdateFullname(this.fullname);
    }

    public void addGrade(int grade) {
        grades.add(grade);

        if (studentView != null)
            studentView.onUpdateGrades(grades);
    }

    public void removeGrade(int index) {
        this.grades.remove(index);

        if (studentView != null)
            studentView.onUpdateGrades(this.grades);
    }

    public void addStudent(int parYear, char parLetter, String parFullname){
        students.add(new Student(code, parFullname, parYear, parLetter));
        code++;

        if (studentView != null)
            studentView.onUpdateStudents(students);
    }

    public void removeStudent(int index) {
        this.students.remove(index);

        if (studentView != null)
            studentView.onUpdateStudents(this.students);
    }

    @Override
    public String toString() {
        return "Matricola: " + code + " - " + fullname + " " + year + letter;
    }
}
