<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>인덱스를 만들어 보자</title>
	<link rel="stylesheet" href="./css/bootstrap.css">
	<link rel="stylesheet" href="./css/style.css">

</head>

<body>

	<header>
		<!--
            container-fluid 요소는 가로 해상도와 상관없이
            항상 100%의 width를 가진다.
        -->
		<div class="container-fluid">
			<div class="row">
				<nav class="navbar">
					<div class="container">
						<div class="navbar-header">
							<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
							</button>
							<a class="navbar-brand" href="#"><img width="30px" src="./img/logo.svg" alt="logo"></a>
						</div>
						<div class="collapse navbar-collapse" id="myNavbar">
							<ul class="nav navbar-nav">
								<li><a href="#">Main</a></li>
								<li><a href="#">Form</a></li>
								<li><a href="#">Grid Board</a></li>
								<li><a href="#">Board</a></li>
							</ul>
							<!-- 드롭다운으로 로그인 추가 -->
							<ul class="nav navbar-nav navbar-right">
								<li class="dropdown">
									<a class="dropdown-toggle" data-toggle="dropdown" href="#">로그인
										<span class="caret"></span>
									</a>
									<ul class="dropdown-menu">
										<li><a href="#"><span class="glyphicon glyphicon-user"></span>Join</a></li>
										<li><a href="#"><span class="glyphicon glyphicon-log-in"></span>Login</a></li>
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