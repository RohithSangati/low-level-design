package builder;

import java.util.ArrayList;
import java.util.List;

public class MbbsStudentBuilder extends StudentBuilder {

	@Override
	public StudentBuilder setSubjects() {
		List<String> subs = new ArrayList<>();
		subs.add("Human Body");
		subs.add("Nervous System");
		subs.add("Cardiology");
		this.subjects = subs;
		return this;
	}

}
