package com.xuehai.model;

import java.util.List;

public class TestCase {
	private String name;
	private List<Entity> entityList;
	private CaseResult result;
	
	public enum CaseResult {PASS, FAIL, SKIP}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Entity> getEntityList() {
		return entityList;
	}

	public void setEntityList(List<Entity> entityList) {
		this.entityList = entityList;
	}

	public CaseResult getResult() {
		return result;
	}

	public void setResult(CaseResult result) {
		this.result = result;
	}

	@Override
	public String toString() {
		StringBuilder entities=new StringBuilder("[");
		for (Entity entity : entityList) {
			entities.append(entity.toString()).append(", ");
		}
		entities.append("]");
		int last=entities.lastIndexOf(",]");
		entities.replace(last, last+1, "");
		return "TestCase [name=" + name + ", entity=" + entities + ", result=" + result + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((entityList == null) ? 0 : entityList.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((this.result == null) ? 0 : this.result.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TestCase other = (TestCase) obj;
		if (entityList == null) {
			if (other.entityList != null)
				return false;
		} else if (!entityList.equals(other.entityList))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (result != other.result)
			return false;
		return true;
	}
	
}
