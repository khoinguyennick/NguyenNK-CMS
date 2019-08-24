<div class="col-2 px-0 border-right " style="left: 0; top: 0">
    <form action="${pageContext.request.contextPath}/search" class="input-group mb-3 mt-4 px-2">
        <input name="keyword" class="form-control" placeholder="Search...">
        <div class="input-group-append">
            <button class="btn btn-link btn-outline-secondary" type="submit">
                <i class="fas fa-search"></i>
            </button>
        </div>
    </form>
    <ul class="list-group list-group-flush">
        <button class="list-group-item btn btn-link text-primary text-left" id="view-link">
            <i class="fas fa-table"></i> View Content
        </button>
        <button class="list-group-item btn btn-link text-primary text-left" id="form-link">
            <i class="fas fa-edit"></i> Form Content
        </button>
    </ul>
</div>

<script src="js/sidebar.js"></script>