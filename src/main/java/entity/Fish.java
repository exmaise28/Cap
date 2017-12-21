package entity;

import java.util.Base64;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;



@Entity
@Table(name="fish")
public class Fish {
	@Id
	@Column
	private String fishName;
	@Column
	private String fishInfo;
	@Column
	private String fishPicPath;
	@Column
	private byte[] fishPic;
	
	@Transient
	private String showPicture;
	
	public void setShowPicture(String pic) {
		this.showPicture = pic;
	}
	public String getShowPicture() {
		return showPicture;
	}
	public String getFishName() {
		return fishName;
	}
	public void setFishName(String fishName) {
		this.fishName = fishName;
	}
	public String getFishInfo() {
		return fishInfo;
	}
	public void setFishInfo(String fishInfo) {
		this.fishInfo = fishInfo;
	}
	public byte[] getFishPic() {
		return fishPic;
	}
	public void setFishPic(byte[] fishPic) {
		this.fishPic = fishPic;
	}
	
	public String getFishPicPath() {
		return fishPicPath;
	}
	public void setFishPicPath(String fishPicPath) {
		this.fishPicPath = fishPicPath;
	}
	public String showPicture()
	{
	    String encoded = "";
	    if(fishPic != null && fishPic.length>0){
	            encoded = Base64.getEncoder().encodeToString(fishPic);
	      }
	     return encoded;
	}
	
	@Override
	public String toString() {
		return "Fish [fishName=" + fishName + ", fishInfo=" + fishInfo + ", fishPic=" + fishPic + "]";
	
	}
}
