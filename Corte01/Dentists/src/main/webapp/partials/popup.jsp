<%@ page import="com.dentalia.domain.util.ErrorPopup" %><%
    // Find attribute to render a modal
    Object modal = session.getAttribute("error");
    if (modal != null) {
        ErrorPopup error = (ErrorPopup) modal;
        session.removeAttribute("error");
%>
<div class="modal fade" id="errorModal" tabindex="-1" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header <%= error.getLevel() == ErrorPopup.Level.ERROR ? "bg-danger" : "bg-warning" %> text-white">
                <h5 class="modal-title">Error</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <p><%= error.getMessage() %>
                </p>
            </div>
        </div>
    </div>
</div>

<script>
    document.addEventListener("DOMContentLoaded", function () {
        let errorModal = new bootstrap.Modal(document.getElementById('errorModal'));
        errorModal.show();
        setTimeout(() => errorModal.hide(), 1000);
    });
</script>
<%
    }
%>