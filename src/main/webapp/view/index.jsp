<%@ include file="/view/taglib.jspf" %>

<html xmlns:c="http://www.w3.org/1999/XSL/Transform">

<head>
    <title>Dynamusic</title>
</head>
<body>
<center><h1>Dynamusic</h1></center>

<c:if test="${empty user}">
    <center><strong><a href="${fullPath}/loginForm">LOGIN</a></strong></center>
    <br>
    Welcome to Dynamusic!!!
</c:if>
<c:if test="${not empty user}">
    Welcome to Dynamusic, ${user.login}!!!
    <br>
    <a href="${fullPath}/playlists">--> View my playlists <--</a>
</c:if>

<h3>Songs</h3>
<table>
    <tr>
        <th width="60">Song ID</th>
        <th width="150">Song Name</th>
        <th width="150">Song Duration</th>
        <th width="200">Add</th>
    </tr>
    <c:forEach items="${songs}" var="song">
        <tr>
            <td>${song.id}</td>
            <td>${song.name}</td>
            <td>${song.duration}</td>
            <td>
                <form method="get" action="addSongToPlaylist/${song.id}">
                    <select name="playlistId">
                        <c:forEach items="${playlists}" var="playlist">
                            <option value="${playlist.id}">${playlist.name}</option>
                        </c:forEach>
                    </select>
                    <input type="submit" value="Add to playlist">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>