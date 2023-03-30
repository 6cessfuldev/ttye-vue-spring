package com.kangandyuk.ttye.domain;

public class PagingVO {
    
    //paging 처리를 위한 변수
    private int totalCount; //전체 게시물 수
    private int totalPage; //전체 페이지 수
    private int currentPage; //현재 페이지
    private int blockCount; //한 페이지의  게시물의 수
    private int blockPage; //한 화면에 보여줄 페이지 수
    private int startCount; //한 페이지에서 보여줄 게시글의 시작 번호
    private int endCount; //한 페이지에서 보여줄 게시글의 끝 번호
    private int startPage; //시작 페이지
    private int endPage; //마지막 페이지

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getBlockCount() {
        return blockCount;
    }

    public void setBlockCount(int blockCount) {
        this.blockCount = blockCount;
    }

    public int getBlockPage() {
        return blockPage;
    }

    public void setBlockPage(int blockPage) {
        this.blockPage = blockPage;
    }

    public int getStartCount() {
        return startCount;
    }

    public void setStartCount(int startCount) {
        this.startCount = startCount;
    }

    public int getEndCount() {
        return endCount;
    }

    public void setEndCount(int endCount) {
        this.endCount = endCount;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    @Override
    public String toString() {
        return "PagingVO [totalCount=" + totalCount + ", totalPage=" + totalPage + ", currentPage=" + currentPage
                + ", blockCount=" + blockCount + ", blockPage=" + blockPage + ", startCount=" + startCount + ", endCount="
                + endCount + ", startPage=" + startPage + ", endPage=" + endPage + "]";
    }

    //PagingVO 생성자
    public PagingVO(int currentPage, int blockCount, int blockPage) {
        this.currentPage = currentPage;
        this.blockCount = blockCount;
        this.blockPage = blockPage;
    }

    //계산 메소드
    public void makePaging() {
        //전체 페이지 수
        totalPage = (int)Math.ceil((double)totalCount/blockCount);
        if(totalPage == 0) {
            totalPage = 1;
        }
        
        //현재 페이지가 전체 페이지 수보다 크면 전체 페이지 수로 설정
        if(currentPage > totalPage) {
            currentPage = totalPage;
        }
        
        //현재 페이지의 처음과 마지막 글의 번호 가져오기.
        startCount = (currentPage - 1) * blockCount;
        endCount = startCount + blockCount - 1;
        
        //시작 페이지와 마지막 페이지 값 구하기.
        startPage = (int)((currentPage - 1) / blockPage) * blockPage + 1;
        endPage = startPage + blockPage - 1;
        
        //마지막 페이지가 전체 페이지 수보다 크면 전체 페이지 수로 설정
        if(endPage > totalPage) {
            endPage = totalPage;
        }
    }
     
}
