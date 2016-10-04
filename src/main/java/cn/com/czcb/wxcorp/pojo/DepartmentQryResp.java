package cn.com.czcb.wxcorp.pojo;

import java.util.List;


public class DepartmentQryResp {

    private int errcode;
    private String errmsg;
    private List<Department> department;
    public void setErrcode(int errcode) {
         this.errcode = errcode;
     }
     public int getErrcode() {
         return errcode;
     }

    public void setErrmsg(String errmsg) {
         this.errmsg = errmsg;
     }
     public String getErrmsg() {
         return errmsg;
     }

    public void setDepartment(List<Department> department) {
         this.department = department;
     }
     public List<Department> getDepartment() {
         return department;
     }

}