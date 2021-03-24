<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<title>MetroMap in JEE</title>


<style>
@import
	url('https://fonts.googleapis.com/css2?family=Roboto&display=swap');

@import
	url('https://fonts.googleapis.com/css2?family=Ubuntu:wght@300;700&display=swap')
	;
</style>

<link href="css/style77.css" rel="stylesheet">

<style>
@import
	url('https://fonts.googleapis.com/css2?family=Roboto&display=swap');

@import
	url('https://fonts.googleapis.com/css2?family=Ubuntu:wght@300;700&display=swap')
	;
</style>

</head>
<body>

	<div id="particles-js" id="particles-js"></div>
	<script type="text/javascript" src="js/particles.js"></script>
	<script type="text/javascript" src="js/app.js"></script>



	<div id="duplicate">
		<div id="seconddup">
			<DIV>
				<h1>Don't get lost in Boston anymore !</h1>
			</DIV>

			<div id="MainFrame">



				<div id="PictureFrame">
					<img id="thePic" src="png/BostonMetroMap.png">
				</div>


				<form method="post" id="FormFrame">
					<div id="inputofformFrame">

						<div class="INPUT">
							<Label>Start</Label> 
								<select name="start" class="InputColor">
								<c:forEach items="${ options }" var="option">
									<p id="texst">
										<option value="${option.value}">${option.key}</option>
									</p>
								</c:forEach>
							</select>
						</div>

						<div class="INPUT">
							<Label>End&nbsp&nbsp</Label> 
								<select name="end" class="InputColor">
								<c:forEach items="${ options }" var="option">
									<p id="texst">
										<option value="${option.value}">${option.key}</option>
									</p>
								</c:forEach>
							</select>
						</div>

						<div class="SUMBITING">
							<input type="submit" class="InputColor"></input>
						</div>
					</div>
					<div id="BackEndresultFrame">
						<div id="anotherframefortest">
							<c:if test="${ route != null }">
								<c:forEach items="${ route.names }" var="station">
									<p id="texst">
										<c:out value="${ station }" />
									</p>
								</c:forEach>
							</c:if>
						</div>
					</div>

				</form>

			</div>
		</div>
	</div>

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"
		integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg=="
		crossorigin="anonymous"></script>
</body>
</html>
