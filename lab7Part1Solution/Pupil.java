package lab7Part1Solution;

import org.w3c.dom.ls.LSOutput;

public class Pupil extends User{
    public Pupil(int id, String name, String surname, String group) {
        super(id, name, surname, group);
    }
    public void check() {
        System.out.println("Its pupil");
    }
}
