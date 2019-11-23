function getdata(){

    mov=document.getElementById("search").value;
    console.log(mov)
    tsr=""
    //everytime we search a movie it will be appended to the url
    fetch("http://www.omdbapi.com/?s="+mov+"&apikey=d6f86dbc")
    .then(response => response.json())
    .then(json =>{

        per=json
        //to fetch the search from the url which will output the number of result found 
        //ex: I searched for "pink" movie, search:10 (there were 10 results found with this movie name)
        console.log(per.Search )
        for(x in per.Search){
            console.log(per.Search[x].Title);
            //search[0], search[1]....search[9] will be have attrinutes as poster(with img url), title(with movie title)
            //year(with year the movie came in)
            tsr=tsr+"<img src='"+per.Search[x].Poster+"' class='card-img-top' alt='img'>"+
            "<div class='card-body'>"+
            "<h5 class='card-title'>"+per.Search[x].Title+"</h5>"+
            "<h5 class='card-title'>"+per.Search[x].Year+", "+per.Search[x].imdbID+"</h5>"+
            "<a href='#' class='btn btn-primary'>Watch</a></div><hr> <hr> <hr> <hr>"
            document.getElementById("carddiv").innerHTML=tsr
        }
        //document.getElementById("carddiv").innerHTML=tsr
    })
    .catch(err=>console.log(err))

}