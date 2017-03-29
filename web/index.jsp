<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <link rel="stylesheet"  href="https://kendo.cdn.telerik.com/2017.1.223/styles/kendo.common-material.min.css" />
    <link rel="stylesheet" href="https://kendo.cdn.telerik.com/2017.1.223/styles/kendo.material.min.css" />
    <link rel="stylesheet" href="https://kendo.cdn.telerik.com/2017.1.223/styles/kendo.material.mobile.min.css" />

    <script type="text/javascript" src="https://kendo.cdn.telerik.com/2017.1.223/js/jquery.min.js"></script>
    <script type="text/javascript" src="https://kendo.cdn.telerik.com/2017.1.223/js/kendo.all.min.js"></script>
  </head>
  <body>
    <div id="testGrid"></div>
    <div class="container">
        <input id="Uid" type="text"/>
        <input id="Uname" type="text"/>
        <input type="button" id="addDrug" class="button" value="Add"/>
        <input type="button" id="delDrug" class="button" value="Add"/>
    </div>
    <script type="text/javascript">
        $(document).ready(function () {
            function refresh () {
                $('#testGrid').data('kendoGrid').dataSource.read();
                $('#testGrid').data('kendoGrid').refresh();
            }
            $("#addDrug").click(function(){
                    var request = $.ajax({
                        type: "POST",
                        url: "/DrugServlet",
                        data: JSON.stringify({
                            "drugsid":$("#Uid").val(),
                            "name":$("#Uname").val()
                        }),
                        dataType: "application/json"
                    });

                    setTimeout(refresh,1200);
                });
            $("#delDrug").click(function(){
                debugger;
                var grid = $("#testGrid").data("kendoGrid");
                var id = grid.dataItem(grid.select()).drugsid;
                var request = $.ajax({
                    type: "DELETE",
                    url: "/DrugServlet/id="+id,
                    dataType: "application/json"
                });

                setTimeout(refresh,1200);
            });


            $("#testGrid").kendoGrid({
                dataSource: {
                    type: "json",
                    transport: {
                        read: "/DrugServlet?action=getAll",
                        dataType: "json"
                    },
                    schema: {
                        type: 'json',
                        model: {
                            fields: {
                                drugsid: { type: "string" },
                                name: { type: "string" },
                                barcode: { type: "string" }
                            }
                        }
                    },
                    pageSize: 10
                },
                height: 550,
                sortable: true,
                columns: [{
                    field: "drugsid",
                    title: "id"
                }, {
                    field: "name",
                    title: "name"
                },{
                    field: "barcode",
                    title: "barcode"
                }

                ]
            });
        });
    </script>
  </body>
</html>
