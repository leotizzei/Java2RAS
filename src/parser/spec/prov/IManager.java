package parser.spec.prov;

public interface IManager {
	String[] getProvidedInterfaces();
	void setProvidedInterface(String typeName, Object facade);
	void setProvidedInterfaces(String[] interfaces);
	String[] getRequiredInterfaces();
	Object getProvidedInterface(String name);
	void setRequiredInterface(String name,Object facade);
	void setRequiredInterfaces(String[] interfaces);
	Object getRequiredInterface(String name);
}
