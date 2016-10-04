package cn.com.czcb.wxcorp.pojo;


/**
 * Auto-generated: 2016-10-03 22:44:41
 *
 * @author www.jsons.cn 
 * @website http://www.jsons.cn/json2java/ 
 */
public class Department {

    private int id;
    private String name;
    private int parentid;
    private int order;
    public void setId(int id) {
         this.id = id;
     }
     public int getId() {
         return id;
     }

    public void setName(String name) {
         this.name = name;
     }
     public String getName() {
         return name;
     }

    public void setParentid(int parentid) {
         this.parentid = parentid;
     }
     public int getParentid() {
         return parentid;
     }

    public void setOrder(int order) {
         this.order = order;
     }
     public int getOrder() {
         return order;
     }
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", parentid="
				+ parentid + ", order=" + order + "]";
	}
     
     

}