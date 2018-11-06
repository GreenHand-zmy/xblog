
<textarea id="content" name="content" class="form-control">
    <c:if test="${post.content != null}">
        ${post.content}
    </c:if>
</textarea>

<script type="text/javascript">
$(function () {
    if (!mblog.browser.android && !mblog.browser.ios) {
		seajs.use('editor', function(editor) {
			editor.init(function () {
				$('#content').removeClass('form-control');
			});
		});
    }
})
</script>
