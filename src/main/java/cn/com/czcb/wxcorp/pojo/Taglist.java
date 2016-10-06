package cn.com.czcb.wxcorp.pojo;

public class Taglist {

    private int tagid;
    private String tagname;
    public void setTagid(int tagid) {
         this.tagid = tagid;
     }
     public int getTagid() {
         return tagid;
     }

    public void setTagname(String tagname) {
         this.tagname = tagname;
     }
     public String getTagname() {
         return tagname;
     }
	@Override
	public String toString() {
		return "Taglist [tagid=" + tagid + ", tagname=" + tagname + "]";
	}

     
}
