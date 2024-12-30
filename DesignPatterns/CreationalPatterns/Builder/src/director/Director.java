package director;

import builder.EngineeringStudentBuilder;
import builder.MbbsStudentBuilder;
import builder.StudentBuilder;
import model.Student;

public class Director {

	StudentBuilder studentBuilder;

	public Director(StudentBuilder studentBuilder) {
		this.studentBuilder = studentBuilder;
	}

	public Student createStudent() {
		if (studentBuilder instanceof EngineeringStudentBuilder) {
			return createEngineeringStudent();
		} else if (studentBuilder instanceof MbbsStudentBuilder) {
			return createMBAStudent();
		}
		return null;
	}

	private Student createEngineeringStudent() {
		return studentBuilder.setAge(20).setFatherName("Madhava Reddy").setFirstName("Rohith")
				.setMotherName("Varalakshmi").setRollNumber(3).setSubjects().build();
	}

	private Student createMBAStudent() {
		return studentBuilder.setFatherName("Madhava Reddy").setFirstName("Rohith").setMotherName("Varalakshmi")
				.setRollNumber(3).setLastName("Sangati").setSubjects().build();
	}

}
