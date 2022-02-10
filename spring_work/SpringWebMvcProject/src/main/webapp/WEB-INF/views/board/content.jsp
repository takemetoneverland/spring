<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../include/header.jsp" />
<style>
header.masthead {
	
	display: none;
}	
</style>
<br/><br/>
<div class="container">

<div class="row">
  <div class="col-lg-12">
    <div class="card">
      <div class="card-header text-white" style="background-color: #643691;">${article.boardNo}번 게시물 내용</div>
      <div class="card-body">

        
          <div class="form-group">
            <label>작성자</label>
            <input type="text" class="form-control" name='writer' value="${article.writer}" readonly>
          </div>
          
          <div class="form-group">
            <label>제목</label>
            <input type="text" class="form-control" name='title' value="${article.title}" readonly>
          </div>

          <div class="form-group">
            <label>내용</label>
            <textarea class="form-control" rows="5" name='content' readonly>${article.content}</textarea>
          </div>

        <form id="formObj" role="form" action="<c:url value='/board/delete' />" method="post">
			<!-- 수정 버튼 눌렀을 때 넘어가는 데이터 hidden으로 숨겨져 있어 눈에는 안보임 -->         
         	<input type="hidden" name="boardNo" value="${article.boardNo}">
         	<input type="hidden" name="page" value="${p.page}">
         	<input type="hidden" name="countPerPage" value="${p.countPerPage}">
         
	          <input id="list-btn" class="btn" type="button" value="목록"
			style="background-color: #643691; margin-top: 0; height: 40px; color: white; border: 0px solid #388E3C; opacity: 0.8">&nbsp;&nbsp;
	          
	          <c:if test="${login.name == article.writer}">
		          <input id="mod-btn" class="btn" type="button" value="수정"
				style="background-color: orange; margin-top: 0; height: 40px; color: white; border: 0px solid #388E3C; opacity: 0.8">&nbsp;&nbsp;
		          <input class="btn" type="submit" value="삭제" onclick="return confirm('정말로 삭제하시겠습니까?')"
				style="background-color: red; margin-top: 0; height: 40px; color: white; border: 0px solid #388E3C; opacity: 0.8">&nbsp;&nbsp;
       		  </c:if>
       </form>



      </div>
    </div>
  </div>
</div>
</div>
<jsp:include page="../include/footer.jsp" />

<script>

	//목록 버튼 클릭 이벤트 처리.
	/*
	const $listBtn = document.getElementById('list-btn');
	$listBtn.onclick = function() {
		console.log('목록 버튼이 클릭됨!');
		location.href='/board/list';
	}
	
	//수정 버튼 클릭 이벤트 처리.
	const $modBtn = document.getElementById('mod-btn');
	const $formElement = document.getElementById('formObj');
	
	$modBtn.onclick = function() {
		$formElement.setAttribute('action', '/board/modify');
		$formElement.setAttribute('method', 'get');
		$formElement.submit();
	}
	*/

	//제이쿼리 시작
	$(document).ready(function() {
		//목록 버튼 클릭 이벤트 처리.
		$('#list-btn').click(function() {
			console.log('목록 버튼이 클릭됨!');
			location.href='/board/list?page=${p.page}&countPerPage=${p.countPerPage}'
			+ '&keyword=${p.keyword}&condition=${p.condition}';
		});
		
		//수정 버튼 클릭 이벤트 처리
		$('#mod-btn').click(function() {
			$('#formObj').attr({
				'action': '/board/modify',
				'method': 'get'
			});
			$('#formObj').submit();
		});
		
	});
	
</script>























