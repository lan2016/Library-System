function showRow(row)
{
var x=row.cells;
document.getElementById("fa").value=x[0].innerHTML;
document.getElementById("fb").value=x[1].innerHTML;
document.getElementById("fc").value=x[2].innerHTML;
document.getElementById("fa").style. backgroundColor="wheat";
	document.getElementById("fb").style.backgroundColor = "wheat";
	document.getElementById("fc").style.backgroundColor = "wheat";

}