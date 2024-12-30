package builder;

import java.util.List;

import model.Student;

public abstract class StudentBuilder {

	public int rollNumber;
	public int age;
	public String firstName;
	public String lastName;
	public String middleName;
	public String motherName;
	public String fatherName;
	public List<String> subjects;

	public StudentBuilder setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
		return this;
	}

	public StudentBuilder setAge(int age) {
		this.age = age;
		return this;
	}

	public StudentBuilder setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public StudentBuilder setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public StudentBuilder setMiddleName(String middleName) {
		this.middleName = middleName;
		return this;
	}

	public StudentBuilder setMotherName(String motherName) {
		this.motherName = motherName;
		return this;
	}

	public StudentBuilder setFatherName(String fatherName) {
		this.fatherName = fatherName;
		return this;
	}

	public abstract StudentBuilder setSubjects();

	public Student build() {
		return new Student(this);
	}

}
