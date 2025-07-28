<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><tiles:insertAttribute name="title" /></title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css" />
	<style>
		.wrapper {
		    min-height: 100vh;
		    display: flex;
		    flex-direction: column;
		}
		
		header, footer {
		    background-color: #0d6efd;
		    color: white;
		    padding: 1rem 2rem;
		}
		
		.content {
		    flex: 1;
		    display: flex;
		    background-color: #f8f9fa;
		}
		
		aside {
		    width: 220px;
		    background-color: #e9f0fb;
		    border-right: 1px solid #0d6efd;
		    padding-top: 1.5rem;
		    overflow-y: auto;
		}
		
		main {
		    flex: 1;
		    padding: 1.5rem 2rem;
		    overflow-y: auto;
		}
	</style>
</head>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<body>
    <div class="wrapper">
        <header>
            <tiles:insertAttribute name="header" />
        </header>

        <div class="content">
            <aside>
                <tiles:insertAttribute name="left" />
            </aside>

            <main>
                <tiles:insertAttribute name="content" />
            </main>
        </div>

        <footer>
            <tiles:insertAttribute name="footer" />
        </footer>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
