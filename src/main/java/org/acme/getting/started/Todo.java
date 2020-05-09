package org.acme.getting.started;
import java.time.*;

/*
 * Version is store by a number that will be formated 
 */
public class Todo {
	long id;
	String title;
	String description;
	LocalDate expireAt;
	LocalDate createdAt;
	LocalDate updateAt;
	LocalDate doneAt;
	long version;
	
	public Todo() {
	}
	
	public Todo(String title) {
		this.title = title;
	}
	public Todo(Long id, String title) {
		this.id = id;
		this.title = title;
	}
	
	public Todo(long id, String title, String description, LocalDate expireAt, LocalDate createdAt, LocalDate updateAt,
			LocalDate doneAt, long version) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.expireAt = expireAt;
		this.createdAt = createdAt;
		this.updateAt = updateAt;
		this.doneAt = doneAt;
		this.version = version;
	}

	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String idToString() {
		return "\"id\":" + id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String titleToString() {
		return "\"Title\": \"" + title+"\"-";
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String descriptionToString() {
		return "\"Description\":" + description;
	}
	public LocalDate getExpireAt() {
		return expireAt;
	}
	public void setExpireAt(LocalDate expireAt) {
		this.expireAt = expireAt;
	}
	public String expireAtToString() {
		return "\"ExpireAt\":" + expireAt.toString();
	}
	public LocalDate getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}
	public String createdAtToString() {
		return "\"CreatedAt\":" + createdAt.toString();
	}
	public LocalDate getUpdateAt() {
		return updateAt;
	}
	public void setUpdateAt(LocalDate updateAt) {
		this.updateAt = updateAt;
	}
	public String updateAtToString() {
		return "\"updateAt\":" + updateAt.toString();
	}
	public LocalDate getDoneAt() {
		return doneAt;
	}
	public void setDoneAt(LocalDate doneAt) {
		this.doneAt = doneAt;
	}
	public String doneAtToString() {
		return "\"doneAt\":" + doneAt.toString();
	}
	public long getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public String versionToString() {
		//can be store as varchar(3) with 3 column, make it more consistent.
		return "\"version\":" + version/1000000+"."+(version%100000)/1000+"."+version%1000;
	}
	public String ToString() {
		return "{" +
			idToString()+"," + System.lineSeparator() +
			titleToString() +","+ System.lineSeparator() +
			descriptionToString()+","+ System.lineSeparator() +
			expireAtToString()+","+ System.lineSeparator() +
			createdAtToString()+","+ System.lineSeparator() +
			updateAtToString()+","+ System.lineSeparator() +
			doneAtToString()+","+ System.lineSeparator() +
			versionToString()+ System.lineSeparator() +
		"}";
	}
}
