package example.service;

public interface NameService {

	/**
	 * Check for existence of a name
	 * @param name The name to be checked
	 * @return true if the name is in the list,false otherwise.
	 */
	public boolean checkName(String name);
	
}
