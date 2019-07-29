package com.boylab.roomhelp.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.TextView;

/**
 * Author pengle on 2019/7/29 10:45
 * Email  pengle609@163.com
 */
@Entity(foreignKeys = @ForeignKey(entity = Student.class,
                                parentColumns = {"student_id"},
                                childColumns = {"name"}))
public class Teacher {

    @PrimaryKey(autoGenerate = true)
    private long teacher_id;

    @NonNull
    private String name;
    private int age;
    private String sex;
    private String course;

    public long getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(long teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
