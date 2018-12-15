<%@ include file="/view/taglib.jspf" %>

<html xmlns:c="http://www.w3.org/1999/XSL/Transform">

<head>
    <title>Dynamusic</title>
</head>
<body>
<center><h1>Dynamusic</h1></center>

<strong>Songs of ${playlist.name} playlist: </strong>

<h3>Songs</h3>
<table>
    <tr>
        <th width="60">Song ID</th>
        <th width="120">Song Name</th>
        <th width="120">Song Duration</th>
        <th width="200">Delete Song</th>
    </tr>
    <c:forEach items="${songs}" var="song">
        <tr>
            <td>${song.id}</td>
            <td>${song.name}</td>
            <td>${song.duration}</td>
            <td><a href="">Delete song from playlist</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>