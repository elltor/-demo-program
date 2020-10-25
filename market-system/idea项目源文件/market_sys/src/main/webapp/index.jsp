<%@ page import="org.apache.jasper.runtime.PageContextImpl" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2020/5/25
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
        pageContext.setAttribute("hostPath", basePath);
    %>
    <link rel="stylesheet" href="${hostPath}/libs/bootstrap.css">
    <link rel="stylesheet" href="${hostPath}/css/base.css">
</head>
<body>
<%--标题栏--%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="javascript:;" id="welcome_menu_btn">管理系统</a>
    <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
        <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
            <li class="nav-item">
                <a class="nav-link" href="javascript:;" id="shopping_menu_btn">商品销售</a>
            </li>

            <li class="nav-item">
                <a class="nav-link" href="javascript:;" id="vip_menu_btn">会员管理</a>
            </li>

            <li class="nav-item">
                <a class="nav-link" href="javascript:;" id="analysis_menu_btn">销售统计</a>
            </li>
        </ul>

        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" placeholder="输入姓名、手机号码、ID查询会员" style="min-width: 280px" id="global_serarch_input">
            <button class="btn btn-outline-success my-2 my-sm-0" type="button" data-toggle="modal" data-target="#search_user_model" id="global_serarch_btn">
                搜索
            </button>
        </form>
    </div>

    <!-- 搜索模态框 start -->
    <div class="modal fade" id="search_user_model" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">查询内容</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <%--搜索出的用户表--%>
                    <table class="table">
                        <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">姓名</th>
                            <th scope="col">性别</th>
                            <th scope="col">工作单位</th>
                            <th scope="col">手机号</th>
                            <th scope="col">积分</th>
                        </tr>
                        </thead>
                        <tbody id="global_search_model_table_body">
                        <tr>
                            <th scope="row">1</th>
                            <td>lqc</td>
                            <td>男</td>
                            <td>阿里巴巴</td>
                            <td>15136406316</td>
                            <td>200</td>
                        </tr>
                        <tr>
                            <th scope="row">1</th>
                            <td>lqc</td>
                            <td>男</td>
                            <td>阿里巴巴</td>
                            <td>15136406316</td>
                            <td>2000</td>
                        </tr>
                        </tbody>
                    </table>
                    <div>如果搜索用户不存在, 可能用户为注册或检索信息有误.</div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
                </div>
            </div>
        </div>
    </div>
    <!-- 搜索模态框 end -->
</nav>


<%--欢迎面板--%>
<div class="container my-section" id="welcome_main_panel">
    <div class="jumbotron">
        <h1 class="display-4">欢迎使用超市会员管理系统</h1>
        <p class="lead">你可以使用管理系统记录用户购买商品的记录，也可以使用管理系统实现对会员的管理，还可以查看用户购买商品的情况。</p>
        <hr class="my-4">
        <h5>会员及福利说明：</h5>
        <p>用户可以在系统中注册会员，当消费达到一定额度可以提升会员等级，等级越高，购买商品折扣幅度越大。具体优惠如下：</p>
        <p>Lv0:新注册用户不享受折扣</p>
        <p>Lv1:用户达到积分500，享受9.9折优惠</p>
        <p>Lv2:用户达到积分1000，享受9.8折优惠</p>
        <p>Lv3:用户达到积分2000，享受9.5折优惠</p>
        <p>Lv4:用户达到积分4000，享受9.3折优惠</p>
        <p>Lv5:用户达到积分8000，享受9.0折优惠</p>
        <p>备注：每消费一元加1积分</p>
    </div>
</div>


<%--添加商品面板--%>
<div class="container my-section" id="shopping_main_panel">
    <table class="table table-hover">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">商品名称</th>
            <th scope="col">类别</th>
            <th scope="col">单价:元</th>
            <th scope="col">数量</th>
            <th scope="col">金额</th>
        </tr>
        </thead>
        <tbody id="shopping_table_body">
        <tr>
            <th scope="row">1</th>
            <td>可口可乐</td>
            <td>饮料</td>
            <td>3</td>
            <td>5</td>
            <td>15</td>
        </tr>
        <tr>
            <th scope="row">2</th>
            <td>可口可乐</td>
            <td>饮料</td>
            <td>3</td>
            <td>5</td>
            <td>15</td>
        </tr>
        <tr>
            <th scope="row">3</th>
            <td>可口可乐</td>
            <td>饮料</td>
            <td>3</td>
            <td>5</td>
            <td>15</td>
        </tr>
        <tr>
            <th scope="row">4</th>
            <td>可口可乐</td>
            <td>饮料</td>
            <td>3</td>
            <td>5</td>
            <td>15</td>
        </tr>
        </tbody>
    </table>

    <%--模态框 start--%>
    <div class="container" style="display: flex;flex-flow: row nowrap;justify-content: center;padding-top: 20px">
        <button type="button" class="btn btn-success" data-toggle="modal" data-target="#add_goods_model" id="shpping_add_goods_btn">
            添加商品
        </button>
        <div style="padding: 0 20px"></div>
        <button type="button" class="btn btn-outline-primary" data-toggle="modal" data-target="#normal_model" id="shopping_normal_btn">
            普通结账
        </button>
        <div style="padding: 0 20px"></div>
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#vip_model" id="shopping_vip_btn">
            会员结账
        </button>

        <div style="padding: 0 20px"></div>
        <button type="button" class="btn btn-danger" id="shopping_clear_btn">
            清除订单
        </button>
    </div>


    <!-- Modal -->
    <div class="modal fade" id="add_goods_model" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel2323">Modal title</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <%--表单 start --%>
                    <form>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="shopping_add_goods_name">商品名称</label>
                                <input type="text" class="form-control" id="shopping_add_goods_name">
                            </div>
                            <div class="form-group col-md-6">
                                <label for="shopping_add_sort">商品种类</label>
                                <input type="text" class="form-control" id="shopping_add_sort">
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="shopping_add_single_price">单价:元</label>
                                <input type="number" class="form-control" id="shopping_add_single_price">
                            </div>
                            <div class="form-group col-md-6">
                                <label for="shopping_add_count">数量</label>
                                <input type="number" class="form-control" id="shopping_add_count">
                            </div>
                        </div>
                    </form>
                    <%--表单 end --%>
                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary" data-dismiss="modal" id="shopping_add_exec">确定</button>
                </div>
            </div>
        </div>
    </div>


    <%--普通结账模态框--%>
    <div class="modal fade" id="normal_model" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLab22el11">Modal title</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    请支付相应金额
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">取消结账</button>
                    <button type="button" class="btn btn-primary" data-dismiss="modal" id="shopping_normal_submit">确认结账</button>
                </div>
            </div>
        </div>
    </div>

    <%--会员结账模态框--%>
    <!-- Modal -->
    <div class="modal fade" id="vip_model" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel11">Modal title</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form>
                        <label for="shopping_phone_or_id">请输入用户手机号或ID</label>
                        <input type="text" class="form-control" id="shopping_phone_or_id">
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
                    <button type="button" class="btn btn-primary" data-dismiss="modal" id="shopping_vip_submit">确定</button>
                </div>
            </div>
        </div>
    </div>
    <%--模态框 end--%>
</div>

<%--会员管理面板--%>
<div class="container my-section" id="vip_main_panel">

    <table class="table table-hover">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">姓名</th>
            <th scope="col">性别</th>
            <th scope="col">工作单位</th>
            <th scope="col">手机号</th>
            <th scope="col">积分</th>
            <th scope="col">等级Lv</th>
            <th scope="col" style="text-align: center">操作</th>

        </tr>
        </thead>
        <tbody id="user_panel_table_body">
        <tr>
            <th scope="row">1</th>
            <td>lqc(示例)</td>
            <td>男</td>
            <td>阿里巴巴</td>
            <td>15136406316</td>
            <td>200</td>
            <td>2</td>
            <td style="display: flex;flex-flow: row nowrap;justify-content: center">
                <button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#modify_user_model">
                    修改会员
                </button>
                <div style="padding:0 5px"></div>
                <button type="button" class="btn btn-danger btn-sm">
                    删除会员
                </button>
            </td>
        </tr>
        <%--        <tr>
                    <th scope="row">2</th>
                    <td>lqc</td>
                    <td>男</td>
                    <td>阿里巴巴</td>
                    <td>15136406316</td>
                    <td>2000</td>
                    <td style="display: flex;flex-flow: row nowrap;justify-content: center">
                        <button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#modify_user_model">
                            修改会员
                        </button>
                        <div style="padding:0 5px"></div>
                        <button type="button" class="btn btn-danger btn-sm" data-toggle="modal" data-target="#vip_model">
                            删除会员
                        </button>
                    </td>
                </tr>--%>

        </tbody>
    </table>


    <div style="padding: 10px 0"></div>
    <div class="container form-row">
        <button type="button" class="btn btn-success col" data-toggle="modal" data-target="#add_user_model" style="margin: 0 50px">
            添加会员
        </button>
    </div>


    <%-----------------------------添加会员模态框 start------------------------------%>
    <div class="modal fade" id="add_user_model" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel23">添加会员</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <%--表单 start --%>
                    <form>
                        <div class="form-row">
                            <div class="form-group col-md-4">
                                <label for="add_user_username">用户姓名</label>
                                <input type="text" class="form-control" value="" id="add_user_username">
                            </div>
                            <div class="form-group col-md-4">
                                <label for="add_user_sex">性别</label>
                                <input type="text" class="form-control" placeholder="请输入男或女" value="男" id="add_user_sex">
                            </div>
                            <div class="form-group col-md-4">
                                <label for="add_user_age">年龄</label>
                                <input type="number" class="form-control" value="0" id="add_user_age">
                            </div>
                        </div>

                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="add_user_phone">手机号码</label>
                                <input type="number" class="form-control" id="add_user_phone">
                            </div>
                            <div class="form-group col-md-6">
                                <label for="add_user_work_unit">工作单位</label>
                                <input type="text" class="form-control" id="add_user_work_unit">
                            </div>
                        </div>
                    </form>
                    <%--表单 end --%>
                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
                    <button type="button" id="add_user_btn" class="btn btn-primary" data-dismiss="modal">确定</button>
                </div>
            </div>
        </div>
    </div>
    <%-----------------------------添加 会员模态框 end ------------------------------%>


    <%-----------------------------修改 会员模态框 end ------------------------------%>
    <div class="modal fade" id="modify_user_model" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel223">Modal title</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <%--表单 start --%>
                    <form>
                        <div class="form-row">
                            <div class="form-group col-md-4">
                                <label for="modify_panel_username">用户姓名</label>
                                <input type="text" class="form-control" value="" id="modify_panel_username">
                            </div>
                            <div class="form-group col-md-4">
                                <label for="modify_panel_sex">性别</label>
                                <input type="text" class="form-control" placeholder="请输入男或女" value="" id="modify_panel_sex">
                            </div>
                            <div class="form-group col-md-4">
                                <label for="modify_panel_age">年龄</label>
                                <input type="number" class="form-control" value="" id="modify_panel_age">
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="modify_panel_phone">手机号码</label>
                                <input type="number" class="form-control" value="" id="modify_panel_phone">
                            </div>
                            <div class="form-group col-md-6">
                                <label for="modify_panel_work_unit">工作单位</label>
                                <input type="text" class="form-control" value="" id="modify_panel_work_unit">
                            </div>
                        </div>
                    </form>
                    <%--表单 end --%>
                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary" data-dismiss="modal" id="modify_panel_exec">
                        修改
                    </button>
                </div>
            </div>
        </div>
    </div>
    <%-----------------------------修改 会员模态框 end ------------------------------%>
</div>


<%--------------------------------------销售统计 start----------------------------------------------%>
<div class="container my-section"  id="analysis_main_panel">
    <h5 style="padding-bottom: 10px">各类商品销售额占比</h5>
    <div class="progress" style="background: #c3c3c3;height: 80px">
        <div class="progress-bar" role="progressbar" style="width: 25%" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100" id="analysis_drink">饮料类:30%</div>
        <div class="progress-bar bg-success" role="progressbar" style="width: 25%" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100" id="analysis_food">食品类:40%</div>
        <div class="progress-bar bg-info" role="progressbar" style="width: 25%" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100" id="analysis_wash">洗化类：10%</div>
        <div class="progress-bar bg-danger" role="progressbar" style="width: 25%" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100" id="analysis_kitchen">厨具类：20%</div>
    </div>

    <div style="padding: 20px 0"></div>

    <h5 style="padding-bottom: 10px">男女会员消费比</h5>
    <div class="progress" style="background: #c3c3c3;height: 50px">
        <div class="progress-bar" role="progressbar" style="width: 0%" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100" id="analysis_man">111</div>
        <div class="progress-bar bg-danger" role="progressbar" style="width: 0%" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100" id="analysis_woman">444</div>
    </div>


    <div style="padding: 20px 0"></div>
    <h5 style="padding-bottom: 10px">销售记录</h5>

    <%--销售额表格--%>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">订单</th>
            <th scope="col">商品名称</th>
            <th scope="col">类别</th>
            <th scope="col">数量</th>
            <th scope="col">金额</th>
            <th scope="col">时间</th>
            <th scope="col">其他</th>
        </tr>
        </thead>
        <tbody id="analysis_table_body">
        <tr>
            <th scope="row">1</th>
            <td>1592039555033</td>
            <td>可口</td>
            <td>饮料</td>
            <td>5</td>
            <td>15</td>
            <td>2020.6.13</td>
            <td>用户</td>
        </tr>

        </tbody>
    </table>
</div>
<%--------------------------------------销售统计 end----------------------------------------------%>

<%--底部空白div--%>
<div class="" style="width: 100%;height: 50px"></div>

<%--依赖库--%>
<script src="${hostPath}/libs/jquery-3.4.1.js"></script>
<script src="${hostPath}/libs/bootstrap.bundle.js"></script>

<script>
/********************************* 添加会员用户 start ********************/
    //文本框
    var $addUserBtn = $("#add_user_btn");
    var $username_input = $("#add_user_username");
    var $sex_input = $("#add_user_sex");
    var $age_input = $("#add_user_age");
    var $phone_input = $("#add_user_phone");
    var $work_unit_input = $("#add_user_work_unit");
    //表格内容
    var $user_panel_table_body = $("#user_panel_table_body");
    $user_panel_table_body.html("");

    //初始加载会员列表
    $.ajax({
        url: "/findAllUserServlet",
        type: "POST",
        data: {},
        dataType: "json",
        success: function (res) {
            console.log(res);
            addUserToUserTable(res.data, $user_panel_table_body);
        },
        error: function (res) {

        }
    });

    //添加会员事件
    $addUserBtn.click(function (e) {
        console.log($username_input.val(), $sex_input.val(), $age_input.val(), $phone_input.val(), $work_unit_input.val());
        var sex = $sex_input.val() === "男" ? 0 : 1;

        $.ajax({
            url: "/addUserServlet",
            data: {
                username: $username_input.val(),
                sex: sex,
                age: $age_input.val(),
                phone: $phone_input.val(),
                work_unit: $work_unit_input.val()
            },
            dataType: "json",
            type: "POST",
            success: function (data) {
                alert(data.msg + data);
                $username_input.val("");
                $age_input.val("0");
                $sex_input.val("男")
                $phone_input.val("");
                $work_unit_input.val("");

                $user_panel_table_body.html("");
                $.ajax({
                    url: "/findAllUserServlet",
                    type: "POST",
                    data: {},
                    dataType: "json",
                    success: function (res) {
                        console.log(res);
                        addUserToUserTable(res.data, $user_panel_table_body);
                    },
                    error: function (res) {
                        console.log(res.msg)
                    }
                });
            },
            error: function (data) {
                alert(data.msg);
            }
        });
    });

    // 在用户表格中添加用户
    function addUserToUserTable(userList, body) {
        console.log(body);
        $.each(userList, function (idx, val) {
            console.log(val);

            var sex = val.sex === 0 ? "男" : "女";
            var $user_tr = $('        <tr>\n' +
                '            <th scope="row">' + (idx + 1) + '</th>\n' +
                '            <td>' + val.username + '</td>\n' +
                '            <td>' + sex + '</td>\n' +
                '            <td>' + val.work_unit + '</td>\n' +
                '            <td>' + val.phone + '</td>\n' +
                '            <td>' + val.user_exp + '</td>\n' +
                '            <td>' + val.level + '</td>\n' +
                '            <td style="display: flex;flex-flow: row nowrap;justify-content: center">\n' +
                '                <button data-userid="' + val.id + '" data-username="' + val.username + '" data-sex="' + val.sex + '"  data-age="' + val.age + '" data-work_unit="' + val.work_unit + '" data-phone="' + val.phone + '"  type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#modify_user_model">\n' +
                '                    修改' +
                '                </button>\n' +
                '                <div style="padding:0 5px"></div>\n' +
                '                <button data-userid="' + val.id + '" data-username="' + val.username + '" data-sex="' + val.sex + '"  data-age="' + val.age + '" data-work_unit="' + val.work_unit + '" data-phone="' + val.phone + '" type="button" class="btn btn-danger btn-sm">\n' +
                '                    删除' +
                '                </button>\n' +
                '            </td>\n' +
                '        </tr>');
            $(body).append($user_tr);
        });
    }

    /*--------------------修改和删除用户------------------------------------ */
    //User bean
    var modify_userid, modify_username, modify_sex, modify_age, modify_phone, modify_work_unit;

    // jQuery的delegate事件委托写法
    $('#user_panel_table_body').delegate('button', 'click', function (ev) {
        console.log(ev);
        modify_userid = ev.target.dataset.userid;
        modify_username = ev.target.dataset.username;
        modify_sex = ev.target.dataset.sex;
        modify_age = ev.target.dataset.age;
        modify_phone = ev.target.dataset.phone;
        modify_work_unit = ev.target.dataset.work_unit;

        // 打印
        console.log(modify_userid, modify_username, modify_sex, modify_age, modify_phone, modify_work_unit, ev);

        //同步修改面板信息
        set_modify_panel_data();

        //执行删除操作
        if (ev.target.innerText === "删除") {
            deleteUserFromUserTable()
        }
    });

    //同步修改面板信息函数
    function set_modify_panel_data() {
        $("#modify_panel_username").val(modify_username);
        $("#modify_panel_sex").val(modify_sex == 0 ? "男" : "女")
        $("#modify_panel_age").val(modify_age);
        $("#modify_panel_phone").val(modify_phone);
        $("#modify_panel_work_unit").val(modify_work_unit);
    }


    /*----------------------修改会员信息事件-----------------------*/
    $("#modify_panel_exec").click(function (ev) {
        var sex = $("#modify_panel_sex").val() === "男" ? 0 : 1;
        $.ajax({
            url: "/modifyUserServlet",
            data: {
                userid: modify_userid,
                username: $("#modify_panel_username").val(),
                sex: sex,
                age: $("#modify_panel_age").val(),
                phone: $("#modify_panel_phone").val(),
                work_unit: $("#modify_panel_work_unit").val()
            },
            dataType: "json",
            type: "POST",
            success: function (data) {
                $user_panel_table_body.html("");
                $.ajax({
                    url: "/findAllUserServlet",
                    type: "POST",
                    data: {},
                    dataType: "json",
                    success: function (res) {
                        console.log(res);
                        addUserToUserTable(res.data, $user_panel_table_body);
                    }
                });
            },
            error: function (data) {
                alert(data.msg);
            }
        });
        alert("修改会员信息")
    });
    /*----------------------修改会员信息事件 end-----------------------*/


    /*----------------------删除会员---------------------- */
    function deleteUserFromUserTable() {
        $.ajax({
            url: "/deleteUserServlet",
            data: {
                userid: modify_userid,
            },
            dataType: "json",
            type: "POST",
            success: function (data) {
                console.log(data.msg + data);

                $user_panel_table_body.html("");
                $.ajax({
                    url: "/findAllUserServlet",
                    type: "POST",
                    data: {},
                    dataType: "json",
                    success: function (res) {
                        console.log(res);
                        addUserToUserTable(res.data, $user_panel_table_body);
                    }
                });
            },
            error: function (data) {
                alert(data.msg);
            }
        });
    }

    /*----------------------删除会员  end ---------------------- */
/**********************会员用户管理 end ***********************************************/





/**********************商品管理 start ***************************************************/
    //按钮
    var $goods_add = $("#shpping_add_goods_btn");//待定
    var $shopping_normal = $("#shopping_normal_btn");
    var $shopping_vip = $("#shopping_vip_btn");
    var $shopping_clean = $("#shopping_clear_btn");//待定

    //表格主体
    var $shopping_table_body = $("#shopping_table_body");
    $shopping_table_body.html("");//初始化清除表格内容

    //添加商品模态框数据
    var $shopping_panel_goods_name_input = $("#shopping_add_goods_name");
    var $shopping_panel_sort_input = $("#shopping_add_sort");
    var $shopping_panel_single_price_input = $("#shopping_add_single_price");
    var $shopping_panel_count_input = $("#shopping_add_count");


    var tr_count = 0;
    var all_price = 0;
    var sign = getTimestamp();
    var discount = [1, 0.99, 0.98, 0.95, 0.93, 0.90, 0.90, 0.90, 0.90, 0.90];//折扣

    $("#shopping_add_exec").click(function (ev) {
        tr_count++;
        var goods_name = $shopping_panel_goods_name_input.val();
        var sort = $shopping_panel_sort_input.val();
        var single_price = parseInt($shopping_panel_single_price_input.val());
        var count = parseInt($shopping_panel_count_input.val());
        var total_price = single_price * count;
        var order_id = sign;

        var $tr = $(
            '<tr>\n' +
            '      <th scope="row">' + tr_count + '</th>\n' +
            '      <td>' + goods_name + '</td>\n' +
            '      <td>' + sort + '</td>\n' +
            '      <td>' + single_price + '</td>\n' +
            '      <td>' + count + '</td>\n' +
            '      <td>' + total_price + '</td>\n' +
            '</tr>'
        );

        $.ajax({
            url: "/addShoppingInfoServlet",
            data: {
                order_id: order_id,
                goods_name: goods_name,
                sort: sort,
                count: count,
                price: total_price
            },
            type: "POST",
            dataType: "json",
            success: function (res) {
                //清除上次数据
                $shopping_panel_goods_name_input.val("");
                $shopping_panel_sort_input.val("");
                $shopping_panel_single_price_input.val("");
                $shopping_panel_count_input.val("");

                //往table中添加行
                $shopping_table_body.append($tr);
                all_price += total_price;
            },
            error: function (res) {
                alert(res.msg);
            }
        });

    });


    $("#shopping_normal_submit").click(function (ev) {
        sign = getTimestamp();
        $shopping_table_body.html("");
        alert("支付金额:" + all_price);
        tr_count = 0;
        all_price = 0;
    });


    $("#shopping_vip_submit").click(function (ev) {
        var order_id = sign;
        var phone_or_id = $("#shopping_phone_or_id").val();

        $.ajax("/findUserByPhoneOrIdServlet", {
            type: "POST",
            dataType: "json",
            data: {
                phone_or_id: phone_or_id
            },
            success: function (res) {
                console.log(res);
                var out_res = res;
                if (res.data !== null) {
                    $.ajax("/modifyShoppingInfoUseridServlet", {
                        type: "POST",
                        dataType: "json",
                        data: {
                            order_id: order_id,
                            userid: res.data.id
                        },
                        success: function (res) {
                            //会员给予折扣
                            var discounted = Math.floor(all_price * discount[out_res.data.level] * 100) / 100;
                            alert("你的会员等级是:" + out_res.data.level + "\n折扣前:" + all_price + "\n折扣后价格:" + discounted + "\n积分增加:" + Math.floor(discounted));
                            $.ajax("/addUserShoppingExpServlet", {
                                type: "POST",
                                dataType: "json",
                                data: {
                                    userid: out_res.data.id,
                                    exp: Math.floor(discounted)
                                },
                                success: function (res) {
                                    console.log(res.msg)
                                },
                                error: function (res) {
                                    console.log(res.msg)
                                }
                            });
                            sign = getTimestamp();
                            tr_count = 0;
                            all_price=0;
                            $shopping_table_body.html("");
                        },
                        error: function (res) {
                            alert(res.msg);
                        }
                    })
                } else {
                    alert("该用户不存在请先注册")
                }
            },
            error: function (res) {
                alert(res.msg);
            }
        });
    });

    //时间戳工具
    function getTimestamp() {
        return new Date().getTime();
    }

    //清除当前订单
    $("#shopping_clear_btn").click(function (ev) {
        var order_id = sign;
        $.ajax("/deleteNowOrderServlet", {
            type: "POST",
            dataType: "json",
            data: {
                order_id: order_id
            },
            success: function (res) {
                alert(res.msg);
                sign = getTimestamp();
                $shopping_table_body.html("");
                all_price=0;
                tr_count=0;
            },
            error:function (res) {
                alert(res.msg);
            }
        });
    });
/************************** 商品管理 end **************************************************/






/************************** 搜索功能 start ***************************************************/
var $global_search_input = $("#global_serarch_input");
var $global_search_btn = $("#global_serarch_btn");
var $global_search_table_body = $("#global_search_model_table_body");


$global_search_btn.click(function (ev) {
    $global_search_table_body.html("");
    console.log($global_search_input.val());
    $.ajax("/fuzzyQueryByPhoneOrIdServlet",{
        type:"POST",
        dataType:"json",
        data:{
            keyWords:$global_search_input.val()
        },
        success:function (res) {
            console.log(res);
            $.each(res.data,function (idx,val) {
                var sex = val.sex===0?"男":"女";
                var $tr = $('<tr>\n' +
                    '              <th scope="row">'+idx+1+'</th>\n' +
                    '              <td>'+val.username+'</td>\n' +
                    '              <td>'+sex+'</td>\n' +
                    '              <td>'+val.work_unit+'</td>\n' +
                    '              <td>'+val.phone+'</td>\n' +
                    '              <td>'+val.user_exp+'</td>\n' +
                    '        </tr>'
                )
                $global_search_table_body.append($tr);
            });
        },
        error:function (res) {
            console.log(res.msg);
        }

    })
});
/************************** 搜索功能 end ***************************************************/






/************************** 销售统计 start ***************************************************/
//各类商品购买人数比
var $analysis_drink_sort = $("#analysis_drink");
var $analysis_food_sort = $("#analysis_food");
var $analysis_wash_sort = $("#analysis_wash");
var $analysis_kitchen_sort = $("#analysis_kitchen");

$.ajax("/findSortPriceServlet",{
    type:"POST",
    dataType:"json",
   success:function (res) {
        var totalPrice = parseFloat(res.data.totalPrice);
        var drink = parseFloat(res.data['饮料']);
        var food = parseFloat(res.data['食品']);
        var wash = parseFloat(res.data['洗化']);
        var kitchen = parseFloat(res.data['厨具']);


       var drink_percent = Math.ceil((drink/totalPrice)*1000)/10;
       var food_percent = Math.ceil((food/totalPrice)*1000)/10;
       var wash_percent = Math.ceil((wash/totalPrice)*1000)/10;
       var kitchen_percent = Math.ceil((kitchen/totalPrice)*1000)/10;
       console.log(drink_percent,food_percent,wash_percent,kitchen_percent);

       $analysis_drink_sort.css("width",drink_percent+"%");
       $analysis_food_sort.css("width",food_percent+"%");
       $analysis_wash_sort.css("width",wash_percent+"%");
       $analysis_kitchen_sort.css("width",kitchen_percent+"%");


       $analysis_drink_sort.text("饮料："+drink_percent+"%");
       $analysis_food_sort.text("食品："+food_percent+"%");
       $analysis_wash_sort.text("洗化："+wash_percent+"%");
       $analysis_kitchen_sort.text("厨具："+kitchen_percent+"%");
   }
});


//男女消费比
    var $analysis_man_sort = $("#analysis_man");
    var $analysis_woman_sort = $("#analysis_woman");


    $.ajax("/findCustomerConsumeBySexServlet",{
        type:"POST",
        dataType:"json",
        success:function (res) {
            var totalPrice = parseFloat(res.data.totalPrice);
            var man = parseFloat(res.data['0']);
            var woman = parseFloat(res.data['1']);

            var man_percent = Math.ceil((man/totalPrice)*1000)/10;
            var woman_percent = Math.ceil((woman/totalPrice)*1000)/10;

            $analysis_man_sort.css("width",man_percent+"%");
            $analysis_woman_sort.css("width",woman_percent+"%");

            $analysis_man_sort.text("男："+man_percent+"%");
            $analysis_woman_sort.text("女："+woman_percent+"%");
        }
    });

//订单列表
var analysis_table_body = $("#analysis_table_body");


$.ajax("/findAllShoppingInfoServlet",{
    type:"POST",
    dataType:"json",
    success:function (res) {
        analysis_table_body.html("");
        $.each(res.data,function (idx,itm) {
            var order_date = new Date(parseInt(itm.date)).toLocaleDateString();
            var order_user = itm.userid===0?"非会员":"会员id:"+itm.userid;

            var $tr = $('<tr>\n' +
                '            <th scope="row">'+(idx+1)+'</th>\n' +
                '            <td>'+itm.order_id+'</td>\n' +
                '            <td>'+itm.goods_name+'</td>\n' +
                '            <td>'+itm.sort+'</td>\n' +
                '            <td>'+itm.count+'</td>\n' +
                '            <td>'+itm.price+'</td>\n' +
                '            <td>'+order_date+'</td>\n' +
                '            <td>'+order_user+'</td>\n' +
                '        </tr>'
            );
            analysis_table_body.append($tr);
        })
    }

});
/************************** 销售统计 end ***************************************************/





/*************************** 菜单 start *****************************************************/
//菜单
var $welcome_main_panel = $("#welcome_main_panel");
var $shopping_main_panel = $("#shopping_main_panel");
var $vip_main_panel = $("#vip_main_panel");
var $analysis_main_panel = $("#analysis_main_panel");



var $panel_arr = [$welcome_main_panel,$shopping_main_panel,$vip_main_panel,$analysis_main_panel];
for(var i=1;i<$panel_arr.length;i++) $panel_arr[i].hide();


var last_panel_idx = 0;
var now_panel_idx = 0;



function control_panel(idx){
    if(idx !== last_panel_idx){
        $panel_arr[last_panel_idx].hide();
        $panel_arr[idx].show();
        last_panel_idx = idx;
    }
}

$("#welcome_menu_btn").click(function (ev) {
    control_panel(0);
});


$("#shopping_menu_btn").click(function (ev) {
    control_panel(1);
});

$("#vip_menu_btn").click(function (ev) {
    control_panel(2);
});

$("#analysis_menu_btn").click(function () {
    control_panel(3)
});
</script>
</body>
</html>
