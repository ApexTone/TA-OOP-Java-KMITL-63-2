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
    public String[] getStudents() {
        return students;
    }

    public void dropStudent(String student){
        for(int i=0;i<students.length;i++){
            if(this.students[i].equals(student)){
                for(int j=i+1;j<students.length;i++){
                    students[i-1] = students[i];
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
        Course course = new Course("");
    }
}
