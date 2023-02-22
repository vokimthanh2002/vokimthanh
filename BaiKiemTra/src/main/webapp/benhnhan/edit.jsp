<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<a href="/benhnhan">Tro ve danh sach benh nhan</a>
<form method="post">
    <div class="form-row">
        <div class="form-group col-md-6">
            <label>Ma benh nhan</label>
            <input name="maBN" type="text" class="form-control"  value="${requestScope["benhnhan"].getMaBenhNhan()}">
        </div>
        <div class="form-group col-md-4">
            <label >Ma benh an</label>
            <select name="maBA" class="form-control">
                <option value="${requestScope["benhnhan"].getMaBenhAn()}">${requestScope["benhnhan"].getMaBenhAn()}</option>
                <c:forEach items="${listBA}" var ="benhan">
                    <option value="${benhan.getMaBenhAn()}">${benhan.getMaBenhAn()}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group col-md-6">
            <label>Ten benh nhan</label>
            <input name="tenBN" type="text" class="form-control"  placeholder="Nhap ten benh nhan" value="${requestScope["benhnhan"].getTenBenhNhan()}">
        </div>
        <div class="form-group col-md-6">
            <label>Chon ngay nhap vien</label>
            <input name="ngayNV" type="date" class="form-control" value="${requestScope["benhnhan"].getNgayNhapVien()}"  >
        </div>
        <div class="form-group col-md-6">
            <label>Chon ngay xuat vien</label>
            <input name="ngayRV" type="date" class="form-control" value="${requestScope["benhnhan"].getNgayRaVien()}"  >
        </div>
        <div class="form-group col-md-6">
            <label>Nhap ly do</label>
            <input name="lyDo" type="text" class="form-control"  placeholder="Nhap ly do" value="${requestScope["benhnhan"].getLiDo()}" >
        </div>

    </div>

    <button type="submit" class="btn btn-primary">Xac nhan thay doi</button>
</form>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>