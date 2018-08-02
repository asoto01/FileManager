<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>File Manager</title>
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.1/css/bulma.min.css">
</head>
<body>
<div class="has-text-centered">
<h1 class="is-size-1">File Manager</h1>
</div>
	<br>
	<div class="has-text-centered">
	<img src="https://is1-ssl.mzstatic.com/image/thumb/Purple128/v4/3a/11/d4/3a11d442-16ae-7446-4ee3-b9ea91766d62/AppIconFileManager-1x_U007emarketing-85-220-0-6.png/246x0w.jpg">
	</div>
	<br>
	<br>
	<div class = "container">
	<div class="file has-name is-centered">
  <form action="FileUpload" method="post"
                        enctype="multipart/form-data">
<input type="file" name="file" size="50" />
<br />
<input type="submit" value="Upload File" />
</form>
</div>
</div>
</body>
</html>