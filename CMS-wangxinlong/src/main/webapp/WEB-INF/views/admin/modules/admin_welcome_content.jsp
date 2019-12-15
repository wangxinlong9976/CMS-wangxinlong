<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<div class="row">
	<div class="clear"></div>
	<div class="col-12">
		<marquee>[系统消息]:xxxxxxxxxxxxxxxxxxxxxx</marquee>
		<p class="alert alert-primary text-center" style="margin-top: 20px;">欢迎  <span class="text-danger">${adminSession.username}</span>  进入CMS管理系统</p>
	</div>
</div>
<div class="row">
   <div class="col-6">
      <div class="card">
         <div class="card-body">
            <canvas id="myChart" height="200px">
            
            </canvas>
         </div>
      </div>
   </div>
   <div class="col-3">
      	<div class="card">
	         <div class="card-body">
		    	  <div class="content_card" >
		               <div class="row">
		               		<div class="col-12 txt-center">
		               			<label>Logo</label>
		               		</div>
		            		
		               </div>
		               <div class="row">
		              		 <div class="col-12 txt-center">
		               			网站访问量:
		            			<span class="text-red" id="visitor">${persons}</span>
		               		</div>	
		               </div>
	              </div>
	         </div>
      </div>
   </div>
   <div class="col-3" >
      	<div class="card" >
	         <div class="card-body" >
		          <div class="content_card">
		            	<div class="row">
		               		<div class="col-12 txt-center">
		               			<label>Logo</label>
		               		</div>
		            		
		               </div>
		               <div class="row">
		              		 <div class="col-12 txt-center">
		               			当前在线人数:
		            			<span class="text-red" id="visitor">${persons}</span>
		               		</div>	
		               </div>
		          </div>
	         </div>
      </div>
      
   </div>
    
</div>
<script type="text/javascript">
/* var lineChartData_cashback_total = {
        labels : ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月'],
        datasets : [
            {
                fillColor : "rgba(220,220,220,0.5)",
                strokeColor : "rgba(220,220,220,1)",
                pointColor : "rgba(220,220,220,1)",
                pointStrokeColor : "#0f0",
                data : [50,60,70,80,90,100,100,120,90,100,100,120]
            }
        ]
        
    };
var cashback = new Chart(document.getElementById("myChart").getContext("2d")).Line(lineChartData_cashback_total); */
var ctx = document.getElementById('myChart').getContext('2d');
var title = new Array('红', '蓝', '黄', '绿', '紫', '橙');
var data = new Array(12, 19, 3, 5, 2, 3);
var data = new Array(12, 19, 3, 5, 2, 4);
var myChart = new Chart(ctx, {
    type: 'line',
    data: {
        labels: title,
        datasets: [{
            label: '示例',
            data: data,
            borderColor:'red',
            borderWidth: 0.3,
            fill: false,
        }]
    },
    options: {
        tooltips: {
            intersect: false,
            mode: 'index'
        }
    }
});

</script>
</div>
