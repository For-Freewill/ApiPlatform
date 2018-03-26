<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>质量分析</title>
<link href="<%=path%>/css/top.css" rel="stylesheet" />
<script type="text/javascript" src="<%=path%>/js/jquery-3.3.1.min.js"></script>
<script src="<%=path%>/js/echarts.min.js"></script>
<script type="text/javascript">
	var total = 0;
	// 指定图表的配置项和数据

	var option = {
		title : {
			text : '系统质量趋势图（测试用例通过率）',
			left : 'center',
			textStyle : {
				//文字颜色
				color : '#4876FF',
				//字体风格,'normal','italic','oblique'
				fontStyle : 'normal',
				//字体粗细 'normal','bold','bolder','lighter',100 | 200 | 300 | 400...
				fontWeight : 'bold',
				//字体系列
				fontFamily : 'sans-serif',
				//字体大小
				fontSize : 18
			}
		},
		tooltip : {
			trigger : 'axis'
		},
		legend : {
			data : []
		},
		xAxis : {
			type : 'category',
			data : [],
			splitLine : {
				show : false
			},//去除网格线
			//设置轴线的属性
			axisLine : {
				lineStyle : {
					color : '#4876FF',
					width : 1,//这里是为了突出显示加上的
				}
			},

			axisLabel : {
				show : true,
				textStyle : {
					color : '#4876FF'
				},
				interval : 0, //横轴信息全部显示  
				rotate : -60,// 30度角倾斜显示  
			}
		},
		yAxis : {
			type : 'value',
			//去除网格线
			splitLine : {
				show : false
			},
			//保留网格区域
			splitArea : {
				show : true
			},
			//设置轴线的属性
			axisLine : {
				lineStyle : {
					color : '#4876FF',
					width : 1,//这里是为了突出显示加上的
				}
			},
			axisLabel : {
				formatter : '{value}%',
				textStyle : {
					color : '#4876FF'
				}
			}
		},
		series : [ {
			name : '质量趋势',
			type : 'line',
			data : [],
			itemStyle : {
				normal : {
					lineStyle : {
						color : '#4876FF'
					}
				}
			},

			markLine : {
				data : [ {
					type : 'average',
					name : '平均值'
				} ],
				itemStyle : {
					normal : {
						lineStyle : {

							type : 'dashed',
							color : '#4876FF ',
							width : 1,
						},

					}
				}
			}
		} ]
	};

	var myChart;
	$(function() {
		//自适应设置
		var width = $(window).width();
		var height = $(window).height();
		$("#container").css("width", width-100);
		$("#container").css("height", height-100);
		myChart = echarts.init(document.getElementById('container'));
		getReuslt(2,1);
	});
	
	function getReuslt(pageSize,indexClass){
		$(".custom_date li").removeClass("custom_date_active");
		$(".custom_date li:eq(" + indexClass + ")").addClass(
				"custom_date_active");
		$.post("report/result.do",{
			"pageSize":pageSize
		},function(data){
			option.series[0].data = [];
			option.xAxis.data=[];
			data.forEach(function(item, i) {
				var ratio = item.sucess/(item.sucess+item.fail+item.skip);
				option.series[0].data.push(Math.round(ratio*100));
				option.xAxis.data.push((i+1) + "次");
			});
			myChart.setOption(option);
		});
	}
</script>

<style>
* {
	padding: 0;
	margin: 0;
}

body {
	font-family: "Microsoft YaHei";
}

li, ul {
	list-style: none;
}

a {
	text-decoration: none;
}

input {
	vertical-align: middle;
}

.nav {
	width: 230px;
}

.nav_list {
	background: #ebebeb;
	border-top: 1px solid #e2e2e2;
}

.nav_list li a {
	height: 40px;
	line-height: 40px;
	padding-left: 65px;
	display: block;
	color: #666666;
}

.nav_list li a:hover {
	height: 40px;
	line-height: 40px;
	background: #f4f4f4;
}

.nav_title {
	height: 47px;
	background-image: url(images/all_bg.png);
	background-repeat: no-repeat;
	font-size: 16px;
}

.nav_title_default {
	background-position: left -927px;
}

.nav_title a {
	height: 47px;
	line-height: 47px;
	padding-left: 65px;
	font-size: 16px;
	color: #444444;
	display: block;
}

.nav_list .selected a, .nav_list .selected a:hover {
	height: 40px;
	line-height: 40px;
	padding-left: 60px;
	display: block;
	color: #666666;
	border-left: 5px solid #0057ff;
	background: #fff;
	position: absolute;
	width: 173px;
	z-index: 1;
}


.Custom {
	background: url(images/cus_bg.jpg) repeat-x;
	height: 52px;
	border-left: 1px solid #e8e8e8;
	border-right: 1px solid #e8e8e8;
	border-radius: 8px 8px 0 0;
	margin-top: 10px;
	text-align: left;
	margin-left: 0;
	clear: both;
}

.cus {
	height: 52px;
	float: left;
}

.cus li {
	height: 52px;
	float: left;
}

.cus_right_none a {
	width: 89px;
	height: 52px;
	line-height: 52px;
	float: left;
	background-image: url(images/all_bg.png);
	background-position: left -524px;
	color: #434343;
	font-size: 14px;
	text-align: right;
	padding-right: 50px;
}

/* .time-picker-bar { */
/* 	line-height: normal; */
/* 	margin-right: 10px; */
/* 	margin-top: 11px; */
/* 	position: relative; */
/* 	background: #000; */
/* } */
</style>

</head>

<body>
	<div
		style="float: left; padding-left: 25px; padding-right: 30px; width: 95%; padding-top: 25px">
		<div class="kuang02">
			<ul class="custom_date" id="el_3_datetype">
				<li class="custom_date custom_date_active" onClick="getReuslt(30,0)"><a
					href="javascript:void(0);">近30次</a></li>
				<li class="custom_date" onClick="getReuslt(10,1)"><a
					href="javascript:void(0);">近10次</a></li>
			</ul>
			<div class="clear"></div>
			<div id="container"></div>
		</div>
	</div>
</body>
</html>