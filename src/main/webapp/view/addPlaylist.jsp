<%@ include file="/view/taglib.jspf" %>

<html>

<head>
    <title>Dynamusic</title>
</head>
<body>
<center><h1>Dynamusic</h1></center>

Choose playlist name:
<form method="get" action="${fullPath}/playlists/addForm/addPlaylist">
    <input type="text" name="playlistName">
    <input type="submit" value="Add playlist">
    <input type="hidden" value="${user.id}">
</form>

</body>
</html>