<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <title>Document</title>
</head>
<body>
    <div>
        <p style="display: inline-block;margin-right: 5px">지폐금액</p><input style="display: inline-block" type="text" id="t" name="t" onchange="addComma(this)"><br>
        <p style="display: inline-block">동전의 가지 수</p> <button style="display: inline-block" onclick="addRow()">+</button><button style="display: inline-block" onclick="deleteRow(-1)">-</button>
    </div>

    <div>
        <table id="coinListTable">
            <tr>
                <td style="min-width: 200px">동전금액</td>
                <td>개수</td>
            </tr>
        </table>
    </div>

    <button onclick="getCalcResult()">계산</button><br>
    <input type="text" id="result" style="border: 0" readonly>
</body>
</html>

<script>
    function addComma(obj){
        obj.value = obj.value.toString().replace(/[^0-9.]/g, '').replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ',');
    }
    function addRow(){
        const table = document.getElementById("coinListTable");
        const newRow = table.insertRow();

        const newCell1 = newRow.insertCell(0);
        const newCell2 = newRow.insertCell(1);

        newCell1.innerHTML = "<input type='text' id='Pi' name='pi'>";
        newCell2.innerHTML = "<input type='text' id='Ni' name='Ni'>";
    }

    function deleteRow(rowNum){
        const table = document.getElementById("coinListTable");

        if (table.rows.length > 1){
            table.deleteRow(rowNum);
        }
    }
    function getCalcResult(){
        const table = document.getElementById("coinListTable").getElementsByTagName("tr");
        let piList = new Array();
        let niList = new Array();

        for(let i = 1; i <= table.length-1; i++){
            let cell = table[i].getElementsByTagName("td");

            piList.push(cell[0].firstChild.value);
            niList.push(cell[1].firstChild.value);
        }
        let xmlHttpRequest = new XMLHttpRequest();
        let t = document.getElementById("t").value.replace(",", "");

        let data = {
            "t": parseInt(t),
            "k": table.length-1,
            "piList": piList,
            "niList": niList
        }

        xmlHttpRequest.open("POST", "/main", true);
        xmlHttpRequest.setRequestHeader("Content-type", "application/json");

        xmlHttpRequest.send(JSON.stringify(data));

        xmlHttpRequest.onload = function (){
            if(xmlHttpRequest.status == 200 || xmlHttpRequest.status == 201){
                document.getElementById("result").value = xmlHttpRequest.response;

            }else{
                alert(xmlHttpRequest.response);
            }
        }
    }
</script>