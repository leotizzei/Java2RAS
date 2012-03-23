package parser.impl;

import java.util.HashMap;

import parser.spec.prov.IManager;
import parser.spec.prov.IParserMgt;



class Manager implements IManager {

	private HashMap<String,Object> providedInterfaces;
	private HashMap<String,Object> requiredInterfaces;
	private String[] listReqInt;
	private String[] listProvInt;
	
	Manager(){
		this.providedInterfaces = new HashMap<String,Object>();
		this.requiredInterfaces = new HashMap<String,Object>();
		IParserMgt icc =  new Facade();
		this.setProvidedInterface("IParserMgt",icc);
		
		
		String[] listProv = new String[1];
		listProv[0] = "IParserMgt";
		this.setProvidedInterfaces(listProv);
		this.setRequiredInterfaces(null);
		
	}
	
	public String[] getProvidedInterfaces() {

		return this.listProvInt;
	}

	public void setProvidedInterface(String typeName, Object facade) {
		this.providedInterfaces.put(typeName,facade);

	}

	public void setProvidedInterfaces(String[] interfaces) {
		this.listProvInt = interfaces;

	}

	public String[] getRequiredInterfaces() {
		return this.listReqInt;
	}

	public Object getProvidedInterface(String name) {
		
		return this.providedInterfaces.get(name);
	}

	public void setRequiredInterface(String name, Object facade) {
		this.requiredInterfaces.put(name,facade);

	}

	public void setRequiredInterfaces(String[] interfaces) {
		this.listReqInt = interfaces;

	}

	public Object getRequiredInterface(String name) {
		
		return this.requiredInterfaces.get(name);
	}

	
	
}
