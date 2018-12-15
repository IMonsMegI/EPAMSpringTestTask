<%@ include file="/view/taglib.jspf" %>

<html xmlns:c="http://www.w3.org/1999/XSL/Transform">

<head>
    <title>Dynamusic</title>
</head>
<body>
<center><h1>Dynamusic</h1></center>

<a href="${fullPath}/playlists/addForm">Add playlist</a>
<br>

<form method="get" action="${fullPath}/playlists/deletePlaylist">
    <select name="playlistToDeleteName">
        <c:forEach items="${playlists}" var="playlist">
            <option value="${playlist.name}">${playlist.name}</option>
        </c:forEach>
    </select>
    <input type="submit" value="Delete playlist">
</form>

<h3>Playlists</h3>
<table>
    <tr>
        <th width="60">Playlist ID</th>
        <th width="120">Playlist Name</th>
        <th width="120">Playlist Count Of Songs</th>
    </tr>
    <c:forEach items="${playlists}" var="playlist">
        <tr>
            <td>${playlist.id}</td>
            <td>${playlist.name}</td>
            <td>${playlist.countOfSongs}</td>
            <td><a href="${fullPath}/playlist/${playlist.id}">View playlist</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>