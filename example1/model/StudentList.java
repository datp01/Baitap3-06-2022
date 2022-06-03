package Test.com.example.model;

import Test.com.example.entity.Student;

import java.util.*;

public class StudentList {
    private HashSet<Student> list;
    private int length;
    public StudentList() {
        list = new HashSet<Student>();
    }
    public HashSet<Student> findByName(String name) {
        boolean found = false;
        HashSet<Student> matches = new HashSet<>();
        for(Student s: list) {
            String fullName = new String(s.getFirstName() + " " + s.getLastName()).toLowerCase(Locale.ROOT);
            if(fullName.matches("(.*)" + name.toLowerCase() + "(.*)")) {
                matches.add(s);
                found = true;
            }
        }
        if (found == false) {
            System.out.println("Not Found");
        }
        return matches;
    }
    public Student findById(String id) {
        for (Student s:list) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }
    public void add(Student s) {
        list.add(s);
    }
    public void remove(String id) {
        boolean found = false;
        for(Student s:list) {
            if(s.getId() == id) {
                int choice;
                System.out.println("Are you sure deleting this student?(1.Yes 2.No)");
                choice = new Scanner(System.in).nextInt();
                if(choice == 1)
                    list.remove(s);
                found = true;
            }
        }
        if(found == false) {
            System.out.println("Can not find student with id " + id);
        }
    }

    public void showList(HashSet<Student> slist) {
        for (Student s: slist) {
            s.printInfo();
        }
    }

//    public boolean deleteStudent(String id) {
//        Document doc = this.doc.stream()
//                .filter(document -> document.getId().equals(id))
//                .findFirst().orElse(null);
//        if (doc == null) {
//            return false;
//        }
//        this.documents.remove(doc);
//        return true;
//    }

    public boolean removeById(String id) {
        Student student= this.list.stream()
                .filter(student1 -> student1.getId().equals(id))
                .findFirst().orElse(null);
        if (student == null) {
            return false;
        }
        this.list.remove(student);
        return true;

    }
}
