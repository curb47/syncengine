package com.percero.agents.sync.metadata;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MappedClassManager implements IMappedClassManager {

	private Map<String, MappedClass> mappedClassesByName = new HashMap<String, MappedClass>();

	public void addMappedClass(MappedClass theMappedClass) {
		if (!mappedClassesByName.containsKey(theMappedClass.className))
			mappedClassesByName.put(theMappedClass.className, theMappedClass);
	}

	public MappedClass getMappedClassByClassName(String aClassName) {
		MappedClass mc = mappedClassesByName.get(aClassName);
		if (mc == null) {
			Random rnd = new Random();
			mc = new MappedClass(rnd.nextInt(), aClassName);
			addMappedClass(mc);
		}
		
		return mc;
	}

}
