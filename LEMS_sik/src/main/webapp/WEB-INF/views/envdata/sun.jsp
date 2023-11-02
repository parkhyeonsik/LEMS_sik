<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="command" value="${pageMaker.command }" />

<title></title>
<head>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
</head>
<body class="dark-mode sidebar-mini layout-fixed layout-navbar-fixed layout-footer-fixed" style="height: auto;">
	<div class="card-header">
		<h3 class="card-title">일조시간데이터 조회</h3>
		</div>
			<section class="content">
			<div class="card">
   				<div class="card-header with-border">
   					<div id="keyword" class="card-tools" style="width: 700px;">
						<div class="input-group row">
							<!-- search bar -->
							<select class="form-control col-md-3" name="perPageNum"
								id="perPageNum" onchange="if(this.value)location.href=(this.value);">
								<option value="<%=request.getContextPath() %>/envdata/sun.do">리스트</option>
								<option value="<%=request.getContextPath() %>/envdata/sunDetail.do">그래프</option>
							</select>
							<!-- sort num -->
							<select class="form-control col-md-3" name="searchType" id="searchType" >
		                        <option>전체</option>
		                        <option value="A" ${command.searchType eq 'A' ? 'selected':'' }>A</option>
		                        <option value="B" ${command.searchType eq 'B' ? 'selected':'' }>B</option>
		                        <option value="C" ${command.searchType eq 'C' ? 'selected':'' }>C</option>
		                        <option value="D" ${command.searchType eq 'D' ? 'selected':'' }>D</option>
		                        <option value="E" ${command.searchType eq 'E' ? 'selected':'' }>E</option>
		                        <option value="F" ${command.searchType eq 'F' ? 'selected':'' }>F</option>
		                        <option value="G" ${command.searchType eq 'G' ? 'selected':'' }>G</option>
		                        <option value="H" ${command.searchType eq 'H' ? 'selected':'' }>H</option>
		                        <option value="I" ${command.searchType eq 'I' ? 'selected':'' }>I</option>
		                        <option value="J" ${command.searchType eq 'J' ? 'selected':'' }>J</option>
		                        <option value="K" ${command.searchType eq 'K' ? 'selected':'' }>K</option>
		                        <option value="L" ${command.searchType eq 'L' ? 'selected':'' }>L</option>
		                        <option value="M" ${command.searchType eq 'M' ? 'selected':'' }>M</option>
		                        <option value="N" ${command.searchType eq 'N' ? 'selected':'' }>N</option>
		                    </select>
							<!-- Date range as a button -->
							<div class="input-group-prepend">
								<span class="input-group-text"> <i
									class="far fa-calendar-alt"></i>
								</span>
							</div>
							<input type="text" class="form-control float-right"
								style="width: 100px" id="datepicker" name="datepicker" value="${command.fromDate }" placeholder="날짜 입력">
							<input type="text" class="form-control float-right"
								style="width: 100px" id="datepicker2" name="datepicker2" value="${command.toDate }" placeholder="날짜 입력">&nbsp;&nbsp;&nbsp;&nbsp;
							<!-- keyword -->
								<button class="btn btn-primary" type="button" id="searchBtn"
									data-card-widget="search" onclick="searchList_go(1);">조회</button>
							<!-- end : search bar -->
						</div>
					</div>
				</div>
			</div>
		</section>
	<div class="card-body">
		<div class="" style="position: relative; display: inline-block;">
            <div style="position: relative; display: inline-block;">
               <button id="downloadCSV" value="downloadCSV" class="btn btn-block btn-secondary btn"
                  onclick="downloadCSV();">CSV</button>
            </div>&nbsp;&nbsp;
            <div style="position: relative; display: inline-block;">
               <button id="downloadExcel" value="downloadExcel" class="btn btn-block btn-secondary btn"
                  onclick="downloadExcel();">Excel</button>
            </div>
         </div>					
	         <table class="table table-bordered table-striped" id="sunList" style="text-align:center;">
				<thead>
					<tr style='font-size:0.95em;'>
						<th style="width:10%;">No.</th>
						<th style="width:20%;">날짜</th>
						<th style="width:10%;">구간</th>
						<th style="width:20%;">일출</th>
						<th style="width:20%;">일몰</th>
						<th>밤의길이</th>
					</tr>
				</thead>
				<c:if test="${empty sunlightList }" >
					<tr>
						<td colspan="6">
							<strong>해당 내용이 없습니다.</strong>
						</td>
					</tr>
		  		</c:if>
				<tbody>
		  		<c:forEach items="${sunlightList }" var="sunlight">
		  			<tr style='font-size:1em;'>
		  				<td>${sunlight.sunNum }</td>
		  			<td>
						<fmt:formatDate value="${sunlight.sunDate }" pattern="yyyy-MM-dd"/>
					</td>
					<td>${sunlight.hwCode }</td>
					<td>
						<fmt:parseDate value="${sunlight.sunRise }" var="sunRise" pattern="Hmm" />
						<fmt:formatDate value="${sunRise }" pattern="H:mm"/>
					</td>
					<td>
						<fmt:parseDate value="${sunlight.sunSet }" var="sunSet" pattern="HHmm" />
						<fmt:formatDate value="${sunSet }" pattern="HH:mm"/>
					</td>
					<td>
						<fmt:parseDate value="${sunlight.fullLight }" var="fullLight" pattern="HHmm" />
						<fmt:formatDate value="${fullLight }" pattern="HH:mm"/>
					</td>
		  			</tr>
		  		</c:forEach>	
				</tbody>
			</table>
		</div>
		<div class="card-footer">
			<%@ include file="/WEB-INF/views/envdata/Sunpagination.jsp" %>				
		</div>
<%@ include file="/WEB-INF/views/module/footer_js.jsp" %>

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/xlsx/0.18.0/xlsx.full.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/FileSaver.js/2.0.5/FileSaver.min.js"></script>

<script>
<!-- datetimepicker -->
$(function() {
	 $.datepicker.setDefaults({
	     dateFormat: 'yy-mm-dd' 
	     ,showOtherMonths: true 
	     ,showMonthAfterYear:true
	     ,changeYear: true
	     ,changeMonth: true               
	     ,yearSuffix: "년" 
	     ,monthNamesShort: ['1','2','3','4','5','6','7','8','9','10','11','12']
	     ,monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] 
	     ,dayNamesMin: ['일','월','화','수','목','금','토']
	     ,dayNames: ['일요일','월요일','화요일','수요일','목요일','금요일','토요일'] 
	     ,minDate: "-2Y" 
	     ,maxDate: "+3M"               
	 });

	 $("#datepicker").datepicker();                    
	 $("#datepicker2").datepicker();
	 
    //$('#datepicker').datepicker('setDate', 'today'); 
    //$('#datepicker2').datepicker('setDate', 'today');
	 
	});

//downloadCSV
function downloadCSV() {
   const table = document.getElementById("sunList"); // 테이블 설정
   const rows = table.getElementsByTagName("tr"); // 행 저장
    let csvContent = "\uFEFF"; // BOM (utf8이 자꾸 안돼서 이걸로 함)

    const headerCells = rows[0].getElementsByTagName("th"); // 제목 행
    const headerRowData = []; // 제목 행 데이터 저장 배열
    for (const cell of headerCells) {
        headerRowData.push(cell.textContent.trim()); // 제목 행 공백 자르고 배열에 저장
    }
    csvContent += headerRowData.join(",") + "\n"; // 쉼표로 데이터 구분, 개행 문자로 행 구분

    for (let i = 1; i < rows.length; i++) { // 1부터 시작해서 제목 행 다음부터 반복문 실행
        const cells = rows[i].getElementsByTagName("td"); // 데이터 저장
        if (cells.length > 0) {
            const rowData = []; // 데이터 저장 배열
            for (const cell of cells) {
                rowData.push(cell.textContent.trim()); // 데이터 공백 자르고 배열에 저장
            }
            csvContent += rowData.join(",") + "\n"; // 쉼표, 개행 문자로 데이터 구분
        }
    }

    const encodedUri = "data:text/csv;charset=utf-8," + encodeURIComponent(csvContent); // uri로 인코딩
    const link = document.createElement("a");
    link.setAttribute("href", encodedUri);
    link.setAttribute("download", "sunList.csv"); // .csv 다운로드하는 링크
    document.body.appendChild(link);
    link.click(); // <a> 클릭해서 다운로드 시작
}

//downloadExcel
function downloadExcel() {
   const table = document.getElementById("sunList"); // 테이블 설정
   const rows = table.getElementsByTagName("tr"); // 행 저장
    let excelContent = "\uFEFF"; // BOM (utf8이 자꾸 안돼서 이걸로 함)

    const headerCells = rows[0].getElementsByTagName("th"); // 제목 행
    const headerRowData = []; // 제목 행 데이터 저장 배열
    for (const cell of headerCells) {
        headerRowData.push(cell.textContent.trim()); // 제목 행 공백 자르고 배열에 저장
    }
    excelContent += headerRowData.join(",") + "\n"; // 쉼표로 데이터 구분, 개행 문자로 행 구분

    for (let i = 1; i < rows.length; i++) { // 1부터 시작해서 제목 행 다음부터 반복문 실행
        const cells = rows[i].getElementsByTagName("td"); // 데이터 저장
        if (cells.length > 0) {
            const rowData = []; // 데이터 저장 배열
            for (const cell of cells) {
                rowData.push(cell.textContent.trim()); // 데이터 공백 자르고 배열에 저장
            }
            excelContent += rowData.join(",") + "\n"; // 쉼표, 개행 문자로 데이터 구분
        }
    }

    const encodedUri = "data:text/excel;charset=utf-8," + encodeURIComponent(excelContent); // uri로 인코딩
    const link = document.createElement("a");
    link.setAttribute("href", encodedUri);
    link.setAttribute("download", "sunList.xls"); // .csv 다운로드하는 링크
    document.body.appendChild(link);
    link.click(); // <a> 클릭해서 다운로드 시작
}

</script>
</body>
</html>