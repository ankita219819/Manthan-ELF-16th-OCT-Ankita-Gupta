function run(){ 
    document.querySelector("iframe").value="";
    var text=document.getElementById("textareaid").value;
    document.querySelector("iframe").contentDocument.write(text)

}

