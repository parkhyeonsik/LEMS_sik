<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title><decorator:title /></title>

  <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&amp;display=fallback">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/bootstrap/plugins/fontawesome-free/css/all.min.css">
  <!-- Data range -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap/plugins/daterangepicker/daterangepicker.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/bootstrap/dist/css/adminlte.min.css?v=3.2.0">
  <!-- overlayScrollbars -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap/plugins/overlayScrollbars/css/OverlayScrollbars.min.css">  

  <!--kwang-->
  <!-- datepicker -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap/plugins/daterangepicker/daterangepicker.css">
  <!-- jQuery UI CSS파일 --> 
  <link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />  
  <!-- jQuery 기본 js파일  --> 
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>  
  <!-- jQuery UI 라이브러리 js파일 -->
  <script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
  
  <!-- uha -->
  <!-- toggle -->
  <link href="<%=request.getContextPath()%>/resources/bootstrap/css/bootstrap-toggle.min.css" rel="stylesheet">
  <!-- dateandtimepicker -->
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/flatpickr/dist/flatpickr.min.css">
  <script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>
  <script src="https://cdn.jsdelivr.net/npm/flatpickr/dist/l10n/ko.js"></script>
  
  <!-- soon -->
  <!-- route style -->
  <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/route.css" type="text/css">
  <!-- weather style -->
  <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/weather.css" type="text/css">
  <!-- chart style -->
  <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/chart.css" type="text/css">

<decorator:head />
</head>

<body class="dark-mode sidebar-mini layout-fixed layout-navbar-fixed" style="height: auto;">




