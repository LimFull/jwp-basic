<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="kr">
<head>
	<%@ include file="/include/header.jspf" %>
</head>
<body>
<%@ include file="/include/navigation.jspf" %>

<div class="container" id="main">
	<div class="col-md-12 col-sm-12 col-lg-10 col-lg-offset-1">
		<div class="panel panel-default">
			<header class="qna-header">
				<h2 class="qna-title">${question.title}</h2>
			</header>
			<div class="content-main">
				<article class="article">
					<div class="article-header">
						<div class="article-header-thumb">
							<img src="data:image/jpeg;base64,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" class="article-author-thumb" alt="">
						</div>
						<div class="article-header-text">
							<a href="/users/92/kimmunsu" class="article-author-name">${question.writer}</a>
							<a href="/questions/413" class="article-header-time" title="퍼머링크">
								<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${question.createdDate}" />
								<i class="icon-link"></i>
							</a>
						</div>
					</div>
					<div class="article-doc">
						${question.contents}
					</div>
					<div class="article-util">
						<ul class="article-util-list">
							<li>
								<a class="link-modify-article" href="#">수정</a>
							</li>
							<li>
								<form class="form-delete" action="#" method="POST">
									<input type="hidden" name="_method" value="DELETE">
									<button class="link-delete-article" type="submit">삭제</button>
								</form>
							</li>
							<li>
								<a class="link-modify-article" href="/">목록</a>
							</li>
						</ul>
					</div>
				</article>

				<div class="qna-comment">
					<div class="qna-comment-slipp">
						<p class="qna-comment-count"><strong>${question.countOfAnswer}</strong>개의 의견</p>
						<div class="qna-comment-slipp-articles">

							<c:forEach items="${answers}" var="each">
							<article class="article">
								<div class="article-header">
									<div class="article-header-thumb">
										<img src="https://graph.facebook.com/v2.3/1324855987/picture" class="article-author-thumb" alt="">
									</div>
									<div class="article-header-text">
										${each.writer}
										<div class="article-header-time"><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${each.createdDate}" /></div>
									</div>
								</div>
								<div class="article-doc comment-doc">
									<p>${each.contents}</p>
								</div>
								<div class="article-util">
									<ul class="article-util-list">
										<li>
											<a class="link-modify-article" href="/api/qna/updateAnswer?answerId=${each.answerId}">수정</a>
										</li>
										<li>
											<form class="form-delete" action="/api/qna/deleteAnswer" method="POST">
												<input type="hidden" name="answerId" value="${each.answerId}" />
												<button type="submit" class="link-delete-article">삭제</button>
											</form>
										</li>
									</ul>
								</div>
							</article>
                            </c:forEach>
                       
							<div class="answerWrite">
								<form name="answer" method="post">
									<input type="hidden" name="questionId" value="${question.questionId}">
									<div class="form-group col-lg-4" style="padding-top:10px;">
										<input class="form-control" id="writer" name="writer" placeholder="이름">
									</div>
									<div class="form-group col-lg-12">
										<textarea name="contents" id="contents" class="form-control" placeholder=""></textarea>
									</div>
									<input class="btn btn-success pull-right" type="submit" value="답변하기" />
									<div class="clearfix" />
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<script type="text/template" id="answerTemplate">
	<article class="article">
		<div class="article-header">
			<div class="article-header-thumb">
				<img src="https://graph.facebook.com/v2.3/1324855987/picture" class="article-author-thumb" alt="">
			</div>
			<div class="article-header-text">
				{0}
				<div class="article-header-time">{1}</div>
			</div>
		</div>
		<div class="article-doc comment-doc">
			{2}
		</div>
		<div class="article-util">
			<ul class="article-util-list">
				<li>
					<a class="link-modify-article" href="/api/qna/updateAnswer/{3}">수정</a>
				</li>
				<li>
					<form class="form-delete" action="/api/qna/deleteAnswer" method="POST">
						<input type="hidden" name="answerId" value="{4}" />
						<button type="submit" class="link-delete-article">삭제</button>
					</form>
				</li>
			</ul>
		</div>
	</article>
</script>

<%@ include file="/include/footer.jspf" %>
</body>
</html>