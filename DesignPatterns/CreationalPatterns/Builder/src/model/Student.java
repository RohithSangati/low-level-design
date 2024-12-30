package model;

import java.util.List;

import builder.StudentBuilder;

public class Student {

	int rollNumber;
	int age;
	String firstName;
	String lastName;
	String middleName;
	String motherName;
	String fatherName;
	List<String> subjects;

	public Student(StudentBuilder studentBuilder) {
		this.rollNumber = studentBuilder.rollNumber;
		this.age = studentBuilder.age;
		this.firstName = studentBuilder.firstName;
		this.lastName = studentBuilder.lastName;
		this.middleName = studentBuilder.middleName;
		this.motherName = studentBuilder.motherName;
		this.fatherName = studentBuilder.fatherName;
		this.subjects = studentBuilder.subjects;
	}

	public String toString() {
		return "Student : Firstname - " + this.firstName + "\nLastname - " + this.lastName + "\nMiddelname - "
				+ this.middleName + "\nMothername -" + this.motherName + "\nFathername -" + this.fatherName
				+ "\nRollnumber -" + this.rollNumber + "\nAge -" + this.age + "\nSubjects -"+(this.subjects.toString());
	}

}
