<%@ page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>To-Do List</title>

    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
        rel="stylesheet">

    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
        rel="stylesheet">
</head>
<body>
    
    <div class="container mt-4">
        <h1 class="mb-4">To-Do List</h1>
        <hr>
        <hr>
        <br>
        <form action="" method="post" class="form-inline mb-4">
            <div class="form-group">
                <input type="text" name="task" class="form-control mr-2"
                    placeholder="Add a new task" />
            </div>
            <button type="submit" class="btn btn-primary">Add</button>
        </form>
        <hr>
        <hr>
        <br>
        <ul class="list-group">
            <%
                ArrayList<String> tasks = (ArrayList<String>) request.getSession().getAttribute("tasks");
                if (tasks == null) {
                    tasks = new ArrayList<>();
                    request.getSession().setAttribute("tasks", tasks);
                }

                String newTask = request.getParameter("task");
                if (newTask != null && !newTask.isEmpty()) {
                    tasks.add(newTask);
                }
            %>
            <%
                for (int i = 0; i < tasks.size(); i++) {
                    String task = tasks.get(i);
            %>
            <li class="list-group-item">
                Task <%=i + 1%>: <%=task%>
            </li>
            <%
                }
            %>
        </ul>
    </div>
    
    <!-- Include Bootstrap JS and jQuery (optional) if needed -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script
        src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script
        src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>