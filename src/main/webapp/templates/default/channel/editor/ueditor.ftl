
<textarea id="content" name="content" class="form-control">${view.content}</textarea>

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
