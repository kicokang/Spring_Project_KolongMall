package spring.com.dto;

public class CriteriaVO {

    // 페이지 번호
    private int nowPage;
    // 페이지 당 게시물 갯수
    private int pagePerRow;
    private String search;
    private int limit1;

    // 기본생성자 : 1페이지, 페이지 당 게시물 갯수 5으로 초기화
    public CriteriaVO() {
        this.nowPage = 1;
        this.pagePerRow = 5;
    }
    public CriteriaVO(String search, int nowPage ,int pagePerRow) {
        this.nowPage = nowPage;
        this.pagePerRow = pagePerRow;
        this.setSearch(search);
    }


    // 페이지 번호 유효성 체크
    public void setNowPage(int page) {
        if (page <= 0) {
            this.nowPage = 1;
            return;
        }
        this.nowPage = page;
    }

    // 페이지 당 게시물 갯수 유효성 체크
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
    // 페이지 블럭 시작번호
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