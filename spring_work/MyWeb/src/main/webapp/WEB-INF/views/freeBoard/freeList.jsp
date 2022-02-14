<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> <!-- 날짜 표현(포맷팅) 하기 위해서. -->

<%@ include file="../include/header.jsp" %>

    <section>
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-9 col-xs-12 board-table">
                    <div class="titlebox">
                        자유게시판
                    </div>
                    <hr>

                    <form action="#">
                        <div class="search-wrap clearfix">
                            <button type="submit" class="btn btn-info search-btn">검색</button>
                            <input type="text" class="form-control search-input">
                            <select class="form-control search-select">
                                <option>제목</option>
                                <option>내용</option>
                                <option>작성자</option>
                                <option>제목+내용</option>
                            </select>
                        </div>
                    </form> 
                        <table class="table table-bordered table-hover">
                            <thead>
                            	<tr>
	                                <th>번호</th>
	                                <th>제목</th>
	                                <th>작성자</th>
	                                <th>등록일</th>
	                                <th>수정일</th>
                                </tr>
                            </thead>
                            <tbody>
                            	<c:forEach var="vo" items="${boardList}">
	                                <tr>
	                                    <td>${vo.bno}</td>
	                                    <td>
	                                    	<a href="<c:url value='/freeBoard/freeDetail?bno=${vo.bno}&pageNum=${pc.paging.pageNum}&keyword=${pc.paging.keyword}&condition=${pc.paging.condition}' />">${vo.title}</a>
	                                    	&nbsp;&nbsp;&nbsp;
	                                    	<c:if test="${vo.newMark}">
	                                    		<img alt="newMark" src="<c:url value='/img/icon_new.gif' />">
	                                    	</c:if>
	                                    </td>
	                                    <td>${vo.writer}</td>
	                                    <td><fmt:formatDate value="${vo.regdate}" pattern="yyyy-MM-dd HH:mm:ss" /> </td>
	                                    <td><fmt:formatDate value="${vo.updatedate}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
	                                </tr>
                                </c:forEach>
                            </tbody>
                        </table>


						<form action="<c:url value='/freeBoard/freeList' />" name="pageForm">
	                        <div class="text-center clearfix">
	                            <hr>
	                            <ul class="pagination" id="pagination">
	                            	<c:if test="${pc.prev}">
	                                	<li><a href="#" data-pageNum="${pc.beginPage-1}">이전</a></li>
	                                </c:if>
	                                
	                                <c:forEach var="num" begin="${pc.beginPage}" end="${pc.endPage}">
	                                	<li class="${pc.paging.pageNum == num ? 'active' : ''}"><a href="#" data-pageNum="${num}">${num}</a></li>
	                                </c:forEach>
	                                
	                                <c:if test="${pc.next}">
	                               		<li><a href="#" data-pageNum="${pc.endPage+1}">다음</a></li>
	                                </c:if>
	                            </ul>
	                            
	                            <!-- 페이지 관련 버튼을 클릭 시 같이 숨겨서 보낼 값 -->
	                            <input type="hidden" name="pageNum" value="${pc.paging.pageNum}">
	                            <input type="hidden" name="countPerPage" value="${pc.paging.countPerPage}">
	                            <input type="hidden" name="keyword" value="${pc.paging.keyword}">
	                            <input type="hidden" name="condition" value="${pc.paging.condition}">
	                            
	                            <button class="btn btn-info">글쓰기</button>
	                        </div>
                        </form>
                </div>
            </div>
        </div>
    </section>


<%@ include file="../include/footer.jsp" %>

<script>
	
	//사용자가 페이지 관련 버튼을 클릭했을 때, 기존에는 각각의 a태그의 href에
	//각각 다른 url을 작성해서 요청을 보내줬다면, 이번에는 클릭한 그 버튼에 맞는 페이지 정보를
	//자바스크립트를 이용하여 끌고 와서 요청을 보내 주겠다.
	/*
	const pagination = document.getElementById('pagination');
	pagination.onclick = function(e) {
		e.preventDefault(); //버튼의 고유이벤트 속성 중지.
		
		//현재 이벤트가 발생한 요소(버튼)의
		//data-pageNum의 값을 얻어서 변수에 저장.
		const value = e.target.dataset.pagenum;
		
		//페이지 버튼들을 감싸고 있는 form태그를 name으로 지목하여
		//그 안에 있는 pageNum이라는 input태그의 value에
		//위에서 얻은 data-pageNum의 값을 삽입 후 submit
		document.pageForm.pageNum.value = value;
		document.pageForm.submit();
	}
	*/
	
	$(function() {
		$('#pagination').on('click', 'a', function(e) {
			e.preventDefault();
			console.log($(this));
			const value = $(this).data('pagenum');
			console.log(value);
			document.pageForm.pageNum.value = value;
			document.pageForm.submit();
		});
	});

</script>