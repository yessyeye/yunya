package com.xuehai.model;

import com.xuehai.util.Utils;

import java.util.Map;

public class Entity {
	private String id;
	private String description;
	private String domain;
	private String url;
	private String urlParam;
	private String method;
	private Map<String,String> header;
	private String queryString;
	private String bodyData;
	private String assertion;
	private String authToken;
	private boolean sign;
	private Mock mock;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String descrption) {
		this.description = descrption;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getDomain() {
		return domain;
	}
	
	public void setDomain(String domain) {
		this.domain = domain;
	}
	
	public String getUrlParam() {
		return urlParam;
	}
	
	public void setUrlParam(String urlParam) {
		this.urlParam = urlParam;
	}
	
	public String getMethod() {
		return method;
	}
	
	public void setMethod(String method) {
		this.method = method;
	}
	
	public Map<String, String> getHeader() {
		return header;
	}
	
	public void setHeader(Map<String, String> header) {
		this.header = header;
	}
	
	public String getQueryString() {
		return queryString;
	}
	
	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}
	
	public String getBodyData() {
		return bodyData;
	}
	
	public void setBodyData(String bodyData) {
		this.bodyData = bodyData;
	}

	public String getAssertion() {
		return assertion;
	}

	public void setAssertion(String assertion) {
		this.assertion = assertion;
	}

	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	public boolean needSign() {
		return sign;
	}

	public void setSign(boolean sign) {
		this.sign = sign;
	}

	public Mock getMock() {
		return mock;
	}

	public void setMock(Mock mock) {
		this.mock = mock;
	}
	
	


	@Override
	public String toString() {
		StringBuilder headerContent = new StringBuilder("[");
		for (Map.Entry<String, String> entry : header.entrySet()) {
			headerContent.append(entry.getKey())
				.append("=")
				.append(entry.getValue())
				.append(",");
		}
		headerContent.append("]");
		return "Entity [id=" + id + ", description=" + description + ", domain=" + domain + ", url=" + url
				+ ", urlParam=" + urlParam + ", method=" + method + ", header=" + Utils.format(headerContent) 
				+ ", queryString=" + queryString + ", bodyData=" + bodyData + ", assertion=" + assertion 
				+ ", authToken=" + authToken + ", sign=" + sign + ", mock=" + mock + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((assertion == null) ? 0 : assertion.hashCode());
		result = prime * result + ((authToken == null) ? 0 : authToken.hashCode());
		result = prime * result + ((bodyData == null) ? 0 : bodyData.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((domain == null) ? 0 : domain.hashCode());
		result = prime * result + ((header == null) ? 0 : header.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((method == null) ? 0 : method.hashCode());
		result = prime * result + ((mock == null) ? 0 : mock.hashCode());
		result = prime * result + ((queryString == null) ? 0 : queryString.hashCode());
		result = prime * result + (sign ? 1231 : 1237);
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		result = prime * result + ((urlParam == null) ? 0 : urlParam.hashCode());
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
		Entity other = (Entity) obj;
		if (assertion == null) {
			if (other.assertion != null)
				return false;
		} else if (!assertion.equals(other.assertion))
			return false;
		if (authToken == null) {
			if (other.authToken != null)
				return false;
		} else if (!authToken.equals(other.authToken))
			return false;
		if (bodyData == null) {
			if (other.bodyData != null)
				return false;
		} else if (!bodyData.equals(other.bodyData))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (domain == null) {
			if (other.domain != null)
				return false;
		} else if (!domain.equals(other.domain))
			return false;
		if (header == null) {
			if (other.header != null)
				return false;
		} else if (!header.equals(other.header))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (method == null) {
			if (other.method != null)
				return false;
		} else if (!method.equals(other.method))
			return false;
		if (mock == null) {
			if (other.mock != null)
				return false;
		} else if (!mock.equals(other.mock))
			return false;
		if (queryString == null) {
			if (other.queryString != null)
				return false;
		} else if (!queryString.equals(other.queryString))
			return false;
		if (sign != other.sign)
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		if (urlParam == null) {
			if (other.urlParam != null)
				return false;
		} else if (!urlParam.equals(other.urlParam))
			return false;
		return true;
	}

	
}
