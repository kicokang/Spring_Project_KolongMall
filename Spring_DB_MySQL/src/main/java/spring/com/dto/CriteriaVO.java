package spring.com.dto;

public class CriteriaVO {

    // ������ ��ȣ
    private int nowPage;
    // ������ �� �Խù� ����
    private int pagePerRow;
    private String search;
    private int limit1;

    // �⺻������ : 1������, ������ �� �Խù� ���� 5���� �ʱ�ȭ
    public CriteriaVO() {
        this.nowPage = 1;
        this.pagePerRow = 5;
    }
    public CriteriaVO(String search, int nowPage ,int pagePerRow) {
        this.nowPage = nowPage;
        this.pagePerRow = pagePerRow;
        this.setSearch(search);
    }


    // ������ ��ȣ ��ȿ�� üũ
    public void setNowPage(int page) {
        if (page <= 0) {
            this.nowPage = 1;
            return;
        }
        this.nowPage = page;
    }

    // ������ �� �Խù� ���� ��ȿ�� üũ
    public void setPagePerRow(int pagePerRow) {
        if (pagePerRow <= 0 || pagePerRow > 100) {
            this.pagePerRow =5;
            return;
        }
        this.pagePerRow = pagePerRow;
    }

    public int getNowPage() {
        return nowPage;
    }

    // for MyBatis SQL Mapper
    public int getPagePerRow() {
        return this.pagePerRow;
    }

    // for MyBatis SQL Mapper
    // ������ �� ���۹�ȣ
    public int getPaging() {
        return (this.nowPage - 1) * pagePerRow;
    }

    @Override
    public String toString() {
        return "Criteria{" +
                "nowPage=" + nowPage +
                ", pagePerRow=" + pagePerRow +
                '}';
    }
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	
	public int getNumOfPage(int totalRow) {
		
		int numOfPage=0;
		if((totalRow % pagePerRow)!=0) {
			numOfPage = (totalRow / pagePerRow)+1;
		}else {
			numOfPage = (totalRow / pagePerRow);
		}
		
		return numOfPage;	
	}
	public void setLimit1() {
		this.limit1=(nowPage - 1) * pagePerRow;
	}

}