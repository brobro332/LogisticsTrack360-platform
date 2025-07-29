<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<style>
  footer {
    background-color: #f8f9fa;
    border-top: 1px solid #dee2e6;
    padding: 1rem 2rem;
    text-align: center;
    font-size: 0.9rem;
    color: #6c757d;
  }

  footer nav ul {
    list-style: none;
    padding: 0;
    margin-top: 0.5rem;
    display: flex;
    justify-content: center;
    gap: 1rem;
  }

  footer nav ul li a {
    color: #0d6efd;
    text-decoration: none;
    font-weight: 500;
    transition: color 0.2s;
  }

  footer nav ul li a:hover {
    color: #0a58ca;
    text-decoration: underline;
  }

  @media (max-width: 576px) {
    footer {
      font-size: 0.8rem;
      padding: 1rem;
    }
    footer nav ul {
      flex-direction: column;
      gap: 0.25rem;
    }
  }
</style>

<p class="mb-1">© 2025 LogisticsTrack360. All rights reserved.</p>
	<nav>
		<ul>
			<li><a href="https://github.com/brobro332/LogisticsTrack360-platform" target="_blank"><i class="fab fa-github me-1"></i>GitHub</a></li>
		</ul>
	</nav>
</body>
</html>