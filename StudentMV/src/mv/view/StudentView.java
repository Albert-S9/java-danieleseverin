package mv.view;

import mv.model.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StudentView extends JFrame {

    private Student student;

    private JLabel yearLabel;
    private JLabel letterLabel;
    private JLabel fullnameLabel;
    private DefaultListModel<String> gradesListModel;
    private DefaultListModel<String> studentListModel;

    public StudentView(Student student) {
        super("Student View");

        this.student = student;


        // Create graphic interface
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(new Dimension(500, 500));

        JPanel basePane = new JPanel(new BorderLayout());
        setContentPane(basePane);

        JPanel topPane = new JPanel();
        basePane.add(topPane, BorderLayout.NORTH);

        JPanel centerPane = new JPanel();
        basePane.add(centerPane, BorderLayout.CENTER);


        yearLabel = new JLabel("Year: ----");
        letterLabel = new JLabel("Class: -");
        fullnameLabel = new JLabel("Fullname: -");
        topPane.add(yearLabel);
        topPane.add(letterLabel);
        topPane.add(fullnameLabel);


        JButton updateButton = new JButton("Update");
        topPane.add(updateButton);

        studentListModel = new DefaultListModel<>();
        JList<String> studentList = new JList<>(studentListModel);
        studentList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        topPane.add(new JScrollPane(studentList));

        JButton addStudentButton = new JButton("Add student");
        topPane.add(addStudentButton);

        JButton removeStudentButton = new JButton("Rmv student");
        topPane.add(removeStudentButton);

        //->
        addStudentButton.addActionListener(e->{
            JPanel dialogPane = new JPanel();

            dialogPane.add(new Label("Year"));
            JTextField yearText = new JTextField(4);
            dialogPane.add(yearText);

            dialogPane.add(new Label("Class"));
            JTextField letterText = new JTextField(2);
            dialogPane.add(letterText);

            dialogPane.add(new Label("FullName"));
            JTextField fullnameText = new JTextField(10);
            dialogPane.add(fullnameText);

            JOptionPane.showMessageDialog(
                    null,
                    dialogPane,
                    "Set Student Data",
                    JOptionPane.PLAIN_MESSAGE);

            if (
                    letterText.getText().isEmpty()
                            || letterText.getText().length() != 1
                            || yearText.getText().isEmpty()
                            || fullnameText.getText().isEmpty()
            ) {
                JOptionPane.showMessageDialog(
                        null,
                        "Dati inseriti non validiti",
                        "Errore inserimento dati",
                        JOptionPane.ERROR_MESSAGE
                );
            }

            int parYear = Integer.parseInt(yearText.getText());
            char parLetter = letterText.getText().charAt(0);
            String parFullname = fullnameText.getText();
            student.addStudent(parYear, parLetter, parFullname);

        });

        removeStudentButton.addActionListener(e -> {
                student.removeStudent(studentList.getSelectedIndex());
        });

        //---------------------------
        gradesListModel = new DefaultListModel<>();

        JList<String> gradesList = new JList<>(gradesListModel);
        gradesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        centerPane.add(new JScrollPane(gradesList));

        JButton addGradeButton = new JButton("Add Grade");
        centerPane.add(addGradeButton);

        JButton removeGradeButton = new JButton("Remove Grade");
        centerPane.add(removeGradeButton);

        addGradeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String grade = JOptionPane.showInputDialog("Voto");
                student.addGrade(Integer.parseInt(grade));
            }
        });

        removeGradeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                student.removeGrade(gradesList.getSelectedIndex());
            }
        });

        // register button action
        updateButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                JPanel dialogPane = new JPanel();

                dialogPane.add(new Label("Year"));
                JTextField yearText = new JTextField(4);
                dialogPane.add(yearText);

                dialogPane.add(new Label("Class"));
                JTextField letterText = new JTextField(2);
                dialogPane.add(letterText);

                dialogPane.add(new Label("FullName"));
                JTextField fullnameText = new JTextField(10);
                dialogPane.add(fullnameText);

                JOptionPane.showMessageDialog(
                        null,
                        dialogPane,
                        "Set Student Data",
                        JOptionPane.PLAIN_MESSAGE);

                if (
                        letterText.getText().isEmpty()
                                || letterText.getText().length() != 1
                        || yearText.getText().isEmpty()
                        || fullnameText.getText().isEmpty()
                ) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Dati inseriti non validiti",
                            "Errore inserimento dati",
                            JOptionPane.ERROR_MESSAGE
                    );
                }

                student.onUpdateYear(Integer.parseInt(yearText.getText()));
                student.onUpdateLetter(letterText.getText().charAt(0));
                student.onUpdateFullname(fullnameText.getText());
            }
        });


        setVisible(true);
    }

    public void onUpdateYear(int year) {
        yearLabel.setText("Year: " + year);
    }

    public void onUpdateLetter(char letter) {
        letterLabel.setText("Class: " + letter);
    }

    public void onUpdateFullname(String fullname) {
        fullnameLabel.setText(fullname);
    }

    public void onUpdateGrades(ArrayList<Integer> grades) {

        gradesListModel.clear();
        for (Integer grade : grades){
            gradesListModel.addElement(grade.toString());
        }
    }

    public void onUpdateStudents (ArrayList<Student> students) {
        studentListModel.clear();
        for (Student student : students){
            studentListModel.addElement(student.toString());

        }
    }
}
