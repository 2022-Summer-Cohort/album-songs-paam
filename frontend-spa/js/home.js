export default function home(albums) {
    return `
    <main class="main-content">
    <section class="album-library">
    
    <div class="addAlbumDiv">
    <input type="image" src="/frontend-spa/images/add-icon-transp.png" class="addAlbum-button" height="100" width="100">
    <p>ADD ALBUM</p>
    </div>

        ${albums.map(album => {
        return `
            <div class="album">
                <h2 class="album-title">${album.title}</h2>
                <input type="hidden" class="id_field" value="${album.id}">
                <h3 class="album-song">Record Label: ${album.recordLabel}</h3>
                <img src=${album.imgUrl}>
                <p class = "album-rating">Ratings: ${album.ratings}</p>

                <input type="text" class="update-recordLabel" placeholder="New record label">                
                <button class="update-button">Update Record Label</button>
                <input type="image" src="/frontend-spa/images/trashTransp.png" height="28" width="30" class="delete-button" \>
            </div>
            `
    }).join("")
        }
    


    </section>
    </main>
    `

}