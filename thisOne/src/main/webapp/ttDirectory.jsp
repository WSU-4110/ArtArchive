<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="WEB-INF/styles.css" rel="stylesheet" type="text/css">
<html>
<header><h1>ART ARCHIVE - Tutorial and Technique Directory</h1></header>
<%@ include file="WEB-INF/head.html" %>
<body>
<%@ include file="WEB-INF/navbar.html" %>
<div class="accordion md-accordion accordion-1" id="accordionAA" role="tablist">
  <div class="card">
    <div class="card-header" role="tab">
      <h5 class="text-uppercase">
        <a class="font-weight-bold" data-toggle="collapse" href="#collapse01" aria-expanded="true"
          aria-controls="collapse01">Digital Art</a>
      </h5>
    </div>
    <div id="collapse01" class="collapse show" role="tabpanel" aria-labelledby="heading01"
      data-parent="#accordionAA">
	  <div class="card">
    <div class="card-header" role="tab">
      <h5 class="text-uppercase">
        <a data-toggle="collapse" href="#collapse01" aria-expanded="true"
          aria-controls="collapse01">Procreate</a>
      </h5>
    </div>
      <div class="card-body">
        <div class="row my-4">
          <div class="col-md-8">
            <h2 class="font-weight-bold">Getting familiar with Procreate.</h2>
            <p class="">Test tutorial post.</p>
          </div>
          <div class="col-md-4 mt-3 pt-2">
            <div class="view z-depth-1">
              <img src="images/ttDirectory/image2.png" alt="image2.png" class="img-fluid">
            </div>
          </div>
        </div>
      </div>
    </div>
	<div class="card-header" role="tab" id="heading01">
      <h5 class="text-uppercase">
        <a data-toggle="collapse" href="#collapse01" aria-expanded="true"
          aria-controls="collapse01">Portraits</a>
      </h5>
    </div>
      <div class="card-body">
        <div class="row my-4">
          <div class="col-md-8">
            <h2 class="font-weight-bold">Drawing a portrait.</h2>
            <p class="">Test tutorial post.</p>
          </div>
          <div class="col-md-4 mt-3 pt-2">
            <div class="view z-depth-1">
              <img src="images/ttDirectory/image1.png" alt="image1.png" class="img-fluid">
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="card">
    <div class="card-header" role="tab" id="heading02">
      <h5 class="text-uppercase">
        <a class="font-weight-bold" class="collapsed" data-toggle="collapse" href="#collapse02"
          aria-expanded="false" aria-controls="collapse02">Photography</a>
      </h5>
    </div>
    <div id="collapse02" class="collapse" role="tabpanel" aria-labelledby="heading02"
      data-parent="#accordionAA">
      <div class="card-body">
        <div class="row my-4">
          <div class="col-md-8">
            <h2 class="font-weight-bold">Two-Thirds Rule</h2>
            <p class="">Test tutorial post</p>
          </div>
          <div class="col-md-4 mt-3 pt-2">
            <div class="view z-depth-1">
              <img src="images/ttDirectory/photography0.jpg" alt="" class="img-fluid">
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="card">
    <div class="card-header" role="tab" id="heading03">
      <h5 class="text-uppercase">
        <a class="font-weight-bold" class="collapsed" data-toggle="collapse" href="#collapse03"
          aria-expanded="false" aria-controls="collapse03">Sketching</a>
      </h5>
    </div>
    <div id="collapse03" class="collapse" role="tabpanel" aria-labelledby="heading03"
      data-parent="#accordionAA">
      <div class="card-body">
        <div class="row my-4">
          <div class="col-md-8">
            <h2 class="font-weight-bold">Choosing the right pencil.</h2>
            <p class="">Test tutorial post.</p>
          </div>
          <div class="col-md-4 mt-3 pt-2">
            <div class="view z-depth-1">
              <img src="images/ttDirectory/sketch0.jpg" alt="" class="img-fluid">
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>
