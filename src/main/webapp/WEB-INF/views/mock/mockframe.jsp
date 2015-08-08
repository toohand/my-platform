<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>

  <meta charset="utf-8">
  <title>测试</title>

  <meta name="viewport" content="width=device-width">
  <meta name="renderer" content="ie-stand">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">

  <link rel="stylesheet" href="${ctx}/css/mock/reset.css">
  <link rel="stylesheet" href="${ctx}/css/mock/function.css">

  <link rel="stylesheet" type="text/css" href="${ctx}/css/mock/wrapper.css">
  <link rel="stylesheet" type="text/css" href="${ctx}/css/mock/wrapper-3r2c2f.css">
  <!--[if IE]>
  <link rel="stylesheet" type="text/css" href="${ctx}/css/mock/wrapper-ie.css"/>
  <![endif]-->
</head>
<body marginwidth="0" marginheight="0">
<div>
  <div class="header">
    <div class="logo"></div>
    <div class="banner">很纯洁的系统头部</div>
    <div id="toolbar">
      <ul>
        <li class="non-tab"><a><span>2014年12月15日 星期一</span></a></li>

        <li><a href="/opus/agOpusUserCompile/modifyUserPassWord.jsp?userId=4375" target="_blank"><span><i
                class="settings">修改密码</i></span></a></li>

        <li><a href="#" target="_blank"><span><i class="settings">修改手机</i></span></a>
        </li>
        <li><a href="${ctx}/mock/logout"><span><i class="logout">登出</i></span></a></li>
      </ul>
    </div>
    <div id="tabbar">
      <ul>
        <li class="non-tab">
          <a>
              <span>
                  <i>人大信息运维部</i>
                  <i>系统管理员</i>
                  <i>[主任助理]</i>

              </span>
          </a>
        </li>
        <li class="current"><a href="javascript:;"><span>我的办公室</span></a></li>
        <li><a href="/index/index.action"><span>系统控制台</span></a></li>
        <li><a href="/index/index.action"><span>人事管理</span></a></li>
      </ul>
    </div>
    <div id="menubar-wrapper">
      <div id="menubar">
        <ul>
          <li>
            <a href="#"
               target="main_frame"><span>附件管理</span></a>
          </li>
          <li>
            <a href="#"
               target="main_frame"><span>日志管理</span></a>
          </li>
          <li>
            <a href="#"
               target="main_frame"><span>社服通</span></a>
          </li>
          <li>
            <a href="${ctx}/"
               target="main_frame"><span>人房管理</span></a>
          </li>
        </ul>
      </div>
    </div>


  </div>
  <div class="right">
    <iframe id="main_frame" src="${ctx}/"  width="100%" height="100%" frameborder="no" border="0" marginwidth="0" marginheight="0" scrolling="auto" allowtransparency="yes" style="margin-bottom:-3px;"></iframe>
  </div>
  <div class="footer">

  </div>
</div>
</body>
</html>