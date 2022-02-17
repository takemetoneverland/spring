<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

	<%@ include file="include/header.jsp" %>

    <!-- 본문 -->
    <section>
        <!-- 슬라이드 시작 -->
        <div class="container-fluid">
            <div class="row">

                <div id="myCarousel" class="carousel slide" data-ride="carousel">
                    <!-- Indicators -->
                    <ol class="carousel-indicators">
                      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                      <li data-target="#myCarousel" data-slide-to="1"></li>
                      <li data-target="#myCarousel" data-slide-to="2"></li>
                    </ol>
                  
                    <!-- Wrapper for slides -->
                    <div class="carousel-inner" role="listbox">
                      <div class="item active">
                        <a href="#">
                            <img src="img/slide1.jpg" alt="슬라이드1">
                        </a> 
                      </div>
                      <div class="item">
                        <a href="#">
                            <img src="img/slide2.jpg" alt="슬라이드2">
                        </a> 
                      </div>
                      <div class="item">
                        <a href="#">
                            <img src="img/slide3.jpg" alt="슬라이드3">
                        </a> 
                      </div>
                    </div>
                  
                    <!-- 좌, 우 화살표 (없애고 싶으면 지우세요.) -->
                    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                      <span class="sr-only">Previous</span>
                    </a>
                    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                      <span class="sr-only">Next</span>
                    </a>
                  </div>

            </div>
        </div>
    </section>

    <!-- 상품 배치 -->
    <section>
        <div class="container">
            <div class="row">
                <div class="col-xs-12">
                    <h2>상품 그리드 레이아웃 <small>(쿠팡 참조)</small></h2>
                </div>
            </div>

            <!-- 새로운 그리드 잡기-->
            <div class="row">
                <ul class="col-xs-12 prod-list">
                    <!-- 첫 줄은 사이즈를 6칸씩 잡는다.(2개씩 보임)-->
                    <li class="col-sm-6">
                        <a href="#" class="prod-link">
                            <img src="img/box1.jpg" alt="box1">
                            <span class="arrow"><i class="glyphicon glyphicon-menu-right"></i></span>
                            <span class="arrow hover">상세보기<i class="glyphicon glyphicon-menu-right"></i></span>
                        </a>
                    </li>
                    <li class="col-sm-6">
                        <a href="#" class="prod-link">
                            <img src="img/box2.jpg" alt="box2">
                            <span class="arrow"><i class="glyphicon glyphicon-menu-right"></i></span>
                            <span class="arrow hover">상세보기<i class="glyphicon glyphicon-menu-right"></i></span>
                        </a>
                    </li>
                    <!-- 하나를 잡았으면 다음부터는 차지하는 공간만 다르게 설정. -->
                    <li class="col-md-3 col-sm-6">
                        <a href="#" class="prod-link">
                            <img src="img/box3.jpg" alt="box3">
                            <span class="arrow"><i class="glyphicon glyphicon-menu-right"></i></span>
                            <span class="arrow hover">상세보기<i class="glyphicon glyphicon-menu-right"></i></span>
                        </a>
                    </li>
                    <li class="col-md-3 col-sm-6">
                        <a href="#" class="prod-link">
                            <img src="img/box4.jpg" alt="box4">
                            <span class="arrow"><i class="glyphicon glyphicon-menu-right"></i></span>
                            <span class="arrow hover">상세보기<i class="glyphicon glyphicon-menu-right"></i></span>
                        </a>
                    </li>
                    <li class="col-md-3 col-sm-6">
                        <a href="#" class="prod-link">
                            <img src="img/box5.jpg" alt="box5">
                            <span class="arrow"><i class="glyphicon glyphicon-menu-right"></i></span>
                            <span class="arrow hover">상세보기<i class="glyphicon glyphicon-menu-right"></i></span>
                        </a>
                    </li>
                    <li class="col-md-3 col-sm-6">
                        <a href="#" class="prod-link">
                            <img src="img/box6.jpg" alt="box6">
                            <span class="arrow"><i class="glyphicon glyphicon-menu-right"></i></span>
                            <span class="arrow hover">상세보기<i class="glyphicon glyphicon-menu-right"></i></span>
                        </a>
                    </li>
                    <!--이번에는 md에서 6칸, sm사이즈에서 12칸-->
                    <li class="col-md-6 col-sm-12">
                        <a href="#" class="prod-link">
                            <img src="img/box7.jpg" alt="box7">
                            <span class="arrow"><i class="glyphicon glyphicon-menu-right"></i></span>
                            <span class="arrow hover">상세보기<i class="glyphicon glyphicon-menu-right"></i></span>
                        </a>
                    </li>
                    <li class="col-md-3 col-sm-6">
                        <a href="#" class="prod-link">
                            <img src="img/box8.jpg" alt="box8">
                            <span class="arrow"><i class="glyphicon glyphicon-menu-right"></i></span>
                            <span class="arrow hover">상세보기<i class="glyphicon glyphicon-menu-right"></i></span>
                        </a>
                    </li>
                    <li class="col-md-3 col-sm-6">
                        <a href="#" class="prod-link">
                            <img src="img/box9.jpg" alt="box9">
                            <span class="arrow"><i class="glyphicon glyphicon-menu-right"></i></span>
                            <span class="arrow hover">상세보기<i class="glyphicon glyphicon-menu-right"></i></span>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </section>


	<%@ include file="include/footer.jsp" %>

	<script>
		const msg = '${msg}';
		if(msg !== '') {
			alert(msg);
		}
	</script>

</body>

</html>