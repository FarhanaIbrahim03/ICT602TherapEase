package com.example.therapease2;

public class Aboutus {
    private String name, group, studentId, course;
    private int imageResId;

    public Aboutus(String name, String group, String studentId, String course, int imageResId) {
        this.name = name;
        this.group = group;
        this.studentId = studentId;
        this.course = course;
        this.imageResId = imageResId;
    }

    public String getName() { return name; }
    public String getGroup() { return group; }
    public String getStudentId() { return studentId; }
    public String getCourse() { return course; }
    public int getImageResId() { return imageResId; }
}
