package entity;

import java.util.Base64;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="files")
public class Files {
	
	@Id
	@GeneratedValue
	private int Id;
	
	@Column
	private String username;
	
	@Column
	private String path;
	
	@Column
	private byte[] pic;
	
	
	@Transient
	private String showTrophy;
	
	public void setShowTrophy(String tro) {
		this.showTrophy= tro;
	}
	public String getShowTrophy() {
		return showTrophy;
	}
	public String showTrophy()
	{
	    String encoded = "";
	    if(pic != null && pic.length>0){
	            encoded = Base64.getEncoder().encodeToString(pic);
	      }
	     return encoded;
	}
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public byte[] getPic() {
		return pic;
	}
	public void setPic(byte[] pic) {
		this.pic = pic;
	}
	
	
}
