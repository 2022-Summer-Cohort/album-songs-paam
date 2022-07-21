import home from "./home.js";
import header from "./header.js";
import footer from "./footer.js";
import albumView from "../albumView.js";

const container = document.querySelector(".container");

function makeHomeView() {
    fetch("http://localhost:8080/api/albums")
    .then(res => res.json())
    .then(albums => {
        console.log(albums);
        
        
        container.innerHTML = header();
        container.innerHTML += home(albums);
        container.innerHTML += footer();


        const albumsElement = document.querySelectorAll(".album");

        albumsElement.forEach(album => {
            album.addEventListener("click", ()=>{
                let albumId = album.querySelector(".id_field");
                // alert(`you clicked album id: ${albumId.value}`);
                makeAlbumView(albumId.value);
            })
        })
    })
}

function makeAlbumView(albumId) {
    fetch(`http://localhost:8080/api/albums/${albumId}`)
    .then(res => res.json())
    .then(album => {
        console.log(album);
        container.innerHTML = header();
        container.innerHTML += albumView(album);
        container.innerHTML += footer();

        const songElement = document.querySelectorAll(".song");

        songElement.forEach(song=>{
            song.addEventListener("click", ()=>{
                let songSum = song.querySelector(".sum_field");
                alert(songSum.value);
            });
        }) 

        const backButton = document.querySelector(".back-navigation");
        backButton.addEventListener("click",()=>{
            makeHomeView();
        });

    
    
        const songNameIn = container.querySelector(".songNameInput");
        const songSumIn = container.querySelector(".songDescriptionInput");
        const addSongButton = container.querySelector(".addSongButton");

        addSongButton.addEventListener("click",()=>{
            const newSongJson = {
                "title": songNameIn.value,
                "summary": songSumIn.value,

            }
            fetch(`http://localhost:8080/api/albums/${albumId}/addSong`, {
                method: 'POST',
                headers: {
                    'Content-type': 'application/ json'
                },
                body: JSON.stringify(newSongJson)
            })
            .then(res => res.json())
            .then(album => {
                makeAlbumView(album.id);
            })
        })
           
    })

}

makeHomeView();