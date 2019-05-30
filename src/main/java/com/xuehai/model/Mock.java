package com.xuehai.model;

import com.xuehai.util.Utils;
import org.mockserver.model.Parameter;

import java.util.List;

public class Mock {
	private boolean isMock;
	private String method;
	private String path;
	private List<Parameter> parameters;
	private String requestBody;
	private int responseCode;
	private String responseData;
	
	public boolean isMock() {
		return isMock;
	}
	public void setMock(boolean isMock) {
		this.isMock = isMock;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public List<Parameter> getParameters() {
		return parameters;
	}
	public void setParameters(List<Parameter> parameters) {
		this.parameters = parameters;
	}
	public String getRequestBody() {
		return requestBody;
	}
	public void setRequestBody(String requestBody) {
		this.requestBody = requestBody;
	}
	public int getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}
	public String getResponseData() {
		return responseData;
	}
	public void setResponseData(String responseData) {
		this.responseData = responseData;
	}
	
	@Override
	public String toString() {
		StringBuilder parametersContent = new StringBuilder("[");
		for (Parameter parameter : parameters) {
			parametersContent.append("{")
				.append(parameter.getName())
				.append(":")
				.append(parameter.getValues())
				.append("},");
		}
		parametersContent.append("]");
		return "Mock [isMock=" + isMock + ", method=" + method + ", path=" + path + ", parameters=" + Utils.format(parametersContent)
				+ ", requestBody=" + requestBody + ", responseCode=" + responseCode + ", responseData=" + responseData
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (isMock ? 1231 : 1237);
		result = prime * result + ((method == null) ? 0 : method.hashCode());
		result = prime * result + ((parameters == null) ? 0 : parameters.hashCode());
		result = prime * result + ((path == null) ? 0 : path.hashCode());
		result = prime * result + ((requestBody == null) ? 0 : requestBody.hashCode());
		result = prime * result + responseCode;
		result = prime * result + ((responseData == null) ? 0 : responseData.hashCode());
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
		Mock other = (Mock) obj;
		if (isMock != other.isMock)
			return false;
		if (method == null) {
			if (other.method != null)
				return false;
		} else if (!method.equals(other.method))
			return false;
		if (parameters == null) {
			if (other.parameters != null)
				return false;
		} else if (!parameters.equals(other.parameters))
			return false;
		if (path == null) {
			if (other.path != null)
				return false;
		} else if (!path.equals(other.path))
			return false;
		if (requestBody == null) {
			if (other.requestBody != null)
				return false;
		} else if (!requestBody.equals(other.requestBody))
			return false;
		if (responseCode != other.responseCode)
			return false;
		if (responseData == null) {
			if (other.responseData != null)
				return false;
		} else if (!responseData.equals(other.responseData))
			return false;
		return true;
	}
	
}
