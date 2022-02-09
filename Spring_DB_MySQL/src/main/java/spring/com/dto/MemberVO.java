package spring.com.dto;

public class MemberVO {
	 
    private int m_num;
    private String id;
    private String pw;
    private String name;
    private String address;
    
    public MemberVO() {
    	
    }
	public MemberVO(int m_num,String id, String pw, String name, String address) {
		this.m_num=m_num;
		this.id=id;
		this.pw=pw;
		this.name=name;
		this.address=address;
	}
	//°´Ã¼ Ãâ·Â
	@Override
	public String toString()
	{
		return this.m_num + " " + this.id + " " + this.pw + " " + this.name + " " +  this.address;
	}
	public int getM_num() {
		return m_num;
	}
	public void setM_num(int m_num) {
		this.m_num = m_num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
   
}
