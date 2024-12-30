package builder;

import java.util.ArrayList;
import java.util.List;

public class EngineeringStudentBuilder extends StudentBuilder {

	@Override
	public StudentBuilder setSubjects() {
		List<String> subs = new ArrayList<>();
		subs.add("Java");
		subs.add("Computer Networks");
		subs.add("Low Level System Desing");
		this.subjects = subs;
		return this;
	}

}
