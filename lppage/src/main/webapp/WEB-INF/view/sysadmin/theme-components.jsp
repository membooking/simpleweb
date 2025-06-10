<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/view/common/taglibs.jsp" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Themes</title>
    <link rel="stylesheet" href="/static/vendor/bs-icons/bootstrap-icons.css"/>
    <link rel="stylesheet" type="text/css" href="/static/vendor/bootstrap.min.css" />
    <script src="/static/vendor/jquery-3.7.1.min.js"></script>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-lg-12">
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="/sysadmin/themes">Themes</a></li>
                    <li class="breadcrumb-item active" aria-current="page">Components</li>
                </ol>
            </nav>
            <h1>Components</h1>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <table class="table table-striped table-dark">
                <thead>
                <tr>
                    <th>Code</th>
                    <th>Section</th>
                    <th>Tags</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="cur" items="${components}">
                    <tr>
                        <td>${cur.code}</td>
                        <td>${cur.section}</td>
                        <td>${cur.tags}</td>
                        <td><a href="#" data-theme="${cur.theme}" data-themecomponentid="${cur.themecomponentid}" class="btn btn-link btn-edit-component">Edit</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <br/>
            <button type="button" class="btn btn-primary btn-add-component">Add</button>
        </div>
    </div>
</div>

<div class="modal fade" id="themecomponentModal" tabindex="-1" role="dialog" aria-labelledby="themecomponentModalLabel">
    <div class="modal-dialog modal-fullscreen" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="themecomponentModalLabel">Component form</h4>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form id="themeComponentForm" method="post" action="/sysadmin/theme/${theme}/save-component">
                    <input type="hidden" name="themecomponentid" value="0">
                    <div class="row">
                        <div class="form-group col-md">
                            <label>Code:</label>
                            <input type="text" class="form-control" name="code">
                        </div>
                        <div class="form-group col-md">
                            <label>Section:</label>
                            <input type="text" class="form-control" name="section">
                        </div>
                        <div class="form-group col-md">
                            <label>Tags:</label>
                            <input type="text" class="form-control" name="tags">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <label>Content</label>
                            <textarea name="content"></textarea>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-bs-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary btn-save-component">Save changes</button>
            </div>
        </div>
    </div>
</div>
<script src="/static/vendor/bootstrap.bundle.min.js"></script>
<script src="/static/vendor/ckeditor/ckeditor.js"></script>
<script>
    var base64_encoded_path = $('.base64_encoded_path').html();
    CKEDITOR.dtd.$removeEmpty.i = 0;
    CKEDITOR.replace( 'content', {
        filebrowserBrowseUrl: '/ckeditor/browse/'+base64_encoded_path,
        filebrowserUploadUrl: '/ckeditor/upload/'+base64_encoded_path,
        height: 700,
        allowedContent: true,
        autoParagraph: false,
        extraAllowedContent: 'span;*(*);*{*}'
    });
    $('.btn-add-component').on('click',function (){
        $('#themecomponentModal').modal('show');
    });
    $('.btn-save-component').on('click',function (){
        $('#themeComponentForm').submit();
    });
    $('.btn-edit-component').on('click',function (){
        let themecomponentid = $(this).data('themecomponentid');
        let theme = $(this).data('theme');
        $.ajax({
            url: '/api/v0/theme/' + theme + '/get-component?cid=' + themecomponentid,
            type: 'GET',
            contentType: "application/json",
            success: function(component) {
                showThemeComponentForm(component);
            }
        });
    });
    function showThemeComponentForm(component) {
        if (component.themecomponentid > 0) {
            var $theForm = $('#themeComponentForm');
            $theForm.find('input[name="themecomponentid"]').val(component.themecomponentid);
            $theForm.find('input[name="code"]').val(component.code);
            $theForm.find('input[name="section"]').val(component.section);
            $theForm.find('input[name="tags"]').val(component.tags);
            $theForm.find('textarea[name="content"]').val(component.content);
            CKEDITOR.instances.content.setData(component.content);
            $('#themecomponentModal').modal('show');
        }
    }
</script>
</body>
</html>