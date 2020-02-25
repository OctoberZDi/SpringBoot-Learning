<!DOCTYPE html>
<html>
<head lang="en">
    <title>Spring Boot Demo - FreeMarker</title>
    <link href="/css/index.css" rel="stylesheet">
    <script type="text/javascript" src="/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="/js/index.js"></script>
</head>
<body>
<h2>首页
    <h2>

        <span>
            <#list users as item>
                ${item!}<br/>
            </#list>
        </span>

        <button class="a"> click me</button>
</body>
</html>