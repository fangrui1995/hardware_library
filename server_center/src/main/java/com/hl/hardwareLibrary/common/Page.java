package com.hl.hardwareLibrary.common;

import java.util.List;

@SuppressWarnings("rawtypes")
public class Page
	{
		public long count;
	
	public int pageSize;
	
	public int page;
		
	public List data;
	
	public Page(){}
	public Page(long count, int pageSize, int page, List  data)
	{
		this.count = count;
		this.pageSize = pageSize;
		this.page = page;
		this.data = data;
	}
}

