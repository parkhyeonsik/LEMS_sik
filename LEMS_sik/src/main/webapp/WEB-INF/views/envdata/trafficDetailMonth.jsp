<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="command" value="${pageMaker.command }" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고속도로환경분석(교통)</title>
<!-- Google Font: Source Sans Pro -->
<link rel="stylesheet"
   href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
<!-- Font Awesome Icons -->
<link rel="stylesheet"
   href="<%=request.getContextPath()%>/resources/bootstrap/plugins/fontawesome-free/css/all.min.css">

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<link rel="stylesheet"
   href="<%=request.getContextPath()%>/resources/bootstrap/plugins/daterangepicker/daterangepicker.css">
<!-- Theme style -->
<link rel="stylesheet"
   href="<%=request.getContextPath()%>/resources/bootstrap/dist/css/adminlte.min.css">

<style>
</style>
</head>
<body
   class="dark-mode sidebar-mini layout-fixed layout-navbar-fixed layout-footer-fixed"
   style="height: auto;">
   <div class="card-header">
      <h3 class="card-title">교통데이터 조회</h3>
   </div>
   <section class="content">
      <div class="card">
         <div class="card-header with-border">
            <div id="keyword" class="card-tools" style="width: 750px;">
               <div class="input-group row">
                  <!-- search bar -->
                  <select class="form-control col-md-3" name="perPageNum"
                     id="perPageNum" onchange="location.href=this.value">
                     <option value="<%=request.getContextPath() %>/envdata/trafficDetail.do">그래프</option>
                     <option value="<%=request.getContextPath() %>/envdata/traffic.do">리스트</option>
                  </select>
                  <select class="form-control col-md-3" name="perPageNum"
                     id="perPageNum" onchange="location.href=this.value">
                     <option value="<%=request.getContextPath() %>/envdata/trafficDetailMonth.do">월</option>
                     <option value="<%=request.getContextPath() %>/envdata/trafficDetail.do">일</option>
                  </select>
                  <!-- sort num -->
                  <%-- <select class="form-control col-md-3" name="searchType" id="searchType">
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
                           data-card-widget="search" onclick="searchList_go(1);">조회</button> --%>
                     <!-- end : search bar -->
               </div>
            </div>
         </div>
      </div>
   </section>
   <div class="card-body">
      <div class="row">
         <section class="col-lg-8">
            <div id="pdfDiv">
            <div class="card">
               <div class="card-body">
                <button id="savePdfBtn" value="pdf다운로드" class="btn btn-block btn-secondary" style="width:5%;" >PDF</button>
                  <div class="trafficCanvas">
                     <canvas id="trafficChart" height="100%"></canvas>
                  </div>
               </div>
            </div>
            </div>
            <div class="card">
               <table class="table-s table-bordered dataTable dtr-inline"
                  style="width: 100%; height: 90%; text-align: center;">
                  <thead>
                     <tr style="font-size: 1.5em;">
                        <th style="width: 20%;">구분</th>
                        <th style="width: 40%;">교통량</th>
                        <th style="width: 40%;">통행속도</th>
                     </tr>
                  </thead>
                  <tbody style="font-size: 1.3em;">
                     <tr>
                        <td>평균</td>
                        <td>${staticMap.MontraAvg }</td>
                        <td>${staticMap.MonspAvg }</td>
                     </tr>
                     <tr>
                        <td>표준편차</td>
                        <td>${staticMap.Montradevi }</td>
                        <td>${staticMap.Monspdevi }</td>
                     </tr>
                     <tr>
                        <td>최대값</td>
                        <td>${staticMap.Montramax }</td>
                        <td>${staticMap.Monspmax }</td>
                     </tr>
                     <tr>
                        <td>최소값</td>
                        <td>${staticMap.Montramin }</td>
                        <td>${staticMap.Monspmin }</td>
                     </tr>
                  </tbody>
               </table>
            </div>
         </section>
         <div class="col-lg-4" >
         <div class="" style="position: relative; display: inline-block;">
               <div style="position: relative; display: inline-block;">
                  <button id="downloadCSV" value="downloadCSV" class="btn btn-block btn-secondary btn-md" 
                     onclick="downloadCSV();">CSV</button>
               </div>&nbsp;&nbsp;
               <div style="position: relative; display: inline-block;">
                  <button id="downloadExcel" value="downloadExcel" class="btn btn-block btn-secondary btn-md" 
                     onclick="downloadExcel();">Excel</button>
               </div>
            </div>
            <table class="table table-bordered table-striped" id="monthData" style="text-align: center;">
               <thead>
                  <tr style="font-size: 0.95em;">
                     <th style="width: 25%;">날짜</th>
                     <th style="width: 20%;">구간</th>
                     <th style="width: 25%;">교통량</th>
                     <th style="width: 30%;">통행속도</th>
                  </tr>
               </thead>
                  <c:if test="${empty monthData }">
                     <tr>
                        <td colspan="5"><strong>해당 내용이 없습니다.</strong></td>
                     </tr>
                  </c:if>
               <tbody>
                  <c:forEach items="${monthData }" var="data">
                     <tr style='font-size: 1em;'>
                        <td>${data.strDate }</td>
                        <td>${data.hwCode }</td>
                        <td>${data.dayTrf }</td>
                        <td>${data.daySpd }</td>
                     <tr>
                  </c:forEach>
               </tbody>
            </table>
            <%-- <%@ include file="/WEB-INF/views/envdata/trafficDetailMonthpagination.jsp" %>       --%>      
         </div>
      </div>
   </div>

   <%@ include file="/WEB-INF/views/module/footer_js.jsp"%>

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.2.61/jspdf.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/html2canvas/0.4.1/html2canvas.js"></script>

<script>
   
   $(function() {
       $.datepicker.setDefaults({
           dateFormat: 'yy-mm' 
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
       
      });
   
   
   var doc = new jsPDF();
   var specialElementHandlers = {
       '#editor': function(element, renderer) {
           return true;
       }
   }
    
   $('#savePdfBtn').click(function() {
       html2canvas($("#pdfDiv"), {
           onrendered : function(canvas) {
               // 한글깨짐현상때문에 jpeg->jspdf 전환
               var imgData = canvas.toDataURL('image/jpeg');
               var pageWidth = 210;
               var pageHeight = pageWidth * 1.414;
               var imgWidth = pageWidth - 20;
               var imgHeight = $('#pdfDiv').height() * imgWidth / $('#pdfDiv').width();
               var doc = new jsPDF('p','mm',[pageHeight, pageWidth]);
               doc.addImage(imgData, 'JPEG', 10, 10, imgWidth, imgHeight);
               doc.save('trafficMonth.pdf');
           }
       });
   });
    //downloadCSV
      function downloadCSV() {
         const table = document.getElementById("dayMonthList"); // 테이블 설정
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
          link.setAttribute("download", "trafficMonthList.csv"); // .csv 다운로드하는 링크
          document.body.appendChild(link);
          link.click(); // <a> 클릭해서 다운로드 시작
      }
      
    //downloadExcel
      function downloadExcel() {
         const table = document.getElementById("dayMonthList"); // 테이블 설정
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
          link.setAttribute("download", "trafficMonthList.xls"); // .csv 다운로드하는 링크
          document.body.appendChild(link);
          link.click(); // <a> 클릭해서 다운로드 시작
      }

    //chart
    // var ctx = document.getElementById("myChart");
  $(function(){
       var ctx = document.getElementById('trafficChart').getContext('2d');
       var chart = new Chart(ctx, {
           type: 'line',
           data: chartData,
           options: chartOptions
       })
   })
//    alert(typeof(labels[0]));
   // chart data and options
   var chartData = {
       labels: [],
       datasets: [
          
           {
               label: '교통량',
               type:'bar',
               yAxisID: 'y-left',
               data: [],
               backgroundColor: [
                   'rgba(255, 204, 153, 0.4)'
               ],
               borderColor: [
                  'rgba(255, 204, 153, 0.4)'
               ],
               borderWidth: 2
           },
           {
               label: '통행속도',
               yAxisID: 'y-right',
               data: [],
               backgroundColor: [
                   '#6699FF'
               ],
               borderColor: [
                   '#6699FF'
               ],
               borderWidth: 2
           }
       ]
   }

   var chartOptions = {
          responsive: true,
          scales: {
              x: {
                  title: {
                      display: true,
                      text: '구간',
                      color: 'white',
                      font: {
                          size: 20 
                          }
                  }
              },
              'y-left': {
                  type: 'linear',
                  position: 'left',
                  title: {
                      display: true,
                      text: '교통량',
                      color: 'white',
                      font: {
                          size: 20 
                      },
                      grid: {
                          display: false
                      }
                  }
              },
              'y-right': {
                  type: 'linear',
                  position: 'right',
                  title: {
                      display: true,
                      text: '주행속도',
                      color: 'white',
                      font: {
                          size: 20 
                      },
                      grid: {
                          display: false
                      }
                  }
              }
          }
      }
    <c:forEach items="${monthData}" var="data">
       //chartData.labels.push('<fmt:formatDate value="${daydata.dayDate }" pattern="yyyy-MM-dd"/>'); //레이블 배열에 추가
       chartData.labels.push('${data.hwCode}');
       chartData.datasets[0].data.push(${data.dayTrf}); //데이터 배열에 추가
        chartData.datasets[1].data.push(${data.daySpd}); //데이터 배열에 추가
   </c:forEach>
        
</script>
</body>
</html>