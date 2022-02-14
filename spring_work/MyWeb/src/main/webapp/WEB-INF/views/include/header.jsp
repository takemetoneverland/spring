<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>인덱스를 만들어 보자</title>
    <link rel="stylesheet" href="<c:url value='/css/bootstrap.css' />">
    <link rel="stylesheet" href="<c:url value='/css/style.css' />">
    <script src="<c:url value='/js/jquery-3.6.0.min.js' />"></script>
    <script src="<c:url value='/js/bootstrap.js' />"></script>  
</head>

<body>

    <header>
        <!-- container-fluid요소는 가로 해상도에 상관없이
         항상 100%의 width를 가집니다. -->
        <!-- div.container 태그를 먼저 열어 줍니다. -->
        <!-- navbar-nav를 이용한 메뉴 구성.-->

        <div class="container-fluid">
            <div class="row">
                <nav class="navbar">
                    <div class="container">
                        <div class="navbar-header">
                            <!-- data-toggle 같은 것은 내부적으로 지원하는 반응형 기능이 있기 때문에 막 지우시면 안됩니다. -->
                            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </button>
                            <a class="navbar-brand" href="#"><img width="30px" src="<c:url value='/img/logo.svg' />" alt="logo"></a>
                        </div>
                        <div class="collapse navbar-collapse" id="myNavbar">
                            <ul class="nav navbar-nav">
                                <li class="active"><a href="<c:url value='/' />">Main</a></li>
                                <li><a href="<c:url value='/freeBoard/freeList' />">자유게시판</a></li>
                                <li><a href="#">SNS</a></li>
<!--                                 <li><a href="#">Grid Board2</a></li>
                                <li><a href="#">Board</a></li>
 -->                            </ul>
                            <!-- 드롭다운으로 로그인 추가 -->
                            <ul class="nav navbar-nav navbar-right">
                                <li class="dropdown">
                                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">로그인
                                     <span class="caret"></span>   
                                    </a>
                                    <ul class="dropdown-menu">
                                        <li><a href="#"><span class="glyphicon glyphicon-user"></span> Join</a></li>
                                        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                                    </ul>
                                </li>
                            </ul>

                            <!-- 검색창을 배치하고 싶을 때 -->
                            <form class="navbar-form navbar-right" action="#">
                                <div class="input-group">
                                    <input type="text" class="form-control" placeholder="Search">
                                    <div class="input-group-btn">
                                        <button type="submit" class="btn btn-primary">검색</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </nav>
            </div>
        </div>
    </header>
