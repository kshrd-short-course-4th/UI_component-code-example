package com.example.rathana.ui_components.enitiy;

import java.util.List;

/**
 * Created by RATHANA on 12/3/2017.
 */

public class StudentEnroll {

    private int studentId;
    private String className;
    private List<String> subject;
    private String startTime;
    private String endTime;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<String> getSubject() {
        return subject;
    }

    public void setSubject(List<String> subject) {
        this.subject = subject;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "StudentEnroll{" +
                "studentId=" + studentId +
                ", className='" + className + '\'' +
                ", subject=" + subject +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }
}
