<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Registration</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="https://bootstrap-themes.github.io/dashboard/assets/css/toolkit-inverse.css">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <![endif]-->
</head>
<body>
<br><br><br><br>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>

<div class="bw">
    <div class="di">
        <div class="em brh">
            <nav class="bro">
                <div class="bri">
                    <button class="bqe bqg brj" type="button" data-toggle="collapse" data-target="#nav-toggleable-md">
                        <span class="aep">Toggle nav</span>
                    </button>
                    <a class="brk bsi" href="index.html">
                        <span class="bv bik brl"></span>
                    </a>
                </div>

                <div class="collapse bql" id="nav-toggleable-md">
                    <form class="brm">
                        <input class="form-control" type="text" placeholder="Search...">
                        <button type="submit" class="po">
                            <span class="bv bje"></span>
                        </button>
                    </form>
                    <ul class="nav qq nav-stacked xx">
                        <li class="ayx">Dashboards</li>
                        <li class="qp">
                            <a class="qn active" href="index.html">Overview</a>
                        </li>
                        <li class="qp">
                            <a class="qn " href="order-history/index.html">Order history</a>
                        </li>
                        <li class="qp">
                            <a class="qn " href="fluid/index.html">Fluid layout</a>
                        </li>
                        <li class="qp">
                            <a class="qn " href="icon-nav/index.html">Icon nav</a>
                        </li>

                        <li class="ayx">More</li>
                        <li class="qp">
                            <a class="qn " href="docs/index.html">
                                Toolkit docs
                            </a>
                        </li>
                        <li class="qp">
                            <a class="qn" href="http://getbootstrap.com" target="blank">
                                Bootstrap docs
                            </a>
                        </li>
                        <li class="qp">
                            <a class="qn " href="index-light/index.html">Light UI</a>
                        </li>
                        <li class="qp">
                            <a class="qn" href="#docsModal" data-toggle="modal">
                                Example modal
                            </a>
                        </li>
                    </ul>
                    <hr class="bsj afx">
                </div>
            </nav>
        </div>
        <div class="es bsk">
            <div class="brv">
                <div class="brw">
                    <h6 class="bry">Dashboards</h6>
                    <h2 class="brx">Overview</h2>
                </div>
                <div>
                    <button type="button" class="btn btn-default btn-lg">
                        <span class="glyphicon glyphicon-star" aria-hidden="true"></span> Star
                    </button>
                </div>
                <div class="qb brz">
                    <div class="ayt brg">

                        <input type="text" value="01/01/15 - 01/08/15" class="form-control" data-provide="datepicker">
                        <span class="bv bck"></span>
                    </div>
                </div>
            </div>

            <hr class="afx">

            <div class="di awt agl">
                <div class="en agg amz">
                    <div class="azy aim"><iframe class="chartjs-hidden-iframe" tabindex="-1" style="display: block; overflow: hidden; border: 0px; margin: 0px; top: 0px; left: 0px; bottom: 0px; right: 0px; height: 100%; width: 100%; position: absolute; pointer-events: none; z-index: -1;"></iframe>
                        <canvas class="bra js-chart-drawn" width="142" height="142" data-chart="doughnut" data-dataset="[230, 130]" data-dataset-options="{ borderColor: '#252830', backgroundColor: ['#1ca8dd', '#1bc98e'] }" data-labels="['Returning', 'New']" style="display: block; width: 142px; height: 142px;">
                        </canvas>
                    </div>
                    <strong class="axn">Traffic</strong>
                    <h4>New vs Returning</h4>
                </div>
                <div class="en agg amz">
                    <div class="azy aim"><iframe class="chartjs-hidden-iframe" tabindex="-1" style="display: block; overflow: hidden; border: 0px; margin: 0px; top: 0px; left: 0px; bottom: 0px; right: 0px; height: 100%; width: 100%; position: absolute; pointer-events: none; z-index: -1;"></iframe>
                        <canvas class="bra js-chart-drawn" width="142" height="142" data-chart="doughnut" data-dataset="[330,30]" data-dataset-options="{ borderColor: '#252830', backgroundColor: ['#1ca8dd', '#1bc98e'] }" data-labels="['Returning', 'New']" style="display: block; width: 142px; height: 142px;">
                        </canvas>
                    </div>
                    <strong class="axn">Revenue</strong>
                    <h4>New vs Recurring</h4>
                </div>
                <div class="en agg amz">
                    <div class="azy aim"><iframe class="chartjs-hidden-iframe" tabindex="-1" style="display: block; overflow: hidden; border: 0px; margin: 0px; top: 0px; left: 0px; bottom: 0px; right: 0px; height: 100%; width: 100%; position: absolute; pointer-events: none; z-index: -1;"></iframe>
                        <canvas class="bra js-chart-drawn" width="142" height="142" data-chart="doughnut" data-dataset="[100,260]" data-dataset-options="{ borderColor: '#252830', backgroundColor: ['#1ca8dd', '#1bc98e'] }" data-labels="['Referrals', 'Direct']" style="display: block; width: 142px; height: 142px;">
                        </canvas>
                    </div>
                    <strong class="axn">Traffic</strong>
                    <h4>Direct vs Referrals</h4>
                </div>
            </div>

            <div class="brc agl afz">
                <h3 class="brd bre">Quick stats</h3>
            </div>

            <hr class="agl">

            <div class="di">
                <div class="ep agn">
                    <div class="by afz">
                        <h6 class="azi">
                            Countries
                        </h6>

                        <a class="rp tr yg" href="#">
                            <span class="azj" style="width: 62.4%;"></span>
                            United States
                            <span class="bso axn">62.4%</span>
                        </a>

                        <a class="rp tr yg" href="#">
                            <span class="azj" style="width: 15.0%;"></span>
                            India
                            <span class="bso axn">15.0%</span>
                        </a>

                        <a class="rp tr yg" href="#">
                            <span class="azj" style="width: 5.0%;"></span>
                            United Kingdom
                            <span class="bso axn">5.0%</span>
                        </a>

                        <a class="rp tr yg" href="#">
                            <span class="azj" style="width: 5.0%;"></span>
                            Canada
                            <span class="bso axn">5.0%</span>
                        </a>

                        <a class="rp tr yg" href="#">
                            <span class="azj" style="width: 4.5%;"></span>
                            Russia
                            <span class="bso axn">4.5%</span>
                        </a>

                        <a class="rp tr yg" href="#">
                            <span class="azj" style="width: 2.3%;"></span>
                            Mexico
                            <span class="bso axn">2.3%</span>
                        </a>

                        <a class="rp tr yg" href="#">
                            <span class="azj" style="width: 1.7%;"></span>
                            Spain
                            <span class="bso axn">1.7%</span>
                        </a>

                        <a class="rp tr yg" href="#">
                            <span class="azj" style="width: 1.5%;"></span>
                            France
                            <span class="bso axn">1.5%</span>
                        </a>

                        <a class="rp tr yg" href="#">
                            <span class="azj" style="width: 1.4%;"></span>
                            South Africa
                            <span class="bso axn">1.4%</span>
                        </a>

                        <a class="rp tr yg" href="#">
                            <span class="azj" style="width: 1.2%;"></span>
                            Japan
                            <span class="bso axn">1.2%</span>
                        </a>

                    </div>
                    <a href="#" class="ce pi ahr">All countries</a>
                </div>
                <div class="ep agn">
                    <div class="by afz">
                        <h6 class="azi">
                            Most visited pages
                        </h6>

                        <a class="rp tr yg" href="#">
                            <span>/ (Logged out)</span>
                            <span class="bsp axn">3,929,481</span>
                        </a>

                        <a class="rp tr yg" href="#">
                            <span>/ (Logged in)</span>
                            <span class="bsp axn">1,143,393</span>
                        </a>

                        <a class="rp tr yg" href="#">
                            <span>/tour</span>
                            <span class="bsp axn">938,287</span>
                        </a>

                        <a class="rp tr yg" href="#">
                            <span>/features/something</span>
                            <span class="bsp axn">749,393</span>
                        </a>

                        <a class="rp tr yg" href="#">
                            <span>/features/another-thing</span>
                            <span class="bsp axn">695,912</span>
                        </a>

                        <a class="rp tr yg" href="#">
                            <span>/users/username</span>
                            <span class="bsp axn">501,938</span>
                        </a>

                        <a class="rp tr yg" href="#">
                            <span>/page-title</span>
                            <span class="bsp axn">392,842</span>
                        </a>

                        <a class="rp tr yg" href="#">
                            <span>/some/page-slug</span>
                            <span class="bsp axn">298,183</span>
                        </a>

                        <a class="rp tr yg" href="#">
                            <span>/another/directory/and/page-title</span>
                            <span class="bsp axn">193,129</span>
                        </a>

                        <a class="rp tr yg" href="#">
                            <span>/one-more/page/directory/file-name</span>
                            <span class="bsp axn">93,382</span>
                        </a>

                    </div>
                    <a href="#" class="ce pi ahr">View all pages</a>
                </div>
            </div>

            <div class="by afz">
                <h6 class="azi">
                    Devices and resolutions
                </h6>

                <a class="rp tr yg" href="#">
                    <span>Desktop (1920x1080)</span>
                    <span class="axn">3,929,481</span>
                </a>

                <a class="rp tr yg" href="#">
                    <span>Desktop (1366x768)</span>
                    <span class="axn">1,143,393</span>
                </a>

                <a class="rp tr yg" href="#">
                    <span>Desktop (1440x900)</span>
                    <span class="axn">938,287</span>
                </a>

                <a class="rp tr yg" href="#">
                    <span>Desktop (1280x800)</span>
                    <span class="axn">749,393</span>
                </a>

                <a class="rp tr yg" href="#">
                    <span>Tablet (1024x768)</span>
                    <span class="axn">695,912</span>
                </a>

                <a class="rp tr yg" href="#">
                    <span>Tablet (768x1024)</span>
                    <span class="axn">501,938</span>
                </a>

                <a class="rp tr yg" href="#">
                    <span>Phone (320x480)</span>
                    <span class="axn">392,842</span>
                </a>

                <a class="rp tr yg" href="#">
                    <span>Phone (720x450)</span>
                    <span class="axn">298,183</span>
                </a>

                <a class="rp tr yg" href="#">
                    <span>Desktop (2560x1080)</span>
                    <span class="axn">193,129</span>
                </a>

                <a class="rp tr yg" href="#">
                    <span>Desktop (2560x1600)</span>
                    <span class="axn">93,382</span>
                </a>

            </div>
            <a href="#" class="ce pi ahr">View all devices</a>

        </div>
    </div>
</div>

<div id="docsModal" class="cb fade" tabindex="-1" role="dialog" aria-labelledby="bsq">
    <div class="modal-dialog">
        <div class="modal-content">

            <div class="uf">
                <h4 class="modal-title" id="myModalLabel">Example modal</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">?</span></button>
            </div>
            <div class="modal-body">
                <p>You're looking at an example modal in the dashboard theme.</p>
            </div>
            <div class="ug">
                <button type="button" class="ce pb" data-dismiss="modal">Cool, got it!</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>