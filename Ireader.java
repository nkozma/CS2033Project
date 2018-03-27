package project.group2.system.njk;

import java.util.ArrayList;

public interface Ireader {
	public String read(String name, String findField);
	public ArrayList<String> readField(String field);
}
