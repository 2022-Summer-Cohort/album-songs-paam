import home from "./home.js";
import header from "./header.js";
import footer from "./footer.js";

fetch("http://localhost:8080/api/albums")
.then(res => res.json())
.then(albums => {
    console.log(albums);
    const container = document.querySelector(".container");
    container.innerHTML += header();
    container.innerHTML += home(albums);
    container.innerHTML += footer();


    const albumsElement = document.querySelectorAll(".album");

    albumsElement.forEach(album => {
        album.addEventListener("click", ()=>{
            let albumId = album.querySelector(".id_field");
            alert(`you clicked album id: ${albumId.value}`);
        })
    })
})