<%--
  Created by IntelliJ IDEA.
  User: fz
  Date: 2015/5/30
  Time: 20:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Callable Upload</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="/css/bootstrap.min.css">

    <!-- 可选的Bootstrap主题文件（一般不用引入） -->
    <!-- <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap-theme.min.css"> -->

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="/js/jquery-1.11.2.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="/js/bootstrap.min.js"></script>
    <style type="text/css">
        .container {
            margin-top: 20px;
        }
    </style>
    <script type="text/javascript">
        $(document).ready(function(){
            function getPercentAjax(){
                try{
                    $.ajax({
                        url: '/pets/tomupload/progress',
                        dataType: 'jsonp',
                        success: function(data){
                            if(!data.doneFlag){
                                $("#progress").show();
                                $("#progressBar").width(data.percentDone+"%").html(data.percentDone+"%");
                                setTimeout(getPercentAjax, 500);
                            }
                        },
                        error: function(jqXHR, textStatus, errorThrown){
                            console.log(jqXHR);
                            console.log(textStatus);
                            console.log(errorThrown);
                        }
                    });
                }catch(err){
                    console.log(err);
                }

            }

            $("#uploadBtn2").click(function(event){
                event.preventDefault();
                var timestamp = new Date().getTime();
                $("#upload_key").val(timestamp);
                $("#callableForm2").submit();
                getPercentAjax();
            });
        });
    </script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-6">
            <div class="panel panel-primary">
                <div class="panel-heading">文件上传</div>
                <div class="panel-body">
                    <form id="callableForm" method="post" action="/pets/tomcallable" enctype="multipart/form-data" class="form-group">
                        <div class="form-group">
                            <label for="inputFile">上传文件</label>
                            <input type="file" id="inputFile" name="file" />
                        </div>
                        <button type="submit" class="btn btn-primary">上传</button>
                    </form>
                </div>
            </div>
        </div>
        <div class="col-md-6">
            <div class="panel panel-primary">
                <div class="panel-heading">多文件上传</div>
                <div class="panel-body">
                    <form id="callableForm2" method="post" action="/pets/tomupload" enctype="multipart/form-data" class="form-group">
                        <div class="form-group">
                            <input type="file" id="inputFile20" name="files" />
                            <input type="file" id="inputFile21" name="files" />
                            <input type="hidden" id="upload_key" name="upload_key" value="0" />
                        </div>
                        <div id="progress" class="progress" style="display: none;">
                            <div id="progressBar" class="progress-bar" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width: 0%;">
                            </div>
                        </div>
                        <input id="uploadBtn2" type="button" class="btn btn-primary" value="上传"/>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
