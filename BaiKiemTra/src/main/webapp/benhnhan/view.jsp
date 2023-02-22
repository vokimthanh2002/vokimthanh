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
<table class="table table-dark">
  <thead>
  <tr>
    <th scope="col">Hinh Anh</th>
    <th scope="col">Ma Benh Nhan</th>
    <th scope="col">Ma Benh An</th>
    <th scope="col">Ten Benh Nhan</th>
    <th scope="col">Ngay Nhap Vien</th>
    <th scope="col">Ngay Ra Vien</th>
    <th scope="col">Ly Do</th>
  </tr>
  </thead>
  <tbody>
  <tr>
    <td><img src="https://toigingiuvedep.vn/wp-content/uploads/2021/07/mau-anh-the-dep-lam-the-can-cuoc.jpg" style="height: 50px" width="50px"></td>
    <td>${requestScope["benhnhan"].getMaBenhNhan()}</td>
    <td>${requestScope["benhnhan"].getMaBenhAn()}</td>
    <td>${requestScope["benhnhan"].getTenBenhNhan()}</td>
    <td>${requestScope["benhnhan"].getNgayNhapVien()}</td>
    <td>${requestScope["benhnhan"].getNgayRaVien()}</td>
    <td>${requestScope["benhnhan"].getLiDo()}</td>
  </tr>
  </tbody>
</table>
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