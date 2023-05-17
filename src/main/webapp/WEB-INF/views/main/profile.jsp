<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <%@ include file="../include/static-head.jsp" %>
    <!-- side menu event js defer : 지연 메뉴 걸기 -->
    <script src="/assets/js/side-menu.js" defer></script>
    <!-- 말풍선 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.6.0/font/bootstrap-icons.css" />
    <!-- css -->
    <link rel="stylesheet" href="/assets/css/profile.css">
</head>

<body>



<!-- header -->
<header>
    <div class="inner-header">
        <h1 class="logo">
            <a href="/user/main">
                <img src="/assets/img/logo-instagram.png" alt="로고이미지">
            </a>
        </h1>
        <h2 class="intro-text"><a href="/user/main">Petstagram</a></h2>
        <a href="#" class="menu-open">
            <span class="menu-txt">MENU</span>
            <span class="lnr lnr-menu"></span>
        </a>
    </div>

    <nav class="gnb">
        <a href="#" class="close">
            <span class="lnr lnr-cross"></span>
        </a>
        <ul>
            <a href="/user/main"><span class="lnr lnr-home"> 홈</span></a>
            <a href="#"><span class="lnr lnr-magnifier"> 검색</span></a>
            <a href="#"><span class="lnr lnr-map"> 내 주변 친구</span></a>
            <a href="#"><span class="lnr lnr-heart"> 자랑하기</span></a>
            <a href="#"><span class="lnr lnr-bubble"> 메시지</span></a>
            <a href="#"><span class="lnr lnr-alarm"> 알림</span></a>
            <a href="#"><span class="lnr lnr-user"> 프로필</span></a>
        </ul>
    </nav>
</header>

<!--main left sidebar-->
<aside class="sidebar">
    <div class="profile-box">
        <div class="profile-img"><a href=""></a></div>
        <h3 id="petNickname">멍멍이</h3>
        <p id="profileIntro">#안뇽</p>
    </div>
        <div>
         <button type="submit" onclick="http://localhost:8585/modify">수정하기</button>
        </div>
</aside>



<!--//Profile Change Body label이랑 id 맞추고 dto랑 name 맞춘다-->
<div class="profileChange">
    <form action="/pet/profile"  method="post"  name = "petProfile" class="profile">

        <label for="petPhoto">프로필 사진 추가하기</label>
        <input type="file" id="petPhoto" name="petPhtoto" accept="image/*">

        <label for="petName">반려동물 이름</label>
        <input type="text" id="petName" name="petName" required>

        <label for="petAge">나이</label>
        <input type="text" id="petAge" name="petAge" required>

        <label for="petKind">품종</label>
        <input type="text" id="petKind" name="petKind" required>



        <label for="petGender">성별</label>
        <select id="petGender" name="petGender">
            <option value="">선택하세요</option>
            <option value="FEMALE">여</option>
            <option value="MALE">남</option>
            <option value="NO_GENDER">중성</option>
            <option value="SECRET">밝히고 싶지 않음</option>
        </select>

        <label for="hashTag">소개</label>
        <textarea id="hashTag" name="hashTag" rows="4" required></textarea>

<%--        <label for="profileSuggest">프로필에 계정 추천 표시</label>--%>
<%--        <p id="suggestProfile">강아지의 프로필이 다른 프로필에서 추천될 수 있는지를 선택하세요.&nbsp;&nbsp;&nbsp;<input type="checkbox" name="profileSuggest"></p>--%>

        <input type="submit" value="제출">
    </form>
</div>
<script>

    const $hashTag = document.getElementById('hashTag');
    const $profileIntro= document.getElementById('profileIntro');
    const $petName= document.getElementById('petName');
    const $petNickname= document.getElementById('petNickname');

    $hashTag.onkeyup = e => {
        // console.log(e);

        if (e.key === 'Enter') {
            $profileIntro.textContent = $hashTag.value;
            $petNickname.textContent = $petName.value;
        }

    };

</script>
</body>

</html>