package com.liuxian.util;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

@Service
public class JsonP {
	@Autowired
	private Gson gson;
	
	public <T> void buildJsonp(T t, String cb, HttpServletResponse response) {
		response.setContentType("text/javascript; charset=utf-8");
		Writer out;
		try {
			out = response.getWriter();
			out.write(cb + "(");
			out.write(gson.toJson(t));
			System.out.println(gson.toJson(t));
			out.write(");");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
