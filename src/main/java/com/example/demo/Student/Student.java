package com.example.demo.Student;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator(
        name = "student_sequence",
        sequenceName = "student_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "student_sequence"
    )
    private long id;
    private String regno;
    private String name;
    private int room;
    private String block;
    private long phno;
    
    //all fields except id
    public Student(String regno, String name, String block, int room, long phno) {
        this.regno = regno;
        this.name = name;
        this.block = block;
        this.room = room;
        this.phno = phno;
    }
    //all fields
    public Student(long id, String regno, String name, String block, int room, long phno) {
        this.id = id;
        this.regno = regno;
        this.name = name;
        this.block = block;
        this.room = room;
        this.phno = phno;
    }
    //empty
    public Student() {
    }

    public long getId(){
        return this.id;
    }

    public String getRegno() {
        return this.regno;
    }

    public void setRegno(String regno) {
        this.regno = regno;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoom() {
        return this.room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public String getBlock() {
        return this.block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public long getPhno() {
        return this.phno;
    }

    public void setPhno(long phno) {
        this.phno = phno;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", regno='" + getRegno() + "'" +
            ", name='" + getName() + "'" +
            ", room='" + getRoom() + "'" +
            ", block='" + getBlock() + "'" +
            ", phno='" + getPhno() + "'" +
            "}";
    }


}

