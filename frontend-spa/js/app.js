import home from "./home.js";
import header from "./header.js";
import footer from "./footer.js";
import albumView from "./albumView.js";
const container = document.querySelector(".container");

// function makeHomeView() {
//     fetch("http://localhost:8080/api/albums")
//     .then(res => res.json())
//     .then(albums => {
//         console.log(albums);
        
        
//         container.innerHTML = header();
//         container.innerHTML += home(albums);
//         container.innerHTML += footer();


//         const albumsElement = document.querySelectorAll(".album");

//         albumsElement.forEach(album => {
//             album.addEventListener("click", ()=>{
//                 let albumId = album.querySelector(".id_field");
//                 // alert(`you clicked album id: ${albumId.value}`);
//                 makeAlbumView(albumId.value);
//             })
//         })
//     })
// }


function makeHomeView() {
    fetch("http://localhost:8080/api/albums")
    .then(res => res.json())
    .then(albums => {
        makeHomeViewFromJSON(albums);
    })
}

function makeHomeViewFromJSON(albums) {
    container.innerHTML = header();
    container.innerHTML += home(albums);
    container.innerHTML += footer();

    const albumsEl = container.querySelectorAll(".album");

    albumsEl.forEach(album => {
        let albumElId = album.querySelector(".id_field");
        const albumH2 = album.querySelector(".album-title");
        albumH2.addEventListener("click", ()=> {
            fetch(`http://localhost:8080/api/albums/${albumElId.value}`)
            .then(res => res.json())
            .then(albumsJson => {
                makeAlbumView(albumsJson);
            })    
        })
        
        const deleteButton = album.querySelector(".delete-button");
        deleteButton.addEventListener("click", ()=> {
            fetch(`http://localhost:8080/api/albums/${albumElId.value}`, {
                method: 'DELETE'
            })
            .then(res => res.json())
            .then(newAlbums => {
                makeHomeViewFromJSON(newAlbums);
            })
        });

        const updateButton = album.querySelector(".update-button");
        updateButton.addEventListener("click", ()=> {
            const updateInput = album.querySelector(".update-recordLabel");
            fetch(`http://localhost:8080/api/albums/${albumElId.value}`, {
                method: 'PATCH',
                body: updateInput.value
            })
            .then(res => res.json())
            .then(newAlbums =>{
                makeHomeViewFromJSON(newAlbums);
            })

        })
    });
}


function makeAlbumView(album) {
        console.log(album);
        container.innerHTML = header();
        container.innerHTML += albumView(album);
        container.innerHTML += footer();

        const songElement = document.querySelectorAll(".song");
        console.log(songElement)

        songElement.forEach(song=>{
            let songElId = song.querySelector(".id_field");

            const editButton = song.querySelector(".edit-button");
            editButton.addEventListener("click", ()=> {
                const updateInput = song.querySelector(".update-songName");
                fetch(`http://localhost:8080/api/songs/${songElId.value}/editSong`, {
                    method: 'PATCH',
                    body: updateInput.value
                })
                .then(res => res.json())
                .then(album => {
                    makeAlbumView(album);
                })
    
            })

            
            const deleteSongButton = song.querySelector(".delete-button");
            deleteSongButton.addEventListener("click", ()=> {
                fetch(`http://localhost:8080/api/songs/${songElId.value}/deleteSong`, {
                    method: 'DELETE'
                })
                .then(res => res.json())
                .then(album => {
                    makeAlbumView(album);
                })
            });
        }) 

        const backButton = document.querySelector(".back-navigation");
        backButton.addEventListener("click",()=>{
            makeHomeView();
        })

        const songNameIn = container.querySelector(".songNameInput");
        const songSumIn = container.querySelector(".songDescriptionInput");
        const addSongButton = container.querySelector(".addSongButton");

        addSongButton.addEventListener("click",()=>{
            // let albumElId = container.querySelector(".id-field");
            // const album = container.querySelector();
            const newSongJson = {
                "title": songNameIn.value,
                "summary": songSumIn.value,
            }
            fetch(`http://localhost:8080/api/albums/${album.id}/addSong`,{
                method: 'POST',
                headers: {
                    'Content-type': 'application/json'
                },
                body: JSON.stringify(newSongJson)
            })
            .then(res => res.json())
            .then(album => {
                makeAlbumView(album);
            })
        })

}

makeHomeView();