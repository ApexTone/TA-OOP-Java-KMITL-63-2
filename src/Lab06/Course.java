package Lab06;
/*
* Testcase
* drop student that doesn't in the class
* dropStudent one by one vs clear must display same thing
* extending array
* */
public class Course {
    //Refer from the picture in this link https://che.gg/3u7FhxJ
    private String courseName;
    private String[] students = new String[100];
    private int numberOfStudents;

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public void addStudent(String student){
        if(numberOfStudents == students.length){
            String[] newStudents = new String[students.length*2];
            for(int i=0;i<students.length;i++){
                newStudents[i] = students[i];
            }
            students = newStudents;
        }
        students[numberOfStudents++] = student;
    }

    public String getCourseName() {
        return courseName;
    }
    public String getStudentsList() {
        if(numberOfStudents == 0){
            return "No student in this course";
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<numberOfStudents;i++){
            sb.append(students[i]);
            sb.append(" ");
        }
        return sb.toString();
    }

    public void dropStudent(String student){
        for(int i=0;i<students.length;i++){
            if(student.equals(this.students[i])){
                if(numberOfStudents == 1){
                    students[i] = null;
                }
                else {
                    for (int j = i + 1; j < students.length; j++) {
                        students[j - 1] = students[j];
                    }
                }
                numberOfStudents--;
                break;
            }
        }
    }
    public void clear(){
        this.students = new String[100];
        this.numberOfStudents = 0;
    }


    public static void main(String[] args) {
        Course course = new Course("Object-Oriented Programming");
        System.out.println("---ADD---");
        course.addStudent("S1");
        course.addStudent("S2");
        course.addStudent("S3");
        System.out.println(course.getStudentsList());
        System.out.println("---DROP---");
        course.dropStudent("NOT FOUND1");
        course.dropStudent("S1");
        course.dropStudent("S2");
        course.dropStudent("S3");
        course.dropStudent("NOT FOUND2");
        System.out.println(course.getStudentsList());

        System.out.println("---ADD 2---");
        course.addStudent("S1");
        course.addStudent("S2");
        course.addStudent("S3");
        System.out.println(course.getStudentsList());
        System.out.println("---CLEAR---");
        course.clear();
        System.out.println(course.getStudentsList());
    }
}
