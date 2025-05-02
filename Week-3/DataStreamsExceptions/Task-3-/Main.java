import java.io.*;

class Student implements Serializable {
    private int id;
    private String name;
    private int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return "Student ID: " + id + ", Name: " + name + ", Age: " + age;
    }
}

class Course implements Serializable {
    private String courseCode;
    private String courseName;
    private String instructor;

    public Course(String courseCode, String courseName, String instructor) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.instructor = instructor;
    }

    public String toString() {
        return "Course Code: " + courseCode + ", Name: " + courseName + ", Instructor: " + instructor;
    }
}

class Enrollment implements Serializable {
    private Student student;
    private Course course;
    private String enrollmentDate;

    public Enrollment(Student student, Course course, String enrollmentDate) {
        this.student = student;
        this.course = course;
        this.enrollmentDate = enrollmentDate;
    }

    public String toString() {
        return "Enrollment Date: " + enrollmentDate + "\n" + student.toString() + "\n" + course.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        // إنشاء كائنات الطالب والدورة الدراسية والتسجيل
        Student student = new Student(1, "Ahmed", 20);
        Course course = new Course("CS101", "Introduction to Computer Science", "Dr. Ali");
        Enrollment enrollment = new Enrollment(student, course, "2023-01-15");

        // تسلسل الكائن (حفظه في الملف)
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("enrollments.ser"))) {
            oos.writeObject(enrollment);
            System.out.println("تم حفظ التسجيل في ملف enrollments.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // قراءة الكائن (إلغاء التسلسل)
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("enrollments.ser"))) {
            Enrollment deserializedEnrollment = (Enrollment) ois.readObject();
            System.out.println("تم قراءة التسجيل من الملف: \n" + deserializedEnrollment);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
