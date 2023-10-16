<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
<!-- bootstrap CDN link -->
 	 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<!-- AJAX를 사용하려면 반드시 jquery원본이 필요하다 -->
	<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
  	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h1>회원 정보 추가</h1>
		
		<%-- <form method="post" action="/lesson06/ex01/add-user">--%>
			<div class="form-group">
				<label for="name"><b>이름</b></label>
				<input type="text" id="name" name="name" class="form-control col-3" placeholder="이름을 입력하세요">
			</div>
			<div class="form-group">
				<label for="yyyymmdd"><b>생년월일</b></label>
				<input type="text" id="yyyymmdd" name="yyyymmdd" class="form-control col-3" placeholder="예)20190101">
			</div>
			<div class="form-group">
				<label for="email"><b>이메일</b></label>
				<input type="text" id="email" name="email" class="form-control col-3" placeholder="이메일주소를 입력하세요">
			</div>
			<div class="form-group">
				<label for="introduce"><b>자기소개</b></label>
				<textarea id="introduce" name="introduce" class="form-control col-5" rows="10"></textarea>
			</div>
			
			<!--  <input type="submit" class="btn btn-success" value="추가">-->
			<%-- ★★★★★ AJAX 통신일 때는 반드시 button 타입으로 지정한다 --%>
			<input type="button" id="joinBtn" class="btn btn-success" value="추가">
		<%-- </form>--%>
	</div>
	
	
<script>
	$(document).ready(function() {
		// 1) jquery submit 기능 이용하기 (form 태그)
		/* $("form").on("submit", function(e) {
			e.preventDefault(); //form태그 동작을 막는다
			//alert("폼 태그 동작");
			
			//validation check
			let name = $("#name").val().trim();
			if (name == "") {
				alert("이름을 입력하세요");
				return false; //submit 안함
			}
			
			let yyyymmdd = $('#yyyymmdd').val().trim();
			if (yyyymmdd.length < 1) {
				alert("생년월일을 입력하세요");
				return false; //submit 안함
			}
			
			let email = $('input[name=email]').val().trim();
			if (!email) {
				alert("이메일을 입력하세요");
				return false; //submit 안함				
			}
			
			//여기까지 도달하면 submit 수행
			
		}); */
		
		// 2) jquery의 AJAX 통신 이용하기
		$('#joinBtn').on('click', function() {
			//alert("버튼 클릭");
			
			//validation check
			let name = $("#name").val().trim();
			if (name == "") {
				alert("이름을 입력하세요");
				return ; 
			}
			
			let yyyymmdd = $('#yyyymmdd').val().trim();
			if (yyyymmdd.length < 1) {
				alert("생년월일을 입력하세요");
				return ; 
			}
			
			let email = $('input[name=email]').val().trim();
			if (!email) {
				alert("이메일을 입력하세요");
				return ;				
			}
			
			let introduce = $('#introduce').val();
			
			console.log(name);
			console.log(yyyymmdd);
			console.log(email);
			console.log(introduce);
			
			//AJAX: 서버 요청
			$.ajax({
				// request
				type:"post" 
				, url:"/lesson06/ex01/add-user"
				, data:{"name":name, "yyyymmdd":yyyymmdd, "email":email, "introduce":introduce} //JSON Sting
				
				// response
				// call back 함수
				, success:function(data) { //data: response결과의 응답값, 위의 data와는 아무관계없음
					// 서버 처리 후에 에러가 없을 때 수행된다
					//alert(data);
					if (data == "성공") {
						location.href = "/lesson06/ex01/get-latest-user";
					}
					
				}
				, complete:function(data) {
					// 성공이든 실패든 무조건 불려짐 => 굳이 안쓴다 여기선 그냥 보여주는것
				}
				, error:function(request, status, error) {
					//에러일 때 수행(404, 400, 405, 500등등)
					alert(request);
					alert(status);
					alert(error);
				}
			});
			
			
			
		});
	});
</script>
</body>
</html>