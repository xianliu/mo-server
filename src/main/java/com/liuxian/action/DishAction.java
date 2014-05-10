package com.liuxian.action;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;
import com.liuxian.inject.service.DishServiceImpl;
import com.liuxian.model.Dish;
import com.opensymphony.xwork2.ActionContext;

@Controller("dishAction")
public class DishAction {
	@Autowired
	private Gson gson;
	
	private int id;
	
	private int groupId;
	
	private String name;
	
	private String imageName;
	
	private String price;
	
	private File uploadImage;

	private String uploadImageContentType;
	
	private String 	uploadImageFileName;
	
	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getUploadImageContentType() {
		return uploadImageContentType;
	}

	public void setUploadImageContentType(String uploadImageContentType) {
		this.uploadImageContentType = uploadImageContentType;
	}

	public String getUploadImageFileName() {
		return uploadImageFileName;
	}

	public void setUploadImageFileName(String uploadImageFileName) {
		this.uploadImageFileName = uploadImageFileName;
	}

	public File getUploadImage() {
		return uploadImage;
	}
	
	public void setUploadImage(File uploadImage) {
		this.uploadImage = uploadImage;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Autowired
	private DishServiceImpl dishService;
	
	
	public String add() {
		Dish dish = new Dish();
		dish.setGroup_id(groupId);
		dish.setName(name);
		dish.setPrice(price);
		dish.setUpdate_time(new Date());
		dish.setImageName(imageName);
		dishService.add(dish);
		return "refreshList";
	}
	
	public String update() {
		Dish dish = new Dish();
		dish.setId(id);
		dish.setGroup_id(groupId);
		dish.setName(name);
		dish.setPrice(price);
		dish.setUpdate_time(new Date());
		dish.setImageName(imageName);
		dishService.update(dish);
		return "refreshList";
	}
	
	public String list() {
		List<Dish> dishList = dishService.list(groupId);
		ActionContext.getContext().put("dishList", dishList);
		return "dishList";
	}
	
	public String remove() {
		Dish dish = dishService.get(id);
		File image = new File(dish.getImageName());
		
		if(image.isFile() && image.exists()) {
			image.delete();
		}
		
		dishService.remove(id);
		return "refreshList";
	}
	
	public void uploadImage() throws IOException {
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext().get(
						org.apache.struts2.StrutsStatics.HTTP_RESPONSE);
		response.setContentType("application/json; charset=utf-8");
		String realPath = ServletActionContext.getServletContext().getRealPath("/upload");
		int i = uploadImageFileName.lastIndexOf(".");
		String extention = uploadImageFileName.substring(i);
		String imageFileName = UUID.randomUUID().toString() + extention;
		System.out.println("realpath：" + realPath);
		if(uploadImage != null ) {
			// set the target file name
			File saveFile = new File(new File(realPath), imageFileName);
			if(!saveFile.getParentFile().exists()) {
				saveFile.getParentFile().mkdirs();
			}
			
			FileUtils.copyFile(uploadImage, saveFile);
		}
		
		Writer out;
		try {
			out = response.getWriter();
			out.write(gson.toJson(imageFileName));
			System.out.println(gson.toJson(imageFileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void get() {
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext().get(
						org.apache.struts2.StrutsStatics.HTTP_RESPONSE);
		Dish dish = dishService.get(id);
		response.setContentType("application/json; charset=utf-8");
		Writer out;
		try {
			out = response.getWriter();
			out.write(gson.toJson(dish));
			System.out.println(gson.toJson(dish));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
