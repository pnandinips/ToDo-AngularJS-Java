package org.todo.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;


public class ToDoItem {
	
	
	private Long id;
	
	private String toDo;
	

	private String listName;
	
	
	private String tag;
	
	
	private boolean completed;
	
	@DateTimeFormat(iso=ISO.DATE)
	Date reminder; 
		
	public String getToDo() {
		return toDo;
	}

	public void setToDo(String toDo) {
		this.toDo = toDo;
	}

	public String getTag() {
		return tag;
	}
	
	public void setTag(String tag) {
		this.tag = tag;
	}
	
	public boolean isCompleted() {
		return completed;
	}
	
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	
	public Date getReminder() {
		return reminder;
	}

	public void setReminder(Date reminder) {
		this.reminder = reminder;
	}	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((toDo == null) ? 0 : toDo.hashCode());
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
		ToDoItem other = (ToDoItem) obj;
		if (toDo == null) {
			if (other.toDo != null)
				return false;
		} else if (!toDo.equals(other.toDo))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "ToDoItem [item=" + toDo + ", list= "+ listName + ",tag= " + tag
				+ ", completed=" + completed + "]";
	}
}
