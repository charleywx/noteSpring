<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>HttpMessageConverter Demo</title>
</head>
<body>
    <div id="resp"></div>
    <input type="button" onclick="req()" value="请求">

    <%--target/SpringMVC2017/WEB-INF/classes/assets/assets.js/jquery.assets.js--%>
    <script src="assets/js/jquery.js" type="text/javascript"></script>

    <script>
        function req() {
            $.ajax({
                url: "convert",
                data: "1234-张三",
                type: "POST",
                contentType: "application/myMediaType",
                success: function (data) {
                    $("#resp").html(data);
                }
            });
        }
    </script>
</body>
</html>