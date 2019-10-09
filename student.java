package 练习2;

public class student {
    public String Stuid;
    public String Stuname;
    public String Stuclass;
    public int Stuage;
    public int Stuadsc;
    public String Remark;
	public String getStuid() {
		return Stuid;
	}
	public void setStuid(String stuid) {
		Stuid = stuid;
	}
	public String getStuname() {
		return Stuname;
	}
	public void setStuname(String stuname) {
		Stuname = stuname;
	}
	public String getStuclass() {
		return Stuclass;
	}
	public void setStuclass(String stuclass) {
		Stuclass = stuclass;
	}
	public int getStuage() {
		return Stuage;
	}
	public void setStuage(int stuage) {
		Stuage = stuage;
	}
	public int getStuadsc() {
		return Stuadsc;
	}
	public void setStuadsc(int stuadsc) {
		Stuadsc = stuadsc;
	}
	public String getRemark() {
		return Remark;
	}
	public void setRemark(String remark) {
		Remark = remark;
	}
    public student() {
    	
    }
    public student(String aStuid,String aStuname,
    		String aStuclass,int aStuage,int aStuadsc,
    		String aRemark) {
    	this.Stuid=aStuid;
    	this.Stuname=aStuname;
    	this.Stuclass=aStuclass;
    	this.Stuage=aStuage;
    	this.Stuadsc=aStuadsc;
    	this.Remark=aRemark;
    }
    
}
